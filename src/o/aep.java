// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.HashSet;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            acy, aed, xx, auf, 
//            zp, aqf

final class aep extends acy
{

    private aed bhH;

    aep(aed aed1, aed aed2, ApiManager apimanager, zp zp, aqf aqf)
    {
        bhH = aed1;
        super(aed2, apimanager, zp, aqf);
    }

    public final void _mth02CA(String s, String s1, String s2, String s3, auf auf1)
    {
        if (!aed._mth1FBE(bhH))
        {
            return;
        }
        aed._mth1428(bhH).block(s, aed._mth1427(bhH), aed._mth02BE(bhH).aUj, auf1);
        if (auf1 != null && auf1.eI() != null)
        {
            aed._mth02CA(bhH, s, s1, auf1.eI());
            if (auf1._mth1F35() != null)
            {
                aed.FE73(bhH).add(auf1._mth1F35());
            }
        }
    }
}
