// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls1D51, _cls1E3B, FE77

final class _cls2134
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    private _cls1D51 l;

    _cls2134(_cls1D51 _pcls1d51)
    {
        l = _pcls1d51;
        super();
    }

    public final void onGlobalLayout()
    {
        if (l._mth05D2().isShowing())
        {
            if (!l.isShown())
            {
                _cls1D51._mth02CB(l).dismiss();
                return;
            }
            _cls1D51._mth02CB(l).show();
            if (l.b != null)
            {
                l.b._mth141D(true);
            }
        }
    }
}
