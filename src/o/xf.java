// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Application;
import android.content.SharedPreferences;
import com.localytics.android.Localytics;
import com.localytics.android.LocalyticsActivityLifecycleCallbacks;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

// Referenced classes of package o:
//            xg, qb, qc, qi, 
//            xh, aui, atr, atn, 
//            qd, ato, qg, ack, 
//            acj, zp, qf, qh, 
//            xi, xd

public final class xf
{
    public static final class if extends Enum
    {

        public static final if aQR;
        public static final if aQS;
        public static final if aQT;
        public static final if aQU;
        public static final if aQV;
        public static final if aQW;
        public static final if aQX;
        public static final if aQY;
        public static final if aQZ;
        public static final if aRA;
        public static final if aRB;
        public static final if aRC;
        public static final if aRD;
        public static final if aRE;
        public static final if aRF;
        private static if aRG;
        private static if aRH;
        public static final if aRI;
        public static final if aRJ;
        public static final if aRK;
        public static final if aRL;
        public static final if aRM;
        private static if aRN;
        private static if aRO;
        private static if aRP;
        private static if aRQ;
        public static final if aRR;
        public static final if aRS;
        public static final if aRT;
        private static if aRU;
        public static final if aRV;
        public static final if aRW;
        public static final if aRX;
        public static final if aRY;
        public static final if aRZ;
        public static final if aRa;
        public static final if aRb;
        public static final if aRc;
        public static final if aRd;
        public static final if aRe;
        public static final if aRf;
        public static final if aRg;
        public static final if aRh;
        public static final if aRi;
        public static final if aRj;
        public static final if aRk;
        public static final if aRl;
        public static final if aRm;
        public static final if aRn;
        public static final if aRo;
        public static final if aRp;
        public static final if aRq;
        public static final if aRr;
        public static final if aRs;
        public static final if aRt;
        public static final if aRu;
        public static final if aRv;
        public static final if aRw;
        public static final if aRx;
        public static final if aRy;
        public static final if aRz;
        public static final if aSA;
        public static final if aSB;
        public static final if aSC;
        public static final if aSD;
        public static final if aSE;
        public static final if aSF;
        public static final if aSG;
        public static final if aSH;
        private static if aSI;
        public static final if aSJ;
        public static final if aSK;
        public static final if aSL;
        public static final if aSM;
        public static final if aSN;
        public static final if aSO;
        private static if aSP;
        public static final if aSQ;
        public static final if aSR;
        public static final if aSS;
        public static final if aST;
        public static final if aSU;
        public static final if aSV;
        public static final if aSW;
        private static final if aSX[];
        public static final if aSa;
        public static final if aSb;
        public static final if aSc;
        public static final if aSd;
        public static final if aSe;
        public static final if aSf;
        public static final if aSg;
        public static final if aSh;
        public static final if aSi;
        private static if aSj;
        public static final if aSk;
        public static final if aSl;
        public static final if aSm;
        public static final if aSn;
        public static final if aSo;
        public static final if aSp;
        public static final if aSq;
        public static final if aSr;
        public static final if aSs;
        public static final if aSt;
        public static final if aSu;
        public static final if aSv;
        public static final if aSw;
        public static final if aSx;
        public static final if aSy;
        public static final if aSz;
        public final String Sx;

        public static if valueOf(String s)
        {
            return (if)Enum.valueOf(o/xf$if, s);
        }

        public static if[] values()
        {
            return (if[])aSX.clone();
        }

