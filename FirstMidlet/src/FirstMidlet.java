import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class FirstMidlet extends MIDlet {
    private Display display;
    private TextBox textBox;
    private boolean started;
    private TextBox emailTxt;
    private TextBox passwordTxt;
    private TextBox nameTxt;
    private TextBox mobileTxt;
    private TextBox urlTxt;

    public FirstMidlet() {
        this.display = Display.getDisplay(this);
        emailTxt = new TextBox("Email", "", 100, TextField.EMAILADDR);
        passwordTxt = new TextBox("Password", "", 16, TextField.PASSWORD);
        nameTxt = new TextBox("Name", "", 50, TextField.ANY);
        mobileTxt = new TextBox("Mobile", "", 15, TextField.PHONENUMBER); // Correction ici
        urlTxt = new TextBox("Website", "", 100, TextField.URL);
        this.textBox = new TextBox("titre du texte", "Bonjour", 20, TextField.PASSWORD);
        started = false;
    }

    protected void startApp() {
        if (!started) {
            display = Display.getDisplay(this);
            Form form = new Form("Item Layout");
            form.append("Hello");
            form.append("World");
            form.append("\nLet's start \n a new line\n");
            form.append("Second line");
            form.append(new TextField("Name", "Said", 32, TextField.ANY));
            form.append("Address");
            form.append(new TextField(null, null, 32, TextField.ANY));
            display.setCurrent(form);
            started = true;
        } else {
            display.setCurrent(textBox);
            System.out.println(textBox.getString());
        }
    }

    protected void pauseApp() {
    }

    protected void destroyApp(boolean unconditional) {
    }
}
