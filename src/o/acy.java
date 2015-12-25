// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tv.periscope.android.api.ApiManager;
import tv.periscope.android.api.GetUserResponse;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            aqo, aqf, agp, zu, 
//            zw, anh, zr, zp, 
//            xf, adc, aui, acz, 
//            yo, yq, anb, auf

public class acy
    implements aqo
{

    final ApiManager bcW;
    public final aqf bdJ;
    private final asc.if bdK;
    private final Context mContext;
    private final zp mUserManager;

    public acy(Context context, ApiManager apimanager, zp zp1, aqf aqf1)
    {
        this(context, apimanager, zp1, aqf1, null);
    }

    public acy(Context context, ApiManager apimanager, zp zp1, aqf aqf1, anb anb)
    {
        mContext = context;
        bcW = apimanager;
        mUserManager = zp1;
        bdJ = aqf1;
        bdK = anb;
    }

    private void _mth02CA(String s, ahi.if if1)
    {
        bdJ._mth02CB(null);
        Intent intent = new Intent(mContext, o/agp);
        intent.putExtra("e_b_id", s);
        intent.putExtra("e_p_mode", if1);
        mContext.startActivity(intent);
    }

    public final void aN()
    {
        if (bdJ.buH)
        {
            bdJ._mth02CB(null);
        }
    }

    public final boolean aO()
    {
        return bdJ.buH;
    }

    public void onEventMainThread(zu zu1)
    {
label0:
        {
label1:
            {
label2:
                {
                    static final class _cls1
                    {

                        static final int $SwitchMap$tv$periscope$android$event$ApiEvent$Type[];
                        static final int bcB[];

                        static 
                        {
                            $SwitchMap$tv$periscope$android$event$ApiEvent$Type = new int[zu.if.values().length];
                            try
                            {
                                $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXq.ordinal()] = 1;
                            }
                            catch (NoSuchFieldError nosuchfielderror) { }
                            bcB = new int[zw.values().length];
                            try
                            {
                                bcB[zw.aYI.ordinal()] = 1;
                            }
                            catch (NoSuchFieldError nosuchfielderror1) { }
                            try
                            {
                                bcB[zw.aYD.ordinal()] = 2;
                            }
                            catch (NoSuchFieldError nosuchfielderror2) { }
                            try
                            {
                                bcB[zw.aYC.ordinal()] = 3;
                            }
                            catch (NoSuchFieldError nosuchfielderror3) { }
                            try
                            {
                                bcB[zw.aYE.ordinal()] = 4;
                            }
                            catch (NoSuchFieldError nosuchfielderror4) { }
                            try
                            {
                                bcB[zw.aYx.ordinal()] = 5;
                            }
                            catch (NoSuchFieldError nosuchfielderror5) { }
                            try
                            {
                                bcB[zw.aYy.ordinal()] = 6;
                            }
                            catch (NoSuchFieldError nosuchfielderror6) { }
                            try
                            {
                                bcB[zw.aYz.ordinal()] = 7;
                            }
                            catch (NoSuchFieldError nosuchfielderror7) { }
                            try
                            {
                                bcB[zw.aYA.ordinal()] = 8;
                            }
                            catch (NoSuchFieldError nosuchfielderror8) { }
                            try
                            {
                                bcB[zw.aYN.ordinal()] = 9;
                            }
                            catch (NoSuchFieldError nosuchfielderror9) { }
                            try
                            {
                                bcB[zw.aYO.ordinal()] = 10;
                            }
                            catch (NoSuchFieldError nosuchfielderror10) { }
                            try
                            {
                                bcB[zw.aYP.ordinal()] = 11;
                            }
                            catch (NoSuchFieldError nosuchfielderror11) { }
                        }
                    }

                    switch (_cls1..SwitchMap.tv.periscope.android.event.ApiEvent.Type[zu1.aXk.ordinal()])
                    {
                    default:
                        return;

                    case 1: // '\001'
                        break;
                    }
                    if (!bdJ.buH)
                    {
                        break label0;
                    }
                    boolean flag;
                    if (zu1.aXl == null && zu1.mU == null)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (!flag)
                    {
                        break label1;
                    }
                    GetUserResponse getuserresponse = (GetUserResponse)zu1.data;
                    zu1 = bdJ;
                    if (((aqf) (zu1)).aWS == null)
                    {
                        zu1 = null;
                    } else
                    {
                        zu1 = ((aqf) (zu1)).aWS.id;
                    }
                    if (zu1 != null)
                    {
                        String s = getuserresponse.user.id;
                        zu1 = bdJ;
                        if (((aqf) (zu1)).aWS == null)
                        {
                            zu1 = null;
                        } else
                        {
                            zu1 = ((aqf) (zu1)).aWS.id;
                        }
                        if (!s.equals(zu1))
                        {
                            break label2;
                        }
                    }
                    bdJ._mth02CF(getuserresponse.user);
                }
                return;
            }
            zu1 = bdJ;
            zu1.bAI = true;
            zu1._mth02CB(null);
            Toast.makeText(mContext, 0x7f06012c, 1).show();
        }
    }

    public void onEventMainThread(zw zw1)
    {
        switch (_cls1.bcB[zw1.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            if (bdJ.buH)
            {
                zw1 = bdJ;
                if (((aqf) (zw1)).aWS != null)
                {
                    Iterator iterator = ((aqf) (zw1)).bzZ.iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        android.support.v7.widget.RecyclerView.if if1 = ((RecyclerView)iterator.next()).dF;
                        if (if1 != null)
                        {
                            if (if1 instanceof anh)
                            {
                                ((anh)if1).btU.A();
                            } else
                            {
                                zw1.FB58(((aqf) (zw1)).aWS.id);
                            }
                            if1.ey.notifyChanged();
                        }
                    } while (true);
                }
                return;
            }
            break;

        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
            if (!bdJ.buH)
            {
                break;
            }
            zw1 = bdJ;
            if (((aqf) (zw1)).aWS != null)
            {
                zp zp1 = ((aqf) (zw1)).mUserManager;
                String s = ((aqf) (zw1)).aWS.id;
                zw1._mth02CF((PsUser)zp1.aWM.get(s));
            }
            break;
        }
    }

    public void _mth02CA(String s, String s1, String s2, String s3, auf auf)
    {
        xf._mth02CA(xf.if.aSG);
        bcW.block(s, s2, s3, auf);
    }

    public void _mth02CA(adc adc1)
    {
        if (adc1 == null)
        {
            return;
        }
        if (mUserManager.aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVC").get(null), null) != null && mUserManager.aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVC").get(null), null).equals(adc1.id) || mUserManager.aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVB").get(null), null) != null && mUserManager.aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVB").get(null), null).equals(adc1.username))
        {
            xf._mth02CA(xf.if.aSB);
        } else
        {
            xf._mth02CA(xf.if.aSC);
        }
        if (aui._mth02BF(adc1.id))
        {
            if (bdJ.buH)
            {
                bdJ._mth02CB(adc1);
            } else
            {
                bcW.getUserById(adc1.id);
                bcW.getUserBroadcastsByUserId(adc1.id);
                aqf aqf1 = bdJ;
                aqf1.bAl.setImageDrawable(null);
                aqf1.aWS = null;
                aqf1._mth1D4F("-1");
                aqf1 = bdJ;
                zp zp1 = mUserManager;
                adc1 = adc1.id;
                aqf1._mth02CF((PsUser)zp1.aWM.get(adc1));
            }
        } else
        if (aui._mth02BF(adc1.username))
        {
            aqf aqf2 = bdJ;
            aqf2.bAl.setImageDrawable(null);
            aqf2.aWS = null;
            aqf2._mth1D4F("-1");
            bcW.getUserByUsername(adc1.username);
            if (bdJ.buH)
            {
                bdJ._mth02CB(adc1);
            } else
            {
                bcW.getUserBroadcastsByUsername(adc1.username);
            }
        }
        if (bdK != null)
        {
            bdK.du();
        }
        bdJ.show();
    }

    public void _mth1D65(Object obj)
    {
        _mth02CA((adc)obj);
    }

    public final void _mth2160(String s)
    {
        bcW.getFollowingById(s);
    }

    public final void _mth2170(String s)
    {
        bcW.getFollowersById(s);
    }

    public final void _mth4E36(String s)
    {
        bcW.follow(s);
    }

    public final void FB54(String s)
    {
        bcW.mute(s);
    }

    public final void FB60(String s)
    {
        bcW.unmute(s);
    }

    public final void FBE6(String s)
    {
        bcW.unfollow(s);
    }

    public final void FBE9(String s)
    {
        (new android.app.AlertDialog.Builder(mContext)).setMessage(mContext.getString(0x7f06016e)).setNegativeButton(0x7f06004b, null).setPositiveButton(0x7f06016d, new acz(this, s)).show();
    }

    public final void FBFE(String s)
    {
        ((ClipboardManager)mContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(s, String.format("%s/%s", new Object[] {
            yo.aVs.n(), s
        })));
        Toast.makeText(mContext, 0x7f060126, 0).show();
    }

    public void FE70(String s)
    {
        _mth02CA(s, ahi.if.blu);
    }

    public void FE97(String s)
    {
        _mth02CA(s, ahi.if.blv);
    }
}
