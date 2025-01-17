import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private List<Event> events;

    public EventManager(){
        this.events = new ArrayList<>();
    }

    public void createEvent (String name, String date, String location, String category, int availableTickets){
        events.add(new Event(name, date, category, location, availableTickets));
    }

    public List<Event> searchEvent(String keyword, String name, String date, String location, String category, int availableTickets){
        List<Event> result = new ArrayList<>();

        for (Event event : events){
            boolean matchesKeyword = keyword != null && (event.getName().toLowerCase().contains(keyword.toLowerCase())) || event.getCategory().toLowerCase().contains(keyword.toLowerCase());
            boolean matchesName = name != null && event.getName().equals(name);
            boolean matchesDate = date  != null && event.getDate().equals(date);
            boolean matchesLocation = location != null && event.getLocation().equals(location);
            if (matchesLocation || matchesDate || matchesLocation || matchesKeyword || matchesName){
                result.add(event);
            }
        }
        return result;

    }
    public List<Event> getEvent() {
        return events;
    }
}


