import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class MIDletList extends MIDlet {
    private Display display;
    private List liste;

    public MIDletList() {
        this.display = Display.getDisplay(this);

        // Déclaration et initialisation du tableau items
        String[] items = { "Item 1", "Item 2", "Item 3", "Item 4" };

        // Création de la liste avec les éléments
        this.liste = new List("Selection", List.EXCLUSIVE, items, null);
    }

    protected void startApp() {
        display.setCurrent(liste);
    }

    protected void pauseApp() {
    }

    protected void destroyApp(boolean unconditional) {
    }
}
