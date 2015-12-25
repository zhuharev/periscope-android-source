// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.util.List;
import java.util.Set;

// Referenced classes of package o:
//            _cls04B7, _cls025C, _cls0287, _cls0264, 
//            FF49, _cls0645, _cls0EB2, _cls03AB, 
//            _cls02A1, _cls02A2, _cls044C, FF90, 
//            FE93, _cls1D50, _cls1D3C, FF8B, 
//            _cls2148, FEE0, FF43, FEAE, 
//            _cls025B, FF7A, FC62, FEE9

public class _cls1D2E
    implements Cloneable
{

    private Context context;
    private int jA;
    private int jB;
    private _cls0287 jC;
    private FF43 jD;
    private boolean jE;
    protected final _cls1D3C jl;
    private Class jn;
    private Class jo;
    private FE93 jp;
    private _cls2148 jq;
    private FF49 jr;
    private Object js;
    private FEAE jt;
    private boolean ju;
    private int jv;
    private Float jw;
    private int jx;
    private boolean jy;
    _cls025B jz;

    _cls1D2E(Context context1, Class class1, FF7A ff7a, Class class2, _cls1D3C _pcls1d3c, FE93 fe93, _cls2148 _pcls2148)
    {
        jt = _cls04B7._mth05DA();
        jw = Float.valueOf(1.0F);
        jx = 0;
        jy = true;
        jz = _cls025C._mth03F2();
        jA = -1;
        jB = -1;
        jC = _cls0287.mv;
        jD = _cls0264._mth2040();
        context = context1;
        jn = class1;
        jo = class2;
        jl = _pcls1d3c;
        jp = fe93;
        jq = _pcls2148;
        if (ff7a != null)
        {
            class2 = new FF49(ff7a);
        } else
        {
            class2 = null;
        }
        jr = class2;
        if (context1 == null)
        {
            throw new NullPointerException("Context can't be null");
        }
        if (class1 != null && ff7a == null)
        {
            throw new NullPointerException("LoadProvider must not be null");
        } else
        {
            return;
        }
    }

    _cls1D2E(FF7A ff7a, Class class1, _cls1D2E _pcls1d2e)
    {
        this(_pcls1d2e.context, _pcls1d2e.jn, ff7a, class1, _pcls1d2e.jl, _pcls1d2e.jp, _pcls1d2e.jq);
        js = _pcls1d2e.js;
        ju = _pcls1d2e.ju;
        jt = _pcls1d2e.jt;
        jC = _pcls1d2e.jC;
        jy = _pcls1d2e.jy;
    }

    public Object clone()
    {
        return _mth0157();
    }

    void _mth0140()
    {
    }

    void _mth0142()
    {
    }

    public _cls1D2E _mth0157()
    {
        _cls1D2E _lcls1d2e = (_cls1D2E)super.clone();
        if (jr == null) goto _L2; else goto _L1
_L1:
        Object obj = jr._mth025F();
_L4:
        try
        {
            _lcls1d2e.jr = ((FF49) (obj));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((Throwable) (obj)));
        }
        return _lcls1d2e;
_L2:
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public _cls1D2E _mth017F()
    {
        _cls025B _lcls025b = _cls025C._mth03F2();
        if (_lcls025b == null)
        {
            throw new NullPointerException("Animation factory must not be null!");
        } else
        {
            jz = _lcls025b;
            return this;
        }
    }

    public _cls1D2E _mth02B4(boolean flag)
    {
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        jy = flag;
        return this;
    }

    public _cls1D2E _mth02C6(int i, int j)
    {
        if (!_cls0645._mth02E1(i, j))
        {
            throw new IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
        } else
        {
            jB = i;
            jA = j;
            return this;
        }
    }

    public _cls044C _mth02CA(ImageView imageview)
    {
        _cls0645._mth0631();
        if (imageview == null)
        {
            throw new IllegalArgumentException("You must pass in a non null View");
        }
    /* anonymous class not found */
    class _anm1 {}

        if (!jE && imageview.getScaleType() != null)
        {
            switch (_cls1.jF[imageview.getScaleType().ordinal()])
            {
            case 1: // '\001'
                _mth0142();
                break;

            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
                _mth0140();
                break;
            }
        }
        Object obj = jl;
        obj = jo;
        if (o/0EB2.isAssignableFrom(((Class) (obj))))
        {
            imageview = new _cls03AB(imageview);
        } else
        if (android/graphics/Bitmap.equals(obj))
        {
            imageview = new _cls02A1(imageview);
        } else
        if (android/graphics/drawable/Drawable.isAssignableFrom(((Class) (obj))))
        {
            imageview = new _cls02A2(imageview);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Unhandled class: ")).append(obj).append(", try .as*(Class).transcode(ResourceTranscoder)").toString());
        }
        return _mth02CA(((_cls044C) (imageview)));
    }

    public final _cls044C _mth02CA(_cls044C _pcls044c)
    {
        _cls0645._mth0631();
        if (_pcls044c == null)
        {
            throw new IllegalArgumentException("You must pass in a non null Target");
        }
        if (!ju)
        {
            throw new IllegalArgumentException("You must first set a model (try #load())");
        }
        Object obj = _pcls044c._mth0442();
        if (obj != null)
        {
            ((FF90) (obj)).clear();
            FE93 fe93 = jp;
            fe93.qX.remove(obj);
            fe93.qY.remove(obj);
            ((FF90) (obj)).recycle();
        }
        if (jx == 0)
        {
            jx = _cls1D50.kb;
        }
        float f = jw.floatValue();
        int i = jx;
        obj = FF8B._mth02CA(jr, js, jt, context, i, _pcls044c, f, null, jv, null, 0, null, 0, null, null, jl.jK, jD, jo, jy, jz, jB, jA, jC);
        _pcls044c._mth02CF(((FF90) (obj)));
        jq._mth02CA(_pcls044c);
        FE93 fe93_1 = jp;
        fe93_1.qX.add(obj);
        if (!fe93_1.qZ)
        {
            ((FF90) (obj)).begin();
            return _pcls044c;
        } else
        {
            fe93_1.qY.add(obj);
            return _pcls044c;
        }
    }

    public _cls1D2E _mth02CA(_cls0287 _pcls0287)
    {
        jC = _pcls0287;
        return this;
    }

    public _cls1D2E _mth02CA(FC62 fc62)
    {
        if (jr != null)
        {
            jr.nd = fc62;
        }
        return this;
    }

    public _cls1D2E _mth02CA(FEAE feae)
    {
        if (feae == null)
        {
            throw new NullPointerException("Signature must not be null");
        } else
        {
            jt = feae;
            return this;
        }
    }

    public _cls1D2E _mth02CA(FEE9 fee9)
    {
        if (jr != null)
        {
            jr.re = fee9;
        }
        return this;
    }

    public transient _cls1D2E _mth02CA(FF43 aff43[])
    {
        jE = true;
        if (aff43.length == 1)
        {
            jD = aff43[0];
            return this;
        } else
        {
            jD = new FEE0(aff43);
            return this;
        }
    }

    public _cls1D2E _mth02D0(int i)
    {
        jv = i;
        return this;
    }

    public _cls1D2E FE7A(Object obj)
    {
        js = obj;
        ju = true;
        return this;
    }
}
