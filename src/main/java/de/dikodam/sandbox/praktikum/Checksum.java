package de.dikodam.sandbox.praktikum;

public class Checksum {


    private Checksum() {
        // singleton pattern
    }

    public static boolean validate(byte[] frame) {
        // convert bytes to shorts
        short[] shorts = Utils.byteArrayToShortArray(frame);
        short sum = 0x0000;
        for (short aShort : shorts) {
            sum = addShorts(sum, aShort);
        }
        return sum == 0x0000;
    }

    public static short calculateFor(byte[] data) {
        // convert byte[] (8bit each) to short[] (16bit each)
        short[] shorts = Utils.byteArrayToShortArray(data);
        short sum = 0x0;
        // add each 16bit unit
        for (short summand : shorts) {
            sum = addShorts(sum, summand);
        }
        // invert the sum, resulting in the TCP/IP checksum
        return (short) (~sum);
    }

    public static short calculateFromShorts(short[] payload, short... metaData) {
        short sum = 0x0000;
        for (short metaDataSummand : metaData) {
            sum = addShorts(sum, metaDataSummand);
        }
        for (short payloadSummand : payload) {
            sum = addShorts(sum, payloadSummand);
        }
        short checksum = (short) (~sum);
        System.out.println(String.format("sum is     : %x", sum));
        System.out.println(String.format("checksum is: %x", checksum));
        return checksum;
    }


    public static short addShorts(short short1, short short2) {
        // sum is 16 bit + carry at 17. position
        int sumInt = Utils.shortToInt(short1) + Utils.shortToInt(short2);
        System.out.println(String.format("adding: %x + %x = %x", short1, short2, sumInt));
        // cast to short cuts off left 16 bits, leaving right 16 bits
        short sum = (short) sumInt;
        // get the carry from position 17 to position 1
        short carry = (short) (sumInt >>> 16);
        System.out.println(String.format("carry: %x", carry));
        // add carry (0 or 1), return sum of this addition
        short result = (short) (sum + carry);
        System.out.println(String.format("result: %x", result));
        return result;
    }

}
