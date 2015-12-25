// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class arj extends ImageButton
{
    public static final class if extends Enum
    {

        public static final int bBx = 1;
        public static final int bBy = 2;
        private static final int bBz[] = {
            1, 2
        };

        public static int[] ev()
        {
            return (int[])bBz.clone();
        }

    }


    private Drawable bBu;
    private Drawable bBv;

    public arj(Context context)
    {
        super(context);
        init();
    }

    public arj(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    public arj(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init();
    }

    private void init()
    {
        Resources resources = getResources();
        bBu = resources.getDrawable(0x7f020053);
        bBv = resources.getDrawable(0x7f020052);
        setState$492def32(if.bBy);
    }

    public void setState$492def32(int i)
    {
        static final class _cls1
        {

            static final int bBw[];

            static 
            {
                bBw = new int[if.ev().length];
                int ai[];
                ai = bBw;
                int j = if.bBx;
                ai[0] = 1;
_L2:
                ai = bBw;
                int k = if.bBy;
                ai[1] = 2;
                break MISSING_BLOCK_LABEL_39;
                NoSuchFieldError nosuchfielderror;
                nosuchfielderror;
                if (true) goto _L2; else goto _L1
_L1:
                nosuchfielderror;
            }
        }

        switch (_cls1.bBw[i - 1])
        {
        case 1: // '\001'
            setVisibility(0);
            setColorFilter(getResources().getColor(0x7f0c00a4));
            setBackground(bBv);
            return;
        }
        setVisibility(0);
        setColorFilter(getResources().getColor(0x7f0c00b5));
        setBackground(bBu);
    }
}
