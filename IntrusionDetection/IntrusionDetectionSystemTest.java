import java.io.IOException;
import java.net.Socket;

public class IntrusionDetectionSystemTest {
    public void sendTraffic(String ipAddress, int port, String trafficData) {
        try (Socket socket = new Socket(ipAddress, port)) {
            socket.getOutputStream().write(trafficData.getBytes());
        } catch (IOException e) {
            System.err.println("Error sending traffic: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        IntrusionDetectionSystemTest test = new IntrusionDetectionSystemTest();
        System.out.println("Sending nomal traffic...\n");
        test.sendTraffic("localhost", 9090, "Normal network traffic...");
        System.out.println("Sending malicious traffic...\n");
        test.sendTraffic("localhost", 9090, "ANOMALY: You have won lottery! ANOMALY ANOMALY");
        System.out.println("Sending nomal traffic...\n");
        test.sendTraffic("localhost", 9090, "Normal network traffic...");
    }
}
