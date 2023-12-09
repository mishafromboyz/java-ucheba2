package dz6;

public class Electro extends Car
{
    protected int batteryCapacity;
    protected int currentBattery;

    public int getCurrentBattery() {
        return currentBattery;
    }

    public void setCurrentBattery(int currentBattery) {
        this.currentBattery = currentBattery;
    }


    @Override
    public void getInfo() {
        System.out.println("\nfuel = electricity\ntype = road car\nbattery capacity = "
                        + batteryCapacity + "h"
                );
        super.getInfo();
    }

    @Override
    public void accelerate(Double accelValue)
    {
        if (currentBattery < 2)
        {
            System.out.println("battery died");
            return;
        }

        super.accelerate(accelValue);
        currentBattery -= 2;
        System.out.println("car is being quiet");
    }

    @Override
    public void brake(Double brakeValue) {
        if (currentBattery < 1)
        {
            System.out.println("battery died");
            return;
        }
        super.brake(brakeValue);
        currentBattery -= 1;
    }

    public void charge(Integer time)
    {
        if (currentBattery >= batteryCapacity)
            return;

        if (time == null)
            time = 100;

        currentBattery += 100 * time;

        if (currentBattery > batteryCapacity)
            currentBattery = batteryCapacity;
    }

    public static Electro.ElectroBuilder newBuilder()
    {
        return new Electro().new ElectroBuilder();
    }

    public class ElectroBuilder
    {
        private ElectroBuilder()
        {}

        public Electro.ElectroBuilder setBatteryCapacity(int capacity)
        {
            Electro.this.batteryCapacity = capacity;
            Electro.this.currentBattery = capacity;
            return this;
        }


        public Electro.ElectroBuilder setMass(double mass) {
            Electro.this.mass = mass;
            return this;
        }

        public Electro.ElectroBuilder setPower(int power) {
            Electro.this.power = power;
            Electro.this.topSpeed = (int)(Math.sqrt(power * 0.5) * 20);
            return this;
        }

        public Electro.ElectroBuilder setName(String name)
        {
            Electro.this.name = name;
            return this;
        }

        public Electro build()
        {
            return Electro.this;
        }
    }
}
