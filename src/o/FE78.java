// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls02B5, FE7E

public class FE78
{
    /* member class not found */
    class if {}


    public FE78()
    {
    }

    public static android.os.Parcelable.Creator _mth02CA(FE7E fe7e)
    {
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            return _cls02B5._mth02CB(fe7e);
        } else
        {
            return new if(fe7e);
        }
    }
}
