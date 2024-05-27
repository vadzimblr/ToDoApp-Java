package bsu.poznyak.projectmanagementapplication.models.Exceptions;

public class ValidationException extends Exception{
    public ValidationException(String exceptionMessage){
        super(exceptionMessage);
    }
}
