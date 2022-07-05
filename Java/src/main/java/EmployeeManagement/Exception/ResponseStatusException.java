package EmployeeManagement.Exception;

public class ResponseStatusException extends Exception {
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    String errorMessage;

    public ResponseStatusException(String message) {
        this.errorMessage = message;
    }
}
