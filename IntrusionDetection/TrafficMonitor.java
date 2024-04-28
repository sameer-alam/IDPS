import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TrafficMonitor {
    private ServerSocket serverSocket;
    private AnomalyDetector anomalyDetector;
    private ResponseSystem responseSystem;

    public TrafficMonitor(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        anomalyDetector = new AnomalyDetector();
        responseSystem = new ResponseSystem();
    }

    public void startMonitoring() {
        System.out.println("Monitoring traffic on port " + serverSocket.getLocalPort() + "\n");
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                InetAddress ipAddress = socket.getInetAddress();

                // Check if IP address is blocked
                if (responseSystem.isIpAddressBlocked(ipAddress)) {
                    System.out.println("Dropping packet from blocked IP address: " + ipAddress + "\n");
                    continue;
                }

                System.out.println("New connection from " + ipAddress);
                InputStream inputStream = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    // Analyze network traffic
                    analyzeTraffic(buffer, bytesRead, ipAddress);
                }
            }
        } catch (IOException e) {
            System.err.println("Error monitoring traffic: " + e.getMessage());
        }
    }

    private void analyzeTraffic(byte[] buffer, int bytesRead, InetAddress ipAddress) {
        // Convert byte array to string
        String trafficData = new String(buffer, 0, bytesRead);

        // Print traffic data to console
        System.out.println("Received data: " + trafficData);

        // Check for anomalies
        boolean isAnomaly = anomalyDetector.detectAnomaly(trafficData);
        if (isAnomaly) {
            System.out.println("Anomaly detected!");
            // Trigger response to anomaly
            responseSystem.blockIpAddress(ipAddress);
        }

        boolean isRealAnomaly = anomalyDetector.detectRealAnomaly(trafficData);
        if (isRealAnomaly) {
            System.out.println("Anomaly detected!");
            // Trigger response to anomaly
            responseSystem.blockIpAddress(ipAddress);
        }

        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        TrafficMonitor monitor = new TrafficMonitor(9090);
        monitor.startMonitoring();
    }
}
