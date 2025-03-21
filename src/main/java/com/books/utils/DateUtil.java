package com.books.utils;

import com.books.utils.enums.EnumDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class DateUtil {

    public static final String TIMEZONE = "America/Sao_Paulo";

    public static final ZoneId ZONE_ID = ZoneId.of(TIMEZONE);

    public static final Locale LOCALE_BRAZIL = new Locale("pt", "BR");

    private static final SimpleDateFormat DDMMYYYY = EnumDateFormat.DDMMYYYY.getFormat();

    private static final SimpleDateFormat HHMM = EnumDateFormat.HHMM.getFormat();

    private static final SimpleDateFormat DDMMHHMM = EnumDateFormat.DDMMHHMM.getFormat();
    private static final SimpleDateFormat DDMMYYHHMM = EnumDateFormat.DDMMYYHHMM.getFormat();
    private static final SimpleDateFormat DDMMYYYYHHMM = EnumDateFormat.DDMMYYYYHHMM.getFormat();
    private static final SimpleDateFormat DDMMYYYYHHMMSS = EnumDateFormat.DDMMYYYYHHMMSS.getFormat();
    private static final SimpleDateFormat YYYYMMDDHHMMSS = EnumDateFormat.YYYYMMDDHHMMSS.getFormat();
    private static final SimpleDateFormat YYYYMMDD = EnumDateFormat.YYYYMMDD.getFormat();
    private static final SimpleDateFormat HHMMSS = EnumDateFormat.HHMMSS.getFormat();

    public static String format(EnumDateFormat dateFormat, Date date) {
        return date != null ? dateFormat.getFormat().format(date) : "";
    }

    public static String formatHHMM(Date date) {
        return date != null ? HHMM.format(date) : "";
    }

    public static String formatDDMMYYYY(Date date) {
        return date != null ? DDMMYYYY.format(date) : "";
    }

    public static String formatYYYYMMDDHHMMSS(Date date) {
        return date != null ? YYYYMMDDHHMMSS.format(date) : "";
    }

    public static String formatYYYYMMDD(Date date) {
        return date != null ? YYYYMMDD.format(date) : "";
    }

    public static String formatDDMMYYYYHHMMSS(Date date) {
        return date != null ? DDMMYYYYHHMMSS.format(date) : "";
    }

    public static String formatDDMMYYYYHHMM(Date date) {
        return date != null ? DDMMYYYYHHMM.format(date) : "";
    }

    public static String formatDDMMYYHHMM(Date date) {
        return date != null ? DDMMYYHHMM.format(date) : "";
    }

    public static String formatHHMMSS(Date date) {
        return date != null ? HHMMSS.format(date) : "";
    }

    public static String toTimezoneZero(Date date) {
        HHMMSS.setTimeZone(TimeZone.getTimeZone("UTC"));
        return HHMMSS.format(date);
    }

    public static Date parse(Date date, EnumDateFormat dateFormat) {
        try {
            if (dateFormat == null) {
                dateFormat = EnumDateFormat.YYYYMMDDTHHMMSS;
            }

            final String strDateFormat = dateFormat.format(date);

            return dateFormat.parse(strDateFormat);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static LocalTime toLocalTime(Date date) {
        return date.toInstant().atZone(ZONE_ID).toLocalTime();
    }

    public static LocalDate toLocalDate(Date date) {
        return date.toInstant().atZone(ZONE_ID).toLocalDate();
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        return date.toInstant().atZone(ZONE_ID).toLocalDateTime();
    }

    public static Integer calculateDifference(ChronoUnit unit, Date dateInicial, Date dateFinal) {
        final LocalDateTime ldInitial = toLocalDateTime(minSecond(dateInicial));
        final LocalDateTime ldFinal = toLocalDateTime(minSecond(dateFinal));

        return Math.toIntExact(unit.between(ldInitial, ldFinal));
    }

    public static Date getDate() {
        return getCalendar().getTime();
    }

    public static Calendar getCalendar() {
        return Calendar.getInstance(LOCALE_BRAZIL);
    }

    public static Calendar getCalendar(Date date) {
        final Calendar calendar = Calendar.getInstance(LOCALE_BRAZIL);
        calendar.setTime(date);
        return calendar;
    }

    public static int compareTo(Date dateInit, Date dateFinal) {
        return compareTo(dateInit, dateFinal, null);
    }

    public static int compareTo(Date dateInit, Date dateFinal, EnumDateFormat dateFormat) {
        if (dateInit == null) {
            dateInit = getDate();
        }

        if (dateFinal == null) {
            dateFinal = getDate();
        }

        dateInit = parse(dateInit, dateFormat);
        dateFinal = parse(dateFinal, dateFormat);

        return dateInit.compareTo(dateFinal);
    }

    public static Integer dayOfWeek(Date date) {
        if (date == null) {
            date = getDate();
        }

        return getCalendar(date).get(Calendar.DAY_OF_WEEK) - 1;
    }

    public static Date add(int calendarField, int amount) {
        return add(null, calendarField, amount);
    }

    public static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            date = getDate();
        }

        final Calendar calendar = getCalendar(date);
        calendar.add(calendarField, amount);

        return calendar.getTime();
    }

    public static Date subtract(int calendarField, int amount) {
        return subtract(null, calendarField, amount);
    }

    public static Date subtract(Date date, int calendarField, int amount) {
        return add(date, calendarField, -amount);
    }

    public static String formatMinutes(Integer minutes) {
        if (minutes < 60) {
            return minutes + " min";
        }

        final Integer hour = minutes / 60;
        final Integer minute = minutes - ((hour * 60 * 60) / 60);

        return hour + " h " + minute + " min";
    }

    public static Calendar getCalendarWithHour(final Date dateParameter, final Date dateWithHour) {
        final Calendar calendarHour = DateUtil.getCalendar(dateWithHour);

        final Calendar calendarDate = DateUtil.getCalendar(dateParameter);
        calendarDate.set(Calendar.HOUR_OF_DAY, calendarHour.get(Calendar.HOUR_OF_DAY));
        calendarDate.set(Calendar.MINUTE, calendarHour.get(Calendar.MINUTE));
        calendarDate.set(Calendar.SECOND, calendarHour.get(Calendar.SECOND));
        return calendarDate;
    }

    public static Calendar getCalendarWithDay(final Date dateParameter, final Date dateWithDay) {
        final Calendar calendarDay = DateUtil.getCalendar(dateWithDay);

        final Calendar calendarDate = DateUtil.getCalendar(dateParameter);
        calendarDate.set(Calendar.DAY_OF_MONTH, calendarDay.get(Calendar.DAY_OF_MONTH));
        calendarDate.set(Calendar.MONTH, calendarDay.get(Calendar.MONTH));
        calendarDate.set(Calendar.YEAR, calendarDay.get(Calendar.YEAR));
        return calendarDate;
    }

    public static boolean isToday(Date dateParameter) {
        return LocalDate.now().isEqual(toLocalDate(dateParameter));
    }

    public static boolean dateBetweenDates(Date dateParameter, Date dateBefore, Date dateAfter) {
        return !dateParameter.before(dateBefore) && dateParameter.after(dateAfter);
    }

    public static boolean isDateBetween(Date dateParameter, Date dateBefore, Date dateAfter) {
        return !dateParameter.before(dateBefore) && !dateParameter.after(dateAfter);
    }

    public static Date converterLongToDate(Long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time * 1000);
        return calendar.getTime();
    }

    public static String formatYYYYMMDDHHMMSS(Object date) {
        return date != null ? YYYYMMDDHHMMSS.format(date) : "";
    }

    public static Date formatStringToDate(String date, EnumDateFormat format) {
        try {
            if (date == null || format == null) {
                return null;
            }

            return format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isValidDate(String date, EnumDateFormat format) {
        try {
            if (date == null || format == null) {
                return false;
            }

            format.parse(date);
        } catch (ParseException e) {
            return false;
        }

        return true;
    }

    public static Date getLastDayOfMonth(Date date) {
        Calendar auxDate = Calendar.getInstance();
        auxDate.setTime(date);
        auxDate.set(Calendar.DAY_OF_MONTH, auxDate.getActualMaximum(Calendar.DAY_OF_MONTH));
        return maxHour(auxDate.getTime());

    }

    public static Date minSecond(final Date date) {
        final GregorianCalendar c = getGregorianCalendar(date);
        c.set(Calendar.SECOND, c.getActualMinimum(Calendar.SECOND));
        return c.getTime();
    }

    public static Date maxSecond(final Date date) {
        final GregorianCalendar c = getGregorianCalendar(date);
        c.set(Calendar.SECOND, c.getActualMaximum(Calendar.SECOND));
        return c.getTime();
    }

    public static Date minDay(final Date date) {
        final GregorianCalendar c = getGregorianCalendar(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        return c.getTime();
    }

    public static Date maxDay(final Date date) {
        final GregorianCalendar c = getGregorianCalendar(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return c.getTime();
    }

    private static GregorianCalendar getGregorianCalendar(final Date date) {
        final GregorianCalendar c = new GregorianCalendar();
        c.setTime(date);
        return c;
    }

    public static Date getFirstDayOfMonth(Date date) {
        Calendar initialDate = Calendar.getInstance();

        initialDate.setTime(date);

        initialDate.set(Calendar.DATE, 1);

        return minHour(initialDate.getTime());
    }

    public static Date maxHour(Date date) {
        if (date == null) {
            return null;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, cal.getActualMaximum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getActualMaximum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getActualMaximum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getActualMaximum(Calendar.MILLISECOND));

        return cal.getTime();
    }

    public static Date minHour(Date date) {
        if (date == null) {
            return null;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, cal.getActualMinimum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getActualMinimum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getActualMinimum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getActualMinimum(Calendar.MILLISECOND));

        return cal.getTime();
    }

    public static List<String> formatListToHHMM(List<Date> dates) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        List<String> hoursList = new ArrayList<>();
        for (Date date : dates) {
            String hours = formatter.format(date);
            hoursList.add(hours);
        }
        return hoursList;
    }

    public static Date getFinalDate() {
        LocalDate localDate = LocalDate.of(9999, 12, 30);
        ZoneId zoneId = ZoneId.systemDefault();
        return Date.from(localDate.atStartOfDay(zoneId).toInstant());
    }

    public static Date getSpecificTime(Date date, int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date updateDateWithCurrentTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        Calendar currentTime = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, currentTime.get(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, currentTime.get(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, currentTime.get(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, currentTime.get(Calendar.MILLISECOND));

        return calendar.getTime();
    }

    public static Date parseStringToDate(String strDate) {
        SimpleDateFormat formatter = EnumDateFormat.YYYYMMDDHHMMSS.getFormat();
        Date date = null;
        try {
            date = formatter.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
