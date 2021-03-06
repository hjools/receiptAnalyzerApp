package com.google.firebase.udacity.receiptapp.shared;

import java.io.IOException;
import java.io.Serializable;
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

public class Receipt implements Serializable {

    private static final String TAG = "Receipt";

    private String mDate;
    private String mStore;
    private String mAddr;
    private Double mAmount;
    private Double mLongitude;
    private Double mLatitude;


    /**
     * Default class constructor is required in order to enable
     * serialization back from Object to Receipt when retrieving
     * data from Firebase realtime database
     */
    public Receipt() {}

    /**
     * Class constructor calls the default with a not-available "na"
     * value for the store address, as this value may not be
     * available on a receipt.
     * @param date    Date of purchase
     * @param store   Store name
     * @param amount  Amount of money spent
     */
    public Receipt(String date, String store, Double amount, Double longitude, Double latitude) throws IOException {
        this(date, store, "na", amount, longitude, latitude);
    }

    /**
     * Class constructor sets all possible variables
     * @param date    Date of purchase
     * @param store   Store name
     * @param addr    Store address
     * @param amount  Amount of money spent
     */
    public Receipt(String date, String store, String addr, Double amount, Double longitude, Double latitude) throws IOException {
        this.mDate = date;
        this.mStore = store;
        this.mAddr = addr;
        this.mAmount = amount;
        this.mLongitude = longitude;
        this.mLatitude = latitude;
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
        ret.put("longitude", mLongitude);
        ret.put("latitude", mLatitude);
        return ret;
    }

    /**
     * getter method enables serialization from Receipt to Object
     * to store in Firebase realtime database
     * @return store of purchase
     */
    public String getStore() {
        return mStore;
    }

    /**
     * getter method enables serialization from Receipt to Object
     * to store in Firebase realtime database
     * @return date of purchase
     */
    public String getDate() {
        return mDate;
    }

    /**
     * getter method enables serialization from Receipt to Object
     * to store in Firebase realtime database
     * @return total of purchase
     */
    public Double getAmount() {
        return mAmount;
    }

    /**
     * getter method enables serialization from Receipt to Object
     * to store in Firebase realtime database
     * @return return address of store of purchase
     */
    public String getAddr() { return mAddr; }

    /**
     * getter method enables serialization from Receipt to Object
     * to store in Firebase realtime database
     * @return longitude of location captured
     */
    public Double getLongitude() { return mLongitude; }

    /**
     * getter method enables serialization from Receipt to Object
     * to store in Firebase realtime database
     * @return latitude of location captured
     */
    public Double getLatitude() { return mLatitude; }

    /**
     * setter method enables serialization from Object to Receipt
     * when retrieved from Firebase realtime database
     * @param store  String store name
     */
    public void setStore(String store) { this.mStore = store; }

    /**
     * setter method enables serialization from Object to Receipt
     * when retrieved from Firebase realtime database
     * @param date   String date of purchase
     */
    public void setDate(String date) { this.mDate = date; }

    /**
     * setter method enables serialization from Object to Receipt
     * when retrieved from Firebase realtime database
     * @param amt    Double total amount spent
     */
    public void setAmount(Double amt) { this.mAmount = amt; }

    /**
     * setter method enables serialization from Object to Receipt
     * when retrieved from Firebase realtime database
     * @param addr   String address of store
     */
    public void setAddr(String addr) { this.mAddr = addr; }

    /**
     * setter method enables serialization from Object to Receipt
     * when retrieved from Firebase realtime database
     * @param longitude  Double longitude of location
     */
    public void setLongitude(Double longitude) { this.mLongitude = longitude; }

    /**
     * setter method enables serialization from Object to Receipt
     * when retrieved from Firebase realtime database
     * @param latitude   Double latitude of location
     */
    public void setLatitude(Double latitude) { this.mLatitude = latitude; }
}