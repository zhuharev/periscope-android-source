// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            asn, ang, aan, yu, 
//            zs, aos, aqt, arc, 
//            aui, _cls1D3C, _cls1D5A, _cls1D27, 
//            aao, _cls0443, _cls1647, aok

public class anf
    implements asn
{

    private aan bnb;
    private final yu btL;

    public anf(yu yu1)
    {
        btL = yu1;
    }

    public final void _mth02CA(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc, PsUser psuser, int i)
    {
        _pcls02cc = (ang)_pcls02cc;
        psuser = (PsUser)psuser;
        Object obj = ((ang) (_pcls02cc)).fy.getResources();
        bnb = new aan(((ang) (_pcls02cc)).fy.getContext());
        _pcls02cc.user = psuser;
        ((ang) (_pcls02cc)).btO.setText(psuser.displayName);
        if (TextUtils.isEmpty(psuser.description))
        {
            ((ang) (_pcls02cc)).btQ.setVisibility(8);
        } else
        {
            ((ang) (_pcls02cc)).btQ.setVisibility(0);
            ((ang) (_pcls02cc)).btQ.setText(psuser.description);
        }
        if (psuser.isVerified)
        {
            ((ang) (_pcls02cc)).btT.setVisibility(0);
        } else
        {
            ((ang) (_pcls02cc)).btT.setVisibility(8);
        }
        zs zs1 = btL._mth04C0(psuser.id);
        static final class _cls1
        {

            static final int btC[];

            static 
            {
                btC = new int[zs.values().length];
                try
                {
                    btC[zs.aXf.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    btC[zs.aXc.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    btC[zs.aXb.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    btC[zs.aXe.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    btC[zs.aXd.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
            }
        }

        if (zs1 == null)
        {
            ((ang) (_pcls02cc)).btP.setText("");
        } else
        {
            switch (_cls1.btC[zs1.ordinal()])
            {
            case 1: // '\001'
            case 2: // '\002'
                ((ang) (_pcls02cc)).btN.setVisibility(8);
                ((ang) (_pcls02cc)).btP.setText(((Resources) (obj)).getString(0x7f0600cb, new Object[] {
                    aos._mth02CA(((Resources) (obj)), psuser.numFollowers, true)
                }));
                break;

            case 3: // '\003'
                ((ang) (_pcls02cc)).btN.setVisibility(8);
                ((ang) (_pcls02cc)).btP.setText(((Resources) (obj)).getString(0x7f0600ce));
                break;

            case 4: // '\004'
                ((ang) (_pcls02cc)).btN.setVisibility(8);
                ((ang) (_pcls02cc)).btP.setText(((Resources) (obj)).getString(0x7f0600cb, new Object[] {
                    aos._mth02CA(((Resources) (obj)), psuser.numFollowers, true)
                }));
                break;

            default:
                ((ang) (_pcls02cc)).btN.setVisibility(0);
                ((ang) (_pcls02cc)).btP.setText(aos._mth02CA(((Resources) (obj)), psuser.getNumHearts(), false));
                break;
            }
        }
        ((ang) (_pcls02cc)).btS.setChecked(_mth02CB(psuser));
        if (((ang) (_pcls02cc)).btR != null)
        {
            obj = ((ang) (_pcls02cc)).btR;
            byte byte0;
            if (psuser.isMuted)
            {
                byte0 = 0;
            } else
            {
                byte0 = 8;
            }
            ((arc) (obj)).setVisibility(byte0);
        }
        obj = psuser.getProfileUrlSmall();
        if (aui._mth02BF(((CharSequence) (obj))))
        {
            ((_cls1D27)_cls1D3C._mth1427(((ang) (_pcls02cc)).fy.getContext())._mth02CA(java/lang/String).FF70(obj))._mth02CB(aao.baq)._mth02CA(new _cls0443[] {
                bnb
            })._mth05D5(0x7f020049)._mth0197()._mth02CA(((ang) (_pcls02cc)).btM);
            return;
        } else
        {
            aok._mth02CA(((ang) (_pcls02cc)).btM, psuser.displayName, i + 1);
            return;
        }
    }

    public boolean _mth02CB(PsUser psuser)
    {
        return psuser.isFollowing;
    }
}
