package Models;

import java.util.Scanner;

public class Train {
    private Wagon[] wagons;
    private final int WAGON_COUNT;

    private Scanner scanner = new Scanner(System.in);

    public Train(int wagonCount) {
        this.WAGON_COUNT = wagonCount;
        this.wagons = new Wagon[this.WAGON_COUNT];
    }

    public void addWagon() {
        System.out.print("Kolik řad sedadel bude mít vagón? ");
        int seatRowCount = this.scanner.nextInt();

        Wagon wagon = new Wagon(seatRowCount);
        for (int i = 0; i < wagons.length; i++) {
            if (wagons[i] == null) {
                wagons[i] = wagon;
                return;
            }
        }
        System.out.println("Více vagónů nemůžete přidat!\n");
    }

    public void removeWagon() {
        System.out.print("Zadejte číslo vagonu, který chcete odstranit: ");
        int wagonNum = this.scanner.nextInt();

        if (wagons[wagonNum] == null) {
            System.out.println("Nemůžete odstranit neexistující vagón!\n");

            return;
        }
        wagons[wagonNum] = null;
        System.out.println("Vagón odstraněn!\n");
    }

    public void printWagons() {
        int counter = 0;
        for (Wagon wagon : wagons) {
            if (wagon != null) {
                System.out.println("Vagón číslo " + counter);
                for (boolean[] row : wagon.seats) {
                    for (boolean seat : row) {
                        if (!seat) {
                            System.out.print(" _ ");
                        }
                        if (seat) {
                            System.out.print(" X ");
                        }
                    }
                    System.out.println("");
                }
                System.out.println("Počet volných míst ve vagonu: " + this.getEmptySpaceCount(counter));
                System.out.println("");
                counter++;
            }
        }
    }

    public void reserveSeat() {
        System.out.print("Zadejte číslo vagonu, ve kterém chcete rezervovat místo: ");
        int wagonNum = this.scanner.nextInt();
        this.validateWagonNum(wagonNum);

        System.out.print("Zadejte číslo řady, ve které chcete sedět: ");
        int rowNum = this.scanner.nextInt();
        this.validateRowNum(rowNum);

        System.out.print("Zadejte číslo sedadla, ve kterém chcete sedět: ");
        int seatNum = this.scanner.nextInt();

        wagons[wagonNum].reserveSeat(seatNum, rowNum);
    }

    public void vacateSeat() {
        System.out.print("Zadejte číslo vagonu, ve kterém chcete uvolnit rezervované místo: ");
        int wagonNum = this.scanner.nextInt();
        this.validateWagonNum(wagonNum);

        System.out.print("Zadejte číslo řady: ");
        int rowNum = this.scanner.nextInt();
        this.validateRowNum(rowNum);


        System.out.print("Zadejte číslo sedadla: ");
        int seatNum = this.scanner.nextInt();

        wagons[wagonNum].vacateSeat(seatNum, rowNum);
    }


    public int getEmptySpaceCount(int wagonNum) {
        int emptySpaceCounter = 0;

        if (wagons[wagonNum] != null) {
            for (boolean[] row : wagons[wagonNum].seats) {
                for (boolean seat : row) {
                    if (!seat) {
                        emptySpaceCounter++;
                    }
                }
            }
        }

        return emptySpaceCounter;
    }

    public void validateWagonNum(int wagonNum) {
        if (wagonNum > this.wagons.length || wagonNum < 0) {
            System.out.println("Zadejte validní číslo vagonu!");

            return;
        }
    }

    public void validateRowNum(int rowNum) {
        if (rowNum < 0 || rowNum > 1) {
            System.out.println("Zadejte validní číslo řady!");

            return;
        }
    }
}