package sandbox.cdi;

import javax.enterprise.inject.Default;

@Default
public class StandardAtmTransport implements ATMTransport {

    @Override
    public void communicateWithBank(byte[] datapacket) {
        System.out.println("communicating with bank via STANDARD transport");
    }

}
