package com.gorf.jackson.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/**
 * If a schema property value is an I18N key, this converts it to the translated value.
 *
 * @param <T> the type of object to be serialized
 */
public class I18nSerializer<T> extends JsonSerializer<T> {

    private final Map<String, String> i18nTranslations;

    public I18nSerializer(Map<String, String> i18nTranslations) {
        Objects.requireNonNull(i18nTranslations);
        this.i18nTranslations = i18nTranslations;
    }

    @Override
    public void serialize(T value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        String i18nKey = value.toString();
        gen.writeString(i18nTranslations.getOrDefault(i18nKey, i18nKey));
    }
}
