package aut.cs.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LengthValidatorTest {

    @Test
    public void justMin() {
        LengthValidator lengthValidator = new LengthValidator(3, -1);
        assertTrue(lengthValidator.validate("abc"));
        assertTrue(lengthValidator.validate("abcde"));
        assertFalse(lengthValidator.validate("ab"));
        assertFalse(lengthValidator.validate(""));
    }

    @Test
    public void justMax() {
        LengthValidator lengthValidator = new LengthValidator(-1, 4);
        assertTrue(lengthValidator.validate("abc"));
        assertFalse(lengthValidator.validate("abcde"));
        assertFalse(lengthValidator.validate("abdefghijklmn"));
        assertTrue(lengthValidator.validate(""));
    }

    @Test
    public void both() {
        LengthValidator lengthValidator = new LengthValidator(2, 4);
        assertTrue(lengthValidator.validate("ab"));
        assertTrue(lengthValidator.validate("abc"));
        assertTrue(lengthValidator.validate("1234"));
        assertFalse(lengthValidator.validate("abcde"));
        assertFalse(lengthValidator.validate("a"));
    }

    @Test
    public void none() {
        LengthValidator lengthValidator = new LengthValidator(-1,-1);
        assertTrue(lengthValidator.validate("ab"));
        assertTrue(lengthValidator.validate("abc"));
        assertTrue(lengthValidator.validate("1234"));
        assertTrue(lengthValidator.validate("abcde"));
        assertTrue(lengthValidator.validate(""));
    }
}