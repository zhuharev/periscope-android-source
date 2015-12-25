// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            arz

public final class ary
    implements android.support.v4.view.ViewPager._cls02CF
{

    private final arz bCn;
    private int bCo;
    private int mState;

    public ary(arz arz1)
    {
        bCn = arz1;
    }

    public final void _mth02CA(int i, float f, int j)
    {
        arz arz1 = bCn;
        arz1.bX = i;
        arz1.bCs = arz1.bCt * f;
        arz1.invalidate();
    }

    public final void _mth0640(int i)
    {
        bCo = i;
    }

    public final void _mth1427(int i)
    {
        if (mState == 2 && i == 0)
        {
            bCn.setPosition(bCo);
        }
        mState = i;
    }
}
