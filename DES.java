public class DES {

    static int[] IP = { 58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64,
            56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53, 45, 37, 29,
            21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7 };

    static int[] leftShifts = { 0, 1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1 };

    private static long map(long input, int[] map) {
        long result = 0;
        for (int i = 0; i < map.length; i++) {
            long bit = (input >> i) & 1;
            result |= (bit << IP[i]);
            System.out.println("Bit " + i + " : " + (bit == 1 ? "1" : "0") + "\tresult: " + Long.toHexString(result));

        }
        return result;
    }

    private static long initialPermutation(long plaintext) {
        return map(plaintext, IP);
    }

    // static long removeBit(long x, int i) {
    // long mask = -1 << i;
    // return (x & ~mask) | ((x >>> 1) & mask);
    // }

    // private static long keyTransformation(long key, int shift) {
    // System.out.println("Key " + Long.toHexString(key));

    // for (int i = 7; i < 64; i += 7) {
    // key = removeBit(key, i);
    // }
    // System.out.println("Key-8 " + Long.toHexString(key));

    // long h1 = key >>> 28;
    // long h2 = key & 0xfffffff;

    // System.out.println("H1 " + Long.toHexString(h1));
    // System.out.println("H2 " + Long.toHexString(h2));

    // return key;
    // }

    public static void main(String[] args) {
        long plaintext = Long.parseUnsignedLong("8F03456D3F78E2C5", 16);
        long key = Long.parseUnsignedLong("3b3898371520f75e", 16);

        initialPermutation(plaintext);
        // keyTransformation(key, 2);
    }
}
