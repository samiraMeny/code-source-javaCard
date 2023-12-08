import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.Ticker;
import javax.microedition.midlet.MIDlet;

public class Afficher_image extends MIDlet implements CommandListener {
    private Display display;
    private Form mainForm;
    private StringItem msg;
    private Ticker ticker;

    public Afficher_image() {
        display = Display.getDisplay(this);
        mainForm = new Form("maForme");
        ticker = new Ticker("Be careful, a tiger is coming");
        msg = new StringItem("", "A TIGER");
        mainForm.addCommand(new Command("Exit", Command.EXIT, 0));
        mainForm.append(msg);

        try {
            Image img = Image.createImage("/images/Tiger.jpeg");
            mainForm.append(new ImageItem(null, img, ImageItem.LAYOUT_CENTER, null));
            display.setCurrent(mainForm);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        mainForm.setCommandListener(this);
    }

    public void startApp() {
        mainForm.setTicker(ticker);
        display.setCurrent(mainForm);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, javax.microedition.lcdui.Displayable d) {
        if (c.getCommandType() == Command.EXIT) {
            destroyApp(true);
            notifyDestroyed();
        }
    }
}
