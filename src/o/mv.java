// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.google.android.gms.maps.model.MarkerOptions;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package o:
//            gj, er

public final class mv
    implements _cls141F.if, er._cls02CB
{
    public final class if
    {

        final HashSet JY = new HashSet();
        public _cls141F.if JZ;
        public er._cls02CB Ka;
        final mv Kb;

        public final void clear()
        {
            gj gj1;
            for (Iterator iterator = JY.iterator(); iterator.hasNext(); Kb.JX.remove(gj1))
            {
                gj1 = (gj)iterator.next();
                gj1.remove();
            }

            JY.clear();
        }

        public final gj _mth02CA(MarkerOptions markeroptions)
        {
            markeroptions = Kb.JV._mth02CA(markeroptions);
            JY.add(markeroptions);
            Kb.JX.put(markeroptions, this);
            return markeroptions;
        }

        public if()
        {
            Kb = mv.this;
            super();
        }
    }


    final er JV;
    private final HashMap JW = new HashMap();
    final HashMap JX = new HashMap();

    public mv(er er)
    {
        JV = er;
    }

    public final boolean _mth02CA(gj gj1)
    {
        if if1 = (if)JX.get(gj1);
        if (if1 != null && if1.Ka != null)
        {
            return if1.Ka._mth02CA(gj1);
        } else
        {
            return false;
        }
    }

    public final boolean _mth02CB(gj gj1)
    {
        if if1 = (if)JX.get(gj1);
        if (if1 != null)
        {
            boolean flag;
            if (if1.JY.remove(gj1))
            {
                if1.Kb.JX.remove(gj1);
                gj1.remove();
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return true;
            }
        }
        return false;
    }
}
