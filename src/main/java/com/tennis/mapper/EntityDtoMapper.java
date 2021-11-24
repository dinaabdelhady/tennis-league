package com.tennis.mapper;

public interface EntityDtoMapper<ENT, DTO>{
    DTO toDTO(ENT ent);
    ENT toEntity(DTO dto);
}
