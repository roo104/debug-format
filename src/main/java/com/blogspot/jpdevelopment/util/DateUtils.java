/**
 * Copyright Schantz A/S, all rights reserved
 */
package com.blogspot.jpdevelopment.util;

import java.sql.*;
import java.time.*;
import java.util.Date;

public class DateUtils {
	
	public static Date asDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}
	
	public static Timestamp asSqlDateTime(LocalDateTime localDateTime) {
		return Timestamp.valueOf(localDateTime);
	}
	
	public static Date asDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}
	
	public static LocalDate asLocalDate(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public static LocalDateTime asLocalDateTime(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
}