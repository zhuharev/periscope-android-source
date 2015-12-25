// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            aew, ahw, aib

public final class aex
    implements aew
{

    private final ahw bhQ;
    private final aib bhR;

    public aex(ahw ahw1, aib aib1)
    {
        bhQ = ahw1;
        bhR = aib1;
    }

    public final void aX()
    {
        bhQ.setVisibility(8);
        bhR.setVisibility(8);
    }

    public final void aY()
    {
        bhQ.setVisibility(0);
        bhR.setVisibility(0);
    }

    public final boolean aZ()
    {
        return bhQ.getVisibility() == 0;
    }
}
