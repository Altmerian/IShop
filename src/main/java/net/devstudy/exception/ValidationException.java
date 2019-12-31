package net.devstudy.exception;

public class ValidationException extends IllegalArgumentException {
	private static final long serialVersionUID = -6843925636139273536L;

	public ValidationException(String s) {
		super(s);
	}
}
