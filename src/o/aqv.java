// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

public abstract class aqv extends ClickableSpan
{

    private int _fld0196;

    public aqv(int i)
    {
        _fld0196 = i;
    }

    public void updateDrawState(TextPaint textpaint)
    {
        super.updateDrawState(textpaint);
        textpaint.setUnderlineText(false);
        textpaint.setColor(_fld0196);
    }
}
