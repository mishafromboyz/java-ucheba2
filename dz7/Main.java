package dz7;

public class Main {
    public static void main(String[] args)
    {
        Kunteynir k = new Kunteynir();
        k.spisok.add(new Printer("sample@text.com", new int[]{255, 255, 255, 0}));
        k.spisok.add(new Printer("email a", new int[]{0, 0, 0, 1}));

        k.sendEmail(k.spisok.elementAt(0), "hello", "email a");
        k.spisok.elementAt(1).print();

        k.spisok.elementAt(1).scan("D:\\prog\\java\\ucheba2\\dz7\\Main.java");
        k.spisok.elementAt(1).print();

        k.sendId(k.spisok.elementAt(1), "world", 0);
        k.spisok.elementAt(0).print();

        k.sendIP(k.spisok.elementAt(0), "sample text", new int[]{0, 0, 0, 1});
        k.spisok.elementAt(0).print();
    }
}
