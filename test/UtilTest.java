package gbaEmu;

import org.junit.Test;
import static org.junit.Assert.*;
import gbaEmu.Util;

public class UtilTest {
    @Test
    public void testSetClearBit() {
        byte b = 0;
        b = Util.setBit(b, 3);
        assertTrue(Util.testBit(b, 3));
        b = Util.clearBit(b, 3);
        assertFalse(Util.testBit(b, 3));
    }
}
