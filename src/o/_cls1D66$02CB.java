// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.File;

// Referenced classes of package o:
//            _cls1D66

public final class 
{

    private final String key;
    private _cls1D66 km;
    public final File kp[];
    private final long lengths[];
    private final long sequenceNumber;

    public ()
    {
    }

    private (_cls1D66 _pcls1d66, String s, long l, File afile[], long al[])
    {
        km = _pcls1d66;
        super();
        key = s;
        sequenceNumber = l;
        kp = afile;
        lengths = al;
    }

    (_cls1D66 _pcls1d66, String s, long l, File afile[], long al[], byte byte0)
    {
        this(_pcls1d66, s, l, afile, al);
    }
}
