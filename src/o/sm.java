// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.InputStream;

// Referenced classes of package o:
//            sl

final class sm
    implements sl._cls02CB
{

    private boolean St;
    private StringBuilder Su;
    private sl Sv;

    sm(sl sl, StringBuilder stringbuilder)
    {
        Sv = sl;
        Su = stringbuilder;
        super();
        St = true;
    }

    public final void read(InputStream inputstream, int i)
    {
        if (St)
        {
            St = false;
        } else
        {
            Su.append(", ");
        }
        Su.append(i);
    }
}
