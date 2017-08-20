package sandbox.cdi;

import java.math.BigDecimal;

public interface AutomatedTellerMachine {

    void deposit(BigDecimal bd);
    void withdraw(BigDecimal bd);

}
