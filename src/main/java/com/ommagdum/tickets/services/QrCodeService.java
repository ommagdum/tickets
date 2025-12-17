package com.ommagdum.tickets.services;

import com.ommagdum.tickets.domain.entities.QrCode;
import com.ommagdum.tickets.domain.entities.Ticket;

public interface QrCodeService {

    QrCode generateQrCode(Ticket ticket);
}
