package br.com.exchange.currency.repository.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyConverterEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private Long idTransaction;

    @Column(name = "id_user")
    @NotNull
    private Long idUser;

    @Column(name = "origin_currency")
    @NotEmpty
    private String originCurrency;

    @Column(name = "origin_value")
    @NotNull
    private BigDecimal originValue;

    @Column(name = "target_currency")
    @NotEmpty
    private String targetCurrency;

    @Column(name = "target_value")
    @NotNull
    private BigDecimal targetValue;

    @Column(name = "date_time_convetion")
    @NotNull
    private LocalDateTime dateTimeConvetion;
}
