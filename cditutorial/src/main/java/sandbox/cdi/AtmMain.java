package sandbox.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.math.BigDecimal;

public class AtmMain {

    public static void main(String[] args) {

        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        AutomatedTellerMachine atm = container.instance().select(AutomatedTellerMachine.class).get();

        atm.deposit(new BigDecimal("10.00"));
        atm.withdraw(new BigDecimal("1000.00"));

        weld.shutdown();
    }
}
