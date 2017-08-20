package sandbox.cdi;

import java.math.BigDecimal;

public interface ATMTransport {

    void communicateWithBank(byte[] datapacket);
}
