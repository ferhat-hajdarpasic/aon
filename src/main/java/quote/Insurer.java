package quote;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ferhathajdarpasic on 20/2/17.
 */
public class Insurer {
    public final String name;
    public final List<String> excludedPostcodes;
    public final List<String>  excludedOccupations;
    public final BigDecimal minimumTurnover;
    public final BigDecimal premiumMultipier;
    public Insurer(String name, String[] excludedPostcodes, String[] excludedOccupations, BigDecimal minimumTurnover, float premiumMultipier) {
        this.name = name;
        this.excludedPostcodes = Arrays.asList(excludedPostcodes);
        this.excludedOccupations = Arrays.asList(excludedOccupations);
        this.minimumTurnover = minimumTurnover;
        this.premiumMultipier = new BigDecimal(premiumMultipier);
    }
    public Quote quote(String postcode, String occupation, BigDecimal turnover) {
        boolean unableToQuote =(excludedPostcodes.contains(postcode) && excludedOccupations.contains(occupation)) || (turnover.floatValue() < minimumTurnover.floatValue());
        if(!unableToQuote) {
            return new Quote(name, turnover.multiply(premiumMultipier), false);
        } else {
            return new Quote(name, new BigDecimal("0"), true);
        }
    }
}
