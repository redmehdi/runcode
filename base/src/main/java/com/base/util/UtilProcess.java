package com.base.util;

import static org.apache.commons.lang3.Validate.matchesPattern;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.validator.routines.EmailValidator;

import com.base.exception.ValidationException;

public final class UtilProcess {

	private static final char SEPARATOR = '.';

	private static final char GROUPING_SEPARATOR = ',';

	private static final String _0_0 = "#,##0.0#";

	public static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

	public static final String PHONE_REGEX = "(\\+34|0034|34)?[ -]*(6|7)[ -]*([0-9][ -]*){8}";

	/**
	 * string to long in case differ then number type will be null in any case
	 * 
	 * @param number
	 * @return number or null
	 */
	public static Long stringToLong(final String number) {
		try {
			return Long.parseLong(number);
		}
		catch (NumberFormatException e) {
			return null;
		}
	}

	public static BigDecimal stringToBigDecimal(final String number) {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setGroupingSeparator(GROUPING_SEPARATOR);
		symbols.setDecimalSeparator(SEPARATOR);

		// Pattern for bigDecimal
		DecimalFormat decimalFormat = new DecimalFormat(_0_0, symbols);
		decimalFormat.setParseBigDecimal(true);
		
		// parse the string and positive always
		try {
			final BigDecimal parse = (BigDecimal) decimalFormat.parse(number);
			return parse.abs();
		}
		catch (ParseException e) {
			return null;
		}

	}

	public static String validateEmail(final String email) throws ValidationException {
		matchesPattern(email, EMAIL_REGEX, "invalid email");
		EmailValidator validator = EmailValidator.getInstance();
		if (email == null || email.equals("") || !validator.isValid(email)) {
			throw new ValidationException("Please enter the email correctly");
		}
		return email;
	}

	public static String validatePhone(final String phone) throws ValidationException {
		matchesPattern(phone, PHONE_REGEX, "invalid phone number");
		if (phone == null || phone.equals("")) {
			throw new ValidationException("Please enter the phone number correctly");
		}
		return phone;
	}

	/**
	 * @param date
	 * @return {@link Date}
	 * @throws ParseException
	 */
	public final static Date stringToDate(final String date) throws ParseException {
		return new SimpleDateFormat("dd/MM/yyyy").parse(date);
	}

	/**
	 * @return
	 */
	public final static String generateId() {
		return UUID.randomUUID().toString();
	}

	/**
	 * @param amount
	 * @param balance
	 * @return
	 */
	public static final BigDecimal discountMoney(final BigDecimal amount, final BigDecimal balance) {
		return balance.subtract(amount);
	}

}
