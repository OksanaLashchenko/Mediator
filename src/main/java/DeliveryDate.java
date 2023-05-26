import java.time.LocalDate;

public class DeliveryDate extends Component{

    private final LocalDate deliveryDate;

    public DeliveryDate(Mediator dialog, LocalDate deliveryDate) {
        super(dialog);
        this.deliveryDate = deliveryDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

}
