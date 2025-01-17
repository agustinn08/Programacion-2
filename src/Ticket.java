public class Ticket {
    private Event event;
    private User user;
    private String type;

    public Ticket(Event event, User user, String type){
        this.event = event;
        this.user  = user;
        this.type = type;
    }
    public String toString() {
        return "Ticket for event: " + event.getName() +
                ", User: " + user.getName() +
                ", Ticket type: " + type;
    }
}
