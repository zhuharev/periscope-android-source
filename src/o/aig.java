// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package o:
//            aij, xd, aan, aim, 
//            zc, atn, atv, ato, 
//            xf, aik, ain, aui, 
//            _cls1D3C, _cls1D5A, _cls1D27, aao, 
//            _cls1647, _cls0443, aok, atw, 
//            aos, FBFF, aqx, ail

public final class aig extends android.support.v7.widget.RecyclerView.if
    implements android.view.View.OnClickListener
{
    public static interface aux
    {

        public abstract void _mth14D2(String s);
    }

    public static final class if
        implements android.view.View.OnLongClickListener
    {

        public final zc bmU;
        public final HashSet bnd = new HashSet();
        private final _cls02CA bne;
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

        public if(_cls02CA _pcls02ca, aig aig1)
        {
            bne = _pcls02ca;
            bnf = aig1;
            bmU = aig1.bmU;
        }
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class _cls02CF {}


    private final aij bmT;
    public zc bmU;
    public aux bmV;
    public _cls02CE bmW;
    public _cls02CB bmX;
    public _cls02CF bmY;
    private if bmZ;
    private int bna;
    private final aan bnb;
    private final Context mContext;

    public aig(Context context, zc zc1)
    {
        this(context, zc1, new aij(xd._mth216D()));
    }

    public aig(Context context, zc zc1, aij aij1)
    {
        mContext = context;
        bmU = zc1;
        bmT = aij1;
        if (super.ey._mth30FC())
        {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        } else
        {
            super.ez = true;
            bna = context.getResources().getInteger(0x7f0b0004);
            bnb = new aan(context);
            return;
        }
    }

    private void _mth02CA(aim aim1)
    {
        aim1 = bmU._mth144B(aim1.broadcastId);
        if (bmV != null)
        {
            bmV._mth14D2(aim1.fd());
        }
    }

    public final int getItemCount()
    {
        return bmU.v();
    }

    public final long getItemId(int i)
    {
        atv atv1 = (atv)bmU.FF89.get(i);
        if (atv1 != null)
        {
            long l1 = atv1.fZ().hashCode();
            long l = l1;
            if (atv1.ga() != null)
            {
                l = l1 + (long)atv1.ga().hashCode();
            }
            return l;
        } else
        {
            return super.getItemId(i);
        }
    }

    public final int getItemViewType(int i)
    {
        atv atv1 = (atv)bmU.FF89.get(i);
        static final class _cls1
        {

            static final int bnc[];

            static 
            {
                bnc = new int[atv.if.values().length];
                try
                {
                    bnc[atv.if.bEk.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    bnc[atv.if.bEl.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    bnc[atv.if.bEm.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
            }
        }

        switch (_cls1.bnc[atv1.fZ().ordinal()])
        {
        case 1: // '\001'
            return 4;

        case 2: // '\002'
            return 8;

        case 3: // '\003'
            return 5;
        }
        atn atn1 = bmU._mth144B(atv1.ga());
        if (atn1 == null)
        {
            return -1;
        }
        if (atn1.bDW == ato.bEd)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            return atv1.fZ() != atv.if.bEi ? 1 : 3;
        }
        if (atv1.fZ() == atv.if.bEi && atn1.bDU)
        {
            return 7;
        }
        return !atn1.eV() ? 1 : 2;
    }

    public final void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131558522: 
        case 2131558525: 
        case 2131558527: 
        case 2131558528: 
        case 2131558529: 
        case 2131558531: 
        case 2131558532: 
        case 2131558533: 
        case 2131558535: 
        case 2131558536: 
        case 2131558537: 
            break;

        case 2131558524: 
            view = (aim)view.getTag();
            view = bmU._mth144B(((aim) (view)).broadcastId);
            if (view != null && bmX != null)
            {
                bmX._mth02CE(view.id(), true);
                return;
            }
            break;

        case 2131558523: 
        case 2131558534: 
            view = (aim)view.getTag();
            view = bmU._mth144B(((aim) (view)).broadcastId);
            if (view == null)
            {
                break;
            }
            boolean flag;
            if (((atn) (view)).bDW == ato.bEd)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                if (bmX != null)
                {
                    bmX._mth1D64(view.id());
                    return;
                }
                break;
            }
            if (bmX != null)
            {
                bmX._mth02CE(view.id(), false);
                return;
            }
            break;

        case 2131558538: 
            xf._mth02CA(xf.if.aRB);
            _mth02CA((aim)view.getTag(0x7f0d008a));
            return;

        case 2131558526: 
            xf._mth02CA(xf.if.aRC);
            _mth02CA((aim)view.getTag());
            return;

        case 2131558521: 
            xf._mth02CA(xf.if.aRD);
            if (bmY != null)
            {
                bmY.cu();
                return;
            }
            break;

        case 2131558530: 
            view = (String)view.getTag();
            view = bmU._mth144B(view);
            if (view != null && bmW != null)
            {
                bmW._mth02BD(view);
            }
            break;
        }
    }

    public final void _mth02CA(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc, int i)
    {
        _pcls02cc = (aim)_pcls02cc;
        switch (_pcls02cc.getItemViewType())
        {
        default:
            return;

        case -1: 
            return;

        case 1: // '\001'
        case 2: // '\002'
            atn atn1 = bmU._mth1D49(i);
            bmT._mth02CA((aik)_pcls02cc, atn1);
            return;

        case 3: // '\003'
        case 7: // '\007'
            _pcls02cc = (ain)_pcls02cc;
            Object obj = bmU._mth1D49(i);
            if (((ain) (_pcls02cc)).broadcastId != null && ((ain) (_pcls02cc)).broadcastId.equals(((atn) (obj)).id()))
            {
                i = 1;
            } else
            {
                i = 0;
            }
            _pcls02cc.broadcastId = ((atn) (obj)).id();
            if (TextUtils.isEmpty(((atn) (obj)).eS()))
            {
                ((ain) (_pcls02cc)).bnm.setText(0x7f06016f);
            } else
            {
                ((ain) (_pcls02cc)).bnm.setText(((atn) (obj)).eS());
            }
            ((ain) (_pcls02cc)).fy.setTag(_pcls02cc);
            _pcls02cc.FB36(((atn) (obj)).bEa);
            if (((atn) (obj)).fe())
            {
                ((ain) (_pcls02cc)).bnn.setVisibility(0);
                ((ain) (_pcls02cc)).bnM.setVisibility(8);
            } else
            {
                ((ain) (_pcls02cc)).bnn.setVisibility(8);
                ((ain) (_pcls02cc)).bnM.setVisibility(0);
            }
            ((ain) (_pcls02cc)).bnp.setText(((atn) (obj)).fh());
            ((ain) (_pcls02cc)).bnp.setOnClickListener(this);
            ((ain) (_pcls02cc)).bnp.setTag(_pcls02cc);
            if (aui._mth02BF(((atn) (obj)).fi()))
            {
                _cls1D5A _lcls1d5a = _cls1D3C._mth1427(mContext);
                String s = ((atn) (obj)).fi();
                ((_cls1D27)_lcls1d5a._mth02CA(java/lang/String).FF70(s))._mth02CB(aao.baq)._mth05D5(0x7f020049)._mth02CA(new _cls0443[] {
                    bnb
                })._mth02CA(((ain) (_pcls02cc)).bnO);
            } else
            {
                aok._mth02CA(((ain) (_pcls02cc)).bnO, ((atn) (obj)).fh(), 0);
            }
            ((ain) (_pcls02cc)).bnO.setOnClickListener(this);
            ((ain) (_pcls02cc)).bnO.setTag(0x7f0d008a, _pcls02cc);
            if (((ain) (_pcls02cc)).bnR == null || !((ain) (_pcls02cc)).bnR.equals(((atn) (obj)).ff()))
            {
                _pcls02cc.bnR = ((atn) (obj)).ff();
                if (i == 0)
                {
                    ((ain) (_pcls02cc)).bnP.setImageDrawable(null);
                }
                if (aui._mth02BF(((atn) (obj)).ff()))
                {
                    _cls1D5A _lcls1d5a1 = _cls1D3C._mth1427(mContext);
                    String s1 = ((atn) (obj)).ff();
                    ((_cls1D27)_lcls1d5a1._mth02CA(java/lang/String).FF70(s1))._mth0197()._mth02CB(aao.baq)._mth02CA(((ain) (_pcls02cc)).bnP);
                }
            }
            obj = ((atn) (obj)).eT().toString();
            if (aui.isEmpty(((CharSequence) (obj))))
            {
                ((ain) (_pcls02cc)).bnN.setVisibility(8);
                return;
            } else
            {
                ((ain) (_pcls02cc)).bnN.setText(((CharSequence) (obj)));
                return;
            }

        case 5: // '\005'
        case 8: // '\b'
            _pcls02cc = (aik)_pcls02cc;
            i = bmU.w();
            ((aik) (_pcls02cc)).bnt.setText(mContext.getResources().getQuantityString(0x7f070004, i, new Object[] {
                aos._mth02CA(mContext.getResources(), i, false)
            }));
            // fall through

        case 0: // '\0'
        case 4: // '\004'
        case 6: // '\006'
            return;
        }
    }

    public final void _mth02CA(_cls02CA _pcls02ca)
    {
        if (_pcls02ca != null)
        {
            bmZ = new if(_pcls02ca, this);
            _pcls02ca._mth02CA(bmZ);
        } else
        {
            bmZ = null;
        }
        bmT.bmZ = bmZ;
    }

    public final android.support.v7.widget.RecyclerView._cls02CC _mth02CB(ViewGroup viewgroup, int i)
    {
        switch (i)
        {
        case 6: // '\006'
        default:
            FBFF fbff = new FBFF(mContext);
            fbff.setLayoutParams(viewgroup.getLayoutParams());
            return new aim(fbff);

        case 1: // '\001'
            viewgroup = new aik(LayoutInflater.from(mContext).inflate(0x7f030028, viewgroup, false));
            ((aik) (viewgroup)).bns.setVisibility(8);
            ((aik) (viewgroup)).bnr.setFeatured(false, 0);
            ((aik) (viewgroup)).bnr.setLive(false);
            ((aik) (viewgroup)).bnr.setTag(viewgroup);
            ((aik) (viewgroup)).bnr.setOnClickListener(this);
            ((aik) (viewgroup)).bnK.setVisibility(8);
            ((aik) (viewgroup)).bno.setVisibility(0);
            ((aik) (viewgroup)).fy.setTag(viewgroup);
            ((aik) (viewgroup)).fy.setOnClickListener(this);
            return viewgroup;

        case 2: // '\002'
            viewgroup = new aik(LayoutInflater.from(mContext).inflate(0x7f030028, viewgroup, false));
            ((aik) (viewgroup)).bns.setVisibility(0);
            ((aik) (viewgroup)).bnr.setFeatured(true, 0);
            ((aik) (viewgroup)).bnr.setOnClickListener(this);
            ((aik) (viewgroup)).bnr.setTag(viewgroup);
            ((aik) (viewgroup)).bnK.setVisibility(8);
            ((aik) (viewgroup)).bno.setVisibility(8);
            ((aik) (viewgroup)).fy.setTag(viewgroup);
            ((aik) (viewgroup)).fy.setOnClickListener(this);
            ((aik) (viewgroup)).bnu.setOnClickListener(this);
            return viewgroup;

        case 3: // '\003'
            viewgroup = new ain(LayoutInflater.from(mContext).inflate(0x7f030029, viewgroup, false));
            ((ain) (viewgroup)).fy.setOnClickListener(this);
            ((ain) (viewgroup)).fy.setTag(viewgroup);
            return viewgroup;

        case 7: // '\007'
            viewgroup = new ain(LayoutInflater.from(mContext).inflate(0x7f030029, viewgroup, false));
            ((ain) (viewgroup)).bnQ.setText(0x7f060115);
            ((ain) (viewgroup)).bnQ.setBackgroundResource(0x7f02007a);
            ((ain) (viewgroup)).fy.setOnClickListener(this);
            ((ain) (viewgroup)).fy.setTag(viewgroup);
            return viewgroup;

        case 4: // '\004'
            viewgroup = LayoutInflater.from(mContext).inflate(0x7f030025, viewgroup, false);
            viewgroup.findViewById(0x7f0d0079).setOnClickListener(this);
            return new aik(viewgroup);

        case 5: // '\005'
            return new aik(LayoutInflater.from(mContext).inflate(0x7f030026, viewgroup, false));

        case 8: // '\b'
            return new aik(LayoutInflater.from(mContext).inflate(0x7f030027, viewgroup, false));
        }
    }
}
