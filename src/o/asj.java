// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

public final class asj
{
    static final class if extends Handler
    {

        private final TextView av;
        private final PopupWindow bCP;

        public final void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                return;

            case 100: // 'd'
                break;
            }
            if (bCP.isShowing() && av.isAttachedToWindow())
            {
                bCP.dismiss();
            }
        }

        public if(PopupWindow popupwindow, TextView textview)
        {
            super(Looper.getMainLooper());
            bCP = popupwindow;
            av = textview;
        }
    }


    public final TextView av;
    public final if bCO;
    public final PopupWindow bCP;
    public final AnimatorSet bCQ = new AnimatorSet();
    private final ObjectAnimator bCR;

    public asj(Context context)
    {
        bCP = new PopupWindow(context);
        av = (TextView)LayoutInflater.from(context).inflate(0x7f03008b, null);
        av.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
        bCO = new if(bCP, av);
        bCR = ObjectAnimator.ofFloat(av, View.ALPHA, new float[] {
            1.0F, 0.0F
        });
        bCP.setHeight(-2);
        bCP.setWidth(-2);
        bCP.setBackgroundDrawable(null);
        bCP.setContentView(av);
    }

    public final void _mth02CA(View view, String s, boolean flag)
    {
        av.setText(s);
        s = new int[2];
        view.getLocationOnScreen(s);
        int i = s[0];
        int j = s[1];
        s = new Rect(i, j, view.getWidth() + i, view.getHeight() + j);
        av.measure(-2, -2);
        int k = av.getMeasuredWidth();
        i = av.getMeasuredHeight();
        j = s.centerX();
        k /= 2;
        int l = ((Rect) (s)).top;
        s = bCR;
        long l1;
        if (flag)
        {
            l1 = 5500L;
        } else
        {
            l1 = 2500L;
        }
        s.setDuration(l1);
        bCP.showAtLocation(view, 0, j - k, l - i);
        bCQ.play(bCR);
        bCQ.start();
        view = bCO;
        if (flag)
        {
            l1 = 5500L;
        } else
        {
            l1 = 2500L;
        }
        view.sendEmptyMessageDelayed(100, l1);
    }
}
