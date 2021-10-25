package com.xiaoTools.core.convert;

import com.xiaoTools.assertion.Assertion;
import com.xiaoTools.core.basicType.BasicType;
import com.xiaoTools.core.convert.collectionConverter.CollectionConverter;
import com.xiaoTools.core.convert.converterRegistry.ConverterRegistry;
import com.xiaoTools.core.convert.enumConverter.EnumConverter;
import com.xiaoTools.core.convert.formatter.numberChineseFormatter.NumberChineseFormatter;
import com.xiaoTools.core.convert.formatter.numberChineseFormatter.NumberWordFormatter;
import com.xiaoTools.core.convert.mapConverter.MapConverter;
import com.xiaoTools.core.convert.typeReference.TypeReference;
import com.xiaoTools.core.exception.convertException.ConvertException;
import com.xiaoTools.lang.constant.Constant;
import com.xiaoTools.util.byteUtil.ByteUtil;
import com.xiaoTools.util.charsetUtil.CharsetUtil;
import com.xiaoTools.util.classUtil.ClassUtil;
import com.xiaoTools.util.hexUtil.HexUtil;
import com.xiaoTools.util.strUtil.StrUtil;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * [类型转换器](Type converter)
 * @description: zh - 类型转换器
 * @description: en - Type converter
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/17 8:07 上午
*/
public class Convert {

    /*转换为字符串-----------------------------------------------------------to String*/

    /**
     * [转换为字符串](Convert to string)
     * @description: zh - 转换为字符串
     * @description: en - Convert to string
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/22 11:08 上午
     * @param value: 被转换的值
     * @param defaultValue: 转换错误时的默认值
     * @return java.lang.String
    */
    public static String toStr(Object value, String defaultValue) {
        return convertQuietly(String.class, value, defaultValue);
    }

    /**
     * [转换成为字符串](Convert to string)
     * @description: zh - 转换成为字符串
     * @description: en - Convert to string
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/27 9:49 下午
     * @param value: 被转换的值
     * @return java.lang.String
    */
    public static String toStr(Object value) {
        return toStr(value, Constant.STRING_NULL);
    }

    /**
     * [转换为String数组](Convert to string array)
     * @description: zh - 转换为String数组
     * @description: en - Convert to string array
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/27 9:49 下午
     * @param value: 被转换的值
     * @return java.lang.String[]
    */
    public static String[] toStrArray(Object value) {
        return convert(String[].class, value);
    }

    /*转换成为字符串-----------------------------------------------------------to char*/

    /**
     * [转换为字符](Convert to character)
     * @description: zh - 转换为字符
     * @description: en - Convert to character
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/27 9:50 下午
     * @param value: 被转换的值
     * @param defaultValue: 转换错误时的默认值
     * @return java.lang.Character
    */
    public static Character toChar(Object value, Character defaultValue) {
        return convertQuietly(Character.class, value, defaultValue);
    }

    /**
     * [转换为字符](Convert to character)
     * @description: zh - 转换为字符
     * @description: en - Convert to character
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/27 9:53 下午
     * @param value: 被转换的值
     * @return java.lang.Character
    */
    public static Character toChar(Object value) {
        return toChar(value, Constant.CHARACTER_NULL);
    }

    /**
     * [转换为 Character 数组](Convert to Character array)
     * @description: zh - 转换为 Character 数组
     * @description: en - Convert to Character array
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/27 9:55 下午
     * @param value: 被转换的值
     * @return java.lang.Character[]
    */
    public static Character[] toCharArray(Object value) {
        return convert(Character[].class, value);
    }

    /*转换成为字节-----------------------------------------------------------to byte*/

    /**
     * [转换为byte](Convert to byte)
     * @description: zh - 转换为byte
     * @description: en - Convert to byte
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/27 9:56 下午
     * @param value: 被转换的值
     * @param defaultValue: 转换错误时的默认值
     * @return java.lang.Byte
    */
    public static Byte toByte(Object value, Byte defaultValue) {
        return convertQuietly(Byte.class, value, defaultValue);
    }

    /**
     * [转换为byte](Convert to byte)
     * @description: zh - 转换为byte
     * @description: en - Convert to byte
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/27 9:57 下午
     * @param value: 被转换的值
     * @return java.lang.Byte
    */
    public static Byte toByte(Object value) {
        return toByte(value, null);
    }

    /**
     * [转换为Byte数组](Convert to byte array)
     * @description: zh - 转换为Byte数组
     * @description: en - Convert to byte array
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/27 9:58 下午
     * @param value: 被转换的值
     * @return java.lang.Byte[]
    */
    public static Byte[] toByteArray(Object value) {
        return convert(Byte[].class, value);
    }

