package com.example.parkingsystemv1.Scheduler;

import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;

import static org.junit.jupiter.api.Assertions.*;

class Job1Test {

    @Test
    void execute() throws ServletException {
        Scheduler s = new Scheduler();
        s.init();
    }
}