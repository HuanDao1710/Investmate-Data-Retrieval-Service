package vn.edu.hust.InvestMate.RequestService.exception;

public class TransactionValidationException extends RuntimeException{
	public TransactionValidationException(String message) {
		super(message);
	}
}
