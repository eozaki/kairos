import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private ExecutorService pool = Executors.newFixedThreadPool(5);

    public Server() {}

    public void run() throws IOException {
        ServerSocket ss = new ServerSocket(3000);

        try {
            while(true) {
                Socket socket = ss.accept();
                ClientHandler ch = new ClientHandler(socket);
                pool.execute(ch);
            }
        } catch(IOException e) {
            System.out.println("Algo de errado não está certo");
        } finally {
            ss.close();
        }
    }
}
