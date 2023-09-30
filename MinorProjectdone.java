import org.firmata4j.I2CDevice;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.ssd1306.SSD1306;
import java.io.IOException;
import java.util.Timer;

public class MinorProjectdone {
    static final byte I2C0 = 0x3C; // OLED   Display
    public static void main(String[] args) throws IOException, InterruptedException {
        var myUSBport = "/dev/cu.usbserial-0001";
        var device = new FirmataDevice(myUSBport);
        device.start();
        device.ensureInitializationIsDone();

        I2CDevice i2cObject = device.getI2CDevice((byte) 0x3C); // Use 0x3C for the Grove OLED
        SSD1306 theOledObject = new SSD1306(i2cObject, SSD1306.Size.SSD1306_128_64); // 128x64 OLED SSD1515
        theOledObject.init();


        var moistureSensor = device.getPin(15);
        moistureSensor.setMode(Pin.Mode.ANALOG);

        var pump = device.getPin(2);
        pump.setMode(Pin.Mode.OUTPUT);

        Timer timer = new Timer();
        var task = new moistureTask(theOledObject, moistureSensor, timer, pump, 1);
        timer.schedule(task, 0, 1000);



    }

}