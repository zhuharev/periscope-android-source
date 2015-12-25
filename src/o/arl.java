// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

// Referenced classes of package o:
//            xe

public class arl extends RelativeLayout
    implements android.view.View.OnClickListener, android.content.DialogInterface.OnClickListener
{
    public static interface if
    {

        public abstract void aQ();
    }


    private int bBA;
    private int bBB;
    private int bBC;
    private int bBD;
    private int bBE[];
    private int bBF[];
    public int bBG;
    private ImageView bBH;
    private if bBI;
    private int bBq;
    private TextView bBs;
    private int bsq[];

    public arl(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        _mth02CF(context, attributeset);
    }

    public arl(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        _mth02CF(context, attributeset);
    }

    private View ew()
    {
        LayoutInflater layoutinflater = LayoutInflater.from(getContext());
        View view = layoutinflater.inflate(bBA, null);
        RadioGroup radiogroup = (RadioGroup)view.findViewById(bBB);
        int j = bBE.length;
        for (int i = 0; i < j; i++)
        {
            RadioButton radiobutton = (RadioButton)layoutinflater.inflate(0x7f030072, null);
            radiobutton.setId(bBE[i]);
            radiobutton.setText(bBF[i]);
            radiogroup.addView(radiobutton);
        }

        radiogroup.check(bBG);
        return view;
    }

    private void _mth013A(int i)
    {
        bBG = i;
        int k = bBE.length;
        for (int j = 0; j < k; j++)
        {
            if (i == bBE[j])
            {
                bBs.setText(getContext().getString(bBF[j]));
                bBH.setImageResource(bsq[j]);
                return;
            }
        }

    }

    private void _mth02CF(Context context, AttributeSet attributeset)
    {
        inflate(context, 0x7f030074, this);
        context = context.obtainStyledAttributes(attributeset, xe.PsRadioGroupPreference, 0, 0);
        bBq = context.getResourceId(0, 0);
        context.recycle();
        return;
        attributeset;
        context.recycle();
        throw attributeset;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        switch (i)
        {
        default:
            return;

        case -1: 
            dialoginterface = (RadioGroup)((AlertDialog)dialoginterface).findViewById(bBB);
            break;
        }
        _mth013A(((RadioButton)dialoginterface.findViewById(dialoginterface.getCheckedRadioButtonId())).getId());
        if (bBI != null)
        {
            bBI.aQ();
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131558747: 
            (new android.app.AlertDialog.Builder(getContext())).setTitle(bBq).setView(ew()).setPositiveButton(bBC, this).setNegativeButton(bBD, null).show();
            break;
        }
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        ((TextView)findViewById(0x7f0d0037)).setText(bBq);
        bBs = (TextView)findViewById(0x7f0d0102);
        bBH = (ImageView)findViewById(0x7f0d015c);
        findViewById(0x7f0d015b).setOnClickListener(this);
    }

    public void setDialogLayout(int i, int j, int k, int l)
    {
        bBA = i;
        bBB = j;
        bBC = k;
        bBD = l;
    }

    public void setOnCheckedChangeListener(if if1)
    {
        bBI = if1;
    }

    public void setSingleChoiceItems(int ai[], int ai1[], int ai2[], int i)
    {
        bBE = ai;
        bBF = ai1;
        bsq = ai2;
        _mth013A(i);
    }
}
