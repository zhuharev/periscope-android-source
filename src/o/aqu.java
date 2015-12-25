// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.RelativeLayout;
import android.widget.TextView;

// Referenced classes of package o:
//            aqt

public class aqu extends RelativeLayout
    implements Checkable
{

    private aqt bAO;
    public TextView beL;

    public aqu(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        inflate(context, 0x7f030088, this);
    }

    public aqu(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        inflate(context, 0x7f030088, this);
    }

    public boolean isChecked()
    {
        return bAO.bAL;
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        bAO = (aqt)findViewById(0x7f0d0187);
        beL = (TextView)findViewById(0x7f0d019f);
    }

    public void setChecked(boolean flag)
    {
        bAO.setChecked(flag);
    }

    public void setText(CharSequence charsequence)
    {
        beL.setText(charsequence);
    }

    public void toggle()
    {
        boolean flag = bAO.bAL;
        aqt aqt1 = bAO;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        aqt1.setChecked(flag);
    }
}
