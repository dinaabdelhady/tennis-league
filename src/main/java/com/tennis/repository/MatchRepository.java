package com.tennis.repository;

import com.tennis.model.entity.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends CrudRepository<Match,Integer> {
    List<Match> findAll();
    List<Match> findAllByRound(Integer round);
}
