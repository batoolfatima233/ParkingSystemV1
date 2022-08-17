package com.example.parkingsystemv1.Objects;

public class parking {
    public String vehicle_number;
    public String park_status;
    public String date;
    public String time;


    public parking(String vehicle_number, String park_status, String date, String time) {
        this.vehicle_number = vehicle_number;
        this.park_status = park_status;
        this.date = date;
        this.time = time;
    }

    public parking(String vehicle_number, String park_status) {
        this.vehicle_number = vehicle_number;
        this.park_status = park_status;
    }

    public String getVehicle_number() {
        return vehicle_number;
    }

    public void setVehicle_number(String vehicle_number) {
        this.vehicle_number = vehicle_number;
    }

    public String getPark_status() {
        return park_status;
    }

    public void setPark_status(String park_status) {
        this.park_status = park_status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

