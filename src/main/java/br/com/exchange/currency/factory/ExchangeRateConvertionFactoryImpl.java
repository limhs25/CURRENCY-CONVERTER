package br.com.exchange.currency.factory;

import br.com.exchange.currency.config.enums.BaseCurrencyEnum;
import br.com.exchange.currency.domain.CurrencyRequest;
import br.com.exchange.currency.integration.exchangerate.contract.ExchangeRateResponse;
import br.com.exchange.currency.repository.entity.CurrencyConverterEntity;
import org.springframework.stereotype.Component;

@Component
public class ExchangeRateConvertionFactoryImpl implements ExchangeRateConvertionFactory {

    @Override
    public CurrencyConverterEntity getCurrencyConveterEntity(CurrencyRequest currencyRequest, ExchangeRateResponse exchangeRateByBase) throws Exception {

        switch (currencyRequest.getOriginCurrency()) {
            case BRL:
                return null;
            case USD:
                return null;
            case EUR:
                return null;
            case JPY:
                return null;
            default:
                throw new Exception();
        }
    }
}
