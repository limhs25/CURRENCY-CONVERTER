package br.com.exchange.currency.config.annotation;

import br.com.exchange.currency.enums.BaseCurrencyEnum;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

@Slf4j
public class EnumNamePatternValidator implements ConstraintValidator<EnumNamePattern, BaseCurrencyEnum> {
    private BaseCurrencyEnum [] baseCurrencyEnums;

    @Override
    public void initialize(EnumNamePattern annotation) {
        this.baseCurrencyEnums = annotation.anyOf();
    }

    @Override
    public boolean isValid(BaseCurrencyEnum value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(baseCurrencyEnums)
                .contains(value);
    }
}