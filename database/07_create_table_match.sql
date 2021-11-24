
DROP TABLE IF EXISTS `matches`;
CREATE TABLE `matches` (
   id integer  NOT NULL auto_increment ,
   first_registration_id integer  NOT NULL,
   second_registration_id integer  NOT NULL,
   round integer  NOT NULL,
   CONSTRAINT match_pk PRIMARY KEY (id)
) ;