public class Fridge extends Device implements Connectable{
    public Fridge(String deviceName) {
        super(deviceName);
        deviceType = "Fridge";
    }

    @Override
    public void turnOn() {
        deviceState = true;
        System.out.printf("%s was turned on. The air inside is being cooled.%n", deviceName);
    }

    @Override
    public void turnOff() {
        deviceState = false;
        System.out.printf("%s was turned off. Your food will spoil if not turned back on.%n", deviceName);
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
