// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package o:
//            aig, aik, zc, ail, 
//            atn

public static final class 
    implements android.view.LongClickListener
{

    public final zc bmU;
    public final HashSet bnd = new HashSet();
    private final A bne;
    private final aig bnf;

    public final boolean onLongClick(View view)
    {
        aik aik1 = (aik)view.getTag();
        String s = aik1.broadcastId;
        boolean flag2 = bnd.contains(s);
        boolean flag;
        if (!flag2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setActivated(flag);
        view = bmU._mth144B(s);
        if (view == null)
        {
            aik1.bnr.setEnabled(false);
        } else
        {
            ail ail1 = aik1.bnr;
            boolean flag1;
            if (flag2 && ((atn) (view)).bDX)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            ail1.setReplayEnabled(flag1);
            view = aik1.bnr;
            if (!flag2)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            view.setDeleteEnabled(flag1);
        }
        if (flag2)
        {
            bnd.remove(s);
            return bne.ct();
        } else
        {
            bnd.add(s);
            return bne.cs();
        }
    }

    public A(A a, aig aig1)
    {
        bne = a;
        bnf = aig1;
        bmU = aig1.bmU;
    }
}
