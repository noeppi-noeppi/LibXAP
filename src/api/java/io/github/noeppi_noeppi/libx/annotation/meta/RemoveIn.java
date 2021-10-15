package io.github.noeppi_noeppi.libx.annotation.meta;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE;

/**
 * Marks the version in which a feature will be removed.
 * At least one of the parameters must be defined.
 * An element that is annotated with {@code @RemoveIn} must be annotated
 * with {@link Deprecated#forRemoval() @Deprecated(forRemoval = true)}.
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target(value = {CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, MODULE, PARAMETER, TYPE})
public @interface RemoveIn {

    /**
     * The minecraft version in which the feature should be removed.
     */
    String minecraft() default "";
    
    /**
     * The mod version in which the feature should be removed.
     */
    String mod() default "";
}
