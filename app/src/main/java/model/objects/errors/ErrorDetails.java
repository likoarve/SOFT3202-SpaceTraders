package model.objects.errors;

public class ErrorDetails {
    public String message;
    public int code;

    public String toString() {
        return String.format("%s\n(Error code: %s)", message, code);
    }
}
