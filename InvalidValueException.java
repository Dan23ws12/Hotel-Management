
/*
 * This exception is thrown whenever a user types in an invalid value for any parameter, 
 * example "" for id or first name
*/

public class InvalidValueException extends Exception {

    private String param;
    private String badValue;

    public InvalidValueException(String parameter, String badValue) {
        this.param = parameter;
        this.badValue = badValue;
    }

    public InvalidValueException() {

    }

    public InvalidValueException(String badValue) {
        this.badValue = badValue;
    }

    @Override
    public String toString() {
        if (this.badValue == null) {
            return "null is an invalid option for any parameter";
        }
        if (this.badValue.equals("")) {
            return "an empty string is an invalid option for any parameter";
        }
        return String.format("%s is an invalid option for %s", this.badValue, this.param);
    }
}
