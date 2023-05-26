import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class OrderDeliveryDialog implements Mediator {

    @Override
    public void notifySender(Component sender, String event) {
        if (sender instanceof TakeAwayDelivery) {
            if (event.equals("true")) {
                System.out.println("Self-taken delivery processed");
                return;
            } else {
                System.out.println("Process delivery to person");
            }
        }
        if (sender instanceof DeliveryToAnotherPerson) {
            deliverToPerson(event);
        }
        if (sender instanceof DeliveryDate) {
            chooseDeliveryDate((DeliveryDate) sender, event);
        }
    }

    void chooseDeliveryDate(DeliveryDate sender, String event) {
        if (event.equals("true") && sender.getDeliveryDate().getDayOfYear() == LocalDate.now().getDayOfYear()) {
            System.out.println("The current date delivery is scheduling");
        } else if (event.equals("true") && sender.getDeliveryDate().getDayOfYear() > LocalDate.now().getDayOfYear()) {
            System.out.println("The future delivery date is scheduling");
        } else {
            System.out.println("The delivery is not necessary");
        }
    }

    void deliverToPerson(String event) {
        if (event.equals("true")) {
            System.out.println("Enter name and phoneNumber:");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String name = reader.readLine();
                String phoneNumber = reader.readLine();
                System.out.println("Delivery is taken for another person " + name + " " + phoneNumber);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Delivery is taken for the registered client");
        }
    }

}
