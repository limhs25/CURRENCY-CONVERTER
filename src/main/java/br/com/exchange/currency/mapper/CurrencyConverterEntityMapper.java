package br.com.exchange.currency.mapper;

import br.com.exchange.currency.domain.CurrencyRequest;
import br.com.exchange.currency.repository.entity.CurrencyConverterEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Mapper(componentModel = "spring")
public interface CurrencyConverterEntityMapper {

    @Mapping(target = "targetValue",expression = "java(getCurrencyValueCalculated(currencyRequest,conversionRate))")
    @Mapping(target = "dateTimeConvetion",expression = "java(java.time.LocalDateTime.now())")
    CurrencyConverterEntity toCurrencyConverterEntity(CurrencyRequest currencyRequest, BigDecimal conversionRate);


    default BigDecimal getCurrencyValueCalculated(CurrencyRequest currencyRequest, BigDecimal rate) {
        BigDecimal currencyValueCalculed = null;
        if(Objects.nonNull(currencyRequest) && Objects.nonNull(currencyRequest.getOriginValue()) && Objects.nonNull(rate)){
            currencyValueCalculed =  currencyRequest.getOriginValue().multiply(rate).setScale(2, RoundingMode.HALF_UP);
        }
        return currencyValueCalculed;
    }

}
