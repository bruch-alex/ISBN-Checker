package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateISBN {
    Pattern pattern = Pattern.compile("[a-zA-Z]");
    Matcher matcher;

    public boolean validate(String isbn) {
        if (containsLetters(isbn)) throw new NumberFormatException("ISBN can contain only numbers");

        if (!isSizeValid(isbn)) return false;

        if (isbn.length() == 10) return checkISBN10(isbn);
        else return checkISBN13(isbn);
    }

    private boolean containsLetters(String isbn) {
        matcher = pattern.matcher(isbn);
        return matcher.find();
    }

    private boolean isSizeValid(String isbn) {
        return isbn.length() == 13 || isbn.length() == 10;
    }

    private boolean checkISBN10(String isbn) {
        int total = 0;
        for (int i = 0; i < 10; i++) {
            total += Character.getNumericValue(isbn.charAt(i)) * (10 - i);
        }
        return total % 11 == 0;
    }

    private boolean checkISBN13(String isbn) {
        int total = 0;
        for (int i = 0; i < 12; i++) {
            if ((i + 1) % 2 != 0) {
                total += Character.getNumericValue(isbn.charAt(i));
            } else total += Character.getNumericValue(isbn.charAt(i)) * 3;
        }
        int r = 10 - (total % 10);
        int lastDigit = r == 10 ? 0 : r;
        return lastDigit == Character.getNumericValue(isbn.charAt(12));
    }
}