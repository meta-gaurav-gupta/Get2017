CREATE DATABASE city_codes;

USE city_codes;

CREATE TABLE IF NOT EXISTS states(
    state_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    state_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS cities(
    zip_code VARCHAR(8) NOT NULL PRIMARY KEY,
    city_name VARCHAR(30) NOT NULL,
    state_id INT(11) NOT NULL,
    FOREIGN KEY (state_id) REFERENCES states(state_id)
);

INSERT INTO `states` (`state_name`) VALUES ('RAJASTHAN'), 
										   ('BIHAR'), 
										   ('MAHARASTRA'),
										   ('PUNJAB'), 
										   ('GUJRAT');

INSERT INTO `cities` (`zip_code`, `city_name`, `state_id`) VALUES ('301001', 'ALWAR', '1'), 
																  ('313001', 'UDAIPUR', '1'), 
																  ('800002', 'PATNA', '2'), 
																  ('824102', 'CHATRA', '2'), 
																  ('400001', 'MUMBAI', '3'), 
																  ('411021', 'PUNE', '3'), 
																  ('141003', 'ABDULLAPUR BASTI', '4'), 
																  ('144417', 'AUR', '4'), 
																  ('364210', 'AMARGADH', '5'), 
																  ('364215', 'AMBALA', '5');

/* 1. */

SELECT Z.zip_code "ZIP Code", Z.city_name AS "City", S.state_name AS "State"
FROM cities AS Z
INNER JOIN states AS S ON Z.state_id = S.state_id
ORDER BY S.state_name,Z.city_name;
