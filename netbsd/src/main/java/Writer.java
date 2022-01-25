import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Writer extends Thread{
    final private Socket s;
    public void run()
    {
        try {
            DataOutputStream dOut;
            dOut = new DataOutputStream(s.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            while(true)
                dOut.writeUTF(scanner.nextLine());

        } catch (IOException ignore) {
        }
    }



    public Writer(Socket s)
    {
        this.s = s;
    }
}
