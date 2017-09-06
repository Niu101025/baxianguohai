package com.niu.yumao.utils;

public class StrUtils {

    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        if ("null".equalsIgnoreCase(str))
            return true;
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(String str) {
//	        return str == null || str.length() == 0;
        return isBlank(str);
    }

    public static boolean isNotEmpty(String str) {
        return !StrUtils.isEmpty(str);
    }

    public static boolean isNotBlank(String str) {
        return !StrUtils.isBlank(str);
    }
}
