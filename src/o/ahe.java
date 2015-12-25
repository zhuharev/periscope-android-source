// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.widget.EditText;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import tv.periscope.android.api.ApiManager;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            acy, auf, aug, agp, 
//            atr, adx, apb, wr, 
//            xw, ahw, atn, aey, 
//            adc, aqf, zp

final class ahe extends acy
{

    private agp ble;

    ahe(agp agp1, agp agp2, ApiManager apimanager, zp zp, aqf aqf1)
    {
        ble = agp1;
        super(agp2, apimanager, zp, aqf1);
    }

    public final void _mth02CA(String s, String s1, String s2, String s3, auf auf1)
    {
        super._mth02CA(s, s1, s2, s3, auf1);
        if (auf1 != null && auf1._mth1F35() != null)
        {
            s1 = ble;
            if (s1._mth02CA(aug.bEz))
            {
                s2 = ((agp) (s1)).aVa;
                s3 = ((agp) (s1)).bkw.fC();
                Object obj3 = ((agp) (s1)).bkw.fx();
                Object obj1 = ((agp) (s1)).aWS.username;
                Object obj2 = ((agp) (s1)).aWS.displayName;
                String s4 = ((agp) (s1)).aWS.id;
                String s5 = ((agp) (s1)).aWS.getProfileUrlMedium();
                Object obj = ((agp) (s1)).bkv;
                long l;
                if (((adx) (obj)).bfX == 0.0D)
                {
                    l = apb.ec().getTime();
                } else
                {
                    l = (long)((((adx) (obj)).bfX - 2208988800D) * 1000D);
                }
                long l1 = apb.ec().getTime();
                obj = auf1._mth1F35();
                Object obj4 = new aud.if();
                obj4.bEx = Integer.valueOf(0);
                obj3 = ((auf.if) (obj4))._mth02CB(Integer.valueOf(2))._mth02CB(aug.bEM)._mth0407(((String) (obj3)));
                obj4 = wr._mth05D9(l);
                obj1 = ((auf.if) (obj3))._mth0640(BigInteger.valueOf(((wr) (obj4)).VE >>> 32 & 0xffffffffL).multiply(BigInteger.valueOf(0x100000000L)).add(BigInteger.valueOf(((wr) (obj4)).VE & 0xffffffffL)))._mth0630(UUID.randomUUID().toString())._mth0719(((String) (obj1)))._mth0E07(((String) (obj2)))._mth1426(s5)._mth0433(s4)._mth02CB(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())));
                obj2 = wr._mth05D9(l1);
                s2._mth02CA(s3, ((auf.if) (obj1))._mth1427(BigInteger.valueOf(((wr) (obj2)).VE >>> 32 & 0xffffffffL).multiply(BigInteger.valueOf(0x100000000L)).add(BigInteger.valueOf(((wr) (obj2)).VE & 0xffffffffL)))._mth1D16(((String) (obj))).gG());
            }
            ((agp) (s1)).bhC.add(auf1._mth1F35());
            ((android.support.v7.widget.RecyclerView.if) (((agp) (s1)).bgV.bml)).ey.notifyChanged();
        }
        if (agp._mth02CD(ble) != null && agp._mth02CD(ble).fo().fd().equals(s))
        {
            ble.finish();
        }
    }

    public final void _mth02CA(adc adc1)
    {
        super._mth02CA(adc1);
        agp._mth02CC(ble).bhT.clearFocus();
    }

    public final void _mth1D65(Object obj)
    {
        super._mth02CA((adc)obj);
        agp._mth02CC(ble).bhT.clearFocus();
    }

    public final void FE70(String s)
    {
        if (agp._mth037A(ble) != null && !agp._mth037A(ble).equals(s))
        {
            super.FE70(s);
            return;
        }
        if (super.bdJ.buH)
        {
            super.bdJ._mth02CB(null);
        }
    }

    public final void FE97(String s)
    {
        if (agp._mth037A(ble) != null && !agp._mth037A(ble).equals(s))
        {
            super.FE97(s);
            return;
        }
        if (super.bdJ.buH)
        {
            super.bdJ._mth02CB(null);
        }
    }
}
