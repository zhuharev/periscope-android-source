// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

// Referenced classes of package o:
//            xe

public class aro extends RelativeLayout
    implements android.widget.CompoundButton.OnCheckedChangeListener
{
    public static interface if
    {

        public abstract void _mth02CA(aro aro1, boolean flag);
    }


    private int bBM;
    private int bBN;
    public Switch bBO;
    private if bBP;
    private int bBq;
    private TextView bBs;

    public aro(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        _mth02CF(context, attributeset);
    }

    public aro(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        _mth02CF(context, attributeset);
    }

    private void _mth02CF(Context context, AttributeSet attributeset)
    {
        inflate(context, 0x7f030086, this);
        context = context.obtainStyledAttributes(attributeset, xe.PsSwitchPreference, 0, 0);
        bBq = context.getResourceId(0, 0);
        bBM = context.getResourceId(1, 0);
        bBN = context.getResourceId(2, 0);
        context.recycle();
        return;
        attributeset;
        context.recycle();
        throw attributeset;
    }

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (flag)
        {
            bBs.setText(bBM);
        } else
        {
            bBs.setText(bBN);
        }
        if (bBP != null)
        {
            bBP._mth02CA(this, flag);
        }
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        ((TextView)findViewById(0x7f0d0037)).setText(bBq);
        bBs = (TextView)findViewById(0x7f0d0102);
        bBs.setText(bBN);
        bBO = (Switch)findViewById(0x7f0d019e);
        bBO.setOnCheckedChangeListener(this);
    }

    public void setChecked(boolean flag)
    {
        bBO.setChecked(flag);
    }

    public void setOnCheckedChangeListener(if if1)
    {
        bBP = if1;
    }
}
