package tutorial.app.common.converter;

import java.time.LocalDateTime;

import org.dozer.DozerConverter;

public class LocalDateTimeCustomConverter extends DozerConverter<LocalDateTime, LocalDateTime> {

    public LocalDateTimeCustomConverter() {
        super(LocalDateTime.class, LocalDateTime.class);
    }

    @Override
    public LocalDateTime convertTo(final LocalDateTime source, final LocalDateTime destination) {

        if (source == null) {
            return null;
        }

        return LocalDateTime.of(
                source.getYear(),
                source.getMonthValue(),
                source.getDayOfMonth(),
                source.getHour(),
                source.getMinute(),
                source.getSecond(),
                source.getNano());
    }

    @Override
    public LocalDateTime convertFrom(final LocalDateTime source, final LocalDateTime destination) {

        if (source == null) {
            return null;
        }

        return LocalDateTime.of(
                source.getYear(),
                source.getMonthValue(),
                source.getDayOfMonth(),
                source.getHour(),
                source.getMinute(),
                source.getSecond(),
                source.getNano());
    }

}
