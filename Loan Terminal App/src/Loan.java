import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Loan {
    int amount = 0;
    List<LoanPayment> loanPayments = new ArrayList<>();
    boolean closed = false;
    LocalDateTime loanDate;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDateTime loanDate) {
        this.loanDate = loanDate;
    }

    public int calcLoanPayment() {
        int s = 0;
        for (LoanPayment loanPayment : loanPayments) {
            s+=loanPayment.getPaidAmount();
        }
        return s;
    }

    public int calcSaldo(){
        int s = 0;
        for (LoanPayment loanPayment : loanPayments) {
            s += loanPayment.getPaidAmount();
        }
        return this.amount-s;
    }
}
