
DROP TABLE IF EXISTS `registration`;
CREATE TABLE registration (
   id integer  NOT NULL auto_increment ,
   registration_date date  NOT NULL,
   CONSTRAINT registration_pk PRIMARY KEY (id)
) ;