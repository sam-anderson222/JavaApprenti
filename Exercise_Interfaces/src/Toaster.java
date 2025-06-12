public class Toaster extends Device implements Connectable {
    public Toaster(String deviceName) {
        super(deviceName);
        deviceType = "Toaster";
    }

    @Override
    public void turnOn() {
        deviceState = true;
        System.out.printf("%s was turned on. Your food is now toasting.%n", deviceName);
    }

    @Override
    public void turnOff() {
        deviceState = false;
        System.out.printf("%s was turned off. Your food is ready to eat!%n", deviceName);
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
