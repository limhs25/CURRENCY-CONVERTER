package br.com.exchange.currency.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyResponse {
    @JsonProperty( "id_transaction")
    private Long idTransaction;
    @JsonProperty( "id_user")
    private Long idUser;
    @JsonProperty("origin_currency")
    private String originCurrency;
    @JsonProperty("origin_value")
    private BigDecimal originValue;
    @JsonProperty("target_currency")
    private String targetCurrency;
    @JsonProperty("target_value")
    private BigDecimal targetValue;
    @JsonProperty("conversion_rate")
    private BigDecimal conversionRate;
    @JsonProperty("date_time_convetion")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTimeConvetion;
}
