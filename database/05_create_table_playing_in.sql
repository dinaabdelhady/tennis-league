
DROP TABLE IF EXISTS `playing_in`;
CREATE TABLE playing_in (
   id integer  NOT NULL  auto_increment,
   registration_id integer  NOT NULL,
   seed integer  NOT NULL,
   CONSTRAINT playing_in_pk PRIMARY KEY (id)
) ;
