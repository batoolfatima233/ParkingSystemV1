package com.example.parkingsystemv1.localDatabase;

import com.example.parkingsystemv1.Objects.Registration;
import com.example.parkingsystemv1.Objects.parking;
import org.junit.jupiter.api.Test;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.Assert.assertArrayEquals;
class DatabaseTest {

    Database db = new Database();

    DatabaseTest() throws SQLException {
    }

    @Test
    void registerInfo1() throws SQLException, MessagingException, UnsupportedEncodingException {
        // already registered
        Registration test_entry = new Registration("qirat","zahra","batool12547@gmail.com","33346661468",2,"GTL-5877");
        assertEquals(1,db.RegisterInfo(test_entry));
    }
    @Test
    void registerInfo2() throws SQLException, MessagingException, UnsupportedEncodingException {
        // successfully registered
        Registration test_entry = new Registration("abeer","azam","batool12547@gmail.com","33346661468",2,"ASD-345");
        assertEquals(2,db.RegisterInfo(test_entry));
    }

    @Test
    void parkingInfo1()throws SQLException, MessagingException, UnsupportedEncodingException {
        // already parked in
        parking test_entry = new parking("LJK-0110","in");
        assertEquals(1,db.ParkingInfo(test_entry));
    }
    @Test
    void parkingInfo2()throws SQLException, MessagingException, UnsupportedEncodingException {
        // already parked out
        parking test_entry = new parking("GTL-5877","out");
        assertEquals(2,db.ParkingInfo(test_entry));
    }
    @Test
    void parkingInfo3()throws SQLException, MessagingException, UnsupportedEncodingException {
        // successfully parked in
        parking test_entry = new parking("leh-909","in");
        assertEquals(3,db.ParkingInfo(test_entry));
    }
    @Test
    void parkingInfo4()throws SQLException, MessagingException, UnsupportedEncodingException {
        // successfully parked out
        parking test_entry = new parking("leh-909","out");
        assertEquals(4,db.ParkingInfo(test_entry));
    }
    @Test
    void parkingInfo8()throws SQLException, MessagingException, UnsupportedEncodingException {
        // first register yourself
        parking test_entry = new parking("bvc-sdf","in");
        assertEquals(8,db.ParkingInfo(test_entry));
    }

    @Test
    void check_parking1() throws SQLException {

        // already in
        int actual= db.check_parking("LJK-0110");
        assertEquals(1,actual);
    }
    @Test
    void check_parking2() throws SQLException {

        // already out
        int actual= db.check_parking("GTL-5877");
        assertEquals(2,actual);
    }
    @Test
    void check_parking3() throws SQLException {

        // allowed
        int actual= db.check_parking("leh-909");
        assertEquals(3,actual);
    }

    @Test
    void check_registration1() throws SQLException
    {
        assertEquals(1,db.check_registration("sdf-0987"));
    }

    @Test
    void check_registration2() throws SQLException
    {
        assertEquals(2,db.check_registration("leh-909"));
    }


    @Test
    void checkAt1am() {
    }

    @Test
    void check_history1() {
        ArrayList<parking> arr = new ArrayList<>();

        parking p1 = new parking("GTL-5877","in");
        p1.setTime("23:13:42.424");
        p1.setDate("2022-08-07");
        arr.add(p1);

        parking p2 = new parking("GTL-5877","out");
        p1.setTime("23:23:52.746");
        p1.setDate("2022-08-07");
        arr.add(p2);
        //assertEquals(arr.stream().map(m -> m.get(m).toString()),db.check_history("GTL-5877").stream().map(m -> m.getTime().toString()));
        //assertArrayEquals(arr.toArray(),db.check_history("GTL-5877").toArray());
    }
}