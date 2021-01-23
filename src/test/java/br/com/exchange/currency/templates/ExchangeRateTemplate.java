package br.com.exchange.currency.templates;

import br.com.exchange.currency.integration.exchangerate.contract.ExchangeRateResponse;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.math.BigDecimal;

public class ExchangeRateTemplate implements TemplateLoader {
    public static String VALID_EXCHANGE_RATE_BRL = "valid_exchange_rate_brl";
    public static String VALID_EXCHANGE_RATE_USD = "valid_exchange_rate_usd";
    public static String VALID_EXCHANGE_RATE_EUR = "valid_exchange_rate_eur";
    public static String VALID_EXCHANGE_RATE_JPY = "valid_exchange_rate_jpy";
    public static String VALID_RATE = "valid_rate";

    @Override
    public void load() {

        Fixture.of(ExchangeRateResponse.class).addTemplate(VALID_EXCHANGE_RATE_BRL, new Rule(){{
            add("rates",one(ExchangeRateResponse.RateResponse.class, VALID_RATE));
            add("base","BRL");
            add("date",instant("now"));
        }});

        Fixture.of(ExchangeRateResponse.class).addTemplate(VALID_EXCHANGE_RATE_USD).inherits(VALID_EXCHANGE_RATE_BRL, new Rule(){{
            add("base","USD");
        }});

        Fixture.of(ExchangeRateResponse.class).addTemplate(VALID_EXCHANGE_RATE_EUR).inherits(VALID_EXCHANGE_RATE_BRL, new Rule(){{
            add("base","EUR");
        }});

        Fixture.of(ExchangeRateResponse.class).addTemplate(VALID_EXCHANGE_RATE_JPY).inherits(VALID_EXCHANGE_RATE_BRL, new Rule(){{
            add("base","JPY");
        }});

        Fixture.of(ExchangeRateResponse.RateResponse.class).addTemplate(VALID_RATE, new Rule(){{
            add("brl",new BigDecimal(10));
            add("usd",new BigDecimal(10));
            add("eur",new BigDecimal(10));
            add("jpy",new BigDecimal(10));
        }});
    }
}
