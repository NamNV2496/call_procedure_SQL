DROP TABLE IF EXISTS user;

CREATE TABLE user (id int(10) NOT NULL AUTO_INCREMENT,
                  age int(10) NOT NULL,
                  name varchar (50) NOT NULL,
                  place varchar (255) NOT NULL,
                  PRIMARY KEY (id));

INSERT INTO user (age, name, place) VALUES (23, 'BMW', "germany");
INSERT INTO user (age, name, place) VALUES (23, 'BENZ', "England");
INSERT INTO user (age, name, place) VALUES (23, 'PORCHE', "germany");
INSERT INTO user (age, name, place) VALUES (23, 'MEC', "germany");

DELIMITER $$

DROP PROCEDURE IF EXISTS FIND_CARS_AFTER_YEAR$$
CREATE PROCEDURE FIND_USER_AFTER_YEAR(IN year_in INT)
BEGIN
SELECT * FROM user WHERE name >= year_in ORDER BY name;
END$$

DROP PROCEDURE IF EXISTS GET_TOTAL_USER_BY_AGE
CREATE PROCEDURE GET_TOTAL_USER_BY_AGE(IN age_in int(10), OUT count_out INT)
BEGIN
SELECT COUNT(*) into count_out from user WHERE age = age_in;
END$$

DELIMITER ;
