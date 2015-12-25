// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

// Referenced classes of package o:
//            amp

public class amo extends amp
    implements android.widget.CompoundButton.OnCheckedChangeListener, TextWatcher
{

    private EditText bsU;
    private Switch bsV;
    private Switch bsW;

    public amo()
    {
    }

    public void afterTextChanged(Editable editable)
    {
        _cls30CE.if._mth02CA(this, editable);
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    protected final void dr()
    {
        setContentView(0x7f03001c);
        bsU = (EditText)findViewById(0x7f0d0062);
        bsU.addTextChangedListener(this);
        Object obj = getApplicationContext().getSharedPreferences("api_tweaks", 0).getString("pref_local_api", "https://dev-api.periscope.tv");
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            bsU.setText(((CharSequence) (obj)));
        }
        bsV = (Switch)findViewById(0x7f0d0061);
        bsW = (Switch)findViewById(0x7f0d0063);
        bsV.setOnCheckedChangeListener(this);
        bsV.setChecked(_cls30CE.if._mth1428(this));
        bsW.setOnCheckedChangeListener(this);
        bsW.setChecked(_cls30CE.if.FE73(this));
        obj = (Switch)findViewById(0x7f0d0064);
        ((Switch) (obj)).setOnCheckedChangeListener(this);
        ((Switch) (obj)).setChecked(_cls30CE.if._mth02CB(this));
        obj = (Switch)findViewById(0x7f0d0065);
        ((Switch) (obj)).setOnCheckedChangeListener(this);
        ((Switch) (obj)).setChecked(_cls30CE.if._mth02CF(this));
    }

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        switch (compoundbutton.getId())
        {
        default:
            return;

        case 2131558497: 
            if (flag)
            {
                bsW.setChecked(false);
                bsU.setEnabled(true);
                bsU.setSelection(bsU.getText().length());
                getApplicationContext().getSharedPreferences("api_tweaks", 0).edit().putBoolean("pref_enable_local_api", true).apply();
                _cls30CE.if._mth02CA(this, bsU.getText());
                return;
            } else
            {
                getApplicationContext().getSharedPreferences("api_tweaks", 0).edit().putBoolean("pref_enable_local_api", false).apply();
                bsU.setEnabled(false);
                return;
            }

        case 2131558499: 
            if (flag)
            {
                bsV.setChecked(false);
            }
            getApplicationContext().getSharedPreferences("api_tweaks", 0).edit().putBoolean("pref_enable_canary_api", flag).apply();
            return;

        case 2131558500: 
            getApplicationContext().getSharedPreferences("api_tweaks", 0).edit().putBoolean("pref_enable_chatman", flag).apply();
            return;

        case 2131558501: 
            getApplicationContext().getSharedPreferences("api_tweaks", 0).edit().putBoolean("pref_enable_pubnub", flag).apply();
            // fall through

        case 2131558498: 
            return;
        }
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }
}
