package sandbox.cdi;

import javax.enterprise.inject.Alternative;

@Alternative
public class SoapAtmTransport implements ATMTransport {

    @Override
    public void communicateWithBank(byte[] datapacket) {
        System.out.println("communicating with bank via SOAP transport");
    }

}
