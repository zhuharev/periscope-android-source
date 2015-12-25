// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.util.Set;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            asn, xd, zp, aik, 
//            atn, ato, ail, aqx, 
//            aos, aui, _cls1D3C, _cls1D5A, 
//            _cls1D27, aao, _cls1647, atw, 
//            yv

public final class aij
    implements asn
{

    aig.if bmZ;
    private int bna;
    private final boolean bnh;
    private final boolean bni;
    private final String bnj;
    private int bnk;
    private int bnl;
    private final yv mBroadcastCacheManager;

    public aij(yv yv1)
    {
        this(yv1, false, false);
    }

    public aij(yv yv1, boolean flag, boolean flag1)
    {
        bna = -1;
        mBroadcastCacheManager = yv1;
        bnh = flag;
        bni = flag1;
        bnj = xd._mth1FEA().aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVC").get(null), null);
    }

    public final volatile void _mth02CA(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc, PsUser psuser, int i)
    {
        _mth02CA((aik)_pcls02cc, (atn)psuser);
    }

    public final void _mth02CA(aik aik1, atn atn1)
    {
        Resources resources;
        Context context;
        boolean flag;
        boolean flag1;
        boolean flag2;
label0:
        {
            context = aik1.fy.getContext();
            resources = context.getResources();
            if (bna == -1)
            {
                bna = resources.getInteger(0x7f0b0004);
            }
            aik1.bnu.setVisibility(8);
            if (bnk == 0)
            {
                bnk = context.getResources().getDimensionPixelSize(0x7f0900a1);
            }
            if (bnl == 0)
            {
                bnl = context.getResources().getDimensionPixelOffset(0x7f0900a3);
            }
            if (aik1.broadcastId != null && aik1.broadcastId.equals(atn1.id()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            aik1.broadcastId = atn1.id();
            if (TextUtils.isEmpty(atn1.eS()))
            {
                aik1.bnm.setText(0x7f06016f);
            } else
            {
                aik1.bnm.setText(atn1.eS());
            }
            if (atn1.fe())
            {
                aik1.bnn.setVisibility(0);
            } else
            {
                aik1.bnn.setVisibility(8);
            }
            aik1.bnu.setVisibility(8);
            if (aik1.bnv.getPaddingBottom() == 0)
            {
                aik1.bnv.setPadding(0, bnk, 0, bnk);
            }
            if (aik1.bnq.getPaddingEnd() == 0)
            {
                aik1.bnq.setPadding(bnl, 0, bnl, 0);
            }
            if (atn1.bDW == ato.bEd)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                aik1.FB36(atn1.bEa);
                aik1.bno.setVisibility(8);
                aik1.bnr.setLive(true);
            } else
            {
                if (atn1.eV())
                {
                    int j = adt._cls02CE.parseColor(atn1.eX());
                    aik1.bns.setCategoryColor(j);
                    aik1.bns.setCategory(atn1.eW());
                    aik1.bnr.setFeatured(true, j);
                    String s = atn1.eY();
                    aik1.bno.setVisibility(8);
                    if (TextUtils.isEmpty(s))
                    {
                        aik1.bnq.setVisibility(8);
                    } else
                    {
                        aik1.bnq.setVisibility(0);
                        aik1.bnq.setText(s);
                        aik1.bnq.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                        aik1.bnu.setVisibility(0);
                        aik1.bnu.setTag(atn1.id());
                        aik1.bnv.setPadding(0, bnk, 0, 0);
                        aik1.bnq.setPadding(bnl, 0, 0, bnk);
                    }
                } else
                {
                    aik1.bno.setVisibility(0);
                    aik1.bno.setText(aos._mth02CA(context, atn1.eU()));
                    aik1.bnr.setFeatured(false, 0);
                }
                aik1.bnK.setVisibility(8);
                aik1.bnr.setLive(false);
            }
            flag2 = atn1.bDX;
            if (!flag1)
            {
                if (bmZ != null)
                {
                    aig.if if1 = bmZ;
                    String s2 = atn1.id();
                    if (if1.bnd.contains(s2))
                    {
                        aik1.bnr.setDeleteEnabled(true);
                        aik1.bnr.setReplayEnabled(false);
                        break label0;
                    }
                }
                aik1.bnr.setDeleteEnabled(false);
                aik1.bnr.setReplayEnabled(flag2);
            } else
            {
                aik1.bnr.setDeleteEnabled(false);
                aik1.bnr.setReplayEnabled(false);
            }
        }
        aik1.bnp.setText(atn1.fh());
        if (flag1 || atn1.bDU || flag2)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        aik1.bnr.setEnabled(flag2);
        if (bmZ != null)
        {
            aik1.fy.setOnLongClickListener(bmZ);
        }
        if (aik1.bnw == null || !aik1.bnw.equals(atn1.fg()))
        {
            aik1.bnw = atn1.fg();
            if (!flag)
            {
                aik1.bnr.bnH.setImageDrawable(null);
            }
            if (aui._mth02BF(atn1.fg()))
            {
                _cls1D5A _lcls1d5a = _cls1D3C._mth1427(context);
                String s3 = atn1.fg();
                ((_cls1D27)_lcls1d5a._mth02CA(java/lang/String).FF70(s3))._mth02E3(bna)._mth02CB(aao.baq)._mth02CA(aik1.bnr.bnH);
            }
        }
        if (atn1.eV())
        {
            return;
        }
        if (bnh && atn1.bu())
        {
            aik1.bnq.setText(atn1.eT().toString());
            aik1.bnq.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            aik1.bnq.setVisibility(0);
            return;
        }
        String s1 = mBroadcastCacheManager._mth05F2(atn1.id());
        if (bni && !atn1.fd().equals(bnj) && aui._mth02BF(s1))
        {
            aik1.bnq.setText(context.getString(0x7f06005a, new Object[] {
                s1
            }));
            atn1 = resources.getDrawable(0x7f0200f6);
            atn1.setColorFilter(resources.getColor(0x7f0c0056), android.graphics.PorterDuff.Mode.SRC_ATOP);
            aik1.bnq.setCompoundDrawablesWithIntrinsicBounds(atn1, null, null, null);
            int i = resources.getDimensionPixelOffset(0x7f0900a0);
            aik1.bnq.setCompoundDrawablePadding(i);
            aik1.bnq.setVisibility(0);
            return;
        } else
        {
            aik1.bnq.setVisibility(8);
            return;
        }
    }
}
