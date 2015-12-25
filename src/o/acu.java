// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

// Referenced classes of package o:
//            acp, xf, add, ash

public class acu extends acp
    implements android.view.View.OnClickListener
{

    public acu()
    {
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

        case 2131558665: 
            xf._mth02CA(xf.if.aQW);
            view = new Intent(this, o/add);
            view.putExtra("e_title", getString(0x7f060041));
            view.putExtra("e_url", getString(0x7f060042));
            startActivity(view, ActivityOptions.makeCustomAnimation(this, 0x7f04000e, 0x7f04000c).toBundle());
            return;

        case 2131558667: 
            xf._mth02CA(xf.if.aQV);
            view = new Intent(this, o/add);
            view.putExtra("e_title", getString(0x7f06011d));
            view.putExtra("e_url", getString(0x7f06011e));
            startActivity(view, ActivityOptions.makeCustomAnimation(this, 0x7f04000e, 0x7f04000c).toBundle());
            return;

        case 2131558666: 
            xf._mth02CA(xf.if.aQU);
            view = new Intent(this, o/add);
            view.putExtra("e_title", getString(0x7f060161));
            view.putExtra("e_url", getString(0x7f060163));
            startActivity(view, ActivityOptions.makeCustomAnimation(this, 0x7f04000e, 0x7f04000c).toBundle());
            return;

        case 2131558656: 
            onBackPressed();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030052);
        ((ash)findViewById(0x7f0d009c)).setTitle(0x7f0600e0);
        findViewById(0x7f0d0109).setOnClickListener(this);
        findViewById(0x7f0d010a).setOnClickListener(this);
        findViewById(0x7f0d010b).setOnClickListener(this);
        findViewById(0x7f0d0100).setOnClickListener(this);
    }
}
