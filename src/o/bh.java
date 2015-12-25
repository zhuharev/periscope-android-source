// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.lang.reflect.Field;

// Referenced classes of package o:
//            bg

public final class bh extends bg.if
{

    private final Object _fld15A8;

    private bh(Object obj)
    {
        _fld15A8 = obj;
    }

    public static Object _mth02CA(bg bg1)
    {
        if (bg1 instanceof bh)
        {
            return ((bh)bg1)._fld15A8;
        }
        bg1 = bg1.asBinder();
        Field afield[] = bg1.getClass().getDeclaredFields();
        if (afield.length == 1)
        {
            Field field = afield[0];
            if (!field.isAccessible())
            {
                field.setAccessible(true);
                try
                {
                    bg1 = ((bg) (field.get(bg1)));
                }
                // Misplaced declaration of an exception variable
                catch (bg bg1)
                {
                    throw new IllegalArgumentException("Binder object is null.", bg1);
                }
                // Misplaced declaration of an exception variable
                catch (bg bg1)
                {
                    throw new IllegalArgumentException("remoteBinder is the wrong class.", bg1);
                }
                // Misplaced declaration of an exception variable
                catch (bg bg1)
                {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", bg1);
                }
                return bg1;
            } else
            {
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
        } else
        {
            throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
        }
    }

    public static bh _mth02E1(Object obj)
    {
        return new bh(obj);
    }
}
