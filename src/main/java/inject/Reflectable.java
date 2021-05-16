package inject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Retention(RetentionPolicy.RUNTIME) говорит, что аннотация будет использована в рантайме,
 * а это значит, можно получить к ней доступ с помощью рефлексии.
 * @Target(ElementType.TYPE) говорит, что аннотацию можно использовать на интерфейсах и классах.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Reflectable {}