        static 
        {
            aQR = new if("ProfileFollowers", 0, "followers_table_view_controller");
            aQS = new if("ProfileFollowing", 1, "following_table_view_controller");
            aQT = new if("ProfileBlocked", 2, "blocked_table_view_controller");
            aQU = new if("ProfileTermsOfService", 3, "profile_terms_of_service");
            aQV = new if("ProfilePrivacyPolicy", 4, "profile_privacy_policy");
            aQW = new if("ProfileAttribution", 5, "profile_attribution");
            aQX = new if("ProfileHelpCenter", 6, "help_center");
            aQY = new if("ProfileSendFeedback", 7, "user_sends_feedback");
            aQZ = new if("ProfileLogout", 8, "profile_logout");
            aRa = new if("ProfileChoosePhoto", 9, "Choose Profile Image - Profile");
            aRb = new if("ProfileTakePhoto", 10, "Take Profile Image - Profile");
            aRc = new if("ProfileCancelPhoto", 11, "Cancel Profile Image - Profile");
            aRd = new if("SendFeedbackCanceled", 12, "user_cancels_send_feedback");
            aRe = new if("SendFeedbackGenerated", 13, "user_saves_draft_feedback");
            aRf = new if("SettingsAutosaveOn", 14, "user_turns_on_autosave_broadcasts");
            aRg = new if("SettingsAutosaveOff", 15, "user_turns_off_autosave_broadcasts");
            aRh = new if("SettingsNewFollowerPushOn", 16, "user_turns_on_new_follower_push");
            aRi = new if("SettingsNewFollowerPushOff", 17, "user_turns_off_new_follower_push");
            aRj = new if("SettingsFollowedLivePushOn", 18, "user_turns_on_followed_live_push");
            aRk = new if("SettingsFollowedLivePushOff", 19, "user_turns_off_followed_live_push");
            aRl = new if("SettingsFollowedSharePushOn", 20, "user_turns_on_followed_share_push");
            aRm = new if("SettingsFollowedSharePushOff", 21, "user_turns_off_followed_share_push");
            aRn = new if("SettingsSuggestedFirstPushOn", 22, "user_turns_on_suggested_first_push");
            aRo = new if("SettingsSuggestedFirstPushOff", 23, "user_turns_off_suggested_first_push");
            aRp = new if("NewUserSkipWalkthrough", 24, "skip_walkthrough");
            aRq = new if("NewUserGetStartedWalkthrough", 25, "Get Stated (Walkthrough)");
            aRr = new if("NewUserViewTos", 26, "viewed_terms_of_service");
            aRs = new if("NewUserViewPP", 27, "viewed_privacy_policy");
            aRt = new if("NewUserLoginWithTwitter", 28, "Login with Twitter Pressed");
            aRu = new if("NewUserFailedTwitterLogin", 29, "Failed Create Account (Pressed Login Twitter)");
            aRv = new if("NewUserFailedLogin", 30, "Failed Create Account (Didn't Press Login)");
            aRw = new if("NewUserChoosePhoto", 31, "Choose Profile Image - Account Sign Up");
            aRx = new if("NewUserTakePhoto", 32, "Take Profile Image - Account Sign Up");
            aRy = new if("NewUserCancelPhoto", 33, "Cancel Profile Image - Account Sign Up");
            aRz = new if("LoginWithDigits", 34, "Login with Digits Pressed");
            aRA = new if("FailedDigitsLogin", 35, "Failed Create Account (Pressed Login Digits)");
            aRB = new if("LiveAvatarTapped", 36, "live_cell_selects_profile_image");
            aRC = new if("LiveAuthorNameTapped", 37, "live_cell_selects_display_name");
            aRD = new if("EmptyHomeLivePromptTapped", 38, "Tapped View Global List");
            aRE = new if("MapBroadcastLaunched", 39, "Launch Broadcast - Map");
            aRF = new if("MapPinClicked", 40, "Clicked Pin - Map");
            aRG = new if("GlobalSegmentChangedToMap", 41, "Map/List Segment: Map");
            aRH = new if("GlobalSegmentChangedToList", 42, "Map/List Segment: List");
            aRI = new if("ViewerCommentOnBroadcast", 43, "commented_on_broadcast");
            aRJ = new if("ViewerSharePressed", 44, "share_icon_pressed");
            aRK = new if("ViewerShareFollowers", 45, "share_followers_chosen");
            aRL = new if("ViewerShareAllFollowers", 46, "share_all_followers_chosen");
            aRM = new if("ViewerParticipantButtonPressed", 47, "participants_button_pressed");
            aRN = new if("ViewerPromptedToFollow", 48, "prompted_to_follow_broadcaster_in_chat");
            aRO = new if("ViewerPromptedToShare", 49, "prompted_to_share_broadcast_in_chat");
            aRP = new if("ViewerFollowedBroadcasterFromChat", 50, "followed_broadcaster_from_chat");
            aRQ = new if("ViewerUnFollowedBroadcasterFromChat", 51, "unfollowed_broadcaster_from_chat");
            aRR = new if("ViewerBlockUserFromChat", 52, "Block User - Chat");
            aRS = new if("ViewerLiveHeartsSent", 53, "Live Hearts Sent");
            aRT = new if("ViewerReplayHeartsSent", 54, "Replay Hearts Sent");
            aRU = new if("ViewerTappedBroadcasterBlockedChat", 55, "tapped_broadcaster_blocked_chat");
            aRV = new if("ViewerChatWarningShown", 56, "Showed Warning Chat Modal");
            aRW = new if("ViewerChatWarningSent", 57, "Sent Warning Chat");
            aRX = new if("ViewerChatWarningNotSent", 58, "Did Not Send Warning Chat");
            aRY = new if("ReplayDeletePressed", 59, "replay_delete");
            aRZ = new if("ReplaySavedToGallery", 60, "replay_save_to_camera_roll");
            aSa = new if("ReplayWatchedEntirety", 61, "watched_entire_replay");
            aSb = new if("DidScrub", 62, "Did Scrub");
            aSc = new if("ReplayScrubbing", 63, "Replay Scrubbing");
            aSd = new if("ReportBroadcastStarted", 64, "report_broadcast_started");
            aSe = new if("ReportBroadcastCompleted", 65, "report_broadcast_completed");
            aSf = new if("ReportBroadcastCanceled", 66, "report_broadcast_cancelled");
            aSg = new if("ReportBroadcastError", 67, "report_broadcast_error");
            aSh = new if("HideChatOn", 68, "hide_chat_on");
            aSi = new if("HideChatOff", 69, "hide_chat_off");
            aSj = new if("ShareBroadcastPressed", 70, "Share Broadcast (from Share/Cinema)");
            aSk = new if("PreBroadcastLocationOn", 71, "pre_broadcast_enable_location");
            aSl = new if("PreBroadcastLocationOff", 72, "pre_broadcast_disable_location");
            aSm = new if("PublishBroadcast", 73, "published_broadcast");
            aSn = new if("BroadcastStartedTwitterOn", 74, "Broadcaster Started with Twitter Sharing Enabled");
            aSo = new if("BroadcastStartedTwitterOff", 75, "Broadcaster Started with Twitter Sharing Disabled");
            aSp = new if("BroadcasterTweetSucceeded", 76, "broadcaster_tweet_succeeded");
            aSq = new if("BroadcasterTweetFailed", 77, "broadcaster_tweet_failed");
            aSr = new if("StopBroadcastPressed", 78, "ended_broadcast");
            aSs = new if("FlipCameraViaDoubleTap", 79, "double_tapped_to_flip");
            aSt = new if("FlipCameraViaControl", 80, "used_control_to_flip");
            aSu = new if("MainWatchListAccessed", 81, "main_watch_list");
            aSv = new if("GlobalWatchListAccessed", 82, "global_watch_list");
            aSw = new if("GlobalMapAccessed", 83, "Global Map");
            aSx = new if("BroadcastFloatActionBtnPressed", 84, "broadcast");
            aSy = new if("MainUserListAccessed", 85, "main_user_list");
            aSz = new if("SearchUsersFloatActionBtnPressed", 86, "user_serach_table_view_controller");
            aSA = new if("ProfilePeekabooPressed", 87, "user_profile");
            aSB = new if("ProfileSheetLoggedInUser", 88, "logged_in_user_profile_modal_is_launched");
            aSC = new if("ProfileSheetOtherUser", 89, "user_profile_modal_is_launched");
            aSD = new if("PrivateBroadcastSheet", 90, "lock_list_is_launched");
            aSE = new if("ShareBroadcastSheet", 91, "share_w_specific_followers_launched");
            aSF = new if("ProfileSheetBlockUnblockPresented", 92, "Block User action sheet presented");
            aSG = new if("ProfileSheetBlockPressed", 93, "Block User action sheet: block");
            aSH = new if("ProfileSheetUnblockPressed", 94, "Block User action sheet: unblock");
            aSI = new if("ProfileSheetBlockCanceled", 95, "Block User action sheet: cancel");
            aSJ = new if("ProfileSheetRecents", 96, "User Modal Recents");
            aSK = new if("ProfileSheetFollowing", 97, "User Modal Following");
            aSL = new if("ProfileSheetFollowers", 98, "User Modal Followers");
            aSM = new if("ProfileSheetWatchLivePresented", 99, "Watch LIVE presented");
            aSN = new if("ProfileSheetWatchLiveSelected", 100, "Watch LIVE selected");
            aSO = new if("ProfileSheetUserChannel", 101, "Launched User Channel from User Modal");
            aSP = new if("AppNoGooglePlayServices", 102, "App No Google Play Services");
            aSQ = new if("ShareOnTwitterLivePressed", 103, "Share on Twitter - button pressed (live)");
            aSR = new if("ShareOnTwitterLiveCanceled", 104, "Share on Twitter - cancelled (live)");
            aSS = new if("ShareOnTwitterLiveCompleted", 105, "Share on Twitter - completed (live)");
            aST = new if("ShareOnTwitterReplayPressed", 106, "Share on Twitter - button pressed (replay)");
            aSU = new if("ShareOnTwitterReplayCanceled", 107, "Share on Twitter - cancelled (replay)");
            aSV = new if("ShareOnTwitterReplayCompleted", 108, "Share on Twitter - completed (replay)");
            aSW = new if("AppLaunch", 109, "App Launch");
            aSX = (new if[] {
                aQR, aQS, aQT, aQU, aQV, aQW, aQX, aQY, aQZ, aRa, 
                aRb, aRc, aRd, aRe, aRf, aRg, aRh, aRi, aRj, aRk, 
                aRl, aRm, aRn, aRo, aRp, aRq, aRr, aRs, aRt, aRu, 
                aRv, aRw, aRx, aRy, aRz, aRA, aRB, aRC, aRD, aRE, 
                aRF, aRG, aRH, aRI, aRJ, aRK, aRL, aRM, aRN, aRO, 
                aRP, aRQ, aRR, aRS, aRT, aRU, aRV, aRW, aRX, aRY, 
                aRZ, aSa, aSb, aSc, aSd, aSe, aSf, aSg, aSh, aSi, 
                aSj, aSk, aSl, aSm, aSn, aSo, aSp, aSq, aSr, aSs, 
                aSt, aSu, aSv, aSw, aSx, aSy, aSz, aSA, aSB, aSC, 
                aSD, aSE, aSF, aSG, aSH, aSI, aSJ, aSK, aSL, aSM, 
                aSN, aSO, aSP, aSQ, aSR, aSS, aST, aSU, aSV, aSW
            });
        }

