package lab4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class which is describing an entity Department
 */
public class Division {

    private static AtomicInteger idCounter = new AtomicInteger(0);
    private int ID;
    private String title;

    /** Default constructor for an object of the Department class */
    public Division() {
        this.ID = createID();
        this.title = "noTitle";
    }

    /** Constructor with parameters for an object of the Department class */
    public Division(String title) {
        this.ID = createID();
        this.title = title;
    }

    public int createID() {
        return idCounter.incrementAndGet();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ID: " + this.getID() +
                "\nНазвание: " + this.getTitle();
    }
}