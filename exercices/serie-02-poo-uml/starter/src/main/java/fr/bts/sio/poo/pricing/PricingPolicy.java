package fr.bts.sio.poo.pricing;

import fr.bts.sio.poo.domain.Movie;
import java.math.BigDecimal;

@FunctionalInterface
public interface PricingPolicy {
    BigDecimal priceFor(Movie movie, int rentalDays);
}