    /**
     * [转换为Byte数组](Convert to byte array)
     * @description: zh - 转换为Byte数组
     * @description: en - Convert to byte array
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/27 10:00 下午
     * @param value: 被转换的值
     * @return byte[]
    */
    public static byte[] toPrimitiveByteArray(Object value) {
        return convert(byte[].class, value);
    }

    /*转换为Short-----------------------------------------------------------to Short*/

    /**
     * [转换为Short](Convert to short)
     * @description: zh - 转换为Short
     * @description: en - Convert to short
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/27 10:02 下午
     * @param value: 被转换的值
     * @param defaultValue: 转换错误时的默认值
     * @return java.lang.Short
    */
    public static Short toShort(Object value, Short defaultValue) {
        return convertQuietly(Short.class, value, defaultValue);
    }

    /**
     * [转换为Short](Convert to short)
     * @description: zh - 转换为Short
     * @description: en - Convert to short
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/27 10:03 下午
     * @param value: 被转换的值
     * @return java.lang.Short
    */
    public static Short toShort(Object value) {
        return toShort(value, null);
    }

    /**
     * [转换为Short数组](Convert to short array)
     * @description: zh - 转换为Short数组
     * @description: en - Convert to short array
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/27 10:06 下午
     * @param value: 被转换的值
     * @return java.lang.Short[]
    */
    public static Short[] toShortArray(Object value) {
        return convert(Short[].class, value);
    }

    /*转换为Number-----------------------------------------------------------to Number*/

    /**
     * [转换为Number](Convert to number)
     * @description: zh - 转换为Number
     * @description: en - Convert to number
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/27 10:09 下午
     * @param value: 被转换的值
     * @param defaultValue: 转换错误时的默认值
     * @return java.lang.Number
    */
    public static Number toNumber(Object value, Number defaultValue) {
        return convertQuietly(Number.class, value, defaultValue);
    }

    /**
     * [转换为Number](Convert to number)
     * @description: zh - 转换为Number
     * @description: en - Convert to number
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/27 10:10 下午
     * @param value: 被转换的值
     * @return java.lang.Number
    */
    public static Number toNumber(Object value) {
        return toNumber(value, null);
    }

    /**
     * [转换为Number数组](Convert to number array)
     * @description: zh - 转换为Number数组
     * @description: en - Convert to number array
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/27 10:11 下午
     * @param value: 被转换的值
     * @return java.lang.Number[]
    */
    public static Number[] toNumberArray(Object value) {
        return convert(Number[].class, value);
    }

    /*转换为int-----------------------------------------------------------to int*/

    /**
     * [转换成为int类型](convert to int)
     * @description: zh - 转换成为int类型
     * @description: en - convert to int
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 7:52 上午
     * @param value: 被转换的值
     * @param defaultValue: 转换错误时的默认值
     * @return java.lang.Integer
    */
    public static Integer toInt(Object value, Integer defaultValue) {
        return convertQuietly(Integer.class, value, defaultValue);
    }

    /**
     * [转换成为int类型](convert to int)
     * @description: zh - 转换成为int类型
     * @description: en - convert to int
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 7:53 上午
     * @param value: 被转换的值
     * @return java.lang.Integer
    */
    public static Integer toInt(Object value) {
        return toInt(value, Constant.INTEGER_NULL);
    }

    /**
     * [转换为Integer数组](Convert to integer array)
     * @description: zh - 转换为Integer数组
     * @description: en - Convert to integer array
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 7:54 上午
     * @param value: 被转换的值
     * @return java.lang.Integer[]
    */
    public static Integer[] toIntArray(Object value) {
        return convert(Integer[].class, value);
    }

    /*转换为long-----------------------------------------------------------to long*/

    /**
     * [转换为long](covert to long)
     * @description: zh - 转换为long
     * @description: en - covert to long
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 7:55 上午
     * @param value: 被转换的值
     * @param defaultValue: 转换错误时的默认值
     * @return java.lang.Long
    */
    public static Long toLong(Object value, Long defaultValue) {
        return convertQuietly(Long.class, value, defaultValue);
    }

    /**
     * [转换为long](Convert to long)
     * @description: zh - 转换为long
     * @description: en - Convert to long
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 7:57 上午
     * @param value: 被转换的值
     * @return java.lang.Long
    */
    public static Long toLong(Object value) {
        return toLong(value, null);
    }

