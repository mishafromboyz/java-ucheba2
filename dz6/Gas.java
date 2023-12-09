package dz6;

public class Gas extends Car
{
    protected int gearbox;
    protected int redline;
    protected int currentGear = 0;
    protected int currentRPM = 0;

    public int getCurrentGear()
    {
        return currentGear;
    }

    public void setCurrentGear(int currentGear) {
        this.currentGear = currentGear;
    }


    public int getCurrentRPM() {
        return currentRPM;
    }

    public void setCurrentRPM(int currentRPM) {
        this.currentRPM = currentRPM;
    }

    public void switchGear(int desiredGear)
    {
        int diff =  desiredGear - currentGear;

        setCurrentGear(desiredGear);
        setCurrentRPM(getCurrentRPM() - 2000 * diff);

        if (getCurrentRPM() < 0)
        {
            setCurrentRPM(0);
            System.out.println("oh no! mashina zaglohla!");
            return;
        }
        while (getCurrentRPM() > redline)
        {
            brake(100.0); //downshifting
        }
    }

    @Override
    public void accelerate(Double accelValue)
    {
        super.accelerate(accelValue);
        setCurrentRPM(getCurrentSpeed() * 200 - (2000 * (currentGear - 1)));

        if (getCurrentRPM() > redline)
        {
            setCurrentRPM(redline);
            setCurrentSpeed((int)((redline + (2000 * currentGear - 1)) * 0.005));
        }

        if (getCurrentRPM() > 6000)
            System.out.println("this car is being loud");

    }

    @Override
    public void brake(Double brakeValue)
    {
        super.brake(brakeValue);
        setCurrentRPM(getCurrentSpeed() * 200 - (2000 * (currentGear - 1)));
        if (getCurrentRPM() < 0)
        {
            setCurrentRPM(0);
            System.out.println("oh no! mashina zaglohla!");
        }
        return;
    }

    @Override
    public void getInfo()
    {
        System.out.println("\nfuel = gas\ntype = road car\ngearbox = "
                + gearbox + " gears");
        super.getInfo();
    }

    public static GasBuilder newBuilder()
    {
        return new Gas().new GasBuilder();
    }

    public class GasBuilder
    {
        private GasBuilder()
        {}

        public GasBuilder setGearbox(int gearbox)
        {
            Gas.this.gearbox = gearbox;
            return this;
        }

        public GasBuilder setRedline(int redline)
        {
            Gas.this.redline = redline;
            return this;
        }

        public GasBuilder setMass(double mass) {
            Gas.this.mass = mass;
            return this;
        }

        public GasBuilder setPower(int power) {
            Gas.this.power = power;
            Gas.this.topSpeed = (int)(Math.sqrt(power * 0.5) * 20);
            return this;
        }

        public GasBuilder setName(String name)
        {
            Gas.this.name = name;
            return this;
        }

        public Gas build()
        {
            return Gas.this;
        }
    }
}
