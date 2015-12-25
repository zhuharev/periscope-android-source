// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.Collection;

// Referenced classes of package o:
//            ane, aop, alr, als, 
//            ang, alp, zj

public final class alq extends ane
    implements aop
{

    final alr bsj = new alr(this);

    public alq(alp alp, zj zj, alp alp1)
    {
        super(alp, zj, alp1);
        btK = new als(this, zj);
    }

    static Object _mth02CA(alq alq1, int i)
    {
        return alq1.getItem(i);
    }

    public final void dj()
    {
        bsj.dj();
    }

    public final boolean dk()
    {
        return bsj.dk();
    }

    public final Collection dl()
    {
        return bsj.dl();
    }

    public final void selectAll()
    {
        bsj.selectAll();
    }

    protected final ang _mth02BB(ViewGroup viewgroup)
    {
        return new ang(LayoutInflater.from(mContext).inflate(0x7f030083, viewgroup, false), beo);
    }

    protected final android.support.v7.widget.RecyclerView._cls02CC _mth02BC(ViewGroup viewgroup)
    {
        return new ang(LayoutInflater.from(mContext).inflate(0x7f030083, viewgroup, false), beo);
    }

    public final volatile void _mth1646(String s)
    {
        s = (String)s;
        bsj._mth1646(s);
    }
}
