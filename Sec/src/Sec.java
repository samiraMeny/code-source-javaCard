import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.util.Calendar;

public class Sec extends MIDlet implements CommandListener {

    private Display display;
    private Form form;
    private boolean started = false;

    public Sec() {
    }

    protected void startApp() {
        if (!started) {
            display = Display.getDisplay(this);

            form = new Form("Sec");

            // Text
            form.append("Hello, this is a MIDlet!");

            // List of Choices
            String[] choices = { "Option 1", "Option 2", "Option 3", "Option 4" };
            ChoiceGroup choiceGroup = new ChoiceGroup("Selectionner une option:", ChoiceGroup.EXCLUSIVE, choices, null);
            form.append(choiceGroup);

            // Date
            DateField dateField = new DateField("Select a date:", DateField.DATE);
            form.append(dateField);

            // Text Field
            form.append(new TextField("Enter your name:", "", 32, TextField.ANY));

            // Progress Bar
            Gauge gauge = new Gauge("Progress:", true, 100, 0);
            form.append(gauge);

            // Display current time using Calendar
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            int second = calendar.get(Calendar.SECOND);
            form.append("Current Time: " + hour + ":" + minute + ":" + second);

            // Exit Command
            Command exitCommand = new Command("Exit", Command.EXIT, 0);
            form.addCommand(exitCommand);
            form.setCommandListener(this);

            display.setCurrent(form);
            started = true;
        }
    }

    protected void pauseApp() {
    }

    protected void destroyApp(boolean unconditional) {
        // Clean up resources, if any
    }

    public void commandAction(Command c, Displayable d) {
        if (c.getCommandType() == Command.EXIT) {
            destroyApp(true);
            notifyDestroyed();
        }
    }
}
