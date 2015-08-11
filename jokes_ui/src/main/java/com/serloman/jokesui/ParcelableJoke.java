package com.serloman.jokesui;

import android.os.Parcel;
import android.os.Parcelable;

import com.serloman.Joke;


/**
 * Created by Serloman on 11/08/2015.
 */
public class ParcelableJoke implements Parcelable, Joke {
    private String mCategory;
    private String mJoke;

    public ParcelableJoke(String category, String joke){
        this.mCategory = category;
        this.mJoke = joke;
    }

    protected ParcelableJoke(Parcel in) {
        readFromParcel(in);
    }

    @Override
    public String getCategory() {
        return mCategory;
    }

    @Override
    public String getJoke() {
        return mJoke;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mCategory);
        dest.writeString(mJoke);
    }

    private void readFromParcel(Parcel in){
        mCategory = in.readString();
        mJoke = in.readString();
    }

    public static final Creator<ParcelableJoke> CREATOR = new Creator<ParcelableJoke>() {
        @Override
        public ParcelableJoke createFromParcel(Parcel in) {
            return new ParcelableJoke(in);
        }

        @Override
        public ParcelableJoke[] newArray(int size) {
            return new ParcelableJoke[size];
        }
    };

}
