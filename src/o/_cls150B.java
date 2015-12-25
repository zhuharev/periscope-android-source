// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package o:
//            _cls1422

public abstract class _cls150B
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class _cls02CF {}


    _cls02CA _fld1D43;
    _cls02CB _fld1D45;
    _cls02CF _fld1D49;

    _cls150B()
    {
    }

    public static boolean _mth02CA(Map map, Collection collection)
    {
        int i = map.size();
        Iterator iterator = map.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (!collection.contains(iterator.next()))
            {
                iterator.remove();
            }
        } while (true);
        return i != map.size();
    }

    public static boolean _mth02CA(Set set, Object obj)
    {
        if (set == obj)
        {
            return true;
        }
        if (obj instanceof Set)
        {
label0:
            {
                obj = (Set)obj;
                boolean flag;
                try
                {
                    if (set.size() != ((Set) (obj)).size())
                    {
                        break label0;
                    }
                    flag = set.containsAll(((Collection) (obj)));
                }
                // Misplaced declaration of an exception variable
                catch (Set set)
                {
                    return false;
                }
                // Misplaced declaration of an exception variable
                catch (Set set)
                {
                    return false;
                }
                if (flag)
                {
                    return true;
                }
            }
            return false;
        } else
        {
            return false;
        }
    }

    public final Object[] _mth02BF(int i)
    {
        int k = _mth1420();
        Object aobj[] = new Object[k];
        for (int j = 0; j < k; j++)
        {
            aobj[j] = _mth02CE(j, i);
        }

        return aobj;
    }

    protected abstract Object _mth02CA(int i, Object obj);

    protected abstract void _mth02CA(Object obj, Object obj1);

    public final Object[] _mth02CA(Object aobj[], int i)
    {
        int k = _mth1420();
        Object aobj1[] = aobj;
        if (aobj.length < k)
        {
            aobj1 = (Object[])Array.newInstance(((Object) (aobj)).getClass().getComponentType(), k);
        }
        for (int j = 0; j < k; j++)
        {
            aobj1[j] = _mth02CE(j, i);
        }

        if (aobj1.length > k)
        {
            aobj1[k] = null;
        }
        return aobj1;
    }

    protected abstract int _mth02CE(Object obj);

    protected abstract Object _mth02CE(int i, int j);

    protected abstract int _mth02CF(Object obj);

    protected abstract int _mth1420();

    protected abstract _cls1422 _mth1423();

    protected abstract void _mth1429();

    protected abstract void _mth1FBE(int i);
}
