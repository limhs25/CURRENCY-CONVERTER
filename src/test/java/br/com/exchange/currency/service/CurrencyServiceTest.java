package br.com.exchange.currency.service;

import br.com.exchange.currency.domain.CurrencyRequest;
import br.com.exchange.currency.domain.CurrencyResponse;
import br.com.exchange.currency.factory.ExchangeRateConvertionFactory;
import br.com.exchange.currency.integration.exchangerate.contract.ExchangeRateResponse;
import br.com.exchange.currency.integration.exchangerate.service.ExchangeRateService;
import br.com.exchange.currency.mapper.CorrencyResponseMapper;
import br.com.exchange.currency.mapper.CurrencyConverterEntityMapper;
import br.com.exchange.currency.repository.CurrencyRepository;
import br.com.exchange.currency.repository.entity.CurrencyConverterEntity;
import br.com.exchange.currency.templates.CurrencyConverterEntityTemplete;
import br.com.exchange.currency.templates.CurrencyRequestTemplate;
import br.com.exchange.currency.templates.ExchangeRateTemplate;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mapstruct.factory.Mappers.getMapper;

@RunWith(SpringRunner.class)
public class CurrencyServiceTest {


    @Mock
    private ExchangeRateService exchangeRateService;

    @Spy
    private ExchangeRateConvertionFactory convertionFactory;

    @Spy
    private CorrencyResponseMapper correncyResponseMapper = getMapper(CorrencyResponseMapper.class);

    @Spy
    private CurrencyConverterEntityMapper currencyConverterEntityMapper = getMapper(CurrencyConverterEntityMapper.class);

    @Mock
    private CurrencyRepository currencyRepository;

