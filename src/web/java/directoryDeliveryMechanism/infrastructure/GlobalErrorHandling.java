package directoryDeliveryMechanism.infrastructure;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import directoryDeliveryMechanism.view.ApiResponse;

@ControllerAdvice
public class GlobalErrorHandling {
    @ExceptionHandler
	public ResponseEntity<ApiResponse> handleError(UserPrincipalNotFoundException ex) {
        return new ResponseEntity<>(new ApiResponse(true, Arrays.asList("payload 1", "payload 2")), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ResponseEntity<ApiResponse> handleGeneralError(Exception ex) {
        System.out.println("FROMMMMMMMMM");
        return new ResponseEntity<>(new ApiResponse(true, Arrays.asList("general exception")), HttpStatus.BAD_REQUEST);
    }

}
