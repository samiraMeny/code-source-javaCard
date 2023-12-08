import java.text.Normalizer.Form;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class PremierMiDlet extends MIDlet {
    private Display display;
    private Form helloFrm;

    public PremierMiDlet() {
        helloFrm = new Form("Bonjour Midlet");
    }

    protected void startApp() {
        display = Display.getDisplay(this);
        display.setCurrent(helloFrm);
    }

    protected void pauseApp() {
    }

    protected void destroyApp(boolean unconditional) {
    }
}
