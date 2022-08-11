package com.example.parkingsystemv1.Validation;
import com.amazonaws.services.route53resolver.model.Validation;
import com.example.parkingsystemv1.Objects.Registration;
import com.example.parkingsystemv1.Objects.parking;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class validationTest {
    validation val = new validation();
    @Test
    void checkRegistration1() {

        Registration test = new Registration("qirat","zahra","batool12547gmail.com","3334666146",2,"POV-9876");
        assertFalse(val.checkRegistration(test));
    }
    @Test
    void checkRegistration2() {

        Registration test = new Registration("qirat","zahra","batool12547@gmail.com","3334666146",2,"POV-9876");
        assertFalse(val.checkRegistration(test));
    }
    @Test
    void checkRegistration3() {

        Registration test = new Registration("qirat","zahra","batool12547@gmail.com","33346661466",2,"POV-9876");
        assertTrue(val.checkRegistration(test));
    }
    @Test
    void checkRegistration4() {

        Registration test = new Registration("qirat","zahra","batool12547gmail.com","33346661466",2,"POV-9876");
        assertFalse(val.checkRegistration(test));
    }

    @Test
    void checkRegistration5() {

        Registration test = new Registration("","zahra","batool12547@gmail.com","33346661466",2,"POV-9876");
        assertFalse(val.checkRegistration(test));
    }

    @Test
    void checkRegistration6() {

        Registration test = new Registration("qirat","","batool12547@gmail.com","33346661466",2,"POV-9876");
        assertFalse(val.checkRegistration(test));
    }
    @Test
    void checkRegistration7() {

        Registration test = new Registration("qirat",null,"batool12547@gmail.com","33346661466",2,"POV-9876");
        assertFalse(val.checkRegistration(test));
    }
    @Test
    void checkParking1() {
        parking test = new parking("POV-9876","in");
        assertTrue(val.checkParking(test));
    }
    @Test
    void checkParking2() {
        parking test = new parking("POV-9876","inn");
        assertFalse(val.checkParking(test));
    }
    @Test
    void checkParking3() throws NullPointerException{
        parking test = new parking("POV-9876",null);
        assertFalse(val.checkParking(test));
    }
    @Test
    void checkParking4() throws NullPointerException{
        parking test = new parking(null,"out");
        assertFalse(val.checkParking(test));
    }
}