package de.dikodam.sandbox.checksum;

import de.dikodam.sandbox.praktikum.Checksum;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ChecksumTest {

    //    0    1    2    3    4    5    6    7    8    9    A    B    C    D    E    F
    // 0000 0001 0010 0011 0100 0101 0110 0111 1000 1001 1010 1011 1100 1101 1110 1111

    @Test
    public void addShorts() {
        short s1 = (short) 0xFE00;                            //      1111 1110 0000 0000
        short s2 = (short) 0xAC00;                            //      1010 1100 0000 0000
        short resultSum = Checksum.addShorts(s1, s2);         //    1 1010 1010 0000 0000
        boolean result = resultSum == (short) 0xAA01;           //      1010 1010 0000 0001
        assertThat(result, is(true));
    }


    @Test
    public void parsing() {
        short[] shorts = new short[]{(short) 0xABCD, -5, -51, -1, 3, -253};
        for (short s : shorts) {
            System.out.println(String.format("%1$d, %1$x", s));
        }
    }

    @Test
    public void checksumMagic() {
        //short[] data = new short[]{
        //    (short) 0xABCD,
        //    (short) 0xFF03,
        //    (short) 0x552E
        //};

        byte[] data = new byte[]{
            (byte) 0xAB, (byte) 0xCD,
            (byte) 0xFF, (byte) 0x03,
        };
        short expectedChecksum = (short) 0x552E;

        short checksumResult = Checksum.calculateFor(data);
        System.out.println(String.format("checksum is: %x", checksumResult));

        assertThat(checksumResult, is(expectedChecksum));
    }

    @Test
    public void validate() {
        System.out.println(String.format("ff is %x", (byte) 0xff));
        byte[] data = new byte[]{
            (byte) 0xAB, (byte) 0xCD,
            0x00, 0x01,
            (byte) 0xff, (byte) 0xfe,
            (byte) 0xff, (byte) 0xcd
        };

        System.out.println(String.format("checksum is %x", Checksum.calculateFor(data)));

        boolean result = Checksum.validate(data);

        assertThat(result, is(true));

    }
}