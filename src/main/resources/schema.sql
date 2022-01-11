
CREATE TABLE if not exists account_table (
  id SERIAL PRIMARY KEY,
  user_id text NOT NULL,
  user_pwd text DEFAULT NULL,
  user_name text DEFAULT NULL,
  user_email text DEFAULT NULL
  );

CREATE TABLE if not exists  reservation_table (
  id SERIAL PRIMARY KEY,
  user_id text DEFAULT NULL,
  Start_date timestamp NULL DEFAULT NULL,
  end_date timestamp NULL DEFAULT NULL,
  content text DEFAULT NULL
) ;