DROP TABLE IF EXISTS dataset;

CREATE TABLE dataset (
	id SERIAL PRIMARY KEY,
	-- id INTEGER IDENTITY PRIMARY KEY,
   train_date timestamp with time zone,
   site_id integer DEFAULT 0,
   direction char(1),
   car_id varchar(250),
   axle_no integer DEFAULT 0,
   car_side char(1),
   avg_vert numeric(5,2) DEFAULT 0,
   max_vert numeric(5,2) DEFAULT 0,
   dyn_vert numeric(5,2) DEFAULT 0,
   dyn_ratio numeric(5,2) DEFAULT 0,
   avg_lat numeric(5,2) DEFAULT 0,
   max_lat numeric(5,2) DEFAULT 0,
   wheel_id varchar(250),
   car_wgt_calc numeric(6,2) DEFAULT 0,
   pct_load numeric(3,2) DEFAULT 0,
   train_speed integer
  );
  
 -- ALTER TABLE dataset ADD COLUMN id BIGSERIAL PRIMARY KEY;



