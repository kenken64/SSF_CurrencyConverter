package vttp2022b2.app.CurrencyConverter.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import vttp2022b2.app.CurrencyConverter.models.Currency;
import vttp2022b2.app.CurrencyConverter.models.Query;

@Service
public class CurrencyAPIService {
    private static final Logger logger = LoggerFactory.getLogger(CurrencyAPIService.class);

    private static String URL = "https://api.apilayer.com/fixer/convert";

    public Optional<Currency> convertExchangeRates(Query q) {
        String apiKey = System.getenv("FIXER_CURRENCY_API_KEY");

        String currencyUrl = UriComponentsBuilder.fromUriString(URL)
                .queryParam("to", q.getTo())
                .queryParam("from", q.getFrom())
                .queryParam("amount", q.getAmount())
                .toUriString();
        logger.info(currencyUrl);
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = null;

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("apikey", apiKey);
            HttpEntity request = new HttpEntity(headers);
            resp = template.exchange(
                    currencyUrl,
                    HttpMethod.GET,
                    request,
                    String.class,
                    1);
            logger.info(resp.getBody());
            Currency c = Currency.createJson(resp.getBody());
            return Optional.of(c);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
