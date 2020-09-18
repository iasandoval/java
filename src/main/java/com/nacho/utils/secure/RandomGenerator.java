package com.nacho.utils.secure;

import org.junit.Assert;
import org.junit.Test;

import java.security.SecureRandom;
import java.util.regex.Pattern;

public class RandomGenerator {

    @Test
    public void test() {

        RandomGenerator r = new RandomGenerator();

        for(int i = 0; i<100; i++) {
            System.out.println(r.generatePIN());
        }
    }

    @Test
    public void testPhone() {
        RandomGenerator r = new RandomGenerator();

        Assert.assertTrue(r.isValidPhone(123456789));
    }

    @Test
    public void testPhone1() {
        RandomGenerator r = new RandomGenerator();

        Assert.assertTrue(r.isValidPhone("123456789"));
    }

    @Test
    public void testEmail() {
        RandomGenerator r = new RandomGenerator();

        Assert.assertTrue(r.isValidEmail(""));
    }

    @Test
    public void maskEmail() {
        String email = "nacho1@saii.com.mx.com".replaceAll("(^[^@]{3}|(?!^)\\G)[^@]", "$1*");

        System.out.println(email);
    }

    @Test
    public void maskPhone() {

        String phone = "1234567890";

        String formattedPhone = phone.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");

        String  phoneNum = formattedPhone.replaceAll("\\d(?=(?:\\D*\\d){4})", "*");

        System.out.println(phoneNum);
    }


    private String generatePIN() {
        //byte[] seed = new byte[128];
        return String.format("%06d", new SecureRandom().nextInt(999999));
    }

    private boolean isValidPhone(int phone) {
        Pattern phonePattern = Pattern.compile("^(\\d{10})$");

        boolean valid = Boolean.FALSE;

        return phonePattern.matcher(String.valueOf(phone)).matches();
    }

    private boolean isValidPhone(String phone) {
        Pattern phonePattern = Pattern.compile("^(\\d{10})$");

        boolean valid = Boolean.FALSE;

        return phonePattern.matcher(phone).matches();
    }

    private boolean isValidEmail(String email) {
        Pattern emailPattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");

        boolean valid = Boolean.FALSE;

        return emailPattern.matcher(email).matches();
    }

}
