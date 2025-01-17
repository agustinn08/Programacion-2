
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    EntrySystem system = new EntrySystem();

    system.getEventManager().createEvent("Pelicula","2025-01-17", "Abasto Shopping", "Cine", 15);
    system.getEventManager().createEvent("Partido de futbol", "2025-01-18", "Estadio de Boca", "Futbol", 20);
    system.getEventManager().createEvent("Duky","2025-01-25", "Luna Park", "Show", 1500);
    system.getEventManager().createEvent("Boxeo","2025-02-24", "Bernabeu", "Espectaculo box", 0);

        System.out.println("Ingrese su nombre");
        String name = scanner.nextLine();
        System.out.println("Ingrese su mail");
        String email = scanner.nextLine();
        User user = new User(name, email);

        boolean True = true;
        while (True){
            System.out.println(" 1. Listar eventos / 2. Buscar eventos / 3. Comprar entrada / 4. Ver mis entradas / 5. Salir");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1:
                    for (Event event : system.getEventManager().getEvent()){
                        System.out.println(event);
                    }
                    break;
                case 2:
                    System.out.println("ingrese una palabra clave / fecha / lugar / nombre / categoria");
                    System.out.print("Palabra clave: ");
                    String keyword = scanner.nextLine();
                    System.out.print("Nombre del evento: ");
                    String eventName = scanner.nextLine();
                    System.out.print("Fecha del evento (YYYY-MM-DD): ");
                    String eventDate = scanner.nextLine();
                    System.out.print("Ubicación del evento: ");
                    String eventLocation = scanner.nextLine();
                    System.out.print("Categoría del evento: ");
                    String eventCategory = scanner.nextLine();
                    System.out.print("Entradas disponibles (deja en blanco para no filtrar): ");
                    String ticketsInput = scanner.nextLine();
                    int availableTickets = ticketsInput.isEmpty() ? -1 : Integer.parseInt(ticketsInput);
                    List<Event> results = system.getEventManager().searchEvent(keyword, eventName, eventDate, eventLocation, eventCategory, availableTickets);
                    if (results.isEmpty()) {
                        System.out.println("No se encontraron eventos.");
                    } else {
                        for (Event event : results) {
                            System.out.println(event);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Introduce el título del evento para comprar una entrada: ");
                    String eventTitle = scanner.nextLine();
                    Event selectedEvent = null;
                    for (Event event : system.getEventManager().getEvent()) {
                        if (event.getName().equalsIgnoreCase(eventTitle)) {
                            selectedEvent = event;
                            break;
                        }
                    }
                    if (selectedEvent == null) {
                        System.out.println("Evento no encontrado.");
                    } else {
                        System.out.print("Selecciona el tipo de entrada (General/VIP): ");
                        String ticketType = scanner.nextLine();
                        system.buyTicket(user, selectedEvent, ticketType);
                    }
                    break;

                case 4:
                    system.showTickets(user);
                    break;

                case 5:
                    True = false;
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}








