package businessobject;

public class Destination {

    private static String destination;

    public Destination(String destination) {
        this.destination = destination;
    }

    public String getDestination(){
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}