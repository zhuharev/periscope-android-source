// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.res.ColorStateList;
import android.widget.CompoundButton;

class _cls1D43
{

    _cls1D43()
    {
    }

    static void _mth02CA(CompoundButton compoundbutton, ColorStateList colorstatelist)
    {
        compoundbutton.setButtonTintList(colorstatelist);
    }

    static void _mth02CA(CompoundButton compoundbutton, android.graphics.PorterDuff.Mode mode)
    {
        compoundbutton.setButtonTintMode(mode);
    }
}
