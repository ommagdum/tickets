package com.ommagdum.tickets.mappers;

import com.ommagdum.tickets.domain.CreateEventRequest;
import com.ommagdum.tickets.domain.CreateTicketTypeRequest;
import com.ommagdum.tickets.domain.dto.CreateEventRequestDto;
import com.ommagdum.tickets.domain.dto.CreateEventResponseDto;
import com.ommagdum.tickets.domain.dto.CreateTicketTypeRequestDto;
import com.ommagdum.tickets.domain.entities.Event;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);

    CreateEventRequest fromDto(CreateEventRequestDto dto);

    CreateEventResponseDto toDto(Event event);

}
