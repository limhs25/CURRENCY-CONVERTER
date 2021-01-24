package br.com.exchange.currency.mapper;

import br.com.exchange.currency.domain.CurrencyRequest;
import br.com.exchange.currency.repository.entity.CurrencyConverterEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Mapper(componentModel = "spring")
public interface CurrencyConverterEntityMapper {

    @Mapping(target = "targetValue",expression = "java(getCurrencyValueCalculated(currencyRequest.getOriginValue(),conversionRate))")
    @Mapping(target = "dateTimeConvetion",expression = "java(java.time.LocalDateTime.now())")
    CurrencyConverterEntity toCurrencyConverterEntity(CurrencyRequest currencyRequest, BigDecimal conversionRate);


    default BigDecimal getCurrencyValueCalculated(BigDecimal originValue, BigDecimal rate) {
        return originValue.multiply(rate).setScale(2, RoundingMode.HALF_UP);
    }

}
