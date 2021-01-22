package br.com.exchange.currency.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @JsonProperty("date_time_convetion")
    private LocalDateTime dateTimeConvetion;
}
