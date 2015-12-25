// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


class _cls0390
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    final _cls0295._cls02CA as;

    _cls0390(_cls0295._cls02CA _pcls02ca)
    {
        as = _pcls02ca;
        super();
    }

    public void onGlobalLayout()
    {
        if (!_cls0295._cls02CA._mth02CA(as, as.am))
        {
            as.dismiss();
            return;
        } else
        {
            as._mth14D2();
            _cls0295._cls02CA._mth02CB(as);
            return;
        }
    }
}
