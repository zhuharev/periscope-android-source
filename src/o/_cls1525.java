// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls14F4

class _cls1525
    implements Runnable
{

    final _cls14F4 _fld04BA;

    _cls1525(_cls14F4 _pcls14f4)
    {
        _fld04BA = _pcls14f4;
        super();
    }

    public void run()
    {
        if ((_cls14F4._mth02CA(_fld04BA) & 1) != 0)
        {
            _cls14F4._mth02CA(_fld04BA, 0);
        }
        if ((_cls14F4._mth02CA(_fld04BA) & 0x1000) != 0)
        {
            _cls14F4._mth02CA(_fld04BA, 108);
        }
        _cls14F4._mth02CA(_fld04BA, false);
        _cls14F4._mth02CB(_fld04BA, 0);
    }
}
