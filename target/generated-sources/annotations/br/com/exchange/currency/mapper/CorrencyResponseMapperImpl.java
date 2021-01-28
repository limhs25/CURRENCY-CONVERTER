package br.com.exchange.currency.mapper;

import br.com.exchange.currency.domain.CurrencyResponse;
import br.com.exchange.currency.domain.CurrencyResponse.CurrencyResponseBuilder;
import br.com.exchange.currency.repository.entity.CurrencyConverterEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-24T23:58:26-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
@Component
public class CorrencyResponseMapperImpl implements CorrencyResponseMapper {

    @Override
    public CurrencyResponse toCurrencyResponse(CurrencyConverterEntity currencyConverterEntity) {
        if ( currencyConverterEntity == null ) {
            return null;
        }

        CurrencyResponseBuilder currencyResponse = CurrencyResponse.builder();

        currencyResponse.idTransaction( currencyConverterEntity.getIdTransaction() );
        currencyResponse.idUser( currencyConverterEntity.getIdUser() );
        if ( currencyConverterEntity.getOriginCurrency() != null ) {
            currencyResponse.originCurrency( currencyConverterEntity.getOriginCurrency().name() );
        }
        currencyResponse.originValue( currencyConverterEntity.getOriginValue() );
        if ( currencyConverterEntity.getTargetCurrency() != null ) {
            currencyResponse.targetCurrency( currencyConverterEntity.getTargetCurrency().name() );
        }
        currencyResponse.targetValue( currencyConverterEntity.getTargetValue() );
        currencyResponse.conversionRate( currencyConverterEntity.getConversionRate() );
        currencyResponse.dateTimeConvetion( currencyConverterEntity.getDateTimeConvetion() );

        return currencyResponse.build();
    }

    @Override
    public List<CurrencyResponse> toListCurrencyResponse(List<CurrencyConverterEntity> currencyConverterEntity) {
        if ( currencyConverterEntity == null ) {
            return null;
        }

        List<CurrencyResponse> list = new ArrayList<CurrencyResponse>( currencyConverterEntity.size() );
        for ( CurrencyConverterEntity currencyConverterEntity1 : currencyConverterEntity ) {
            list.add( toCurrencyResponse( currencyConverterEntity1 ) );
        }

        return list;
    }
}
