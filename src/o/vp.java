// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.IOException;

// Referenced classes of package o:
//            wn, vn, vr, wo

final class vp
    implements wn
{

    private vn Vd;
    private wn Ve;

    vp(vn vn1, wn wn1)
    {
        Vd = vn1;
        Ve = wn1;
        super();
    }

    public final void close()
    {
        Ve.close();
        Vd.exit(true);
        return;
        Object obj;
        obj;
        throw Vd.exit(((IOException) (obj)));
        obj;
        Vd.exit(false);
        throw obj;
    }

    public final long read(vr vr, long l)
    {
        Vd.enter();
        l = Ve.read(vr, l);
        Vd.exit(true);
        return l;
        vr;
        throw Vd.exit(vr);
        vr;
        Vd.exit(false);
        throw vr;
    }

    public final wo timeout()
    {
        return Vd;
    }

    public final String toString()
    {
        return (new StringBuilder("AsyncTimeout.source(")).append(Ve).append(")").toString();
    }
}
