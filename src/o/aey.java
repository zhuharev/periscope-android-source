// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package o:
//            afd, aqd, aez, afa, 
//            afb, afc, aok, _cls1D3C, 
//            _cls1D5A, _cls1D27, aao, _cls1647

public class aey extends RelativeLayout
    implements android.view.View.OnFocusChangeListener
{
    public static final class if extends Enum
    {

        public static final int bij = 1;
        public static final int bik = 2;
        public static final int bil = 3;
        public static final int bim = 4;
        private static final int bin[] = {
            1, 2, 3, 4
        };

        public static int[] bD()
        {
            return (int[])bin.clone();
        }

    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}


    private View bhS;
    EditText bhT;
    int bhU;
    ArrayList bhV;
    private _cls02CB bhW;
    View bhX;
    private TextView bhY;
    private View bhZ;
    private int bia;
    AlertDialog bib;
    private TextView bic;
    private TextView bid;
    private aqd bie;
    private View bif;
    private View _fld057D;

    public aey(Context context)
    {
        super(context);
        bhV = new ArrayList();
        init(context);
    }

    public aey(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        bhV = new ArrayList();
        init(context);
    }

    public aey(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        bhV = new ArrayList();
        init(context);
    }

    private void bC()
    {
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(bhX, View.ALPHA, new float[] {
            0.0F, 1.0F
        });
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(bif, View.ALPHA, new float[] {
            1.0F, 0.0F
        });
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.play(objectanimator).with(objectanimator1);
        animatorset.addListener(new afd(this));
        animatorset.start();
    }

    private void init(Context context)
    {
        LayoutInflater.from(context).inflate(0x7f030032, this, true);
        _fld057D = findViewById(0x7f0d00b5);
        bhS = findViewById(0x7f0d00b4);
        bif = findViewById(0x7f0d00b9);
        bhT = (EditText)findViewById(0x7f0d00ba);
        bhT.setFilters(new InputFilter[] {
            new android.text.InputFilter.LengthFilter(100)
        });
        bie = (aqd)findViewById(0x7f0d008a);
        float f = getResources().getDimension(0x7f09005a);
        boolean flag;
        if (getContext().getResources().getConfiguration().getLayoutDirection() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            bie.setCornerRadius(new float[] {
                0.0F, f, f, 0.0F
            });
        } else
        {
            bie.setCornerRadius(new float[] {
                f, 0.0F, 0.0F, f
            });
        }
        bhX = findViewById(0x7f0d00b6);
        bhY = (TextView)findViewById(0x7f0d00b7);
        bhX.setOnClickListener(new aez(this));
        bhZ = findViewById(0x7f0d00b8);
        findViewById(0x7f0d00b3).setOnClickListener(new afa(this));
        bhU = _cls02CA.bio;
        bhT.setOnFocusChangeListener(this);
        context = new afb(this);
        bhT.addTextChangedListener(context);
        context = LayoutInflater.from(getContext()).inflate(0x7f030036, this, false);
        bic = (TextView)context.findViewById(0x7f0d0037);
        bid = (TextView)context.findViewById(0x7f0d00c6);
        bib = (new android.app.AlertDialog.Builder(getContext())).setView(context).create();
    }

    static View _mth02BB(aey aey1)
    {
        return aey1.bif;
    }

    static int _mth02CA(aey aey1)
    {
        return aey1.bia;
    }

    static void _mth02CA(aey aey1, int i, int j)
    {
        aey1.bic.setText(i);
        aey1.bid.setText(j);
        aey1.bib.show();
    }

    static int _mth02CB(aey aey1)
    {
        return aey1.bhU;
    }

    static EditText _mth02CE(aey aey1)
    {
        return aey1.bhT;
    }

    static _cls02CB _mth02CF(aey aey1)
    {
        return aey1.bhW;
    }

    static View _mth141D(aey aey1)
    {
        return aey1.bhX;
    }

    void bA()
    {
        bhU = _cls02CA.bio;
        EditText edittext = bhT;
        if (edittext != null)
        {
            ((InputMethodManager)edittext.getContext().getSystemService("input_method")).hideSoftInputFromWindow(edittext.getWindowToken(), 0);
        }
        bC();
        bhS.setVisibility(8);
        _fld057D.setVisibility(8);
    }

    final void bB()
    {
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(bhX, View.ALPHA, new float[] {
            1.0F, 0.0F
        });
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(bif, View.ALPHA, new float[] {
            0.0F, 1.0F
        });
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.play(objectanimator).with(objectanimator1);
        animatorset.addListener(new afc(this));
        animatorset.start();
    }

    public void onFocusChange(View view, boolean flag)
    {
        int i;
        switch (view.getId())
        {
        case 2131558586: 
            if (flag)
            {
                EditText edittext = bhT;
                if (edittext != null)
                {
                    ((InputMethodManager)edittext.getContext().getSystemService("input_method")).showSoftInput(edittext, 1);
                }
                setCommentSendOrClose();
            } else
            {
                bA();
            }
            // fall through

        default:
            i = bhV.size() - 1;
            break;
        }
        for (; i >= 0; i--)
        {
            ((android.view.View.OnFocusChangeListener)bhV.get(i)).onFocusChange(view, flag);
        }

    }

    public void setChatState$2bba3bc2(int i)
    {
        if (bia != i)
        {
            bia = i;
            static final class _cls1
            {

                static final int bih[];
                static final int bii[];

                static 
                {
                    bii = new int[_cls02CA.bE().length];
                    int ai[];
                    int k;
                    try
                    {
                        ai = bii;
                        int j = _cls02CA.bip;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    ai[1] = 1;
_L6:
                    ai = bii;
                    k = _cls02CA.biq;
                    ai[2] = 2;
_L1:
                    bih = new int[if.bD().length];
                    ai = bih;
                    k = if.bil;
                    ai[2] = 1;
_L2:
                    ai = bih;
                    k = if.bim;
                    ai[3] = 2;
_L3:
                    ai = bih;
                    k = if.bik;
                    ai[1] = 3;
_L4:
                    ai = bih;
                    k = if.bij;
                    ai[0] = 4;
                    break MISSING_BLOCK_LABEL_112;
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
                    if (true) goto _L6; else goto _L5
_L5:
                }
            }

            switch (_cls1.bih[i - 1])
            {
            default:
                return;

            case 1: // '\001'
                bhY.setText(0x7f06005c);
                bhZ.setVisibility(8);
                return;

            case 4: // '\004'
                bhY.setText(0x7f060080);
                bhZ.setVisibility(8);
                return;

            case 3: // '\003'
                bhY.setText(0x7f06007f);
                bhZ.setVisibility(0);
                return;

            case 2: // '\002'
                bhY.setText(0x7f060051);
                bhZ.setVisibility(8);
                break;
            }
        }
    }

    public void setCommentSendOrClose()
    {
        if (bhT.length() > 0)
        {
            bhU = _cls02CA.biq;
            _fld057D.setVisibility(8);
            bhS.setVisibility(0);
            return;
        } else
        {
            bhU = _cls02CA.bip;
            _fld057D.setVisibility(0);
            bhS.setVisibility(8);
            return;
        }
    }

    public void setParticipantInfo(String s, int i)
    {
        bie.setColorFilter(aok._mth02CB(getResources(), i));
        ((_cls1D27)_cls1D3C._mth1427(getContext())._mth02CA(java/lang/String).FF70(s))._mth019A()._mth02CB(aao.baq)._mth02CA(bie);
    }

    public void setSendCommentDelegate(_cls02CB _pcls02cb)
    {
        bhW = _pcls02cb;
    }

    public void setUpReply(String s)
    {
        bhT.setText("");
        bhT.append(s);
        bB();
    }
}
