import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    String phoneNum;
    String firstName;
    List<Loan> loans = new ArrayList<>();

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int calcBalance(){
        int loansBl = 0;
        int loanPaymentBl =0;
        for (Loan loan : loans) {
            loansBl +=loan.getAmount();
            loanPaymentBl += loan.calcLoanPayment();
        }
        return loansBl-loanPaymentBl;
    }

    public void addLoan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qancha miqdorda qarz kiritmoqchisiz?");
        Loan loan = new Loan();
        loan.setLoanDate(LocalDateTime.now());
        loan.setAmount(scanner.nextInt());
        loans.add(loan);
    }

    public void PayLoan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qancha miqdorda qarz to'lamoqchisiz?");
        int x = scanner.nextInt();
        if(x>calcBalance()){
            System.out.println("To'g'ri summa kiriting!");
        }else {
            while(x>0){
                for (Loan loan : loans) {
                    LoanPayment loanPayment = new LoanPayment();
                    if(!loan.isClosed() && loan.calcSaldo()>=x){
                        loanPayment.setPaidAmount(x);
                        loanPayment.setLoanPaymentDate(LocalDateTime.now());
                        loan.loanPayments.add(loanPayment);
                        if(loan.calcSaldo()==0){
                            loan.setClosed(true);
                        }
                        x = 0;
                        return;
                    }else {
                        int s = x - loan.calcSaldo();
                        loanPayment.setPaidAmount(loan.calcSaldo());
                        loanPayment.setLoanPaymentDate(LocalDateTime.now());
                        loan.loanPayments.add(loanPayment);
                        x = s;
                    }
                }
                System.out.println("To'lov to'landi✅");
            }
        }
    }


}
