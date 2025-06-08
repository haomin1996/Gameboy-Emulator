package gbaEmu;

import org.junit.Test;
import static org.junit.Assert.*;

public class CPUTest {
    @Test
    public void testHaltInstruction() {
        Memory mem = new Memory();
        CPU cpu = new CPU(mem);
        mem.cpu = cpu;
        cpu.initOpcodes();
        mem.writeMemory(cpu.register.pc & 0xFFFF, (byte)0x76);
        cpu.executeNextOp();
        assertTrue(cpu.halt);
    }

    @Test
    public void testLoadRom() {
        Memory mem = new Memory();
        byte[] rom = new byte[] {1,2,3};
        mem.loadRom(rom);
        assertEquals(1, mem.readMemory(0));
        assertEquals(2, mem.readMemory(1));
        assertEquals(3, mem.readMemory(2));
    }
}
