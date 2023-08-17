package com.registration.registrationpeople.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DocumentUtilsTest {

    @Test
    void shouldValidateCpfValid() {
        Assertions.assertTrue(DocumentUtils.isCPF("169.583.690-17"));
    }

    @Test
    void shouldValidateCPFInvalid() {
        Assertions.assertFalse(DocumentUtils.isCPF("11867164898"));
    }

    @Test
    void shouldValidateCNPJValid() {
        Assertions.assertTrue(DocumentUtils.isCNPJ("87.851.861/0001-61"));
    }

    @Test
    void shouldValidateCNPJInvalid() {
        Assertions.assertFalse(DocumentUtils.isCNPJ("87.851.861/0002-62"));
    }

}
