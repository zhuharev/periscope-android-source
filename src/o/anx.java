// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.SharedPreferences;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.util.Map;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            asn, any, arc, xd, 
//            zp, zs, zd, aqt, 
//            aui, aan, _cls1D3C, _cls1D5A, 
//            _cls1D27, aao, _cls1647, _cls0443, 
//            aok

public class anx
    implements asn
{

    private aan bnb;

    public anx()
    {
    }

    public final volatile void _mth02CA(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc, PsUser psuser, int i)
    {
        _mth02CA((any)_pcls02cc, (PsUser)psuser, i);
    }

    public final void _mth02CA(any any1, PsUser psuser, int i)
    {
label0:
        {
label1:
            {
                any1.user = psuser;
                any1.btO.setText(psuser.displayName);
                if (any1.btR != null)
                {
                    arc arc1 = any1.btR;
                    byte byte0;
                    if (psuser.isMuted)
                    {
                        byte0 = 0;
                    } else
                    {
                        byte0 = 8;
                    }
                    arc1.setVisibility(byte0);
                }
                if (!psuser.id.equals(xd._mth1FEA().aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVC").get(null), null)) && !psuser.isBlocked)
                {
                    zp zp1 = xd._mth1FEA();
                    String s1 = psuser.id;
                    if (!((zd)zp1.aWI.get(zs.aXa))._mth14EA(s1))
                    {
                        break label1;
                    }
                }
                any1.bus.setVisibility(8);
                break label0;
            }
            any1.bus.setVisibility(0);
        }
        any1.bus.setChecked(_mth02CB(psuser));
        String s = psuser.getProfileUrlSmall();
        if (aui._mth02BF(s))
        {
            psuser = any1.btM.getContext();
            if (bnb == null)
            {
                bnb = new aan(psuser);
            }
            ((_cls1D27)_cls1D3C._mth1427(psuser)._mth02CA(java/lang/String).FF70(s))._mth02CB(aao.baq)._mth05D5(0x7f020049)._mth02CA(new _cls0443[] {
                bnb
            })._mth0197()._mth02CA(any1.btM);
            return;
        } else
        {
            aok._mth02CA(any1.btM, psuser.displayName, i + 1);
            return;
        }
    }

    protected boolean _mth02CB(PsUser psuser)
    {
        return psuser.isFollowing;
    }
}
