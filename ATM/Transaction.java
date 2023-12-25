package ATM;

import java.time.Instant;
import java.util.Date;
import java.util.Map;

public class Transaction
{
    private final Account sender;
    private final Account receiver;
    private final Date date;
    private final Map.Entry<Currency, Double> amount;

    public Transaction(Account sender, Account receiver, Map.Entry<Currency, Double> amount)
    {
        this.sender = sender;
        this.receiver = receiver;
        this.date = Date.from(Instant.now());
        this.amount = amount;
    }

    @Override
    public String toString()
    {
        return "transaction{" +
                "sender=" + sender.getName() +
                ", receiver=" + receiver.getName() +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
