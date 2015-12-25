// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.widget.Toast;
import java.io.File;
import java.util.List;
import tv.periscope.android.api.AdjustBroadcastRankResponse;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            adk, aew, apl, acm, 
//            acl, zu, xf, agb, 
//            adp, ado, adn, adm, 
//            adq, adc, asm, aed, 
//            adh, acy, aex

final class adl
    implements adk
{

    final ApiManager bcW;
    private final asm bek;
    final apl bev;
    private final agb bew;
    private final aew bex;
    private boolean bey;
    private final Activity mActivity;

    public adl(Activity activity, ApiManager apimanager, apl apl1, asm asm1, agb agb1, aew aew1)
    {
        mActivity = activity;
        bcW = apimanager;
        bev = apl1;
        bek = asm1;
        bew = agb1;
        bex = aew1;
    }

    public adl(aed aed, ApiManager apimanager, adh adh, acy acy, agb agb1, aex aex)
    {
        this(((Activity) (aed)), apimanager, ((apl) (adh)), ((asm) (acy)), null, ((aew) (aex)));
    }

    public final void aX()
    {
        bex.aX();
        if (bev != null)
        {
            bev.dC();
        }
    }

    public final void aY()
    {
        bex.aY();
        if (bev != null)
        {
            bev.dC();
        }
    }

    public final boolean aZ()
    {
        return bex.aZ();
    }

    public final boolean ba()
    {
        return bey;
    }

    public final boolean bb()
    {
        return (new acm(mActivity)).aH().bdl;
    }

    public final void onEventMainThread(zu zu1)
    {
        static final class _cls1
        {

            static final int $SwitchMap$tv$periscope$android$event$ApiEvent$Type[];

            static 
            {
                $SwitchMap$tv$periscope$android$event$ApiEvent$Type = new int[zu.if.values().length];
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXQ.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXO.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXL.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXR.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
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
                xf._mth02CA(xf.if.aSe);
                Toast.makeText(mActivity, 0x7f06013e, 0).show();
                return;
            } else
            {
                xf._mth02CA(xf.if.aSg);
                Toast.makeText(mActivity, 0x7f06013d, 0).show();
                return;
            }

        case 2: // '\002'
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
                Toast.makeText(mActivity, 0x7f06008c, 0).show();
                bcW.megaBroadcastCall();
                return;
            } else
            {
                Toast.makeText(mActivity, 0x7f06008b, 0).show();
                return;
            }

        case 3: // '\003'
            boolean flag2;
            if (zu1.aXl == null && zu1.mU == null)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (flag2)
            {
                Toast.makeText(mActivity, 0x7f060132, 0).show();
                return;
            } else
            {
                Toast.makeText(mActivity, 0x7f060131, 0).show();
                return;
            }

        case 4: // '\004'
            break;
        }
        boolean flag3;
        if (zu1.aXl == null && zu1.mU == null)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (flag3)
        {
            zu1 = (AdjustBroadcastRankResponse)zu1.data;
            Toast.makeText(mActivity, ((AdjustBroadcastRankResponse) (zu1)).summary, 1).show();
            return;
        } else
        {
            Toast.makeText(mActivity, "Sorry, we could not adjust the broadcast rank", 0).show();
            return;
        }
    }

    public final void _mth0130(String s)
    {
        if (bew != null)
        {
            bew._mth071D(s);
        }
        if (bev != null)
        {
            bev.dC();
        }
    }

    public final void _mth0196(String s)
    {
        bcW.increaseBroadcastRank(s);
        if (bev != null)
        {
            bev.dC();
        }
    }

    public final void _mth0279(String s)
    {
        bcW.decreaseBroadcastRank(s);
        if (bev != null)
        {
            bev.dC();
        }
    }

    public final void _mth02B6(String s)
    {
        (new android.app.AlertDialog.Builder(mActivity)).setMessage(mActivity.getString(0x7f06008a)).setNegativeButton(0x7f060088, null).setPositiveButton(0x7f060089, new adp(this, s)).show();
    }

    public final void _mth02BF(String s)
    {
        (new android.app.AlertDialog.Builder(mActivity)).setMessage(mActivity.getString(0x7f06013c)).setNegativeButton(0x7f06013a, new ado(this)).setPositiveButton(0x7f06013b, new adn(this, s)).setOnCancelListener(new adm(this)).show();
    }

    public final void _mth03CA(String s)
    {
        (new android.app.AlertDialog.Builder(mActivity)).setMessage(mActivity.getString(0x7f060130)).setNegativeButton(0x7f06012e, null).setPositiveButton(0x7f06012f, new adq(this, s)).show();
    }

    public final String _mth05D2(String s)
    {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES), "Periscope");
        if (!file.exists())
        {
            file.mkdir();
        }
        return (new File(file, (new StringBuilder("ps")).append(s).append(".mp4").toString())).getAbsolutePath();
    }

    public final void _mth05D6(String s)
    {
        bey = true;
        s = _mth05D2(s);
        MediaScannerConnection.scanFile(mActivity, new String[] {
            s
        }, new String[] {
            "video/mp4"
        }, null);
    }

    public final void _mth05DF(String s)
    {
        bek._mth1D65(new adc(s, null));
    }

    public final void _mth1FBE(List list)
    {
        if (bev != null)
        {
            bev._mth02CB(null, list);
        }
    }

    public final void FE78(boolean flag)
    {
        bey = flag;
    }
}
