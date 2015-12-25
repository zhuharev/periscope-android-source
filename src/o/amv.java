// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import tv.periscope.android.api.ApiManager;
import tv.periscope.android.api.GetBroadcastRankParametersResponse;

// Referenced classes of package o:
//            amp, zu

public class amv extends amp
    implements android.widget.CompoundButton.OnCheckedChangeListener, android.view.View.OnClickListener
{

    private EditText bti;
    private EditText btj;
    private EditText btk;
    private EditText btl;
    private EditText btm;
    private EditText btn;
    private EditText bto;
    private EditText btp;
    private EditText btq;
    private TextView btr;
    private Button bts;

    public amv()
    {
    }

    protected final void dr()
    {
        setContentView(0x7f030076);
        Switch switch1 = (Switch)findViewById(0x7f0d0171);
        switch1.setOnCheckedChangeListener(this);
        switch1.setChecked(_cls30CE.if._mth02CE(this));
        bti = (EditText)findViewById(0x7f0d0172);
        btj = (EditText)findViewById(0x7f0d0173);
        btk = (EditText)findViewById(0x7f0d0174);
        btl = (EditText)findViewById(0x7f0d0175);
        btm = (EditText)findViewById(0x7f0d0176);
        btn = (EditText)findViewById(0x7f0d0177);
        bto = (EditText)findViewById(0x7f0d0178);
        btp = (EditText)findViewById(0x7f0d0179);
        btq = (EditText)findViewById(0x7f0d017a);
        btr = (TextView)findViewById(0x7f0d017c);
        bts = (Button)findViewById(0x7f0d017b);
        bts.setOnClickListener(this);
        ApiManager.get(this).getBroadcastRankParameters();
    }

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        switch (compoundbutton.getId())
        {
        default:
            return;

        case 2131558769: 
            getApplicationContext().getSharedPreferences("api_tweaks", 0).edit().putBoolean("pref_enable_rank_summary", flag).apply();
            break;
        }
    }

    public void onClick(View view)
    {
        if (view.getId() == 0x7f0d017b)
        {
            if (!bti.isEnabled())
            {
                bti.setEnabled(true);
                btj.setEnabled(true);
                btk.setEnabled(true);
                btl.setEnabled(true);
                btm.setEnabled(true);
                btn.setEnabled(true);
                bto.setEnabled(true);
                btp.setEnabled(true);
                btq.setEnabled(true);
                btr.setVisibility(0);
                bts.setText("Save changes");
                return;
            }
            ApiManager.get(this).setBroadcastRankParameters(bti.getText().toString(), btj.getText().toString(), btk.getText().toString(), btl.getText().toString(), btm.getText().toString(), btn.getText().toString(), bto.getText().toString(), btp.getText().toString(), btq.getText().toString());
        }
    }

    public void onEventMainThread(zu zu1)
    {
        static final class _cls1
        {

            static final int $SwitchMap$tv$periscope$android$event$ApiEvent$Type[];

            static 
            {
                $SwitchMap$tv$periscope$android$event$ApiEvent$Type = new int[zu.if.values().length];
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXW.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXX.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
            }
        }

        switch (_cls1..SwitchMap.tv.periscope.android.event.ApiEvent.Type[zu1.aXk.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            boolean flag;
            if (zu1.aXl == null && zu1.mU == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                zu1 = (GetBroadcastRankParametersResponse)zu1.data;
                bti.setText(((GetBroadcastRankParametersResponse) (zu1)).stickinessCoefficient);
                btj.setText(((GetBroadcastRankParametersResponse) (zu1)).verifiedCoefficient);
                btk.setText(((GetBroadcastRankParametersResponse) (zu1)).viewersCountCoefficient);
                btl.setText(((GetBroadcastRankParametersResponse) (zu1)).reportRatioCoefficient);
                btm.setText(((GetBroadcastRankParametersResponse) (zu1)).hasLocationCoefficient);
                btn.setText(((GetBroadcastRankParametersResponse) (zu1)).sharesCoefficient);
                bto.setText(((GetBroadcastRankParametersResponse) (zu1)).cortexScoreCoefficient);
                btp.setText(((GetBroadcastRankParametersResponse) (zu1)).decayCoefficient);
                btq.setText(((GetBroadcastRankParametersResponse) (zu1)).decayHalfLife);
                return;
            } else
            {
                Toast.makeText(this, "Failed to get broadcast rank parameters", 1).show();
                return;
            }

        case 2: // '\002'
            break;
        }
        boolean flag1;
        if (zu1.aXl == null && zu1.mU == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            bti.setEnabled(false);
            btj.setEnabled(false);
            btk.setEnabled(false);
            btl.setEnabled(false);
            btm.setEnabled(false);
            btn.setEnabled(false);
            bto.setEnabled(false);
            btp.setEnabled(false);
            btq.setEnabled(false);
            btr.setVisibility(8);
            bts.setText("Edit parameters");
            Toast.makeText(this, "Save completed. Rank will update in a few seconds", 1).show();
            ApiManager.get(this).getBroadcastRankParameters();
            return;
        } else
        {
            Toast.makeText(this, "Failed to set broadcast rank parameters", 1).show();
            return;
        }
    }
}
