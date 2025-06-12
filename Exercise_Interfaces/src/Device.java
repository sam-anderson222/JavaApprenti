public class Device {
    protected String deviceName;
    protected String deviceType;
    protected boolean deviceState;

    public Device(String deviceName) {
        this.deviceName = deviceName;
        this.deviceState = false; // Devices are off by default
    }
}
