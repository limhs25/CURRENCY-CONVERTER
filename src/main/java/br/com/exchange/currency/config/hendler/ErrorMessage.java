package br.com.exchange.currency.config.hendler;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class ErrorMessage {
    private int statusCode;
    private String message;
}
