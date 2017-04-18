package com.google.firebase.udacity.receiptapp;

/**
 * Created by helen on 4/13/17.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Created by helen on 4/9/17.
 * Receipt class encapsulates a scanned paper receipt
 * received through the OCR reader. Constructor takes
 * in four default values, all required in order to
 * Based on Firebase tutorial documentation
 * to ensure that the receipt object can be
 * safely stored in Firebase database.
 */

class Receipt {

    public String mDate;
    public String mStore;
    public String mAddr;
    public Double mAmount;

    public Receipt() {
        // Default constructor required for calls to DataSnapshot.getValue(Receipt.class);
    }

    /**
     * Class constructor calls the default with a not-available "na"
     * value for the store address, as this value may not be
     * available on a receipt.
     * @param date    Date of purchase
     * @param store   Store name
     * @param amount  Amount of money spent
     */
    public Receipt(String date, String store, Double amount) {
        this(date, store, "na", amount);
    }

    /**
     * Class constructor sets all possible variables
     * @param date    Date of purchase
     * @param store   Store name
     * @param addr    Store address
     * @param amount  Amount of money spent
     */
    public Receipt(String date, String store, String addr, Double amount) {
        this.mDate = date;
        this.mStore = store;
        this.mAddr = addr;
        this.mAmount = amount;
    }

    /**
     * Returns a hashmap version of the receipt object
     * this method is called on. Method implemented to
     * allow synchronization with Firebase.
     * @return hashmap of this receipt object
     */
    public Map<String, Object> toMap() {
        HashMap<String, Object> ret = new HashMap<>();
        ret.put("date", mDate);
        ret.put("store", mStore);
        ret.put("addr", mAddr);
        ret.put("amount", mAmount);
        return ret;
    }
}