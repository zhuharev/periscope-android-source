// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;
import java.util.List;

public final class _cls152C
{

    private final ArrayList yD;
    private final Object yE;

    private _cls152C(Object obj)
    {
        if (obj == null)
        {
            throw new NullPointerException("null reference");
        } else
        {
            yE = obj;
            yD = new ArrayList();
            return;
        }
    }

    public _cls152C(Object obj, byte byte0)
    {
        this(obj);
    }

    public final String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder(100)).append(yE.getClass().getSimpleName()).append('{');
        int j = yD.size();
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append((String)yD.get(i));
            if (i < j - 1)
            {
                stringbuilder.append(", ");
            }
        }

        return stringbuilder.append('}').toString();
    }

    public final _cls152C _mth02CA(String s, Object obj)
    {
        ArrayList arraylist = yD;
        StringBuilder stringbuilder = new StringBuilder();
        if (s == null)
        {
            throw new NullPointerException("null reference");
        } else
        {
            arraylist.add(stringbuilder.append((String)s).append("=").append(String.valueOf(obj)).toString());
            return this;
        }
    }
}
