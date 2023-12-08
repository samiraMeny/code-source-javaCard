import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.Ticker;
import javax.microedition.midlet.MIDlet;

public class ImageMidlet extends MIDlet implements CommandListener {
    private Display display;
    private Form mainForm;
    private StringItem msg;
    private Ticker ticker;

    public ImageMidlet() {
        display = Display.getDisplay(this);
        mainForm = new Form("maForme");
        ticker = new Ticker("Be careful, a tiger is coming");
        msg = new StringItem("", "A TIGER");
        mainForm.addCommand(new Command("Exit", Command.EXIT, 0));
        mainForm.append(msg);
        mainForm.setCommandListener(this);

        try {
            Image img = Image.createImage("/images/tiger.jpg");
            mainForm.append(new ImageItem(null, img, ImageItem.LAYOUT_CENTER, null));
            display.setCurrent(mainForm);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public void startApp() {
        mainForm.setTicker(ticker);
        display.setCurrent(mainForm);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if (c.getCommandType() == Command.EXIT) {
            destroyApp(true);
            notifyDestroyed();
        }
    }
}
