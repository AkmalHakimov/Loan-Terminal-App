import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {
    String name;
    List<User> users = new ArrayList<>();

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void addUser() {
        Scanner scannerStr = new Scanner(System.in);
        User user = new User();
        System.out.println("Ismingizni kiriting");
        user.setFirstName(scannerStr.nextLine());
        boolean isTrue = false;
        while(isTrue == false){
            System.out.println("Nomeringizni quyidagi ko'rinishda kiriting=>(+998********): ");
            String enteredPh = scannerStr.nextLine();
            if(enteredPh.startsWith("+998")){
                user.setPhoneNum(enteredPh);
                isTrue = true;
            }else {
                System.out.println("Noto'g'ri malumot kiritdingiz!");
            }
        }
        users.add(user);
        System.out.println("User qo'shildi✅");
    }

    public void addLoan() {
        Scanner scanner = new Scanner(System.in);
        if(users.size()==0){
            System.out.println("Birinchi user kiriting!");
            return;
        }
        System.out.println("Qaysi userga qarz qo'shmoqchisiz?");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i+1) + ". " + users.get(i).getFirstName());
        }
        users.get(scanner.nextInt()-1).addLoan();
        System.out.println("Qarz qo'shildi✅");
    }

    public void payLoan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qaysi userga qarz to'lamoqchisiz?");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i+1) + ". " + users.get(i).getFirstName());
        }
        users.get(scanner.nextInt()-1).PayLoan();
    }

    public void reports() {
        int s = 0;
        for (User user : users) {
            s +=user.calcBalance();
        }
        System.out.println("Umumiy qarzlar: " + s);
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).loans.size()!=0){
                User user = users.get(i);
                System.out.println(" \n ||" + (i+1) + ". Name: " + user.getFirstName() + " \n Phone Number: " + user.getPhoneNum() + " \n Qarzi: " + user.calcBalance());
                System.out.println("Qarzlar hisoboti: ");
                for (int k = 0; k < user.loans.size(); k++) {
                    System.out.print(" \n ||" + "Qarz Olgan kunlari: ");
                    System.out.println("Sana: " + user.loans.get(k).getLoanDate() + " Summa: " + user.loans.get(k).getAmount());
                    for (int t = 0; t < user.loans.get(k).loanPayments.size(); t++) {
                        LoanPayment loanPayment = user.loans.get(k).loanPayments.get(t);
                        System.out.println(" \n ||" + "Qarz bergan kunlari: ");
                        System.out.print("Sana: " + loanPayment.getLoanPaymentDate() + ". Summa: " +loanPayment.getPaidAmount());
                    }
                }
            }
        }
    }


}
