// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import o.037A;
import o.141D;
import o.1428;

// Referenced classes of package android.support.v4.app:
//            Fragment

public final class BackStackState
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls037A();
    private int mIndex;
    private String mName;
    private int _fld02BE;
    private int _fld02CC;
    private CharSequence _fld02CD;
    private int _fld02D1;
    private CharSequence _fld0640;
    private ArrayList _fld1427;
    private ArrayList _fld1428;
    private int _fld1540[];
    private int _fld1FBE;

    public BackStackState(Parcel parcel)
    {
        _fld1540 = parcel.createIntArray();
        _fld1FBE = parcel.readInt();
        _fld02BE = parcel.readInt();
        mName = parcel.readString();
        mIndex = parcel.readInt();
        _fld02CC = parcel.readInt();
        _fld02CD = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        _fld02D1 = parcel.readInt();
        _fld0640 = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        _fld1427 = parcel.createStringArrayList();
        _fld1428 = parcel.createStringArrayList();
    }

    public BackStackState(_cls141D _pcls141d)
    {
        int i = 0;
        for (o._cls141D.if if1 = _pcls141d._fld02BC; if1 != null;)
        {
            int j = i;
            if (if1._fld02E1 != null)
            {
                j = i + if1._fld02E1.size();
            }
            if1 = if1._fld2071;
            i = j;
        }

        _fld1540 = new int[_pcls141d._fld037A * 7 + i];
        if (!_pcls141d._fld02BF)
        {
            throw new IllegalStateException("Not on back stack");
        }
        o._cls141D.if if2 = _pcls141d._fld02BC;
        i = 0;
        for (; if2 != null; if2 = if2._fld2071)
        {
            int ai[] = _fld1540;
            int k = i + 1;
            ai[i] = if2.FE7A;
            ai = _fld1540;
            int l = k + 1;
            if (if2.FF70 != null)
            {
                i = if2.FF70.mIndex;
            } else
            {
                i = -1;
            }
            ai[k] = i;
            ai = _fld1540;
            i = l + 1;
            ai[l] = if2._fld02B3;
            ai = _fld1540;
            k = i + 1;
            ai[i] = if2._fld02B4;
            ai = _fld1540;
            i = k + 1;
            ai[k] = if2._fld02C6;
            ai = _fld1540;
            k = i + 1;
            ai[i] = if2._fld02C7;
            if (if2._fld02E1 != null)
            {
                int j1 = if2._fld02E1.size();
                int ai1[] = _fld1540;
                i = k + 1;
                ai1[k] = j1;
                for (k = 0; k < j1;)
                {
                    int ai2[] = _fld1540;
                    int i1 = i + 1;
                    ai2[i] = ((Fragment)if2._fld02E1.get(k)).mIndex;
                    k++;
                    i = i1;
                }

            } else
            {
                int ai3[] = _fld1540;
                i = k + 1;
                ai3[k] = 0;
            }
        }

        _fld1FBE = _pcls141d._fld1FBE;
        _fld02BE = _pcls141d._fld02BE;
        mName = _pcls141d.mName;
        mIndex = _pcls141d.mIndex;
        _fld02CC = _pcls141d._fld02CC;
        _fld02CD = _pcls141d._fld02CD;
        _fld02D1 = _pcls141d._fld02D1;
        _fld0640 = _pcls141d._fld0640;
        _fld1427 = _pcls141d._fld1427;
        _fld1428 = _pcls141d._fld1428;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeIntArray(_fld1540);
        parcel.writeInt(_fld1FBE);
        parcel.writeInt(_fld02BE);
        parcel.writeString(mName);
        parcel.writeInt(mIndex);
        parcel.writeInt(_fld02CC);
        TextUtils.writeToParcel(_fld02CD, parcel, 0);
        parcel.writeInt(_fld02D1);
        TextUtils.writeToParcel(_fld0640, parcel, 0);
        parcel.writeStringList(_fld1427);
        parcel.writeStringList(_fld1428);
    }

    public final _cls141D _mth02CA(_cls1428 _pcls1428)
    {
        _cls141D _lcls141d = new _cls141D(_pcls1428);
        o._cls141D.if if1;
label0:
        for (int i = 0; i < _fld1540.length; _lcls141d._mth02CA(if1))
        {
            if1 = new o._cls141D.if();
            int ai[] = _fld1540;
            int j = i + 1;
            if1.FE7A = ai[i];
            boolean flag = _cls1428.DEBUG;
            ai = _fld1540;
            i = j + 1;
            j = ai[j];
            if (j >= 0)
            {
                if1.FF70 = (Fragment)_pcls1428._fld1D40.get(j);
            } else
            {
                if1.FF70 = null;
            }
            ai = _fld1540;
            j = i + 1;
            if1._fld02B3 = ai[i];
            ai = _fld1540;
            i = j + 1;
            if1._fld02B4 = ai[j];
            ai = _fld1540;
            j = i + 1;
            if1._fld02C6 = ai[i];
            ai = _fld1540;
            i = j + 1;
            if1._fld02C7 = ai[j];
            ai = _fld1540;
            int k = i + 1;
            int i1 = ai[i];
            i = k;
            if (i1 <= 0)
            {
                continue;
            }
            if1._fld02E1 = new ArrayList(i1);
            j = 0;
            i = k;
            do
            {
                int l = i;
                i = l;
                if (j >= i1)
                {
                    continue label0;
                }
                boolean flag1 = _cls1428.DEBUG;
                Object obj = _pcls1428._fld1D40;
                int ai1[] = _fld1540;
                i = l + 1;
                obj = (Fragment)((ArrayList) (obj)).get(ai1[l]);
                if1._fld02E1.add(obj);
                j++;
            } while (true);
        }

        _lcls141d._fld1FBE = _fld1FBE;
        _lcls141d._fld02BE = _fld02BE;
        _lcls141d.mName = mName;
        _lcls141d.mIndex = mIndex;
        _lcls141d._fld02BF = true;
        _lcls141d._fld02CC = _fld02CC;
        _lcls141d._fld02CD = _fld02CD;
        _lcls141d._fld02D1 = _fld02D1;
        _lcls141d._fld0640 = _fld0640;
        _lcls141d._fld1427 = _fld1427;
        _lcls141d._fld1428 = _fld1428;
        _lcls141d._mth02CA(1);
        return _lcls141d;
    }

}
