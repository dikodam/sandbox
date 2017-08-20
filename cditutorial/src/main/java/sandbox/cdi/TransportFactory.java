package sandbox.cdi;

public class TransportFactory {

//    @Produces
    ATMTransport createTransport() {
        System.out.println("ATMTransport created with producer");
        return new JsonAtmTransport();
    }

}
