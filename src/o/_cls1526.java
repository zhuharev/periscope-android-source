// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.OutputStream;

// Referenced classes of package o:
//            FC62, _cls05D4, _cls14FF

public final class _cls1526
    implements FC62
{

    private String id;
    private final FC62 qv;
    private final FC62 qw;

    public _cls1526(FC62 fc62, FC62 fc62_1)
    {
        qv = fc62;
        qw = fc62_1;
    }

    public final String getId()
    {
        if (id == null)
        {
            id = (new StringBuilder()).append(qv.getId()).append(qw.getId()).toString();
        }
        return id;
    }

    public final boolean _mth02CA(Object obj, OutputStream outputstream)
    {
        obj = (_cls14FF)((_cls05D4)obj).get();
        _cls05D4 _lcls05d4 = ((_cls14FF) (obj)).qn;
        if (_lcls05d4 != null)
        {
            return qv._mth02CA(_lcls05d4, outputstream);
        } else
        {
            return qw._mth02CA(((_cls14FF) (obj)).qm, outputstream);
        }
    }
}
