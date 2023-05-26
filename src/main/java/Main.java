import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Mediator orderDeliveryDialog = new OrderDeliveryDialog();
        Component deliveryToAnotherPerson = new DeliveryToAnotherPerson(orderDeliveryDialog);
        Component deliveryDate1 = new DeliveryDate(orderDeliveryDialog, LocalDate.now().plusDays(1L));
        Component deliveryDate2 = new DeliveryDate(orderDeliveryDialog, LocalDate.now());
        Component takeAwayDelivery = new TakeAwayDelivery(orderDeliveryDialog);

        orderDeliveryDialog.notifySender(deliveryToAnotherPerson, "true");
        orderDeliveryDialog.notifySender(deliveryToAnotherPerson, "false");

        orderDeliveryDialog.notifySender(deliveryDate1, "true");
        orderDeliveryDialog.notifySender(deliveryDate1, "false");
        orderDeliveryDialog.notifySender(deliveryDate2, "true");

        orderDeliveryDialog.notifySender(takeAwayDelivery, "true");
        orderDeliveryDialog.notifySender(takeAwayDelivery, "false");
    }

}
