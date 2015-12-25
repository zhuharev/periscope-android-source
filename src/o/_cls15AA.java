// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.common.stats.ConnectionEvent;

public final class _cls15AA
    implements android.os.Parcelable.Creator
{

    public _cls15AA()
    {
    }

    public static void _mth02CA(ConnectionEvent connectionevent, Parcel parcel)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int i = parcel.dataPosition();
        int j = connectionevent.wB;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(j);
        long l = connectionevent.yF;
        _cls141D.if._mth02CB(parcel, 2, 8);
        parcel.writeLong(l);
        _cls141D.if._mth02CA(parcel, 4, connectionevent.yH, false);
        _cls141D.if._mth02CA(parcel, 5, connectionevent.yI, false);
        _cls141D.if._mth02CA(parcel, 6, connectionevent.yJ, false);
        _cls141D.if._mth02CA(parcel, 7, connectionevent.yK, false);
        _cls141D.if._mth02CA(parcel, 8, connectionevent.yL, false);
        l = connectionevent.yN;
        _cls141D.if._mth02CB(parcel, 10, 8);
        parcel.writeLong(l);
        l = connectionevent.yO;
        _cls141D.if._mth02CB(parcel, 11, 8);
        parcel.writeLong(l);
        j = connectionevent.yG;
        _cls141D.if._mth02CB(parcel, 12, 4);
        parcel.writeInt(j);
        _cls141D.if._mth02CA(parcel, 13, connectionevent.yM, false);
        _cls141D.if._mth141D(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int k = _cls141D.if._mth02CA(parcel);
        int j = 0;
        long l3 = 0L;
        int i = 0;
        String s5 = null;
        String s4 = null;
        String s3 = null;
        String s2 = null;
        String s1 = null;
        String s = null;
        long l2 = 0L;
        long l1 = 0L;
        do
        {
            if (parcel.dataPosition() >= k)
            {
                break;
            }
            int l = parcel.readInt();
            switch (l & 0xffff)
            {
            case 1: // '\001'
                _cls141D.if._mth02CA(parcel, l, 4);
                j = parcel.readInt();
                break;

            case 2: // '\002'
                _cls141D.if._mth02CA(parcel, l, 8);
                l3 = parcel.readLong();
                break;

            case 4: // '\004'
                s5 = _cls141D.if._mth02CB(parcel, l);
                break;

            case 5: // '\005'
                s4 = _cls141D.if._mth02CB(parcel, l);
                break;

            case 6: // '\006'
                s3 = _cls141D.if._mth02CB(parcel, l);
                break;

            case 7: // '\007'
                s2 = _cls141D.if._mth02CB(parcel, l);
                break;

            case 8: // '\b'
                s1 = _cls141D.if._mth02CB(parcel, l);
                break;

            case 10: // '\n'
                _cls141D.if._mth02CA(parcel, l, 8);
                l2 = parcel.readLong();
                break;

            case 11: // '\013'
                _cls141D.if._mth02CA(parcel, l, 8);
                l1 = parcel.readLong();
                break;

            case 12: // '\f'
                _cls141D.if._mth02CA(parcel, l, 4);
                i = parcel.readInt();
                break;

            case 13: // '\r'
                s = _cls141D.if._mth02CB(parcel, l);
                break;

            case 3: // '\003'
            case 9: // '\t'
            default:
                _cls141D.if._mth02CA(parcel, l);
                break;
            }
        } while (true);
        if (parcel.dataPosition() != k)
        {
            throw new android.support.v4.app.Fragment.if((new StringBuilder("Overread allowed size end=")).append(k).toString(), parcel);
        } else
        {
            return new ConnectionEvent(j, l3, i, s5, s4, s3, s2, s1, s, l2, l1);
        }
    }

    public final Object[] newArray(int i)
    {
        return new ConnectionEvent[i];
    }
}
