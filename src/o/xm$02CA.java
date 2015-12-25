// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            xm

static final class aTL
{

    byte aTL[];
    int aTM;
    long aTN;

    public final void clear()
    {
        for (int i = 0; i < aTL.length; i++)
        {
            aTL[i] = 0;
        }

    }

    Object(int i)
    {
        aTL = new byte[2048];
    }
}
