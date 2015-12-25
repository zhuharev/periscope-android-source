// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import o.0640;
import o.1428;
import o.1D35;

// Referenced classes of package android.support.v4.app:
//            Fragment

public final class FragmentState
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1D35();
    private Bundle mArguments;
    private int mContainerId;
    private boolean mDetached;
    private int mFragmentId;
    private boolean mFromLayout;
    private int mIndex;
    private boolean mRetainInstance;
    public Bundle mSavedFragmentState;
    private String mTag;
    private String _fld02E4;
    public Fragment _fld03B9;

    public FragmentState(Parcel parcel)
    {
        _fld02E4 = parcel.readString();
        mIndex = parcel.readInt();
        boolean flag;
        if (parcel.readInt() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mFromLayout = flag;
        mFragmentId = parcel.readInt();
        mContainerId = parcel.readInt();
        mTag = parcel.readString();
        if (parcel.readInt() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mRetainInstance = flag;
        if (parcel.readInt() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mDetached = flag;
        mArguments = parcel.readBundle();
        mSavedFragmentState = parcel.readBundle();
    }

    public FragmentState(Fragment fragment)
    {
        _fld02E4 = fragment.getClass().getName();
        mIndex = fragment.mIndex;
        mFromLayout = fragment.mFromLayout;
        mFragmentId = fragment.mFragmentId;
        mContainerId = fragment.mContainerId;
        mTag = fragment.mTag;
        mRetainInstance = fragment.mRetainInstance;
        mDetached = fragment.mDetached;
        mArguments = fragment.mArguments;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(_fld02E4);
        parcel.writeInt(mIndex);
        if (mFromLayout)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeInt(mFragmentId);
        parcel.writeInt(mContainerId);
        parcel.writeString(mTag);
        if (mRetainInstance)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (mDetached)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeBundle(mArguments);
        parcel.writeBundle(mSavedFragmentState);
    }

    public final Fragment _mth02CA(_cls0640 _pcls0640, Fragment fragment)
    {
        if (_fld03B9 != null)
        {
            return _fld03B9;
        }
        Context context = _pcls0640.mContext;
        if (mArguments != null)
        {
            mArguments.setClassLoader(context.getClassLoader());
        }
        _fld03B9 = Fragment.instantiate(context, _fld02E4, mArguments);
        if (mSavedFragmentState != null)
        {
            mSavedFragmentState.setClassLoader(context.getClassLoader());
            _fld03B9.mSavedFragmentState = mSavedFragmentState;
        }
        _fld03B9.setIndex(mIndex, fragment);
        _fld03B9.mFromLayout = mFromLayout;
        _fld03B9.mRestored = true;
        _fld03B9.mFragmentId = mFragmentId;
        _fld03B9.mContainerId = mContainerId;
        _fld03B9.mTag = mTag;
        _fld03B9.mRetainInstance = mRetainInstance;
        _fld03B9.mDetached = mDetached;
        _fld03B9.mFragmentManager = _pcls0640.mFragmentManager;
        boolean flag = _cls1428.DEBUG;
        return _fld03B9;
    }

}
