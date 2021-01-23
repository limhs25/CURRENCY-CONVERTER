package br.com.exchange.currency.factory;

import br.com.exchange.currency.domain.CurrencyRequest;
import br.com.exchange.currency.integration.exchangerate.contract.ExchangeRateResponse;
import br.com.exchange.currency.mapper.CurrencyConverterEntityMapper;
import br.com.exchange.currency.repository.entity.CurrencyConverterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
                return currencyConverterEntityMapper.toCurrencyConverterEntity(currencyRequest, rates.getUsd());

            case EUR:
                return currencyConverterEntityMapper.toCurrencyConverterEntity(currencyRequest, rates.getEur());

            case JPY:
                return currencyConverterEntityMapper.toCurrencyConverterEntity(currencyRequest, rates.getJpy());

            default:
                throw new IllegalArgumentException("Target Currency not supported");
        }
    }
}
