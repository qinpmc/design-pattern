package strategy;

import java.math.BigDecimal;

public interface IQuoteStrategy {
    //获取折后价的价格
      BigDecimal getPrice(BigDecimal originalPrice);
}
