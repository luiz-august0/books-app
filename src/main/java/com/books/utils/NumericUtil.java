package com.books.utils;

import java.math.BigDecimal;

public class NumericUtil {

    public static double round(Double valor) {
        return round(valor, 2);
    }

    public static double round(Double valor, Integer casas) {
        if (valor == null || valor.isNaN()) {
            valor = 0.0;
        }

        if (casas == null) {
            casas = 2;
        }

        BigDecimal big = new BigDecimal(valor.toString());
        big = big.setScale(casas, BigDecimal.ROUND_HALF_UP);
        return big.doubleValue();
    }

    public static BigDecimal round(BigDecimal valor) {
        return round(valor, 2);
    }

    public static BigDecimal round(BigDecimal valor, Integer casas) {
        if (valor == null) {
            valor = BigDecimal.ZERO.setScale(casas, BigDecimal.ROUND_HALF_UP);
        }
        if (casas == null) {
            casas = 2;
        }
        return valor.setScale(casas, BigDecimal.ROUND_HALF_UP);
    }

    public synchronized static boolean isEquals(BigDecimal one, BigDecimal other) {
        if (one != null && other == null) {
            return false;
        } else if (one == null && other != null) {
            return false;
        } else {
            return one.compareTo(other) == 0;
        }

    }

    public synchronized static boolean isGreater(Number number, Number compareTo) {
        return number != null && number.doubleValue() > compareTo.doubleValue();
    }

    public synchronized static boolean isGreaterOrEquals(Number number, Number compareTo) {
        return number != null && number.doubleValue() >= compareTo.doubleValue();
    }

    public synchronized static boolean isGreaterThanZero(Number number) {
        return isGreater(number, 0);
    }

    public synchronized static boolean isLess(Number number, Number compareTo) {
        return number != null && number.doubleValue() < compareTo.doubleValue();
    }

    public synchronized static boolean isLessOrEquals(Number number, Number compareTo) {
        return number != null && number.doubleValue() <= compareTo.doubleValue();
    }

    public synchronized static boolean isDifferent(Number number, Number compareTo) {
        return number != null && number.doubleValue() != compareTo.doubleValue();
    }

    public synchronized static boolean isEquals(Number number, Number compareTo) {
        return !isDifferent(number, compareTo);
    }

    public synchronized static boolean isLessThanZero(Number number) {
        return isLess(number, 0);
    }

    public synchronized static boolean isLessOrEqualsZero(Number number) {
        return isLessOrEquals(number, 0);
    }

    public synchronized static double getPercentage(double value, double percent) {
        value = value * (percent / 100);

        return value;
    }

    public synchronized static BigDecimal getPercentage(BigDecimal value, BigDecimal percent) {
        double percentage = getPercentage(value.doubleValue(), percent.doubleValue());
        return BigDecimal.valueOf(percentage);
    }

    public synchronized static BigDecimal getNotNullOrZero(BigDecimal value) {
        return value != null ? value : BigDecimal.ZERO;
    }

    public synchronized static Integer getNotNullOrZero(Integer value) {
        return value != null ? value : 0;
    }

    public synchronized static Double getNotNullOrZero(Double value) {
        return value != null ? value : 0.0;
    }

    public static BigDecimal min(BigDecimal a, BigDecimal b) {
        return BigDecimal.valueOf(Math.min(a.doubleValue(), b.doubleValue()));
    }

    public static BigDecimal max(BigDecimal a, BigDecimal b) {
        return BigDecimal.valueOf((Math.max(a.doubleValue(), b.doubleValue())));
    }

    public static boolean isNumeric(String str) {
        return str.matches("^-?[0-9]+(\\.[0-9]+)?$");
    }

    public synchronized static boolean isIntegerValue(Double value) {
        return value != null && value % 1 == 0;
    }

    public static boolean between(Number valor, Number inicio, Number fim) {
        if (valor == null || inicio == null || fim == null) {
            return false;
        }
        return valor.doubleValue() >= inicio.doubleValue() && valor.doubleValue() <= fim.doubleValue();
    }

    public static Integer parseInt(String strVal) {
        try {
            if (strVal != null) {
                return Integer.parseInt(strVal);
            }
        } catch (Exception ex) {
        }
        return null;
    }

    public static Long parseLong(String strVal) {
        try {
            if (strVal != null) {
                return Long.parseLong(strVal);
            }
        } catch (Exception ex) {
        }
        return null;
    }

    public static Integer parseInt(Object objVal) {
        if (objVal != null) {
            return parseInt(objVal.toString());
        }
        return null;
    }

    public static BigDecimal parseBigDecimal(Object objVal) {
        if (objVal != null) {
            return new BigDecimal(objVal.toString());
        }
        return null;
    }

    public synchronized static boolean isPositive(Number number) {
        return number != null && number.doubleValue() >= 0 ? true : false;
    }

    public synchronized static boolean isNegative(Number number) {
        return number != null && number.doubleValue() < 0 ? true : false;
    }

    public static BigDecimal getMaxBigDecimal() {
        int repeat = 100;
        String lotsOfNines = String.format("%0" + repeat + "d", 0).replace('0', '9');
        return new BigDecimal(lotsOfNines);
    }
}
