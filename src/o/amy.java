// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import java.lang.reflect.Field;

// Referenced classes of package o:
//            amp, aro, ash, acq, 
//            xd, arl, zp, amt, 
//            amu, amr, amo, amv

public class amy extends amp
    implements android.view.View.OnClickListener, aro.if
{

    private SharedPreferences aQC;
    private ash bed;
    private aro btA;
    private aro btB;
    private arl btv;
    private arl btw;
    private arl btx;
    private arl bty;
    private aro btz;

    public amy()
    {
    }

    private void dt()
    {
        btz.setChecked(aQC.getBoolean("pref_force_hls", false));
        btA.setChecked(aQC.getBoolean("pref_show_channel_info", false));
        btB.setChecked(aQC.getBoolean("pref_show_block_counts", false));
    }

    protected final void dr()
    {
        setContentView(0x7f03003e);
        bed = (ash)findViewById(0x7f0d009c);
        bed.findViewById(0x7f0d0100).setOnClickListener(this);
        bed.setTitle(0x7f060193);
        ((TextView)findViewById(0x7f0d0089)).setText((new acq(this, xd._mth1FEA())).aK());
        aQC = PreferenceManager.getDefaultSharedPreferences(this);
        btv = (arl)findViewById(0x7f0d00dc);
        btv.setOnClickListener(this);
        btw = (arl)findViewById(0x7f0d00dd);
        btw.setOnClickListener(this);
        bty = (arl)findViewById(0x7f0d0062);
        bty.setOnClickListener(this);
        btz = (aro)findViewById(0x7f0d00e0);
        btz.setOnCheckedChangeListener(this);
        btA = (aro)findViewById(0x7f0d00df);
        btA.setOnCheckedChangeListener(this);
        btB = (aro)findViewById(0x7f0d00e1);
        btB.setOnCheckedChangeListener(this);
        btx = (arl)findViewById(0x7f0d00de);
        if (!xd._mth1FEA().aQC.getBoolean((String)yp.CON._mth02CA("o.yp").getField("aVN").get(null), false))
        {
            btx.setVisibility(8);
        }
        btx.setOnClickListener(this);
        dt();
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        overridePendingTransition(0x7f04000a, 0x7f040010);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131558620: 
            if (android.os.Build.VERSION.SDK_INT >= 21)
            {
                startActivity(new Intent(this, o/amt));
                return;
            } else
            {
                startActivity(new Intent(this, o/amu));
                return;
            }

        case 2131558621: 
            startActivity(new Intent(this, o/amr));
            return;

        case 2131558498: 
            startActivity(new Intent(this, o/amo));
            return;

        case 2131558622: 
            startActivity(new Intent(this, o/amv));
            return;

        case 2131558656: 
            onBackPressed();
            return;
        }
    }

    public final void _mth02CA(aro aro1, boolean flag)
    {
        switch (aro1.getId())
        {
        default:
            return;

        case 2131558623: 
            if (aQC.getBoolean("pref_show_channel_info", false) != flag)
            {
                aQC.edit().putBoolean("pref_show_channel_info", flag).apply();
                dt();
                return;
            }
            break;

        case 2131558624: 
            if (aQC.getBoolean("pref_force_hls", false) != flag)
            {
                aQC.edit().putBoolean("pref_force_hls", flag).apply();
                dt();
                return;
            }
            break;

        case 2131558625: 
            if (aQC.getBoolean("pref_show_block_counts", false) != flag)
            {
                aQC.edit().putBoolean("pref_show_block_counts", flag).apply();
                dt();
            }
            break;
        }
    }
}
