package edu.daffodil.cdc.helper;

import android.os.Parcel;
import android.os.Parcelable;

public class ChildExpandable implements Parcelable {
    public final String name;

    public String getName() {
        return name;
    }

    public ChildExpandable(String name) {
        this.name = name;
    }

    protected ChildExpandable(Parcel in) {
        name = in.readString();
    }

    public static final Creator<ChildExpandable> CREATOR = new Creator<ChildExpandable>() {
        @Override
        public ChildExpandable createFromParcel(Parcel in) {
            return new ChildExpandable(in);
        }

        @Override
        public ChildExpandable[] newArray(int size) {
            return new ChildExpandable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);

    }
}
