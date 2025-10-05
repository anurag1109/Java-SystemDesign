package lld2.designPattern.structuralDP.adapter;

public interface BankAPIAdapter {

    double getBalance(String accountNumber);

    boolean sendMoney(String fromAccount,
            String toAccount,
            double amount);
}