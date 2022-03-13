package aut.cs.validator;

import java.util.ArrayList;

public abstract class StringValidator {
    abstract public boolean validate(String string);

    public String getMessage() {
        return "String is not acceptable.";
    }
}
