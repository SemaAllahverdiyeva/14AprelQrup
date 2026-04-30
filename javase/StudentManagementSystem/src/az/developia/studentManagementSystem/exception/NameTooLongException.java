package az.developia.studentManagementSystem.exception;

public class NameTooLongException extends RuntimeException {
	private String message;

	public NameTooLongException(String myMessage) {
		this.message = myMessage;
	}

	public String getMessage() {
		return message;
	}
}
