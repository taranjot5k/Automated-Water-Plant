import  org.firmata4j.Pin;
import org.firmata4j.ssd1306.MonochromeCanvas;
import org.firmata4j.ssd1306.SSD1306;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;



public class moistureTask extends TimerTask {
    private int duration;
    private final SSD1306 theOledObject;
    private final Pin moistureSensor;
    private final Timer myTimer;
    private final Pin pump;


    public moistureTask(SSD1306 display, Pin pin, Timer timer, Pin pump, int duration) {
        this.theOledObject = display;
        this.moistureSensor = pin;
        this.myTimer = timer;
        this.pump = pump;
    }

    @Override
    public void run() {
        double Value = moistureSensor.getValue();
        String MoistureReading = String.valueOf(Value);
        //	print	to	the	Java	console
        System.out.println(MoistureReading);
        String r = MoistureReading;


        if (moistureSensor.getValue() <= 700) {
            theOledObject.getCanvas().setTextsize(1);
            theOledObject.getCanvas().drawString(0,0,r);
            theOledObject.getCanvas().drawString(0, 10, "WET SOIL.Pump OFF");

            try {
                pump.setValue(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (moistureSensor.getValue() >= 700) {
            theOledObject.getCanvas().setTextsize(1);
            theOledObject.getCanvas().drawString(0,0,r);
            theOledObject.getCanvas().drawString(0, 10, "DRY SOIL.Pump On");
            try {
                pump.setValue(1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Next,	erase	the	previous horizontal	 line	by	applying	"DARK"
        theOledObject.getCanvas().drawHorizontalLine(0, 37, 128, MonochromeCanvas.Color.DARK);

        //		Now,	draw	a	white	line	that	is	proportional	to	the	moisture	value.
        theOledObject.getCanvas().drawHorizontalLine(0, 37, (int) Value / 8, MonochromeCanvas.Color.BRIGHT);
        theOledObject.display();
    }
}

