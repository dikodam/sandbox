package sandbox.cdi;

import static sandbox.cdi.TransportType.*;

//@Json
//@Alternative
@Transport(type = JSON)
public class JsonAtmTransport implements ATMTransport {

    @Override
    public void communicateWithBank(byte[] datapacket) {
        System.out.println("communicating with bank via JSON transport");
    }
}
