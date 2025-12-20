package com.ommagdum.tickets.mappers;

import com.ommagdum.tickets.domain.dto.ListTicketResponseDto;
import com.ommagdum.tickets.domain.dto.ListTicketTicketTypeResponseDto;
import com.ommagdum.tickets.domain.entities.Ticket;
import com.ommagdum.tickets.domain.entities.TicketType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface TicketMapper {

    ListTicketTicketTypeResponseDto toListTicketTicketTypeResponseDto(TicketType ticketType);

    ListTicketResponseDto toListTicketResponseDto(Ticket ticket);
}
