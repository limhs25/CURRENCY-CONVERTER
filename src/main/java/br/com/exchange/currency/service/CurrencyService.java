package br.com.exchange.currency.service;

import br.com.exchange.currency.domain.CurrencyRequest;
import br.com.exchange.currency.domain.CurrencyResponse;
import br.com.exchange.currency.factory.ExchangeRateConvertionFactory;
import br.com.exchange.currency.integration.exchangerate.contract.ExchangeRateResponse;
import br.com.exchange.currency.integration.exchangerate.service.ExchangeRateService;
import br.com.exchange.currency.repository.CurrencyRepository;
import br.com.exchange.currency.repository.entity.CurrencyConverterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private ExchangeRateService exchangeRateService;

    @Autowired
    private ExchangeRateConvertionFactory convertionFactory;

    public CurrencyResponse registerCurrencyConverter(CurrencyRequest currencyRequest) {
        final String origingCurrencyBase = currencyRequest.getOriginCurrency().toString();
        final ExchangeRateResponse exchangeRateByBase = exchangeRateService.getExchangeRateByBase(origingCurrencyBase);
        final CurrencyConverterEntity currencyConveterEntity = convertionFactory.getCurrencyConveterEntity(currencyRequest, exchangeRateByBase);

        return null;
    }

    public List<CurrencyResponse> getCurrencyConvertionsByIdUser(Long idUser) {
        return null;
    }

}
