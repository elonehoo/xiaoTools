package com.xiaoTools.util.arrayUtil;

import java.lang.reflect.Array;
import java.util.Objects;

import com.xiaoTools.core.matcher.Matcher;
import com.xiaoTools.lang.constant.Constant;
import com.xiaoTools.util.primitiveArrayUtil.PrimitiveArrayUtil;

/**
 * [数组工具类](Array tool class)
 * @author HCY
 * @since 2021/5/16 2:21 [下午](afternoon)
*/
public class ArrayUtil extends PrimitiveArrayUtil {

    /* 数组是否为空 ------------------------------------------------------------------------------- Is Empty */

    /**
     * [数组是否为空](Is the array empty)
     * @description zh - 数组是否为空
     * @description en - Is the array empty
     * @version V1.0
     * @author XiaoXunYao
     * @since 2021-08-18 14:31:59
     * @param array 数组
     * @return boolean
     */
    public static <T> boolean isEmpty(T[] array) {
		return array == Constant.NULL || array.length == Constant.ZERO;
	}

    /**
     * [数组是否为空](Is the array empty)
     * @description zh - 数组是否为空
     * @description en - Is the array empty
     * @version V1.0
     * @author XiaoXunYao
     * @since 2021-08-18 14:33:32
     * @param array 数组
     * @return boolean
     */
    public static boolean isEmpty(Object array) {
		if (array != Constant.NULL) {
			if (isArray(array)) {
				return Constant.ZERO == Array.getLength(array);
			}
			return Constant.FALSE;
		}
		return Constant.TRUE;
	}

    /* 如果给定数组为空 ------------------------------------------------------------------------------- default array */

    /**
     * [如果给定数组为空，返回默认数组](If the given array is empty, the default array is returned)
     * @description zh - 如果给定数组为空，返回默认数组
     * @description en - If the given array is empty, the default array is returned
     * @version V1.0
     * @author XiaoXunYao
     * @since 2021-08-18 15:00:54
     */
    public static <T> T[] defaultIfEmpty(T[] array, T[] defaultArray) {
		return isEmpty(array) ? defaultArray : array;
	}

    /* 数组是否为非空 ------------------------------------------------------------------------------- isNotEmpty */

    /**
     * [数组是否为非空](Is the array non empty)
     * @description zh - 数组是否为非空
     * @description en - Is the array non empty
     * @version V1.0
     * @author XiaoXunYao
     * @since 2021-08-18 15:02:55
     * @param array 数组
     * @return T
     */
    public static <T> boolean isNotEmpty(T[] array) {
		return (Constant.NULL != array && array.length != Constant.ZERO);
	}

    /**
     * [数组是否为非空](Is the array non empty)
     * @description zh - 数组是否为非空
     * @description en - Is the array non empty
     * @version V1.0
     * @author XiaoXunYao
     * @since 2021-08-18 15:04:32
     * @param array 数组
     * @return boolean
     */
    public static boolean isNotEmpty(Object array) {
		return Constant.FALSE == isEmpty(array);
	}

    /* 是否包含 null 元素 ------------------------------------------------------------------------------- hasNull */

    /**
     * [是否包含 null 元素](Contains null elements)
     * @description zh - 是否包含 null 元素
     * @description en - Contains null elements
     * @version V1.0
     * @author XiaoXunYao
     * @since 2021-08-18 19:41:43
     * @param array 数组
     * @return boolean
     */
    @SuppressWarnings("unchecked")
    public static <T> boolean hasNull(T... array) {
		if (isNotEmpty(array)) {
			for (T element : array) {
				if (Constant.NULL == element) {
					return Constant.TRUE;
				}
			}
		}
		return Constant.FALSE;
	}

    /* 多个字段是否全为 null ------------------------------------------------------------------------------- isAllNull */

