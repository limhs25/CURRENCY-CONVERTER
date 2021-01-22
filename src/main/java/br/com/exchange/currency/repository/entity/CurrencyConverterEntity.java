package br.com.exchange.currency.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyConverterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private Long idTransaction;

    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "origin_currency")
    private String originCurrency;

    @Column(name = "origin_value")
    private BigDecimal originValue;

    @Column(name = "target_currency")
    private String targetCurrency;

    @Column(name = "target_value")
    private BigDecimal targetValue;

    @Column(name = "date_time_convetion")
    private LocalDateTime dateTimeConvetion;
}
