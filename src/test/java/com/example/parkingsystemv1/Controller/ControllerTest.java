package com.example.parkingsystemv1.Controller;

import com.example.parkingsystemv1.Objects.Registration;
import com.example.parkingsystemv1.Objects.parking;
import org.junit.jupiter.api.Test;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import static com.example.parkingsystemv1.Controller.Controller.doParking;
import static com.example.parkingsystemv1.Controller.Controller.doRegistration;
import static com.example.parkingsystemv1.Controller.Controller.carHistory;
import static org.junit.jupiter.api.Assertions.*;
class ControllerTest {


    @Test
    void doregistration1() throws SQLException, MessagingException, UnsupportedEncodingException {
        // invalid
        Registration test_entry = new Registration("qirat","zahra","batool12547@gmail.com","3334666146",2,"POV-9876");
        assertEquals(1,doRegistration(test_entry));
    }
    @Test
    void doregistration2() throws SQLException, MessagingException, UnsupportedEncodingException {
        // already registered
        Registration test_entry = new Registration("qirat","zahra","batool12547@gmail.com","33346661468",2,"GTL-5877");
        assertEquals(2,doRegistration(test_entry));
    }
    @Test
    void doregistration3() throws SQLException, MessagingException, UnsupportedEncodingException {
        // successfully registered
        Registration test_entry = new Registration("qirat","zahra","batool12547@gmail.com","33346661468",2,"QWE-9876");
        assertEquals(3,doRegistration(test_entry));
    }
    @Test
    void doParking1() throws SQLException, MessagingException, UnsupportedEncodingException {
        // invalid
        parking test_entry = new parking("","in");
        assertEquals(1,doParking(test_entry));
    }
    @Test
    void doParking2() throws SQLException, MessagingException, UnsupportedEncodingException {
        // already parked in
        parking test_entry = new parking("LJK-0110","in");
        assertEquals(2,doParking(test_entry));
    }
    @Test
    void doParking3() throws SQLException, MessagingException, UnsupportedEncodingException {
        // already parked out
        parking test_entry = new parking("GTL-5877","out");
        assertEquals(3,doParking(test_entry));
    }
    @Test
    void doParking4() throws SQLException, MessagingException, UnsupportedEncodingException {
        // successfully parked in
        parking test_entry = new parking("POV-9876","in");
        assertEquals(4,doParking(test_entry));
    }
    @Test
    void doParking5() throws SQLException, MessagingException, UnsupportedEncodingException {
        // successfully parked out
        parking test_entry = new parking("POV-9876","out");
        assertEquals(5,doParking(test_entry));
    }
    @Test
    void doParking8() throws SQLException, MessagingException, UnsupportedEncodingException {
        // first park yourself
        parking test_entry = new parking("ASD-456","out");
        assertEquals(8,doParking(test_entry));
    }

    @Test
    void carHistory1() throws SQLException {
//        String expected = "GTL-5877\t2022-08-07\t23:13:42.424\tin\n" +
//                "GTL-5877\t2022-08-07\t23:23:52.746\tout\n" +
//                "GTL-5877\t2022-08-07\t23:52:27.325\tin\n" +
//                "GTL-5877\t2022-08-10\t21:03:00.225\tout\n" +
//                "GTL-5877\t2022-08-10\t21:03:58.454\tin\n" +
//                "GTL-5877\t2022-08-10\t21:04:56.091\tout\n" +
//                "GTL-5877\t2022-08-10\t21:12:27.112\tin\n" +
//                "GTL-5877\t2022-08-10\t21:12:36.684\tout\n";
        String actual = carHistory("GTL-5877");
       // assertEquals(expected,actual);
        assertNotNull(actual);
    }
}