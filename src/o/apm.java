// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

// Referenced classes of package o:
//            aqd, arp, xe, art

public class apm extends RelativeLayout
{

    public aqd byT;
    private arp byU;

    public apm(Context context)
    {
        super(context);
        _mth02CA(context, null, 0);
    }

    public apm(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        _mth02CA(context, attributeset, 0);
    }

    public apm(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        _mth02CA(context, attributeset, i);
    }

    private void _mth02CA(Context context, AttributeSet attributeset, int i)
    {
        LayoutInflater.from(context).inflate(0x7f03001a, this, true);
        byT = (aqd)findViewById(0x7f0d0036);
        byU = (arp)findViewById(0x7f0d0060);
        attributeset = context.obtainStyledAttributes(attributeset, xe.ActionSheetItem, i, 0);
        i = 0;
        int j = attributeset.getIndexCount();
        while (i < j) 
        {
            int k = attributeset.getIndex(i);
            switch (k)
            {
            default:
                break;

            case 1: // '\001'
                byT.setImageDrawable(attributeset.getDrawable(k));
                break;

            case 0: // '\0'
                byT.setColorFilter(attributeset.getColor(k, 0));
                break;

            case 2: // '\002'
                byU.setText(attributeset.getString(k));
                break;

            case 3: // '\003'
                byU.setTextSize(0, attributeset.getDimensionPixelSize(k, 16));
                break;

            case 4: // '\004'
                try
                {
                    android.graphics.Typeface typeface = art._mth02C8(context, attributeset.getString(k));
                    byU.setTypeface(typeface);
                }
                catch (Exception exception) { }
                break;
            }
            i++;
        }
        attributeset.recycle();
    }

    public void setIcon(int i, int j)
    {
        if (j > 0)
        {
            byT.setColorFilter(getResources().getColor(j));
        } else
        {
            byT.clearColorFilter();
        }
        if (i > 0)
        {
            byT.setImageResource(i);
            return;
        } else
        {
            byT.setImageDrawable(null);
            return;
        }
    }

    public void setLabel(CharSequence charsequence)
    {
        byU.setText(charsequence);
        byU.setTextColor(getResources().getColor(0x7f0c0037));
    }

    public void setLabel(CharSequence charsequence, int i)
    {
        byU.setText(charsequence);
        byU.setTextColor(getResources().getColor(i));
    }
}
