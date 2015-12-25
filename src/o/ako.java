// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            akn, akm

final class ako
    implements android.support.v4.view.ViewPager._cls02CF
{

    private final akn bqJ;

    public ako(akm akm)
    {
        bqJ = akm;
    }

    public final void _mth02CA(int i, float f, int j)
    {
    }

    public final void _mth0640(int i)
    {
    }

    public final void _mth1427(int i)
    {
        akn akn1 = bqJ;
        boolean flag;
        if (i != 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        akn1.setRefreshable(flag);
    }
}
