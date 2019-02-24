package com.nayanatech.nayanarestaurant.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class SubItemDemo implements Parcelable {
    public final String name;
    public final String itemPrice;

    public SubItemDemo(String name, String itemPrice) {
        this.name = name;
        this.itemPrice = itemPrice;
    }

    protected SubItemDemo(Parcel in) {
        name = in.readString();
        itemPrice = in.readString();
    }

    public static final Creator<SubItemDemo> CREATOR = new Creator<SubItemDemo>() {
        @Override
        public SubItemDemo createFromParcel(Parcel in) {
            return new SubItemDemo(in);
        }

        @Override
        public SubItemDemo[] newArray(int size) {
            return new SubItemDemo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(itemPrice);

    }
}
