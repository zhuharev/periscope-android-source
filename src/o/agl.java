// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.File;
import java.util.ArrayList;

// Referenced classes of package o:
//            agm, agn, ago, ask, 
//            aos, asl, xj, xf, 
//            agp

public final class agl
    implements ask.if
{

    final ask bjP;
    private final asl bjQ;
    final View bjR;
    final View bjS;
    private final String bjT;
    final float bjU;
    final int bjV;
    boolean bjW;
    boolean bjX;
    String bjY;
    private xj bjZ;
    private final agm bka = new agm(this);
    private final agn bkb = new agn(this);
    final ago bkc = new ago(this);

    public agl(View view, agp agp, ask ask1, String s)
    {
        bjQ = agp;
        bjP = ask1;
        bjR = view;
        bjS = bjP.findViewById(0x7f0d0107);
        bjT = s;
        bjU = aos._mth02B2(bjP.getContext()).y;
        bjP.setCallbackListener(this);
        bjV = bjP.getContext().getResources().getDimensionPixelOffset(0x7f090089);
    }

    public final void bW()
    {
        if (!bjX)
        {
            return;
        }
        Object obj = bjP.getFocusedChild();
        if (obj != null)
        {
            ((InputMethodManager)((View) (obj)).getContext().getSystemService("input_method")).hideSoftInputFromWindow(((View) (obj)).getWindowToken(), 0);
        }
        float f = aos._mth02B2(bjP.getContext()).y;
        float f1 = bjS.getTranslationY();
        obj = ObjectAnimator.ofFloat(bjS, View.TRANSLATION_Y, new float[] {
            f1, f
        });
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(bjP.bCY, View.ALPHA, new float[] {
            1.0F, 0.0F
        });
        AnimatorSet animatorset = new AnimatorSet();
        ArrayList arraylist = new ArrayList(2);
        arraylist.add(obj);
        arraylist.add(objectanimator);
        animatorset.playTogether(arraylist);
        animatorset.setDuration(300L);
        animatorset.setInterpolator(new DecelerateInterpolator());
        animatorset.addListener(bka);
        animatorset.start();
    }

    public final void bX()
    {
        bjQ._mth02CA(bjP.bCU.getText().toString(), bjP.bCS.getText().toString(), bjY, bjZ);
    }

    public final void onDismiss()
    {
        if (bjZ != null)
        {
            xf._mth02CA(bjZ.aTa);
        }
        bW();
    }

    public final void _mth02CA(String s, String s1, File file, xj xj1)
    {
        if (bjX)
        {
            return;
        }
        bjX = true;
        bjZ = xj1;
        bjW = false;
        if (file != null)
        {
            bjY = file.getAbsolutePath();
        } else
        {
            bjY = null;
        }
        xj1 = bjP.bCY;
        ask ask1 = bjP;
        String s2 = bjT;
        ask1.bCW.setText(0x7f060150);
        ask1.bsI.setText((new StringBuilder("@")).append(s2).toString());
        ask1.bCU.setText("");
        ask1.bCU.append(s);
        ask1.bCS.setText(s1);
        ask1._mth1FBE(file);
        s = ObjectAnimator.ofFloat(bjS, View.TRANSLATION_Y, new float[] {
            bjU, 0.0F
        });
        s1 = ObjectAnimator.ofFloat(xj1, View.ALPHA, new float[] {
            0.0F, 1.0F
        });
        file = new AnimatorSet();
        xj1 = new ArrayList(2);
        xj1.add(s);
        xj1.add(s1);
        file.playTogether(xj1);
        file.setDuration(300L);
        file.setInterpolator(new DecelerateInterpolator());
        file.addListener(bkb);
        file.start();
    }
}
