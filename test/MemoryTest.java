package gbaEmu;

import org.junit.Test;
import static org.junit.Assert.*;
import gbaEmu.Memory;
import gbaEmu.CPU;

public class MemoryTest {
    @Test
    public void testStackPushPop() {
        Memory mem = new Memory();
        mem.cpu = new CPU(mem); // CPU constructor requires Memory
        mem.cpu.register.sp = (short)0xFFFE;
        mem.stackPush((short)0xABCD);
        assertEquals((short)0xFFFC, mem.cpu.register.sp);
        short val = mem.stackPop();
        assertEquals((short)0xABCD, val);
        assertEquals((short)0xFFFE, mem.cpu.register.sp);
    }
}
