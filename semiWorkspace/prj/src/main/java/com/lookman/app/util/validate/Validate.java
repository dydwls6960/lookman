package com.lookman.app.util.validate;

public class Validate {

	public static boolean isValidNumber(String numberStr) {
		try {
			Integer.parseInt(numberStr);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
