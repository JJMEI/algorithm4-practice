DROP TABLE IF EXISTS spitter;
DROP TABLE IF EXISTS spittle;

CREATE TABLE spitter
(
  id INTEGER NOT NULL AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL UNIQUE ,
  password VARCHAR(100) NOT NULL,
  fullname VARCHAR(100) NOT NULL ,
  email VARCHAR(100) NOT NULL ,
  update_by_email BOOLEAN NOT NULL,
  PRIMARY KEY(id)
)ENGINE = InnoDB;

CREATE TABLE spittle
(
  id INTEGER AUTO_INCREMENT PRIMARY KEY ,
  spitter_id INTEGER NOT NULL,
  spittleText VARCHAR(2000) NOT NULL ,
  postedTime DATE NOT NULL ,
  FOREIGN KEY (spitter_id) REFERENCES spitter(id)
)ENGINE = InnoDB;