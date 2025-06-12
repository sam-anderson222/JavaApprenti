import java.util.ArrayList;

public class DeviceService {
    private ArrayList<Connectable> devices;

    public DeviceService() {
        devices = new ArrayList<Connectable>();
    }

    public void addDevice(Connectable device) {
        devices.add(device);
    }

    public ArrayList<Connectable> getDevices() {
        return devices;
    }

    public Connectable getDevice(int index) {
        return devices.get(index - 1);
    }
}
