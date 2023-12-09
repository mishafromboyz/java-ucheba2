package dz6;

public abstract class Car
{
    protected double mass;
    protected int power;
    protected int topSpeed;
    protected String name;
    protected int currentSpeed = 1;

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int Speed) {
        this.currentSpeed = Speed;
    }


    public void getInfo()
    {
        System.out.println("name = " + name +
                "\nmass = " + mass + "kg\npower = "
                + power + "hp\ntop speed = " + topSpeed + "kmh");
    }

    public void accelerate(Double accelValue)
    {

        if (getCurrentSpeed() >= topSpeed)
            return;

        if (accelValue == null)
            accelValue = 100.0;

        setCurrentSpeed((int)(getCurrentSpeed() + 500 * accelValue / mass));

        if (getCurrentSpeed() > topSpeed)
            setCurrentSpeed(topSpeed);
    }
    public void brake(Double brakeValue)
            //tormoz per sec
    {

        if (getCurrentSpeed() <= 0)
            return;

        if (brakeValue == null)
            brakeValue = 100.0;
            //tormoz v pol

        setCurrentSpeed((int)(getCurrentSpeed() - 500 * brakeValue / mass));

        if (getCurrentSpeed() < 0)
            setCurrentSpeed(0);
    }

}
