package br.com.exchange.currency.service;

import br.com.exchange.currency.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class CurrencyService implements Serializable {

    @Autowired
    private CurrencyRepository currencyRepository;


}
