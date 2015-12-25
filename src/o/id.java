// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.lang.reflect.Field;

// Referenced classes of package o:
//            hy

final class id extends hy
{

    id(String s, int i)
    {
        super(s, 4, (byte)0);
    }

    public final String _mth02CA(Field field)
    {
        return hy._mth02BC(field.getName(), "-").toLowerCase();
    }
}
