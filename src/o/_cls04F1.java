// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.InputStream;

// Referenced classes of package o:
//            _cls04ED

final class _cls04F1
    implements sl._cls02CB
{

    private byte vG[];
    private int vH[];
    private _cls04ED vI;

    _cls04F1(_cls04ED _pcls04ed, byte abyte0[], int ai[])
    {
        vI = _pcls04ed;
        vG = abyte0;
        vH = ai;
        super();
    }

    public final void read(InputStream inputstream, int i)
    {
        int ai[];
        inputstream.read(vG, vH[0], i);
        ai = vH;
        ai[0] = ai[0] + i;
        inputstream.close();
        return;
        Exception exception;
        exception;
        inputstream.close();
        throw exception;
    }
}
