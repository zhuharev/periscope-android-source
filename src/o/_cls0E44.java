// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.accounts.Account;
import android.view.View;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package o:
//            _cls067B, dc

public final class _cls0E44
{

    public final String wU;
    final String wV;
    public final Set xG;
    final Set xH;
    public final Map xI;
    private final int xJ;
    private final View xK;
    public Integer xL;
    public final dc xe;
    public final Account xw;

    public _cls0E44(Account account, Set set, Map map, int i, View view, String s, String s1, 
            dc dc)
    {
        xw = account;
        if (set == null)
        {
            account = Collections.EMPTY_SET;
        } else
        {
            account = Collections.unmodifiableSet(set);
        }
        xG = account;
        if (map == null)
        {
            map = Collections.EMPTY_MAP;
        }
        xI = map;
        xK = view;
        xJ = i;
        wU = s;
        wV = s1;
        xe = dc;
        account = new HashSet(xG);
        for (set = xI.values().iterator(); set.hasNext(); account.addAll(((_cls067B)set.next()).wr)) { }
        xH = Collections.unmodifiableSet(account);
    }
}
