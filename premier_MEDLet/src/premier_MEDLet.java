import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class premier_MEDLet extends MIDlet implements CommandListener {
    private Display display;
    private TextBox textBox;
    private Command exitCommand;

    public premier_MEDLet() {
        this.display = Display.getDisplay(this);
        this.textBox = new TextBox("Titre du texte", "Bonjour", 20, TextField.ANY);
        this.exitCommand = new Command("Exit", Command.EXIT, 0);
        this.textBox.addCommand(exitCommand);
        this.textBox.setCommandListener(this);
    }

    protected void startApp() {
        display.setCurrent(textBox);
    }

    protected void pauseApp() {
    }

    protected void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if (c == exitCommand) {
            // Affiche le texte saisi lorsque l'utilisateur appuie sur la commande Exit
            System.out.println(textBox.getString());
            destroyApp(false);
            notifyDestroyed();
        }
    }
}
