// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls025B, _cls025C, _cls0284, _cls0192

public final class _cls0288
    implements _cls025B
{

    private final _cls0284.if rN;
    private _cls0284 rO;

    _cls0288(_cls0284.if if1)
    {
        rN = if1;
    }

    public final _cls0192 _mth02CF(boolean flag, boolean flag1)
    {
        if (flag || !flag1)
        {
            return _cls025C._mth03F3();
        }
        if (rO == null)
        {
            rO = new _cls0284(rN);
        }
        return rO;
    }
}
