package Models;

public class Wagon {
    public boolean[][] seats;

    public Wagon(int seatRowCount) {
        this.seats = new boolean[2][seatRowCount];
    }

    public void reserveSeat(int seat, int row) {
        if (!seats[seat][row]) {
            seats[seat][row] = true;

            System.out.println("Vaše místo bylo rezervováno!\n");
            return;
        }

        System.out.println("Tohle místo je už obsazené!\n");
    }

    public void vacateSeat(int seat, int row) {
        if (seats[seat][row]) {
            seats[seat][row] = false;

            System.out.println("Vaše rezervace místa byla zrušena!\n");
            return;
        }

        System.out.println("Tohle místo je prázdé!\n");
    }
}
