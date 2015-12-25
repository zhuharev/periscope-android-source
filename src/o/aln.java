// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.widget.Button;
import java.util.Arrays;

// Referenced classes of package o:
//            xe, art

final class aln
{

    private static final int brT[] = {
        0x1010095, 0x1010098, 0x10103b3, 0x10100d7, 0x10103b4, 0x10100d9, 0x10100d4
    };
    private static final SparseIntArray brU;

    public static void _mth02CA(Context context, AttributeSet attributeset, Button button)
    {
        Object obj = context.obtainStyledAttributes(attributeset, xe.PsTextView);
        String s = ((TypedArray) (obj)).getString(0);
        try
        {
            button.setTypeface(art._mth02C8(context, s));
        }
        catch (Exception exception) { }
        ((TypedArray) (obj)).recycle();
        obj = context.getResources();
        context = context.obtainStyledAttributes(attributeset, brT);
        button.setTextSize(0, context.getDimensionPixelSize(brU.get(0x1010095), ((Resources) (obj)).getDimensionPixelSize(0x7f090058)));
        button.setTextColor(context.getColor(brU.get(0x1010098), ((Resources) (obj)).getColor(0x7f0c005a)));
        button.setBackgroundResource(context.getResourceId(brU.get(0x10100d4), 0));
        button.setPadding(context.getDimensionPixelSize(brU.get(0x10103b3), 0), context.getDimensionPixelSize(brU.get(0x10100d7), 0), context.getDimensionPixelSize(brU.get(0x10103b4), 0), context.getDimensionPixelSize(brU.get(0x10100d9), 0));
        context.recycle();
    }

    static 
    {
        brU = new SparseIntArray();
        Arrays.sort(brT);
        for (int i = 0; i < 7; i++)
        {
            brU.put(brT[i], i);
        }

    }
}
