package com.ommagdum.tickets.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ommagdum.tickets.domain.entities.EventStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEventRequest {
    private UUID id;
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
    private String venue;
    @JsonProperty("salesStart")
    private LocalDateTime saleStart;
    @JsonProperty("salesEnd")
    private LocalDateTime saleEnd;
    private EventStatusEnum status;
    private List<UpdateTicketTypeRequest> ticketTypes = new ArrayList<>();
}
