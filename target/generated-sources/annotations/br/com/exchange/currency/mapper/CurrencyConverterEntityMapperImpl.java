package br.com.exchange.currency.mapper;

import br.com.exchange.currency.domain.CurrencyRequest;
import br.com.exchange.currency.repository.entity.CurrencyConverterEntity;
import br.com.exchange.currency.repository.entity.CurrencyConverterEntity.CurrencyConverterEntityBuilder;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-24T23:58:26-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
@Component
public class CurrencyConverterEntityMapperImpl implements CurrencyConverterEntityMapper {

    @Override
    public CurrencyConverterEntity toCurrencyConverterEntity(CurrencyRequest currencyRequest, BigDecimal conversionRate) {
        if ( currencyRequest == null && conversionRate == null ) {
            return null;
        }

        CurrencyConverterEntityBuilder currencyConverterEntity = CurrencyConverterEntity.builder();

        if ( currencyRequest != null ) {
            currencyConverterEntity.idUser( currencyRequest.getIdUser() );
            currencyConverterEntity.originCurrency( currencyRequest.getOriginCurrency() );
            currencyConverterEntity.originValue( currencyRequest.getOriginValue() );
            currencyConverterEntity.targetCurrency( currencyRequest.getTargetCurrency() );
        }
        if ( conversionRate != null ) {
            currencyConverterEntity.conversionRate( conversionRate );
        }
        currencyConverterEntity.targetValue( getCurrencyValueCalculated(currencyRequest,conversionRate) );
        currencyConverterEntity.dateTimeConvetion( java.time.LocalDateTime.now() );

        return currencyConverterEntity.build();
    }
}
