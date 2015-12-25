// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package o:
//            aht, aqd, ahm, xk, 
//            aev, adf, _cls03BD, _cls0EB2, 
//            _cls0192

public final class ahz extends aht
    implements android.view.View.OnClickListener
{
    final class if extends _cls03BD
    {

        private ahz bmE;

        public final void _mth02CA(Object obj, _cls0192 _pcls0192)
        {
            obj = (_cls0EB2)obj;
            bmE.bmu.setImageDrawable(((android.graphics.drawable.Drawable) (obj)));
            if (bmE.bmC != null)
            {
                bmE.bmu.setColorFilter(bmE.bmC.intValue());
            }
        }

        private if()
        {
            bmE = ahz.this;
            super();
        }

        if(byte byte0)
        {
            this();
        }
    }


    private final aev blC;
    public final if bmA = new if((byte)0);
    public ahm bmB;
    public Integer bmC;
    final adf bmD;
    public final View bmr;
    public final TextView bms;
    public final TextView bmt;
    public final aqd bmu;
    public final ImageView bmv;
    public final View bmw;
    public final View bmx;
    public final ImageView bmy;
    public final TextView bmz;

    public ahz(View view, aev aev1, adf adf1)
    {
        super(view);
        bmr = view.findViewById(0x7f0d00bc);
        bms = (TextView)view.findViewById(0x7f0d00bd);
        bmt = (TextView)view.findViewById(0x7f0d00c0);
        bmu = (aqd)view.findViewById(0x7f0d008a);
        bmv = (ImageView)view.findViewById(0x7f0d00c1);
        bmw = view.findViewById(0x7f0d00c2);
        bmx = view.findViewById(0x7f0d00bb);
        bmy = (ImageView)view.findViewById(0x7f0d00be);
        bmz = (TextView)view.findViewById(0x7f0d00bf);
        bmy.setColorFilter(view.getContext().getResources().getColor(0x7f0c0056));
        blC = aev1;
        bmD = adf1;
        float f = view.getResources().getDimension(0x7f09005a);
        boolean flag;
        if (view.getContext().getResources().getConfiguration().getLayoutDirection() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            bmu.setCornerRadius(new float[] {
                0.0F, f, f, 0.0F
            });
        } else
        {
            bmu.setCornerRadius(new float[] {
                f, 0.0F, 0.0F, f
            });
        }
        if (blC != null)
        {
            view.setOnClickListener(this);
        }
    }

    public final void onClick(View view)
    {
        boolean flag;
        if (bmB.blR > 0.2F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            blC._mth02CA(bmB.aVl, new xk(xf.if.aRR));
            return;
        } else
        {
            blC.onCancel();
            return;
        }
    }

    public final boolean FE76(String s, String s1)
    {
        return bmD != null && (bmD.FEF3(s) || bmD.FF3F(s1));
    }
}
