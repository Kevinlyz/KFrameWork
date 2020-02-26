package com.kevinlyz.common.util;

import org.apache.commons.lang3.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
/**
 * 日期工具类
 *
 * @author kevinlyz
 * @version 1.0
 * @date 2020-02-26 19:47
 */
public abstract class DateUtil {


    public static final String DEF_DATE_FORMAT              = "yyyy-MM-dd";

    public static final String DEF_TIME_FORMAT              = "HH:mm:ss";

    public static final String DEF_DATETIME_FORMAT          = "yyyy-MM-dd HH:mm:ss";

    public static final String DEF_DATETIME_DAY_BEGIN_FORMAT= "yyyy-MM-dd 00:00:00";

    public static final String DEF_DATETIME_DAY_END_FORMAT  = "yyyy-MM-dd 23:59:59";

    public static final String DEF_FULL_FORMAT              = "yyyy-MM-dd HH:mm:ss:SS";

    public static final String DEF_NOSING_MONTH_FORMAT      = "yyyyMM";

    public static final String DEF_NOSING_DATE_FORMAT       = "yyyyMMdd";

    public static final String DEF_NOSING_DATETIME_FORMAT   = "yyyyMMddHHmmss";

    public static final String DEF_CHINESE_DATETIME_FORMAT  = "yyyy年MM月dd日 hh点mm分ss秒";

    public static final ZoneId ZONE_ID                      = ZoneId.of("Asia/Shanghai");

    public static final ZoneOffset OFFSET                   = ZoneOffset.of("+8");

    public static final String DATE_FORMAT                  = "yyyy/MM/dd";

    public static final String DEF_CHINESE_DATE_FORMAT      = "yyyy年MM月dd日";

    public static final String DEF_CHINESE_YEARMONTH_FORMAT      = "yyyy年MM月";

    public static final String DEF_NOSING_SECOND_FORMAT     = "yyyy-MM-dd HH:mm";

    public static Structure parse(String date, String pattern) {
        return parse(parseDate(date, pattern));
    }

    public static Structure parse() {
        return parse(LocalDate.now());
    }

    public static Structure parse(LocalDate date) {
        return new Structure(date);
    }

    public static Structure parse(LocalDateTime dateTime) {
        return new Structure(dateTime);
    }

    public static String formatNow(String pattern) {
        return format(LocalDateTime.now(), pattern);
    }

    public static String format(LocalDateTime dateTime, String pattern) {

        return DateTimeFormatter.ofPattern(pattern).format(dateTime);
    }

    public static String format(LocalDate date, String pattern) {

        return DateTimeFormatter.ofPattern(pattern).format(date);
    }

    public static LocalDateTime currBeginDateTime() {

        return LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
    }

    public static LocalDateTime beginDateTime(LocalDate date) {

        return LocalDateTime.of(date, LocalTime.MIN);
    }

    public static LocalDateTime currEndDateTime() {

        return LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
    }

    public static LocalDateTime endDateTime(LocalDate date) {

        return LocalDateTime.of(date, LocalTime.MAX);
    }

    public static LocalDateTime currMonthBeginDateTime() {

        return LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth());
    }

    public static LocalDateTime currMonthEndDateTime() {

        return LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth());
    }

    public static LocalDateTime dateTimeOffset(ChronoUnit unit, long offset) {

        return LocalDateTime.now().plus(offset, unit);
    }

    public static LocalDate dateOffset(ChronoUnit unit, long offset) {

        return LocalDate.now().plus(offset, unit);
    }

    public static LocalDateTime dateTimeOffset(LocalDateTime dateTime, ChronoUnit unit, long offset) {

        return dateTime.plus(offset, unit);
    }

    public static LocalDate dateOffset(LocalDate date, ChronoUnit unit, long offset) {

        return date.plus(offset, unit);
    }

    public static LocalDateTime parseDateTime(String dateTime, String pattern) {

        return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(pattern));
    }

    public static long dateInterval(LocalDate startDate, LocalDate endDate) {

        return endDate.toEpochDay() - startDate.toEpochDay();
    }

    public static long dateIntervalNow(LocalDate date) {

        return Math.abs(LocalDate.now().toEpochDay() - date.toEpochDay());
    }

    public static LocalDate parseDate(String date, String pattern) {

        return LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDateTime parseDateTime(long mills) {

        return LocalDateTime.ofInstant(Instant.ofEpochMilli(mills), ZONE_ID);
    }

    public static long toMilliSeconds(LocalDateTime localDateTime) {

        return localDateTime.toInstant(OFFSET).toEpochMilli();
    }

    public static long toSeconds(LocalDateTime dateTime) {
        return toMilliSeconds(dateTime) / 1000;
    }

    public static long currTimestamp() {

        return System.currentTimeMillis();
    }

    public static long currSconds() {

        return currTimestamp() / 1000;
    }

    public static class Structure {

        public String year;

        public String month;

        public String day;

        public String hour;

        public String minute;

        public String second;

        public Structure(LocalDate date) {
            this.year   = String.valueOf(date.getYear());
            this.month  = StringUtils.leftPad(String.valueOf(date.getMonthValue()), 2, "0");
            this.day    = StringUtils.leftPad(String.valueOf(date.getDayOfMonth()), 2, "0");
        }

        public Structure(LocalDateTime dateTime) {
            this.year   = String.valueOf(dateTime.getYear());
            this.month  = String.valueOf(dateTime.getMonthValue());
            this.day    = String.valueOf(dateTime.getDayOfMonth());
            this.hour   = String.valueOf(dateTime.getHour());
            this.minute = String.valueOf(dateTime.getMinute());
            this.second = String.valueOf(dateTime.getSecond());
        }

        @Override
        public String toString() {
            return "Structure{" +
                    "year='" + year + '\'' +
                    ", month='" + month + '\'' +
                    ", day='" + day + '\'' +
                    ", hour='" + hour + '\'' +
                    ", minute='" + minute + '\'' +
                    ", second='" + second + '\'' +
                    '}';
        }
    }

}

