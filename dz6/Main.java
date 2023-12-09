package dz6;

public class Main {
    public static void main(String[] args)
    {
        Gas vaz = Gas.newBuilder()
                .setGearbox(5)
                .setRedline(8000)
                .setName("VAZ 2106")
                .setPower(700)
                .setMass(1500)
                .build();

        vaz.getInfo();

        vaz.accelerate(null);
        System.out.println(vaz.getCurrentSpeed());
        System.out.println(vaz.getCurrentRPM());

        vaz.switchGear(2);
        System.out.println(vaz.getCurrentRPM());

        Electro msk = Electro.newBuilder()
                .setMass(1500)
                .setName("moskvich 911 gt3 rs")
                .setPower(600)
                .setBatteryCapacity(1000)
                .build();

        msk.getInfo();

        msk.accelerate(null);
        System.out.println(msk.getCurrentSpeed());
        System.out.println(msk.getCurrentBattery());

        Tractor tr = Tractor.newBuilder()
                .setMass(3000)
                .setName("mclaren")
                .setPower(500)
                .setMod("blades")
                .build();

        tr.getInfo();

        tr.work();
        tr.pull(1000);
    }
}