    /**
     * [转换为Long数组](Convert to long array)
     * @description: zh - 转换为Long数组
     * @description: en - Convert to long array
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 7:57 上午
     * @param value: 被转换的值
     * @return java.lang.Long[]
    */
    public static Long[] toLongArray(Object value) {
        return convert(Long[].class, value);
    }

    /*转换为double-----------------------------------------------------------to double*/

    /**
     * [转换为double](Convert to double)
     * @description: zh - 转换为double
     * @description: en - Convert to double
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 7:59 上午
     * @param value: 被转换的值
     * @param defaultValue: 转换错误时的默认值
     * @return java.lang.Double
    */
    public static Double toDouble(Object value, Double defaultValue) {
        return convertQuietly(Double.class, value, defaultValue);
    }

    /**
     * [转换为double](Convert to double)
     * @description: zh - 转换为double
     * @description: en - Convert to double
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 8:00 上午
     * @param value: 被转换的值
     * @return java.lang.Double
    */
    public static Double toDouble(Object value) {
        return toDouble(value, null);
    }

    /**
     * [转换为Double数组](Convert to double array)
     * @description: zh - 转换为Double数组
     * @description: en - Convert to double array
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 8:00 上午
     * @param value: 被转换的值
     * @return java.lang.Double[]
    */
    public static Double[] toDoubleArray(Object value) {
        return convert(Double[].class, value);
    }

    /*转换为float-----------------------------------------------------------to float*/

    /**
     * [转换为Float](Convert to float)
     * @description: zh - 转换为Float
     * @description: en - Convert to float
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 2:46 下午
     * @param value: 被转换的值
     * @param defaultValue: 转换错误时的默认值
     * @return java.lang.Float
    */
    public static Float toFloat(Object value, Float defaultValue) {
        return convertQuietly(Float.class, value, defaultValue);
    }

    /**
     * [转换为Float](Convert to float)
     * @description: zh - 转换为Float
     * @description: en - Convert to float
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 2:54 下午
     * @param value: 被转换的值
     * @return java.lang.Float
    */
    public static Float toFloat(Object value) {
        return toFloat(value, null);
    }

    /**
     * [转换为Float数组](Convert to a float array)
     * @description: zh - 转换为Float数组
     * @description: en - Convert to a float array
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 2:56 下午
     * @param value: 被转换的值
     * @return java.lang.Float[]
    */
    public static Float[] toFloatArray(Object value) {
        return convert(Float[].class, value);
    }

    /*转换为boolean-----------------------------------------------------------to boolean*/

    /**
     * [转换为boolean](Convert to Boolean)
     * @description: zh - 转换为boolean
     * @description: en - Convert to Boolean
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 3:26 下午
     * @param value: 被转换的值
     * @param defaultValue: 转换错误时的默认值
     * @return java.lang.Boolean
    */
    public static Boolean toBoolean(Object value, Boolean defaultValue) {
        return convertQuietly(Boolean.class, value, defaultValue);
    }

    /**
     * [转换为boolean](Convert to Boolean)
     * @description: zh - 转换为boolean
     * @description: en - Convert to Boolean
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 3:31 下午
     * @param value: 被转换的值
     * @return java.lang.Boolean
    */
    public static Boolean toBoolean(Object value) {
        return toBoolean(value, null);
    }

    /**
     * [转换为Boolean数组](Convert to Boolean array)
     * @description: zh - 转换为Boolean数组
     * @description: en - Convert to Boolean array
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 3:31 下午
     * @param value: 被转换的值
     * @return java.lang.Boolean[]
    */
    public static Boolean[] toBooleanArray(Object value) {
        return convert(Boolean[].class, value);
    }

    /*转换为BigInteger-----------------------------------------------------------to BigInteger*/

    /**
     * [转换为BigInteger](Convert to BigInteger)
     * @description: zh - 转换为BigInteger
     * @description: en - Convert to BigInteger
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 3:41 下午
     * @param value: 被转换的值
     * @param defaultValue: 转换错误时的默认值
     * @return java.math.BigInteger
    */
    public static BigInteger toBigInteger(Object value, BigInteger defaultValue) {
        return convertQuietly(BigInteger.class, value, defaultValue);
    }

    /**
     * [转换为BigInteger](Convert to BigInteger)
     * @description: zh - 转换为BigInteger
     * @description: en - Convert to BigInteger
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 4:04 下午
     * @param value: 被转换的值
     * @return java.math.BigInteger
    */
    public static BigInteger toBigInteger(Object value) {
        return toBigInteger(value, null);
    }

    /*转换为toBigDecimal-----------------------------------------------------------to toBigDecimal*/

