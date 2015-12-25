// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;

// Referenced classes of package o:
//            arp, xe

public class aqx extends arp
{

    private int bAP;
    private Drawable bAQ;

    public aqx(Context context)
    {
        super(context);
        _mth02CF(context, null);
    }

    public aqx(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        _mth02CF(context, attributeset);
    }

    public aqx(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        _mth02CF(context, attributeset);
    }

    private void _mth02CF(Context context, AttributeSet attributeset)
    {
        Resources resources = getResources();
        bAQ = resources.getDrawable(0x7f020066);
        setTextColor(-1);
        setTextSize(0, resources.getDimension(0x7f090077));
        int i = (int)resources.getDimension(0x7f090078);
        int j = (int)resources.getDimension(0x7f09008a);
        setPadding(i, j, i, j);
        context = context.obtainStyledAttributes(attributeset, xe.PsFeaturedTextView);
        bAP = context.getColor(0, resources.getColor(0x7f0c0046));
        context.recycle();
        setBackground(bAQ);
        setCategoryColor(bAP);
    }

    public void setCategory(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            setText(0x7f0600ca);
            return;
        } else
        {
            setText(s);
            return;
        }
    }

    public void setCategoryColor(int i)
    {
        int j = i;
        if (i == 0)
        {
            j = getResources().getColor(0x7f0c0046);
        }
        bAP = j;
        bAQ.setColorFilter(bAP, android.graphics.PorterDuff.Mode.MULTIPLY);
    }
}
