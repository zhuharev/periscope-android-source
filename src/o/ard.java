// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.text.util.Linkify;
import android.util.AttributeSet;

// Referenced classes of package o:
//            arp

public class ard extends arp
{

    public ard(Context context)
    {
        super(context);
    }

    public ard(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public ard(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        setLinkTextColor(getResources().getColor(0x7f0c005a));
    }

    public void setText(CharSequence charsequence, android.widget.TextView.BufferType buffertype)
    {
        super.setText(charsequence, buffertype);
        Linkify.addLinks(this, 7);
    }
}
