package com.medic.appmedic.core.usecase.port.out;

import com.medic.appmedic.core.entity.Booking;

import java.util.Optional;
import java.util.UUID;

public interface BookingRepositoryPort {
    Booking save(Booking booking);

    Optional<Booking> findById(UUID id);
}
