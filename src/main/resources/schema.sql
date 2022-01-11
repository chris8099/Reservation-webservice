
CREATE TABLE if not exists account_table (
  id SERIAL PRIMARY KEY,
  `user_id` varchar(100) NOT NULL,
  `user_pwd` varchar(100) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `user_email` varchar(100) DEFAULT NULL,
  );

CREATE TABLE if not exists  reservation_table (
  id SERIAL PRIMARY KEY,
  user_id varchar(100) DEFAULT NULL,
  Start_date timestamp NULL DEFAULT NULL,
  end_date timestamp NULL DEFAULT NULL,
  content varchar(100) DEFAULT NULL
) ;