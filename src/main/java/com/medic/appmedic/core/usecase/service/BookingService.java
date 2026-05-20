package com.medic.appmedic.core.usecase.service;

import com.medic.appmedic.core.entity.Booking;
import com.medic.appmedic.core.usecase.dto.request.CreateBookingRequest;
import com.medic.appmedic.core.usecase.dto.response.BookingResponse;
import com.medic.appmedic.core.usecase.port.in.CreateBookingCase;
import com.medic.appmedic.core.usecase.port.out.BookingRepositoryPort;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.ArrayList;


public class BookingService implements CreateBookingCase {
    private final BookingRepositoryPort bookingRepositoryPort;

    public BookingService(BookingRepositoryPort bookingRepositoryPort) {
        this.bookingRepositoryPort = bookingRepositoryPort;
    }

    @Override
    public BookingResponse createBooking(CreateBookingRequest request) {
        Booking booking = new Booking();
        booking.setClientId(request.getClientId());
        booking.setServiceId(request.getServiceId());
        booking.setUserId(request.getUserId());
        booking.setScheduledAt(request.getScheduledAt());
        booking.setStatus(request.getStatus());
        booking.setReason(request.getReason());
        booking.setNotes(request.getNotes());
        LocalDate now = LocalDate.now();
        booking.setCreatedAt(now);
        booking.setUpdatedAt(now);

        Booking saved = bookingRepositoryPort.save(booking);

        return new BookingResponse(
                saved.getId(),
                saved.getClientId(),
                saved.getServiceId(),
                saved.getUserId(),
                saved.getScheduledAt(),
                saved.getStatus(),
                saved.getReason(),
                saved.getNotes(),
                saved.getCreatedAt(),
                saved.getUpdatedAt()
        );
    }

public List<String> getAvailableSlots(){
    List<String> slots = new ArrayList <> ();

        slots.add("08:00");

        slots.add("09:00");

        slots.add("10:00");

        slots.add("11:00");

        slots.add("12:00");

        slots.add("14:00");

        slots.add("16:00");


    return slots;

    
}
}