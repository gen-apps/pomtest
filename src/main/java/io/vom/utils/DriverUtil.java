package io.vom.utils;

import io.vom.core.Element;
import io.vom.exceptions.ElementNotFoundException;
import org.openqa.selenium.SearchContext;

import java.time.Duration;
import java.time.LocalDate;
import java.util.function.Supplier;

public class DriverUtil {

    public static Element waitUntil(Duration duration, Supplier<Element> supplier) {
        var endTime = LocalDate.now().plus(duration);
        ElementNotFoundException error = null;
        while (LocalDate.now().isBefore(endTime)) {
            try {
                return supplier.get();
            } catch (ElementNotFoundException e) {
                error = e;
            }
        }

        //noinspection ConstantConditions
        throw error;
    }
}
