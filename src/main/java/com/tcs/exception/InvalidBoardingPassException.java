package com.tcs.exception;

public class InvalidBoardingPassException  extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidBoardingPassException(String msg) {
		super(msg);
	}

}
