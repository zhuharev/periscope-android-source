// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

// Referenced classes of package o:
//            xe, art, FF6A

public class arp extends TextView
{

    public arp(Context context)
    {
        super(context);
        _mth02CF(context, null);
    }

    public arp(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        _mth02CF(context, attributeset);
    }

    public arp(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        _mth02CF(context, attributeset);
    }

    private void _mth02CF(Context context, AttributeSet attributeset)
    {
        if ((getGravity() & 7) != 1)
        {
            setTextAlignment(5);
        }
        attributeset = context.obtainStyledAttributes(attributeset, xe.PsTextView);
        String s = attributeset.getString(0);
        try
        {
            setTypeface(art._mth02C8(context, s));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            FF6A._mth02CA("PsTextView", (new StringBuilder("Could not get typeface:  ")).append(this).append(context.getMessage()).toString(), context);
        }
        attributeset.recycle();
    }
}
