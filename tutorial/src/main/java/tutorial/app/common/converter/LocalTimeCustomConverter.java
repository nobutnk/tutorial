package tutorial.app.common.converter;

import java.time.LocalTime;

import org.dozer.DozerConverter;

public class LocalTimeCustomConverter extends DozerConverter<LocalTime, LocalTime> {

    public LocalTimeCustomConverter() {
        super(LocalTime.class, LocalTime.class);
    }

    @Override
    public LocalTime convertTo(final LocalTime source, final LocalTime destination) {

        if (source == null) {
            return null;
        }

        return LocalTime.of(
                source.getHour(),
                source.getMinute(),
                source.getSecond(),
                source.getNano());
    }

    @Override
    public LocalTime convertFrom(final LocalTime source, final LocalTime destination) {

        if (source == null) {
            return null;
        }

        return LocalTime.of(
                source.getHour(),
                source.getMinute(),
                source.getSecond(),
                source.getNano());
    }

}
