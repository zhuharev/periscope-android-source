// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Bundle;
import java.util.LinkedList;

// Referenced classes of package o:
//            bc, ba, bi

public abstract class bb
{
    static interface if
    {

        public abstract int getState();

        public abstract void _mth1604();
    }


    public ba zw;
    Bundle zx;
    LinkedList zy;
    private final bc zz = new bc(this);

    public bb()
    {
    }

    public void _mth02CA(Bundle bundle, if if1)
    {
        if (zw != null)
        {
            if1._mth1604();
            return;
        }
        if (zy == null)
        {
            zy = new LinkedList();
        }
        zy.add(if1);
        if (bundle != null)
        {
            if (zx == null)
            {
                zx = (Bundle)bundle.clone();
            } else
            {
                zx.putAll(bundle);
            }
        }
        _mth02CA(((bi) (zz)));
    }

    public abstract void _mth02CA(bi bi);

    public void _mth02E2(int i)
    {
        for (; !zy.isEmpty() && ((if)zy.getLast()).getState() >= i; zy.removeLast()) { }
    }
}
