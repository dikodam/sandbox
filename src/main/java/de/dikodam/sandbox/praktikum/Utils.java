package de.dikodam.sandbox.praktikum;

import java.util.Arrays;

public class Utils {

    private Utils() {
        // util class with static methods, duh
    }

    public static short twoBytesToOneShort(byte firstByte, byte secondByte) {
        short hiShort = (short) (firstByte << 8);
        int loShort = (short) (secondByte & 0xFF);
        return (short) (hiShort | loShort);
    }

    public static int shortToInt(short s) {
        return s & 0xFFFF;
    }

    public static byte[] shortToBytes(short s) {
        byte left = (byte) (s >>> 8);
        byte right = (byte) s;
        return new byte[]{left, right};
    }

    public static short[] byteArrayToShortArray(byte[] frame) {
        // make frame count even (add an additional 0x00 byte if needed)
        if (frame.length % 2 != 0) {
            frame = Arrays.copyOf(frame, frame.length + 1);
        }

        short[] output = new short[frame.length / 2];
        for (int i = 0; i < output.length; i++) {
            // shift the first byte by 8 bit to the left
            // add second byte to the right by bitwise ORing it with the leftshifted first byte
            short hi = (short) (frame[2 * i] << 8);
            short lo = (short) (frame[2 * i + 1] & 0xFF);
            output[i] = (short) (hi ^ lo);
        }
        return output;
    }
}
