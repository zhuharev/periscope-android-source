// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package o:
//            adw, adt, adr, adk, 
//            ada

public final class adj extends android.support.v7.widget.RecyclerView.if
    implements zg.if
{

    private final adk bej;
    private final adw bes;
    final ArrayList bet = new ArrayList(1);
    private final Context mContext;

    public adj(ada ada, adw adw1, adk adk)
    {
        mContext = ada;
        bes = adw1;
        bes.bfD = this;
        bej = adk;
    }

    public final int getItemCount()
    {
        return bes.v();
    }

    public final int getItemViewType(int i)
    {
        return ((adt)bes.bfz.get(i)).bc() - 1;
    }

    public final void onDataSetChanged()
    {
    }

    public final void _mth02CA(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc, int i)
    {
        ((adr)_pcls02cc)._mth02CA((adt)bes.bfz.get(i));
    }

    public final android.support.v7.widget.RecyclerView._cls02CC _mth02CB(ViewGroup viewgroup, int i)
    {
        i = adt._cls02BD.be()[i];
        static final class _cls1
        {

            static final int beu[];

            static 
            {
                beu = new int[adt._cls02BD.be().length];
                int ai[];
                int k;
                try
                {
                    ai = beu;
                    int j = adt._cls02BD.bfn;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    continue; /* Loop/switch isn't completed */
                }
                ai[0] = 1;
_L8:
                ai = beu;
                k = adt._cls02BD.bfu;
                ai[7] = 2;
_L1:
                ai = beu;
                k = adt._cls02BD.bfo;
                ai[1] = 3;
_L2:
                ai = beu;
                k = adt._cls02BD.bfp;
                ai[2] = 4;
_L3:
                ai = beu;
                k = adt._cls02BD.bfq;
                ai[3] = 5;
_L4:
                ai = beu;
                k = adt._cls02BD.bfr;
                ai[4] = 6;
_L5:
                ai = beu;
                k = adt._cls02BD.bfs;
                ai[5] = 7;
_L6:
                ai = beu;
                k = adt._cls02BD.bft;
                ai[6] = 8;
                break MISSING_BLOCK_LABEL_140;
                NoSuchFieldError nosuchfielderror1;
                nosuchfielderror1;
                  goto _L1
                nosuchfielderror1;
                  goto _L2
                nosuchfielderror1;
                  goto _L3
                nosuchfielderror1;
                  goto _L4
                nosuchfielderror1;
                  goto _L5
                nosuchfielderror1;
                  goto _L6
                nosuchfielderror1;
                if (true) goto _L8; else goto _L7
_L7:
            }
        }

        switch (_cls1.beu[i - 1])
        {
        case 1: // '\001'
            return adr._cls02CA._mth02CB(mContext, viewgroup, bej);

        case 2: // '\002'
            Context context = mContext;
            adk adk = bej;
            return new adr._cls02CB(LayoutInflater.from(context).inflate(0x7f03004a, viewgroup, false), adk);

        case 3: // '\003'
            Context context1 = mContext;
            adk adk1 = bej;
            viewgroup = new adr._cls02CF(LayoutInflater.from(context1).inflate(0x7f030021, viewgroup, false), adk1);
            bet.add(((adr._cls02CF) (viewgroup)).beM);
            return viewgroup;

        case 4: // '\004'
            return adr.if._mth02CA(mContext, viewgroup, bej);

        case 5: // '\005'
            Context context2 = mContext;
            adk adk2 = bej;
            return new adr._cls02CE(LayoutInflater.from(context2).inflate(0x7f03001f, viewgroup, false), adk2);

        case 6: // '\006'
            return adr._cls02BB._mth02CE(mContext, viewgroup, bej);

        case 7: // '\007'
            Context context3 = mContext;
            adk adk3 = bej;
            return new adr._cls141D(LayoutInflater.from(context3).inflate(0x7f030023, viewgroup, false), adk3);

        case 8: // '\b'
            Context context4 = mContext;
            adk adk4 = bej;
            return new adr.aux(LayoutInflater.from(context4).inflate(0x7f030022, viewgroup, false), adk4);
        }
        throw new UnsupportedOperationException("Unsupported view type");
    }

    public final void _mth2071(int i, int j)
    {
        super.ey._mth1D4E(i, 1);
    }

    public final void FE76(int i, int j)
    {
    }

    public final void FE7A(int i, int j)
    {
    }
}
