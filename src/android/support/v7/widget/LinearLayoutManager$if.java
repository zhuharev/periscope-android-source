// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;
import o.2174;

// Referenced classes of package android.support.v7.widget:
//            LinearLayoutManager

final class ca
{

    int bX;
    int bY;
    boolean bZ;
    final LinearLayoutManager ca;

    public final String toString()
    {
        return (new StringBuilder("AnchorInfo{mPosition=")).append(bX).append(", mCoordinate=").append(bY).append(", mLayoutFromEnd=").append(bZ).append('}').toString();
    }

    final void _mth0433()
    {
        int i;
        if (bZ)
        {
            i = ca.bN._mth1506();
        } else
        {
            i = ca.bN._mth14D1();
        }
        bY = i;
    }

    public final void _mth141F(View view)
    {
        if (bZ)
        {
            int j = ca.bN._mth142A(view);
            _cls2174 _lcls2174 = ca.bN;
            int i;
            if (0x80000000 == _lcls2174.dv)
            {
                i = 0;
            } else
            {
                i = _lcls2174._mth1D16() - _lcls2174.dv;
            }
            bY = j + i;
        } else
        {
            bY = ca.bN._mth1421(view);
        }
        bX = LinearLayoutManager._mth1D38(view);
    }

    (LinearLayoutManager linearlayoutmanager)
    {
        ca = linearlayoutmanager;
        super();
    }
}
