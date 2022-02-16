package fr.thmarie.parisf1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.thmarie.parisf1.payload.response.ApiResponse;

@ControllerAdvice
public class RestControllerExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseBody
	public ResponseEntity<ApiResponse> resolveException(ResourceNotFoundException exception) {
		ApiResponse apiResponse = exception.getApiResponse();

		return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
	}

}
