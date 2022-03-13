package aut.cs.validator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmailValidatorTest {
    private static EmailValidator emailValidator;

    @Test
    public void correct_email() {
        assertTrue(emailValidator.validate("zaki.arab@aut.ac.ir"));
        assertTrue(emailValidator.validate("something@gmail.com"));
    }

    @Test
    public void incorrect_email(){
        assertFalse(emailValidator.validate("zaki.arab.ac.ir"));
        assertFalse(emailValidator.validate("___@.ir"));
        assertFalse(emailValidator.validate("bbc@__a__.ir"));
    }

    @BeforeAll
    public static void beforeClass() throws Exception {
        emailValidator = new EmailValidator();
    }
}