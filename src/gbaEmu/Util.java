package gbaEmu;

public final class Util {
	public static byte setBit(byte n, int pos) {
		assert pos >= 0: "setbit parameter must be positive";
		return n |= (1 << pos);
	}
	public static boolean testBit(byte n, int pos) {
		assert pos >= 0: "testbit parameter must be positive";
		return (n & (1 << pos)) > 0;
	}
        public static byte clearBit(byte n, int pos) {
                assert pos >= 0: "clearbit parameter must be positive";
                byte clearTemplate = (byte) ~(1 << pos);
                return (byte) (n & clearTemplate);
        }
	public static byte getVal(byte val, int pos) {
		return (byte) ((val >> pos) & 1);
	}
}
