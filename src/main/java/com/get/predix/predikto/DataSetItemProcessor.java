package com.get.predix.predikto;

 	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	import org.springframework.batch.item.ItemProcessor;

import com.get.predix.predikto.entity.DataSet;

	public class DataSetItemProcessor implements ItemProcessor<DataSet, DataSet> {

	    private static final Logger log = LoggerFactory.getLogger(DataSetItemProcessor.class);

	    @Override
	    public DataSet process(final DataSet DataSet) throws Exception {
	        //log.info("Converting (" + DataSet + ") into (" + transformedDataSet + ")");

	        return DataSet;
	    }

	}