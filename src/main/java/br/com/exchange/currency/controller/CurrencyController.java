package br.com.exchange.currency.controller;

import br.com.exchange.currency.domain.CurrencyRequest;
import br.com.exchange.currency.domain.CurrencyResponse;
import br.com.exchange.currency.service.CurrencyService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @PostMapping("/converter")
    @ApiOperation(value = "Converter Currency.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Currency Convetins Success!"),
            @ApiResponse(code = 400, message = "BadRequest"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<CurrencyResponse> converterCurrency(@Valid @RequestBody CurrencyRequest currencyRequest) {
        CurrencyResponse response = currencyService.registerCurrencyConverter(currencyRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/converters/{id_user}")
    @ApiOperation(value = "Get all Converter Currency by user id.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Currency Convetins Success!"),
            @ApiResponse(code = 400, message = "BadRequest any argument is wrong!"),
            @ApiResponse(code = 500, message = "Internal Server Error!")
    })
    public ResponseEntity<List<CurrencyResponse>> getCurrencyConvertionsByIdUser(@Valid @PathVariable(name = "id_user") Long idUser) {
        List<CurrencyResponse> response = currencyService.getCurrencyConvertionsByIdUser(idUser);
        return ResponseEntity.ok(response);
    }

}
