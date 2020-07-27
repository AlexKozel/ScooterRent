package com.example.mapper;

import com.example.dto.SeasonTicketDTO;
import com.example.entity.SeasonTicket;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SeasonTicketMapper implements MapperAPI<SeasonTicket, SeasonTicketDTO>{

    @Autowired
    private MainMapper modelMapper;

    private TypeMap<SeasonTicket, SeasonTicketDTO> toDTOTypeMap;

    public SeasonTicketDTO toDto(SeasonTicket seasonTicket) {
        if(toDTOTypeMap == null){
            toDTOTypeMap = modelMapper.createTypeMap(SeasonTicket.class, SeasonTicketDTO.class);}
        toDTOTypeMap.addMappings(mapping -> mapping.map(singleSeasonTicket -> seasonTicket.getUser().getUserId(), SeasonTicketDTO::setUserId));
        return Objects.isNull(seasonTicket) ? null : modelMapper.map(seasonTicket, SeasonTicketDTO.class);
    }

    public SeasonTicket toEntity(SeasonTicketDTO seasonTicketDTO){
        return Objects.isNull(seasonTicketDTO) ? null : modelMapper.map(seasonTicketDTO, SeasonTicket.class);
    }
}
