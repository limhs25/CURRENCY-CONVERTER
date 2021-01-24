package br.com.exchange.currency.mapper;

import br.com.exchange.currency.domain.CurrencyResponse;
import br.com.exchange.currency.repository.entity.CurrencyConverterEntity;
import br.com.exchange.currency.templates.CurrencyConverterEntityTemplete;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mapstruct.factory.Mappers.getMapper;

@RunWith(SpringRunner.class)
public class CorrencyResponseMapperTest {

    @Spy
    private CorrencyResponseMapper correncyResponseMapper = getMapper(CorrencyResponseMapper.class);

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.exchange.currency.templates");
    }

    @Test
    public void shouldMapperEntityToCurrencyResponse(){
        CurrencyConverterEntity currencyConverterEntity = Fixture.from(CurrencyConverterEntity.class).gimme(CurrencyConverterEntityTemplete.VALID_ENTITY_BRL_TO_USD);
        final CurrencyResponse currencyResponse = correncyResponseMapper.toCurrencyResponse(currencyConverterEntity);
        assertNotNull(currencyResponse);
    }

    @Test
    public void shouldReturnNullObjectToResponseOnMapperCurrencyEntity(){
        final CurrencyResponse currencyResponse = correncyResponseMapper.toCurrencyResponse(null);
        assertNull(currencyResponse);
    }

    @Test
    public void shouldMapperEntityToCurrencyResponseWithoutOringinCurrencyAndTargetCurrency(){
        CurrencyConverterEntity currencyConverterEntity = Fixture.from(CurrencyConverterEntity.class).gimme(CurrencyConverterEntityTemplete.VALID_ENTITY_BRL_TO_USD);
        currencyConverterEntity.setTargetCurrency(null);
        currencyConverterEntity.setOriginCurrency(null);

        final CurrencyResponse currencyResponse = correncyResponseMapper.toCurrencyResponse(currencyConverterEntity);

        assertNotNull(currencyResponse);
        assertNull(currencyConverterEntity.getTargetCurrency());
        assertNull(currencyResponse.getOriginCurrency());
    }

    @Test
    public void shouldMapperListOfEntityToCurrencyResponse(){
        List<CurrencyConverterEntity> currencyConverterEntity = Fixture.from(CurrencyConverterEntity.class).gimme(2,CurrencyConverterEntityTemplete.VALID_ENTITY_BRL_TO_USD);
        final List<CurrencyResponse> currencyResponse = correncyResponseMapper.toListCurrencyResponse(currencyConverterEntity);
        assertNotNull(currencyResponse);
    }
    @Test
    public void shouldReturnNullObjectToResponseOnMapperListOfCurrencyEntity(){
        final List<CurrencyResponse> currencyResponse = correncyResponseMapper.toListCurrencyResponse(null);
        assertNull(currencyResponse);
    }
}
