package com.employeemanagementsystem.exception;
import com.employeemanagementsystem.entities.Employees;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.NoSuchElementException;

@ControllerAdvice
public class EmployeeExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeListEmptyException.class)
    public ResponseEntity<Object> HandleException()
    {

        return new ResponseEntity<>("Employees list is empty ", HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler({NoSuchElementException.class,EmployeeNotFoundException.class})
    public ResponseEntity<String> HandleNoSuchElementException()
    {

        return new ResponseEntity<>("No Employee details found with the employeeId " , HttpStatus.NOT_FOUND);

    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        return new ResponseEntity<>("Requested method not supported..Change the request type " , HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<String> HandleNumberFormatException()
    {

        return new ResponseEntity<>("The datatype specifying is not allowed.... " , HttpStatus.BAD_REQUEST);

    }

}
