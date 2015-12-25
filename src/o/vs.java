// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.OutputStream;

// Referenced classes of package o:
//            vr

final class vs extends OutputStream
{

    private vr Vi;

    vs(vr vr1)
    {
        Vi = vr1;
        super();
    }

    public final void close()
    {
    }

    public final void flush()
    {
    }

    public final String toString()
    {
        return (new StringBuilder()).append(this).append(".outputStream()").toString();
    }

    public final void write(int i)
    {
        Vi.FEE7((byte)i);
    }

    public final void write(byte abyte0[], int i, int j)
    {
        Vi._mth02BC(abyte0, i, j);
    }
}
