// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

// Referenced classes of package o:
//            aui

public class ash extends RelativeLayout
{

    private TextView bCK;
    private TextView buu;

    public ash(Context context)
    {
        super(context);
        init(context);
    }

    public ash(Context context, AttributeSet attributeset)
    {
        super(context, attributeset, 0x7f01000b);
        init(context);
    }

    public ash(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init(context);
    }

    private void init(Context context)
    {
        LayoutInflater.from(context).inflate(0x7f03008a, this, true);
        buu = (TextView)findViewById(0x7f0d0037);
        bCK = (TextView)findViewById(0x7f0d01a1);
    }

    public void setSubTitle(int i)
    {
        bCK.setVisibility(0);
        bCK.setText(i);
    }

    public void setSubTitle(CharSequence charsequence)
    {
        if (!aui.isEmpty(charsequence))
        {
            bCK.setVisibility(0);
        } else
        {
            bCK.setVisibility(8);
        }
        bCK.setText(charsequence);
    }

    public void setTitle(int i)
    {
        buu.setText(i);
    }

    public void setTitle(CharSequence charsequence)
    {
        buu.setText(charsequence);
    }
}
