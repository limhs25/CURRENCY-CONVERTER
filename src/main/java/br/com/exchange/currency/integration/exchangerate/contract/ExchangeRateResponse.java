package br.com.exchange.currency.integration.exchangerate.contract;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRateResponse {

    @JsonProperty("rates")
    private RateResponse rates;
    @JsonProperty("base")
    private String base;
    @JsonProperty("date")
    private LocalDate date;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RateResponse {
        @JsonProperty("BRL")
        private BigDecimal brl;
        @JsonProperty("USD")
        private BigDecimal usd;
        @JsonProperty("EUR")
        private BigDecimal eur;
        @JsonProperty("JPY")
        private BigDecimal jpy;
    }
}
