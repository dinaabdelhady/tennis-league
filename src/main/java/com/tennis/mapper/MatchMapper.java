package com.tennis.mapper;

import com.tennis.model.dto.MatchDto;
import com.tennis.model.entity.Match;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel="spring")
@Component
public abstract class MatchMapper implements EntityDtoMapper<Match, MatchDto> {

}
