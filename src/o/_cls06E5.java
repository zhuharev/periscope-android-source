// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package o:
//            _cls02E1, FB1D, _cls02EE

public class _cls06E5
{
    /* member class not found */
    class aux {}

    /* member class not found */
    class con {}

    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02BB {}

    /* member class not found */
    class _cls02BC {}

    /* member class not found */
    class _cls02BD {}

    /* member class not found */
    class _cls02BE {}

    /* member class not found */
    class _cls02BF {}

    /* member class not found */
    class _cls02C8 {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class _cls02CF {}

    /* member class not found */
    class _cls037A {}

    /* member class not found */
    class _cls141D {}

    /* member class not found */
    class _cls1FBE {}


    private static final _cls141D _fld144B;

    public _cls06E5()
    {
    }

    private static void _mth02CA(_cls02E1 _pcls02e1, ArrayList arraylist)
    {
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); _pcls02e1._mth02CA((if)arraylist.next())) { }
    }

    private static void _mth02CA(_cls02EE _pcls02ee, _cls02C8 _pcls02c8)
    {
        if (_pcls02c8 != null)
        {
            if (_pcls02c8 instanceof _cls02CB)
            {
                _pcls02c8 = (_cls02CB)_pcls02c8;
                FB1D._mth02CA(_pcls02ee, ((_cls02CB) (_pcls02c8))._fld05DF, ((_cls02CB) (_pcls02c8))._fld05E8, ((_cls02CB) (_pcls02c8))._fld05E0, ((_cls02CB) (_pcls02c8))._fld1550);
                return;
            }
            if (_pcls02c8 instanceof aux)
            {
                _pcls02c8 = (aux)_pcls02c8;
                FB1D._mth02CA(_pcls02ee, ((aux) (_pcls02c8))._fld05DF, ((aux) (_pcls02c8))._fld05E8, ((aux) (_pcls02c8))._fld05E0, ((aux) (_pcls02c8))._fld05D2);
                return;
            }
            if (_pcls02c8 instanceof _cls02CA)
            {
                _pcls02c8 = (_cls02CA)_pcls02c8;
                FB1D._mth02CA(_pcls02ee, ((_cls02CA) (_pcls02c8))._fld05DF, ((_cls02CA) (_pcls02c8))._fld05E8, ((_cls02CA) (_pcls02c8))._fld05E0, ((_cls02CA) (_pcls02c8))._fld14EA, ((_cls02CA) (_pcls02c8))._fld14EB, ((_cls02CA) (_pcls02c8))._fld153E);
            }
        }
    }

    static void _mth02CB(_cls02E1 _pcls02e1, ArrayList arraylist)
    {
        _mth02CA(_pcls02e1, arraylist);
    }

    static void _mth02CB(_cls02EE _pcls02ee, _cls02C8 _pcls02c8)
    {
        _mth02CA(_pcls02ee, _pcls02c8);
    }

    static _cls141D FE76()
    {
        return _fld144B;
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            _fld144B = new _cls02BC();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 20)
        {
            _fld144B = new _cls02BB();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            _fld144B = new con();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            _fld144B = new _cls02BF();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            _fld144B = new _cls02BE();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            _fld144B = new _cls1FBE();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            _fld144B = new _cls037A();
        } else
        {
            _fld144B = new _cls02BD();
        }
    }
}
