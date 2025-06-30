package com.examples;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.examples.repository.ReservationCsv;
import com.examples.service.ReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

public class ReservationCsvTest {
    private ReservationService rs;

    @BeforeEach
    void setUp() {
        File file = new File("data/test/test_data.csv");
        if (file.exists()) {
            file.delete();
        }

        rs = new ReservationService(new ReservationCsv("data/test/test_data.csv"));
    }


    @Test
    @DisplayName("Can create reservation hash map.")
    void canCreateReservationTable() {
        assertNotNull(rs.getReservations());
    }

}
