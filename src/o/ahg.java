// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.widget.Toast;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import java.math.BigInteger;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            agp, agl, xj, xf, 
//            aug, atr, adx, apb, 
//            wr, abc, xw

final class ahg extends Callback
{

    private agp ble;
    private xj blm;

    ahg(agp agp1, xj xj1)
    {
        ble = agp1;
        blm = xj1;
        super();
    }

    public final void failure(TwitterException twitterexception)
    {
        Toast.makeText(ble, 0x7f060151, 0).show();
        agp._mth0640(ble).bW();
    }

    public final void success(Result result)
    {
        if (blm != null)
        {
            xf._mth02CA(blm.aSZ);
        }
        if (ble.isFinishing())
        {
            return;
        }
        Toast.makeText(ble, 0x7f060152, 0).show();
        agp._mth0640(ble).bW();
        if (agp._mth02CA(ble, aug.bEL))
        {
            Object obj1 = agp._mth02CD(ble).fx();
            result = agp._mth1427(ble).username;
            Object obj = agp._mth1427(ble).displayName;
            String s = agp._mth1427(ble).id;
            int i = agp._mth02CD(ble).fw();
            Object obj2 = agp._mth02CF(ble);
            long l;
            if (((adx) (obj2)).bfX == 0.0D)
            {
                l = apb.ec().getTime();
            } else
            {
                l = (long)((((adx) (obj2)).bfX - 2208988800D) * 1000D);
            }
            long l1 = apb.ec().getTime();
            obj2 = new aud.if();
            obj2.bEx = Integer.valueOf(0);
            obj1 = ((auf.if) (obj2))._mth02CB(Integer.valueOf(2))._mth02CB(aug.bEL)._mth0407(((String) (obj1)));
            obj2 = wr._mth05D9(l);
            result = ((auf.if) (obj1))._mth0640(BigInteger.valueOf(((wr) (obj2)).VE >>> 32 & 0xffffffffL).multiply(BigInteger.valueOf(0x100000000L)).add(BigInteger.valueOf(((wr) (obj2)).VE & 0xffffffffL)))._mth02CB(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())))._mth0433(s)._mth0719(result)._mth0E07(((String) (obj)))._mth0630(UUID.randomUUID().toString())._mth02CE(Integer.valueOf(i));
            obj = wr._mth05D9(l1);
            result = result._mth1427(BigInteger.valueOf(((wr) (obj)).VE >>> 32 & 0xffffffffL).multiply(BigInteger.valueOf(0x100000000L)).add(BigInteger.valueOf(((wr) (obj)).VE & 0xffffffffL))).gG();
            if ((agp._mth1428(ble) & 2) == 2)
            {
                agp.FE73(ble).log("suppressing share on twitter, already sent.");
                return;
            }
            agp._mth02CA(ble, 2);
            agp.FF9E(ble)._mth02CA(agp._mth02CD(ble).fC(), result);
        }
    }
}
