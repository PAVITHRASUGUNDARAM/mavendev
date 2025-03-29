package com.gfg.BankAccountNumberServices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestBankAccountNumberServices {
    BankAccountNumberServices service = new BankAccountNumberServices();

    @DisplayName("Test check for Invalid bank account")
    @Test
    public void testInvalidAccountNumbers() {
        assertEquals(false, service.isValidAccountNumberMethod1(null));
        assertEquals(false, service.isValidAccountNumberMethod1(""));
        assertEquals(false, service.isValidAccountNumberMethod1("00000000000000"));
        assertEquals(false, service.isValidAccountNumberMethod1("1234567"));
        assertEquals(false, service.isValidAccountNumberMethod2("00000000000000"));
        assertEquals(false, service.isValidAccountNumberUsingRegularExpression("SA123450000000"));
    }

    @DisplayName("Test check for Valid bank account")
    @Test
    public void testValidAccountNumbers() {
        assertEquals(true, service.isValidAccountNumberMethod1("12345678901234"));
        assertEquals(true, service.isValidAccountNumberMethod2("11022033012346"));
        assertEquals(true, service.isValidAccountNumberUsingRegularExpression("11223344551234"));
    }
}
