import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.net.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("10.57.12.212", 42609);
        Reader r = new Reader(s);
        Writer w = new Writer(s);
        r.start();
        w.start();
    }
}