    /**
     * [转换为BigDecimal](Convert to BigDecimal)
     * @description: zh - 转换为BigDecimal
     * @description: en - Convert to BigDecimal
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 4:08 下午
     * @param value: 被转换的值
     * @param defaultValue: 转换错误时的默认值
     * @return java.math.BigDecimal
    */
    public static BigDecimal toBigDecimal(Object value, BigDecimal defaultValue) {
        return convertQuietly(BigDecimal.class, value, defaultValue);
    }

    /**
     * [转换为BigDecimal](Convert to BigDecimal)
     * @description: zh - 转换为BigDecimal
     * @description: en - Convert to BigDecimal
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 4:16 下午
     * @param value: 被转换的值
     * @return java.math.BigDecimal
    */
    public static BigDecimal toBigDecimal(Object value) {
        return toBigDecimal(value, null);
    }

    /*转换为date-----------------------------------------------------------to date*/

    /**
     * [转换为Date](Convert to date)
     * @description: zh - 转换为Date
     * @description: en - Convert to date
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 4:20 下午
     * @param value: 被转换的值
     * @param defaultValue: 转换错误时的默认值
     * @return java.util.Date
    */
    public static Date toDate(Object value, Date defaultValue) {
        return convertQuietly(Date.class, value, defaultValue);
    }

    /**
     * [LocalDateTime](LocalDateTime)
     * @description: zh - LocalDateTime
     * @description: en - LocalDateTime
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 4:28 下午
     * @param value: 被转换的值
     * @param defaultValue: 转换错误时的默认值
     * @return java.time.LocalDateTime
    */
    public static LocalDateTime toLocalDateTime(Object value, LocalDateTime defaultValue) {
        return convertQuietly(LocalDateTime.class, value, defaultValue);
    }

    /**
     * [转换为 LocalDateTime](Convert to LocalDateTime)
     * @description: zh - 转换为 LocalDateTime
     * @description: en - Convert to LocalDateTime
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 4:32 下午
     * @param value: 被转换的值
     * @return java.time.LocalDateTime
    */
    public static LocalDateTime toLocalDateTime(Object value) {
        return toLocalDateTime(value, null);
    }

    /**
     * [Instant](Instant)
     * @description: zh - Instant
     * @description: en - Instant
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 4:35 下午
     * @param value: 被转换的值
     * @param defaultValue: 转换错误时的默认值
     * @return java.util.Date
    */
    public static Date toInstant(Object value, Date defaultValue) {
        return convertQuietly(Instant.class, value, defaultValue);
    }

    /**
     * [Convert](Convert to date)
     * @description: zh - 转换为Date
     * @description: en - Convert to date
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 4:39 下午
     * @param value: 被转换的值
     * @return java.util.Date
    */
    public static Date toDate(Object value) {
        return toDate(value, null);
    }

    /*转换为Enum对象-----------------------------------------------------------Convert to enum object*/

    /**
     * [转换为Enum对象](Convert to enum object)
     * @description: zh - 转换为Enum对象
     * @description: en - Convert to enum object
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 4:51 下午
     * @param clazz: Enum的Class
     * @param value: 值
     * @param defaultValue: 默认值
     * @return E
    */
	@SuppressWarnings("unchecked")
    public static <E extends Enum<E>> E toEnum(Class<E> clazz, Object value, E defaultValue) {
        return (E) (new EnumConverter(clazz)).convertQuietly(value, defaultValue);
    }

    /**
     * [转换为Enum对象](Convert to enum object)
     * @description: zh - 转换为Enum对象
     * @description: en - Convert to enum object
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 4:49 下午
     * @param clazz: Enum的Class
     * @param value: 值
     * @return E
    */
    public static <E extends Enum<E>> E toEnum(Class<E> clazz, Object value) {
        return toEnum(clazz, value, null);
    }

    /*转换为集合类-----------------------------------------------------------Convert to collection class*/

    /**
     * [转换为集合类](Convert to collection class)
     * @description: zh - 转换为集合类
     * @description: en - Convert to collection class
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 4:55 下午
     * @param collectionType: 集合类型
     * @param elementType: 集合中元素类型
     * @param value: 被转换的值
     * @return java.util.Collection<?>
    */
    public static Collection<?> toCollection(Class<?> collectionType, Class<?> elementType, Object value) {
        return new CollectionConverter(collectionType, elementType).convert(value, null);
    }

