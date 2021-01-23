package br.com.exchange.currency.factory;

import br.com.exchange.currency.domain.CurrencyRequest;
import br.com.exchange.currency.integration.exchangerate.contract.ExchangeRateResponse;
import br.com.exchange.currency.mapper.CurrencyConverterEntityMapper;
import br.com.exchange.currency.repository.entity.CurrencyConverterEntity;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@Component
public class ExchangeRateConvertionFactoryImpl implements ExchangeRateConvertionFactory {
    @Autowired
    private CurrencyConverterEntityMapper currencyConverterEntityMapper;

    @Override
    public CurrencyConverterEntity getCurrencyConveterEntity(CurrencyRequest currencyRequest, ExchangeRateResponse exchangeRateByBase) {
        final ExchangeRateResponse.RateResponse rates = exchangeRateByBase.getRates();
        switch (currencyRequest.getTargetCurrency()) {
            case BRL:
                return currencyConverterEntityMapper.toCurrencyConverterEntity(currencyRequest, rates.getBrl());

            case USD:
                return CurrencyConverterEntity.builder()
                        .idUser(currencyRequest.getIdUser())
                        .originCurrency(currencyRequest.getOriginCurrency())
                        .originValue(currencyRequest.getOriginValue())
                        .targetCurrency(currencyRequest.getTargetCurrency())
                        .targetValue(getCurrencyValueCalculated(currencyRequest.getOriginValue(), rates.getUsd()))
                        .conversionRate(rates.getUsd())
                        .dateTimeConvetion(LocalDateTime.now())
                        .build();
            case EUR:
                return CurrencyConverterEntity.builder()
                        .idUser(currencyRequest.getIdUser())
                        .originCurrency(currencyRequest.getOriginCurrency())
                        .originValue(currencyRequest.getOriginValue())
                        .targetCurrency(currencyRequest.getTargetCurrency())
                        .targetValue(getCurrencyValueCalculated(currencyRequest.getOriginValue(), rates.getEur()))
                        .conversionRate(rates.getEur())
                        .dateTimeConvetion(LocalDateTime.now())
                        .build();
            case JPY:
                return CurrencyConverterEntity.builder()
                        .idUser(currencyRequest.getIdUser())
                        .originCurrency(currencyRequest.getOriginCurrency())
                        .originValue(currencyRequest.getOriginValue())
                        .targetCurrency(currencyRequest.getTargetCurrency())
                        .targetValue(getCurrencyValueCalculated(currencyRequest.getOriginValue(), rates.getJpy()))
                        .conversionRate(rates.getJpy())
                        .dateTimeConvetion(LocalDateTime.now())
                        .build();
            default:
                throw new IllegalArgumentException("");
        }
    }

    private BigDecimal getCurrencyValueCalculated(BigDecimal originValue, BigDecimal rate) {
        return originValue.multiply(rate).setScale(2, RoundingMode.HALF_UP);
    }
}
