package Task3;

public class Reservation {
    int id;
    int roomId;
    String guestName;
    String guestEmail;
    String checkInDate;
    String checkOutDate;
    double amountPaid;

    public Reservation(int id, int roomId, String guestName, String guestEmail, String checkInDate, String checkOutDate, double amountPaid) {
        this.id = id;
        this.roomId = roomId;
        this.guestName = guestName;
        this.guestEmail = guestEmail;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.amountPaid = amountPaid;
    }
}
