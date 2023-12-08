import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class FirstMidlets extends MIDlet implements CommandListener {
    private Display display;
    private TextBox emailTxt;
    private TextBox passwordTxt;
    private TextBox nameTxt;
    private TextBox mobileTxt;
    private TextBox urlTxt;
    private TextBox textBox;
    private String str2;
    private Command nextCommand;
    private Command exitCommand;

    public FirstMidlets() {
        this.display = Display.getDisplay(this);
        emailTxt = new TextBox("Email", "", 100, TextField.EMAILADDR);
        passwordTxt = new TextBox("Password", "", 16, TextField.PASSWORD);
        nameTxt = new TextBox("Name", "", 50, TextField.ANY);
        mobileTxt = new TextBox("Mobile", "", 15, TextField.PHONENUMBER);
        urlTxt = new TextBox("Website", "", 100, TextField.URL);
        this.textBox = new TextBox("Titre du texte", "Bonjour", 20, TextField.ANY);
        str2 = textBox.getString();

        nextCommand = new Command("Next", Command.OK, 1);
        exitCommand = new Command("Exit", Command.EXIT, 1);

        emailTxt.addCommand(nextCommand);
        passwordTxt.addCommand(nextCommand);
        nameTxt.addCommand(nextCommand);
        mobileTxt.addCommand(nextCommand);
        urlTxt.addCommand(nextCommand);
        textBox.addCommand(exitCommand);

        emailTxt.setCommandListener(this);
        passwordTxt.setCommandListener(this);
        nameTxt.setCommandListener(this);
        mobileTxt.setCommandListener(this);
        urlTxt.setCommandListener(this);
        textBox.setCommandListener(this);
    }

    protected void startApp() {
        display.setCurrent(emailTxt);
    }

    protected void pauseApp() {
    }

    protected void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if (c == nextCommand) {
            if (d == emailTxt) {
                display.setCurrent(passwordTxt);
            } else if (d == passwordTxt) {
                display.setCurrent(nameTxt);
            } else if (d == nameTxt) {
                display.setCurrent(mobileTxt);
            } else if (d == mobileTxt) {
                display.setCurrent(urlTxt);
            } else if (d == urlTxt) {
                display.setCurrent(textBox);
            }
        } else if (c == exitCommand) {
            destroyApp(true);
            notifyDestroyed();
        }
    }
}
