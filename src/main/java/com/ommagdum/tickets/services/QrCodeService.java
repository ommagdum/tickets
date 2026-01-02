package com.ommagdum.tickets.services;

import com.ommagdum.tickets.domain.entities.QrCode;
import com.ommagdum.tickets.domain.entities.Ticket;

import java.util.UUID;

public interface QrCodeService {

    QrCode generateQrCode(Ticket ticket);

    byte[] getQrCodeImageForUserAndTicket(UUID userId, UUID ticketId);
}