    /**
     * [转换为ArrayList，元素类型默认Object](Convert to ArrayList, the element type is object by default)
     * @description: zh - 转换为ArrayList，元素类型默认Object
     * @description: en - Convert to ArrayList, the element type is object by default
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 4:59 下午
     * @param value: 被转换的值
     * @return java.util.List<?>
    */
    public static List<?> toList(Object value) {
        return convert(List.class, value);
    }

    /**
     * [转换为ArrayList](Convert to ArrayList)
     * @description: zh - 转换为ArrayList
     * @description: en - Convert to ArrayList
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 5:13 下午
     * @param elementType: 集合中元素类型
     * @param value: 被转换的值
     * @return java.util.List<T>
    */
	@SuppressWarnings("unchecked")
    public static <T> List<T> toList(Class<T> elementType, Object value) {
        return (List<T>) toCollection(ArrayList.class, elementType, value);
    }

    /**
     * [转换为Map](Convert to map)
     * @description: zh - 转换为Map
     * @description: en - Convert to map
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 5:16 下午
     * @param keyType: 键类型
     * @param valueType: 值类型
     * @param value: 被转换的值
     * @return java.util.Map<K,V>
    */
	@SuppressWarnings("unchecked")
    public static <K, V> Map<K, V> toMap(Class<K> keyType, Class<V> valueType, Object value) {
        return (Map<K, V>) new MapConverter(HashMap.class, keyType, valueType).convert(value, null);
    }

    /**
     * [转换值为指定类型，类型采用字符串表示](Convert the value to the specified type, and the type is represented by a string)
     * @description: zh - 转换值为指定类型，类型采用字符串表示
     * @description: en - Convert the value to the specified type, and the type is represented by a string
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 5:18 下午
     * @param className: 类的字符串表示
     * @param value: 值
     * @return T
    */
    public static <T> T convertByClassName(String className, Object value) throws ConvertException{
        return convert(ClassUtil.loadClass(className), value);
    }

    /*转换-----------------------------------------------------------convert*/

    /**
     * [转换值为指定类型](Convert the value to the specified type)
     * @description: zh - 转换值为指定类型
     * @description: en - Convert the value to the specified type
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/24 7:36 下午
     * @param type: 类型
     * @param value: 值
     * @return T
    */
    public static <T> T convert(Class<T> type, Object value) throws ConvertException {
        return convert((Type)type, value);
    }

    /**
     * [转换值为指定类型](Convert the value to the specified type)
     * @description: zh - 转换值为指定类型
     * @description: en - Convert the value to the specified type
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/24 7:37 下午
     * @param reference: 类型参考，用于持有转换后的泛型类型
     * @param value: 值
     * @return T
    */
    public static <T> T convert(TypeReference<T> reference, Object value) throws ConvertException{
        return convert(reference.getType(), value, null);
    }

    /**
     * [转换值为指定类型](Convert the value to the specified type)
     * @description: zh - 转换值为指定类型
     * @description: en - Convert the value to the specified type
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/24 7:43 下午
     * @param type: 类型
     * @param value: 值
     * @return T
    */
    public static <T> T convert(Type type, Object value) throws ConvertException{
        return convert(type, value, null);
    }

    /**
     * [转换值为指定类型](Convert the value to the specified type)
     * @description: zh - 转换值为指定类型
     * @description: en - Convert the value to the specified type
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/24 7:45 下午
     * @param type: 类型值
     * @param value: 值
     * @param defaultValue: 默认值
     * @return T
    */
    public static <T> T convert(Class<T> type, Object value, T defaultValue) throws ConvertException {
        return convert((Type)type, value, defaultValue);
    }

    /**
     * [转换值为指定类型](Convert the value to the specified type)
     * @description: zh - 转换值为指定类型
     * @description: en - Convert the value to the specified type
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/24 7:48 下午
     * @param type: 类型
     * @param value: 值
     * @param defaultValue: 默认值
     * @return T
    */
    public static <T> T convert(Type type, Object value, T defaultValue) throws ConvertException {
        return convertWithCheck(type, value, defaultValue, Constant.FALSE);
    }

    /**
     * [转换值为指定类型，不抛异常转换](Convert the value to the specified type without exception conversion)
     * @description: zh - 转换值为指定类型，不抛异常转换
     * @description: en - Convert the value to the specified type without exception conversion
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 5:25 下午
     * @param type: 目标类型
     * @param value: 值
     * @return T
    */
    public static <T> T convertQuietly(Type type, Object value) {
        return convertQuietly(type, value, null);
    }

