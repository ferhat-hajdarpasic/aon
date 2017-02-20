package quote;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RestController
public class QuoteController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/quote")
    public List<Quote> quote(@RequestParam(value="postcode", defaultValue="") String postcode,
                               @RequestParam(value="occupation", defaultValue="") String occupation,
                               @RequestParam(value="turnover", defaultValue="") BigDecimal turnover
                             ) {
        return QuoteFactory.quote(postcode, occupation, turnover).stream().filter(quote -> !quote.isUnableToQuote()).collect(Collectors.toList());

    }
}
