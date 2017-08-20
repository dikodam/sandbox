package sandbox.cdi;

import static sandbox.cdi.TransportType.SOAP;

//@Alternative
@Transport(type = SOAP)
public class SoapAtmTransport implements ATMTransport {

    @Override
    public void communicateWithBank(byte[] datapacket) {
        System.out.println("communicating with bank via SOAP transport");
    }
}
