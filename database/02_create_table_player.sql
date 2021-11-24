DROP TABLE IF EXISTS `player`;
CREATE TABLE player (
   id integer  NOT NULL auto_increment,
   first_name varchar(50)  NOT NULL,
   last_name varchar(50)  NOT NULL,
   email varchar(255)  NOT NULL,
   gender char(1)  NOT NULL,
   date_of_birth date  NOT NULL,
   CONSTRAINT player_pk PRIMARY KEY (id)
) ;