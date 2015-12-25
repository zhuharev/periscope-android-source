// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

// Referenced classes of package o:
//            acp, xf, yo, aos, 
//            acq, xd

public class acs extends acp
    implements android.view.View.OnClickListener
{

    private acq bdt;
    private EditText bdu;
    private EditText bdv;

    public acs()
    {
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 8000)
        {
            finish();
        }
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        xf._mth02CA(xf.if.aRd);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131558656: 
            onBackPressed();
            return;

        case 2131558657: 
            xf._mth02CA(xf.if.aRe);
            break;
        }
        Toast.makeText(this, 0x7f0600d4, 1).show();
        Object obj = (new StringBuilder()).append(bdu.getText().toString()).append("\n\n").append(bdv.getText().toString()).toString();
        if (yo.h())
        {
            view = "contact@periscope.tv";
        } else
        {
            view = "beta-feedback@periscope.tv";
        }
        String s = getString(0x7f0600d1, new Object[] {
            (new StringBuilder("v")).append(aos._mth0131(this)).append(" (").append(getPackageName()).append(")").toString()
        });
        obj = (new StringBuilder(((String) (obj)))).append("\n\n--------------------").append(bdt.aK());
        startActivityForResult((new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", view, null))).putExtra("android.intent.extra.SUBJECT", s).putExtra("android.intent.extra.TEXT", ((StringBuilder) (obj)).toString()), 8000);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03004b);
        getWindow().setBackgroundDrawable(null);
        bdt = new acq(this, xd._mth1FEA());
        bdu = (EditText)findViewById(0x7f0d0102);
        bdv = (EditText)findViewById(0x7f0d00fd);
        bundle = (new StringBuilder()).append(getString(0x7f0600d0)).append("\n\n").toString();
        bdv.setText(bundle);
        findViewById(0x7f0d0100).setOnClickListener(this);
        findViewById(0x7f0d0101).setOnClickListener(this);
    }
}
