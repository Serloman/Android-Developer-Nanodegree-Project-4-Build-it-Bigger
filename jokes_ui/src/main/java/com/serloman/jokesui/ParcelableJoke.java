package com.serloman.jokesui;

import android.os.Parcel;
import android.os.Parcelable;

import com.serloman.models.Joke;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Serloman on 11/08/2015.
 */
public class ParcelableJoke implements Parcelable, Joke {

    private int mId;
    private String mJoke;
    private List<String> mCategories;

    public ParcelableJoke(Joke joke){
        this(joke.getId(), joke.getJoke(), joke.getCategories());
    }

    public ParcelableJoke(int id, String joke, List<String> categories){
        this.mId = id;
        this.mJoke = joke;
        this.mCategories = categories;
    }

    protected ParcelableJoke(Parcel in) {
        readFromParcel(in);
    }


    @Override
    public int getId() {
        return mId;
    }

    @Override
    public String getJoke() {
        return mJoke;
    }

    @Override
    public List<String> getCategories() {
        return mCategories;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mJoke);
        dest.writeList(mCategories);
    }

    private void readFromParcel(Parcel in){
        mId = in.readInt();
        mJoke = in.readString();
        mCategories = new ArrayList<>();
        in.readStringList(mCategories);
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
