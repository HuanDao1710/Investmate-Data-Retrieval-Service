package vn.edu.hust.InvestMate.RequestService.utils;
import java.time.*;

public class TimeUtils {
	public static Long getStartOfDay() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime oneAM = LocalDateTime.of(now.toLocalDate(), LocalTime.of(1, 0));
		Instant instant = oneAM.atZone(ZoneId.systemDefault()).toInstant();
		return instant.getEpochSecond();
	}

	public static Long getEndOfDay() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime oneAM = LocalDateTime.of(now.toLocalDate(), LocalTime.of(18, 0));
		Instant instant = oneAM.atZone(ZoneId.systemDefault()).toInstant();
		return instant.getEpochSecond();
	}

	public static Long getStartOfDay(long time) {
		// Chuyển đổi epoch seconds thành LocalDateTime
		LocalDateTime dateTime = Instant.ofEpochSecond(time).atZone(ZoneOffset.ofHours(7)).toLocalDateTime();

		// Lấy ngày bắt đầu của ngày
		LocalDateTime startOfDay = dateTime.toLocalDate().atStartOfDay();

		// Chuyển đổi lại thành epoch seconds
		return startOfDay.toEpochSecond(ZoneOffset.ofHours(7));
	}

	public static Long getEndOfDay(long time) {
		// Chuyển đổi epoch seconds thành LocalDateTime
		LocalDateTime dateTime = Instant.ofEpochSecond(time).atZone(ZoneOffset.ofHours(7)).toLocalDateTime();

		// Lấy ngày bắt đầu của ngày
		LocalDateTime startOfDay = dateTime.toLocalDate().atTime(23, 55);

		// Chuyển đổi lại thành epoch seconds
		return startOfDay.toEpochSecond(ZoneOffset.ofHours(7));
	}

	public static int getCurrentYear() {
		return Year.now().getValue();
	}
}
