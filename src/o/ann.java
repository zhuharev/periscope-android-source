// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import java.util.Collection;
import java.util.List;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            anm, aop, amz, ano, 
//            anp, any, aqt, anz, 
//            zq, ans, asn

public final class ann extends anm
    implements Filterable, aop
{
    public static interface if
    {

        public abstract void _mth02E4(boolean flag);
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}


    private final anz buk;
    public final ano bul = new ano(this);
    private final anp bum = new anp(this);
    private _cls02CB bun;
    private List buo;
    public boolean bup;
    public if buq;

    public ann(Context context, zq zq, ans ans)
    {
        super(context, zq, null, new amz());
        buk = ans;
    }

    static Object _mth02CA(ann ann1, int i)
    {
        int j = i;
        if (ann1.bup)
        {
            if (i == 0)
            {
                return "";
            }
            j = Math.max(0, i - 1);
        }
        return ann1.anm.getItem(j);
    }

    static List _mth02CA(ann ann1, List list)
    {
        ann1.buo = list;
        return list;
    }

    static aop _mth02CA(ann ann1)
    {
        return ann1.bul;
    }

    static int _mth02CB(ann ann1)
    {
        if (ann1.bup)
        {
            return ann1.anm.getItemCount() + 1;
        } else
        {
            return ann1.anm.getItemCount();
        }
    }

    static if _mth02CE(ann ann1)
    {
        return ann1.buq;
    }

    public final void dj()
    {
        bul.dj();
    }

    public final boolean dk()
    {
        return bul.dk();
    }

    public final Collection dl()
    {
        return bul.dl();
    }

    protected final volatile asn dv()
    {
        return bum;
    }

    public final Filter getFilter()
    {
        if (bun == null)
        {
            bun = new _cls02CB((byte)0);
        }
        return bun;
    }

    protected final Object getItem(int i)
    {
        if (buo != null)
        {
            return buo.get(i);
        }
        int j = i;
        if (bup)
        {
            if (i == 0)
            {
                return "";
            }
            j = Math.max(0, i - 1);
        }
        return super.getItem(j);
    }

    public final int getItemCount()
    {
        if (buo != null)
        {
            return buo.size();
        }
        if (bup)
        {
            return super.getItemCount() + 1;
        } else
        {
            return super.getItemCount();
        }
    }

    public final int getItemViewType(int i)
    {
        Object obj;
label0:
        {
            int j = i;
            if (buo != null)
            {
                obj = buo.get(j);
                break label0;
            }
            int k = j;
            if (bup)
            {
                if (j == 0)
                {
                    obj = "";
                    break label0;
                }
                k = Math.max(0, j - 1);
            }
            obj = super.getItem(k);
        }
        if (obj instanceof zp.if)
        {
            return i != 0 ? 1 : 3;
        }
        return !(obj instanceof PsUser) ? 4 : 2;
    }

    public final void selectAll()
    {
        bul.selectAll();
    }

    public final android.support.v7.widget.RecyclerView._cls02CC _mth02BC(ViewGroup viewgroup)
    {
        return new any(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030092, viewgroup, false), buk, 0x7f0d0187);
    }

    public final void _mth02CA(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc, int i)
    {
        if (_pcls02cc.getItemViewType() == 4)
        {
            ((_cls02CA)_pcls02cc).bus.setChecked(bul.dk());
            return;
        } else
        {
            super._mth02CA(_pcls02cc, i);
            return;
        }
    }

    public final android.support.v7.widget.RecyclerView._cls02CC _mth02CB(ViewGroup viewgroup, int i)
    {
        if (i == 4)
        {
            return new _cls02CA(LayoutInflater.from(mContext).inflate(0x7f03007a, viewgroup, false));
        } else
        {
            return super._mth02CB(viewgroup, i);
        }
    }

    public final volatile void _mth1646(String s)
    {
        s = (String)s;
        bul._mth1646(s);
    }
}
