package br.com.exchange.currency.controller;

import br.com.exchange.currency.WireMockConfig;
import br.com.exchange.currency.domain.CurrencyRequest;
import br.com.exchange.currency.enums.BaseCurrencyEnum;
import br.com.exchange.currency.mapper.CorrencyResponseMapper;
import br.com.exchange.currency.templates.CurrencyRequestTemplate;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import feign.FeignException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.NestedServletException;

import static java.nio.charset.Charset.defaultCharset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.util.StreamUtils.copyToString;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@EnableConfigurationProperties
@ContextConfiguration(classes = { WireMockConfig.class })
@SpringBootTest
public class CurrencyControllerTest {

    @Autowired
    private WireMockServer wireMockServer;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Autowired
    private CurrencyController controller;

    @Autowired
    private CorrencyResponseMapper correncyResponseMapper;

    @Before
    public void init() {
        wireMockServer.resetMappings();
        wireMockServer.resetScenarios();
        wireMockServer.resetRequests();
        FixtureFactoryLoader.loadTemplates("br.com.exchange.currency.templates");
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .build();
    }

    @Test
    public void shouldCreateCorrectAnCurrencuConverterAndGetResponseEntityOk() throws Exception{
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_BRL_TO_USD);

        wireMockServer.stubFor(WireMock.get(WireMock.urlEqualTo("/latest?base=BRL"))
                .willReturn(WireMock.aResponse()
                        .withBody(copyToString(CurrencyControllerTest.class.getResourceAsStream("/payload/exchange.json"), defaultCharset()))
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type",
                                "application/json")));

        mockMvc.perform(post("/v1/currency/converter")
                .content(new ObjectMapper().writeValueAsString(currencyRequest))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id_transaction").value("1"))
                .andExpect(jsonPath("$.id_user").value("1"))
                .andExpect(jsonPath("$.origin_currency").value("BRL"))
                .andExpect(jsonPath("$.origin_value").value("1"))
                .andExpect(jsonPath("$.target_currency").value("USD"))
                .andExpect(jsonPath("$.target_value").value("0.18"))
                .andExpect(jsonPath("$.conversion_rate").value("0.18"));
    }
    @Test(expected = NestedServletException.class)
    public void shouldThrowNestedServletExceptionBecauseTheBaseIsInvalid() throws Exception{
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_BRL_TO_USD);
        currencyRequest.setOriginCurrency(BaseCurrencyEnum.UNKNOWN);
        wireMockServer.stubFor(WireMock.get(WireMock.urlEqualTo("/latest?base=UNKNOWN"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.BAD_REQUEST.value())
                        .withHeader("Content-Type",
                                "application/json")));

        mockMvc.perform(post("/v1/currency/converter")
                .content(new ObjectMapper().writeValueAsString(currencyRequest))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON));
    }

    @Test
    public void shouldCreateCorrectAnCurrencuConverterAndGetListResponseEntity() throws Exception{
        CurrencyRequest currencyRequest = Fixture.from(CurrencyRequest.class).gimme(CurrencyRequestTemplate.VALID_REQUEST_BRL_TO_USD);

        wireMockServer.stubFor(WireMock.get(WireMock.urlEqualTo("/latest?base=BRL"))
                .willReturn(WireMock.aResponse()
                        .withBody(copyToString(CurrencyControllerTest.class.getResourceAsStream("/payload/exchange.json"), defaultCharset()))
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type",
                                "application/json")));

        mockMvc.perform(post("/v1/currency/converter")
                .content(new ObjectMapper().writeValueAsString(currencyRequest))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id_transaction").value("2"))
                .andExpect(jsonPath("$.id_user").value("1"))
                .andExpect(jsonPath("$.origin_currency").value("BRL"))
                .andExpect(jsonPath("$.origin_value").value("1"))
                .andExpect(jsonPath("$.target_currency").value("USD"))
                .andExpect(jsonPath("$.target_value").value("0.18"))
                .andExpect(jsonPath("$.conversion_rate").value("0.18"));

        mockMvc.perform(get("/v1/currency/converters/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].id_transaction").value("1"))
                .andExpect(jsonPath("$[0].id_user").value("1"))
                .andExpect(jsonPath("$[0].origin_currency").value("BRL"))
                .andExpect(jsonPath("$[0].origin_value").value("1.0"))
                .andExpect(jsonPath("$[0].target_currency").value("USD"))
                .andExpect(jsonPath("$[0].target_value").value("0.18"))
                .andExpect(jsonPath("$[0].conversion_rate").value("0.18"));

    }

}