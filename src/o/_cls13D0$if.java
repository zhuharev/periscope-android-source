// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.File;

// Referenced classes of package o:
//            _cls13D0, _cls14F6, _cls14F7, _cls14F9

public static class nU
{

    final int nT;
    final _cls14F6 nU;

    public _cls13D0 _mth1EC9()
    {
        File file = nU._mth1F31();
        if (file == null)
        {
            return null;
        }
        if (!file.mkdirs() && (!file.exists() || !file.isDirectory()))
        {
            return null;
        } else
        {
            return _cls14F7._mth02CA(file, nT);
        }
    }

    public le(_cls14F9 _pcls14f9, int i)
    {
        nT = i;
        nU = _pcls14f9;
    }
}
