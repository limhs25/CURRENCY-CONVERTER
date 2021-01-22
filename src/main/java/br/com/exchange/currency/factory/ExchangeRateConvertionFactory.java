package br.com.exchange.currency.factory;

import br.com.exchange.currency.domain.CurrencyRequest;
import br.com.exchange.currency.integration.exchangerate.contract.ExchangeRateResponse;
import br.com.exchange.currency.repository.entity.CurrencyConverterEntity;

public interface ExchangeRateConvertionFactory {
    CurrencyConverterEntity getCurrencyConveterEntity(CurrencyRequest currencyRequest, ExchangeRateResponse exchangeRateByBase) throws Exception;
}
