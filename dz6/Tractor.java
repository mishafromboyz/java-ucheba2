package dz6;

public class Tractor extends Car
{
    protected String mod;
    protected final int topSpeed = 30;
    protected int force;

    public void work()
    {
        switch (mod)
        {
            case ("blades"):
            {
                System.out.println("tractor kosit travy");
                break;
            }
            case ("plough"):
            {
                System.out.println("tractor pashet");
                break;
            }
            case ("OTVAL"):
            {
                System.out.println("tractor stal bulldozerom i poshel na stroiky");
                break;
            }
            default:
            {
                System.out.println("tractor poehal");
            }
        }
    }

    public void pull(int weight)
    {
        if (force < weight)
            System.out.println("load is too heavy");
        else
            System.out.println("tractor pulls");
    }

    @Override
    public void accelerate(Double accelValue) {
        super.accelerate(accelValue);
        System.out.println("tractor is being loud");
    }

    @Override
    public void getInfo()
    {
        System.out.println("\nfuel = diesel\ntype = tractor\nmod = "
        + mod + "\nmax load = " + force + "kg");
        super.getInfo();
    }

    public static Tractor.TractorBuilder newBuilder()
    {
        return new Tractor().new TractorBuilder();
    }

    public class TractorBuilder
    {
        private TractorBuilder()
        {}



        public Tractor.TractorBuilder setMass(double mass) {
            Tractor.this.mass = mass;
            return this;
        }

        public Tractor.TractorBuilder setMod(String mod) {
            Tractor.this.mod = mod;
            return this;
        }

        public Tractor.TractorBuilder setPower(int power) {
            Tractor.this.power = power;
            Tractor.this.force = power * 20;
            return this;
        }

        public Tractor.TractorBuilder setName(String name)
        {
            Tractor.this.name = name;
            return this;
        }

        public Tractor build()
        {
            return Tractor.this;
        }
    }
}
