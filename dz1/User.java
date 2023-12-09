package dz1;

public class User
{
    private long phone;
    private String name;
    private double score;

    public void setPhone(long phone)
    {
        this.phone = phone;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setScore(double score)
    {
        this.score = score;
    }

    public long getPhone()
    {
        return this.phone;
    }

    public String getName()
    {
        return this.name;
    }

    public double getScore()
    {
        return this.score;
    }
}