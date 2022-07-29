package vttp2022b2.app.CurrencyConverter.models;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Currency {
    private Logger logger = LoggerFactory.getLogger(Currency.class);

    private String success;
    private Date date;
    private BigDecimal result;
    private Query query;
}
