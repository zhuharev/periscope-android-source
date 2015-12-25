// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;


// Referenced classes of package org.spongycastle.crypto.params:
//            DESParameters

public class DESedeParameters extends DESParameters
{

    public static boolean FE73(byte abyte0[], int i, int j)
    {
        for (i = 0; i < j; i += 8)
        {
            if (DESParameters._mth1428(abyte0, i))
            {
                return true;
            }
        }

        return false;
    }
}
