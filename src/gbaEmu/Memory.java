package gbaEmu;

public class Memory {
        byte[] mainMemory;
        CPU cpu;
        public Memory() {
                mainMemory = new byte[0x10000];
        }

        /**
         * Copy the supplied ROM bytes into the memory area starting at 0x0000.
         * Only the first 32KB of the ROM are mapped as this emulator does not
         * implement any banking logic.
         */
        public void loadRom(byte[] romData) {
                int len = Math.min(romData.length, 0x8000);
                System.arraycopy(romData, 0, mainMemory, 0, len);
        }
	public byte readMemory(int address) {
		return mainMemory[address];
	}
	public int writeMemory(int address, byte value) {
		mainMemory[address] = value;
		return 0;
	}
	public void memoryIncrement(int address) {
		mainMemory[address]++;
	}
	// 16 bit stack push
        public int stackPush(short value) {
                cpu.register.sp--;
                writeMemory(cpu.register.sp & 0xFFFF, (byte) (value >> 8));
                cpu.register.sp--;
                writeMemory(cpu.register.sp & 0xFFFF, (byte) (value & 0xFF));
                return 0;
        }
        //16 bit stack pop
        public short stackPop() {
                int low = readMemory(cpu.register.sp & 0xFFFF);
                cpu.register.sp++;
                int high = readMemory(cpu.register.sp & 0xFFFF);
                cpu.register.sp++;
                return (short) ((high << 8) | (low & 0xFF));
        }
}
