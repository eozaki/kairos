import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem vindo ao kairós");

        Server s = new Server();

        try {
            s.run();
        } catch (IOException e) {
            System.out.println("Fatal error");
        }
    }
}