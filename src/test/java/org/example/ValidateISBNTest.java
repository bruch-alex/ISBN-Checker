package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidateISBNTest {

    /*
    Write a test to:
    (1) Check that "helloworld" gives a number format exception.
    (2) Check a valid and invalid 13 digit ISBN number.

    // checkAValid10DigitISBN
    // checkA10DigitInValidISBN
    // checkAValid13DigitISBN
    // checkA13DigitInValidISBN
    // nonNumericISBNIsNotAllowed
     */

    @Test
    public void checkNumberFormatException() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new ValidateISBN().validate("helloWorld");
        });
    }

    @Test
    public void checkValidISBN10() {
        Assertions.assertTrue(new ValidateISBN().validate("0593320964"), "Valid ISBN10");
    }

    @Test
    public void checkInvalidISBN10() {
        Assertions.assertFalse(new ValidateISBN().validate("0593320965"), "Invalid ISBN");
    }

    @Test
    public void checkValidISBN13() {
        Assertions.assertTrue(new ValidateISBN().validate("9780593320969"), "Valid ISBN13");
    }

    @Test
    public void checkInvalidISBN13() {
        Assertions.assertFalse(new ValidateISBN().validate("9780593320968"), "Invalid ISBN13");
    }

    @Test
    public void checkInvalidISBN_length9() {
        Assertions.assertFalse(new ValidateISBN().validate("978059332"), "Length 9");
    }

    @Test
    public void checkInvalidISBN_length15() {
        Assertions.assertFalse(new ValidateISBN().validate("978059332096812"), "Length 15");
    }
}