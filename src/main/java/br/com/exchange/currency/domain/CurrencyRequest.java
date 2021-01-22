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
    @Min(value = 1 ,message = "id_user invalid!")
    private Long idUser;

    @JsonProperty("origin_currency")
    @EnumNamePattern(regexp = "BRL|USD|EUR|JPY",message = "origin_currency invalid!")
    private BaseCurrencyEnum originCurrency;

    @JsonProperty("origin_value")
    @NotNull(message = "origin_value invalid!")
    private BigDecimal originValue;

    @JsonProperty("target_currency")
    @EnumNamePattern(regexp = "BRL|USD|EUR|JPY",message = "target_currency invalid!")
    private BaseCurrencyEnum targetCurrency;

    @JsonProperty("target_value")
    @NotNull(message = "target_value invalid!")
    private BigDecimal targetValue;
}