    @InjectMocks
    private CurrencyService currencyService;

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.exchange.currency.templates");
    }

    @Test
    public void shouldCreateCurrecyConvetionFromBrlBaseToUsdAndReturnTheConversion() {
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_BRL_TO_USD);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_BRL);
        CurrencyConverterEntity currencyConverterEntity = Fixture.from(CurrencyConverterEntity.class).gimme(CurrencyConverterEntityTemplete.VALID_ENTITY_BRL_TO_USD);
        CurrencyResponse currencyResponse = correncyResponseMapper.toCurrencyResponse(currencyConverterEntity);

        Mockito.when(exchangeRateService.getExchangeRateByBase(Mockito.anyString())).thenReturn(exchangeRateResponse);
        Mockito.when(currencyRepository.saveAndFlush(Mockito.any())).thenReturn(currencyConverterEntity);

        final CurrencyResponse response = currencyService.registerCurrencyConverter(currencyRequest);

        assertNotNull(response);
        assertThat(response)
                .usingRecursiveComparison()
                .isEqualTo(currencyResponse);

    }
    @Test
    public void shouldCreateCurrecyConvetionFromBrlBaseToEurAndReturnTheConversion() {
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_BRL_TO_EUR);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_BRL);
        CurrencyConverterEntity currencyConverterEntity = Fixture.from(CurrencyConverterEntity.class).gimme(CurrencyConverterEntityTemplete.VALID_ENTITY_BRL_TO_EUR);
        CurrencyResponse currencyResponse = correncyResponseMapper.toCurrencyResponse(currencyConverterEntity);

        Mockito.when(exchangeRateService.getExchangeRateByBase(Mockito.anyString())).thenReturn(exchangeRateResponse);
        Mockito.when(currencyRepository.saveAndFlush(Mockito.any())).thenReturn(currencyConverterEntity);

        final CurrencyResponse response = currencyService.registerCurrencyConverter(currencyRequest);

        assertNotNull(response);
        assertThat(response)
                .usingRecursiveComparison()
                .isEqualTo(currencyResponse);

    }

    @Test
    public void shouldCreateCurrecyConvetionFromBrlBaseToJpyAndReturnTheConversion() {
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_BRL_TO_JPY);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_BRL);
        CurrencyConverterEntity currencyConverterEntity = Fixture.from(CurrencyConverterEntity.class).gimme(CurrencyConverterEntityTemplete.VALID_ENTITY_BRL_TO_JPY);
        CurrencyResponse currencyResponse = correncyResponseMapper.toCurrencyResponse(currencyConverterEntity);

        Mockito.when(exchangeRateService.getExchangeRateByBase(Mockito.anyString())).thenReturn(exchangeRateResponse);
        Mockito.when(currencyRepository.saveAndFlush(Mockito.any())).thenReturn(currencyConverterEntity);

        final CurrencyResponse response = currencyService.registerCurrencyConverter(currencyRequest);

        assertNotNull(response);
        assertThat(response)
                .usingRecursiveComparison()
                .isEqualTo(currencyResponse);
    }

    @Test
    public void shouldCreateCurrecyConvetionFromUsdBaseToBrlAndReturnTheConversion() {
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_USD_TO_BRL);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_USD);
        CurrencyConverterEntity currencyConverterEntity = Fixture.from(CurrencyConverterEntity.class).gimme(CurrencyConverterEntityTemplete.VALID_ENTITY_USD_TO_BRL);
        CurrencyResponse currencyResponse = correncyResponseMapper.toCurrencyResponse(currencyConverterEntity);

        Mockito.when(exchangeRateService.getExchangeRateByBase(Mockito.anyString())).thenReturn(exchangeRateResponse);
        Mockito.when(currencyRepository.saveAndFlush(Mockito.any())).thenReturn(currencyConverterEntity);

        final CurrencyResponse response = currencyService.registerCurrencyConverter(currencyRequest);

        assertNotNull(response);
        assertThat(response)
                .usingRecursiveComparison()
                .isEqualTo(currencyResponse);

    }
    @Test
    public void shouldCreateCurrecyConvetionFromUsdBaseToEurAndReturnTheConversion() {
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_USD_TO_EUR);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_USD);
        CurrencyConverterEntity currencyConverterEntity = Fixture.from(CurrencyConverterEntity.class).gimme(CurrencyConverterEntityTemplete.VALID_ENTITY_USD_TO_EUR);
        CurrencyResponse currencyResponse = correncyResponseMapper.toCurrencyResponse(currencyConverterEntity);

        Mockito.when(exchangeRateService.getExchangeRateByBase(Mockito.anyString())).thenReturn(exchangeRateResponse);
        Mockito.when(currencyRepository.saveAndFlush(Mockito.any())).thenReturn(currencyConverterEntity);

        final CurrencyResponse response = currencyService.registerCurrencyConverter(currencyRequest);

        assertNotNull(response);
        assertThat(response)
                .usingRecursiveComparison()
                .isEqualTo(currencyResponse);

    }
    @Test
    public void shouldCreateCurrecyConvetionFromUsdBaseToJpyAndReturnTheConversion() {
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_USD_TO_JPY);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_USD);
        CurrencyConverterEntity currencyConverterEntity = Fixture.from(CurrencyConverterEntity.class).gimme(CurrencyConverterEntityTemplete.VALID_ENTITY_USD_TO_JPY);
        CurrencyResponse currencyResponse = correncyResponseMapper.toCurrencyResponse(currencyConverterEntity);

        Mockito.when(exchangeRateService.getExchangeRateByBase(Mockito.anyString())).thenReturn(exchangeRateResponse);
        Mockito.when(currencyRepository.saveAndFlush(Mockito.any())).thenReturn(currencyConverterEntity);

        final CurrencyResponse response = currencyService.registerCurrencyConverter(currencyRequest);

        assertNotNull(response);
        assertThat(response)
                .usingRecursiveComparison()
                .isEqualTo(currencyResponse);

    }

    @Test
    public void shouldCreateCurrecyConvetionFromEurBaseToBrlAndReturnTheConversion() {
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_EUR_TO_BRL);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_EUR);
        CurrencyConverterEntity currencyConverterEntity = Fixture.from(CurrencyConverterEntity.class).gimme(CurrencyConverterEntityTemplete.VALID_ENTITY_EUR_TO_BRL);
        CurrencyResponse currencyResponse = correncyResponseMapper.toCurrencyResponse(currencyConverterEntity);

        Mockito.when(exchangeRateService.getExchangeRateByBase(Mockito.anyString())).thenReturn(exchangeRateResponse);
        Mockito.when(currencyRepository.saveAndFlush(Mockito.any())).thenReturn(currencyConverterEntity);

        final CurrencyResponse response = currencyService.registerCurrencyConverter(currencyRequest);

        assertNotNull(response);
        assertThat(response)
                .usingRecursiveComparison()
                .isEqualTo(currencyResponse);

    }

    @Test
    public void shouldCreateCurrecyConvetionFromEurBaseToUsdAndReturnTheConversion() {
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_EUR_TO_USD);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_EUR);
        CurrencyConverterEntity currencyConverterEntity = Fixture.from(CurrencyConverterEntity.class).gimme(CurrencyConverterEntityTemplete.VALID_ENTITY_EUR_TO_USD);
        CurrencyResponse currencyResponse = correncyResponseMapper.toCurrencyResponse(currencyConverterEntity);

        Mockito.when(exchangeRateService.getExchangeRateByBase(Mockito.anyString())).thenReturn(exchangeRateResponse);
        Mockito.when(currencyRepository.saveAndFlush(Mockito.any())).thenReturn(currencyConverterEntity);

        final CurrencyResponse response = currencyService.registerCurrencyConverter(currencyRequest);

        assertNotNull(response);
        assertThat(response)
                .usingRecursiveComparison()
                .isEqualTo(currencyResponse);

    }

    @Test
    public void shouldCreateCurrecyConvetionFromEurBaseToJpyAndReturnTheConversion() {
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_EUR_TO_JPY);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_EUR);
        CurrencyConverterEntity currencyConverterEntity = Fixture.from(CurrencyConverterEntity.class).gimme(CurrencyConverterEntityTemplete.VALID_ENTITY_EUR_TO_JPY);
        CurrencyResponse currencyResponse = correncyResponseMapper.toCurrencyResponse(currencyConverterEntity);

        Mockito.when(exchangeRateService.getExchangeRateByBase(Mockito.anyString())).thenReturn(exchangeRateResponse);
        Mockito.when(currencyRepository.saveAndFlush(Mockito.any())).thenReturn(currencyConverterEntity);

        final CurrencyResponse response = currencyService.registerCurrencyConverter(currencyRequest);

        assertNotNull(response);
        assertThat(response)
                .usingRecursiveComparison()
                .isEqualTo(currencyResponse);

    }

    @Test
    public void shouldCreateCurrecyConvetionFromJpyBaseToBrlAndReturnTheConversion() {
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_JPY_TO_BRL);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_JPY);
        CurrencyConverterEntity currencyConverterEntity = Fixture.from(CurrencyConverterEntity.class).gimme(CurrencyConverterEntityTemplete.VALID_ENTITY_JPY_TO_BRL);
        CurrencyResponse currencyResponse = correncyResponseMapper.toCurrencyResponse(currencyConverterEntity);

        Mockito.when(exchangeRateService.getExchangeRateByBase(Mockito.anyString())).thenReturn(exchangeRateResponse);
        Mockito.when(currencyRepository.saveAndFlush(Mockito.any())).thenReturn(currencyConverterEntity);

        final CurrencyResponse response = currencyService.registerCurrencyConverter(currencyRequest);

        assertNotNull(response);
        assertThat(response)
                .usingRecursiveComparison()
                .isEqualTo(currencyResponse);

    }

    @Test
    public void shouldCreateCurrecyConvetionFromJpyBaseToUsdAndReturnTheConversion() {
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_JPY_TO_USD);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_JPY);
        CurrencyConverterEntity currencyConverterEntity = Fixture.from(CurrencyConverterEntity.class).gimme(CurrencyConverterEntityTemplete.VALID_ENTITY_JPY_TO_USD);
        CurrencyResponse currencyResponse = correncyResponseMapper.toCurrencyResponse(currencyConverterEntity);

        Mockito.when(exchangeRateService.getExchangeRateByBase(Mockito.anyString())).thenReturn(exchangeRateResponse);
        Mockito.when(currencyRepository.saveAndFlush(Mockito.any())).thenReturn(currencyConverterEntity);

        final CurrencyResponse response = currencyService.registerCurrencyConverter(currencyRequest);

        assertNotNull(response);
        assertThat(response)
                .usingRecursiveComparison()
                .isEqualTo(currencyResponse);

    }

    @Test
    public void shouldCreateCurrecyConvetionFromJpyBaseToEurAndReturnTheConversion() {
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_JPY_TO_EUR);
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_JPY);
        CurrencyConverterEntity currencyConverterEntity = Fixture.from(CurrencyConverterEntity.class).gimme(CurrencyConverterEntityTemplete.VALID_ENTITY_JPY_TO_EUR);
        CurrencyResponse currencyResponse = correncyResponseMapper.toCurrencyResponse(currencyConverterEntity);

        Mockito.when(exchangeRateService.getExchangeRateByBase(Mockito.anyString())).thenReturn(exchangeRateResponse);
        Mockito.when(currencyRepository.saveAndFlush(Mockito.any())).thenReturn(currencyConverterEntity);

        final CurrencyResponse response = currencyService.registerCurrencyConverter(currencyRequest);

        assertNotNull(response);
        assertThat(response)
                .usingRecursiveComparison()
                .isEqualTo(currencyResponse);

    }

    @Test
    public void shouldGetListOfCurrencyConvertionsByIdUser(){
        List<CurrencyConverterEntity> currencyConverterEntity = Fixture.from(CurrencyConverterEntity.class)
                .gimme(2,CurrencyConverterEntityTemplete.VALID_ENTITY_JPY_TO_EUR);
        final List<CurrencyResponse> currencyResponses = correncyResponseMapper.toListCurrencyResponse(currencyConverterEntity);

        Mockito.when(currencyRepository.findByIdUser(Mockito.any())).thenReturn(currencyConverterEntity);

        final List<CurrencyResponse> currencyConvertionsByIdUser = currencyService.getCurrencyConvertionsByIdUser(1L);

        assertNotNull(currencyConvertionsByIdUser);
        assertThat(currencyConvertionsByIdUser)
                .usingRecursiveComparison()
                .isEqualTo(currencyResponses);
    }
    @Test
    public void shouldGetEmptyListOfCurrencyConvertionsByIdUserInvalid(){

        Mockito.when(currencyRepository.findByIdUser(Mockito.any())).thenReturn(new ArrayList<>());

        final List<CurrencyResponse> currencyConvertionsByIdUser = currencyService.getCurrencyConvertionsByIdUser(1L);

        assertNotNull(currencyConvertionsByIdUser);
        assertThat(currencyConvertionsByIdUser).isEqualTo(new ArrayList<>());

    }

}