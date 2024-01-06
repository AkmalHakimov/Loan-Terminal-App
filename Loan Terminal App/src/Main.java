import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        Shop shop = new Shop();
        System.out.print("Magazin nomini kiriting: ");
        shop.setName(scannerStr.nextLine());


        while (true){
            System.out.println("\n 0-User qo'shish");
            System.out.println("1-Qarz qo'shish");
            System.out.println("2-Qarz to'lash");
            System.out.println("3-Qarzdorlar hisoboti");
            int x = scannerInt.nextInt();
            switch (x){
                case 1:
                    shop.addLoan();
                    break;
                case 2:
                    shop.payLoan();
                    break;
                case 3:
                    shop.reports();
                    break;
                case 0:
                    shop.addUser();
                    break;
                default:
                    System.out.println("Jinniiiiii");
                    break;
            }
        }
    }
}