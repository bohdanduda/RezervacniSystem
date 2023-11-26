package Models;

public class Wagon {
    private int id;
    private boolean[][] seats;

    public Wagon(int id, int seatRowCount) {
        this.id = id;
        this.seats = new boolean[2][seatRowCount];
    }

    public void reserveSeat(int seat, int row) {
        if (!seats[seat][row]) {
            seats[seat][row] = true;

            System.out.println("Your seat has been reserved!");
        }

        System.out.println("This seat is already occupied!");
    }

    public void vacateSeat(int seat, int row) {
        if (seats[seat][row]) {
            seats[seat][row] = false;

            System.out.println("Your seat has been vacated!");
        }

        System.out.println("This seat is empty!");
    }
}
