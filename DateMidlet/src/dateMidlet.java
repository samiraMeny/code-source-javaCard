Aimport java.util.*;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class dateMidlet extends MIDlet implements CommandListener {
    private Command exitCommand;
    private Command helpCommand;
    private Display display;

    public dateMidlet() {
        display = Display.getDisplay(this);
        exitCommand = new Command("Exit", Command.EXIT, 0);
        helpCommand = new Command("Help", Command.HELP, 0);
    }

    public void startApp() {
        String str = null;  // Fix: initialize the variable
        Date date = new Date();
        str = "Date et Heure:" + date.toString();

        TextBox t = new TextBox("Date", str, 256, 0);
        t.addCommand(exitCommand);
        t.addCommand(helpCommand);
        t.setCommandListener(this);
        display.setCurrent(t);
    }

    public void pauseApp() {}

    public void destroyApp(boolean unconditional) {}

    public void commandAction(Command c, Displayable s) {
        if (c == helpCommand) {
            System.out.println("help");
        } else if (c == exitCommand) {
            destroyApp(false);
            notifyDestroyed();
        }
    }
}
