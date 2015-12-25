// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            zs

public class zd
{

    protected final ArrayList aWA;
    private Map aWB;
    private String aWy;
    protected final zs aWz;

    public zd(String s, zs zs, Map map)
    {
        this(s, zs, map, ((Collection) (new ArrayList())));
    }

    public zd(String s, zs zs, Map map, Collection collection)
    {
        aWy = s;
        aWz = zs;
        aWA = new ArrayList(collection);
        aWB = map;
    }

    public final int getUserCount()
    {
        return aWA.size();
    }

    public final zs x()
    {
        return aWz;
    }

    public final List y()
    {
        return Collections.unmodifiableList(aWA);
    }

    public final void z()
    {
        aWA.clear();
    }

    public final void _mth02BD(List list)
    {
        aWA.clear();
        if (list != null)
        {
            PsUser psuser;
            for (list = list.iterator(); list.hasNext(); aWB.put(psuser.id, psuser))
            {
                psuser = (PsUser)list.next();
                aWA.add(psuser.id);
            }

        }
    }

    public final void _mth1466(String s)
    {
        if (!aWA.contains(s))
        {
            aWA.add(s);
        }
    }

    public final boolean _mth14BE(String s)
    {
        return aWA.remove(s);
    }

    public final boolean _mth14EA(String s)
    {
        return aWA.contains(s);
    }

    public final PsUser _mth1D61(int i)
    {
        return (PsUser)aWB.get(aWA.get(i));
    }
}
