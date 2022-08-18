package com.resources;

import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class resourcesTest {

    @Test
    void registration() throws Exception {
        resources r = new resources();
        Response res = r.Registration("    {\n" +
                "          \"first_name\": \"shakeel\",\n" +
                "          \"last_name\": \"ahmad\",\n" +
                "          \"email\": \"aftablaiba6@gmail.com\",\n" +
                "          \"contact_number\": \"33111444599\",\n" +
                "          \"garage_number\":1,\n" +
                "          \"vehicle_number\": \"MNB-9090\"\n" +
                "    }");
        assertEquals(200,res.getStatus()); // already registered
    }
    @Test
    void registration1() throws Exception {
        resources r = new resources();
        Response res = r.Registration("    {\n" +
                "          \"first_name\": \"shakeel\",\n" +
                "          \"last_name\": \"ahmad\",\n" +
                "          \"email\": \"aftablaiba6@gmail.com\",\n" +
                "          \"contact_number\": \"33111444599\",\n" +
                "          \"garage_number\":1,\n" +
                "          \"vehicle_number\": \"GTL-5877\"\n" +
                "    }");
        assertEquals(200,res.getStatus()); // already registered
    }
    @Test
    void registration2() throws Exception {
        resources r = new resources();
        Response res = r.Registration(" {\n" +
                "          \"last_name\": \"ahmad\",\n" +
                "          \"email\": \"aftablaiba6@gmail.com\",\n" +
                "          \"contact_number\": \"33111444599\",\n" +
                "          \"garage_number\":1,\n" +
                "          \"vehicle_number\": \"MNB-9090\"\n" +
                "    }");
        assertEquals(400,res.getStatus()); // invalid first name
    }
    @Test
    void registration4() throws Exception {
        resources r = new resources();
        Response res = r.Registration("{\n" +
                "          \"first_name\": \"shakeel\",\n" +
                "          \"email\": \"aftablaiba6@gmail.com\",\n" +
                "          \"contact_number\": \"33111444599\",\n" +
                "          \"garage_number\":1,\n" +
                "          \"vehicle_number\": \"MNB-9090\"\n" +
                "    }");
        assertEquals(400,res.getStatus()); // invalid last name
    }
    @Test
    void registration3() throws Exception {
        resources r = new resources();
        Response res =r.Registration("    {\n" +
                "          \"first_name\": \"jameel\",\n" +
                "          \"last_name\": \"ahmad\",\n" +
                "          \"email\": \"aftablaiba6@gmail.com\",\n" +
                "          \"contact_number\": \"33111444599\",\n" +
                "          \"garage_number\":1,\n" +
                "          \"vehicle_number\": \"SDK-9090\"\n" +
                "    }");
        assertEquals(200,res.getStatus()); // successfully registered
    }
    @Test
    void registration5() throws Exception {
        resources r = new resources();
        Response res =r.Registration("    {\n" +
                "          \"first_name\": \"jameel\",\n" +
                "          \"last_name\": \"ahmad\",\n" +
                "          \"email\": \"aftablaiba6@gmail.com\",\n" +
                "          \"contact_number\": \"33111444599\",\n" +
                "          \"garage_number\":1,\n" +
                "          \"vehicle_number\": \"hzl-9090\"\n" +
                "    }");
        assertEquals(200,res.getStatus()); // successfully registered
    }

    @Test
    void parking1() throws Exception {
        resources r = new resources();
        Response res = r.Parking("    {\n" +
                "        \n" +
                "          \"vehicle_number\": \"LJK-0110\",\n" +
                "          \"park_status\":\"in\"\n" +
                "    }");
        assertEquals(200,res.getStatus()); // already in
    }
    @Test
    void parking2() throws Exception {
        resources r = new resources();
        Response res = r.Parking("    {\n" +
                "        \n" +
                "          \"vehicle_number\": \"GTL-5877\",\n" +
                "          \"park_status\":\"out\"\n" +
                "    }");
        assertEquals(200,res.getStatus()); // already out
    }
    @Test
    void parking3() throws Exception {
        resources r = new resources();
        Response res = r.Parking("     {\n" +
                "        \n" +
                "          \"vehicle_number\": \"\",\n" +
                "          \"park_status\":\"in\"\n" +
                "    }");
        assertEquals(400,res.getStatus()); // invalid
    }
    @Test
    void parking4() throws Exception {
        resources r = new resources();
        Response res = r.Parking("    {\n" +
                "        \n" +
                "          \"vehicle_number\": \"ABC-1111\",\n" +
                "          \"park_status\":\"in\"\n" +
                "    }");
        assertEquals(200,res.getStatus()); // successfully in
    }
    @Test
    void parking5() throws Exception {
        resources r = new resources();
        Response res = r.Parking("    {\n" +
                "        \n" +
                "          \"vehicle_number\": \"ABC-1111\",\n" +
                "          \"park_status\":\"out\"\n" +
                "    }");
        assertEquals(200,res.getStatus()); // successfully out
    }
    @Test
    void parking8() throws Exception {
        resources r = new resources();
        Response res = r.Parking("    {\n" +
                "        \n" +
                "          \"vehicle_number\": \"abc-1234\",\n" +
                "          \"park_status\":\"in\"\n" +
                "    }");
        assertEquals(400,res.getStatus()); // first register
    }

    @Test
    void history1() throws SQLException {
        resources r = new resources();
        Response res = r.History("ABC-1111");
        assertEquals(200,res.getStatus()); // not parked yet
    }

    @Test
    void history2() throws SQLException {
        resources r = new resources();
        Response res = r.History("GTL-5877");
        assertEquals(400,res.getStatus()); // history found
    }
    @Test
    void history3() throws SQLException {
        resources r = new resources();
        Response res = r.History("xql-3451");
        assertEquals(200,res.getStatus()); // not registered so no history
    }
}