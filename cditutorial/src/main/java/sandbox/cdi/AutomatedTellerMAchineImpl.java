package sandbox.cdi;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;

@Named("atm")
public class AutomatedTellerMAchineImpl implements AutomatedTellerMachine {

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

    @Inject
    public void setTransport(ATMTransport transport) {
        this.transport = transport;
    }
}
