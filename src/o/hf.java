// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaLink;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

public final class hf
    implements android.os.Parcelable.Creator
{

    public hf()
    {
    }

    public static void _mth02CA(StreetViewPanoramaLocation streetviewpanoramalocation, Parcel parcel, int i)
    {
        parcel.writeInt(-45243);
        parcel.writeInt(0);
        int j = parcel.dataPosition();
        int k = streetviewpanoramalocation.wB;
        _cls141D.if._mth02CB(parcel, 1, 4);
        parcel.writeInt(k);
        _cls141D.if._mth02CA(parcel, 2, streetviewpanoramalocation.Fz, i, false);
        _cls141D.if._mth02CA(parcel, 3, streetviewpanoramalocation.FA, i, false);
        _cls141D.if._mth02CA(parcel, 4, streetviewpanoramalocation.Fy, false);
        _cls141D.if._mth141D(parcel, j);
    }

    public static StreetViewPanoramaLocation _mth0640(Parcel parcel)
    {
        int j = _cls141D.if._mth02CA(parcel);
        int i = 0;
        StreetViewPanoramaLink astreetviewpanoramalink[] = null;
        LatLng latlng = null;
        String s = null;
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
                    astreetviewpanoramalink = (StreetViewPanoramaLink[])_cls141D.if._mth02CB(parcel, k, StreetViewPanoramaLink.CREATOR);
                    break;

                case 3: // '\003'
                    latlng = (LatLng)_cls141D.if._mth02CA(parcel, k, LatLng.CREATOR);
                    break;

                case 4: // '\004'
                    s = _cls141D.if._mth02CB(parcel, k);
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
                return new StreetViewPanoramaLocation(i, astreetviewpanoramalink, latlng, s);
            }
        } while (true);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return _mth0640(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new StreetViewPanoramaLocation[i];
    }
}
