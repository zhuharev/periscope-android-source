// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


final class wk
{

    boolean VA;
    wk VB;
    wk VC;
    boolean Vz;
    final byte data[];
    int limit;
    int pos;

    wk()
    {
        data = new byte[2048];
        VA = true;
        Vz = false;
    }

    wk(wk wk1)
    {
        this(wk1.data, wk1.pos, wk1.limit);
        wk1.Vz = true;
    }

    private wk(byte abyte0[], int i, int j)
    {
        data = abyte0;
        pos = i;
        limit = j;
        VA = false;
        Vz = true;
    }

    public final wk _mth0288()
    {
        wk wk1;
        if (VB != this)
        {
            wk1 = VB;
        } else
        {
            wk1 = null;
        }
        VC.VB = VB;
        VB.VC = VC;
        VB = null;
        VC = null;
        return wk1;
    }

    public final void _mth02CA(wk wk1, int i)
    {
        if (!wk1.VA)
        {
            throw new IllegalArgumentException();
        }
        if (wk1.limit + i > 2048)
        {
            if (wk1.Vz)
            {
                throw new IllegalArgumentException();
            }
            if ((wk1.limit + i) - wk1.pos > 2048)
            {
                throw new IllegalArgumentException();
            }
            System.arraycopy(wk1.data, wk1.pos, wk1.data, 0, wk1.limit - wk1.pos);
            wk1.limit = wk1.limit - wk1.pos;
            wk1.pos = 0;
        }
        System.arraycopy(data, pos, wk1.data, wk1.limit, i);
        wk1.limit = wk1.limit + i;
        pos = pos + i;
    }
}
