package com.examples.service;

import com.examples.repository.ReservationRepository;

public class ReservationService {
    ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }
}
