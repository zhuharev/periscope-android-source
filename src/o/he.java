// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.maps.model.StreetViewPanoramaLink;

public final class he
    implements android.os.Parcelable.Creator
{

    public he()
    {
    }

    public static void _mth02CA(StreetViewPanoramaLink streetviewpanoramalink, Parcel parcel)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int i = parcel.dataPosition();
        int j = streetviewpanoramalink.wB;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(j);
        _cls141D.if._mth02CA(parcel, 2, streetviewpanoramalink.Fy, false);
        float f = streetviewpanoramalink.EN;
        _cls141D.if._mth02CB(parcel, 3, 4);
        parcel.writeFloat(f);
        _cls141D.if._mth141D(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int j = _cls141D.if._mth02CA(parcel);
        int i = 0;
        String s = null;
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
                    s = _cls141D.if._mth02CB(parcel, k);
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
                return new StreetViewPanoramaLink(i, s, f);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new StreetViewPanoramaLink[i];
    }
}
