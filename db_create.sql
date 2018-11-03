use car_rent;

DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS brand;
DROP TABLE IF EXISTS classes;
DROP TABLE IF EXISTS cars;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS bill;

CREATE TABLE roles (
  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY, 
  role_name VARCHAR(20)
);

CREATE TABLE users(
	  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	  user_login VARCHAR(21) NOT NULL,
	  password VARCHAR(15) NOT NULL,
	  first_name VARCHAR(20) NOT NULL,
	  last_name VARCHAR(25) NOT NULL,
	  third_name VARCHAR(25),
	  pass_seria VARCHAR(10) unique,
	  data_pass VARCHAR(30),
	  id_role INT NOT NULL REFERENCES roles(id)

-- removing a row with some ID from roles table implies removing 
-- all rows from users table for which ROLES_ID=ID
-- default value is ON DELETE RESTRICT, it means you cannot remove
-- row with some ID from the roles table if there are rows in 
-- users table with ROLES_ID=ID
		ON DELETE CASCADE 

-- the same as previous but updating is used insted deleting
		ON UPDATE RESTRICT
);

CREATE TABLE brand(
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	name VARCHAR(20) NOT NULL
);

CREATE TABLE classes(
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	name VARCHAR(20) NOT NULL,
	coeff INT NOT NULL
);

CREATE TABLE cars(
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	name VARCHAR(30)  NOT NULL,
	price INT NOT NULL,
	gov_number VARCHAR(8) NOT NULL unique,
	status enum('RENT','CRASH','STOCK'),
	id_brand INT NOT NULL REFERENCES brand(id),
	id_class INT NOT NULL REFERENCES classes(id)
);

CREATE TABLE bill(
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	status boolean NOT NULL, 
	type VARCHAR(20) NOT NULL,
	summa INT NOT NULL,
	data TIMESTAMP,
    id_order  INT NOT NULL REFERENCES orders(id) ON UPDATE CASCADE
);
CREATE TABLE orders(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	driver BOOLEAN NOT NULL,
    status enum('NEW', 'CLOSED', 'IN_PROGRESS'),
	start_rent TIMESTAMP NOT NULL,
	end_rent TIMESTAMP NOT NULL,
    id_user INT NOT NULL REFERENCES users(id),
	id_car  INT NOT NULL REFERENCES cars(id)
);
