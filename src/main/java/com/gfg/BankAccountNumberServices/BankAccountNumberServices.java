package com.gfg.BankAccountNumberServices;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankAccountNumberServices {
    public boolean isValidAccountNumberMethod1(String accountNumber) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            return false;
        }
        try {
            Long.parseLong(accountNumber);
            if (accountNumber.length() == 14) {
                return !accountNumber.equals("00000000000000");
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }

    public boolean isValidAccountNumberMethod2(String accountNumber) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            return false;
        }
        if (accountNumber.length() == 14) {
            int count = 0;
            for (char ch : accountNumber.toCharArray()) {
                if (!Character.isDigit(ch)) return false;
                if (ch == '0') count++;
            }
            return count != 14;
        }
        return false;
    }

    public boolean isValidAccountNumberUsingRegularExpression(String accountNumber) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            return false;
        }
        if (accountNumber.length() == 14) {
            Pattern pattern = Pattern.compile("[0-9]+");
            Matcher matcher = pattern.matcher(accountNumber);
            if (matcher.matches()) {
                return !accountNumber.equals("00000000000000");
            }
        }
        return false;
    }
}
