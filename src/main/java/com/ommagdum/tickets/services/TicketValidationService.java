package com.ommagdum.tickets.services;

import com.ommagdum.tickets.domain.entities.TicketValidation;

import java.util.UUID;

public interface TicketValidationService {

    TicketValidation validateTicketByQrCode(UUID qrcodeId);

    TicketValidation validateTicketManually(UUID ticketId);
}
