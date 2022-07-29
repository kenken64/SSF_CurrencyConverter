package vttp2022b2.app.CurrencyConverter.models;

import java.math.BigDecimal;

import jakarta.json.JsonNumber;
import jakarta.json.JsonObject;

public class Query {
    private String from;
    private String to;
    private BigDecimal amount;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public static Query createJson(JsonObject o) {
        Query q = new Query();
        JsonObject queryObj = o.getJsonObject("query");
        String toStr = queryObj.getString("To");
        q.to = toStr;
        String fromStr = queryObj.getString("From");
        q.from = fromStr;
        JsonNumber jsNum = queryObj.getJsonNumber("amount");
        q.amount = jsNum.bigDecimalValue();
        return q;
    }
}
