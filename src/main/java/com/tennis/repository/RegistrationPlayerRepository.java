package com.tennis.repository;

import com.tennis.model.entity.Registration;
import com.tennis.model.entity.RegistrationPlayer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationPlayerRepository extends CrudRepository<RegistrationPlayer,Long> {
    List<RegistrationPlayer> findAllByRegistrationIn(List<Registration> registration);
}
