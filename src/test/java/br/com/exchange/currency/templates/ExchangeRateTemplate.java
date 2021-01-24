package br.com.exchange.currency.templates;

import br.com.exchange.currency.integration.exchangerate.contract.ExchangeRateResponse;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExchangeRateTemplate implements TemplateLoader {

    public static String VALID_EXCHANGE_RATE_BASE_BRL = "valid_exchange_rate_brl";
    public static String VALID_EXCHANGE_RATE_BASE_USD = "valid_exchange_rate_usd";
    public static String VALID_EXCHANGE_RATE_BASE_EUR = "valid_exchange_rate_eur";
    public static String VALID_EXCHANGE_RATE_BASE_JPY = "valid_exchange_rate_jpy";
    public static String VALID_RATE_BASE_BRL = "valid_rate_base_brl";
    public static String VALID_RATE_BASE_USD = "valid_rate_base_usd";
    public static String VALID_RATE_BASE_EUR = "valid_rate_base_eur";
    public static String VALID_RATE_BASE_JPY = "valid_rate_base_jpy";

    @Override
    public void load() {

        Fixture.of(ExchangeRateResponse.class).addTemplate(VALID_EXCHANGE_RATE_BASE_BRL, new Rule(){{
            add("rates",one(ExchangeRateResponse.RateResponse.class, VALID_RATE_BASE_BRL));
            add("base","BRL");
            add("date", LocalDate.now());
        }});

        Fixture.of(ExchangeRateResponse.class).addTemplate(VALID_EXCHANGE_RATE_BASE_USD).inherits(VALID_EXCHANGE_RATE_BASE_BRL, new Rule(){{
            add("rates",one(ExchangeRateResponse.RateResponse.class, VALID_RATE_BASE_USD));
            add("base","USD");
        }});

        Fixture.of(ExchangeRateResponse.class).addTemplate(VALID_EXCHANGE_RATE_BASE_EUR).inherits(VALID_EXCHANGE_RATE_BASE_BRL, new Rule(){{
            add("rates",one(ExchangeRateResponse.RateResponse.class, VALID_RATE_BASE_EUR));
            add("base","EUR");
        }});

        Fixture.of(ExchangeRateResponse.class).addTemplate(VALID_EXCHANGE_RATE_BASE_JPY).inherits(VALID_EXCHANGE_RATE_BASE_BRL, new Rule(){{
            add("rates",one(ExchangeRateResponse.RateResponse.class, VALID_RATE_BASE_JPY));
            add("base","JPY");
        }});

        Fixture.of(ExchangeRateResponse.RateResponse.class).addTemplate(VALID_RATE_BASE_BRL, new Rule(){{
            add("brl",new BigDecimal(1));
            add("usd",new BigDecimal(0.18));
            add("eur",new BigDecimal(0.15));
            add("jpy",new BigDecimal(18.98));
        }});

        Fixture.of(ExchangeRateResponse.RateResponse.class).addTemplate(VALID_RATE_BASE_USD, new Rule(){{
            add("brl",new BigDecimal(5.47));
            add("usd",new BigDecimal(1));
            add("eur",new BigDecimal(0.82));
            add("jpy",new BigDecimal(103.76));
        }});

        Fixture.of(ExchangeRateResponse.RateResponse.class).addTemplate(VALID_RATE_BASE_EUR, new Rule(){{
            add("brl",new BigDecimal(6.66));
            add("usd",new BigDecimal(1.22));
            add("eur",new BigDecimal(1));
            add("jpy",new BigDecimal(126.33));
        }});

        Fixture.of(ExchangeRateResponse.RateResponse.class).addTemplate(VALID_RATE_BASE_JPY, new Rule(){{
            add("brl",new BigDecimal(0.053));
            add("usd",new BigDecimal(0.0096));
            add("eur",new BigDecimal(0.0079));
            add("jpy",new BigDecimal(1));
        }});

    }
}
