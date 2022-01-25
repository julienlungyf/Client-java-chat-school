import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Reader extends Thread{
    private Socket s;
    public void run() {
        try {
            DataInputStream e = new DataInputStream(s.getInputStream());
            while (true)
                System.out.println(e.readUTF());
        } catch (IOException ignored) {
        }
    }
    public Reader(Socket s) {
        this.s = s;
    }
}
