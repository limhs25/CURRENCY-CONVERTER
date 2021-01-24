package br.com.exchange.currency.factory;

import br.com.exchange.currency.domain.CurrencyRequest;
import br.com.exchange.currency.enums.BaseCurrencyEnum;
import br.com.exchange.currency.integration.exchangerate.contract.ExchangeRateResponse;
import br.com.exchange.currency.mapper.CurrencyConverterEntityMapper;
import br.com.exchange.currency.repository.entity.CurrencyConverterEntity;
import br.com.exchange.currency.templates.CurrencyConverterEntityTemplete;
import br.com.exchange.currency.templates.CurrencyRequestTemplate;
import br.com.exchange.currency.templates.ExchangeRateTemplate;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mapstruct.factory.Mappers.getMapper;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ExchangeRateConvertionFactoryImplTest {

    @Spy
    private CurrencyConverterEntityMapper currencyConverterEntityMapper = getMapper(CurrencyConverterEntityMapper.class);

    @InjectMocks
    private ExchangeRateConvertionFactoryImpl exchangeRateConvertionFactory;

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.exchange.currency.templates");
    }

    @Test
    public void shouldConverterCurrencyBaseBrlToUsdTargetCurrency(){
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_BRL_TO_USD);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_BRL);
        CurrencyConverterEntity currencyConverterEntity = currencyConverterEntityMapper.toCurrencyConverterEntity(currencyRequest, exchangeRateResponse.getRates().getUsd());
        final CurrencyConverterEntity response = exchangeRateConvertionFactory.getCurrencyConveterEntity(currencyRequest, exchangeRateResponse);

        assertNotNull(response);
        assertThat(response.getIdUser()).isEqualTo(currencyConverterEntity.getIdUser());
        assertThat(response.getOriginCurrency()).isEqualTo(currencyConverterEntity.getOriginCurrency());
        assertThat(response.getOriginValue()).isEqualTo(currencyConverterEntity.getOriginValue());
        assertThat(response.getTargetCurrency()).isEqualTo(currencyConverterEntity.getTargetCurrency());
        assertThat(response.getTargetValue()).isEqualTo(currencyConverterEntity.getTargetValue());

    }
    @Test
    public void shouldConverterCurrencyBaseBrlToEurTargetCurrency(){
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_BRL_TO_EUR);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_BRL);
        CurrencyConverterEntity currencyConverterEntity = currencyConverterEntityMapper.toCurrencyConverterEntity(currencyRequest, exchangeRateResponse.getRates().getEur());
        final CurrencyConverterEntity response = exchangeRateConvertionFactory.getCurrencyConveterEntity(currencyRequest, exchangeRateResponse);

        assertNotNull(response);
        assertThat(response.getIdUser()).isEqualTo(currencyConverterEntity.getIdUser());
        assertThat(response.getOriginCurrency()).isEqualTo(currencyConverterEntity.getOriginCurrency());
        assertThat(response.getOriginValue()).isEqualTo(currencyConverterEntity.getOriginValue());
        assertThat(response.getTargetCurrency()).isEqualTo(currencyConverterEntity.getTargetCurrency());
        assertThat(response.getTargetValue()).isEqualTo(currencyConverterEntity.getTargetValue());
    }
    @Test
    public void shouldConverterCurrencyBaseBrlToJpyTargetCurrency(){
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_BRL_TO_JPY);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_BRL);
        CurrencyConverterEntity currencyConverterEntity = currencyConverterEntityMapper.toCurrencyConverterEntity(currencyRequest, exchangeRateResponse.getRates().getJpy());
        final CurrencyConverterEntity response = exchangeRateConvertionFactory.getCurrencyConveterEntity(currencyRequest, exchangeRateResponse);

        assertNotNull(response);
        assertThat(response.getIdUser()).isEqualTo(currencyConverterEntity.getIdUser());
        assertThat(response.getOriginCurrency()).isEqualTo(currencyConverterEntity.getOriginCurrency());
        assertThat(response.getOriginValue()).isEqualTo(currencyConverterEntity.getOriginValue());
        assertThat(response.getTargetCurrency()).isEqualTo(currencyConverterEntity.getTargetCurrency());
        assertThat(response.getTargetValue()).isEqualTo(currencyConverterEntity.getTargetValue());
    }
    @Test
    public void shouldConverterCurrencyBaseUsdToBrlTargetCurrency(){
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_USD_TO_BRL);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_USD);
        CurrencyConverterEntity currencyConverterEntity = currencyConverterEntityMapper.toCurrencyConverterEntity(currencyRequest, exchangeRateResponse.getRates().getBrl());
        final CurrencyConverterEntity response = exchangeRateConvertionFactory.getCurrencyConveterEntity(currencyRequest, exchangeRateResponse);

        assertNotNull(response);
        assertThat(response.getIdUser()).isEqualTo(currencyConverterEntity.getIdUser());
        assertThat(response.getOriginCurrency()).isEqualTo(currencyConverterEntity.getOriginCurrency());
        assertThat(response.getOriginValue()).isEqualTo(currencyConverterEntity.getOriginValue());
        assertThat(response.getTargetCurrency()).isEqualTo(currencyConverterEntity.getTargetCurrency());
        assertThat(response.getTargetValue()).isEqualTo(currencyConverterEntity.getTargetValue());

    }
    @Test
    public void shouldConverterCurrencyBaseUsdToEurTargetCurrency(){
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_USD_TO_EUR);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_USD);
        CurrencyConverterEntity currencyConverterEntity = currencyConverterEntityMapper.toCurrencyConverterEntity(currencyRequest, exchangeRateResponse.getRates().getEur());
        final CurrencyConverterEntity response = exchangeRateConvertionFactory.getCurrencyConveterEntity(currencyRequest, exchangeRateResponse);

        assertNotNull(response);
        assertThat(response.getIdUser()).isEqualTo(currencyConverterEntity.getIdUser());
        assertThat(response.getOriginCurrency()).isEqualTo(currencyConverterEntity.getOriginCurrency());
        assertThat(response.getOriginValue()).isEqualTo(currencyConverterEntity.getOriginValue());
        assertThat(response.getTargetCurrency()).isEqualTo(currencyConverterEntity.getTargetCurrency());
        assertThat(response.getTargetValue()).isEqualTo(currencyConverterEntity.getTargetValue());
    }
    @Test
    public void shouldConverterCurrencyBaseUsdToJpyTargetCurrency(){
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_USD_TO_JPY);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_USD);
        CurrencyConverterEntity currencyConverterEntity = currencyConverterEntityMapper.toCurrencyConverterEntity(currencyRequest, exchangeRateResponse.getRates().getJpy());
        final CurrencyConverterEntity response = exchangeRateConvertionFactory.getCurrencyConveterEntity(currencyRequest, exchangeRateResponse);

        assertNotNull(response);
        assertThat(response.getIdUser()).isEqualTo(currencyConverterEntity.getIdUser());
        assertThat(response.getOriginCurrency()).isEqualTo(currencyConverterEntity.getOriginCurrency());
        assertThat(response.getOriginValue()).isEqualTo(currencyConverterEntity.getOriginValue());
        assertThat(response.getTargetCurrency()).isEqualTo(currencyConverterEntity.getTargetCurrency());
        assertThat(response.getTargetValue()).isEqualTo(currencyConverterEntity.getTargetValue());
    }
    @Test
    public void shouldConverterCurrencyBaseEurToBrlTargetCurrency(){
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_EUR_TO_BRL);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_EUR);
        CurrencyConverterEntity currencyConverterEntity = currencyConverterEntityMapper.toCurrencyConverterEntity(currencyRequest, exchangeRateResponse.getRates().getBrl());
        final CurrencyConverterEntity response = exchangeRateConvertionFactory.getCurrencyConveterEntity(currencyRequest, exchangeRateResponse);

        assertNotNull(response);
        assertThat(response.getIdUser()).isEqualTo(currencyConverterEntity.getIdUser());
        assertThat(response.getOriginCurrency()).isEqualTo(currencyConverterEntity.getOriginCurrency());
        assertThat(response.getOriginValue()).isEqualTo(currencyConverterEntity.getOriginValue());
        assertThat(response.getTargetCurrency()).isEqualTo(currencyConverterEntity.getTargetCurrency());
        assertThat(response.getTargetValue()).isEqualTo(currencyConverterEntity.getTargetValue());
    }
    @Test
    public void shouldConverterCurrencyBaseEurToUsdTargetCurrency(){
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_EUR_TO_USD);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_EUR);
        CurrencyConverterEntity currencyConverterEntity = currencyConverterEntityMapper.toCurrencyConverterEntity(currencyRequest, exchangeRateResponse.getRates().getUsd());
        final CurrencyConverterEntity response = exchangeRateConvertionFactory.getCurrencyConveterEntity(currencyRequest, exchangeRateResponse);

        assertNotNull(response);
        assertThat(response.getIdUser()).isEqualTo(currencyConverterEntity.getIdUser());
        assertThat(response.getOriginCurrency()).isEqualTo(currencyConverterEntity.getOriginCurrency());
        assertThat(response.getOriginValue()).isEqualTo(currencyConverterEntity.getOriginValue());
        assertThat(response.getTargetCurrency()).isEqualTo(currencyConverterEntity.getTargetCurrency());
        assertThat(response.getTargetValue()).isEqualTo(currencyConverterEntity.getTargetValue());
    }
    @Test
    public void shouldConverterCurrencyBaseEurToJpyTargetCurrency(){
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_EUR_TO_JPY);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_EUR);
        CurrencyConverterEntity currencyConverterEntity = currencyConverterEntityMapper.toCurrencyConverterEntity(currencyRequest, exchangeRateResponse.getRates().getJpy());
        final CurrencyConverterEntity response = exchangeRateConvertionFactory.getCurrencyConveterEntity(currencyRequest, exchangeRateResponse);

        assertNotNull(response);
        assertThat(response.getIdUser()).isEqualTo(currencyConverterEntity.getIdUser());
        assertThat(response.getOriginCurrency()).isEqualTo(currencyConverterEntity.getOriginCurrency());
        assertThat(response.getOriginValue()).isEqualTo(currencyConverterEntity.getOriginValue());
        assertThat(response.getTargetCurrency()).isEqualTo(currencyConverterEntity.getTargetCurrency());
        assertThat(response.getTargetValue()).isEqualTo(currencyConverterEntity.getTargetValue());
    }
    @Test
    public void shouldConverterCurrencyBaseJpyToBrlTargetCurrency(){
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_JPY_TO_BRL);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_JPY);
        CurrencyConverterEntity currencyConverterEntity = currencyConverterEntityMapper.toCurrencyConverterEntity(currencyRequest, exchangeRateResponse.getRates().getBrl());
        final CurrencyConverterEntity response = exchangeRateConvertionFactory.getCurrencyConveterEntity(currencyRequest, exchangeRateResponse);

        assertNotNull(response);
        assertThat(response.getIdUser()).isEqualTo(currencyConverterEntity.getIdUser());
        assertThat(response.getOriginCurrency()).isEqualTo(currencyConverterEntity.getOriginCurrency());
        assertThat(response.getOriginValue()).isEqualTo(currencyConverterEntity.getOriginValue());
        assertThat(response.getTargetCurrency()).isEqualTo(currencyConverterEntity.getTargetCurrency());
        assertThat(response.getTargetValue()).isEqualTo(currencyConverterEntity.getTargetValue());
    }
    @Test
    public void shouldConverterCurrencyBaseJpyToUsdTargetCurrency(){
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_JPY_TO_USD);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_JPY);
        CurrencyConverterEntity currencyConverterEntity = currencyConverterEntityMapper.toCurrencyConverterEntity(currencyRequest, exchangeRateResponse.getRates().getUsd());
        final CurrencyConverterEntity response = exchangeRateConvertionFactory.getCurrencyConveterEntity(currencyRequest, exchangeRateResponse);

        assertNotNull(response);
        assertThat(response.getIdUser()).isEqualTo(currencyConverterEntity.getIdUser());
        assertThat(response.getOriginCurrency()).isEqualTo(currencyConverterEntity.getOriginCurrency());
        assertThat(response.getOriginValue()).isEqualTo(currencyConverterEntity.getOriginValue());
        assertThat(response.getTargetCurrency()).isEqualTo(currencyConverterEntity.getTargetCurrency());
        assertThat(response.getTargetValue()).isEqualTo(currencyConverterEntity.getTargetValue());
    }
    @Test
    public void shouldConverterCurrencyBaseJpyToEurTargetCurrency(){
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_JPY_TO_EUR);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_JPY);
        CurrencyConverterEntity currencyConverterEntity = currencyConverterEntityMapper.toCurrencyConverterEntity(currencyRequest, exchangeRateResponse.getRates().getEur());
        final CurrencyConverterEntity response = exchangeRateConvertionFactory.getCurrencyConveterEntity(currencyRequest, exchangeRateResponse);

        assertNotNull(response);
        assertThat(response.getIdUser()).isEqualTo(currencyConverterEntity.getIdUser());
        assertThat(response.getOriginCurrency()).isEqualTo(currencyConverterEntity.getOriginCurrency());
        assertThat(response.getOriginValue()).isEqualTo(currencyConverterEntity.getOriginValue());
        assertThat(response.getTargetCurrency()).isEqualTo(currencyConverterEntity.getTargetCurrency());
        assertThat(response.getTargetValue()).isEqualTo(currencyConverterEntity.getTargetValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrownExceptionBecasuseTargetCurrencyInvalid(){
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_JPY_TO_USD);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_JPY);
        currencyRequest.setTargetCurrency(BaseCurrencyEnum.UNKNOWN);

        final CurrencyConverterEntity response = exchangeRateConvertionFactory.getCurrencyConveterEntity(currencyRequest, exchangeRateResponse);

    }

}
