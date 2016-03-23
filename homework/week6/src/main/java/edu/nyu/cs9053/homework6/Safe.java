package edu.nyu.cs9053.homework6;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
/**
 * User: blangel
 * Date: 2/28/16
 * Time: 4:07 PM
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Safe {

    static final long INVALID = 0L;

    /**
     * @return the deposit-safe's password
     */
    long password() default INVALID;

}
