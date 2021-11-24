
DROP TABLE IF EXISTS `game_score`;
CREATE TABLE game_score (
   match_id integer  NOT NULL,
   game_number integer  NOT NULL,
   first_registration_point integer  NOT NULL,
   second_registration_point integer  NOT NULL,
   CONSTRAINT game_score_pk PRIMARY KEY (match_id, game_number)
) ;
