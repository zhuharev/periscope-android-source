// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

// Referenced classes of package o:
//            aqs

public class aqz extends aqs
{
    public static final class if extends Enum
    {

        public static final int bAY = 1;
        public static final int bAZ = 2;
        public static final int bBa = 3;
        public static final int bBb = 4;
        private static final int bBc[] = {
            1, 2, 3, 4
        };

        public static int[] eu()
        {
            return (int[])bBc.clone();
        }

    }


    private Drawable bAR;
    private Drawable bAS;
    private Drawable bAT;
    private int bAU;
    private int bAV;
    private int bAW;

    public aqz(Context context)
    {
        super(context);
        init();
    }

    public aqz(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    public aqz(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init();
    }

    private void init()
    {
        Resources resources = getResources();
        bAR = resources.getDrawable(0x7f020053);
        bAU = resources.getColor(0x7f0c005a);
        bAS = resources.getDrawable(0x7f020052);
        bAV = resources.getColor(0x7f0c00a4);
        bAT = resources.getDrawable(0x7f020054);
        bAW = resources.getColor(0x7f0c00a4);
        setState$65a6ccda(if.bAY);
    }

    public void setState$65a6ccda(int i)
    {
        static final class _cls1
        {

            static final int bAX[];

            static 
            {
                bAX = new int[if.eu().length];
                int ai[];
                int k;
                try
                {
                    ai = bAX;
                    int j = if.bAZ;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    continue; /* Loop/switch isn't completed */
                }
                ai[1] = 1;
_L4:
                ai = bAX;
                k = if.bBa;
                ai[2] = 2;
_L1:
                ai = bAX;
                k = if.bBb;
                ai[3] = 3;
_L2:
                ai = bAX;
                k = if.bAY;
                ai[0] = 4;
                break MISSING_BLOCK_LABEL_71;
                NoSuchFieldError nosuchfielderror1;
                nosuchfielderror1;
                  goto _L1
                nosuchfielderror1;
                  goto _L2
                nosuchfielderror1;
                if (true) goto _L4; else goto _L3
_L3:
            }
        }

        switch (_cls1.bAX[i - 1])
        {
        case 1: // '\001'
            setVisibility(0);
            setText(getResources().getString(0x7f060069));
            setTextColor(bAV);
            setBackground(bAS);
            return;

        case 2: // '\002'
            setVisibility(0);
            setText(getResources().getString(0x7f060067));
            setTextColor(bAW);
            setBackground(bAT);
            return;

        case 3: // '\003'
            setVisibility(8);
            return;
        }
        setVisibility(0);
        setText(getResources().getString(0x7f060068));
        setTextColor(bAU);
        setBackground(bAR);
    }
}
