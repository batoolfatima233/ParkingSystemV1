package com.example.parkingsystemv1.Scheduler;

import org.junit.jupiter.api.Test;
import org.quartz.SchedulerException;

import javax.servlet.ServletException;

import static org.junit.jupiter.api.Assertions.*;

class SchedulerTest
{
    @Test
    void testAt1am() throws SchedulerException, ServletException {
        Scheduler s = new Scheduler();
        s.init();

        assertNotNull(s);

    }

}