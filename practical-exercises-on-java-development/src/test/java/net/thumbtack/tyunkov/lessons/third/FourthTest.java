package net.thumbtack.tyunkov.lessons.third;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

/**
 * Created by dmitry on 18.10.15.
 */
public class FourthTest {

    @Test
    public void bigDecimalWorking() {
        BigDecimal bigDecimal = new BigDecimal("45445545568564676876175.3468");
        bigDecimal = bigDecimal.add(new BigDecimal("0.0002"));
        assertEquals(new BigDecimal("45445545568564676876175.3470"), bigDecimal);
    }

    @Test
    public void bigIntegerWorking() {
        BigInteger bigInteger = new BigInteger("45445545568564676876175");
        bigInteger = bigInteger.add(new BigInteger("3"));
        assertEquals(new BigInteger("45445545568564676876178"), bigInteger);
    }
}
