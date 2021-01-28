package br.com.exchange.currency.mapper;

import br.com.exchange.currency.domain.CurrencyResponse;
import br.com.exchange.currency.repository.entity.CurrencyConverterEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CorrencyResponseMapper {
    CurrencyResponse toCurrencyResponse(CurrencyConverterEntity currencyConverterEntity);
    List<CurrencyResponse> toListCurrencyResponse(List<CurrencyConverterEntity> currencyConverterEntity);
}
