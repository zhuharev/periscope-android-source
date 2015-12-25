// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package o:
//            aob, auf, aug, apk, 
//            xd, zp, asm, afx, 
//            arx, acy, agp, qh, 
//            xk, apo, xf

final class adh extends aob
{
    final class if extends _cls02CA
    {

        private adh bem;

        public final apo aV()
        {
            return apo.byX;
        }

        protected final void aW()
        {
            xf._mth02CF(adh._mth02CB(bem));
            bem.bek._mth02CA(ben.fd(), ben.gj(), bei, ben.fx(), ben);
        }

        public final int getIconResId()
        {
            return 0x7f0200d1;
        }

        public final int getIconTint()
        {
            return 0x7f0c0056;
        }

        public final String _mth1D36(Context context)
        {
            return context.getString(0x7f06003a);
        }

        if(String s, auf auf1, asm asm1, xk xk)
        {
            bem = adh.this;
            super(s, auf1, asm1, xk);
        }
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}


    final asm bek;
    final afx bel;

    public adh(arx arx, apk apk1, acy acy, agp agp, qh qh)
    {
        super(arx, apk1, qh);
        bek = acy;
        bel = agp;
    }

    static qh _mth02CA(adh adh1)
    {
        return adh1.buP;
    }

    static qh _mth02CB(adh adh1)
    {
        return adh1.buP;
    }

    public final void _mth02CA(String s, auf auf1, xk xk, boolean flag)
    {
        String s1;
        if (auf1.go() == aug.bEz)
        {
            s1 = buO.getResources().getString(0x7f060036, new Object[] {
                auf1.gj(), auf1.eI()
            });
        } else
        {
            s1 = buO.getResources().getString(0x7f060037, new Object[] {
                auf1.gj()
            });
        }
        ArrayList arraylist = new ArrayList();
        boolean flag1;
        if (!auf1.fd().equals(xd._mth1FEA().aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVC").get(null), null)))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag && bel != null && flag1)
        {
            arraylist.add(new _cls02CB(s, auf1, bek, xk));
        }
        arraylist.add(new _cls02CE(s, auf1, bek, xk));
        if (flag1)
        {
            arraylist.add(new if(s, auf1, bek, xk));
        }
        _mth02CB(s1, arraylist);
    }
}
