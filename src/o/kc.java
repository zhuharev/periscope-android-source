// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.math.BigDecimal;

public final class kc extends Number
{

    private final String value;

    public kc(String s)
    {
        value = s;
    }

    private Object writeReplace()
    {
        return new BigDecimal(value);
    }

    public final double doubleValue()
    {
        return Double.parseDouble(value);
    }

    public final float floatValue()
    {
        return Float.parseFloat(value);
    }

    public final int intValue()
    {
        NumberFormatException numberformatexception;
        int i;
        long l;
        try
        {
            i = Integer.parseInt(value);
        }
        // Misplaced declaration of an exception variable
        catch (NumberFormatException numberformatexception)
        {
            try
            {
                l = Long.parseLong(value);
            }
            // Misplaced declaration of an exception variable
            catch (NumberFormatException numberformatexception)
            {
                return (new BigDecimal(value)).intValue();
            }
            return (int)l;
        }
        return i;
    }

    public final long longValue()
    {
        NumberFormatException numberformatexception;
        long l;
        try
        {
            l = Long.parseLong(value);
        }
        // Misplaced declaration of an exception variable
        catch (NumberFormatException numberformatexception)
        {
            return (new BigDecimal(value)).longValue();
        }
        return l;
    }

    public final String toString()
    {
        return value;
    }
}
