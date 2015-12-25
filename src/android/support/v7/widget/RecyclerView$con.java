// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import java.util.ArrayList;
import java.util.List;
import o.1422;
import o.1551;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView

public static final class ft
{

    int eZ;
    _cls1422 fj;
    _cls1422 fk;
    _cls1422 fl;
    final ArrayList fm = new ArrayList();
    public int fn;
    public int fo;
    public int fp;
    public boolean fq;
    public boolean fr;
    boolean fs;
    boolean ft;

    private static void _mth02CA(_cls1422 _pcls1422,  )
    {
        for (int i = _pcls1422.size() - 1; i >= 0; i--)
        {
            if ( == ((_cls1551) (_pcls1422)).FB48[(i << 1) + 1])
            {
                _pcls1422.removeAt(i);
                return;
            }
        }

    }

    public final String toString()
    {
        return (new StringBuilder("State{mTargetPosition=")).append(eZ).append(", mPreLayoutHolderMap=").append(fj).append(", mPostLayoutHolderMap=").append(fk).append(", mData=").append(null).append(", mItemCount=").append(fn).append(", mPreviousLayoutItemCount=").append(fo).append(", mDeletedInvisibleItemCountSincePreviousLayout=").append(fp).append(", mStructureChanged=").append(fq).append(", mInPreLayout=").append(fr).append(", mRunSimpleAnimations=").append(fs).append(", mRunPredictiveAnimations=").append(ft).append('}').toString();
    }

    final void _mth02CD( )
    {
        fj.remove();
        fk.remove();
        if (fl != null)
        {
            _mth02CA(fl, );
        }
        fm.remove(.fy);
    }

    public ()
    {
        eZ = -1;
        fj = new _cls1422();
        fk = new _cls1422();
        fl = new _cls1422();
        fn = 0;
        fo = 0;
        fp = 0;
        fq = false;
        fr = false;
        fs = false;
        ft = false;
    }
}
