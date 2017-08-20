package sandbox.cdi;

import static sandbox.cdi.TransportType.STANDARD;

@Transport(type = STANDARD)
public class StandardAtmTransport implements ATMTransport {

    @Override
    public void communicateWithBank(byte[] datapacket) {
        System.out.println("communicating with bank via STANDARD transport");
    }

}
