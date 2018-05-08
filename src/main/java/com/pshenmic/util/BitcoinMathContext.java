package com.pshenmic.util;

import java.math.MathContext;
import java.math.RoundingMode;

public class BitcoinMathContext {

    public static final MathContext BITCOIN_FRACTION = new MathContext(6, RoundingMode.HALF_DOWN);

}
