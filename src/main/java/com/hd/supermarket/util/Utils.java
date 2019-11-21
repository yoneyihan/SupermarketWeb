package com.hd.supermarket.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 综合工具类
 * @author 李金荣
 * @data 2017年12月2日
 */
public final class Utils {

    private Utils() {  }

    /** 0 */
    public final static Integer ZERO = Integer.valueOf(0);

    /** 1 */
    public final static Integer ONE = Integer.valueOf(1);

    /** 2 */
    public final static Integer TWO = Integer.valueOf(2);

    /** 100 */
    public final static BigDecimal HUNDRED = BigDecimal.valueOf(100);

    /**
     * 空字符串，""
     */
    public final static String EMPTY = "";

    /**
     * 空Map
     * <br><code>new HashMap<>()</code>
     */
    public final static Map<String, Object> EMPTY_MAP = new HashMap<>();

    /**
     * 判断集合是否为空
     * @param list
     * @return
     */
    public static boolean isEmpty(Collection<?> list) {
        return list == null || list.isEmpty();
    }

    /**
     * 判断数组是否为空
     * @param array
     * @return
     */
    public static <T> boolean isEmpty(T[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断字符串是否为空 <br>
     * str = null 	true<br>
     * str = ""   	true<br>
     * str = " " 	true<br>
     * str = " a " 	false<br>
     *
     * @param str 字符串
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    /**
     * 判断字符串不为空
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 判读集合是否为空
     * @param c
     * @return
     */
    public static boolean isNotEmpty(Collection<?> c) {
        return !isEmpty(c);
    }

    /**
     * 对象转字符串
     * @param o
     * @return
     */
    public static String toString(Object o) {
        return o == null ? null : o.toString();
    }

    /**
     * 是否为Null
     * @param input         输入
     * @param defaultValue  默认值
     * @param <T>
     * @return
     */
    public <T> T isNull(T input, T defaultValue){
        return input == null ? defaultValue : input;
    }

    /**
     * 数组合并
     * @param first  第一个
     * @param second 第二个
     * @return 新的数组
     */
    public static <T> T[] arrayConcat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    /**
     * 获取一个 Map
     *
     * @param k 键
     * @param v 值
     * @return
     */
    public static Map<String, Object> getMap(String k, Object v) {
        Map<String, Object> map = new HashMap<>();
        if (!isEmpty(k))
            map.put(k, v);
        return map;
    }

    /**
     * 大于大于零
     * @param v 比较值
     * @return
     */
    public static boolean greaterZero(Integer v) {
        return v != null && v.compareTo(ZERO) == 1;
    }

    /**
     * 大于零
     * @param v 比较值
     * @return
     */
    public static boolean greaterZero(BigDecimal v) {
        return v != null && v.compareTo(BigDecimal.ZERO) == 1;
    }

    /**
     * 大于零
     * @param v 比较值
     * @return
     */
    public static boolean greaterZero(Double v) {
        return v != null && v.compareTo(BigDecimal.ZERO.doubleValue()) == 1;
    }

    /**
     * Double 类型装换
     * @param str 字符
     * @return default 0.0
     */
    public static Double parseDouble(String str) {
        return Utils.isEmpty(str) ? ZERO.doubleValue() : Double.parseDouble(str);
    }

    /**
     * Integer 类型转换
     * @param str 字符
     * @return default 0
     */
    public static Integer parseInteger(String str) {
        return Utils.isEmpty(str) ? ZERO : Integer.valueOf(str);
    }

    /**
     * BigDecimal 转换
     * @param str 字符
     * @return default 0
     */
    public static BigDecimal parseBigDecimal(String str) {
        return Utils.isEmpty(str) ? BigDecimal.ZERO : new BigDecimal(str);
    }

    public static <T> BigDecimal bigSum(List<T> list, Function<T, BigDecimal> fun) {
        return bigSum(list.stream().map(fun));
    }

    public static BigDecimal bigSum(Collection<BigDecimal> val) {
        return bigSum(val.stream());
    }

    public static BigDecimal bigSum(Stream<BigDecimal> stream) {
        return stream.filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static <T, R> List<R> toList(Collection<T> list, Function<T, R> fun) {
        return list.stream().map(fun).filter(Objects::nonNull).distinct().collect(Collectors.toList());
    }

    /**
     * 最小值
     * @param a 值一
     * @param b 值二
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> T min(T a, T b){
        return (a.compareTo(b) == -1) ? a : b;
    }

    /**
     * 最大值
     * @param a 值一
     * @param b 值二
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> T max(T a, T b){
        return (a.compareTo(b) == 1) ? a : b;
    }


    public static String md5(String input) {
        if (input == null)
            return null;
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(input.getBytes());
            byte[] digest = m.digest();
            BigInteger bigInt = new BigInteger(1, digest);

            String result = bigInt.toString(16);
            if (result.length() > 32)
                result = result.substring(0, 32);

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
