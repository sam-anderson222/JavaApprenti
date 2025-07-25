package org.example.service;

import org.example.data.OrderRepo;
import org.example.data.ServerRepo;
import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.model.Order;
import org.example.model.Server;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServerRepoTest {
    @Autowired
    private ServerRepo serverRepo;

    @Autowired
    private JdbcTemplate jdbcTemplate; // Used to access and reset the sql database.

    @BeforeEach
    void setUp() {
        try {
            jdbcTemplate.execute("{CALL set_known_good_state()}");
        } catch (Exception ex) {
            System.out.println("Error");
        }
    }

    @Test
    void getAllServers_getsAllAvailableServerInPresent() throws InternalErrorException {
        List<Server> servers = serverRepo.getAllAvailableServers(LocalDate.now());

        assertEquals(14, servers.size());
    }

    @Test
    void getAllServers_getsAllAvailableServerInPast() throws InternalErrorException {
        List<Server> servers = serverRepo.getAllAvailableServers(LocalDate.parse("2020-01-02"));

        assertEquals(6, servers.size());
    }

    @Test
    void getServerByID_getServer() throws InternalErrorException, RecordNotFoundException {
        Server server = serverRepo.getServerById(1);

        assertEquals("Mersey", server.getFirstName());
    }

    @Test
    void getServerByID_invalidServer_throwsException() {
        assertThrows(RecordNotFoundException.class, () ->
        {
           serverRepo.getServerById(-1);
        });
    }
}
