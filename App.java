import Models.Train;

import java.util.Scanner;

public class App {
    private Scanner scanner = new Scanner(System.in);
    private Train train;

    public void start() {
        System.out.println("APLIKACE PRO REZERVACI MÍST VE VLAKU\n");
        System.out.print("Kolik vagónů bude vlak mít? ");
        int wagonCount = this.scanner.nextInt();

        this.train = new Train(wagonCount);
        System.out.println("Vlak vytvořen!\n");
        getUI();
    }

    public void getUI() {
        while (true) {
            System.out.println("Co si přejete udělat?\n");
            System.out.println("1 - Přidat vagón");
            System.out.println("2 - Odebrat vagón");
            System.out.println("3 - Rezervovat místo");
            System.out.println("4 - Uvolnit rezervované místo");
            System.out.println("5 - Zobrazit aktuální obsazenost vlaku");
            int answer = this.scanner.nextInt();
            if (answer < 1 || answer > 5) {
                System.out.println("Vyberte validní možnost v rozsahu 1 - 5");
            }

            switch (answer) {
                case 1: {
                    this.train.addWagon();
                    break;
                }

                case 2: {
                    this.train.removeWagon();
                    break;
                }

                case 3: {
                    this.train.reserveSeat();
                    break;
                }

                case 4: {
                    this.train.vacateSeat();
                    break;
                }

                case 5: {
                    this.train.printWagons();
                    break;
                }
            }
        }
    }
}
