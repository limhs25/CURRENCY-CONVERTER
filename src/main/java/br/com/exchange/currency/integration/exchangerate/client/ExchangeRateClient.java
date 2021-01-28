package br.com.exchange.currency.integration.exchangerate.client;

import br.com.exchange.currency.integration.exchangerate.contract.ExchangeRateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "exchangeRateClient",url = "${exchangeRate}")
public interface ExchangeRateClient {

        @GetMapping(value = "/latest",consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<ExchangeRateResponse> getExchangeRateByBase(@RequestParam("base") String base);
}
