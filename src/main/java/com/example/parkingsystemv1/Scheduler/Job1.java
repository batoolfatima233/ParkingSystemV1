package com.example.parkingsystemv1.Scheduler;

import com.example.parkingsystemv1.localDatabase.Database;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.example.parkingsystemv1.Notification.notification.sendEmail;

//import static com.example.parkingsystemv1.notification.sendEmail;

public class Job1 implements Job
{
    public void execute(JobExecutionContext context)
    {
//        try
//        {
        Database b = null;
        try {
            b = new Database();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assert b != null;
        ArrayList<String> array = b.checkAt1am();


            for(String i : array )
            {
                System.out.println("reached here");
                System.out.println("get "+ i);
//                try {
//                    sendEmail(i,"1 am Alert","park your car");
//                } catch (MessagingException e) {
//                    e.printStackTrace();
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
            }
            System.exit(0);
//        }
//        catch(Exception ex)
//        {
//            ex.printStackTrace();
//        }

    }
}
