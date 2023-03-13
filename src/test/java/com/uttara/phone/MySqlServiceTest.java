package com.uttara.phone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.uttara.phone.Name.Gender;


public class MySqlServiceTest {

    MySqlService mySqlService;

    @BeforeEach
    public void init() {
        mySqlService = new MySqlService();
    }

    @Test
    public void testCreateContactBook() {
        assertTrue (mySqlService.createContactBook("park11"));
       assertTrue(mySqlService.contactBookExists("park11"));
        assertFalse (mySqlService.createContactBook("park11"));
        assertTrue (mySqlService.deleteContactBook("park11"));
        assertFalse(mySqlService.contactBookExists("park11"));
    }

    @Test
    public void testContactBookExists() { 
        assertFalse(mySqlService.contactBookExists("navy12"));  
        assertTrue(mySqlService.createContactBook("navy12"));     
        assertTrue(mySqlService.contactBookExists("navy12"));
        assertTrue(mySqlService.deleteContactBook("navy12"));
        assertFalse(mySqlService.contactBookExists("navy12"));
    }

    @Test
    public void testDeleteContactBook() {
        assertTrue (mySqlService.createContactBook("school14"));
        assertTrue(mySqlService.contactBookExists("school14"));
        assertTrue (mySqlService.deleteContactBook("school14"));
        assertFalse(mySqlService.contactBookExists("school14"));
        assertFalse (mySqlService.deleteContactBook("school14"));
    }

    @Test
    public void testWriteContacts() {
        String phoneBookName = "lake cleaning group";
        ContactBean contactBean = new ContactBean(
            new Name(Gender.M, "Arulmozhi Varman", "Arul"), 
            List.of("9532142666", "4266695321"), 
            "No 95, Viharam road, Anuradhapuram, Srilanka - 321579", 
            List.of("lake","asia" , "chola"), 
            List.of("Arulmozhi.Varman@gmail.com", "Varman.Arulmozhi@gmail.com"), 
            Map.of("dateOfBirth",
            LocalDate.of(1025, 2, 14)));
        assertTrue (mySqlService.createContactBook(phoneBookName));
        assertTrue (mySqlService.writeContacts(contactBean, phoneBookName));
        assertTrue (mySqlService.contactExists("arulmozhi varman", "lake cleaning group"));
        assertFalse (mySqlService.writeContacts(contactBean, phoneBookName));
        // assertEquals(List.of(contactBean),mySqlService.readContact(phoneBookName));
        // assertTrue (mySqlService.deleteContact("Arulmozhi.Varman@gmail.com", phoneBookName));
    }

    @Test
    public void testContactExists() {
        String phoneBookName = "North Army";
        ContactBean contactBean = new ContactBean(
            new Name(Gender.M, "Aditha Karikalan", "Adi"), 
            List.of("1429532666", "5324266691"), 
            "No 66, Golden palace road, Kanchipuram, India - 503125", 
            List.of("army","asia" , "chola"), 
            List.of("Aditha.Karikalan@ymail.com", "Karikalan_Adi@hotmail.com"), 
            Map.of("dateOfBirth",
            LocalDate.of(1022, 2, 14)));
        assertTrue (mySqlService.createContactBook(phoneBookName));
        assertTrue (mySqlService.writeContacts(contactBean, phoneBookName));
        assertTrue (mySqlService.contactExists("Aditha", "lake cleaning group"));
        assertFalse (mySqlService.writeContacts(contactBean, phoneBookName));
        // assertEquals(List.of(contactBean),mySqlService.readContact(phoneBookName));
        // assertTrue (mySqlService.deleteContact("Arulmozhi.Varman@gmail.com", phoneBookName));
    }

    @Test
    public void testDeleteContact() {
        String phoneBookName = "spy group";
        ContactBean contactBean = new ContactBean(
            new Name(Gender.M, "Azhwarkadiyan Nambi", "Thirumalai"), 
            List.of("2149532666", "6954266321"), 
            "No 105, fort road, Tanjavur, India - 500231", 
            List.of("secret service","asia", "chola"), 
            List.of("Thirumalai.Nambi@yahoo.com", "Azhwarkadiyan_Nambi@gmail.com"), 
            Map.of("dateOfBirth",
            LocalDate.of(1015, 6, 28)));
        assertTrue (mySqlService.createContactBook(phoneBookName));
        assertTrue (mySqlService.writeContacts(contactBean, phoneBookName));
        assertTrue (mySqlService.contactExists("Nambi", "lake cleaning group"));
        assertFalse (mySqlService.writeContacts(contactBean, phoneBookName));
        // assertEquals(List.of(contactBean),mySqlService.readContact(phoneBookName));
        // assertTrue (mySqlService.deleteContact("Arulmozhi.Varman@gmail.com", phoneBookName));
    }

    @Test
    public void testReadContact() {
        String phoneBookName = "South Army";
        ContactBean contactBean = new ContactBean(
            new Name(Gender.M, "Arulmozhi Varman", "Arul"), 
            List.of("9532142666", "4266695321"), 
            "No 95, Viharam road, Anuradhapuram, Srilanka - 321579", 
            List.of("army","asia", "chola"), 
            List.of("Arulmozhi.Varman@gmail.com", "Varman.Arulmozhi@gmail.com"), 
            Map.of("dateOfBirth",
            LocalDate.of(2023, 2, 14)));
        assertTrue (mySqlService.createContactBook(phoneBookName));
        assertTrue (mySqlService.writeContacts(contactBean, phoneBookName));
        assertTrue (mySqlService.contactExists("arulmozhi varman", "lake cleaning group"));
        
        contactBean = new ContactBean(
            new Name(Gender.M, "Vallavan Vandiyathevan", "Vandi"), 
            List.of("1429532666", "5324266691"), 
            "No 49, Beach palace road, Naagaipattinam, India - 503205", 
            List.of("army","asia" ,"prince", "chola"), 
            List.of("Aditha.Karikalan@ymail.com", "Karikalan_Adi@hotmail.com"), 
            Map.of("dateOfBirth",
            LocalDate.of(1022, 2, 14)));
        assertTrue (mySqlService.createContactBook(phoneBookName));
        assertTrue (mySqlService.writeContacts(contactBean, phoneBookName));
        assertFalse (mySqlService.contactExists("Aditha", "lake cleaning group"));
        assertTrue (mySqlService.contactExists("Varman", "south army"));
        assertFalse (mySqlService.writeContacts(contactBean, phoneBookName));
        assertFalse (mySqlService.writeContacts(contactBean, phoneBookName));
        assertTrue (mySqlService.contactExists("Aditha%", "lake cleaning group"));
        // assertEquals(List.of(contactBean),mySqlService.readContact(phoneBookName));
        // assertTrue (mySqlService.deleteContact("Arulmozhi.Varman@gmail.com", phoneBookName));
    }

    @Test
    public void testUpdateContacts() {
        fail("Not yet Implemented");
    }


}
