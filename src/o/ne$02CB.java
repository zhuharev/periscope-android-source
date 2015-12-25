// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package o:
//            ne, gj

static final class <init>
{

    HashMap Lf;
    HashMap Lg;

    public final void _mth02CE(gj gj)
    {
        Object obj = Lg.get(gj);
        Lg.remove(gj);
        Lf.remove(obj);
    }

    private HashMap()
    {
        Lf = new HashMap();
        Lg = new HashMap();
    }

    HashMap(byte byte0)
    {
        this();
    }
}
