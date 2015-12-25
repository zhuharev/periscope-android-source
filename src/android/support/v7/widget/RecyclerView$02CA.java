// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.database.Observable;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView

public static final class  extends Observable
{

    public final void notifyChanged()
    {
        for (int i = mObservers.size() - 1; i >= 0; i--)
        {
            ((mObservers)mObservers.get(i)).onChanged();
        }

    }

    public final void _mth1D4E(int i, int j)
    {
        for (int k = mObservers.size() - 1; k >= 0; k--)
        {
            ((mObservers)mObservers.get(k))._mth2071(i, j);
        }

    }

    public final void _mth1D54(int i, int j)
    {
        for (int k = mObservers.size() - 1; k >= 0; k--)
        {
            ((mObservers)mObservers.get(k)).FE76(i, j);
        }

    }

    public final void _mth1D62(int i, int j)
    {
        for (int k = mObservers.size() - 1; k >= 0; k--)
        {
            ((mObservers)mObservers.get(k)).FE7A(i, j);
        }

    }

    public final boolean _mth30FC()
    {
        return !mObservers.isEmpty();
    }

    ()
    {
    }
}
