// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package o:
//            FF43, _cls05D4

public class FEE0
    implements FF43
{

    private String id;
    private final List lY;

    public FEE0()
    {
    }

    public transient FEE0(FF43 aff43[])
    {
        if (aff43.length <= 0)
        {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        } else
        {
            lY = Arrays.asList(aff43);
            return;
        }
    }

    public final String getId()
    {
        if (id == null)
        {
            StringBuilder stringbuilder = new StringBuilder();
            for (Iterator iterator = lY.iterator(); iterator.hasNext(); stringbuilder.append(((FF43)iterator.next()).getId())) { }
            id = stringbuilder.toString();
        }
        return id;
    }

    public final _cls05D4 _mth02CA(_cls05D4 _pcls05d4, int i, int j)
    {
        _cls05D4 _lcls05d4 = _pcls05d4;
        for (Iterator iterator = lY.iterator(); iterator.hasNext();)
        {
            _cls05D4 _lcls05d4_1 = ((FF43)iterator.next())._mth02CA(_lcls05d4, i, j);
            if (_lcls05d4 != null && !_lcls05d4.equals(_pcls05d4) && !_lcls05d4.equals(_lcls05d4_1))
            {
                _lcls05d4.recycle();
            }
            _lcls05d4 = _lcls05d4_1;
        }

        return _lcls05d4;
    }
}
