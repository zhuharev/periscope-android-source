// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package o:
//            wg, vr

final class wh extends OutputStream
{

    private wg Vw;

    wh(wg wg1)
    {
        Vw = wg1;
        super();
    }

    public final void close()
    {
        Vw.close();
    }

    public final void flush()
    {
        if (!Vw.closed)
        {
            Vw.flush();
        }
    }

    public final String toString()
    {
        return (new StringBuilder()).append(Vw).append(".outputStream()").toString();
    }

    public final void write(int i)
    {
        if (Vw.closed)
        {
            throw new IOException("closed");
        } else
        {
            Vw.Vu.FEE7((byte)i);
            Vw._mth0165();
            return;
        }
    }

    public final void write(byte abyte0[], int i, int j)
    {
        if (Vw.closed)
        {
            throw new IOException("closed");
        } else
        {
            Vw.Vu._mth02BC(abyte0, i, j);
            Vw._mth0165();
            return;
        }
    }
}
