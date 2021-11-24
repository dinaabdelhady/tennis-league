
DROP TABLE IF EXISTS `match_result`;
CREATE TABLE match_result (
   match_id integer  NOT NULL,
   winner_registration_id integer  NOT NULL,
   number_of_sets_played integer  NOT NULL,
   is_opponent_retired tinyint(1)  NULL,
   CONSTRAINT match_result_pk PRIMARY KEY (match_id)
) ;
