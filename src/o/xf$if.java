// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            xf

public static final class Sx extends Enum
{

    public static final aSW aQR;
    public static final aSW aQS;
    public static final aSW aQT;
    public static final aSW aQU;
    public static final aSW aQV;
    public static final aSW aQW;
    public static final aSW aQX;
    public static final aSW aQY;
    public static final aSW aQZ;
    public static final aSW aRA;
    public static final aSW aRB;
    public static final aSW aRC;
    public static final aSW aRD;
    public static final aSW aRE;
    public static final aSW aRF;
    private static aSW aRG;
    private static aSW aRH;
    public static final aSW aRI;
    public static final aSW aRJ;
    public static final aSW aRK;
    public static final aSW aRL;
    public static final aSW aRM;
    private static aSW aRN;
    private static aSW aRO;
    private static aSW aRP;
    private static aSW aRQ;
    public static final aSW aRR;
    public static final aSW aRS;
    public static final aSW aRT;
    private static aSW aRU;
    public static final aSW aRV;
    public static final aSW aRW;
    public static final aSW aRX;
    public static final aSW aRY;
    public static final aSW aRZ;
    public static final aSW aRa;
    public static final aSW aRb;
    public static final aSW aRc;
    public static final aSW aRd;
    public static final aSW aRe;
    public static final aSW aRf;
    public static final aSW aRg;
    public static final aSW aRh;
    public static final aSW aRi;
    public static final aSW aRj;
    public static final aSW aRk;
    public static final aSW aRl;
    public static final aSW aRm;
    public static final aSW aRn;
    public static final aSW aRo;
    public static final aSW aRp;
    public static final aSW aRq;
    public static final aSW aRr;
    public static final aSW aRs;
    public static final aSW aRt;
    public static final aSW aRu;
    public static final aSW aRv;
    public static final aSW aRw;
    public static final aSW aRx;
    public static final aSW aRy;
    public static final aSW aRz;
    public static final aSW aSA;
    public static final aSW aSB;
    public static final aSW aSC;
    public static final aSW aSD;
    public static final aSW aSE;
    public static final aSW aSF;
    public static final aSW aSG;
    public static final aSW aSH;
    private static aSW aSI;
    public static final aSW aSJ;
    public static final aSW aSK;
    public static final aSW aSL;
    public static final aSW aSM;
    public static final aSW aSN;
    public static final aSW aSO;
    private static aSW aSP;
    public static final aSW aSQ;
    public static final aSW aSR;
    public static final aSW aSS;
    public static final aSW aST;
    public static final aSW aSU;
    public static final aSW aSV;
    public static final aSW aSW;
    private static final aSW aSX[];
    public static final aSW aSa;
    public static final aSW aSb;
    public static final aSW aSc;
    public static final aSW aSd;
    public static final aSW aSe;
    public static final aSW aSf;
    public static final aSW aSg;
    public static final aSW aSh;
    public static final aSW aSi;
    private static aSW aSj;
    public static final aSW aSk;
    public static final aSW aSl;
    public static final aSW aSm;
    public static final aSW aSn;
    public static final aSW aSo;
    public static final aSW aSp;
    public static final aSW aSq;
    public static final aSW aSr;
    public static final aSW aSs;
    public static final aSW aSt;
    public static final aSW aSu;
    public static final aSW aSv;
    public static final aSW aSw;
    public static final aSW aSx;
    public static final aSW aSy;
    public static final aSW aSz;
    public final String Sx;

    public static g.String valueOf(String s)
    {
        return (g.String)Enum.valueOf(o/xf$if, s);
    }

    public static g.String[] values()
    {
        return ([])aSX.clone();
    }

