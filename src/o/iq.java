// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.IOException;
import java.io.StringWriter;

// Referenced classes of package o:
//            mt, it

public abstract class iq
{

    public iq()
    {
    }

    public String toString()
    {
        Object obj;
        try
        {
            obj = new StringWriter();
            mt mt1 = new mt(((java.io.Writer) (obj)));
            mt1.Ju = true;
            _cls1D3A._cls02CA._mth02CA(this, mt1);
            obj = ((StringWriter) (obj)).toString();
        }
        catch (IOException ioexception)
        {
            throw new AssertionError(ioexception);
        }
        return ((String) (obj));
    }

    public Number _mth04AD()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String _mth04AE()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long _mth0507()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int _mth05D4()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean _mth0672()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final it _mth0673()
    {
        if (this instanceof it)
        {
            return (it)this;
        } else
        {
            throw new IllegalStateException((new StringBuilder("Not a JSON Object: ")).append(this).toString());
        }
    }
}
