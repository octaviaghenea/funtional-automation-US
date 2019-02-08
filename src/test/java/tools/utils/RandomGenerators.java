package tools.utils;

public class RandomGenerators {

	public static enum Mode {
		ALPHA_CAPS, ALPHA, ALPHANUMERIC, NUMERIC, ALPHANUMERICSCHAR,
	}

	public static String generateRandomString(int length, Mode mode) {
		StringBuffer buffer = new StringBuffer();
		String characters = "";

		switch (mode) {
		case ALPHA_CAPS:
			characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			break;

		case ALPHA:
			characters = "abcdefghijklmnopqrstuvwxyz";
			break;

		case ALPHANUMERIC:
			characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			break;

		case NUMERIC:
			characters = "123456789";
			break;

		case ALPHANUMERICSCHAR:
			characters = "ab\'cdef'|}{[]:'?@#$%^&*! ,.ghi\"jklmn'opq++*";
			break;
		}

		int charactersLength = characters.length();
		for (int i = 0; i < length; i++) {
			double index = Math.random() * charactersLength;
			buffer.append(characters.charAt((int) index));
		}

		return buffer.toString();
	}
}