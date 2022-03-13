package aut.cs.validator;

import java.text.Normalizer;
import java.util.ArrayList;


public class FormField {
    public ArrayList<StringValidator> validators;
    public String name;
    private String value;

    public FormField(String fieldName, ArrayList<StringValidator> validators) {
        this.validators = validators;
        this.name = fieldName;
        this.value = null;
    }

    /**
     * @param value if no,error happens value is set;
     * @return errros
     */
    public ArrayList<String> setValue(String value) {
        ArrayList<String> errors = new ArrayList<>();
        for (StringValidator validator : this.validators) {
            if (!validator.validate(value))
                errors.add(validator.getMessage());
        }
        if (errors.isEmpty())
            this.value = value;
        return errors;
    }

    public String getValue() {
        return value;
    }

    public static void main(String[] args) {
        // we collect errors in this ArrayList
        ArrayList<String> errors;
        // name should be at least 3 and at most 20 characters
        ArrayList<StringValidator> nameValidators = new ArrayList<>();
        nameValidators.add(new LengthValidator(3, 10));
        FormField nameField = new FormField("name", nameValidators);


        errors = nameField.setValue("ab");
        System.out.println("errors for string \"ab\"");
        System.out.println(errors.toString());

        errors = nameField.setValue("12345678901");
        System.out.println("errors for string \"12345678901\"");
        System.out.println(errors.toString());

        errors = nameField.setValue("majid");
        if (errors.isEmpty()) {
            System.out.printf("no errors, field value is \"%s\"\n", nameField.getValue());
        }

        //email should be an email address and at most 12 characters
        ArrayList<StringValidator> emailValidators = new ArrayList<>();
        emailValidators.add(new EmailValidator());
        emailValidators.add(new LengthValidator(-1, 11));
        FormField emailField = new FormField("email", emailValidators);

        System.out.println("Testing emailField:");

        errors = emailField.setValue("lorem@gmail");
        System.out.println("errors for string \"loremipsum@gmail.com\"");
        System.out.println(errors.toString());

        errors = emailField.setValue("b@gmail.com");

        if (errors.isEmpty()) {
            System.out.printf("no errors, field value is \"%s\"\n", emailField.getValue());
        }


    }
}
