DROP TABLE IF EXISTS `tournament`;
CREATE TABLE tournament (
   id integer  NOT NULL auto_increment,
   tournament_name varchar(100)  NOT NULL,
   location varchar(50)  NOT NULL,
   start_date date  NOT NULL,
   end_date date  NOT NULL,
   number_of_rounds integer  NOT NULL,
   CONSTRAINT tournament_pk PRIMARY KEY (id)
) ;