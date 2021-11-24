package com.tennis.repository;

import com.tennis.model.entity.MatchIdPK;
import com.tennis.model.entity.MatchResult;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchResultRepository extends CrudRepository<MatchResult, MatchIdPK> {
}
