// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.io.File;

// Referenced classes of package o:
//            _cls1D3C, _cls1D5A, _cls1D27, _cls1647

public class ask extends RelativeLayout
    implements TextWatcher, android.view.View.OnClickListener
{
    public static interface if
    {

        public abstract void bX();

        public abstract void onDismiss();
    }


    public TextView bCS;
    private TextView bCT;
    public EditText bCU;
    public ImageView bCV;
    public Button bCW;
    private if bCX;
    public View bCY;
    public TextView bsI;

    public ask(Context context)
    {
        super(context);
        init();
    }

    public ask(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    public ask(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init();
    }

    private void init()
    {
        LayoutInflater.from(getContext()).inflate(0x7f03008f, this, true);
        Resources resources = getResources();
        ((ImageView)findViewById(0x7f0d01aa)).setColorFilter(resources.getColor(0x7f0c00a3));
        ImageView imageview = (ImageView)findViewById(0x7f0d00fa);
        imageview.setColorFilter(resources.getColor(0x7f0c000d));
        imageview.setOnClickListener(this);
        findViewById(0x7f0d0107).setOnClickListener(this);
        bsI = (TextView)findViewById(0x7f0d00bd);
        bCU = (EditText)findViewById(0x7f0d01ac);
        bCU.addTextChangedListener(this);
        bCV = (ImageView)findViewById(0x7f0d0087);
        bCS = (TextView)findViewById(0x7f0d01ad);
        bCT = (TextView)findViewById(0x7f0d01af);
        bCY = findViewById(0x7f0d01a9);
        bCY.setOnClickListener(this);
        bCW = (Button)findViewById(0x7f0d01ae);
        bCW.setOnClickListener(this);
        bCW.setText(0x7f060150);
    }

    public void afterTextChanged(Editable editable)
    {
        int i = 140 - (bCU.getText().length() + 23 + 1);
        bCT.setText(String.valueOf(i));
        if (i < 0)
        {
            bCT.setTextColor(getResources().getColor(0x7f0c0038));
            bCW.setEnabled(false);
            return;
        } else
        {
            bCT.setTextColor(getResources().getColor(0x7f0c0056));
            bCW.setEnabled(true);
            return;
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131558650: 
        case 2131558825: 
            bCX.onDismiss();
            return;

        case 2131558830: 
            bCW.setEnabled(false);
            break;
        }
        bCW.setText(0x7f060155);
        bCX.bX();
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)bCW.getLayoutParams();
        android.widget.RelativeLayout.LayoutParams layoutparams1 = (android.widget.RelativeLayout.LayoutParams)bCT.getLayoutParams();
        if (configuration.orientation == 1)
        {
            layoutparams.removeRule(6);
            layoutparams.addRule(3, 0x7f0d01ad);
            layoutparams1.removeRule(6);
            layoutparams1.addRule(3, 0x7f0d01ad);
        } else
        {
            layoutparams.addRule(6);
            layoutparams.removeRule(3);
            layoutparams1.addRule(6);
            layoutparams1.removeRule(3);
        }
        bCW.setLayoutParams(layoutparams);
        bCT.setLayoutParams(layoutparams1);
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void setCallbackListener(if if1)
    {
        bCX = if1;
    }

    public final void _mth1FBE(File file)
    {
        if (file == null)
        {
            bCV.setImageDrawable(null);
            bCV.setVisibility(8);
            return;
        } else
        {
            bCV.setVisibility(0);
            ((_cls1D27)_cls1D3C._mth1427(getContext())._mth02CA(java/io/File).FF70(file))._mth05D5(0x7f0c0056)._mth0197()._mth02CA(bCV);
            return;
        }
    }
}
