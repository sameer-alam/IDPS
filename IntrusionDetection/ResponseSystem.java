import java.net.InetAddress;
import java.util.HashSet;
import java.util.Set;

public class ResponseSystem {
    private Set<InetAddress> blockedIpAddresses;

    public ResponseSystem() {
        blockedIpAddresses = new HashSet<>();
    }

    public void blockIpAddress(InetAddress ipAddress) {
        blockedIpAddresses.add(ipAddress);
        System.out.println("Blocked IP address: " + ipAddress);
    }

    public boolean isIpAddressBlocked(InetAddress ipAddress) {
        return blockedIpAddresses.contains(ipAddress);
    }
}
