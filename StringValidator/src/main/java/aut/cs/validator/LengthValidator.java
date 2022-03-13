package aut.cs.validator;


public class LengthValidator extends StringValidator {
    private int maxCharacters;
    private int minCharacters;

    /**
     * @param minCharacters minimum characters, should be -1 if you want to set no limit
     * @param maxCharacters maximum characters, should be -1 if you want to set no limit
     */
    public LengthValidator(int minCharacters, int maxCharacters) {
        this.maxCharacters = maxCharacters;
        this.minCharacters = minCharacters;
    }


    /**
     * @param string input string
     * @return true if string length is in range [minCharacters,maxCharacters] (including both)
     */
    @Override
    public boolean validate(String string) {
        int length = string.length();
        if (maxCharacters >= 0) {
            if (length > maxCharacters)
                return false;
        }
        if (minCharacters >= 0) {
            if (length < minCharacters) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getMessage() {
        return String.format("String length is not between [%d,%d]", this.minCharacters, this.maxCharacters);
    }
}
