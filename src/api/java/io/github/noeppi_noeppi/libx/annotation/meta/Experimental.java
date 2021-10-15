package io.github.noeppi_noeppi.libx.annotation.meta;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * Elements annotated with {@code Experimental} are subject to change. Use them at your own
 * risk. These should never be included in releases.
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target(value = {CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, MODULE, PARAMETER, TYPE})
public @interface Experimental {
}
