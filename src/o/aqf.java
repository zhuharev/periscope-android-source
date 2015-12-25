// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            asb, aqg, aqh, aqi, 
//            aql, aqm, aqn, xf, 
//            aqo, arz, xd, aos, 
//            aqz, arj, asj, aan, 
//            aqj, aqk, atn, ato, 
//            zp, aqe, ary, aqp, 
//            yv, zc, zs, anh, 
//            zr, aig, _cls1D3C, _cls1D5A, 
//            _cls1D27, aao, _cls1647, _cls0443, 
//            adc

public class aqf extends FrameLayout
    implements asb, android.view.View.OnClickListener, android.support.v4.view.ViewPager._cls02CF, aig._cls02CB, arz.if
{

    private static final aqg bzV = new aqg(null, -1);
    public PsUser aWS;
    private View bAA;
    private ViewPager bAB;
    private ViewGroup bAC;
    private View bAD;
    private boolean bAE;
    private arz bAF;
    private View bAG;
    private adc bAH;
    public boolean bAI;
    private final aqh bAa;
    private final aqi bAb;
    private yv bAc;
    private TextView bAd;
    private View bAe;
    private TextView bAf;
    private TextView bAg;
    private TextView bAh;
    private TextView bAi;
    private TextView bAj;
    private View bAk;
    public ImageView bAl;
    private aqo bAm;
    private aqz bAn;
    private arj bAo;
    private ImageView bAp;
    private AlertDialog bAq;
    private ArrayList bAr;
    private ArrayAdapter bAs;
    private AutoTransition bAt;
    private boolean bAu;
    private aqj bAv;
    private aqk bAw;
    private Animation bAx;
    private View bAy;
    private View bAz;
    private View beI;
    private TextView beV;
    private asj biC;
    private aan bnb;
    private TextView bsI;
    private TextView bsJ;
    public boolean buH;
    private int bzW;
    private int bzX;
    private int bzY;
    public final ArrayList bzZ;
    public zp mUserManager;
    private int _fld0575;
    private boolean _fld1EC8;

    public aqf(Context context)
    {
        super(context);
        bzW = 0;
        bzX = 1;
        bzY = 2;
        bzZ = new ArrayList(3);
        bAa = new aqh(this);
        bAb = new aqi(this);
        init(context);
    }

    public aqf(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        bzW = 0;
        bzX = 1;
        bzY = 2;
        bzZ = new ArrayList(3);
        bAa = new aqh(this);
        bAb = new aqi(this);
        init(context);
    }

    public aqf(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        bzW = 0;
        bzX = 1;
        bzY = 2;
        bzZ = new ArrayList(3);
        bAa = new aqh(this);
        bAb = new aqi(this);
        init(context);
    }

    private void em()
    {
        bAp = (ImageView)findViewById(0x7f0d0068);
        bAp.setOnClickListener(this);
        Context context = getContext();
        bAr = new ArrayList();
        bAs = new ArrayAdapter(context, 0x7f030046, bAr);
        bAq = (new android.app.AlertDialog.Builder(getContext())).setAdapter(bAs, new aql(this)).create();
    }

    private void en()
    {
        bAx = AnimationUtils.loadAnimation(getContext(), 0x7f04000b);
        bAx.setAnimationListener(new aqm(this));
        bAt = new AutoTransition();
        bAt.addListener(new aqn(this));
    }

    private boolean eo()
    {
        int j = bAC.getChildCount();
        for (int i = 0; i < j; i++)
        {
            if (bAC.getChildAt(i) == bAo)
            {
                return true;
            }
        }

        return false;
    }

    private void ep()
    {
        xf._mth02CA(xf.if.aSL);
        boolean flag;
        if (!bAE)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bAm._mth2170(aWS.id);
        if (flag)
        {
            er();
        }
    }

    private void eq()
    {
        xf._mth02CA(xf.if.aSK);
        boolean flag;
        if (!bAE)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bAm._mth2160(aWS.id);
        if (flag)
        {
            er();
        }
    }

    private void er()
    {
        boolean flag;
        if (!bAE)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bAE = flag;
        byte byte0;
        byte byte1;
        if (bAE)
        {
            byte0 = 0;
            byte1 = 8;
            beV.setTextColor(getResources().getColor(0x7f0c005a));
        } else
        {
            byte0 = 8;
            byte1 = 0;
            beV.setTextColor(getResources().getColor(0x7f0c0037));
        }
        bAk.setVisibility(byte1);
        bAe.setVisibility(byte1);
        bsJ.setVisibility(byte1);
        bAD.setVisibility(byte1);
        bAC.setVisibility(byte1);
        _mth02CA(aWS, byte1);
        bAG.setVisibility(byte0);
        bAA.setVisibility(byte0);
        bAF.setScrollVisibility(byte0);
    }

    private void init(Context context)
    {
        mUserManager = xd._mth1FEA();
        bAc = xd._mth216D();
        View view = LayoutInflater.from(context).inflate(0x7f030070, this, true);
        bAz = findViewById(0x7f0d014d);
        bAz.setOnClickListener(this);
        bAd = (TextView)view.findViewById(0x7f0d014f);
        bAd.setText(aos._mth1D37(getResources().getString(0x7f060178)));
        bAg = (TextView)view.findViewById(0x7f0d0152);
        bAh = (TextView)view.findViewById(0x7f0d0153);
        bAi = (TextView)view.findViewById(0x7f0d0155);
        bAj = (TextView)view.findViewById(0x7f0d0156);
        bsJ = (TextView)view.findViewById(0x7f0d00fd);
        beV = (TextView)view.findViewById(0x7f0d00d0);
        bAe = view.findViewById(0x7f0d00bc);
        bsI = (TextView)view.findViewById(0x7f0d00bd);
        bAD = view.findViewById(0x7f0d0150);
        bAf = (TextView)view.findViewById(0x7f0d00dc);
        bAk = view.findViewById(0x7f0d00cd);
        bAk.setOnClickListener(this);
        bAl = (ImageView)view.findViewById(0x7f0d0075);
        beI = view.findViewById(0x7f0d00b0);
        bAn = (aqz)view.findViewById(0x7f0d0158);
        bAn.setOnClickListener(this);
        bAC = (ViewGroup)view.findViewById(0x7f0d00b3);
        bAo = (arj)view.findViewById(0x7f0d0159);
        bAo.setOnClickListener(this);
        bAC.removeView(bAo);
        biC = new asj(context);
        bnb = new aan(context);
        em();
        _mth02D0(context);
        bAG = view.findViewById(0x7f0d0100);
        bAG.setOnClickListener(this);
        view.findViewById(0x7f0d0151).setOnClickListener(this);
        view.findViewById(0x7f0d0154).setOnClickListener(this);
        view.findViewById(0x7f0d0139).setOnClickListener(this);
        context = findViewById(0x7f0d014e);
        context.setOnClickListener(this);
        _fld0575 = aos._mth02B2(getContext()).y;
        bAy = context;
        bAv = new aqj(this);
        bAw = new aqk(this);
        en();
        setVisibility(8);
    }

    static PsUser _mth02BB(aqf aqf1)
    {
        return aqf1.aWS;
    }

    static aqo _mth02BC(aqf aqf1)
    {
        return aqf1.bAm;
    }

    static TextView _mth02BD(aqf aqf1)
    {
        return aqf1.bAd;
    }

    private int _mth02BE(atn atn1)
    {
        if (atn1 != null)
        {
            boolean flag;
            if (atn1.bDW == ato.bEd)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return getResources().getColor(0x7f0c0081);
            } else
            {
                return getResources().getColor(0x7f0c005a);
            }
        } else
        {
            return getResources().getColor(0x7f0c0056);
        }
    }

    static adc _mth02CA(aqf aqf1, adc adc)
    {
        aqf1.bAH = null;
        return null;
    }

    private void _mth02CA(PsUser psuser, int i)
    {
        if (psuser != null)
        {
            psuser = psuser.id;
        } else
        {
            psuser = null;
        }
        if (psuser == null || psuser.equals(xd._mth1FEA().aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVC").get(null), null)))
        {
            bAp.setVisibility(8);
            return;
        } else
        {
            bAp.setVisibility(i);
            return;
        }
    }

    static boolean _mth02CA(aqf aqf1)
    {
        return aqf1.bAI;
    }

    static boolean _mth02CA(aqf aqf1, boolean flag)
    {
        aqf1._fld1EC8 = flag;
        return flag;
    }

    static boolean _mth02CB(aqf aqf1)
    {
        return aqf1.bAE;
    }

    static boolean _mth02CB(aqf aqf1, boolean flag)
    {
        aqf1.buH = flag;
        return flag;
    }

    static void _mth02CE(aqf aqf1)
    {
        aqf1.er();
    }

    static boolean _mth02CE(aqf aqf1, boolean flag)
    {
        aqf1.bAI = false;
        return false;
    }

    static adc _mth02CF(aqf aqf1)
    {
        return aqf1.bAH;
    }

    static boolean _mth02CF(aqf aqf1, boolean flag)
    {
        aqf1.bAu = flag;
        return flag;
    }

    private void _mth02D0(Context context)
    {
        for (int i = 0; i < 3; i++)
        {
            RecyclerView recyclerview = (RecyclerView)LayoutInflater.from(getContext()).inflate(0x7f030071, null);
            bzZ.add(recyclerview);
        }

        boolean flag;
        if (context.getResources().getConfiguration().getLayoutDirection() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            int j = bzW;
            bzW = bzY;
            bzY = j;
        }
        bAF = (arz)findViewById(0x7f0d0110);
        bAF.setScrollColorProvider(this);
        bAF.setScrollVisibility(8);
        context = new aqe();
        Object obj = new ary(bAF);
        ((aqe) (context)).bzU.add(obj);
        ((aqe) (context)).bzU.add(this);
        obj = new aqp(bzZ);
        bAB = (ViewPager)findViewById(0x7f0d0116);
        bAB.setAdapter(((FB54) (obj)));
        bAB.setOnPageChangeListener(context);
        bAA = findViewById(0x7f0d0157);
    }

    static zp _mth141D(aqf aqf1)
    {
        return aqf1.mUserManager;
    }

    private void _mth1FBE(atn atn1)
    {
        if (atn1 != null)
        {
            boolean flag;
            if (atn1.bDW == ato.bEd)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                atn atn2 = (atn)bAd.getTag();
                boolean flag1;
                if (atn1 != null && atn2 != null && atn1.id().equals(atn2.id()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (!flag1)
                {
                    bAd.setTag(atn1);
                    bAd.startAnimation(bAx);
                    return;
                } else
                {
                    bAd.setVisibility(0);
                    return;
                }
            }
        }
        bAd.setTag(null);
        bAd.clearAnimation();
        bAd.setVisibility(8);
    }

    private zc _mth217C(String s)
    {
        zc zc1 = (zc)bAc.aWh.get(s);
        s = zc1;
        if (zc1 == null)
        {
            s = bzV;
        }
        return s;
    }

    public final int getColor()
    {
        if (bAB._fld025F == bzW)
        {
            Object obj;
            if (aWS == null)
            {
                obj = null;
            } else
            {
                obj = aWS.id;
            }
            obj = _mth217C(((String) (obj)));
            if (((zc) (obj)).v() > 0)
            {
                obj = ((zc) (obj))._mth1D49(0);
            } else
            {
                obj = null;
            }
            return _mth02BE(((atn) (obj)));
        } else
        {
            return getResources().getColor(0x7f0c005a);
        }
    }

    public final void hide()
    {
        _mth02CB(((adc) (null)));
    }

    public final boolean isShowing()
    {
        return buH;
    }

    public void onClick(View view)
    {
        if (bAm == null || aWS == null)
        {
            return;
        }
        switch (view.getId())
        {
        default:
            return;

        case 2131558733: 
            _mth02CB(((adc) (null)));
            return;

        case 2131558605: 
            if (bAd.getVisibility() == 0)
            {
                xf._mth02CA(xf.if.aSN);
                view = (atn)bAd.getTag();
                if (view != null)
                {
                    bAm.FE70(view.id());
                }
                return;
            }
            break;

        case 2131558744: 
            if (bAu)
            {
                break;
            }
            if (aWS.isBlocked)
            {
                bAm.FBE9(aWS.id);
                return;
            }
            if (aWS.isFollowing)
            {
                TransitionManager.beginDelayedTransition(bAC, bAt);
                bAC.removeView(bAo);
                bAm.FBE6(aWS.id);
                return;
            }
            if (!eo())
            {
                TransitionManager.beginDelayedTransition(bAC, bAt);
                bAC.addView(bAo);
            }
            bAm._mth4E36(aWS.id);
            return;

        case 2131558745: 
            asj asj1 = biC;
            boolean flag;
            if (asj1.bCP.isShowing() && asj1.av.isAttachedToWindow())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                asj asj2 = biC;
                asj2.bCO.removeMessages(100);
                asj2.bCQ.cancel();
                asj2.bCP.dismiss();
            }
            if (aWS.isMuted)
            {
                bAm.FB60(aWS.id);
                biC._mth02CA(view, getResources().getString(0x7f06010a), false);
                return;
            } else
            {
                bAm.FB54(aWS.id);
                biC._mth02CA(view, getResources().getString(0x7f060109), false);
                return;
            }

        case 2131558737: 
            bAB.setCurrentItem(bzW);
            if (bAE)
            {
                break;
            }
            xf._mth02CA(xf.if.aSJ);
            boolean flag1;
            if (!bAE)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                er();
            }
            return;

        case 2131558713: 
            bAB.setCurrentItem(bzY);
            if (!bAE)
            {
                eq();
                return;
            }
            break;

        case 2131558740: 
            bAB.setCurrentItem(bzX);
            if (!bAE)
            {
                ep();
                return;
            }
            break;

        case 2131558504: 
            if (aWS != null)
            {
                bAr.clear();
                bAr.add(0, getResources().getString(0x7f060125));
                xf._mth02CA(xf.if.aSF);
                if (aWS.isBlocked)
                {
                    bAr.add(1, getResources().getString(0x7f06012b));
                } else
                {
                    bAr.add(1, getResources().getString(0x7f06012a));
                }
                bAq.show();
            }
            return;

        case 2131558656: 
            er();
            break;
        }
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1)
        {
            bAk.setVisibility(0);
            return;
        } else
        {
            bAk.setVisibility(8);
            return;
        }
    }

    public void setDelegate(aqo aqo1)
    {
        bAm = aqo1;
        int i = 0;
        for (Iterator iterator = bzZ.iterator(); iterator.hasNext();)
        {
            RecyclerView recyclerview = (RecyclerView)iterator.next();
            zs zs1;
            if (i == bzX)
            {
                zs1 = zs.aWX;
            } else
            if (i == bzY)
            {
                zs1 = zs.aWY;
            } else
            {
                zs1 = null;
            }
            if (zs1 != null)
            {
                anh anh1 = new anh(new zr(mUserManager), aqo1);
                anh1.btU._mth02CA(zs1);
                recyclerview.setAdapter(anh1);
                recyclerview._mth02CA(bAa);
            } else
            {
                aig aig1 = new aig(getContext(), bzV);
                aig1.bmX = this;
                recyclerview.setAdapter(aig1);
                recyclerview._mth02CA(bAb);
            }
            recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
            i++;
        }

    }

    public final void show()
    {
        if (_fld1EC8)
        {
            return;
        }
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(bAz, "alpha", new float[] {
            0.0F, 0.6F
        });
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(bAy, "translationY", new float[] {
            (float)_fld0575, 0.0F
        });
        Object obj = getContext();
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            obj = AnimationUtils.loadInterpolator(((Context) (obj)), 0x10c000e);
        } else
        {
            obj = AnimationUtils.loadInterpolator(((Context) (obj)), 0x10c0003);
        }
        objectanimator1.setInterpolator(((android.animation.TimeInterpolator) (obj)));
        objectanimator1.addListener(bAv);
        obj = new AnimatorSet();
        ((AnimatorSet) (obj)).play(objectanimator1).with(objectanimator);
        ((AnimatorSet) (obj)).start();
    }

    public final void _mth02CA(int i, float f, int j)
    {
    }

    public final void _mth02CB(adc adc)
    {
        if (_fld1EC8)
        {
            return;
        }
        bAH = adc;
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(bAz, "alpha", new float[] {
            0.6F, 0.0F
        });
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(bAy, "translationY", new float[] {
            0.0F, (float)_fld0575
        });
        adc = getContext();
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            adc = AnimationUtils.loadInterpolator(adc, 0x10c000d);
        } else
        {
            adc = AnimationUtils.loadInterpolator(adc, 0x10c0006);
        }
        objectanimator1.setInterpolator(adc);
        objectanimator1.addListener(bAw);
        adc = new AnimatorSet();
        adc.play(objectanimator1).with(objectanimator);
        adc.start();
    }

    public final void _mth02CE(String s, boolean flag)
    {
        xf._mth02CA(xf.if.aSO);
        if (bAm != null)
        {
            bAm.FE97(s);
        }
    }

    public final void _mth02CF(PsUser psuser)
    {
        if (psuser == null)
        {
            return;
        }
        _mth02CA(psuser, 0);
        beV.setText(psuser.displayName);
        bsI.setText(getContext().getString(0x7f060171, new Object[] {
            psuser.username
        }));
        bAf.setText(aos._mth02CA(getResources(), psuser.getNumHearts(), false));
        bsJ.setText(psuser.description);
        bAi.setText(aos._mth02CA(getResources(), psuser.numFollowers, true));
        bAj.setText(aos._mth02CA(getResources(), psuser.numFollowing, true));
        if (psuser.isVerified)
        {
            beI.setVisibility(0);
        } else
        {
            beI.setVisibility(8);
        }
        int i;
        if (psuser.id.equals(xd._mth1FEA().aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVC").get(null), null)))
        {
            i = aqz.if.bBb;
        } else
        if (psuser.isBlocked)
        {
            i = aqz.if.bBa;
        } else
        if (psuser.isFollowing)
        {
            i = aqz.if.bAZ;
        } else
        {
            i = aqz.if.bAY;
        }
        bAn.setState$65a6ccda(i);
        if (psuser.isFollowing)
        {
            int j;
            if (psuser.isMuted)
            {
                j = arj.if.bBx;
            } else
            {
                j = arj.if.bBy;
            }
            bAo.setState$492def32(j);
            if (!eo())
            {
                bAC.addView(bAo);
            }
        } else
        {
            bAC.removeView(bAo);
        }
        if (aWS == null || aWS.getProfileUrlLarge() == null || !aWS.getProfileUrlLarge().equals(psuser.getProfileUrlLarge()))
        {
            _cls1D5A _lcls1d5a = _cls1D3C._mth1427(getContext());
            String s = psuser.getProfileUrlLarge();
            ((_cls1D27)_lcls1d5a._mth02CA(java/lang/String).FF70(s))._mth02CB(aao.baq)._mth05D5(0x7f0c00a4)._mth02CA(new _cls0443[] {
                bnb
            })._mth0197()._mth02CA(bAl);
        }
        aWS = psuser;
        _mth1D4F(aWS.id);
    }

    public final void _mth0640(int i)
    {
        if (bAm == null || aWS == null)
        {
            return;
        }
        if (i == bzW)
        {
            xf._mth02CA(xf.if.aSJ);
            if (!bAE)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                er();
            }
            return;
        }
        if (i == bzX)
        {
            ep();
            return;
        }
        if (i == bzY)
        {
            eq();
        }
    }

    public final void _mth1427(int i)
    {
    }

    public void _mth1D4F(String s)
    {
        Iterator iterator = bzZ.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            android.support.v7.widget.RecyclerView.if if1 = ((RecyclerView)iterator.next()).dF;
            if (if1 != null)
            {
                if (if1 instanceof anh)
                {
                    ((anh)if1).btU._mth1550(s);
                } else
                {
                    FB58(s);
                }
                if1.ey.notifyChanged();
            }
        } while (true);
    }

    public final void _mth1D64(String s)
    {
        xf._mth02CA(xf.if.aSO);
        if (bAm != null)
        {
            bAm.FE70(s);
        }
    }

    public void FB58(String s)
    {
        aig aig1 = (aig)((RecyclerView)bzZ.get(bzW)).dF;
        zc zc1 = _mth217C(s);
        aig1.bmU = zc1;
        if (zc1.v() > 0)
        {
            s = zc1._mth1D49(0);
        } else
        {
            s = null;
        }
        int i = _mth02BE(s);
        _mth1FBE(s);
        bAg.setTextColor(i);
        bAg.setText(aos._mth02CA(getResources(), zc1.v(), true));
        bAh.setTextColor(i);
    }

}
