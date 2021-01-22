package br.com.exchange.currency.controller;

import br.com.exchange.currency.domain.CurrencyRequest;
import br.com.exchange.currency.domain.CurrencyResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/currency")
public class CurrencyController {

    @PostMapping("/conveter")
    @ApiOperation(value = "Converter Currency.")
    public CurrencyResponse converterCurrency(@RequestBody CurrencyRequest currencyRequest){
        return null;
    }
    @GetMapping("/converters/{id_user}")
    @ApiOperation(value = "Get all Converter Currency by user id.")
    public List<CurrencyResponse> getCurrencyConvertionsByIdUser(@PathVariable(name = "id_user") Long idUser){
        return null;
    }

}