    static 
    {
        aQR = new <init>("ProfileFollowers", 0, "followers_table_view_controller");
        aQS = new <init>("ProfileFollowing", 1, "following_table_view_controller");
        aQT = new <init>("ProfileBlocked", 2, "blocked_table_view_controller");
        aQU = new <init>("ProfileTermsOfService", 3, "profile_terms_of_service");
        aQV = new <init>("ProfilePrivacyPolicy", 4, "profile_privacy_policy");
        aQW = new <init>("ProfileAttribution", 5, "profile_attribution");
        aQX = new <init>("ProfileHelpCenter", 6, "help_center");
        aQY = new <init>("ProfileSendFeedback", 7, "user_sends_feedback");
        aQZ = new <init>("ProfileLogout", 8, "profile_logout");
        aRa = new <init>("ProfileChoosePhoto", 9, "Choose Profile Image - Profile");
        aRb = new <init>("ProfileTakePhoto", 10, "Take Profile Image - Profile");
        aRc = new <init>("ProfileCancelPhoto", 11, "Cancel Profile Image - Profile");
        aRd = new <init>("SendFeedbackCanceled", 12, "user_cancels_send_feedback");
        aRe = new <init>("SendFeedbackGenerated", 13, "user_saves_draft_feedback");
        aRf = new <init>("SettingsAutosaveOn", 14, "user_turns_on_autosave_broadcasts");
        aRg = new <init>("SettingsAutosaveOff", 15, "user_turns_off_autosave_broadcasts");
        aRh = new <init>("SettingsNewFollowerPushOn", 16, "user_turns_on_new_follower_push");
        aRi = new <init>("SettingsNewFollowerPushOff", 17, "user_turns_off_new_follower_push");
        aRj = new <init>("SettingsFollowedLivePushOn", 18, "user_turns_on_followed_live_push");
        aRk = new <init>("SettingsFollowedLivePushOff", 19, "user_turns_off_followed_live_push");
        aRl = new <init>("SettingsFollowedSharePushOn", 20, "user_turns_on_followed_share_push");
        aRm = new <init>("SettingsFollowedSharePushOff", 21, "user_turns_off_followed_share_push");
        aRn = new <init>("SettingsSuggestedFirstPushOn", 22, "user_turns_on_suggested_first_push");
        aRo = new <init>("SettingsSuggestedFirstPushOff", 23, "user_turns_off_suggested_first_push");
        aRp = new <init>("NewUserSkipWalkthrough", 24, "skip_walkthrough");
        aRq = new <init>("NewUserGetStartedWalkthrough", 25, "Get Stated (Walkthrough)");
        aRr = new <init>("NewUserViewTos", 26, "viewed_terms_of_service");
        aRs = new <init>("NewUserViewPP", 27, "viewed_privacy_policy");
        aRt = new <init>("NewUserLoginWithTwitter", 28, "Login with Twitter Pressed");
        aRu = new <init>("NewUserFailedTwitterLogin", 29, "Failed Create Account (Pressed Login Twitter)");
        aRv = new <init>("NewUserFailedLogin", 30, "Failed Create Account (Didn't Press Login)");
        aRw = new <init>("NewUserChoosePhoto", 31, "Choose Profile Image - Account Sign Up");
        aRx = new <init>("NewUserTakePhoto", 32, "Take Profile Image - Account Sign Up");
        aRy = new <init>("NewUserCancelPhoto", 33, "Cancel Profile Image - Account Sign Up");
        aRz = new <init>("LoginWithDigits", 34, "Login with Digits Pressed");
        aRA = new <init>("FailedDigitsLogin", 35, "Failed Create Account (Pressed Login Digits)");
        aRB = new <init>("LiveAvatarTapped", 36, "live_cell_selects_profile_image");
        aRC = new <init>("LiveAuthorNameTapped", 37, "live_cell_selects_display_name");
        aRD = new <init>("EmptyHomeLivePromptTapped", 38, "Tapped View Global List");
        aRE = new <init>("MapBroadcastLaunched", 39, "Launch Broadcast - Map");
        aRF = new <init>("MapPinClicked", 40, "Clicked Pin - Map");
        aRG = new <init>("GlobalSegmentChangedToMap", 41, "Map/List Segment: Map");
        aRH = new <init>("GlobalSegmentChangedToList", 42, "Map/List Segment: List");
        aRI = new <init>("ViewerCommentOnBroadcast", 43, "commented_on_broadcast");
        aRJ = new <init>("ViewerSharePressed", 44, "share_icon_pressed");
        aRK = new <init>("ViewerShareFollowers", 45, "share_followers_chosen");
        aRL = new <init>("ViewerShareAllFollowers", 46, "share_all_followers_chosen");
        aRM = new <init>("ViewerParticipantButtonPressed", 47, "participants_button_pressed");
        aRN = new <init>("ViewerPromptedToFollow", 48, "prompted_to_follow_broadcaster_in_chat");
        aRO = new <init>("ViewerPromptedToShare", 49, "prompted_to_share_broadcast_in_chat");
        aRP = new <init>("ViewerFollowedBroadcasterFromChat", 50, "followed_broadcaster_from_chat");
        aRQ = new <init>("ViewerUnFollowedBroadcasterFromChat", 51, "unfollowed_broadcaster_from_chat");
        aRR = new <init>("ViewerBlockUserFromChat", 52, "Block User - Chat");
        aRS = new <init>("ViewerLiveHeartsSent", 53, "Live Hearts Sent");
        aRT = new <init>("ViewerReplayHeartsSent", 54, "Replay Hearts Sent");
        aRU = new <init>("ViewerTappedBroadcasterBlockedChat", 55, "tapped_broadcaster_blocked_chat");
        aRV = new <init>("ViewerChatWarningShown", 56, "Showed Warning Chat Modal");
        aRW = new <init>("ViewerChatWarningSent", 57, "Sent Warning Chat");
        aRX = new <init>("ViewerChatWarningNotSent", 58, "Did Not Send Warning Chat");
        aRY = new <init>("ReplayDeletePressed", 59, "replay_delete");
        aRZ = new <init>("ReplaySavedToGallery", 60, "replay_save_to_camera_roll");
        aSa = new <init>("ReplayWatchedEntirety", 61, "watched_entire_replay");
        aSb = new <init>("DidScrub", 62, "Did Scrub");
        aSc = new <init>("ReplayScrubbing", 63, "Replay Scrubbing");
        aSd = new <init>("ReportBroadcastStarted", 64, "report_broadcast_started");
        aSe = new <init>("ReportBroadcastCompleted", 65, "report_broadcast_completed");
        aSf = new <init>("ReportBroadcastCanceled", 66, "report_broadcast_cancelled");
        aSg = new <init>("ReportBroadcastError", 67, "report_broadcast_error");
        aSh = new <init>("HideChatOn", 68, "hide_chat_on");
        aSi = new <init>("HideChatOff", 69, "hide_chat_off");
        aSj = new <init>("ShareBroadcastPressed", 70, "Share Broadcast (from Share/Cinema)");
        aSk = new <init>("PreBroadcastLocationOn", 71, "pre_broadcast_enable_location");
        aSl = new <init>("PreBroadcastLocationOff", 72, "pre_broadcast_disable_location");
        aSm = new <init>("PublishBroadcast", 73, "published_broadcast");
        aSn = new <init>("BroadcastStartedTwitterOn", 74, "Broadcaster Started with Twitter Sharing Enabled");
        aSo = new <init>("BroadcastStartedTwitterOff", 75, "Broadcaster Started with Twitter Sharing Disabled");
        aSp = new <init>("BroadcasterTweetSucceeded", 76, "broadcaster_tweet_succeeded");
        aSq = new <init>("BroadcasterTweetFailed", 77, "broadcaster_tweet_failed");
        aSr = new <init>("StopBroadcastPressed", 78, "ended_broadcast");
        aSs = new <init>("FlipCameraViaDoubleTap", 79, "double_tapped_to_flip");
        aSt = new <init>("FlipCameraViaControl", 80, "used_control_to_flip");
        aSu = new <init>("MainWatchListAccessed", 81, "main_watch_list");
        aSv = new <init>("GlobalWatchListAccessed", 82, "global_watch_list");
        aSw = new <init>("GlobalMapAccessed", 83, "Global Map");
        aSx = new <init>("BroadcastFloatActionBtnPressed", 84, "broadcast");
        aSy = new <init>("MainUserListAccessed", 85, "main_user_list");
        aSz = new <init>("SearchUsersFloatActionBtnPressed", 86, "user_serach_table_view_controller");
        aSA = new <init>("ProfilePeekabooPressed", 87, "user_profile");
        aSB = new <init>("ProfileSheetLoggedInUser", 88, "logged_in_user_profile_modal_is_launched");
        aSC = new <init>("ProfileSheetOtherUser", 89, "user_profile_modal_is_launched");
        aSD = new <init>("PrivateBroadcastSheet", 90, "lock_list_is_launched");
        aSE = new <init>("ShareBroadcastSheet", 91, "share_w_specific_followers_launched");
        aSF = new <init>("ProfileSheetBlockUnblockPresented", 92, "Block User action sheet presented");
        aSG = new <init>("ProfileSheetBlockPressed", 93, "Block User action sheet: block");
        aSH = new <init>("ProfileSheetUnblockPressed", 94, "Block User action sheet: unblock");
        aSI = new <init>("ProfileSheetBlockCanceled", 95, "Block User action sheet: cancel");
        aSJ = new <init>("ProfileSheetRecents", 96, "User Modal Recents");
        aSK = new <init>("ProfileSheetFollowing", 97, "User Modal Following");
        aSL = new <init>("ProfileSheetFollowers", 98, "User Modal Followers");
        aSM = new <init>("ProfileSheetWatchLivePresented", 99, "Watch LIVE presented");
        aSN = new <init>("ProfileSheetWatchLiveSelected", 100, "Watch LIVE selected");
        aSO = new <init>("ProfileSheetUserChannel", 101, "Launched User Channel from User Modal");
        aSP = new <init>("AppNoGooglePlayServices", 102, "App No Google Play Services");
        aSQ = new <init>("ShareOnTwitterLivePressed", 103, "Share on Twitter - button pressed (live)");
        aSR = new <init>("ShareOnTwitterLiveCanceled", 104, "Share on Twitter - cancelled (live)");
        aSS = new <init>("ShareOnTwitterLiveCompleted", 105, "Share on Twitter - completed (live)");
        aST = new <init>("ShareOnTwitterReplayPressed", 106, "Share on Twitter - button pressed (replay)");
        aSU = new <init>("ShareOnTwitterReplayCanceled", 107, "Share on Twitter - cancelled (replay)");
        aSV = new <init>("ShareOnTwitterReplayCompleted", 108, "Share on Twitter - completed (replay)");
        aSW = new <init>("AppLaunch", 109, "App Launch");
        aSX = (new aSX[] {
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

    private g.String(String s, int i, String s1)
    {
        super(s, i);
        Sx = s1;
    }
}
