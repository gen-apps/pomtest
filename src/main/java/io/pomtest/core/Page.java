package io.pomtest.core;

import java.util.Locale;
import java.util.function.Consumer;

public class Page<T extends Page<T>> {

    @SuppressWarnings("unchecked")
    private final T _self = (T) this;

    public T job(Consumer<T> consumer) {
        consumer.accept(_self);

        return _self;
    }

    public Locale getLocale() {
        return null;
    }
}
