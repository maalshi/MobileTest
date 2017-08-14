package businessobject;

public class Destination {

    private static String destination;

    public Destination(String destination) {
        this.destination = destination;
    }

    public static String getDestination(){
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}