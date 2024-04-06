public class DES {

    static int[] IP = { 58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64,
            56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53, 45, 37, 29,
            21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7 };

    static int[] IK = { 1, 2, 3, 4, 5, 6, 7, 64, 8, 9, 10, 11, 12, 13, 14, 64, 15, 16, 17, 18, 19, 20, 21, 64, 22, 23,
            24, 25, 26, 27, 28, 64, 29, 30, 31, 32, 33, 34, 35, 64, 36, 37, 38, 39, 40, 41, 42, 64, 43, 44, 45, 46, 47,
            48, 49, 64, 50, 51, 52, 53, 54, 55, 64 };

    static int[] leftShifts = { 0, 1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1 };

    private static long map(long input, int[] map) {
        long result = 0;
        for (int i = 0; i < map.length; i++) {
            long bit = (input >> i) & 1;
            result |= (bit << (map[i] - 1));
            System.out.println("Bit " + i + " : " + (bit == 1 ? "1" : "0") + "\tresult: " + Long.toHexString(result));

        }
        return result;
    }

    private static long initialPermutation(long plaintext) {
        return map(plaintext, IP);
    }

    private static long initialKey(long originalKey) {
        long result = map(originalKey, IK); // every 8th bit is moved to MSB to be discarded
        return result & 0x7FFFFFFFFFFFFFFFl; // MSB is discarded
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
        System.out.println(Long.toHexString(initialKey(key)));
    }
}

// 0011101100111000100110000011011100010101001000001111011101011110
// 0111011 0111000 0011000 0110111 0010101 0100000 1110111 1011110