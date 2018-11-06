import com.phua.lambdaexpression.Credit;
import com.phua.lambdaexpression.Message;
import com.phua.lambdaexpression.Transaction;
import org.junit.Test;

public class TestMain {

    @Test
    public void testCredit() {

        Credit credit = new Credit(100);

        Transaction deposit = (amount) -> credit.getTotal() + amount;

        Transaction withdraw = (amount) -> credit.getTotal() - amount;

        Message output = (result) -> System.out.println("total:" + result);


        output.prompt(String.valueOf(credit.execute(deposit, 100)));
        output.prompt(String.valueOf(credit.execute(withdraw, 20)));
    }

}
