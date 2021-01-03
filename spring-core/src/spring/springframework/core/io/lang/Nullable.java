package spring.springframework.core.io.lang;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.annotation.Nonnull;

/**
 * @author lgq
 * @Description A common Spring annotation to declare that annotated elements can be {@code null} under some circumstance.
 * <p>Leverages JSR-305 meta-annotations to indicate nullability in Java to common
 * tools with JSR-305 support and used by Kotlin to infer nullability of Spring API.
 *
 * <p>Should be used at parameter, return value, and field level. Methods override should
 * repeat parent {@code @Nullable} annotations unless they behave differently.
 *
 * <p>Can be used in association with {@code @NonNullApi} or {@code @NonNullFields} to
 * override the default non-nullable semantic to nullable.
 * @create 2021-01-03 16:21
 */
@Target({ElementType.METHOD,ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Nonnull
@TypeQualifierNickname
public @interface Nullable {
}