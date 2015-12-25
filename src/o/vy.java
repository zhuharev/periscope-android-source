// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            wm, wo, vr

public abstract class vy
    implements wm
{

    private final wm _flddelegate;

    public vy(wm wm1)
    {
        if (wm1 == null)
        {
            throw new IllegalArgumentException("delegate == null");
        } else
        {
            _flddelegate = wm1;
            return;
        }
    }

    public void close()
    {
        _flddelegate.close();
    }

    public final wm _mthdelegate()
    {
        return _flddelegate;
    }

    public void flush()
    {
        _flddelegate.flush();
    }

    public wo timeout()
    {
        return _flddelegate.timeout();
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("(").append(_flddelegate.toString()).append(")").toString();
    }

    public void write(vr vr, long l)
    {
        _flddelegate.write(vr, l);
    }
}
