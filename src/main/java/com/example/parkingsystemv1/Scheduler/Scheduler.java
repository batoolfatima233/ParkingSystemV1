package com.example.parkingsystemv1.Scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class Scheduler extends HttpServlet
{
    public void init() throws ServletException {

        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        Calendar now = Calendar.getInstance();

        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        System.out.println(hour + "  "+ minute);

        try {
            JobDetail job1 = JobBuilder.newJob(Job1.class).withIdentity("Iterate", "group1").build();

            Trigger trigger1 = TriggerBuilder.newTrigger()
                    .withIdentity("triggerIterate", "group1")
                    .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(12, 20))
                    .build();
            org.quartz.Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
            scheduler1.start();
            scheduler1.scheduleJob(job1, trigger1);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}



