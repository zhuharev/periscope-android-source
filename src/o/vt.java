// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.InputStream;

// Referenced classes of package o:
//            vr

public final class vt extends InputStream
{

    private vr Vi;

    public vt(vr vr1)
    {
        Vi = vr1;
        super();
    }

    public final int available()
    {
        return (int)Math.min(Vi.size, 0x7fffffffL);
    }

    public final void close()
    {
    }

    public final int read()
    {
        if (Vi.size > 0L)
        {
            return Vi.readByte() & 0xff;
        } else
        {
            return -1;
        }
    }

    public final int read(byte abyte0[], int i, int j)
    {
        return Vi.read(abyte0, i, j);
    }

    public final String toString()
    {
        return (new StringBuilder()).append(Vi).append(".inputStream()").toString();
    }
}
