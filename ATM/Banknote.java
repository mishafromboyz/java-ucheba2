package ATM;

public enum Banknote
{
    thousand (1000.0),
    hundred (100.0),
    fifty (50.0),
    ten (10.0);
    private final Double value;
    Banknote(Double value)
    {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }
}
