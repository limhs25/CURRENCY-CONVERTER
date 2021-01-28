package br.com.exchange.currency.templates;

import br.com.exchange.currency.enums.BaseCurrencyEnum;
import br.com.exchange.currency.repository.entity.CurrencyConverterEntity;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CurrencyConverterEntityTemplete implements TemplateLoader {

    public static String VALID_ENTITY_BRL_TO_USD = "valid_entity_brl_to_usd";
    public static String VALID_ENTITY_BRL_TO_EUR = "valid_entity_brl_to_eur";
    public static String VALID_ENTITY_BRL_TO_JPY = "valid_entity_brl_to_jpy";

    public static String VALID_ENTITY_USD_TO_BRL = "valid_entity_usd_to_brl";
    public static String VALID_ENTITY_USD_TO_EUR = "valid_entity_usd_to_eur";
    public static String VALID_ENTITY_USD_TO_JPY = "valid_entity_usd_to_jpy";

    public static String VALID_ENTITY_EUR_TO_BRL = "valid_entity_eur_to_brl";
    public static String VALID_ENTITY_EUR_TO_USD = "valid_entity_eur_to_usd";
    public static String VALID_ENTITY_EUR_TO_JPY = "valid_entity_eur_to_jpy";


    public static String VALID_ENTITY_JPY_TO_BRL = "valid_entity_jpy_to_brl";
    public static String VALID_ENTITY_JPY_TO_USD = "valid_entity_jpy_to_usd";
    public static String VALID_ENTITY_JPY_TO_EUR = "valid_entity_jpy_to_eur";

    @Override
    public void load() {

        Fixture.of(CurrencyConverterEntity.class).addTemplate(VALID_ENTITY_BRL_TO_USD, new Rule() {{
            add("idTransaction", 1L);
            add("idUser", 1L);
            add("originCurrency", BaseCurrencyEnum.BRL);
            add("originValue", BigDecimal.ONE);
            add("targetCurrency", BaseCurrencyEnum.USD);
            add("targetValue", new BigDecimal(0.18));
            add("conversionRate", new BigDecimal(0.18));
            add("dateTimeConvetion", LocalDateTime.now());

        }}).addTemplate(VALID_ENTITY_BRL_TO_EUR).inherits(VALID_ENTITY_BRL_TO_USD, new Rule() {{
            add("originValue", BigDecimal.ONE);
            add("targetCurrency", BaseCurrencyEnum.EUR);
            add("targetValue", new BigDecimal(0.15));
            add("conversionRate", new BigDecimal(0.15));

        }}).addTemplate(VALID_ENTITY_BRL_TO_JPY).inherits(VALID_ENTITY_BRL_TO_USD, new Rule() {{
            add("originValue", BigDecimal.ONE);
            add("targetCurrency", BaseCurrencyEnum.JPY);
            add("targetValue", new BigDecimal(18.98));
            add("conversionRate", new BigDecimal(18.98));
        }});

        Fixture.of(CurrencyConverterEntity.class).addTemplate(VALID_ENTITY_USD_TO_BRL, new Rule() {{
            add("idTransaction", 1L);
            add("idUser", 1L);
            add("originCurrency", BaseCurrencyEnum.USD);
            add("originValue", BigDecimal.ONE);
            add("targetCurrency", BaseCurrencyEnum.BRL);
            add("targetValue", new BigDecimal(5.47));
            add("conversionRate", new BigDecimal(5.47));
            add("dateTimeConvetion", LocalDateTime.now());

        }}).addTemplate(VALID_ENTITY_USD_TO_EUR).inherits(VALID_ENTITY_USD_TO_BRL, new Rule() {{
            add("originValue", BigDecimal.ONE);
            add("targetCurrency", BaseCurrencyEnum.EUR);
            add("targetValue", new BigDecimal(0.82));
            add("conversionRate", new BigDecimal(0.82));

        }}).addTemplate(VALID_ENTITY_USD_TO_JPY).inherits(VALID_ENTITY_USD_TO_BRL, new Rule() {{
            add("originValue", BigDecimal.ONE);
            add("targetCurrency", BaseCurrencyEnum.JPY);
            add("targetValue", new BigDecimal(103.76));
            add("conversionRate", new BigDecimal(103.76));
        }});


        Fixture.of(CurrencyConverterEntity.class).addTemplate(VALID_ENTITY_EUR_TO_BRL, new Rule() {{
            add("idTransaction", 1L);
            add("idUser", 1L);
            add("originCurrency", BaseCurrencyEnum.EUR);
            add("originValue", BigDecimal.ONE);
            add("targetCurrency", BaseCurrencyEnum.BRL);
            add("targetValue", new BigDecimal(6.66));
            add("conversionRate", new BigDecimal(6.66));
            add("dateTimeConvetion", LocalDateTime.now());

        }}).addTemplate(VALID_ENTITY_EUR_TO_USD).inherits(VALID_ENTITY_EUR_TO_BRL, new Rule() {{
            add("originValue", BigDecimal.ONE);
            add("targetCurrency", BaseCurrencyEnum.USD);
            add("targetValue", new BigDecimal(1.22));
            add("conversionRate", new BigDecimal(1.22));

        }}).addTemplate(VALID_ENTITY_EUR_TO_JPY).inherits(VALID_ENTITY_EUR_TO_BRL, new Rule() {{
            add("originValue", BigDecimal.ONE);
            add("targetCurrency", BaseCurrencyEnum.JPY);
            add("targetValue", new BigDecimal(126.33));
            add("conversionRate", new BigDecimal(126.33));
        }});

        Fixture.of(CurrencyConverterEntity.class).addTemplate(VALID_ENTITY_JPY_TO_BRL, new Rule() {{
            add("idTransaction", 1L);
            add("idUser", 1L);
            add("originCurrency", BaseCurrencyEnum.JPY);
            add("originValue", BigDecimal.ONE);
            add("targetCurrency", BaseCurrencyEnum.BRL);
            add("targetValue", new BigDecimal(0.053));
            add("conversionRate", new BigDecimal(0.053));
            add("dateTimeConvetion", LocalDateTime.now());

        }}).addTemplate(VALID_ENTITY_JPY_TO_USD).inherits(VALID_ENTITY_JPY_TO_BRL, new Rule() {{
            add("originValue", BigDecimal.ONE);
            add("targetCurrency", BaseCurrencyEnum.USD);
            add("targetValue", new BigDecimal(0.0096));
            add("conversionRate", new BigDecimal(0.0096));

        }}).addTemplate(VALID_ENTITY_JPY_TO_EUR).inherits(VALID_ENTITY_JPY_TO_BRL, new Rule() {{
            add("originValue", BigDecimal.ONE);
            add("targetCurrency", BaseCurrencyEnum.EUR);
            add("targetValue", new BigDecimal(0.0079));
            add("conversionRate", new BigDecimal(0.0079));
        }});

    }
}
