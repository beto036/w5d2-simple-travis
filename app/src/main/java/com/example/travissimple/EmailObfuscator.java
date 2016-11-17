package com.example.travissimple;

/**
 * Created by admin on 11/16/2016.
 */
public class EmailObfuscator {

    public String obfuscate(String s) {
        String result = "";
        String domain = s.substring(0, s.lastIndexOf("@"));
        String rest = s.substring(s.lastIndexOf("@"), s.length());
        if(domain.length() < 4) domain = domain.charAt(0) + "***";
        else domain = domain.charAt(0) + "***" + domain.charAt(domain.length()-1);
        result = domain + rest;
        return result;
    }

    public static void main(String[] args) {
        EmailObfuscator emailObfuscator = new EmailObfuscator();
        System.out.println(emailObfuscator.obfuscate("a@gmal.com"));
    }
}
