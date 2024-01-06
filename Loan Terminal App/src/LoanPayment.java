import java.time.LocalDateTime;

public class LoanPayment {
    int paidAmount = 0;
    LocalDateTime loanPaymentDate;

    public int getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }

    public LocalDateTime getLoanPaymentDate() {
        return loanPaymentDate;
    }

    public void setLoanPaymentDate(LocalDateTime loanPaymentDate) {
        this.loanPaymentDate = loanPaymentDate;
    }
}
