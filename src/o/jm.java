// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

// Referenced classes of package o:
//            js, mp, in, jn, 
//            jr, jt, ju, jv, 
//            jw, jx, jy, jo, 
//            jp, jq, kh

public final class jm
{

    private final Map GP;

    public jm(Map map)
    {
        GP = map;
    }

    private js _mth02CE(Class class1)
    {
        try
        {
            class1 = class1.getDeclaredConstructor(new Class[0]);
            if (!class1.isAccessible())
            {
                class1.setAccessible(true);
            }
            class1 = new js(this, class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        return class1;
    }

    public final String toString()
    {
        return GP.toString();
    }

    public final kh _mth02CB(mp mp1)
    {
        java.lang.reflect.Type type = mp1.Io;
        Class class1 = mp1.Js;
        mp1 = (in)GP.get(type);
        if (mp1 != null)
        {
            return new jn(this, mp1, type);
        }
        mp1 = (in)GP.get(class1);
        if (mp1 != null)
        {
            return new jr(this, mp1, type);
        }
        mp1 = _mth02CE(class1);
        if (mp1 != null)
        {
            return mp1;
        }
        if (java/util/Collection.isAssignableFrom(class1))
        {
            if (java/util/SortedSet.isAssignableFrom(class1))
            {
                mp1 = new jt(this);
            } else
            if (java/util/EnumSet.isAssignableFrom(class1))
            {
                mp1 = new ju(this, type);
            } else
            if (java/util/Set.isAssignableFrom(class1))
            {
                mp1 = new jv(this);
            } else
            if (java/util/Queue.isAssignableFrom(class1))
            {
                mp1 = new jw(this);
            } else
            {
                mp1 = new jx(this);
            }
        } else
        if (java/util/Map.isAssignableFrom(class1))
        {
            if (java/util/SortedMap.isAssignableFrom(class1))
            {
                mp1 = new jy(this);
            } else
            if ((type instanceof ParameterizedType) && !java/lang/String.isAssignableFrom((new mp(((ParameterizedType)type).getActualTypeArguments()[0])).Js))
            {
                mp1 = new jo(this);
            } else
            {
                mp1 = new jp(this);
            }
        } else
        {
            mp1 = null;
        }
        if (mp1 != null)
        {
            return mp1;
        } else
        {
            return new jq(this, class1, type);
        }
    }
}
