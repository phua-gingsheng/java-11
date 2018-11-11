import com.phua.datetime.TimerImpl;
import com.phua.interfacechanges.InterfaceSample;
import com.phua.lambdaexpression.Credit;
import com.phua.lambdaexpression.Message;
import com.phua.lambdaexpression.Transaction;
import com.phua.linuxpid.PID;
import com.phua.moneycurrency.Account;
import org.junit.Test;

import javax.management.timer.Timer;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class TestMain {

    @Test
    public void testLambdaExpression() {

        Credit credit = new Credit(100);

        Transaction deposit = (amount) -> credit.getTotal() + amount;

        Transaction withdraw = (amount) -> credit.getTotal() - amount;

        Message output = (result) -> System.out.println("total:" + result);


        output.prompt(String.valueOf(credit.execute(deposit, 100)));
        output.prompt(String.valueOf(credit.execute(withdraw, 20)));
    }

    @Test
    public void testInterfaceChanges() {

        class Implementation implements InterfaceSample {

            @Override
            public void existingMethod() {
                newMethod();
                newMethodAgain();
            }
        }

        Implementation implementation = new Implementation();
        implementation.existingMethod();
        InterfaceSample.anotherNewMethod();

    }


    @Test
    public void testTime() throws InterruptedException {

        TimerImpl timerImpl = new TimerImpl();

        timerImpl.start();
        TimeUnit.SECONDS.sleep(3);
        timerImpl.stop();
        timerImpl.getNanos();
        timerImpl.getMilis();
        timerImpl.getSeconds();
        timerImpl.getMinutes();

    }


    @Test
    public void testLinuxPID() throws IOException, InterruptedException {
        System.out.println(PID.getPID());
    }

    @Test
    public void testCurrency() {
        Account ac = new Account(Locale.US, 100000);

        ac.status();
        ac.withdraw(1000);
        ac.status();
        ac.deposit(5000);
        ac.status();
        ac.withdraw(10000000);

        System.out.println(ac.getAmount());
        String value = ac.convert(ac.getAmount(),Account.CURRENCY.USD,Account.CURRENCY.CNY);
        System.out.println(value);

    }
}
