package de.dikodam.sandbox.praktikum;

import org.junit.Test;

import java.nio.ByteBuffer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UtilsTest {
    @Test
    public void bytesToShort() throws Exception {
        byte byte1 = (byte) 0xFE;
        byte byte2 = (byte) 0xCD;
        short s = Utils.twoBytesToOneShort(byte1, byte2);
        boolean result = s == (short) 0xFECD;
        assertThat(result, is(true));
    }

    @Test
    public void shortToInt() throws Exception {
        int i = Utils.shortToInt((short) 0xFECD);
        boolean result = i == 0x0000FECD;
        assertThat(result, is(true));
    }

    @Test
    public void shortToBytes() throws Exception {
        short s = (short) 0xFECD;
        byte[] result = Utils.shortToBytes(s);
        byte result0 = result[0];
        byte result1 = result[1];
        assertThat(result0, is((byte) 0xFE));
        assertThat(result1, is((byte) 0xCD));
    }

    @Test
    public void bytesToShorts() throws Exception {

    }

    @Test
    public void byteBuffer() {
        byte[] b1 = new byte[]{0x3, 0x4};
        byte[] b2 = new byte[]{0x1, 0x2};
        ByteBuffer buffer = ByteBuffer.allocate(b1.length + b2.length);
        buffer.put(b2);
        buffer.put(b1);
        byte[] byteArray = buffer.array();
        for (byte b : byteArray) {
            System.out.print(String.format("%x ", b));
        }
    }

    @Test
    public void byteArrayToShortArray() {
        byte[] byteArray = new byte[]{(byte) 0xAB, (byte) 0xCD, (byte) 0xFE, (byte) 0xDC};
        short[] shortArray = Utils.byteArrayToShortArray(byteArray);
         assertThat(shortArray[0], is((short)0xABCD));
         assertThat(shortArray[1], is((short)0xFEDC));
    }

}