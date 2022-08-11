package com.example.parkingsystemv1.Scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Scheduler
{
        public static void main(String[] args) throws SchedulerException {
            Scheduler s = new Scheduler();
        }
//    {
        public void run() throws SchedulerException {
//    public Scheduler() throws SchedulerException {
//        try {
            JobDetail job1 = JobBuilder.newJob(Job1.class).withIdentity("Iterate", "group1").build();

            Trigger trigger1 = TriggerBuilder.newTrigger()
                    .withIdentity("triggerIterate", "group1")
                    .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(13, 22))
                    .build();
            org.quartz.Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
            scheduler1.start();
            scheduler1.scheduleJob(job1, trigger1);

//        }
//        catch (Exception ex)
//        {
//            ex.printStackTrace();
//        }
    }

}