    /**
     * [转换值为指定类型，不抛异常转换](Convert the value to the specified type without exception conversion)
     * @description: zh - 转换值为指定类型，不抛异常转换
     * @description: en - Convert the value to the specified type without exception conversion
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 5:36 下午
     * @param type:目标类型
     * @param value: 值
     * @param defaultValue: 默认值
     * @return T
    */
    public static <T> T convertQuietly(Type type, Object value, T defaultValue) {
        return convertWithCheck(type, value, defaultValue, true);
    }

    /**
     * [转换值为指定类型，可选是否不抛异常转换](The conversion value is of the specified type, and can be converted without exception)
     * @description: zh - 转换值为指定类型，可选是否不抛异常转换
     * @description: en - The conversion value is of the specified type, and can be converted without exception
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 6:15 下午
     * @param type: 目标类型
     * @param value: 值
     * @param defaultValue: 默认值
     * @param quietly: 是否静默转换，true不抛异常
     * @return T
    */
    public static <T> T convertWithCheck(Type type, Object value, T defaultValue, boolean quietly) {
        final ConverterRegistry registry = ConverterRegistry.getInstance();
        try {
            return registry.convert(type, value, defaultValue);
        } catch (Exception e) {
            if(quietly){
                return defaultValue;
            }
            throw e;
        }
    }

    /*全角半角转换-----------------------------------------------------------Full angle and half angle conversion*/

    /**
     * [半角转全角](Half angle to full angle)
     * @description: zh - 半角转全角
     * @description: en - Half angle to full angle
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 7:10 下午
     * @param input: String字符串
     * @return java.lang.String
    */
    public static String toSBC(String input) {
        return toSBC(input, null);
    }

