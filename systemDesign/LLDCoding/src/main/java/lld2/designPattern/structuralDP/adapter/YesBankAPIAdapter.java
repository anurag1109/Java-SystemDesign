package lld2.designPattern.structuralDP.adapter;

import lld2.designPattern.structuralDP.adapter.thirdparty.yesbank.YesBankAPI;

public class YesBankAPIAdapter implements BankAPIAdapter {
    private YesBankAPI yesBankAPI = new YesBankAPI();

    @Override
    public double getBalance(String accountNumber) {
        return yesBankAPI.getBalance(accountNumber, accountNumber);
    }

    @Override
    public boolean sendMoney(String fromAccount, String toAccount, double amount) {
        return false;
    }
}
