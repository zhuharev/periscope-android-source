// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.widget.ImageView;

// Referenced classes of package o:
//            _cls1D2E, _cls0EB2, _cls0165, FF43, 
//            _cls1D3C, _cls152A, FF74, FE93, 
//            _cls2148, _cls044C, _cls0443, _cls0287, 
//            FC62, FEAE, FEE9

public class _cls1647 extends _cls1D2E
{

    _cls1647(Context context, Class class1, FF74 ff74, _cls1D3C _pcls1d3c, FE93 fe93, _cls2148 _pcls2148)
    {
        super(context, class1, ff74, o/0EB2, _pcls1d3c, fe93, _pcls2148);
        context = new _cls0165();
        if (context == null)
        {
            throw new NullPointerException("Animation factory must not be null!");
        } else
        {
            super.jz = context;
            return;
        }
    }

    public Object clone()
    {
        return (_cls1647)super._mth0157();
    }

    final void _mth0140()
    {
        super._mth02CA(new FF43[] {
            jl.jS
        });
    }

    final void _mth0142()
    {
        super._mth02CA(new FF43[] {
            jl.jQ
        });
    }

    public final volatile _cls1D2E _mth0157()
    {
        return (_cls1647)super._mth0157();
    }

    public final volatile _cls1D2E _mth017F()
    {
        super._mth017F();
        return this;
    }

    public final _cls1647 _mth0197()
    {
        _cls0165 _lcls0165 = new _cls0165();
        if (_lcls0165 == null)
        {
            throw new NullPointerException("Animation factory must not be null!");
        } else
        {
            super.jz = _lcls0165;
            return this;
        }
    }

    public final _cls1647 _mth019A()
    {
        super._mth017F();
        return this;
    }

    public final volatile _cls1D2E _mth02B4(boolean flag)
    {
        super._mth02B4(flag);
        return this;
    }

    public final volatile _cls1D2E _mth02C6(int i, int j)
    {
        super._mth02C6(i, j);
        return this;
    }

    public final _cls044C _mth02CA(ImageView imageview)
    {
        return super._mth02CA(imageview);
    }

    public final transient _cls1647 _mth02CA(_cls0443 a_pcls0443[])
    {
        _cls152A a_lcls152a[] = new _cls152A[a_pcls0443.length];
        for (int i = 0; i < a_pcls0443.length; i++)
        {
            a_lcls152a[i] = new _cls152A(jl.je, a_pcls0443[i]);
        }

        super._mth02CA(a_lcls152a);
        return this;
    }

    public final volatile _cls1D2E _mth02CA(_cls0287 _pcls0287)
    {
        super._mth02CA(_pcls0287);
        return this;
    }

    public final volatile _cls1D2E _mth02CA(FC62 fc62)
    {
        super._mth02CA(fc62);
        return this;
    }

    public final volatile _cls1D2E _mth02CA(FEAE feae)
    {
        super._mth02CA(feae);
        return this;
    }

    public final volatile _cls1D2E _mth02CA(FEE9 fee9)
    {
        super._mth02CA(fee9);
        return this;
    }

    public final volatile _cls1D2E _mth02CA(FF43 aff43[])
    {
        super._mth02CA(aff43);
        return this;
    }

    public final _cls1647 _mth02CB(_cls0287 _pcls0287)
    {
        super._mth02CA(_pcls0287);
        return this;
    }

    public final _cls1647 _mth02CB(FEAE feae)
    {
        super._mth02CA(feae);
        return this;
    }

    public final volatile _cls1D2E _mth02D0(int i)
    {
        super._mth02D0(i);
        return this;
    }

    public final _cls1647 _mth02E3(int i)
    {
        _cls0165 _lcls0165 = new _cls0165(i);
        if (_lcls0165 == null)
        {
            throw new NullPointerException("Animation factory must not be null!");
        } else
        {
            super.jz = _lcls0165;
            return this;
        }
    }

    public final _cls1647 _mth05D5(int i)
    {
        super._mth02D0(i);
        return this;
    }

    public final volatile _cls1D2E FE7A(Object obj)
    {
        super.FE7A(obj);
        return this;
    }

    public final _cls1647 FF70(Object obj)
    {
        super.FE7A(obj);
        return this;
    }
}