        private if(String s, int i, String s1)
        {
            super(s, i);
            Sx = s1;
        }
    }


    private static boolean aQO = true;

    public xf()
    {
    }

    public static void _mth02CA(xd xd, ack ack1, zp zp1)
    {
        xd.registerActivityLifecycleCallbacks(new LocalyticsActivityLifecycleCallbacks(xd));
        Localytics.addAnalyticsListener(new xg(zp1, ack1));
        ack1 = qb._mth01AC();
        ack1.Pk = new qc();
        xd.registerActivityLifecycleCallbacks(new qi(ack1));
    }

    public static void _mth02CA(if if1)
    {
        if (aQO)
        {
            Localytics.tagEvent(if1.Sx);
        }
    }

    public static void _mth02CA(if if1, HashMap hashmap)
    {
        if (aQO)
        {
            Localytics.tagEvent(if1.Sx, hashmap);
            (new StringBuilder()).append(if1.Sx).append(" ").append(hashmap);
        }
    }

    public static void _mth02CA(xh xh1)
    {
        xh1._mth05D5("Chat.Hearts");
    }

    public static void _mth02CA(xh xh1, String s)
    {
        xh1._mth05D5("Chat.Comments");
        if (aui._mth02BF(s) && s.charAt(0) == '@')
        {
            xh1._mth05D5("Chat.ChatCommentReplied");
        }
    }

