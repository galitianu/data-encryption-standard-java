public class DES {

    static int[] IP = { 58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64,
            56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53, 45, 37, 29,
            21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7 };

    static int[] leftShifts = { 0, 1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1 };

    static int[] PC1 = { 57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60,
            52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28,
            20, 12, 4 };

    static int[] PC2 = { 14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10, 23, 19, 12, 4, 26, 8, 16, 7, 27, 20, 13, 2, 41, 52,
            31, 37, 47, 55, 30, 40, 51, 45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32 };

    private static long map(long input, int[] map) {
        long result = 0;
        for (int i = 0; i < map.length; i++) {
            long bit = (input >>> (map[i] - 1)) & 1;
            result |= (bit << (i));
        }
        return result;
    }

    private static long initialPermutation(long plaintext) {
        return map(plaintext, IP);
    }

    private static long compressionPermutation(long key) {
        return map(key, PC1);
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
        System.out.println(Long.toHexString(compressionPermutation(key)));
    }
}

// 0011101100111000100110000011011100010101001000001111011101011110
// 0111011 0111000 0011000 0110111 0010101 0100000 1110111 1011110
// 0111011 0111000 0011000 0110111 0010101 0100000 1110111 1011110