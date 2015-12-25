// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Map;

// Referenced classes of package o:
//            ne, mw, gj

final class nh
    implements er._cls02CB
{

    private ne KW;

    nh(ne ne1)
    {
        KW = ne1;
        super();
    }

    public final boolean _mth02CA(gj gj)
    {
        if (ne._mth02CE(KW) != null)
        {
            ne._mth02CE(KW)._mth02CA((mw)ne._mth02CF(KW).get(gj));
            return true;
        } else
        {
            return false;
        }
    }
}
