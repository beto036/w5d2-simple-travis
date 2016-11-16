package com.example.travissimple;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by admin on 11/16/2016.
 */

public class EmailUnitTest {
    @Test
    public void obfuscates_shortEmails() throws Exception{
        EmailObfuscator emailObfuscator = new EmailObfuscator();
        assertEquals(emailObfuscator.obfuscate("a@gmail.com"),"a***@gmail.com");
        assertEquals(emailObfuscator.obfuscate("ab@gmail.com"),"a***@gmail.com");
        assertEquals(emailObfuscator.obfuscate("abc@gmail.com"),"a***@gmail.com");
        assertNotEquals(emailObfuscator.obfuscate("a@gmail.com"),"a@gmail.com");
    }

    @Test
    public void obfuscates_longEmails() throws Exception{
        EmailObfuscator emailObfuscator = new EmailObfuscator();
        assertEquals(emailObfuscator.obfuscate("aaaa@gmail.com"),"a**a@gmail.com");
        assertEquals(emailObfuscator.obfuscate("abbbb@yahoo.com"),"a***b@yahoo.com");
        assertEquals(emailObfuscator.obfuscate("abcccch@gmail.com"),"a***h@gmail.com");
    }
}
