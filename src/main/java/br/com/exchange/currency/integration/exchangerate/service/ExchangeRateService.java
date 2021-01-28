package br.com.exchange.currency.integration.exchangerate.service;

import br.com.exchange.currency.integration.exchangerate.client.ExchangeRateClient;
import br.com.exchange.currency.integration.exchangerate.contract.ExchangeRateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateService {

    @Autowired
    private ExchangeRateClient client;

    public ExchangeRateResponse getExchangeRateByBase(String base){
        return client.getExchangeRateByBase(base).getBody();
    }
}
