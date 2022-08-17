package com.example.parkingsystemv1.Objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class parkingTest {
    parking p1 = new parking("CVB-0909","in","2022-08-10","21:23:52.746");
    parking p2 = new parking("ASD-1234  ","in");

    @Test
    void getVehicle_number() {
        assertEquals("CVB-0909",p1.getVehicle_number());
    }

    @Test
    void setVehicle_number() {
        p2.setVehicle_number("XYZ");
        assertEquals("XYZ",p2.vehicle_number);
    }

    @Test
    void getPark_status() {
        assertEquals("in",p1.getPark_status());
    }

    @Test
    void setPark_status() {
        p2.setPark_status("out");
        assertEquals("out",p2.park_status);
    }

    @Test
    void getDate() {
        assertEquals("2022-08-10",p1.getDate());
    }

    @Test
    void setDate() {
        p1.setDate("2022-08-17");
        assertEquals("2022-08-17",p1.date);
    }

    @Test
    void getTime() {
        assertEquals("21:23:52.746",p1.getTime());
    }

    @Test
    void setTime() {
        p1.setTime("23:23:52.746");
        assertEquals("23:23:52.746",p1.time);
    }
}