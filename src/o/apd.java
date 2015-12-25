// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            apc

public final class apd
{

    public byte buffer[];
    private apc bxG;
    public int length;

    public apd()
    {
        buffer = null;
        length = 0;
    }

    public apd(byte abyte0[])
    {
        buffer = null;
        length = 0;
        buffer = abyte0;
        length = abyte0.length;
    }

    public final apc ef()
    {
        this;
        JVM INSTR monitorenter ;
        apc apc = bxG;
        this;
        JVM INSTR monitorexit ;
        return apc;
        Exception exception;
        exception;
        throw exception;
    }

    public final void _mth02C6(byte abyte0[], int i, int j)
    {
        FEAB(length + j);
        System.arraycopy(abyte0, i, buffer, length, j);
        length = length + j;
    }

    public final void _mth02CA(apc apc)
    {
        this;
        JVM INSTR monitorenter ;
        bxG = apc;
        this;
        JVM INSTR monitorexit ;
        return;
        apc;
        throw apc;
    }

    public final void FEAB(int i)
    {
        if (buffer == null || buffer.length < i)
        {
            char c = '\u1064';
            if (i <= 2048)
            {
                c = ' ';
            }
            byte abyte0[] = new byte[(((i + c) - 1) / c) * c];
            if (length > 0)
            {
                System.arraycopy(buffer, 0, abyte0, 0, length);
            }
            buffer = abyte0;
        }
    }
}
