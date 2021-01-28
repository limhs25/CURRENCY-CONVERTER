package br.com.exchange.currency.templates;

import br.com.exchange.currency.domain.CurrencyRequest;
import br.com.exchange.currency.enums.BaseCurrencyEnum;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.math.BigDecimal;

public class CurrencyRequestTemplate implements TemplateLoader {

    public final static String VALID_REQUEST_BRL_TO_USD = "valid_request_brl_to_usd";
    public static String VALID_REQUEST_BRL_TO_EUR = "valid_request_brl_to_eur";
    public static String VALID_REQUEST_BRL_TO_JPY = "valid_request_brl_to_jpy";

    public static String VALID_REQUEST_USD_TO_BRL = "valid_request_usd_to_brl";
    public static String VALID_REQUEST_USD_TO_EUR = "valid_request_usd_to_eur";
    public static String VALID_REQUEST_USD_TO_JPY = "valid_request_usd_to_jpy";

    public static String VALID_REQUEST_EUR_TO_BRL = "valid_request_eur_to_brl";
    public static String VALID_REQUEST_EUR_TO_USD = "valid_request_eur_to_usd";
    public static String VALID_REQUEST_EUR_TO_JPY = "valid_request_eur_to_jpy";


    public static String VALID_REQUEST_JPY_TO_BRL = "valid_request_jpy_to_brl";
    public static String VALID_REQUEST_JPY_TO_USD = "valid_request_jpy_to_usd";
    public static String VALID_REQUEST_JPY_TO_EUR = "valid_request_jpy_to_eur";

    @Override
    public void load() {
        Fixture.of(CurrencyRequest.class).addTemplate(VALID_REQUEST_BRL_TO_USD, new Rule() {{
            add("idUser", 1L);
            add("originCurrency", BaseCurrencyEnum.BRL);
            add("originValue", BigDecimal.ONE);
            add("targetCurrency", BaseCurrencyEnum.USD);

        }}).addTemplate(VALID_REQUEST_BRL_TO_EUR).inherits(VALID_REQUEST_BRL_TO_USD, new Rule() {{
            add("targetCurrency", BaseCurrencyEnum.EUR);

        }}).addTemplate(VALID_REQUEST_BRL_TO_JPY).inherits(VALID_REQUEST_BRL_TO_USD, new Rule() {{
            add("targetCurrency", BaseCurrencyEnum.JPY);
        }});


        Fixture.of(CurrencyRequest.class).addTemplate(VALID_REQUEST_USD_TO_BRL, new Rule() {{
            add("idUser", 1L);
            add("originCurrency", BaseCurrencyEnum.USD);
            add("originValue", BigDecimal.ONE);
            add("targetCurrency", BaseCurrencyEnum.BRL);

        }}).addTemplate(VALID_REQUEST_USD_TO_EUR).inherits(VALID_REQUEST_USD_TO_BRL, new Rule() {{
            add("targetCurrency", BaseCurrencyEnum.EUR);

        }}).addTemplate(VALID_REQUEST_USD_TO_JPY).inherits(VALID_REQUEST_USD_TO_BRL, new Rule() {{
            add("targetCurrency", BaseCurrencyEnum.JPY);
        }});



        Fixture.of(CurrencyRequest.class).addTemplate(VALID_REQUEST_EUR_TO_BRL, new Rule() {{
            add("idUser", 1L);
            add("originCurrency", BaseCurrencyEnum.EUR);
            add("originValue", BigDecimal.ONE);
            add("targetCurrency", BaseCurrencyEnum.BRL);

        }}).addTemplate(VALID_REQUEST_EUR_TO_USD).inherits(VALID_REQUEST_EUR_TO_BRL, new Rule() {{
            add("targetCurrency", BaseCurrencyEnum.USD);

        }}).addTemplate(VALID_REQUEST_EUR_TO_JPY).inherits(VALID_REQUEST_EUR_TO_BRL, new Rule() {{
            add("targetCurrency", BaseCurrencyEnum.JPY);
        }});

        Fixture.of(CurrencyRequest.class).addTemplate(VALID_REQUEST_JPY_TO_BRL, new Rule() {{
            add("idUser", 1L);
            add("originCurrency", BaseCurrencyEnum.JPY);
            add("originValue", BigDecimal.ONE);
            add("targetCurrency", BaseCurrencyEnum.BRL);

        }}).addTemplate(VALID_REQUEST_JPY_TO_USD).inherits(VALID_REQUEST_JPY_TO_BRL, new Rule() {{
            add("targetCurrency", BaseCurrencyEnum.USD);

        }}).addTemplate(VALID_REQUEST_JPY_TO_EUR).inherits(VALID_REQUEST_JPY_TO_BRL, new Rule() {{
            add("targetCurrency", BaseCurrencyEnum.EUR);
        }});

    }
}
