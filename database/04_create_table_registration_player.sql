
DROP TABLE IF EXISTS `registration_player`;
CREATE TABLE registration_player (
   registration_id integer  NOT NULL,
   player_id integer  NOT NULL,
   CONSTRAINT registration_player_pk PRIMARY KEY (registration_id,player_id)
) ;
