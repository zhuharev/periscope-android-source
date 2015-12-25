// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

// Referenced classes of package o:
//            afn, asj, arc, anq, 
//            xf, aak, arv, aec

public class afo
    implements afn, android.view.View.OnClickListener, ans.if
{

    private static final ArrayList biB = new ArrayList();
    private final aak bgM;
    protected final asj biC;
    private final TextView biD;
    final TextView biE;
    private final arc biF;
    private final arc biG;
    private final anq biH;
    private final arv biI;
    private final ArrayList biJ = new ArrayList();
    afn.if biK;
    protected final Activity mActivity;

    public afo(Activity activity, TextView textview, TextView textview1, arc arc1, arc arc2, arv arv1, aak aak1, 
            anq anq1)
    {
        mActivity = activity;
        biF = arc1;
        biD = textview;
        biE = textview1;
        biI = arv1;
        biG = arc2;
        bgM = aak1;
        biH = anq1;
        biC = new asj(activity);
        textview = biC;
        int i = activity.getResources().getDimensionPixelSize(0x7f0900ac);
        ((asj) (textview)).av.setMaxWidth(i);
        biF.setOnClickListener(this);
        biD.setOnClickListener(this);
        biE.setOnClickListener(this);
        biG.setOnClickListener(this);
        biH._mth02CA(this);
    }

    private void bJ()
    {
        if (biF.isActivated())
        {
            xf._mth02CA(xf.if.aSk);
            bgM.S();
            biI.start();
            return;
        } else
        {
            xf._mth02CA(xf.if.aSl);
            arv arv1 = biI;
            arv1.bBR.cancel();
            arv1.bBS.cancel();
            arv1.setVisibility(8);
            bgM.T();
            return;
        }
    }

    private void _mth02BE(ArrayList arraylist)
    {
        boolean flag;
        if (!arraylist.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        biE.setActivated(flag);
        TextView textview = biD;
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        textview.setActivated(flag1);
        if (flag)
        {
            bK();
            biE.setText(mActivity.getString(0x7f060058, new Object[] {
                Integer.valueOf(arraylist.size())
            }));
            return;
        } else
        {
            bL();
            biE.setText(0x7f060057);
            return;
        }
    }

    public final boolean bF()
    {
        Activity activity = (Activity)bgM.bai.get();
        boolean flag;
        if (activity != null)
        {
            flag = _cls141D.if._mth02CA(activity, aak.bah);
        } else
        {
            flag = false;
        }
        return flag && biF.isActivated();
    }

    public final ArrayList bG()
    {
        if (biE.isActivated())
        {
            return biJ;
        } else
        {
            return biB;
        }
    }

    public aec bH()
    {
        return new aec(bF(), bI(), false);
    }

    protected final boolean bI()
    {
        return !biE.isActivated() && biG.getVisibility() == 0 && biG.isActivated();
    }

    protected void bK()
    {
        biG.setVisibility(8);
    }

    protected void bL()
    {
        biG.setVisibility(0);
    }

    public void onClick(View view)
    {
        if (view == biF)
        {
            view = (Activity)bgM.bai.get();
            boolean flag1;
            if (view != null)
            {
                flag1 = _cls141D.if._mth02CA(view, aak.bah);
            } else
            {
                flag1 = false;
            }
            if (!flag1)
            {
                view = bgM;
                Activity activity = (Activity)((aak) (view)).bai.get();
                boolean flag;
                if (activity != null && _cls141D.if._mth02CB(activity, aak.bah))
                {
                    ((aak) (view)).bam._mth141D(aak.bah);
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    _mth02B8(true);
                    return;
                }
            }
            _mth02CA(biF, false);
            bJ();
            return;
        }
        if (view == biD)
        {
            _mth02BE(biB);
            biK._mth037A(biB);
            biH.clear();
            return;
        }
        if (view == biE)
        {
            xf._mth02CA(xf.if.aSD);
            biH.show();
            return;
        }
        if (view == biG)
        {
            _mth02CA(biG, false);
        }
    }

    public final void _mth02B8(boolean flag)
    {
        arc arc1 = biF;
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        arc1.setActivated(flag1);
        float f;
        if (flag1)
        {
            f = 1.0F;
        } else
        {
            f = 0.3F;
        }
        arc1.setAlpha(f);
        bJ();
        if (flag)
        {
            Toast.makeText(mActivity, 0x7f0600e4, 1).show();
        }
    }

    protected final void _mth02CA(arc arc1, boolean flag)
    {
        boolean flag2;
        if (!arc1.isActivated())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        arc1.setActivated(flag2);
        float f;
        if (flag2)
        {
            f = 1.0F;
        } else
        {
            f = 0.3F;
        }
        arc1.setAlpha(f);
        asj asj1 = biC;
        boolean flag1;
        if (asj1.bCP.isShowing() && asj1.av.isAttachedToWindow())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            asj asj2 = biC;
            asj2.bCO.removeMessages(100);
            asj2.bCQ.cancel();
            asj2.bCP.dismiss();
        }
        if (flag2)
        {
            biC._mth02CA(arc1, mActivity.getString(arc1.bBh), flag);
            return;
        } else
        {
            biC._mth02CA(arc1, mActivity.getString(arc1.bBi), flag);
            return;
        }
    }

    public void _mth02CB(aec aec1)
    {
        arc arc1;
        boolean flag;
label0:
        {
            arc1 = biF;
            if (aec1.bgm)
            {
                Activity activity = (Activity)bgM.bai.get();
                if (activity != null)
                {
                    flag = _cls141D.if._mth02CA(activity, aak.bah);
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    flag = true;
                    break label0;
                }
            }
            flag = false;
        }
        arc1.setActivated(flag);
        float f;
        if (flag)
        {
            f = 1.0F;
        } else
        {
            f = 0.3F;
        }
        arc1.setAlpha(f);
        bJ();
        arc1 = biG;
        flag = aec1.bgn;
        arc1.setActivated(flag);
        if (flag)
        {
            f = 1.0F;
        } else
        {
            f = 0.3F;
        }
        arc1.setAlpha(f);
        _mth02BE(biB);
    }

    public final void _mth1FBE(ArrayList arraylist)
    {
        biJ.clear();
        biJ.addAll(arraylist);
        _mth02BE(biJ);
        if (biK != null)
        {
            biK._mth037A(biJ);
        }
    }

}
