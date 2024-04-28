## _Overview:_

This project implements a basic Intrusion Detection and Prevention System (IDPS) in Java. The IDPS monitors network traffic in real-time, detects anomalies, and responds to potential security threats by blocking malicious IP addresses. It includes components for traffic monitoring, anomaly detection, and response mechanisms.

## _Features:_

-   Real-time monitoring of network traffic on a specified port.
-   Detection of anomalies in network traffic, including keyword-based detections and more complex anomaly identification methods.
-   Response mechanisms to swiftly respond to detected threats by blocking malicious IP addresses.
-   Customizable anomaly detection logic and response mechanisms for flexibility and adaptability.

## _Installation:_

1. Ensure you have Java installed on your system.
2. Download the provided Java files: TrafficMonitor.java, AnomalyDetector.java, and ResponseSystem.java.
3. Compile the Java files using a Java compiler such as javac.

## _Usage:_

1. Run the Traffic Monitor program by executing the command: java TrafficMonitor <port_number>.
    - Replace <port_number> with the desired port number to monitor network traffic (e.g., 9090).
2. The program will start monitoring traffic on the specified port and display information about new connections from client IP addresses.
3. Analyze network traffic and detect anomalies based on predefined criteria.
4. Respond to detected anomalies by blocking malicious IP addresses using the Response System component.
5. Customize and configure the code implementation to meet specific security requirements and network environments.

## _License:_

-   This project is licensed under the MIT License. See the LICENSE file for more information.

## _Authors:_

-   Sameer Alam
-   Muhammad Ahsan Ali Khan
-   Minal Sarwar
-   Maryam Tauqeer
-   Ramsha Munawar

## _Acknowledgments:_

-   Special thanks to Dr Imran Khan for inspiration and guidance.
