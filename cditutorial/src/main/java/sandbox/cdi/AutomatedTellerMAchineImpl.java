package sandbox.cdi;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;

import static sandbox.cdi.TransportType.*;

@Named()
public class AutomatedTellerMAchineImpl implements AutomatedTellerMachine {

    @Inject
    @Transport(type = SOAP)
    // @Json
    private ATMTransport transport;

    @Override
    public void deposit(BigDecimal bd) {
        System.out.println("deposit called: " + bd);
        transport.communicateWithBank("lululu".getBytes());
    }

    @Override
    public void withdraw(BigDecimal bd) {
        System.out.println("withdraw called: " + bd);
        transport.communicateWithBank("lululu".getBytes());
    }

}