    /**
     * [多个字段是否全为 null](Are multiple fields all null)
     * @description zh - 多个字段是否全为 null
     * @description en - Are multiple fields all null
     * @version V1.0
     * @author XiaoXunYao
     * @since 2021-08-18 20:14:56
     * @param array 数组
     * @return boolean
     */
    @SuppressWarnings("unchecked")
	public static <T> boolean isAllNull(T... array) {
		return Constant.NULL == firstNonNull(array);
	}

    /**
     * [返回数组中第一个匹配规则的值](Returns the value of the first matching rule in the array)
     * @description zh - 返回数组中第一个非空元素
     * @description en - Returns the value of the first matching rule in the array
     * @version V1.0
     * @author XiaoXunYao
     * @since 2021-08-18 20:18:19
     * @param array 数组
     * @return T
     */
    @SuppressWarnings("unchecked")
	public static <T> T firstNonNull(T... array) {
		return firstMatch(Objects::nonNull, array);
	}

    /**
     * [返回数组中第一个匹配规则的值](Returns the value of the first matching rule in the array)
     * @description zh - 返回数组中第一个匹配规则的值
     * @description en - Returns the value of the first matching rule in the array
     * @version V1.0
     * @author XiaoXunYao
     * @since 2021-08-18 20:22:49
     * @param match
     * @param array 数组
     * @return T
     */
    @SuppressWarnings("unchecked")
	public static <T> T firstMatch(Matcher<T> matcher, T... array) {
		if (isNotEmpty(array)) {
			for (final T val : array) {
				if (matcher.match(val)) {
					return val;
				}
			}
		}
		return null;
	}

    /* 新建一个空数组 ------------------------------------------------------------------------------- newArray */

    /**
     * [新建一个空数组](Create a new empty array)
     * @description zh - 新建一个空数组
     * @description en - Create a new empty array 
     * @version V1.0
     * @author XiaoXunYao
     * @since 2021-08-18 20:54:36
     * @param componentType 类型
     * @param newSize 数组大小
     * @return T[]
     */
    @SuppressWarnings("unchecked")
	public static <T> T[] newArray(Class<?> componentType, int newSize) {
		return (T[]) Array.newInstance(componentType, newSize);
	}

    /**
     * [新建一个空数组](Create a new empty array)
     * @description zh - 新建一个空数组
     * @description en - Create a new empty array 
     * @version V1.0
     * @author XiaoXunYao
     * @since 2021-08-18 21:47:45
     * @param newSize 数组大小
     * @return Object[]
     */
    public static Object[] newArray(int newSize) {
		return new Object[newSize];
	}

    /* 获取数组对象的元素类型 ------------------------------------------------------------------------------- type */

    /**
     * [获取数组对象的元素类型](Gets the element type of the array object)
     * @description zh - 获取数组对象的元素类型
     * @description en - Gets the element type of the array object
     * @version V1.0
     * @author XiaoXunYao
     * @since 2021-08-19 14:12:43
     * @param array 数组
     * @return class
     */
    public static Class<?> getComponentType(Object array) {
		return Constant.NULL == array ? null : array.getClass().getComponentType();
	}

    /**
     * [获取数组对象的元素类型](Gets the element type of the array object)
     * @description zh - 获取数组对象的元素类型
     * @description en - Gets the element type of the array object
     * @version V1.0
     * @author XiaoXunYao
     * @since 2021-08-19 14:16:17
     * @param arratClass 数组类
     * @return Class
     */
    public static Class<?> getComponentType(Class<?> arrayClass) {
		return Constant.NULL == arrayClass ? null : arrayClass.getComponentType();
	}

    /**
     * [获取数组对象的元素类型](Gets the element type of the array object)
     * @description zh - 获取数组对象的元素类型
     * @description en - Gets the element type of the array object
     * @version V1.0
     * @author XiaoXunYao
     * @since 2021-08-19 14:18:32
     * @param componentType 数组元素类型
     * @return Class
     */
    public static Class<?> getArrayType(Class<?> componentType) {
		return Array.newInstance(componentType, Constant.ZERO).getClass();
	}
}
