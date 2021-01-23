package br.com.exchange.currency.domain;

import br.com.exchange.currency.config.annotation.EnumNamePattern;
import br.com.exchange.currency.config.enums.BaseCurrencyEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyRequest {

    @JsonProperty("id_user")
    @NotNull(message = "id_user cannot be null!")
    private Long idUser;

    @JsonProperty("origin_currency")
    @EnumNamePattern(anyOf = {BaseCurrencyEnum.BRL,BaseCurrencyEnum.EUR,BaseCurrencyEnum.USD,BaseCurrencyEnum.JPY},
            message = "origin_currency invalid!")
    private BaseCurrencyEnum originCurrency;

    @JsonProperty("origin_value")
    @NotNull(message = "origin_value invalid!")
    @Min(value = 1,message = "the minimum value of origin_value must be at least 1")
    private BigDecimal originValue;

    @JsonProperty("target_currency")
    @EnumNamePattern(anyOf = {BaseCurrencyEnum.BRL,BaseCurrencyEnum.EUR,BaseCurrencyEnum.USD,BaseCurrencyEnum.JPY}, message = "target_currency invalid!")
    private BaseCurrencyEnum targetCurrency;
}
