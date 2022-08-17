package com.example.parkingsystemv1.Controller;
import com.example.parkingsystemv1.Objects.Registration;
import com.example.parkingsystemv1.Objects.parking;
import com.example.parkingsystemv1.Validation.validation;
import com.example.parkingsystemv1.localDatabase.Database;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import javax.mail.MessagingException;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;


public class Controller
{

//    public static void main(String[] args)  throws JsonProcessingException
//    {
//        Registration new_entry = new Registration("namef","namel","email","12345678",1,"qwe-gfd");
//        ObjectMapper mapper = new ObjectMapper();
//        //Converting the Object to JSONString
//        String jsonString = mapper.writeValueAsString(new_entry);
//        System.out.println();
//        try
//        {
//            SendRegistrationMessage(jsonString);
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//        //Registration s = ReadRegistrationMessage("regis_queue");
//    }
//    public boolean regis2(Registration new_entry) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        //Converting the Object to JSONString
//        String jsonString = mapper.writeValueAsString(new_entry);
//        System.out.println();
//
//        return true;
//        //Registration s = ReadRegistrationMessage("regis_queue");
//
//    }

//    public static int doParking(parking new_status) throws SQLException {
//        try
//        {
//        validation v = new validation();
//        if(!v.checkParking(new_status))
//        {
//            System.out.print("has returned here in controller");
//            return 1; //  invalid data"
//        }
//        else
//        {
//            //System.out.println(new_status.toString());
//            Database db = new Database();
//            int b = db.ParkingInfo(new_status);
//
//            if (b == 1)
//            {
//                return 2;      // already parked in
//            }
//            else if (b == 2)
//            {
//                return 3;       // already parked out
//            }
//            else if (b == 3)
//            {
//                return 4;        //successfully parked in
//            }
//            else if (b == 4)
//            {
//                return 5;         //successfully parked out
//            }
//                else if (b == 5)
//                {
//                    return 6;         //Response.status(400).entity("invalid").build();
//                }
//                else if (b == 6)
//                {
//                    System.out.println("error in parking status");
//                    return 7;          //Response.status(400).entity("error in parking status").build();
//                }
//            else    // if (b == 8)
//            {
//                return 8 ;           //Response.status(400).entity("first u need to register your car then u can park").build();
//            }
//                else if (b == 9)
//                {
//                    System.out.println("invalid data");
//                    return 6; //Response.status(400).entity("invalid data").build();
//                }
//                else
//                {
//                    System.out.println("error in parking info");
//                    return 6;// Response.status(400).entity("error in parking info").build();
//                }
//        }
//        }
//        catch(Exception ex)
//        {
//            //ex.printStackTrace();
//            System.out.println("exception");
//            return 7; // exception
//        }
//    }

    public static int doRegistration(Registration new_entry) throws SQLException, MessagingException, UnsupportedEncodingException {

            validation v = new validation();
            if(!v.checkRegistration(new_entry))
            {
                return 1; //  invalid info
            }
            else
            {
                Database db = new Database();

                int b = db.RegisterInfo(new_entry);
                if (b == 1)
                {
                    return 2;         //   already registered
                }
                else  // if (b == 2)
                {
                    return 3;        //    successfully registered

                }
            }
    }

    public static int doParking(parking new_status) throws SQLException, MessagingException, UnsupportedEncodingException {
            validation v = new validation();
            if(!v.checkParking(new_status))
            {
                System.out.print("has returned here in controller");
                return 1; //  invalid data"
            }
            else
            {
                Database db = new Database();
                int b = db.ParkingInfo(new_status);

                if (b == 1)
                {
                    return 2;      // already parked in
                }
                else if (b == 2)
                {
                    return 3;       // already parked out
                }
                else if (b == 3)
                {
                    return 4;       //successfully parked in
                }
                else if (b == 4)
                {
                    return 5;        //successfully parked out
                }
                else    // if (b == 8)
                {
                    return 8 ;       //Response.status(400).entity("first u need to register your car then u can park").build();
                }
            }
    }

    public static String carHistory(String car_name) throws SQLException
    {
        Database db = new Database();
        ArrayList<parking> array = db.check_history(car_name);
        String out= "";
        for (parking p : array)
        {
            out= out + p.getVehicle_number()+ "\t"+ p.getDate()+ "\t"+p.getTime()+ "\t"+p.getPark_status() +"\n";
        }
        return out;
    }
}
