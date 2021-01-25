package br.com.exchange.currency.integration.exchangerate.service;

import br.com.exchange.currency.integration.exchangerate.client.ExchangeRateClient;
import br.com.exchange.currency.integration.exchangerate.contract.ExchangeRateResponse;
import br.com.exchange.currency.templates.ExchangeRateTemplate;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ExchangeRateServiceTest {

    @Mock
    private ExchangeRateClient client;

    @InjectMocks
    private ExchangeRateService exchangeRateService;

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.exchange.currency.templates");
    }


    @Test
    public void shouldGetExchangeRateInformationsWithResponseStatusOk() {
        ExchangeRateResponse exchangeRateResponse = Fixture.from(ExchangeRateResponse.class).gimme(ExchangeRateTemplate.VALID_EXCHANGE_RATE_BASE_BRL);

        when(client.getExchangeRateByBase(anyString())).thenReturn(ResponseEntity.ok(exchangeRateResponse));

        final ExchangeRateResponse response = exchangeRateService.getExchangeRateByBase("BRL");

        assertNotNull(response);
        assertThat(response)
                .usingRecursiveComparison()
                .isEqualTo(exchangeRateResponse);

    }

}