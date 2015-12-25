// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.IOException;

// Referenced classes of package o:
//            wm, vn, wo, vr

final class vo
    implements wm
{

    private wm Vc;
    private vn Vd;

    vo(vn vn1, wm wm1)
    {
        Vd = vn1;
        Vc = wm1;
        super();
    }

    public final void close()
    {
        Vd.enter();
        Vc.close();
        Vd.exit(true);
        return;
        Object obj;
        obj;
        throw Vd.exit(((IOException) (obj)));
        obj;
        Vd.exit(false);
        throw obj;
    }

    public final void flush()
    {
        Vd.enter();
        Vc.flush();
        Vd.exit(true);
        return;
        Object obj;
        obj;
        throw Vd.exit(((IOException) (obj)));
        obj;
        Vd.exit(false);
        throw obj;
    }

    public final wo timeout()
    {
        return Vd;
    }

    public final String toString()
    {
        return (new StringBuilder("AsyncTimeout.sink(")).append(Vc).append(")").toString();
    }

    public final void write(vr vr, long l)
    {
        Vd.enter();
        Vc.write(vr, l);
        Vd.exit(true);
        return;
        vr;
        throw Vd.exit(vr);
        vr;
        Vd.exit(false);
        throw vr;
    }
}
