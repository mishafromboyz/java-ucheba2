package dz7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Printer implements Print, Scan, Send
{
    public String getEmail() {
        return email;
    }

    public int[] getIp() {
        return ip;
    }

    private final String email;
    private final int[] ip;
    private List<String> buffer = new ArrayList<String>();

    public Printer(String email, int[] ip) {
        this.email = email;
        this.ip = ip;
    }

    public void receive(String text, Printer sender)
    {
        this.buffer.clear();
        this.buffer.add(text);
        System.out.println("\nreceived text from user with:\nemail: " + sender.email + "\nip: " + Arrays.toString(sender.ip));
    }

    public void print()
    {
        for (String text: buffer)
        {
            print(text);
        }
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void scan(String path)
    {
        buffer.clear();
        Path path1 = Path.of(path);
        if (!Files.exists(path1))
        {
            System.out.println("\ncouldnt find file");
            return;
        }
        try
        {
            System.out.println("\nscanning " + path);
            buffer = Files.readAllLines(path1);
        }
        catch (IOException e)
        {
            System.out.println("\nfile is corrupted");
        }
    }

    public void send(String text, Printer receiver)
    {
        System.out.println("\ntext sent");
        receiver.receive(text, this);
    }
}
