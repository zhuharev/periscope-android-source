// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package o:
//            ada, asd, acx, acw

public class acv extends ada
{

    private String bdD[];
    private Intent bdE;
    private acx bdF;
    private Button bdG;

    public acv()
    {
    }

    private void aM()
    {
        boolean flag;
        if (!_cls141D.if._mth02CB(this, bdD))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            bdG.setText(0x7f0601a3);
            return;
        } else
        {
            bdG.setText(0x7f0601a2);
            return;
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 101)
        {
            if (_cls141D.if._mth02CA(this, bdD))
            {
                startActivity(bdE);
            }
            finish();
        }
    }

    public void onAllowPermissions(View view)
    {
        boolean flag;
        if (!_cls141D.if._mth02CB(this, bdD))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            startActivityForResult((new Intent()).setAction("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", getPackageName(), null)), 101);
            return;
        } else
        {
            _cls141D.if._mth02CA(this, bdD, 100);
            return;
        }
    }

    public void onBackPressed()
    {
        if (((asd) (bdF)).buH)
        {
            bdF.hide();
        }
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent();
        int i = bundle.getIntExtra("layout", 0);
        bdD = bundle.getStringArrayExtra("permissions");
        bdE = (Intent)bundle.getParcelableExtra("start_intent");
        setContentView(0x7f03006c);
        bdF = (acx)findViewById(0x7f0d012f);
        bdF.setContent(i);
        bundle = bdF;
        acw acw1 = new acw(this);
        if (!((asd) (bundle)).bCD.contains(acw1))
        {
            ((asd) (bundle)).bCE.add(acw1);
        }
        bdG = (Button)findViewById(0x7f0d012e);
        boolean flag;
        if (!_cls141D.if._mth02CB(this, bdD))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            bdG.setText(0x7f0601a3);
        } else
        {
            bdG.setText(0x7f0601a2);
        }
        acx acx1 = bdF;
        if (!((asd) (acx1))._fld1EC8)
        {
            ObjectAnimator objectanimator = ObjectAnimator.ofFloat(((asd) (acx1)).bAz, View.ALPHA, new float[] {
                0.0F, 0.6F
            });
            ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(((asd) (acx1)).bAy, View.TRANSLATION_Y, new float[] {
                (float)((asd) (acx1))._fld0575, 0.0F
            });
            bundle = acx1.getContext();
            if (android.os.Build.VERSION.SDK_INT >= 21)
            {
                bundle = AnimationUtils.loadInterpolator(bundle, 0x10c000e);
            } else
            {
                bundle = AnimationUtils.loadInterpolator(bundle, 0x10c0003);
            }
            objectanimator1.setInterpolator(bundle);
            for (bundle = ((asd) (acx1)).bCD.iterator(); bundle.hasNext(); objectanimator1.addListener((android.animation.Animator.AnimatorListener)bundle.next())) { }
            bundle = new AnimatorSet();
            bundle.play(objectanimator1).with(objectanimator);
            bundle.start();
        }
    }

    public void onRequestPermissionsResult(int i, String as[], int ai[])
    {
label0:
        {
            int j;
            switch (i)
            {
            default:
                return;

            case 100: // 'd'
                j = as.length;
                break;
            }
            i = 0;
            do
            {
                if (i >= j)
                {
                    break;
                }
                if (ai[i] != 0)
                {
                    i = 0;
                    break label0;
                }
                i++;
            } while (true);
            i = 1;
        }
        if (i != 0)
        {
            startActivity(bdE);
            finish();
            return;
        } else
        {
            aM();
            return;
        }
    }
}
