// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collection;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            anz, ann, aop, zq, 
//            xd, anv, aos, ant, 
//            anu, anw, zs

public class ans extends RelativeLayout
    implements android.view.View.OnClickListener, anz, ann.if
{
    public static interface if
    {

        public abstract void _mth1FBE(ArrayList arraylist);
    }


    public static final ArrayList biB = new ArrayList();
    public int buA;
    public int buB;
    public int buC;
    public boolean buD;
    public int buE;
    public if buF;
    public ann buG;
    public boolean buH;
    ant buI;
    private anu buJ;
    private zq but;
    public TextView buu;
    public TextView buv;
    public EditText buw;
    private ImageView bux;
    private ImageView buy;
    private TextView buz;
    int _fld0575;
    boolean _fld1EC8;

    public ans(Context context)
    {
        super(context);
        init(context);
    }

    public ans(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init(context);
    }

    public ans(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init(context);
    }

    private void dB()
    {
        ((android.support.v7.widget.RecyclerView.if) (buG)).ey.notifyChanged();
        FBE7(buG.bul.dl().size());
        EditText edittext = buw;
        if (edittext != null)
        {
            ((InputMethodManager)edittext.getContext().getSystemService("input_method")).hideSoftInputFromWindow(edittext.getWindowToken(), 0);
        }
    }

    private void dx()
    {
        buu.setVisibility(0);
        buv.setVisibility(0);
        buw.setVisibility(8);
        buw.setText("");
        buw.clearFocus();
        buy.setImageResource(0x7f0200da);
        bux.setImageResource(0x7f020020);
        EditText edittext = buw;
        if (edittext != null)
        {
            ((InputMethodManager)edittext.getContext().getSystemService("input_method")).hideSoftInputFromWindow(edittext.getWindowToken(), 0);
        }
    }

    private void dz()
    {
        buG.bul.dj();
        ((android.support.v7.widget.RecyclerView.if) (buG)).ey.notifyChanged();
        FBE7(buG.bul.dl().size());
        EditText edittext = buw;
        if (edittext != null)
        {
            ((InputMethodManager)edittext.getContext().getSystemService("input_method")).hideSoftInputFromWindow(edittext.getWindowToken(), 0);
        }
        if (buF != null)
        {
            buF._mth1FBE(biB);
        }
        aN();
    }

    private void init(Context context)
    {
        LayoutInflater.from(context).inflate(0x7f030091, this, true);
        buu = (TextView)findViewById(0x7f0d0037);
        buv = (TextView)findViewById(0x7f0d00fd);
        buw = (EditText)findViewById(0x7f0d0184);
        but = new zq(xd._mth1FEA());
        buG = new ann(context, but, this);
        buw.addTextChangedListener(new anv(this));
        context = (RecyclerView)findViewById(0x7f0d0067);
        context.setLayoutManager(new LinearLayoutManager(getContext()));
        context.setAdapter(buG);
        bux = (ImageView)findViewById(0x7f0d01b1);
        bux.setOnClickListener(this);
        buy = (ImageView)findViewById(0x7f0d01b0);
        buy.setOnClickListener(this);
        buz = (TextView)findViewById(0x7f0d01b2);
        buz.setOnClickListener(this);
        _fld0575 = aos._mth02B2(getContext()).y;
        buI = new ant(this);
        buJ = new anu(this);
        setVisibility(8);
        super.setOnClickListener(this);
    }

    static EditText _mth02CA(ans ans1)
    {
        return ans1.buw;
    }

    static boolean _mth02CA(ans ans1, boolean flag)
    {
        ans1._fld1EC8 = flag;
        return flag;
    }

    static ann _mth02CB(ans ans1)
    {
        return ans1.buG;
    }

    static boolean _mth02CB(ans ans1, boolean flag)
    {
        ans1.buH = flag;
        return flag;
    }

    static void _mth02CE(ans ans1)
    {
        ans1.dz();
    }

    public void aN()
    {
        if (_fld1EC8)
        {
            return;
        }
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(this, "translationY", new float[] {
            0.0F, (float)_fld0575
        });
        Object obj = getContext();
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            obj = AnimationUtils.loadInterpolator(((Context) (obj)), 0x10c000d);
        } else
        {
            obj = AnimationUtils.loadInterpolator(((Context) (obj)), 0x10c0006);
        }
        objectanimator.setInterpolator(((android.animation.TimeInterpolator) (obj)));
        objectanimator.addListener(buJ);
        obj = new AnimatorSet();
        ((AnimatorSet) (obj)).play(objectanimator);
        ((AnimatorSet) (obj)).start();
    }

    ArrayList dA()
    {
        if (buG.bul.dl().isEmpty())
        {
            return biB;
        } else
        {
            return new ArrayList(buG.bul.dl());
        }
    }

    public void dy()
    {
        (new android.app.AlertDialog.Builder(getContext())).setMessage(getContext().getString(buC)).setNegativeButton(0x7f0600bf, null).setPositiveButton(0x7f0600c0, new anw(this)).show();
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131558832: 
            boolean flag;
            if (buw.getVisibility() == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                dx();
                return;
            }
            if (buD && buC != 0)
            {
                dy();
                return;
            }
            buG.bul.dj();
            ((android.support.v7.widget.RecyclerView.if) (buG)).ey.notifyChanged();
            FBE7(buG.bul.dl().size());
            view = buw;
            if (view != null)
            {
                ((InputMethodManager)view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
            if (buF != null)
            {
                buF._mth1FBE(biB);
            }
            aN();
            return;

        case 2131558834: 
            if (buF != null)
            {
                buF._mth1FBE(dA());
            }
            aN();
            return;

        case 2131558833: 
            break;
        }
        boolean flag1;
        if (buw.getVisibility() == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            dx();
            return;
        }
        buu.setVisibility(8);
        buv.setVisibility(8);
        buw.setVisibility(0);
        buw.setText("");
        buw.requestFocus();
        buy.setImageResource(0x7f0200d0);
        bux.setImageResource(0x7f0200da);
        view = buw;
        if (view != null)
        {
            ((InputMethodManager)view.getContext().getSystemService("input_method")).showSoftInput(view, 1);
        }
    }

    public void setUserType(zs zs)
    {
        zq zq1 = but;
        zq1.aWV = zs;
        zq1.aWU.aWT = zs;
    }

    public final void _mth02CA(boolean flag, PsUser psuser)
    {
        ann ann1 = buG;
        psuser = psuser.id;
        ann1.bul._mth1646(psuser);
        dB();
    }

    public final void _mth02CE(PsUser psuser)
    {
        ann ann1 = buG;
        psuser = psuser.id;
        ann1.bul._mth1646(psuser);
        ((android.support.v7.widget.RecyclerView.if) (buG)).ey.notifyChanged();
        FBE7(buG.bul.dl().size());
        psuser = buw;
        if (psuser != null)
        {
            ((InputMethodManager)psuser.getContext().getSystemService("input_method")).hideSoftInputFromWindow(psuser.getWindowToken(), 0);
        }
    }

    public final void _mth02E4(boolean flag)
    {
        if (flag)
        {
            buG.selectAll();
        } else
        {
            buG.bul.dj();
        }
        ((android.support.v7.widget.RecyclerView.if) (buG)).ey.notifyChanged();
        FBE7(buG.bul.dl().size());
        EditText edittext = buw;
        if (edittext != null)
        {
            ((InputMethodManager)edittext.getContext().getSystemService("input_method")).hideSoftInputFromWindow(edittext.getWindowToken(), 0);
        }
    }

    public void FBE7(int i)
    {
        if (i == 0)
        {
            buz.setVisibility(8);
            return;
        }
        buz.setVisibility(0);
        if (buD)
        {
            buz.setText(getContext().getString(buB, new Object[] {
                Integer.valueOf(i)
            }));
            return;
        } else
        {
            buz.setText(getContext().getString(buA, new Object[] {
                Integer.valueOf(i)
            }));
            return;
        }
    }

}
