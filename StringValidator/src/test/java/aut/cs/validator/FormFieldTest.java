package aut.cs.validator;


import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class FormFieldTest {
    static FormField nameField;
    static FormField emailField;

    @BeforeAll
    public static void beforeClass() throws Exception {
        ArrayList<StringValidator> validators = new ArrayList<StringValidator>();
        validators.add(new LengthValidator(-1, 5));
        validators.add(new LengthValidator(3, -1));
        nameField = new FormField("nameField", validators);

        ArrayList<StringValidator> v = new ArrayList<>();
        //--------------
        v.add(new EmailValidator());
        v.add(new LengthValidator(0, 20));
        //--------------
        emailField = new FormField("emailField", v);
    }

    @Test
    public void incorrectNameForm() {
        ArrayList<String> errors = nameField.setValue("12");
        System.out.println(errors.toString());
        assertFalse(errors.isEmpty());

        errors = nameField.setValue("abcdefg");
        System.out.println(errors.toString());
        assertFalse(errors.isEmpty());
    }

    @Test
    public void correctEmailForm() {
        ArrayList<String> errors = emailField.setValue("ni@g.com");
        assertTrue(errors.isEmpty());
        errors = emailField.setValue("something@mail.com");
        assertTrue(errors.isEmpty());
    }

    @Test
    public void incorrectEmailForm() {
        ArrayList<String> errors = emailField.setValue("zaki.arab.ac.ir");
        assertFalse(errors.isEmpty());

        errors = emailField.setValue("something@somemail.com");
        assertFalse(errors.isEmpty());

        errors = emailField.setValue("___@.ir");
        assertFalse(errors.isEmpty());

        errors = emailField.setValue("bbc@__a__.ir");
        assertFalse(errors.isEmpty());

        errors = emailField.setValue("something@somelongmail.com");
        assertFalse(errors.isEmpty());
    }

    @Test
    public void correctNameForm() {
        ArrayList<String> errors = nameField.setValue("123");
        System.out.println(errors.toString());
        assertTrue(errors.isEmpty());

        errors = nameField.setValue("abcd");
        System.out.println(errors.toString());
        assertTrue(errors.isEmpty());

        errors = nameField.setValue("abcde");
        assertTrue(errors.isEmpty());
    }
}
