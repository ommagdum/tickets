package com.ommagdum.tickets.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ommagdum.tickets.domain.CreateTicketTypeRequest;
import com.ommagdum.tickets.domain.entities.EventStatusEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventRequestDto {

    @NotBlank(message = "Event name is required")
    private String name;

    private LocalDateTime start;

    private LocalDateTime end;

    @NotBlank(message = "Venue information is required")
    private String venue;

    @JsonProperty("salesStart")
    private LocalDateTime saleStart;

    @JsonProperty("salesEnd")
    private LocalDateTime saleEnd;

    @NotNull(message = "Event status must be provided")
    private EventStatusEnum status;

    @NotNull(message = "At least one ticket type is required")
    @Valid
    private List<CreateTicketTypeRequestDto> ticketTypes;
}
