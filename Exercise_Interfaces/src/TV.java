public class TV extends Device implements Connectable{
    public TV(String deviceName) {
        super(deviceName);
        deviceType = "TV";
    }

    @Override
    public void turnOn() {
        deviceState = true;
        System.out.printf("%s was turned on.%n", deviceName);
    }

    @Override
    public void turnOff() {
        deviceState = false;
        System.out.printf("%s was turned off.%n", deviceName);
    }

    @Override
    public String getDeviceName() {
        return deviceName;
    }

    @Override
    public String getDeviceType() {
        return deviceType;
    }

    @Override
    public boolean getCurrentState() {
        return deviceState;
    }
}
