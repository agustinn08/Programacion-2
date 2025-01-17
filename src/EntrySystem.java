import java.util.ArrayList;
import java.util.List;

public class EntrySystem {
    private EventManager eventManager;
    private List<Ticket> tickets;

    public EntrySystem(){
        this.eventManager = new EventManager();
        this.tickets = new ArrayList<>();

    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public void buyTicket(User user, Event event, String ticketType){
        if (event.buyTicket()){
            tickets.add(new Ticket(event,user,ticketType));
            System.out.println("Ticket purchased successfully");
        }else{
            System.out.println("Tickets not available");
        }
    }

    public void showTickets(User user) {
        boolean hasTicket = false;
        for (Ticket ticket : tickets){
            if (ticket.toString().contains(user.getName()));{
                System.out.println("The user entry "+ user.getName() + ticket);
                hasTicket = true;
            }

        }
        if (!hasTicket){
            System.out.println("You don't have tickets purchased");
        }
    }
}