    /**
     * [半角转全角](Half angle to full angle)
     * @description: zh - 半角转全角
     * @description: en - Half angle to full angle
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 7:09 下午
     * @param input: String字符串
     * @param notConvertSet: 不替换的字符集合
     * @return java.lang.String
    */
    public static String toSBC(String input, Set<Character> notConvertSet) {
        final char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (Constant.NULL != notConvertSet && notConvertSet.contains(c[i])) {
                // 跳过不替换的字符
                continue;
            }
            if (c[i] == ' ') {
                c[i] = '\u3000';
            } else if (c[i] < '\177') {
                c[i] = (char) (c[i] + 65248);
            }
        }
        return new String(c);
    }

    /**
     * [全角转半角](Full angle to half angle)
     * @description: zh - 全角转半角
     * @description: en - Full angle to half angle
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/29 8:30 上午
     * @param input: String字符串
     * @return java.lang.String
    */
    public static String toDBC(String input) {
        return toDBC(input, null);
    }

    /**
     * [替换全角为半角](half angle to full angle)
     * @description: zh - 替换全角为半角
     * @description: en - half angle to full angle
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/29 8:34 上午
     * @param text: 文本
     * @param notConvertSet: 不替换的字符集合
     * @return java.lang.String
    */
    public static String toDBC(String text, Set<Character> notConvertSet) {
        if(StrUtil.isBlank(text)) {
            return text;
        }
        final char[] c = text.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (Constant.NULL != notConvertSet && notConvertSet.contains(c[i])) {
                // 跳过不替换的字符
                continue;
            }
            if (c[i] == '\u3000' || c[i] == '\u00a0' || c[i] == '\u2007' || c[i] == '\u202F') {
                // \u3000是中文全角空格，\u00a0、\u2007、\u202F是不间断空格
                c[i] = ' ';
            } else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
                c[i] = (char) (c[i] - 65248);
            }
        }
        return new String(c);
    }

    /*转换成十六进制-----------------------------------------------------------Convert to hexadecimal*/

    /**
     * [字符串转换成十六进制字符串，结果为小写](String to hexadecimal string, the result is lowercase)
     * @description: zh - 字符串转换成十六进制字符串，结果为小写
     * @description: en - String to hexadecimal string, the result is lowercase
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/29 9:55 下午
     * @param str: 待转换的ASCII字符串
     * @param charset: 编码
     * @return java.lang.String
    */
    public static String toHex(String str, Charset charset) {
        return HexUtil.encodeHexStr(str, charset);
    }

    /**
     * [byte数组转16进制串](Conversion of byte array to hexadecimal string)
     * @description: zh - byte数组转16进制串
     * @description: en - Conversion of byte array to hexadecimal string
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/30 7:51 上午
     * @param bytes: 被转换的byte数组
     * @return java.lang.String
    */
    public static String toHex(byte[] bytes) {
        return HexUtil.encodeHexStr(bytes);
    }

    /**
     * [Hex字符串转换为Byte值](Hex string to byte value)
     * @description: zh - Hex字符串转换为Byte值
     * @description: en - Hex string to byte value
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/3 8:05 上午
     * @param src: Byte字符串，每个Byte之间没有分隔符
     * @return byte[]
    */
    public static byte[] hexToBytes(String src) {
        return HexUtil.decodeHex(src.toCharArray());
    }

    /**
     * [十六进制转换字符串](Hexadecimal conversion string)
     * @description: zh - 十六进制转换字符串
     * @description: en - Hexadecimal conversion string
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/3 8:05 上午
     * @param hexStr: Byte字符串(Byte之间无分隔符 如:[616C6B])
     * @param charset: 编码 Charset
     * @return java.lang.String
    */
    public static String hexToStr(String hexStr, Charset charset) {
        return HexUtil.decodeHexStr(hexStr, charset);
    }

    /**
     * [String的字符串转换成unicode的String](String string to unicode string)
     * @description: zh - String的字符串转换成unicode的String
     * @description: en - String string to unicode string
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/3 8:07 上午
     * @param strText: 全角字符串
     * @return java.lang.String
    */
    public static String strToUnicode(String strText) {
        return UnicodeUtil.toUnicode(strText);
    }

    /**
     * [unicode的String转换成String的字符串](The string of Unicode is converted to the string of string)
     * @description: zh - unicode的String转换成String的字符串
     * @description: en - The string of Unicode is converted to the string of string
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/4 3:51 下午
     * @param unicode: Unicode符
     * @return java.lang.String
    */
    public static String unicodeToStr(String unicode) {
        return UnicodeUtil.toString(unicode);
    }

    /**
     * [给定字符串转换字符编码](Character encoding for given string conversion)
     * @description: zh - 给定字符串转换字符编码
     * @description: en - Character encoding for given string conversion
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/4 3:57 下午
     * @param str: 被转码的字符串
     * @param sourceCharset: 原字符集
     * @param destCharset: 目标字符集
     * @return java.lang.String
    */
    public static String convertCharset(String str, String sourceCharset, String destCharset) {
        return StrUtil.hasBlank(str, sourceCharset, destCharset) ?
                str : CharsetUtil.convert(str, sourceCharset, destCharset);
    }

    /**
     * [转换时间单位](Convert time units)
     * @description: zh - 转换时间单位
     * @description: en - Convert time units
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/4 3:58 下午
     * @param sourceDuration: 时长
     * @param sourceUnit: 源单位
     * @param destUnit: 目标单位
     * @return long
    */
    public static long convertTime(long sourceDuration, TimeUnit sourceUnit, TimeUnit destUnit) {
        Assertion.notNull(sourceUnit, "sourceUnit is null !");
        Assertion.notNull(destUnit, "destUnit is null !");
        return destUnit.convert(sourceDuration, sourceUnit);
    }

    /*原始包装类型转换-----------------------------------------------------------Original packaging type conversion*/

    /**
     * [原始类转为包装类，非原始类返回原类](The original class is converted to a wrapper class, and the non original class returns the original class)
     * @description: zh - 原始类转为包装类，非原始类返回原类
     * @description: en - The original class is converted to a wrapper class, and the non original class returns the original class
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/4 4:11 下午
     * @param clazz: 原始类
     * @return java.lang.Class<?>
    */
    public static Class<?> wrap(Class<?> clazz) {
        return BasicType.wrap(clazz);
    }

    /**
     * [包装类转为原始类，非包装类返回原类](The packing class becomes the original class, and the non packing class returns the original class)
     * @description: zh - 包装类转为原始类，非包装类返回原类
     * @description: en - The packing class becomes the original class, and the non packing class returns the original class
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/4 4:12 下午
     * @param clazz: 原始类
     * @return java.lang.Class<?>
    */
    public static Class<?> unWrap(Class<?> clazz) {
        return BasicType.unWrap(clazz);
    }

    /*数字和英文转换-----------------------------------------------------------Digital and English conversion*/

    /**
     * [将阿拉伯数字转为英文表达方式](Translate Arabic numerals into English)
     * @description: zh - 将阿拉伯数字转为英文表达方式
     * @description: en - Translate Arabic numerals into English
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/4 4:14 下午
     * @param number: Number对象
     * @return java.lang.String
    */
    public static String numberToWord(Number number) {
        return NumberWordFormatter.format(number);
    }

    /**
     * [将阿拉伯数字转为精简表示形式,例如 1200 --> 1.2K](Convert Arabic numerals to reduced representation, such as 1200 --> 1.2K)
     * @description: zh - 将阿拉伯数字转为精简表示形式,例如 1200 --> 1.2K
     * @description: en - Convert Arabic numerals to reduced representation, such as 1200 --> 1.2K
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/4 4:16 下午
     * @param number: Number对象
     * @return java.lang.String
    */
    public static String numberToSimple(Number number) {
        return NumberWordFormatter.formatSimple(number.longValue());
    }

    /**
     * [将阿拉伯数字转为中文表达方式](Convert Arabic numerals into Chinese expressions)
     * @description: zh - 将阿拉伯数字转为中文表达方式
     * @description: en - Convert Arabic numerals into Chinese expressions
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/4 4:25 下午
     * @param number: 数字
     * @param isUseTraditional: 是否使用繁体字（金额形式）
     * @return java.lang.String
    */
    public static String numberToChinese(double number, boolean isUseTraditional) {
        return NumberChineseFormatter.format(number, isUseTraditional);
    }

    /**
     * [数字中文表示形式转数字](Conversion of Chinese representation of numbers to numbers)
     * @description: zh - 数字中文表示形式转数字
     * @description: en - Conversion of Chinese representation of numbers to numbers
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/4 4:27 下午
     * @param number: 数字中文表示
     * @return int
    */
    public static int chineseToNumber(String number){
        return NumberChineseFormatter.chineseToNumber(number);
    }

    /**
     * [金额转为中文形式](Amount in Chinese)
     * @description: zh - 金额转为中文形式
     * @description: en - Amount in Chinese
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/4 4:29 下午
     * @param n: 数字
     * @return java.lang.String
    */
    public static String digitToChinese(Number n) {
        return Constant.NULL == n ?
                Constant.STRING_CHINA_ZERO : NumberChineseFormatter.format(n.doubleValue(), Constant.TRUE, Constant.TRUE);
    }

    /*数字转换-----------------------------------------------------------Digital conversion*/

    /**
     * [int转byte](Int to byte)
     * @description: zh - int转byte
     * @description: en - Int to byte
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/4 4:33 下午
     * @param intValue: int值
     * @return byte
    */
    public static byte intToByte(int intValue) {
        return (byte) intValue;
    }

    /**
     * [byte转无符号int](Byte to unsigned int)
     * @description: zh - byte转无符号int
     * @description: en - Byte to unsigned int
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/4 4:34 下午
     * @param byteValue: byte值
     * @return int
    */
    public static int byteToUnsignedInt(byte byteValue) {
        // Java 总是把 byte 当做有符处理；我们可以通过将其和 0xFF 进行二进制与得到它的无符值
        return byteValue & 0xFF;
    }

    /**
     * [byte数组转short](Byte array to short)
     * @description: zh - byte数组转short
     * @description: en - Byte array to short
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/4 4:36 下午
     * @param bytes: byte数组
     * @return short
    */
    public static short bytesToShort(byte[] bytes) {
        return ByteUtil.bytesToShort(bytes);
    }

    /**
     * [short转byte数组](Short to byte array)
     * @description: zh - short转byte数组
     * @description: en - Short to byte array
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/4 4:49 下午
     * @param shortValue: short值
     * @return byte[]
    */
    public static byte[] shortToBytes(short shortValue) {
        return ByteUtil.shortToBytes(shortValue);
    }

    /**
     * [byte[]转int值](Byte [] to int)
     * @description: zh - byte[]转int值
     * @description: en - Byte [] to int
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/4 4:52 下午
     * @param bytes: byte数组
     * @return int
    */
    public static int bytesToInt(byte[] bytes) {
        return ByteUtil.bytesToInt(bytes);
    }

    /**
     * [int转byte数组](Int to byte array)
     * @description: zh - int转byte数组
     * @description: en - Int to byte array
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/4 4:53 下午
     * @param intValue: int值
     * @return byte[]
    */
    public static byte[] intToBytes(int intValue) {
        return ByteUtil.intToBytes(intValue);
    }

    /**
     * [long转byte数组](Long to byte array)
     * @description: zh - long转byte数组
     * @description: en - Long to byte array
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/4 4:55 下午
     * @param longValue: long值
     * @return byte[]
    */
    public static byte[] longToBytes(long longValue) {
        return ByteUtil.longToBytes(longValue);
    }

    /**
     * [byte数组转long](Convert byte array to long)
     * @description: zh - byte数组转long
     * @description: en - Convert byte array to long
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/4 4:56 下午
     * @param bytes: byte数组
     * @return long
    */
    public static long bytesToLong(byte[] bytes) {
        return ByteUtil.bytesToLong(bytes);
    }
}
