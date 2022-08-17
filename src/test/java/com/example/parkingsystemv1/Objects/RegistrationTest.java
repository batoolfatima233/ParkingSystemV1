package com.example.parkingsystemv1.Objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationTest {

    Registration r1 = new Registration("qirat","zahra","batool12547@gmail.com","33346661468",2,"GTL-5877");

    Registration r2 = new Registration("adina","zahra","batool12547@gmail.com","33346661468",2,"MNB-5877");


    @Test
    void getFirst_name()
    {
        assertEquals("qirat",r1.getFirst_name());
    }

    @Test
    void setFirst_name() {
        r2.setFirst_name("adina");
        assertEquals("adina",r2.first_name);
    }

    @Test
    void getLast_name() {
        assertEquals("zahra",r1.getLast_name());
    }

    @Test
    void setLast_name()
    {
        r2.setLast_name("zaidi");
        assertEquals("zaidi",r2.last_name);
    }

    @Test
    void getEmail() {
        assertEquals("batool12547@gmail.com",r1.getEmail());
    }

    @Test
    void setEmail() {
        r2.setEmail("laiba@gmail.com");
        assertEquals("laiba@gmail.com",r2.email);
    }

    @Test
    void getContact_number() {
        assertEquals("33346661468",r1.getContact_number());
    }

    @Test
    void setContact_number() {
        r2.setContact_number("12345678234");
        assertEquals("12345678234",r2.contact_number);
    }

    @Test
    void getGarage_number() {
        assertEquals(2,r1.getGarage_number());
    }

    @Test
    void setGarage_number() {
        r2.setGarage_number(1);
        assertEquals(1,r2.garage_number);
    }

    @Test
    void getVehicle_number() {
        assertEquals("GTL-5877",r1.getVehicle_number());
    }

    @Test
    void setVehicle_number() {
        r2.setVehicle_number("jhg-87");
        assertEquals("jhg-87",r2.vehicle_number);
    }


}