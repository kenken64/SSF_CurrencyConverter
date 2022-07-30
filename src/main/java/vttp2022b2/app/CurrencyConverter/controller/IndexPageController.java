package vttp2022b2.app.CurrencyConverter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vttp2022b2.app.CurrencyConverter.models.Currency;
import vttp2022b2.app.CurrencyConverter.models.Query;

@Controller
public class IndexPageController {

    @GetMapping("/")
    public String showIndexPage(Model model) {
        Currency c = new Currency();
        Query q = new Query();
        c.setQuery(q);
        model.addAttribute("currency", c);
        return "index";
    }
}
