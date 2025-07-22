package org.example.data.mappers;

import org.example.model.Server;
import org.springframework.jdbc.core.RowMapper;

import java.time.LocalDate;

public class ServerMapper {
    public static RowMapper<Server> serverRowMapper() {
        return (rs, rowNum) -> {
            Server server = new Server();

            server.setServerID(rs.getInt("ServerID"));
            server.setFirstName(rs.getString("FirstName"));
            server.setLastName(rs.getString("LastName"));
            server.setHireDate(rs.getObject("HireDate", LocalDate.class));
            server.setTermDate(rs.getObject("TermDate", LocalDate.class));

            return server;
        };
    }
}
