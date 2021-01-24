package br.com.exchange.currency.factory;

import br.com.exchange.currency.mapper.CurrencyConverterEntityMapper;
import org.mockito.Spy;

import static org.mapstruct.factory.Mappers.getMapper;

public class ExchangeRateConvertionFactoryImplTest {
    @Spy
    private CurrencyConverterEntityMapper currencyConverterEntityMapper = getMapper(CurrencyConverterEntityMapper.class);
}