    public static void _mth02CA(xh xh1, atr atr1)
    {
        String s = atr1.fo().fd();
        ((qd) (xh1)).Pq.put("Summary.BroadcasterUserId", s);
        s = atr1.fo().id();
        ((qd) (xh1)).Pq.put("Summary.BroadcastID", s);
        boolean flag;
        if (atr1.fo().bDW == ato.bEd)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            ((qd) (xh1)).Pq.put("Summary.State", "Live");
            int i = atr1.fo().bEa;
            ((qd) (xh1)).Pq.put("Summary.LiveViewersAtJoin", Integer.toString(i));
        } else
        {
            ((qd) (xh1)).Pq.put("Summary.State", "Replay");
        }
        if (atr1.fo().fe())
        {
            atr1 = "Private";
        } else
        {
            atr1 = "Public";
        }
        ((qd) (xh1)).Pq.put("Summary.Type", atr1);
    }

    public static void _mth02CA(xh xh1, atr atr1, int i)
    {
        boolean flag;
        if (atr1.fo().bDW == ato.bEd)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            ((qd) (xh1)).Pq.put("Summary.LiveViewersAtExit", Integer.toString(i));
            return;
        } else
        {
            atr1 = atr1.fo();
            long l = TimeUnit.SECONDS.convert(((atn) (atr1)).bDV - atr1.fa(), TimeUnit.MILLISECONDS);
            ((qd) (xh1)).Pq.put("Summary.ReplayDuration", Long.toString(l));
            l = ((qg)((qd) (xh1)).Pr.get("Summary.TimeWatched"))._mth0422();
            ((qd) (xh1)).Pq.put("Summary.ReplayTimeWatched", Long.toString(l));
            return;
        }
    }

    public static void _mth02CA(zp zp1, ack ack1)
    {
        if (ack1.bde == null)
        {
            ack1.aG();
        }
        ack1 = ack1.bde;
        if (ack1 != null)
        {
            if (((acj) (ack1)).bcZ == acj.if.bdb)
            {
                Localytics.setCustomDimension(0, "Twitter");
                Localytics.setCustomDimension(1, "Logged In");
                Localytics.setCustomDimension(2, String.valueOf(zp1.aQC.getInt((String)yp.CON._mth02CA("o.yp").getField("aVG").get(null), 0)));
                Localytics.setCustomDimension(3, String.valueOf(zp1.aQC.getInt((String)yp.CON._mth02CA("o.yp").getField("aVH").get(null), 0)));
            } else
            if (((acj) (ack1)).bcZ == acj.if.bdc)
            {
                Localytics.setCustomDimension(0, "Digits");
                Localytics.setCustomDimension(1, "Logged In");
                Localytics.setCustomDimension(2, String.valueOf(zp1.aQC.getInt((String)yp.CON._mth02CA("o.yp").getField("aVG").get(null), 0)));
                Localytics.setCustomDimension(3, String.valueOf(zp1.aQC.getInt((String)yp.CON._mth02CA("o.yp").getField("aVH").get(null), 0)));
            }
            Localytics.setCustomerId(zp1.aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVC").get(null), null));
        }
    }

    public static void _mth02CB(String s, boolean flag)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("Source", s);
        hashmap.put("Play Available", String.valueOf(flag));
        s = qb._mth01AC();
        String s1 = if.aSW.name();
        ((qb) (s)).Pk.tagEvent(s1, hashmap);
    }

    public static void _mth02CB(qh qh1)
    {
        if (qh1 instanceof xh)
        {
            ((xh)qh1)._mth05D5("Chat.ChatCommentViewProfile");
        }
    }

    public static void _mth02CB(xh xh1)
    {
        xh1._mth05D5("Chat.Screenshots");
    }

    public static void _mth02CE(qh qh1)
    {
        if (qh1 instanceof xh)
        {
            ((xh)qh1)._mth05D5("Chat.ChatCommentTapped");
        }
    }

    public static void _mth02CE(xh xh1)
    {
        xh1._mth05D5("Summary.ReplayPauses");
    }

    public static void _mth02CF(qh qh1)
    {
        if (qh1 instanceof xh)
        {
            ((xh)qh1)._mth05D5("Chat.ChatCommentBlockUser");
        }
    }

    public static void _mth141D(qh qh1)
    {
        if (qh1 instanceof xh)
        {
            ((xh)qh1)._mth05D5("Chat.ChatCommentCancel");
        }
    }

    public static void _mth1D54(String s, String s1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("Source", s);
        if (s1 == null)
        {
            s1 = "None";
        }
        hashmap.put("Deep Link", s1);
        s = qb._mth01AC();
        s1 = if.aSW.name();
        ((qb) (s)).Pk.tagEvent(s1, hashmap);
    }

    public static void _mth30C8()
    {
        Localytics.setCustomDimension(0, "NA");
        Localytics.setCustomDimension(1, "Logged Out");
        Localytics.setCustomDimension(2, String.valueOf("NA"));
        Localytics.setCustomDimension(3, String.valueOf("NA"));
    }

    public static qh _mth30EA()
    {
        qh qh2 = (qh)qb._mth01AC().Pj.get("BROADCAST_VIEWED");
        qh qh1 = qh2;
        if (qh2 == null)
        {
            qh1 = qb._mth01AC()._mth02CA(new xh("BROADCAST_VIEWED"), false);
        }
        return qh1;
    }

    public static qh _mth30EE()
    {
        qh qh2 = (qh)qb._mth01AC().Pj.get("CREATE_BROADCAST");
        qh qh1 = qh2;
        if (qh2 == null)
        {
            qh1 = qb._mth01AC()._mth02CA(new xi("CREATE_BROADCAST"), false);
        }
        return qh1;
    }

}
