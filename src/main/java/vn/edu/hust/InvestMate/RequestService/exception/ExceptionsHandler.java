package vn.edu.hust.InvestMate.RequestService.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Date;
import java.util.Objects;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(TransactionException.class)
	public ResponseEntity<Object> handleTransactionException(TransactionException exception, WebRequest request) {
		return handleExceptionInternal(exception, null, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(TransactionValidationException.class)
	public ResponseEntity<Object> handleTransactionValidationException(TransactionValidationException exception, WebRequest request) {
		return handleExceptionInternal(exception, null, new HttpHeaders(), HttpStatus.OK, request);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleUnwantedException(Exception e) {
		logger.error(e.getMessage());
		return ResponseEntity.status(500).body("Unknown error!");
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
		return ResponseEntity
				.status(statusCode)
				.headers(headers)
				.body(Objects.nonNull(body) ? body : ExceptionResponseDTO.of((HttpStatus) statusCode, ex.getMessage(), new Date()));
	}


	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		return super.handleNoHandlerFoundException(ex, headers, status, request);
	}
}
