// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            wn, vr, wo

public abstract class vz
    implements wn
{

    private final wn _flddelegate;

    public vz(wn wn1)
    {
        if (wn1 == null)
        {
            throw new IllegalArgumentException("delegate == null");
        } else
        {
            _flddelegate = wn1;
            return;
        }
    }

    public void close()
    {
        _flddelegate.close();
    }

    public final wn _mthdelegate()
    {
        return _flddelegate;
    }

    public long read(vr vr, long l)
    {
        return _flddelegate.read(vr, l);
    }

    public wo timeout()
    {
        return _flddelegate.timeout();
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("(").append(_flddelegate.toString()).append(")").toString();
    }
}
