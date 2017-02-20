package quote;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ferhathajdarpasic on 20/2/17.
 */
public class QuoteFactory {
    public static List<Quote> quote(String postcode, String occupation, BigDecimal turnover) {
        List<Quote> result = new ArrayList<>() ;
        for (Insurer insurer : INSURERS) {
            result.add(insurer.quote(postcode, occupation, turnover));
        }
        return result;
    }

    private static final Insurer[] INSURERS = new Insurer[] {
            new Insurer("YUI", new String[]  {"10001", "10002"}, new String[] {"dentist", "plumber"}, new BigDecimal("100000"), 0.01f),
            new Insurer("GIO", new String[]  {"20001", "20002"}, new String[] {"dentist", "baker"}, new BigDecimal("200000"), 0.02f),
            new Insurer("NRMA", new String[] {"30001", "30002"}, new String[] {"dentist", "plumber", "baker"}, new BigDecimal("300000"), 0.03f),
            new Insurer("QBE", new String[]  {"40001", "40002"}, new String[] {"plumber", "baker"}, new BigDecimal("400000"), 0.04f),
    };
}
