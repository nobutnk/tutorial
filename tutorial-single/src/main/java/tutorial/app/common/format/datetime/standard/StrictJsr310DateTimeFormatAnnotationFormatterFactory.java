package tutorial.app.common.format.datetime.standard;

import java.time.format.DateTimeFormatter;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.standard.Jsr310DateTimeFormatAnnotationFormatterFactory;

public class StrictJsr310DateTimeFormatAnnotationFormatterFactory extends Jsr310DateTimeFormatAnnotationFormatterFactory {

    /**
     * Factory method used to create a {@link DateTimeFormatter}.
     * 
     * @param annotation
     *            the format annotation for the field
     * @param fieldType
     *            the type of field
     * @return a {@link DateTimeFormatter} instance
     */
    protected DateTimeFormatter getFormatter(DateTimeFormat annotation, Class<?> fieldType) {
        StrictDateTimeFormatterFactory factory = new StrictDateTimeFormatterFactory();
        factory.setStylePattern(resolveEmbeddedValue(annotation.style()));
        factory.setIso(annotation.iso());
        factory.setPattern(resolveEmbeddedValue(annotation.pattern()));
        return factory.createDateTimeFormatter();
    }

}
