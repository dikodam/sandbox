package sandbox.cdi;

@Json
//@Alternative
public class JsonAtmTransport implements ATMTransport {

    @Override
    public void communicateWithBank(byte[] datapacket) {
        System.out.println("communicating with bank via JSON transport");
    }
}
