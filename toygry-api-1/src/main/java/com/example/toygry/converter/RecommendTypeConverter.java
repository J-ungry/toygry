package com.example.toygry.converter;

import com.example.toygry.entity.RecommendType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RecommendTypeConverter implements AttributeConverter<RecommendType, String> {

    @Override
    public String convertToDatabaseColumn(RecommendType recommendType) {
        return recommendType == null ? null : recommendType.name();
    }

    @Override
    public RecommendType convertToEntityAttribute(String dbData) {
        return dbData == null ? null : RecommendType.valueOf(dbData);
    }
}
