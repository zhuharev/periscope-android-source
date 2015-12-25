// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import com.digits.sdk.android.Digits;
import com.digits.sdk.android.DigitsSession;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterSession;
import tv.periscope.android.LaunchActivity;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            aos, ack, aci, acj, 
//            _cls0675, zp

public class ach
{

    final ApiManager bcW;
    final ack mSessionManager;
    final zp mUserManager;

    public ach(ack ack1, zp zp, ApiManager apimanager)
    {
        mSessionManager = ack1;
        mUserManager = zp;
        bcW = apimanager;
    }

    public String _mth02CA(Context context, DigitsSession digitssession, String s)
    {
        TwitterAuthToken twitterauthtoken = (TwitterAuthToken)digitssession.getAuthToken();
        return bcW.login(twitterauthtoken.secret, twitterauthtoken.token, null, String.valueOf(digitssession.getId()), s, aos._mth1D4B(context), acj.if.bdc);
    }

    public String _mth02CA(Context context, TwitterSession twittersession)
    {
        TwitterAuthToken twitterauthtoken = (TwitterAuthToken)twittersession.getAuthToken();
        return bcW.login(twitterauthtoken.secret, twitterauthtoken.token, twittersession.getUserName(), String.valueOf(twittersession.getUserId()), null, aos._mth1D4B(context), acj.if.bdb);
    }

    public String _mth02CA(LaunchActivity launchactivity)
    {
label0:
        {
            Object obj;
label1:
            {
                obj = mSessionManager;
                if (((ack) (obj)).bde == null)
                {
                    ((ack) (obj)).aG();
                }
                obj = ((ack) (obj)).bde;
                if (obj == null)
                {
                    break label0;
                }
                switch (aci.bcX[((acj) (obj)).bcZ.ordinal()])
                {
                default:
                    return null;

                case 1: // '\001'
                    obj = _cls141D.if._mth02CA(((acj) (obj)), mUserManager);
                    if (obj != null)
                    {
                        return _mth02CA(((Context) (launchactivity)), ((TwitterSession) (obj)));
                    } else
                    {
                        _cls0675._mth02CB(new IllegalStateException("TwitterSession is null, skipping login"));
                        return null;
                    }

                case 2: // '\002'
                    break;
                }
                if (obj != null && ((acj) (obj)).bcZ == acj.if.bdc)
                {
                    obj = (DigitsSession)Digits.getSessionManager().getActiveSession();
                    if (((DigitsSession) (obj)).getAuthToken() instanceof TwitterAuthToken)
                    {
                        break label1;
                    }
                    Digits.getSessionManager().clearActiveSession();
                }
                obj = null;
            }
            if (obj != null)
            {
                return _mth02CA(((Context) (launchactivity)), ((DigitsSession) (obj)), null);
            }
            _cls0675._mth02CB(new IllegalStateException("DigitsSession is null, skipping login"));
        }
        return null;
    }
}
