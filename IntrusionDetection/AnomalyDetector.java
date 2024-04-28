public class AnomalyDetector {
    // Existing code...

    public boolean detectAnomaly(String trafficData) {
        // Consider any traffic data containing the word "ALERT" as an anomaly
        return trafficData.contains("ALERT");
    }

    public boolean detectRealAnomaly(String trafficData) {
        // Implement your logic to detect a real anomaly here
        // You can use various techniques such as statistical analysis, machine
        // learning, or rule-based systems

        // Example: Check if the traffic data exceeds a certain threshold
        int threshold = 2;
        int trafficCount = countTraffic(trafficData);
        return trafficCount > threshold;
    }

    private int countTraffic(String trafficData) {
        // Implement your logic to count the traffic data here
        // Example: Count the number of occurrences of a specific keyword
        String keyword = "ANOMALY";
        int count = 0;
        int index = trafficData.indexOf(keyword);
        while (index != -1) {
            count++;
            index = trafficData.indexOf(keyword, index + keyword.length());
        }
        return count;
    }
}
