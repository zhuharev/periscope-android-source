// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            FF7A, FC62, FEE9, _cls2110, 
//            _cls1D08

public final class FF49
    implements FF7A, Cloneable
{

    public FC62 nd;
    private final FF7A rd;
    public FEE9 re;

    public FF49(FF7A ff7a)
    {
        rd = ff7a;
    }

    public final Object clone()
    {
        return _mth025F();
    }

    public final _cls2110 _mth01C0()
    {
        return rd._mth01C0();
    }

    public final _cls1D08 _mth0254()
    {
        return rd._mth0254();
    }

    public final FF49 _mth025F()
    {
        FF49 ff49;
        try
        {
            ff49 = (FF49)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            throw new RuntimeException(clonenotsupportedexception);
        }
        return ff49;
    }

    public final FEE9 _mth4E28()
    {
        return rd._mth4E28();
    }

    public final FEE9 _mth6C35()
    {
        if (re != null)
        {
            return re;
        } else
        {
            return rd._mth6C35();
        }
    }

    public final FC62 _mth706C()
    {
        if (nd != null)
        {
            return nd;
        } else
        {
            return rd._mth706C();
        }
    }

    public final FC62 FB59()
    {
        return rd.FB59();
    }
}
