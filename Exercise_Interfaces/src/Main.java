import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean runProgram = true;
        DeviceService deviceService = new DeviceService();

        while (runProgram) {
            TerminalUtils.printMenu();
            String userInput = TerminalUtils.getUserStr("Enter an option: ");

            switch (userInput) {
                case "1": // Add device
                    addDevice(deviceService);
                    break;
                case "2": // Show devices
                    TerminalUtils.printDevices(deviceService.getDevices());
                    break;
                case "3": // Turn on device
                    turnOn(deviceService);
                    break;
                case "4": // Turn of device
                    turnOff(deviceService);
                    break;
                default:
                    runProgram = false;
                    break;
            }
        }
    }

    // Since this is a small program, I didn't make separate workflow classes for the menu options.
    public static void addDevice(DeviceService ds) {
        String deviceName = TerminalUtils.getUserStr("Enter device name: ");
        String deviceType = TerminalUtils.getUserStr("Enter device type: ");
        if (deviceType.equalsIgnoreCase("fridge")) {
            ds.addDevice(new Fridge(deviceName));
        } else if (deviceType.equalsIgnoreCase("tv")) {
            ds.addDevice(new TV(deviceName));
        } else if (deviceType.equalsIgnoreCase("toaster")) {
            ds.addDevice(new Toaster(deviceName));
        } else {
            TerminalUtils.printMessage("Error, invalid device type.");
        }
    }

    public static void turnOn(DeviceService ds) {
        TerminalUtils.printDevices(ds.getDevices());
        int index = TerminalUtils.getUserInt("Enter the device you wish to turn on: ");
        ds.getDevice(index).turnOn();
    }

    public static void turnOff(DeviceService ds) {
        TerminalUtils.printDevices(ds.getDevices());
        int index = TerminalUtils.getUserInt("Enter the device you wish to turn off: ");
        ds.getDevice(index).turnOff();
    }
}
