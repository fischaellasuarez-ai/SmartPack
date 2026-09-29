package quarter2.practical_exam.Suarez_practicalexam;


import java.util.Scanner;

public class ArcadeCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new ArcadeCounter().start(scanner);
    }

    public void start(Scanner scanner) {
        buyTokens(scanner);
        claimPrize(scanner);
    }

    // ============ MONEY EXCHANGE TO TOKEN ============
    public void buyTokens(Scanner scanner) {

        System.out.println("###### INSERT YOUR PAYMENT ######");
        System.out.println("Insert Money:");

        int Money = scanner.nextInt();
        System.out.print(Money + " Is now inserted");

        int Token;

        int Tokenconfirmation;

        do {

            System.out.println("###### SELECT YOUR AMOUNT OF TOKEN ######");
            System.out.println("");
            System.out.println("(1) 100 Pesos");
            System.out.println("(2) 200 Pesos");
            System.out.println("(3) 300 Pesos");
            System.out.println("(4) EXIT");
            System.out.print("SELECT A NUMBER: ");

            // Validate that input is an integer
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                return;
            }

            Tokenconfirmation = scanner.nextInt();

            // 100 PESOS
            if (Tokenconfirmation == 1) {

                if (Money < 100) {
                    System.out.println("Insufficient payment.");
                    return;
                }

                int change = Money - 100;

                do {
                    //To clear the display
                    System.out.println("***** ARE YOU SURE? *****");
                    System.out.println("100 PESOS - 50 TOKEN");
                    System.out.println("(1)CONFIRM");
                    System.out.println("(2)GO BACK");
                    System.out.println("(3)EXIT");
                    System.out.print("SELECT A NUMBER:");

                    Token = scanner.nextInt();

                    if (Token == 1) {
                        System.out.println("50 Tokens received!");
                        System.out.println("Change: " + change + " Pesos");
                        System.out.println("Press Enter to continue...");

                        scanner.nextLine();
                        scanner.nextLine();

                        return;
                    }

                    if (Token == 3) {
                        System.out.println("Exit");
                        return;
                    }

                } while (Token != 2);
            }

            // 200 PESOS
            else if (Tokenconfirmation == 2) {

                if (Money < 200) {
                    System.out.println("Insufficient payment.");
                    return;
                }

                int change = Money - 200;

                do {
                    //To clear the display
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("***** ARE YOU SURE? *****");
                    System.out.println("200 PESOS - 100 TOKEN");
                    System.out.println("(1)CONFIRM");
                    System.out.println("(2)GO BACK");
                    System.out.println("(3)EXIT");
                    System.out.print("SELECT A NUMBER:");

                    Token = scanner.nextInt();

                    if (Token == 1) {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();

                        System.out.println("100 Tokens received!");
                        System.out.println("Change: " + change + " Pesos");
                        System.out.println("Press Enter to continue...");

                        scanner.nextLine();
                        scanner.nextLine();

                        return;
                    }

                    if (Token == 3) {
                        System.out.println("Exit");
                        return;
                    }

                } while (Token != 2);
            }

            // 300 PESOS
            else if (Tokenconfirmation == 3) {

                if (Money < 300) {
                    System.out.println("Insufficient payment.");
                    return;
                }

                int change = Money - 300;

                do {

                    System.out.println("***** ARE YOU SURE? *****");
                    System.out.println("");
                    System.out.println("300 PESOS - 150 TOKEN");
                    System.out.println("(1)CONFIRM");
                    System.out.println("(2)GO BACK");
                    System.out.println("(3)EXIT");
                    System.out.print("SELECT A NUMBER:");

                    Token = scanner.nextInt();

                    if (Token == 1) {

                        System.out.println("150 Tokens received!");
                        System.out.println("Change: " + change + " Pesos");
                        System.out.println("Press Enter to continue...");

                        scanner.nextLine();
                        scanner.nextLine();

                        return;
                    }

                    if (Token == 3) {
                        System.out.println("Exit");
                        return;
                    }

                } while (Token != 2);
            } else if (Tokenconfirmation == 4) {
                System.out.println("Exit");
            } else {
                System.out.println("Invalid choice.");
            }

        } while (Tokenconfirmation != 4);

    }

    // ============ TICKET TO PRIZE ============
    public void claimPrize(Scanner scanner) {

        //Insert your ticket amount
        System.out.println("****** INSERT TICKET AMOUNT  ******");
        int Tickets = 0;
        System.out.print("Insert your ticket: " + Tickets);

        Tickets = scanner.nextInt();

        if (Tickets < 500) {
            System.out.println("");
            System.out.println("======You don't have enough ticket, Please keep playing!======");
            System.out.println("");

            return;
        } else {
            System.out.println("");
            System.out.println("");
            System.out.println(" ###### CHOOSE YOUR DESIRED PRIZE.###### ");

        }

        //Where prizes will show.
        System.out.println("");
        System.out.println("****** SELECT YOUR PRIZE ******");
        System.out.println("");
        System.out.println("(1) PLUSHY     - 500 TICKETS");
        System.out.println("(2) TEDDY BEAR - 800 TICKETS");
        System.out.println("(3) RC CAR     - 1000 TICKETS");
        System.out.println("(4) EXIT");
        System.out.print("Choose: ");

        int choice = scanner.nextInt();

        //where the system will choose the prize depending on the users option
        String Prizes = "";

        switch (choice) {

            case 1:
                Prizes = " _________PLUSHY_________";
                break;

            case 2:
                Prizes = " _______TEDDY BEAR_______";
                break;

            case 3:
                Prizes = "__________RC CAR__________";
                break;

            case 4:
                System.out.println("THANK YOU FOR PLAYING!!");
                return;

            default:
                System.out.println();
                System.out.println("Invalid choice.");
                return;
        }

        /*
        calculation of the extra Tickets
        Example:
        1300 tickets and you chosen option num 1 (500 tickets) you'll
        still get the other 800 tickets.
        */

        int TicketAmount = 0;

        switch (choice) {

            case 1:
                TicketAmount = 500;
                break;

            case 2:
                TicketAmount = 800;
                break;

            case 3:
                TicketAmount = 1000;
                break;

            default:
                System.out.println("Invalid choice.");
                return;
        }

        //were the chosen prize will be displayed on
        System.out.println("");
        System.out.println("");
        System.out.println("###### HERE IS YOUR PRIZE######");
        System.out.println(Prizes);

        if (Tickets < TicketAmount) {
            System.out.println("");
            System.out.println("###### PLEASE KEEP PLAYING TO ACHIEVE THIS PRIZE ######");

        } else {

            int TicketChange = Tickets - TicketAmount;

            //where the extra tickets will get displayed.
            System.out.println("");
            System.out.println("###### HERE IS YOUR EXTRA TICKETS ######");
            System.out.println("Ticket Inserted:  " + Tickets);
            System.out.println("Ticket Amount: " + TicketAmount);
            System.out.println("Extra Ticket: " + TicketChange);

            System.out.println("");
            System.out.println("###### HERE IS YOUR PRIZE######");
            System.out.println(Prizes);
        }


    }
}


