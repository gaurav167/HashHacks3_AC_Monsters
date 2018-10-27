package ModelClass;

import android.os.Parcel;
import android.os.Parcelable;

public class Transaction  {
    public String recieverName, recieverLocation;
    public double amount;
    //    Withdrawal, Transfer, Deposit
    public String typeOfTransact;
    public String senderLocation;
    public String timeFormat;
    public String cardType;
    public String currency;
    public String amountRange;

    public Transaction() {

        this.cardType = "debit";
        this.amount = 3000.00;
        if(amount>5000.00){
            amountRange="High";
        }else{
            amountRange="Low";
        }

        this.currency = "INR";
        this.senderLocation = "Patna";
        this.recieverName = "Nicole Barajas";
        this.recieverLocation = "Washington";
        this.typeOfTransact = "transfer";
        this.timeFormat = "27/10/18 10:30";

    }
}