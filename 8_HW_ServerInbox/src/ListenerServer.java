import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ListenerServer {
    // Class member ---
    final int _PORT_NO = 3000;
    private ServerSocket myServerSocket;

    public ListenerServer() throws IOException {
        myServerSocket = new ServerSocket(_PORT_NO);
        //myServerSocket.setSoTimeout(10000);
    }

    public void Listening() {
        while (true) {
            try {
                System.out.println("Waiting for client on port " +
                        myServerSocket.getLocalPort() + "...");

                Socket mySocket = myServerSocket.accept();

                System.out.println("Just connected to " +
                        mySocket.getRemoteSocketAddress());

                // Create thread for communication with client ---
                Thread myAppServerThread = new AppServer(mySocket);

                myAppServerThread.start();  // Running thread ---
            }
            catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            }
            catch (IOException e) {
                e.printStackTrace();
                break;
            }
            finally {
                // do noting ---
            }
        }
    }
}
