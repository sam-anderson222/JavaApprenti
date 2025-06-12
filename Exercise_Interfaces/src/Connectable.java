public interface Connectable {
    void turnOn();
    void turnOff();
    String getDeviceName();
    String getDeviceType(); // Returns the type of device (TV / Fridge / Toaster / etc.)
    boolean getCurrentState();
}
