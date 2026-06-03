package lld2.designPattern.structuralDP.adapter;

import lld2.designPattern.structuralDP.adapter.thirdparty.icicibank.IciciBankAPI;

public class PhonePe {

    public static void main(String[] args) throws InterruptedException {
        // we can create instance of real API and pass it to adapter
        BankAPIAdapter bankAPIAdapter = new ICICIBankAPIAdapter(new IciciBankAPI());
        System.out.println(bankAPIAdapter.getBalance(""));
        // or we can create instance of adapter and inside it create instance of real
        // API
        BankAPIAdapter bankAPIAdapter2 = new YesBankAPIAdapter();
        System.out.println(bankAPIAdapter2.getBalance(""));
    }
}
