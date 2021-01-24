package br.com.exchange.currency.mapper;

import br.com.exchange.currency.domain.CurrencyRequest;
import br.com.exchange.currency.domain.CurrencyResponse;
import br.com.exchange.currency.integration.exchangerate.contract.ExchangeRateResponse;
import br.com.exchange.currency.repository.entity.CurrencyConverterEntity;
import br.com.exchange.currency.templates.CurrencyConverterEntityTemplete;
import br.com.exchange.currency.templates.CurrencyRequestTemplate;
import br.com.exchange.currency.templates.ExchangeRateTemplate;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mapstruct.factory.Mappers.getMapper;

@RunWith(SpringRunner.class)
public class CurrencyConverterEntityMapperTest {

    @Spy
    private CurrencyConverterEntityMapper currencyConverterEntityMapper = getMapper(CurrencyConverterEntityMapper.class);

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.exchange.currency.templates");
    }

    @Test
    public void shouldGetCurrencyEntityMapped() {
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_BRL_TO_USD);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_BRL);
        final CurrencyConverterEntity currencyConverterEntity = currencyConverterEntityMapper.toCurrencyConverterEntity(currencyRequest, exchangeRateResponse.getRates().getBrl());
        assertNotNull(currencyConverterEntity);
    }
    @Test
    public void shouldGetCurrencyEntityWithConvertionRateAndDateConvertionBeacuseCurrencyRequestIsNull() {
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_BRL);
        final CurrencyConverterEntity currencyConverterEntity = currencyConverterEntityMapper.toCurrencyConverterEntity(null, exchangeRateResponse.getRates().getBrl());
        assertNotNull(currencyConverterEntity.getConversionRate());
        assertNotNull(currencyConverterEntity.getDateTimeConvetion());
    }
    @Test
    public void shouldGetCurrencyEntityWithoutConvertionRateAndTargetValueBeacuseConversionRateIsNull() {
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_BRL_TO_USD);
        final CurrencyConverterEntity currencyConverterEntity = currencyConverterEntityMapper.toCurrencyConverterEntity(currencyRequest, null);
        assertNull(currencyConverterEntity.getConversionRate());
        assertNull(currencyConverterEntity.getTargetValue());
    }
    @Test
    public void shouldGetCurrencyEntityWithoutTargetValueBeacuseOriginValueIsNull() {
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_BRL_TO_USD);
        currencyRequest.setOriginValue(null);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_BRL);
        final CurrencyConverterEntity currencyConverterEntity = currencyConverterEntityMapper.toCurrencyConverterEntity(currencyRequest,  exchangeRateResponse.getRates().getBrl());
        assertNull(currencyConverterEntity.getTargetValue());
    }
    @Test
    public void shouldGetCurrencyEntityNull() {
        final CurrencyConverterEntity currencyConverterEntity = currencyConverterEntityMapper.toCurrencyConverterEntity(null, null);
        assertNull(currencyConverterEntity);

    }
}
