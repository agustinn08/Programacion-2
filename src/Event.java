public class Event {
    private String name, date, category, location;
    private int availableTickets;

    public Event(String name, String date, String category, String location, int availableTickets){
        this.name = name;
        this.date = date;
        this.category = category;
        this.location = location;
        this.availableTickets = availableTickets;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public String getLocation() {
        return location;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public boolean buyTicket(){
        if(availableTickets > 0){
            availableTickets = availableTickets - 1;
            return true;
        }
        return false;
    }

    public String toString() {
        return "Event: " + name + ", Location: " + location + ", Date: " + date + ", Category: " + category +
                ", tickets available: " + availableTickets;
    }
}
