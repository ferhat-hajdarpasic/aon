package quote;

import java.beans.Transient;
import java.math.BigDecimal;

public class Quote {
    public String getInsurerName() {
        return insurerName;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public boolean isUnableToQuote() {
        return unableToQuote;
    }

    private final String insurerName;
    private final BigDecimal premium;
    private final boolean unableToQuote;
    public Quote(String insurerName, BigDecimal premium, boolean unableToQuote) {
        this.premium = premium.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.insurerName = insurerName;
        this.unableToQuote = unableToQuote;
    }
}
