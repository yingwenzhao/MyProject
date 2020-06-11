package mock;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * 使用：
 * @MockConfiguration（
 * {
 *      "class , MockInfo.mockType , class.methodName.lineNo",
 *      "class , MockInfo.mockType , class.methodName.lineNo",
 *      ...
 * }
 * ）
 *
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MockConfiguration {

    String [] value() default {};
    String info() default "";

}
