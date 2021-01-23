package br.com.exchange.currency.repository.entity;

import br.com.exchange.currency.config.enums.BaseCurrencyEnum;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    @Enumerated(EnumType.STRING)
    @NotNull
    private BaseCurrencyEnum originCurrency;

    @Column(name = "origin_value")
    @NotNull
    private BigDecimal originValue;

    @Column(name = "target_currency")
    @Enumerated(EnumType.STRING)
    @NotNull
    private BaseCurrencyEnum targetCurrency;

    @Column(name = "target_value")
    @NotNull
    private BigDecimal targetValue;

    @Column(name = "conversion_rate")
    @NotNull
    private BigDecimal conversionRate;

    @Column(name = "date_time_convetion")
    private LocalDateTime dateTimeConvetion;
}
