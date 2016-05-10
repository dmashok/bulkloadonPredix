package com.get.predix.predikto;

	import java.util.logging.Logger;

import javax.sql.DataSource;

	import org.springframework.batch.core.Job;
	import org.springframework.batch.core.JobExecutionListener;
	import org.springframework.batch.core.Step;
	import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
	import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
	import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
	import org.springframework.batch.core.launch.support.RunIdIncrementer;
	import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
	import org.springframework.batch.item.database.JdbcBatchItemWriter;
	import org.springframework.batch.item.file.FlatFileItemReader;
	import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
	import org.springframework.batch.item.file.mapping.DefaultLineMapper;
	import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.core.io.ClassPathResource;
	import org.springframework.jdbc.core.JdbcTemplate;

import com.get.predix.predikto.entity.DataSet;

import ch.qos.logback.classic.Level;

	@Configuration
	@EnableBatchProcessing
	public class BatchConfiguration {

	    @Autowired
	    public JobBuilderFactory jobBuilderFactory;

	    @Autowired
	    public StepBuilderFactory stepBuilderFactory;

	    @Autowired
	    public DataSource dataSource;

	    // tag::readerwriterprocessor[]
	    @Bean
	    public FlatFileItemReader<DataSet> reader() {
	        FlatFileItemReader<DataSet> reader = new FlatFileItemReader<DataSet>();
	        reader.setResource(new ClassPathResource("Predikto_Dataset_1.csv"));
	        reader.setLineMapper(new DefaultLineMapper<DataSet>() {{
	            setLineTokenizer(new DelimitedLineTokenizer() {{
	                setNames(new String[] { "train_date","site_id","direction","car_id","axle_no","car_side","avg_vert",
	                		"max_vert","dyn_vert","dyn_ratio","avg_lat","max_lat","Wheel_ID","car_wgt_calc","pct_load","train_speed" });
	            }});
	            setFieldSetMapper(new BeanWrapperFieldSetMapper<DataSet>() {{
	                setTargetType(DataSet.class);
	            }});
	        }});
	        return reader;
	    }

	    @Bean
	    public DataSetItemProcessor processor() {
	        return new DataSetItemProcessor();
	    }

	    @Bean
	    public JdbcBatchItemWriter<DataSet> writer() {
	        JdbcBatchItemWriter<DataSet> writer = new JdbcBatchItemWriter<DataSet>();
	        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<DataSet>());
	        String sql = "insert into dataset ("
	        		+   "train_date,site_id,direction,car_id,axle_no,car_side,avg_vert,max_vert,dyn_vert,dyn_ratio,avg_lat,max_lat,Wheel_ID,car_wgt_calc,pct_load,train_speed) "
	        		+           "values "
	        		+ "(:train_date,:site_id,:direction,:car_id,:axle_no,:car_side,:avg_vert,:max_vert,:dyn_vert,:dyn_ratio,:avg_lat,:max_lat,:wheel_id,:car_wgt_calc,:pct_load,:train_speed)";
	        
	        writer.setSql(sql);
	        
	        writer.setDataSource(dataSource);
	        return writer;
	    }
	    // end::readerwriterprocessor[]

	    // tag::listener[]

	    @Bean
	    public JobExecutionListener listener() {
	        return new JobCompletionNotificationListener(new JdbcTemplate(dataSource));
	    }

	    // end::listener[]

	    // tag::jobstep[]
	    @Bean
	    public Job importDataJob() {
	        return jobBuilderFactory.get("importDataJob").preventRestart()
	                .incrementer(new RunIdIncrementer())
	                .listener(listener())
	                .flow(step1())
	                .end()
	                .build();
	    }

	    @Bean
	    public Step step1() {
	        return stepBuilderFactory.get("step1")
	                .<DataSet, DataSet> chunk(10)
	                .reader(reader())
	                .processor(processor())
	                .writer(writer())
	                .build();
	    }
	    // end::jobstep[]
}

