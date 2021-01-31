package com.aimtupsu.coffeemachine.utils;

import com.aimtupsu.coffeemachine.state.Quantity;
import java.util.Comparator;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QuantityComparator implements Comparator<Quantity> {

    public static final QuantityComparator COMPARATOR = new QuantityComparator();

    @Override
    public int compare(final Quantity o1, final Quantity o2) {
        return Long.compare(o1.getQuantity(), o2.getQuantity());
    }

    public boolean isLessThan(final Quantity o1, final Quantity o2) {
        return compare(o1, o2) < 0;
    }

}
