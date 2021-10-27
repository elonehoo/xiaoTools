package com.xiaoTools.annotation.propIgnore;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * [属性忽略注解](Attribute ignore annotation)
 * @description zh - 属性忽略注解
 * @description en - Attribute ignore annotation
 * @version V1.0
 * @author XiaoXunYao
 * @since 2021-10-27 08:43:08
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
public @interface PropIgnore {


}
