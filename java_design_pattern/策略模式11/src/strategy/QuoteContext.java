package strategy;

import java.math.BigDecimal;

public class QuoteContext {
    private IQuoteStrategy quoteStrategy;

    public QuoteContext(IQuoteStrategy quoteStrategy){
        this.quoteStrategy = quoteStrategy;
    }

    public BigDecimal getPrice(BigDecimal originalPrice) {
        return quoteStrategy.getPrice(originalPrice);
    }
}
