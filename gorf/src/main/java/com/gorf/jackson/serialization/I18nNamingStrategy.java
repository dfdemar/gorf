package com.gorf.jackson.serialization;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;

import java.util.Map;

/**
 * Changes an I18N key into the translated value for a schema property name.
 *
 * To use this feature, the I18N key should be added to the {@link JsonProperty} annotation.
 * Example: {@code
 *
 * @JsonProperty("Name.Property.I18N.Key")
 * private String name;
 *
 * }
 */
public class I18nNamingStrategy extends PropertyNamingStrategy {

    private final Map<String, String> i18nTranslations;

    public I18nNamingStrategy(Map<String, String> i18nTranslations) {
        this.i18nTranslations = i18nTranslations;
    }

    @Override
    public String nameForField(MapperConfig<?> config, AnnotatedField field, String defaultName) {
        return translate(field.getAnnotation(JsonProperty.class), defaultName);
    }

    @Override
    public String nameForSetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
        return translate(method.getAnnotation(JsonProperty.class), defaultName);
    }

    @Override
    public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
        return translate(method.getAnnotation(JsonProperty.class), defaultName);
    }

    private String translate(JsonProperty jsonProperty, String defaultName) {
        if (jsonProperty == null) {
            return defaultName;
        }

        return i18nTranslations.getOrDefault(jsonProperty.value(), defaultName);
    }
}
