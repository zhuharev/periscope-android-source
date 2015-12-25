// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.widget.Toast;
import com.digits.sdk.android.Digits;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterCore;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import o.0675;
import o.abv;
import o.acf;
import o.acg;
import o.acj;
import o.ack;
import o.acl;
import o.acm;
import o.acn;
import o.aos;
import o.atd;
import o.atn;
import o.atp;
import o.atr;
import o.ats;
import o.att;
import o.aub;
import o.auf;
import o.auh;
import o.aui;
import o.ig;
import o.it;
import o.ql;
import o.qn;
import o.xd;
import o.xf;
import o.yv;
import o.zc;
import o.zd;
import o.zf;
import o.zm;
import o.zp;
import o.zs;
import o.zt;
import o.zu;
import o.zv;
import o.zw;
import o.zy;
import retrofit.RetrofitError;
import retrofit.client.Response;
import tv.periscope.android.signer.SignerService;

// Referenced classes of package tv.periscope.android.api:
//            BlockRequest, ApiClient, ApiService, ErrorResponse, 
//            ErrorResponseItem, PsUser, BroadcastMetaRequest, UserBroadcastsRequest, 
//            BarrierEventHandler, PlaybackMetaRequest, PsRequest, ChatStats, 
//            ApiEventHandler, TwitterLoginResponse, VerifyUsernameResponse, HelloResponse, 
//            WarningPhrases, GetUserResponse, FetchUsersResponse, SuggestedPeopleResponse, 
//            GetBroadcastRequest, GetBroadcastViewersResponse, MuteRequest, UnMuteRequest, 
//            FollowRequest, UnfollowRequest, ApiRunnable

