// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public final class hg
    implements android.os.Parcelable.Creator
{

    public hg()
    {
    }

    public static void _mth02CA(StreetViewPanoramaOrientation streetviewpanoramaorientation, Parcel parcel)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int i = parcel.dataPosition();
        int j = streetviewpanoramaorientation.wB;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(j);
        float f = streetviewpanoramaorientation.EM;
        _cls141D.if._mth02CB(parcel, 2, 4);
        parcel.writeFloat(f);
        f = streetviewpanoramaorientation.EN;
        _cls141D.if._mth02CB(parcel, 3, 4);
        parcel.writeFloat(f);
        _cls141D.if._mth141D(parcel, i);
    }

    public static StreetViewPanoramaOrientation _mth1427(Parcel parcel)
    {
        int j = _cls141D.if._mth02CA(parcel);
        int i = 0;
        float f1 = 0.0F;
        float f = 0.0F;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = parcel.readInt();
                switch (k & 0xffff)
                {
                case 1: // '\001'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    i = parcel.readInt();
                    break;

                case 2: // '\002'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    f1 = parcel.readFloat();
                    break;

                case 3: // '\003'
                    _cls141D.if._mth02CA(parcel, k, 4);
                    f = parcel.readFloat();
                    break;

                default:
                    _cls141D.if._mth02CA(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new android.support.v4.app.Fragment.if((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new StreetViewPanoramaOrientation(i, f1, f);
            }
        } while (true);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return _mth1427(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new StreetViewPanoramaOrientation[i];
    }
}
