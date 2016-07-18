package tutorial.app.common.converter;

import java.time.LocalDate;

import org.dozer.DozerConverter;

public class LocalDateCustomConverter extends DozerConverter<LocalDate, LocalDate> {

    public LocalDateCustomConverter() {
        super(LocalDate.class, LocalDate.class);
    }

    @Override
    public LocalDate convertTo(final LocalDate source, final LocalDate destination) {

        if (source == null) {
            return null;
        }

        return LocalDate.of(
                source.getYear(),
                source.getMonthValue(),
                source.getDayOfMonth());
    }

    @Override
    public LocalDate convertFrom(final LocalDate source, final LocalDate destination) {

        if (source == null) {
            return null;
        }

        return LocalDate.of(
                source.getYear(),
                source.getMonthValue(),
                source.getDayOfMonth());
    }

}