public class ApiManager
{
    class EventHandler
        implements ApiEventHandler
    {

        final ApiManager this$0;

        private void handleEvent(zu zu1)
        {
            static class _cls2
            {

                static final int $SwitchMap$tv$periscope$android$api$ApiManager$FollowActionType[];
                static final int $SwitchMap$tv$periscope$android$event$ApiEvent$Type[];

                static 
                {
                    $SwitchMap$tv$periscope$android$api$ApiManager$FollowActionType = new int[FollowActionType.values().length];
                    try
                    {
                        $SwitchMap$tv$periscope$android$api$ApiManager$FollowActionType[FollowActionType.Follow.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$api$ApiManager$FollowActionType[FollowActionType.Unfollow.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$api$ApiManager$FollowActionType[FollowActionType.Mute.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$api$ApiManager$FollowActionType[FollowActionType.Unmute.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$api$ApiManager$FollowActionType[FollowActionType.Block.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$api$ApiManager$FollowActionType[FollowActionType.Unblock.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type = new int[o.zu.if.values().length];
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aXI.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror6) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aXC.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror7) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aXD.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror8) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aXm.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror9) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aXo.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror10) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aXp.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror11) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aXq.ordinal()] = 7;
                    }
                    catch (NoSuchFieldError nosuchfielderror12) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aXr.ordinal()] = 8;
                    }
                    catch (NoSuchFieldError nosuchfielderror13) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aXs.ordinal()] = 9;
                    }
                    catch (NoSuchFieldError nosuchfielderror14) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aXt.ordinal()] = 10;
                    }
                    catch (NoSuchFieldError nosuchfielderror15) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aYf.ordinal()] = 11;
                    }
                    catch (NoSuchFieldError nosuchfielderror16) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aXB.ordinal()] = 12;
                    }
                    catch (NoSuchFieldError nosuchfielderror17) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aXA.ordinal()] = 13;
                    }
                    catch (NoSuchFieldError nosuchfielderror18) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aXM.ordinal()] = 14;
                    }
                    catch (NoSuchFieldError nosuchfielderror19) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aXz.ordinal()] = 15;
                    }
                    catch (NoSuchFieldError nosuchfielderror20) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aXE.ordinal()] = 16;
                    }
                    catch (NoSuchFieldError nosuchfielderror21) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aXG.ordinal()] = 17;
                    }
                    catch (NoSuchFieldError nosuchfielderror22) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aYc.ordinal()] = 18;
                    }
                    catch (NoSuchFieldError nosuchfielderror23) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aXJ.ordinal()] = 19;
                    }
                    catch (NoSuchFieldError nosuchfielderror24) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aYi.ordinal()] = 20;
                    }
                    catch (NoSuchFieldError nosuchfielderror25) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aXO.ordinal()] = 21;
                    }
                    catch (NoSuchFieldError nosuchfielderror26) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aYj.ordinal()] = 22;
                    }
                    catch (NoSuchFieldError nosuchfielderror27) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aYd.ordinal()] = 23;
                    }
                    catch (NoSuchFieldError nosuchfielderror28) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aYe.ordinal()] = 24;
                    }
                    catch (NoSuchFieldError nosuchfielderror29) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aXv.ordinal()] = 25;
                    }
                    catch (NoSuchFieldError nosuchfielderror30) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aXw.ordinal()] = 26;
                    }
                    catch (NoSuchFieldError nosuchfielderror31) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aXu.ordinal()] = 27;
                    }
                    catch (NoSuchFieldError nosuchfielderror32) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aXx.ordinal()] = 28;
                    }
                    catch (NoSuchFieldError nosuchfielderror33) { }
                    try
                    {
                        $SwitchMap$tv$periscope$android$event$ApiEvent$Type[o.zu.if.aXy.ordinal()] = 29;
                    }
                    catch (NoSuchFieldError nosuchfielderror34) { }
                }
            }

            switch (_cls2..SwitchMap.tv.periscope.android.event.ApiEvent.Type[zu1.aXk.ordinal()])
            {
            default:
                return;

            case 2: // '\002'
            case 3: // '\003'
                break;

            case 4: // '\004'
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
                    Object obj6 = (TwitterLoginResponse)zu1.data;
                    mUserManager._mth02CA(((TwitterLoginResponse) (obj6)).user);
                    zu1 = mSessionManager;
                    String s = ((TwitterLoginResponse) (obj6)).cookie;
                    obj6 = ((TwitterLoginResponse) (obj6)).sessionType;
                    android.content.SharedPreferences.Editor editor = ((ack) (zu1)).aQC.edit();
                    editor.putString((String)o.yp.CON._mth02CA("o.yp").getField("aVT").get(null), s);
                    editor.putString((String)o.yp.CON._mth02CA("o.yp").getField("aVU").get(null), ((o.acj.if) (obj6)).name());
                    editor.apply();
                    zu1.bde = new acj(s, ((o.acj.if) (obj6)));
                    mEventBus._mth1429(zv.aYv);
                    return;
                }
                break;

            case 5: // '\005'
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
                    zu1 = (VerifyUsernameResponse)zu1.data;
                    mUserManager._mth02CA(((VerifyUsernameResponse) (zu1)).user);
                    mUserManager.aQC.edit().putBoolean((String)o.yp.CON._mth02CA("o.yp").getField("aVP").get(null), true).apply();
                    return;
                }
                break;

            case 6: // '\006'
                boolean flag2;
                if (zu1.aXl == null && zu1.mU == null)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if (!flag2)
                {
                    break;
                }
                zt zt1;
                Object obj7;
                for (zu1 = ((HelloResponse)zu1.data).warningPhrases.iterator(); zu1.hasNext(); zt1.aXj.addAll(((Collection) (obj7))))
                {
                    obj7 = (WarningPhrases)zu1.next();
                    zt1 = mWordManager;
                    obj7 = ((WarningPhrases) (obj7)).words;
                }

                return;

            case 7: // '\007'
                boolean flag3;
                if (zu1.aXl == null && zu1.mU == null)
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
                if (!flag3)
                {
                    break;
                }
                Object obj = (GetUserResponse)zu1.data;
                if (Objects.equals(((GetUserResponse) (obj)).user.id, mUserManager.aQC.getString((String)o.yp.CON._mth02CA("o.yp").getField("aVC").get(null), null)))
                {
                    mUserManager._mth02CA(((GetUserResponse) (obj)).user);
                }
                zu1 = mUserManager;
                obj = ((GetUserResponse) (obj)).user;
                ((zp) (zu1)).aWM.put(((PsUser) (obj)).id, obj);
                ((zp) (zu1)).mEventBus._mth1429(zw.aYE);
                return;

            case 8: // '\b'
                boolean flag4;
                if (zu1.aXl == null && zu1.mU == null)
                {
                    flag4 = true;
                } else
                {
                    flag4 = false;
                }
                if (!flag4)
                {
                    break;
                }
                Object obj1 = (FetchUsersResponse)zu1.data;
                if (Objects.equals(((FetchUsersResponse) (obj1)).ownerId, mUserManager.aQC.getString((String)o.yp.CON._mth02CA("o.yp").getField("aVC").get(null), null)))
                {
                    zu1 = mUserManager;
                    obj1 = ((FetchUsersResponse) (obj1)).users;
                    zu1._mth02CA(zs.aWX, ((zp) (zu1)).aQC.getString((String)o.yp.CON._mth02CA("o.yp").getField("aVC").get(null), null), ((List) (obj1)));
                    return;
                } else
                {
                    mUserManager._mth02CA(zs.aWX, ((FetchUsersResponse) (obj1)).ownerId, ((FetchUsersResponse) (obj1)).users);
                    return;
                }

            case 9: // '\t'
                boolean flag5;
                if (zu1.aXl == null && zu1.mU == null)
                {
                    flag5 = true;
                } else
                {
                    flag5 = false;
                }
                if (!flag5)
                {
                    break;
                }
                Object obj2 = (FetchUsersResponse)zu1.data;
                if (Objects.equals(((FetchUsersResponse) (obj2)).ownerId, mUserManager.aQC.getString((String)o.yp.CON._mth02CA("o.yp").getField("aVC").get(null), null)))
                {
                    zu1 = mUserManager;
                    obj2 = ((FetchUsersResponse) (obj2)).users;
                    zu1._mth02CA(zs.aWY, ((zp) (zu1)).aQC.getString((String)o.yp.CON._mth02CA("o.yp").getField("aVC").get(null), null), ((List) (obj2)));
                    return;
                } else
                {
                    mUserManager._mth02CA(zs.aWY, ((FetchUsersResponse) (obj2)).ownerId, ((FetchUsersResponse) (obj2)).users);
                    return;
                }

            case 10: // '\n'
                boolean flag6;
                if (zu1.aXl == null && zu1.mU == null)
                {
                    flag6 = true;
                } else
                {
                    flag6 = false;
                }
                if (flag6)
                {
                    zu1 = (List)zu1.data;
                    ((zd)mUserManager.aWI.get(zs.aWZ))._mth02BD(zu1);
                    return;
                }
                break;

            case 11: // '\013'
                boolean flag7;
                if (zu1.aXl == null && zu1.mU == null)
                {
                    flag7 = true;
                } else
                {
                    flag7 = false;
                }
                if (flag7)
                {
                    Object obj8 = (List)zu1.data;
                    zu1 = mUserManager;
                    zd zd1 = (zd)((zp) (zu1)).aWI.get(zs.aXa);
                    zd1._mth02BD(((List) (obj8)));
                    obj8 = ((zp) (zu1)).aQC.edit();
                    ((android.content.SharedPreferences.Editor) (obj8)).putInt((String)o.yp.CON._mth02CA("o.yp").getField("aVI").get(null), zd1.getUserCount());
                    ((android.content.SharedPreferences.Editor) (obj8)).putStringSet((String)o.yp.CON._mth02CA("o.yp").getField("aVL").get(null), new HashSet(zd1.y()));
                    ((android.content.SharedPreferences.Editor) (obj8)).apply();
                    ((zp) (zu1)).mEventBus._mth1429(zw.aYP);
                    return;
                }
                break;

            case 12: // '\f'
                boolean flag8;
                if (zu1.aXl == null && zu1.mU == null)
                {
                    flag8 = true;
                } else
                {
                    flag8 = false;
                }
                if (flag8)
                {
                    zu1 = (List)zu1.data;
                    String s1 = mUserManager.aQC.getString((String)o.yp.CON._mth02CA("o.yp").getField("aVC").get(null), null);
                    mUserManager._mth02CA(zs.aXf, s1, zu1);
                    return;
                }
                break;

            case 13: // '\r'
                boolean flag9;
                if (zu1.aXl == null && zu1.mU == null)
                {
                    flag9 = true;
                } else
                {
                    flag9 = false;
                }
                if (!flag9)
                {
                    break;
                }
                zu1 = (SuggestedPeopleResponse)zu1.data;
                zp zp1 = mUserManager;
                String s3 = zp1.aQC.getString((String)o.yp.CON._mth02CA("o.yp").getField("aVC").get(null), null);
                zp1._mth02CA(zs.aXc, s3, ((SuggestedPeopleResponse) (zu1)).featured);
                zp1._mth02CA(zs.aXb, s3, ((SuggestedPeopleResponse) (zu1)).twitter);
                if (((SuggestedPeopleResponse) (zu1)).hearted != null)
                {
                    Collections.sort(((SuggestedPeopleResponse) (zu1)).hearted, zm.aWE);
                }
                zp1._mth02CA(zs.aXd, s3, ((SuggestedPeopleResponse) (zu1)).hearted);
                zp1._mth02CA(zs.aXe, s3, ((SuggestedPeopleResponse) (zu1)).popular);
                zp1.C();
                return;

            case 14: // '\016'
                boolean flag10;
                if (zu1.aXl == null && zu1.mU == null)
                {
                    flag10 = true;
                } else
                {
                    flag10 = false;
                }
                if (flag10)
                {
                    Object obj3 = (ats)zu1.data;
                    zu1 = mBroadcastCacheManager;
                    obj3 = ((ats) (obj3)).fo();
                    ArrayList arraylist = new ArrayList(1);
                    arraylist.add(obj3);
                    zu1._mth02BC(arraylist);
                    return;
                }
                break;

            case 15: // '\017'
                boolean flag11;
                if (zu1.aXl == null && zu1.mU == null)
                {
                    flag11 = true;
                } else
                {
                    flag11 = false;
                }
                if (flag11)
                {
                    Object obj4 = (atr)zu1.data;
                    zu1 = mBroadcastCacheManager;
                    obj4 = ((atr) (obj4)).fo();
                    ArrayList arraylist1 = new ArrayList(1);
                    arraylist1.add(obj4);
                    zu1._mth02BC(arraylist1);
                    return;
                }
                break;

            case 16: // '\020'
                boolean flag12;
                if (zu1.aXl == null && zu1.mU == null)
                {
                    flag12 = true;
                } else
                {
                    flag12 = false;
                }
                if (!flag12)
                {
                    break;
                }
                List list = (List)zu1.data;
                HashSet hashset = new HashSet();
                for (Iterator iterator = list.iterator(); iterator.hasNext(); hashset.add(((atn)iterator.next()).id())) { }
                zu1 = new HashSet(((GetBroadcastRequest)zu1.request).ids);
                if (zu1.removeAll(hashset))
                {
                    mBroadcastCacheManager._mth02CB(zu1);
                }
                mBroadcastCacheManager._mth02BC(list);
                zu1 = mProfileManager;
                zu1._mth1D6A(((zf) (zu1)).aQC.getInt((String)o.yp.CON._mth02CA("o.yp").getField("aVJ").get(null), 0) + 1);
                return;

            case 17: // '\021'
                boolean flag13;
                if (zu1.aXl == null && zu1.mU == null)
                {
                    flag13 = true;
                } else
                {
                    flag13 = false;
                }
                if (flag13)
                {
                    zu1 = (GetBroadcastViewersResponse)zu1.data;
                    yv yv1 = mBroadcastCacheManager;
                    String s4 = ((GetBroadcastViewersResponse) (zu1)).broadcastId;
                    atd atd1 = new atd(((GetBroadcastViewersResponse) (zu1)).numWebWatched, ((GetBroadcastViewersResponse) (zu1)).numReplayWatched, ((GetBroadcastViewersResponse) (zu1)).numLiveWatched);
                    yv1.aWi.put(s4, atd1);
                    mUserManager._mth02CA(((GetBroadcastViewersResponse) (zu1)).broadcasterId, ((GetBroadcastViewersResponse) (zu1)).broadcastId, ((GetBroadcastViewersResponse) (zu1)).live, ((GetBroadcastViewersResponse) (zu1)).replay);
                    return;
                }
                break;

            case 18: // '\022'
                boolean flag14;
                if (zu1.aXl == null && zu1.mU == null)
                {
                    flag14 = true;
                } else
                {
                    flag14 = false;
                }
                if (flag14)
                {
                    Object obj5 = (atp)zu1.data;
                    zu1 = mBroadcastCacheManager;
                    obj5 = ((atp) (obj5)).fo();
                    ArrayList arraylist2 = new ArrayList(1);
                    arraylist2.add(obj5);
                    zu1._mth02BC(arraylist2);
                    return;
                }
                break;

            case 1: // '\001'
                boolean flag15;
                if (zu1.aXl == null && zu1.mU == null)
                {
                    flag15 = true;
                } else
                {
                    flag15 = false;
                }
                if (flag15)
                {
                    zu1 = (List)zu1.data;
                    mBroadcastCacheManager._mth141D(zu1);
                    return;
                } else
                {
                    mBroadcastCacheManager.s();
                    return;
                }

            case 19: // '\023'
                boolean flag16;
                if (zu1.aXl == null && zu1.mU == null)
                {
                    flag16 = true;
                } else
                {
                    flag16 = false;
                }
                if (flag16)
                {
                    zu1 = (List)zu1.data;
                    mBroadcastCacheManager._mth02BB(zu1);
                    return;
                } else
                {
                    mBroadcastCacheManager.r();
                    return;
                }

            case 20: // '\024'
                boolean flag17;
                if (zu1.aXl == null && zu1.mU == null)
                {
                    flag17 = true;
                } else
                {
                    flag17 = false;
                }
                if (!flag17)
                {
                    break;
                }
                zu1 = (aub)zu1.data;
                if (aui._mth02BF(zu1.fd()))
                {
                    mBroadcastCacheManager._mth02CA(zu1.fd(), zu1.gk());
                } else
                if (aui._mth02BF(zu1.gj()) && zu1.gk() != null && !zu1.gk().isEmpty())
                {
                    String s2 = ((atn)zu1.gk().get(0)).fd();
                    mBroadcastCacheManager._mth02CA(s2, zu1.gk());
                }
                if (Objects.equals(mUserManager.aQC.getString((String)o.yp.CON._mth02CA("o.yp").getField("aVC").get(null), null), zu1.fd()))
                {
                    mProfileManager._mth1D6A(zu1.gk().size());
                }
                return;

            case 21: // '\025'
                boolean flag18;
                if (zu1.aXl == null && zu1.mU == null)
                {
                    flag18 = true;
                } else
                {
                    flag18 = false;
                }
                if (flag18)
                {
                    zu1 = (att)zu1.data;
                    mBroadcastCacheManager._mth1449(zu1.fW());
                    return;
                }
                break;

            case 22: // '\026'
                if (mUserManager.aQC.getBoolean((String)o.yp.CON._mth02CA("o.yp").getField("aVP").get(null), false))
                {
                    getUser();
                    return;
                }
                break;

            case 23: // '\027'
            case 24: // '\030'
                BlockRequest blockrequest = (BlockRequest)zu1.request;
                if (blockrequest != null)
                {
                    handleFollowActionComplete(zu1, blockrequest.userId);
                    return;
                }
                break;

            case 25: // '\031'
                MuteRequest muterequest = (MuteRequest)zu1.request;
                if (muterequest != null)
                {
                    handleFollowActionComplete(zu1, muterequest.userId);
                    return;
                }
                break;

            case 26: // '\032'
                UnMuteRequest unmuterequest = (UnMuteRequest)zu1.request;
                if (unmuterequest != null)
                {
                    handleFollowActionComplete(zu1, unmuterequest.userId);
                    return;
                }
                break;

            case 27: // '\033'
                FollowRequest followrequest = (FollowRequest)zu1.request;
                if (followrequest != null)
                {
                    handleFollowActionComplete(zu1, followrequest.userId);
                    return;
                }
                break;

            case 28: // '\034'
                UnfollowRequest unfollowrequest = (UnfollowRequest)zu1.request;
                if (unfollowrequest != null)
                {
                    handleFollowActionComplete(zu1, unfollowrequest.userId);
                    return;
                }
                break;

            case 29: // '\035'
                boolean flag19;
                if (zu1.aXl == null && zu1.mU == null)
                {
                    flag19 = true;
                } else
                {
                    flag19 = false;
                }
                if (flag19)
                {
                    mEventBus._mth1429(zv.aYu);
                }
                break;
            }
        }

        private void handleUnauthorizedResponse(zu zu1)
        {
            Object obj = zu1.I();
            if (obj != null && ((ErrorResponse) (obj)).error.code == 64)
            {
                (new StringBuilder("Banned user detected for ")).append(zu1.aXk).append(", logging out.");
                switch (((ErrorResponse) (obj)).error.reason)
                {
                case 9: // '\t'
                case 10: // '\n'
                    doLogout(zv.aYs);
                    return;

                case 12: // '\f'
                    mEventBus._mth1429(zv.aYt);
                    return;
                }
                doLogout(zv.aYr);
                return;
            }
            obj = mSessionManager;
            if (((ack) (obj)).bde == null)
            {
                ((ack) (obj)).aG();
            }
            obj = ((ack) (obj)).bde;
            if (obj != null)
            {
                obj = ((acj) (obj)).bcY;
            } else
            {
                obj = null;
            }
            int i;
            if (obj != null)
            {
                i = ((String) (obj)).length();
            } else
            {
                i = 0;
            }
            _cls0675._mth02CB(new IllegalStateException((new StringBuilder("Unauthorized detected for ")).append(zu1.aXk).append(", logging out. Cookie length ").append(i).toString()));
            doLogout(zv.aYq);
        }

        public void onEventMainThread(zu zu1)
        {
            boolean flag;
            if (zu1.aXl == null && zu1.mU == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag && zu1.aXl.getResponse() != null)
            {
                int i;
                if (zu1.aXl != null && zu1.aXl.getResponse() != null)
                {
                    i = zu1.aXl.getResponse().getStatus();
                } else
                {
                    i = 520;
                }
                switch (i)
                {
                case 401: 
                    handleUnauthorizedResponse(zu1);
                    return;

                case 403: 
                    ErrorResponse errorresponse = zu1.I();
                    if (errorresponse != null && errorresponse.error.code == 1)
                    {
                        Toast.makeText(mContext, 0x7f06017e, 0).show();
                    }
                    break;
                }
            }
            handleEvent(zu1);
            mEventBus._mth1429(zu1);
        }

        public void onEventMainThread(final zy retry)
        {
            class _cls1
                implements Runnable
            {

                final EventHandler this$1;
                final zy val$retry;

                public void run()
                {
                    mConnection._mth02CA(retry.aYT);
                }

                _cls1()
                {
                    this$1 = EventHandler.this;
                    retry = zy1;
                    super();
                }
            }

            mMainHandler.postDelayed(new _cls1(), retry.aYT.getCurrentBackoff());
        }

        EventHandler()
        {
            this$0 = ApiManager.this;
            super();
        }
    }

    class FollowAction
    {

        public PsRequest request;
        final ApiManager this$0;
        public FollowActionType type;

        public String toString()
        {
            return (new StringBuilder("FollowAction(")).append(type).append(", ").append(request).append(")").toString();
        }

        public FollowAction(FollowActionType followactiontype, PsRequest psrequest)
        {
            this$0 = ApiManager.this;
            super();
            type = followactiontype;
            request = psrequest;
        }
    }

    static final class FollowActionType extends Enum
    {

        private static final FollowActionType $VALUES[];
        public static final FollowActionType Block;
        public static final FollowActionType Follow;
        public static final FollowActionType Mute;
        public static final FollowActionType Unblock;
        public static final FollowActionType Unfollow;
        public static final FollowActionType Unmute;

        public static FollowActionType valueOf(String s)
        {
            return (FollowActionType)Enum.valueOf(tv/periscope/android/api/ApiManager$FollowActionType, s);
        }

        public static FollowActionType[] values()
        {
            return (FollowActionType[])$VALUES.clone();
        }

        static 
        {
            Follow = new FollowActionType("Follow", 0);
            Unfollow = new FollowActionType("Unfollow", 1);
            Block = new FollowActionType("Block", 2);
            Unblock = new FollowActionType("Unblock", 3);
            Mute = new FollowActionType("Mute", 4);
            Unmute = new FollowActionType("Unmute", 5);
            $VALUES = (new FollowActionType[] {
                Follow, Unfollow, Block, Unblock, Mute, Unmute
            });
        }

        private FollowActionType(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface OnCompleteCallback
    {

        public abstract void onComplete(int i);

        public abstract void onReceive(zu zu1);

        public abstract void onRetry(zy zy);
    }


    private static final String TAG = "ApiManager";
    private static volatile ApiManager sInstance;
    private final ApiService mApiService;
    private final yv mBroadcastCacheManager;
    private final acg mConnection = new acg();
    private final Context mContext;
    private final EventHandler mDefaultEventHandler = new EventHandler();
    private final ql mEventBus;
    private final ql mLocalEventBus;
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());
    private final HashMap mPendingFollowActions = new HashMap();
    private final zf mProfileManager;
    private final abv mPushManager;
    private final ack mSessionManager;
    private final acm mSettingsStore;
    private final SignerService mSignerService;
    private final zp mUserManager;
    private final zt mWordManager;

    private ApiManager(Context context, ql ql1, ApiService apiservice, SignerService signerservice, zp zp1, yv yv1, abv abv1, 
            ack ack1, zf zf, zt zt, acm acm1)
    {
        mContext = context;
        mEventBus = ql1;
        mApiService = apiservice;
        mSignerService = signerservice;
        mUserManager = zp1;
        mSessionManager = ack1;
        mProfileManager = zf;
        mWordManager = zt;
        mBroadcastCacheManager = yv1;
        mPushManager = abv1;
        context = ql._mth043E();
        context.PM = false;
        mLocalEventBus = new ql(context);
        mLocalEventBus._mth02CA(mDefaultEventHandler, false, 0);
        mSettingsStore = acm1;
    }

    private boolean addFollowAction(String s, FollowActionType followactiontype)
    {
        return addFollowAction(s, followactiontype, null);
    }

    private boolean addFollowAction(String s, FollowActionType followactiontype, PsRequest psrequest)
    {
        ArrayList arraylist1 = (ArrayList)mPendingFollowActions.get(s);
        ArrayList arraylist = arraylist1;
        if (arraylist1 == null)
        {
            arraylist = new ArrayList();
            mPendingFollowActions.put(s, arraylist);
        }
        if (arraylist.isEmpty())
        {
            arraylist.add(new FollowAction(followactiontype, psrequest));
            (new StringBuilder("Queueing action on empty list:")).append(followactiontype).append(" for ").append(s);
            return true;
        }
        if (((FollowAction)arraylist.get(arraylist.size() - 1)).type != followactiontype)
        {
            (new StringBuilder("Queueing action on list:")).append(followactiontype).append(" for ").append(s).append(" of size ").append(arraylist.size());
            arraylist.add(new FollowAction(followactiontype, psrequest));
            return false;
        } else
        {
            (new StringBuilder("Not queueing action ")).append(followactiontype).append(" for ").append(s);
            return false;
        }
    }

    private String execute(int i, Bundle bundle)
    {
        return mConnection._mth02CA((new ApiRunnable.Builder()).setEventBus(mLocalEventBus).setService(mApiService).setSigner(mSignerService).setActionCode(i).setBundle(bundle).build());
    }

    private String execute(int i, Bundle bundle, int j, long l)
    {
        return mConnection._mth02CA((new ApiRunnable.Builder()).setEventBus(mLocalEventBus).setService(mApiService).setSigner(mSignerService).setActionCode(i).setBundle(bundle).setNumRetries(j).setBackoffInterval(l).build());
    }

    private String execute(int i, PsRequest psrequest)
    {
        return mConnection._mth02CA((new ApiRunnable.Builder()).setEventBus(mLocalEventBus).setService(mApiService).setSigner(mSignerService).setActionCode(i).setRequest(psrequest).build());
    }

    private String execute(ql ql1, int i, Bundle bundle, int j, long l)
    {
        return mConnection._mth02CA((new ApiRunnable.Builder()).setEventBus(ql1).setService(mApiService).setSigner(mSignerService).setActionCode(i).setBundle(bundle).setNumRetries(j).setBackoffInterval(l).build());
    }

    private String executeBlock(BlockRequest blockrequest)
    {
        return execute(35, blockrequest);
    }

    private String executeFollow(String s)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_user_id", s);
        return execute(8, bundle);
    }

    private String executeMute(String s)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_user_id", s);
        return execute(55, bundle);
    }

    private void executeNextFollowAction(String s, ArrayList arraylist)
    {
        (new StringBuilder("Executing next action in list for ")).append(s).append(": ").append(arraylist);
        if (arraylist == null || arraylist.isEmpty())
        {
            return;
        }
        arraylist = (FollowAction)arraylist.get(0);
        switch (_cls2..SwitchMap.tv.periscope.android.api.ApiManager.FollowActionType[((FollowAction) (arraylist)).type.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            executeFollow(s);
            return;

        case 2: // '\002'
            executeUnfollow(s);
            return;

        case 3: // '\003'
            executeMute(s);
            return;

        case 4: // '\004'
            executeUnmute(s);
            return;

        case 5: // '\005'
            executeBlock((BlockRequest)((FollowAction) (arraylist)).request);
            return;

        case 6: // '\006'
            executeUnblock(s);
            break;
        }
    }

    private String executeUnblock(String s)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_user_id", s);
        return execute(36, bundle);
    }

    private String executeUnfollow(String s)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_user_id", s);
        return execute(9, bundle);
    }

    private String executeUnmute(String s)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_user_id", s);
        return execute(56, bundle);
    }

    public static ApiManager get(Context context)
    {
        if (sInstance != null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        tv/periscope/android/api/ApiManager;
        JVM INSTR monitorenter ;
        if (sInstance == null)
        {
            sInstance = new ApiManager(context.getApplicationContext(), xd.getEventBus(), (ApiService)xd._mth3078().getService(), (SignerService)xd._mth30A5().getService(), xd._mth1FEA(), xd._mth216D(), xd._mth212A(), xd._mth1FEB(), xd._mth2183(), xd._mth304F(), new acm(context));
        }
        tv/periscope/android/api/ApiManager;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_88;
        context;
        throw context;
        return sInstance;
    }

    private String getBroadcastMainFeatured(ql ql1)
    {
        return execute(ql1, 18, newApiBundle(), 0, 0L);
    }

    private String getBroadcastMainFollowing(ql ql1)
    {
        return execute(ql1, 17, newApiBundle(), 0, 0L);
    }

    private String getBroadcastMainGlobal(ql ql1)
    {
        acl acl1 = mSettingsStore.aH();
        Bundle bundle = newApiBundle();
        bundle.putStringArrayList("e_languages", new ArrayList(acl1.bdk));
        return execute(ql1, 4, bundle, 0, 0L);
    }

    private HashMap getVersionData()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("platform", "Android");
        hashmap.put("platform_version", (new StringBuilder()).append(android.os.Build.VERSION.RELEASE).append(" ").append(android.os.Build.VERSION.SDK_INT).append(android.os.Build.VERSION.INCREMENTAL).toString());
        hashmap.put("app_version", (new StringBuilder()).append(aos._mth0131(mContext)).toString());
        hashmap.put("device", (new StringBuilder()).append(Build.HARDWARE).append(" ").append(Build.MODEL).append(" ").append(Build.PRODUCT).toString());
        return hashmap;
    }

    private void handleFollowActionComplete(zu zu1, String s)
    {
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
            zu1 = zu1.I();
            if (zu1 != null)
            {
                switch (((ErrorResponse) (zu1)).error.code)
                {
                case 2: // '\002'
                    Toast.makeText(mContext, 0x7f06017d, 0).show();
                    break;

                case 161: 
                    Toast.makeText(mContext, 0x7f06019b, 0).show();
                    break;
                }
            }
        }
        zu1 = (ArrayList)mPendingFollowActions.get(s);
        if (zu1 == null)
        {
            return;
        }
        if (zu1.size() > 0)
        {
            FollowAction followaction = (FollowAction)zu1.remove(0);
            (new StringBuilder("Removing completed follow action ")).append(followaction.type).append(" for user ").append(s);
        }
        if (zu1.isEmpty())
        {
            mPendingFollowActions.remove(s);
            return;
        } else
        {
            executeNextFollowAction(s, zu1);
            return;
        }
    }

    private Bundle newApiBundle()
    {
        Bundle bundle = new Bundle();
        Object obj = mSessionManager;
        if (((ack) (obj)).bde == null)
        {
            ((ack) (obj)).aG();
        }
        obj = ((ack) (obj)).bde;
        if (obj != null)
        {
            obj = ((acj) (obj)).bcY;
        } else
        {
            obj = null;
        }
        bundle.putString("e_cookie", ((String) (obj)));
        return bundle;
    }

    public void bind()
    {
        Intent intent = new Intent(mContext, o/acf);
        mContext.bindService(intent, mConnection, 1);
    }

    public String block(String s, String s1, String s2, auf auf1)
    {
        Object obj = mUserManager;
        Object obj1 = ((zp) (obj)).aQC.edit();
        Object obj2 = (PsUser)((zp) (obj)).aWM.get(s);
        if (obj2 != null)
        {
            obj2.isBlocked = true;
            obj2.isFollowing = false;
            obj2.isMuted = false;
        }
        obj2 = (zd)((zp) (obj)).aWI.get(zs.aXa);
        if (!((zd) (obj2))._mth14EA(s))
        {
            ((zd) (obj2))._mth1466(s);
        }
        ((zd)((zp) (obj)).aWI.get(zs.aWZ))._mth14BE(s);
        ((android.content.SharedPreferences.Editor) (obj1)).putStringSet((String)o.yp.CON._mth02CA("o.yp").getField("aVL").get(null), new HashSet(((zd) (obj2)).y()));
        ((android.content.SharedPreferences.Editor) (obj1)).putInt((String)o.yp.CON._mth02CA("o.yp").getField("aVI").get(null), ((zp) (obj)).aQC.getInt((String)o.yp.CON._mth02CA("o.yp").getField("aVI").get(null), 0) + 1);
        ((android.content.SharedPreferences.Editor) (obj1)).apply();
        ((zp) (obj)).mEventBus._mth1429(zw.aYN);
        ((zp) (obj)).mEventBus._mth1429(zw.aYB);
        obj1 = new BlockRequest();
        obj = mSessionManager;
        if (((ack) (obj)).bde == null)
        {
            ((ack) (obj)).aG();
        }
        obj = ((ack) (obj)).bde;
        if (obj != null)
        {
            obj = ((acj) (obj)).bcY;
        } else
        {
            obj = null;
        }
        obj1.cookie = ((String) (obj));
        obj1.userId = s;
        obj1.broadcastId = s1;
        obj1.channel = s2;
        if (auf1 != null)
        {
            s1 = (it)auh.bFf._mth02CA(auf1.gD(), o/it);
        } else
        {
            s1 = null;
        }
        obj1.reason = s1;
        if (auf1 != null)
        {
            s1 = auf1.gE();
        } else
        {
            s1 = null;
        }
        obj1.chatmanReason = s1;
        if (addFollowAction(s, FollowActionType.Block, ((PsRequest) (obj1))))
        {
            return executeBlock(((BlockRequest) (obj1)));
        } else
        {
            return aos.dH();
        }
    }

    public String broadcastMeta(String s, HashMap hashmap, HashMap hashmap1, HashMap hashmap2, ChatStats chatstats)
    {
        Object obj = getVersionData();
        hashmap.putAll(((Map) (obj)));
        hashmap1.putAll(((Map) (obj)));
        BroadcastMetaRequest broadcastmetarequest = new BroadcastMetaRequest();
        obj = mSessionManager;
        if (((ack) (obj)).bde == null)
        {
            ((ack) (obj)).aG();
        }
        obj = ((ack) (obj)).bde;
        if (obj != null)
        {
            obj = ((acj) (obj)).bcY;
        } else
        {
            obj = null;
        }
        broadcastmetarequest.cookie = ((String) (obj));
        broadcastmetarequest.broadcastId = s;
        broadcastmetarequest.stats = hashmap;
        broadcastmetarequest.pubnubStats = hashmap1;
        broadcastmetarequest.behaviorStats = hashmap2;
        broadcastmetarequest.chatStats = chatstats;
        return execute(54, broadcastmetarequest);
    }

    public String createBroadcast(String s)
    {
        Bundle bundle = newApiBundle();
        bundle.putInt("extra_width", 320);
        bundle.putInt("extra_height", 568);
        bundle.putString("e_region", s);
        return execute(23, bundle);
    }

    public String decreaseBroadcastRank(String s)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_broadcast_id", s);
        bundle.putBoolean("e_decrease_rank", true);
        return execute(58, bundle);
    }

    public String deleteBroadcast(String s)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_broadcast_id", s);
        return execute(43, bundle);
    }

    public String deleteReplay(String s)
    {
        Object obj = (atn)mBroadcastCacheManager.aWg.get(s);
        obj.bDX = false;
        yv yv1 = mBroadcastCacheManager;
        ArrayList arraylist = new ArrayList(1);
        arraylist.add(obj);
        yv1._mth02BC(arraylist);
        obj = newApiBundle();
        ((Bundle) (obj)).putString("e_broadcast_id", s);
        return execute(42, ((Bundle) (obj)));
    }

    public void doLogout(zv zv)
    {
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        TwitterCore.getInstance().logOut();
        Digits.getSessionManager().clearActiveSession();
        xf._mth30C8();
        Object obj = mUserManager;
        obj.aWS = null;
        ((zp) (obj)).D();
        for (Iterator iterator = ((zp) (obj)).aWI.values().iterator(); iterator.hasNext(); ((zd)iterator.next()).z()) { }
        ((zp) (obj)).aWK.clear();
        ((zp) (obj)).aWM.clear();
        obj = mBroadcastCacheManager;
        ((zc) (((yv) (obj)).aWd)).FF89.clear();
        ((zc) (((yv) (obj)).aWe)).FF89.clear();
        ((zc) (((yv) (obj)).aWf)).FF89.clear();
        ((yv) (obj)).aWj.clear();
        ((yv) (obj)).aWi.clear();
        ((yv) (obj)).aWg.clear();
        abv abv1 = mPushManager;
        obj = abv1.mSessionManager;
        if (((ack) (obj)).bde == null)
        {
            ((ack) (obj)).aG();
        }
        obj = ((ack) (obj)).bde;
        if (obj != null)
        {
            obj = ((acj) (obj)).bcY;
        } else
        {
            obj = null;
        }
        abv1._mth02BB("unregister", ((String) (obj)), null);
        obj = mSessionManager;
        obj.bde = null;
        obj = ((ack) (obj)).aQC.edit();
        ((android.content.SharedPreferences.Editor) (obj)).remove((String)o.yp.CON._mth02CA("o.yp").getField("aVT").get(null));
        ((android.content.SharedPreferences.Editor) (obj)).remove((String)o.yp.CON._mth02CA("o.yp").getField("aVU").get(null));
        ((android.content.SharedPreferences.Editor) (obj)).apply();
        sharedpreferences.edit().clear().apply();
        mEventBus._mth1429(zv);
    }

    public String endBroadcast(String s, String s1)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_broadcast_id", s);
        bundle.putString("e_logger_name", s1);
        return execute(31, bundle);
    }

    public String endReplayViewed(String s, String s1, float f, float f1, int i)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_broadcast_id", s);
        bundle.putString("e_session_id", s1);
        bundle.putFloat("e_duration", f);
        bundle.putFloat("e_completion", f1);
        bundle.putInt("e_num_hearts", i);
        return execute(25, bundle);
    }

    public String follow(String s)
    {
        zp zp1 = mUserManager;
        PsUser psuser = (PsUser)zp1.aWM.get(s);
        psuser.isFollowing = true;
        psuser.numFollowers = psuser.numFollowers + 1;
        zp1.aQC.edit().putInt((String)o.yp.CON._mth02CA("o.yp").getField("aVH").get(null), zp1.aQC.getInt((String)o.yp.CON._mth02CA("o.yp").getField("aVH").get(null), 0) + 1).apply();
        zp1.mEventBus._mth1429(zw.aYx);
        zp1.mEventBus._mth1429(zw.aYB);
        if (addFollowAction(s, FollowActionType.Follow))
        {
            return executeFollow(s);
        } else
        {
            return aos.dH();
        }
    }

    public String followAll(Collection collection)
    {
        Object obj = mUserManager;
        int i = ((zp) (obj)).aQC.getInt((String)o.yp.CON._mth02CA("o.yp").getField("aVH").get(null), 0);
        for (Iterator iterator = collection.iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            int j = i;
            if (((zp) (obj)).aWM.containsKey(s))
            {
                ((PsUser)((zp) (obj)).aWM.get(s)).isFollowing = true;
                j = i + 1;
            }
            i = j;
        }

        android.content.SharedPreferences.Editor editor = ((zp) (obj)).aQC.edit();
        editor.putInt((String)o.yp.CON._mth02CA("o.yp").getField("aVH").get(null), i);
        editor.apply();
        ((zp) (obj)).mEventBus._mth1429(zw.aYy);
        ((zp) (obj)).mEventBus._mth1429(zw.aYB);
        obj = newApiBundle();
        ((Bundle) (obj)).putStringArray("extra_ids", (String[])collection.toArray(new String[collection.size()]));
        return execute(21, ((Bundle) (obj)));
    }

    public String getAccessChannel(String s)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_broadcast_id", s);
        return execute(13, bundle);
    }

    public String getBlocked()
    {
        return execute(37, newApiBundle());
    }

    public void getBroadcastIdForShareToken(String s)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_token", s);
        execute(39, bundle);
    }

    public String getBroadcastMainGlobal()
    {
        acl acl1 = mSettingsStore.aH();
        Bundle bundle = newApiBundle();
        bundle.putStringArrayList("e_languages", new ArrayList(acl1.bdk));
        return execute(4, bundle, 0, 0L);
    }

    public String getBroadcastRank(String s)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_broadcast_id", s);
        return execute(51, bundle);
    }

    public String getBroadcastRankParameters()
    {
        return execute(49, newApiBundle());
    }

    public String getBroadcastShareUrl(String s)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_broadcast_id", s);
        return execute(33, bundle);
    }

    public void getBroadcastSummary(String s)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_broadcast_id", s);
        execute(34, bundle);
    }

    public String getBroadcastViewers(String s, String s1)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_user_id", s);
        bundle.putString("e_broadcast_id", s1);
        return execute(20, bundle);
    }

    public ql getEventBus()
    {
        return mEventBus;
    }

    public String getFollowers()
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_my_user_id", mUserManager.aQC.getString((String)o.yp.CON._mth02CA("o.yp").getField("aVC").get(null), null));
        return execute(6, bundle);
    }

    public String getFollowersById(String s)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_user_id", s);
        return execute(12, bundle);
    }

    public String getFollowing()
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_my_user_id", mUserManager.aQC.getString((String)o.yp.CON._mth02CA("o.yp").getField("aVC").get(null), null));
        return execute(7, bundle);
    }

    public String getFollowingById(String s)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_user_id", s);
        return execute(11, bundle);
    }

    public String getGlobalMap(float f, float f1, float f2, float f3)
    {
        Bundle bundle = newApiBundle();
        bundle.putFloat("e_point_1_lat", f);
        bundle.putFloat("e_point_1_lng", f1);
        bundle.putFloat("e_point_2_lat", f2);
        bundle.putFloat("e_point_2_lng", f3);
        return execute(52, bundle, 0, 0L);
    }

    public String getMutualFollows()
    {
        return execute(60, newApiBundle());
    }

    public void getMyUserBroadcasts()
    {
        UserBroadcastsRequest userbroadcastsrequest = new UserBroadcastsRequest();
        Object obj = mSessionManager;
        if (((ack) (obj)).bde == null)
        {
            ((ack) (obj)).aG();
        }
        obj = ((ack) (obj)).bde;
        if (obj != null)
        {
            obj = ((acj) (obj)).bcY;
        } else
        {
            obj = null;
        }
        userbroadcastsrequest.cookie = ((String) (obj));
        userbroadcastsrequest.userId = mUserManager.aQC.getString((String)o.yp.CON._mth02CA("o.yp").getField("aVC").get(null), null);
        userbroadcastsrequest.all = true;
        execute(44, userbroadcastsrequest);
    }

    public String getSettings()
    {
        return execute(30, newApiBundle());
    }

    public String getSuggestedPeople()
    {
        acl acl1 = mSettingsStore.aH();
        Bundle bundle = newApiBundle();
        bundle.putBoolean("e_sign_up", false);
        bundle.putStringArrayList("e_languages", new ArrayList(acl1.bdk));
        bundle.putString("e_secret_key", mUserManager.aQC.getString((String)o.yp.CON._mth02CA("o.yp").getField("aVQ").get(null), null));
        bundle.putString("e_secret_token", mUserManager.aQC.getString((String)o.yp.CON._mth02CA("o.yp").getField("aVR").get(null), null));
        return execute(14, bundle);
    }

    public String getSuggestedPeopleForOnboarding()
    {
        Bundle bundle = newApiBundle();
        bundle.putBoolean("e_sign_up", true);
        bundle.putString("e_secret_key", mUserManager.aQC.getString((String)o.yp.CON._mth02CA("o.yp").getField("aVQ").get(null), null));
        bundle.putString("e_secret_token", mUserManager.aQC.getString((String)o.yp.CON._mth02CA("o.yp").getField("aVR").get(null), null));
        return execute(14, bundle);
    }

    public String getUser()
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_my_user_id", mUserManager.aQC.getString((String)o.yp.CON._mth02CA("o.yp").getField("aVC").get(null), null));
        return execute(5, bundle);
    }

    public void getUserBroadcastsByUserId(String s)
    {
        UserBroadcastsRequest userbroadcastsrequest = new UserBroadcastsRequest();
        Object obj = mSessionManager;
        if (((ack) (obj)).bde == null)
        {
            ((ack) (obj)).aG();
        }
        obj = ((ack) (obj)).bde;
        if (obj != null)
        {
            obj = ((acj) (obj)).bcY;
        } else
        {
            obj = null;
        }
        userbroadcastsrequest.cookie = ((String) (obj));
        userbroadcastsrequest.userId = s;
        execute(44, userbroadcastsrequest);
    }

    public void getUserBroadcastsByUsername(String s)
    {
        UserBroadcastsRequest userbroadcastsrequest = new UserBroadcastsRequest();
        Object obj = mSessionManager;
        if (((ack) (obj)).bde == null)
        {
            ((ack) (obj)).aG();
        }
        obj = ((ack) (obj)).bde;
        if (obj != null)
        {
            obj = ((acj) (obj)).bcY;
        } else
        {
            obj = null;
        }
        userbroadcastsrequest.cookie = ((String) (obj));
        userbroadcastsrequest.username = s;
        execute(44, userbroadcastsrequest);
    }

    public String getUserById(String s)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_user_id", s);
        return execute(10, bundle);
    }

    public String getUserByUsername(String s)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_username", s);
        return execute(61, bundle);
    }

    public String hello()
    {
        ArrayList arraylist = new ArrayList(1);
        arraylist.add(Locale.getDefault().getLanguage());
        Bundle bundle = newApiBundle();
        bundle.putStringArrayList("e_locale", arraylist);
        return execute(59, bundle);
    }

    public String increaseBroadcastRank(String s)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_broadcast_id", s);
        bundle.putBoolean("e_increase_rank", true);
        return execute(58, bundle);
    }

    public String login(String s, String s1, String s2, String s3, String s4, String s5, o.acj.if if1)
    {
        Bundle bundle = new Bundle();
        bundle.putString("e_secret_key", s);
        bundle.putString("e_secret_token", s1);
        bundle.putString("e_username", s2);
        bundle.putString("e_user_id", s3);
        bundle.putString("e_phone_number", s4);
        bundle.putString("e_install_id", s5);
        bundle.putString("e_session_type", if1.name());
        return execute(1, bundle);
    }

    public String megaBroadcastCall()
    {
        BarrierEventHandler barriereventhandler = (new BarrierEventHandler(new _cls1())).expect(new o.zu.if[] {
            o.zu.if.aXI, o.zu.if.aXC, o.zu.if.aXD
        });
        Object obj = ql._mth043E();
        obj.PM = false;
        obj = new ql(((qn) (obj)));
        ((ql) (obj))._mth02CA(barriereventhandler, false, 0);
        getBroadcastMainFeatured(((ql) (obj)));
        getBroadcastMainFollowing(((ql) (obj)));
        return getBroadcastMainGlobal(((ql) (obj)));
    }

    public String mute(String s)
    {
        zp zp1 = mUserManager;
        ((PsUser)zp1.aWM.get(s)).isMuted = true;
        zp1.mEventBus._mth1429(zw.aYz);
        zp1.mEventBus._mth1429(zw.aYB);
        if (addFollowAction(s, FollowActionType.Mute))
        {
            return executeMute(s);
        } else
        {
            return aos.dH();
        }
    }

    public void performUploadTest()
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_file_dir", mContext.getFilesDir().getAbsolutePath());
        execute(40, bundle, 0, 0L);
    }

    public String pingBroadcast(String s, String s1)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_broadcast_id", s);
        bundle.putString("e_logger_name", s1);
        return execute(32, bundle);
    }

    public String pingWatching(String s, String s1, String s2)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_broadcast_id", s);
        bundle.putString("e_session_id", s1);
        bundle.putString("e_logger_name", s2);
        return execute(27, bundle);
    }

    public String playbackMeta(String s, HashMap hashmap, HashMap hashmap1, HashMap hashmap2, ChatStats chatstats)
    {
        Object obj = getVersionData();
        hashmap.putAll(((Map) (obj)));
        hashmap1.putAll(((Map) (obj)));
        PlaybackMetaRequest playbackmetarequest = new PlaybackMetaRequest();
        obj = mSessionManager;
        if (((ack) (obj)).bde == null)
        {
            ((ack) (obj)).aG();
        }
        obj = ((ack) (obj)).bde;
        if (obj != null)
        {
            obj = ((acj) (obj)).bcY;
        } else
        {
            obj = null;
        }
        playbackmetarequest.cookie = ((String) (obj));
        playbackmetarequest.broadcastId = s;
        playbackmetarequest.stats = hashmap;
        playbackmetarequest.pubnubStats = hashmap1;
        playbackmetarequest.behaviorStats = hashmap2;
        playbackmetarequest.chatStats = chatstats;
        return execute(53, playbackmetarequest);
    }

    public String publishBroadcast(String s, String s1, ArrayList arraylist, boolean flag, float f, float f1, boolean flag1)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_broadcast_id", s);
        bundle.putString("e_title", s1);
        bundle.putStringArrayList("e_locked_ids", arraylist);
        bundle.putBoolean("e_has_loc", flag);
        bundle.putFloat("e_lat", f);
        bundle.putFloat("e_long", f1);
        bundle.putBoolean("e_following_only_chat", flag1);
        return execute(26, bundle);
    }

    public String refreshLiveBroadcasts(ArrayList arraylist)
    {
        Bundle bundle = newApiBundle();
        bundle.putStringArrayList("extra_ids", arraylist);
        return execute(19, bundle, 0, 0L);
    }

    public String replayThumbnailPlaylist(String s)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_broadcast_id", s);
        return execute(62, bundle);
    }

    public String replayViewed(String s, String s1)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_session_id", s1);
        bundle.putString("e_broadcast_id", s);
        return execute(24, bundle);
    }

    public String reportBroadcast(String s)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_broadcast_id", s);
        return execute(41, bundle);
    }

    public String setBroadcastRankParameters(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_rank_stickiness", s);
        bundle.putString("e_rank_verified", s1);
        bundle.putString("e_rank_viewers", s2);
        bundle.putString("e_rank_report_ratio", s3);
        bundle.putString("e_rank_has_location", s4);
        bundle.putString("e_rank_shares", s5);
        bundle.putString("e_rank_cortex_score", s6);
        bundle.putString("e_rank_decay", s7);
        bundle.putString("e_rank_decay_half_life", s8);
        return execute(50, bundle);
    }

    public void setProfileImage(File file, File file1)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_file_dir", file.getAbsolutePath());
        bundle.putString("e_cache_dir", file1.getAbsolutePath());
        execute(45, bundle);
    }

    public String setSettings(boolean flag, boolean flag1)
    {
        Bundle bundle = newApiBundle();
        bundle.putBoolean("e_user_follow_enabled", flag);
        bundle.putBoolean("e_autosave_enabled", flag1);
        return execute(29, bundle);
    }

    public String shareBroadcast(String s, ArrayList arraylist)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_broadcast_id", s);
        bundle.putStringArrayList("e_user_ids", arraylist);
        return execute(38, bundle);
    }

    public String stopWatching(String s, String s1, String s2, int i, int j, float f)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_broadcast_id", s);
        bundle.putString("e_session_id", s1);
        bundle.putString("e_logger_name", s2);
        bundle.putInt("e_num_hearts", i);
        bundle.putInt("e_n_comments", j);
        bundle.putFloat("e_duration", f);
        return execute(28, bundle);
    }

    public String supportedLanguages()
    {
        return execute(57, newApiBundle());
    }

    public String unban()
    {
        return execute(63, newApiBundle());
    }

    public void unbind()
    {
        try
        {
            mContext.unbindService(mConnection);
            return;
        }
        catch (Throwable throwable)
        {
            return;
        }
    }

    public String unblock(String s)
    {
        zp zp1 = mUserManager;
        android.content.SharedPreferences.Editor editor = zp1.aQC.edit();
        Object obj = (PsUser)zp1.aWM.get(s);
        obj.isBlocked = false;
        obj.isFollowing = false;
        int i = Math.max(0, zp1.aQC.getInt((String)o.yp.CON._mth02CA("o.yp").getField("aVI").get(null), 0) - 1);
        editor.putInt((String)o.yp.CON._mth02CA("o.yp").getField("aVI").get(null), i).apply();
        obj = (zd)zp1.aWI.get(zs.aXa);
        ((zd) (obj))._mth14BE(s);
        editor.putStringSet((String)o.yp.CON._mth02CA("o.yp").getField("aVL").get(null), new HashSet(((zd) (obj)).y())).apply();
        zp1.mEventBus._mth1429(zw.aYO);
        zp1.mEventBus._mth1429(zw.aYB);
        if (addFollowAction(s, FollowActionType.Block))
        {
            return executeUnblock(s);
        } else
        {
            return aos.dH();
        }
    }

    public String unfollow(String s)
    {
        zp zp1 = mUserManager;
        PsUser psuser = (PsUser)zp1.aWM.get(s);
        psuser.isFollowing = false;
        psuser.isMuted = false;
        int j = zp1.aQC.getInt((String)o.yp.CON._mth02CA("o.yp").getField("aVH").get(null), 0) - 1;
        int i = j;
        if (j < 0)
        {
            i = 0;
        }
        ((zd)zp1.aWI.get(zs.aWZ))._mth14BE(s);
        psuser.numFollowers = Math.max(0, psuser.numFollowers - 1);
        zp1.aQC.edit().putInt((String)o.yp.CON._mth02CA("o.yp").getField("aVH").get(null), i).apply();
        zp1.mEventBus._mth1429(zw.aYy);
        zp1.mEventBus._mth1429(zw.aYB);
        if (addFollowAction(s, FollowActionType.Unfollow))
        {
            return executeUnfollow(s);
        } else
        {
            return aos.dH();
        }
    }

    public String unmute(String s)
    {
        zp zp1 = mUserManager;
        ((PsUser)zp1.aWM.get(s)).isMuted = false;
        zp1.mEventBus._mth1429(zw.aYA);
        zp1.mEventBus._mth1429(zw.aYB);
        if (addFollowAction(s, FollowActionType.Unmute))
        {
            return executeUnmute(s);
        } else
        {
            return aos.dH();
        }
    }

    public void updateProfileDescription(String s)
    {
        mUserManager.aQC.edit().putString((String)o.yp.CON._mth02CA("o.yp").getField("aVF").get(null), s).apply();
        Bundle bundle = newApiBundle();
        bundle.putString("e_description", s);
        execute(46, bundle);
    }

    public void updateProfileDisplayName(String s)
    {
        mUserManager.aQC.edit().putString((String)o.yp.CON._mth02CA("o.yp").getField("aVD").get(null), s).apply();
        Bundle bundle = newApiBundle();
        bundle.putString("e_display_name", s);
        execute(47, bundle);
    }

    public String userSearch(String s)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("extra_query", s);
        return execute(15, bundle, 0, 0L);
    }

    public String validateUsername(String s, String s1, String s2)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_username", s);
        bundle.putString("e_secret_key", s1);
        bundle.putString("e_secret_token", s2);
        return execute(2, bundle);
    }

    public String verifyUsername(String s, String s1, String s2, String s3)
    {
        Bundle bundle = newApiBundle();
        bundle.putString("e_username", s);
        bundle.putString("e_display_name", s1);
        bundle.putString("e_secret_key", s2);
        bundle.putString("e_secret_token", s3);
        return execute(3, bundle);
    }












    private class _cls1
        implements OnCompleteCallback
    {

        private List mFeaturedBroadcasts;
        private List mFollowingBroadcasts;
        private List mGlobalBroadcasts;
        final ApiManager this$0;

        public void onComplete(int i)
        {
            if (i == 0)
            {
                mBroadcastCacheManager.mEventBus._mth1429(zw.aYH);
                return;
            } else
            {
                mBroadcastCacheManager._mth02CA(mFeaturedBroadcasts, mFollowingBroadcasts, mGlobalBroadcasts);
                return;
            }
        }

        public void onReceive(zu zu1)
        {
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
                mDefaultEventHandler.onEventMainThread(zu1);
                return;
            }
            switch (_cls2..SwitchMap.tv.periscope.android.event.ApiEvent.Type[zu1.aXk.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                mGlobalBroadcasts = (List)zu1.data;
                return;

            case 2: // '\002'
                mFeaturedBroadcasts = (List)zu1.data;
                return;

            case 3: // '\003'
                mFollowingBroadcasts = (List)zu1.data;
                break;
            }
        }

        public void onRetry(zy zy)
        {
            mDefaultEventHandler.onEventMainThread(zy);
        }

        _cls1()
        {
            this$0 = ApiManager.this;
            super();
            mGlobalBroadcasts = Collections.emptyList();
            mFollowingBroadcasts = Collections.emptyList();
            mFeaturedBroadcasts = Collections.emptyList();
        }
    }

}
