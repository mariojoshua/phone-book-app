package com.uttara.phone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MySqlServiceTest {

    MySqlService mySqlService;

    @BeforeEach
    public void init() {
        mySqlService = new MySqlService();
    }

    @Test
    public void testCreateContactBook() {
        assertTrue (mySqlService.createContactBook("cats"));
        assertFalse (mySqlService.createContactBook("cats"));
        assertTrue (mySqlService.deleteContactBook("cats"));
    }

    @Test
    public void testContactBookExists() {   
        assertTrue(mySqlService.createContactBook("mats"));     
        assertTrue(mySqlService.contactBookExists("mats"));
        assertTrue(mySqlService.deleteContactBook("mats"));
    }

    @Test
    public void testDeleteContactBook() {
        assertTrue (mySqlService.createContactBook("hats"));
        assertTrue (mySqlService.deleteContactBook("hats"));
        assertFalse (mySqlService.deleteContactBook("hats"));
    }

    @Test
    public void testContactExists() {
        fail("Not yet Implemented");
    }

    @Test
    public void testDeleteContact() {
        fail("Not yet Implemented");
    }

    @Test
    public void testReadContact() {
        fail("Not yet Implemented");
    }

    @Test
    public void testUpdateContacts() {
        fail("Not yet Implemented");
    }

    @Test
    public void testWriteContacts() {
        fail("Not yet Implemented");
    }
}
