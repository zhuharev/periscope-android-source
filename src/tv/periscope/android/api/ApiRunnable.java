// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;

import android.os.Bundle;
import android.os.Process;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import o.FF6A;
import o.atg;
import o.atm;
import o.aui;
import o.ql;
import o.zu;
import o.zy;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedFile;
import retrofit.mime.TypedInput;
import tv.periscope.android.signer.SignerService;

// Referenced classes of package tv.periscope.android.api:
//            AdjustBroadcastRankRequest, ApiService, BlockRequest, BlockResponse, 
//            PsBroadcast, DeleteBroadcastRequest, DeleteReplayRequest, ApiRequestWithLogs, 
//            TwitterLoginRequest, TwitterLoginResponse, ValidateUsernameRequest, ValidateUsernameError, 
//            VerifyUsernameRequest, GetUserRequest, GetFollowersRequest, FetchUsersResponse, 
//            GetFollowingRequest, PsRequest, FollowRequest, FollowResponse, 
//            MuteRequest, MuteResponse, UnMuteRequest, UnMuteResponse, 
//            UnfollowRequest, UnfollowResponse, AccessChannelRequest, AccessChannelResponse, 
//            SuggestedPeopleRequest, UserSearchRequest, MainBroadcastFollowingRequest, MainBroadcastFeaturedRequest, 
//            GetBroadcastRequest, GetBroadcastViewersRequest, GetBroadcastViewersResponse, RankedBroadcastsRequest, 
//            BroadcastRankRequest, GetBroadcastRankParametersRequest, SetBroadcastRankParametersRequest, CreateBroadcastRequest, 
//            CreateBroadcastResponse, ReplayViewedRequest, EndReplayViewedRequest, PublishBroadcastRequest, 
//            SetSettingsRequest, PsSettings, GetSettingsRequest, BroadcastSummaryRequest, 
//            BroadcastSummaryResponse, BroadcastIdForTokenRequest, UploadTestResponse, UserBroadcastsRequest, 
//            PlaybackMetaRequest, BroadcastMetaRequest, GetBroadcastShareUrlRequest, GetBroadcastShareUrlResponse, 
//            MapGeoBroadcastFeedRequest, HelloRequest, TypedFiles, TypedFileString, 
//            ThumbnailPlaylistRequest, ThumbnailPlaylistResponse, MarkAbuseRequest, ShareBroadcastRequest, 
//            UpdateDescriptionRequest, UpdateDisplayNameRequest

public class ApiRunnable
    implements Runnable
{
    public static class Builder
    {

        private int mActionCode;
        private long mBackoffInterval;
        private Bundle mBundle;
        private ql mEventBus;
        private int mNumRetries;
        private PsRequest mRequest;
        private ApiService mService;
        private SignerService mSigner;

        public ApiRunnable build()
        {
            return new ApiRunnable(mEventBus, mService, mSigner, mActionCode, mRequest, mBundle, mNumRetries, mBackoffInterval);
        }

        public Builder setActionCode(int i)
        {
            mActionCode = i;
            return this;
        }

        public Builder setBackoffInterval(long l)
        {
            mBackoffInterval = l;
            return this;
        }

        public Builder setBundle(Bundle bundle)
        {
            mBundle = bundle;
            return this;
        }

        public Builder setEventBus(ql ql1)
        {
            mEventBus = ql1;
            return this;
        }

        public Builder setNumRetries(int i)
        {
            mNumRetries = i;
            return this;
        }

        public Builder setRequest(PsRequest psrequest)
        {
            mRequest = psrequest;
            return this;
        }

        public Builder setService(ApiService apiservice)
        {
            mService = apiservice;
            return this;
        }

        public Builder setSigner(SignerService signerservice)
        {
            mSigner = signerservice;
            return this;
        }

        public Builder()
        {
            mActionCode = -1;
            mNumRetries = 5;
            mBackoffInterval = 2000L;
        }
    }


    public static final int ACTION_CODE_ACCESS_CHANNEL = 13;
    public static final int ACTION_CODE_ADJUST_BROADCAST_RANK = 58;
    public static final int ACTION_CODE_BATCH_FOLLOW = 21;
    public static final int ACTION_CODE_BLOCK = 35;
    public static final int ACTION_CODE_BROADCAST_META = 54;
    public static final int ACTION_CODE_BROADCAST_RANK = 51;
    public static final int ACTION_CODE_BROADCAST_SUMMARY = 34;
    public static final int ACTION_CODE_CREATE_BROADCAST = 23;
    public static final int ACTION_CODE_DELETE_BROADCAST = 43;
    public static final int ACTION_CODE_DELETE_REPLAY = 42;
    public static final int ACTION_CODE_END_BROADCAST = 31;
    public static final int ACTION_CODE_END_REPLAY_VIEWED = 25;
    public static final int ACTION_CODE_FIND_FRIENDS = 14;
    public static final int ACTION_CODE_FOLLOW = 8;
    public static final int ACTION_CODE_GET_BLOCKED = 37;
    public static final int ACTION_CODE_GET_BROADCASTS = 19;
    public static final int ACTION_CODE_GET_BROADCAST_ID_FROM_URL = 39;
    public static final int ACTION_CODE_GET_BROADCAST_SHARE_URL = 33;
    public static final int ACTION_CODE_GET_BROADCAST_VIEWERS = 20;
    public static final int ACTION_CODE_GET_FOLLOWERS = 6;
    public static final int ACTION_CODE_GET_FOLLOWERS_BY_ID = 12;
    public static final int ACTION_CODE_GET_FOLLOWING = 7;
    public static final int ACTION_CODE_GET_FOLLOWING_BY_ID = 11;
    public static final int ACTION_CODE_GET_GLOBAL_BROADCAST_FEED = 4;
    public static final int ACTION_CODE_GET_MUTUAL_FOLLOWS = 60;
    public static final int ACTION_CODE_GET_RANK_PARAMETERS = 49;
    public static final int ACTION_CODE_GET_SETTINGS = 30;
    public static final int ACTION_CODE_GET_USER = 5;
    public static final int ACTION_CODE_GET_USER_BY_ID = 10;
    public static final int ACTION_CODE_GET_USER_BY_USERNAME = 61;
    public static final int ACTION_CODE_HELLO = 59;
    public static final int ACTION_CODE_MAIN_FEATURED = 18;
    public static final int ACTION_CODE_MAIN_FOLLOWING = 17;
    public static final int ACTION_CODE_MAIN_GLOBAL_MAP = 52;
    public static final int ACTION_CODE_MUTE = 55;
    public static final int ACTION_CODE_PING_BROADCAST = 32;
    public static final int ACTION_CODE_PING_WATCHING = 27;
    public static final int ACTION_CODE_PLAYBACK_META = 53;
    public static final int ACTION_CODE_PUBLISH_BROADCAST = 26;
    public static final int ACTION_CODE_REPLAY_THUMBNAIL_PLAYLIST = 62;
    public static final int ACTION_CODE_REPLAY_VIEWED = 24;
    public static final int ACTION_CODE_REPORT_BROADCAST = 41;
    public static final int ACTION_CODE_SET_RANK_PARAMETERS = 50;
    public static final int ACTION_CODE_SET_SETTINGS = 29;
    public static final int ACTION_CODE_SHARE_BROADCAST = 38;
    public static final int ACTION_CODE_STOP_WATCHING = 28;
    public static final int ACTION_CODE_SUPPORTED_LANGUAGES = 57;
    public static final int ACTION_CODE_TWITTER_LOGIN = 1;
    public static final int ACTION_CODE_UNBAN = 63;
    public static final int ACTION_CODE_UNBLOCK = 36;
    public static final int ACTION_CODE_UNFOLLOW = 9;
    public static final int ACTION_CODE_UNKNOWN = -1;
    public static final int ACTION_CODE_UNMUTE = 56;
    public static final int ACTION_CODE_UPDATE_PROFILE_DESCRIPTION = 46;
    public static final int ACTION_CODE_UPDATE_PROFILE_DISPLAY_NAME = 47;
    public static final int ACTION_CODE_UPLOAD_PROFILE_IMAGE = 45;
    public static final int ACTION_CODE_UPLOAD_TEST = 40;
    public static final int ACTION_CODE_USER_BROADCASTS = 44;
    public static final int ACTION_CODE_USER_SEARCH = 15;
    public static final int ACTION_CODE_VALIDATE_USERNAME = 2;
    public static final int ACTION_CODE_VERIFY_USERNAME = 3;
    public static final long BACKOFF_INTERVAL_NONE = 0L;
    public static final long DEFAULT_BACKOFF_MS = 2000L;
    public static final int DEFAULT_RETRIES = 5;
    public static final String EXTRA_BROADCAST_ID = "e_broadcast_id";
    public static final String EXTRA_CACHE_DIR = "e_cache_dir";
    public static final String EXTRA_CHANNEL = "e_channel";
    public static final String EXTRA_COMPLETION = "e_completion";
    public static final String EXTRA_COOKIE = "e_cookie";
    public static final String EXTRA_COUNT = "e_count";
    public static final String EXTRA_DECAY_COEFFICIENT = "e_rank_decay";
    public static final String EXTRA_DECAY_HALF_LIFE = "e_rank_decay_half_life";
    public static final String EXTRA_DECREASE_RANK = "e_decrease_rank";
    public static final String EXTRA_DESCRIPTION = "e_description";
    public static final String EXTRA_DISPLAY_NAME = "e_display_name";
    public static final String EXTRA_DURATION = "e_duration";
    public static final String EXTRA_FILE_DIR = "e_file_dir";
    public static final String EXTRA_FOLLOWING_ONLY_CHAT = "e_following_only_chat";
    public static final String EXTRA_HAS_LOCATION = "e_has_loc";
    public static final String EXTRA_HEIGHT = "extra_height";
    public static final String EXTRA_IDS = "extra_ids";
    public static final String EXTRA_INCREASE_RANK = "e_increase_rank";
    public static final String EXTRA_INSTALL_ID = "e_install_id";
    public static final String EXTRA_IS_AUTOSAVE_ENABLED = "e_autosave_enabled";
    public static final String EXTRA_IS_USER_FOLLOW_ENABLED = "e_user_follow_enabled";
    public static final String EXTRA_LANGUAGES = "e_languages";
    public static final String EXTRA_LAT = "e_lat";
    public static final String EXTRA_LOCALE = "e_locale";
    public static final String EXTRA_LOCKED_IDs = "e_locked_ids";
    public static final String EXTRA_LOGGER_NAME = "e_logger_name";
    public static final String EXTRA_LONG = "e_long";
    public static final String EXTRA_MY_USER_ID = "e_my_user_id";
    public static final String EXTRA_NUM_COMMENTS = "e_n_comments";
    public static final String EXTRA_NUM_HEARTS = "e_num_hearts";
    public static final String EXTRA_PHONE_NUMBER = "e_phone_number";
    public static final String EXTRA_POINT_1_LAT = "e_point_1_lat";
    public static final String EXTRA_POINT_1_LNG = "e_point_1_lng";
    public static final String EXTRA_POINT_2_LAT = "e_point_2_lat";
    public static final String EXTRA_POINT_2_LNG = "e_point_2_lng";
    public static final String EXTRA_PUBNUB_STATS = "e_pb_stats";
    public static final String EXTRA_QUERY = "extra_query";
    public static final String EXTRA_REASON = "e_reason";
    public static final String EXTRA_REGION = "e_region";
    public static final String EXTRA_REPORT_CORTEX_SCORE_COEFFICIENT = "e_rank_cortex_score";
    public static final String EXTRA_REPORT_HAS_LOCATION_COEFFICIENT = "e_rank_has_location";
    public static final String EXTRA_REPORT_RATIO_COEFFICIENT = "e_rank_report_ratio";
    public static final String EXTRA_REPORT_SHARES_COEFFICIENT = "e_rank_shares";
    public static final String EXTRA_SECRET_KEY = "e_secret_key";
    public static final String EXTRA_SECRET_TOKEN = "e_secret_token";
    public static final String EXTRA_SESSION_ID = "e_session_id";
    public static final String EXTRA_SESSION_TYPE = "e_session_type";
    public static final String EXTRA_SIGN_UP = "e_sign_up";
    public static final String EXTRA_SINCE = "e_since";
    public static final String EXTRA_STATS = "e_stats";
    public static final String EXTRA_STICKINESS_COEFFICIENT = "e_rank_stickiness";
    public static final String EXTRA_TITLE = "e_title";
    public static final String EXTRA_TOKEN = "e_token";
    public static final String EXTRA_USERNAME = "e_username";
    public static final String EXTRA_USER_ID = "e_user_id";
    public static final String EXTRA_USER_IDS = "e_user_ids";
    public static final String EXTRA_VERIFIED_COEFFICIENT = "e_rank_verified";
    public static final String EXTRA_VIEWERS_COUNT_COEFFICIENT = "e_rank_viewers";
    public static final String EXTRA_WIDTH = "extra_width";
    public static final int MAX_BATCH_FOLLOW = 100;
    public static final int MAX_GET_BROADCASTS = 100;
    public static final int NUM_RETRIES_NONE = 0;
    private static final String PROFILE_IMAGE_FILENAME = "image.jpeg";
    private static final String TAG = "PsApi";
    private static final int UPLOAD_TEST_SIZE = 0x3d090;
    private final int mActionCode;
    private final Bundle mBundle;
    private final ql mEventBus;
    private int mNumRetries;
    private final PsRequest mRequest;
    private long mRetryBackoff;
    private final long mRetryInterval;
    private final ApiService mService;
    private final SignerService mSigner;

    ApiRunnable(ql ql1, ApiService apiservice, SignerService signerservice, int i, PsRequest psrequest, Bundle bundle, int j, 
            long l)
    {
        mEventBus = ql1;
        mService = apiservice;
        mSigner = signerservice;
        mActionCode = i;
        mRequest = psrequest;
        mBundle = bundle;
        mNumRetries = j;
        mRetryInterval = l;
        mRetryBackoff = mRetryInterval;
    }

    private zu adjustBroadcastRank(Bundle bundle)
    {
        AdjustBroadcastRankRequest adjustbroadcastrankrequest = new AdjustBroadcastRankRequest();
        adjustbroadcastrankrequest.cookie = bundle.getString("e_cookie");
        adjustbroadcastrankrequest.broadcastId = bundle.getString("e_broadcast_id");
        adjustbroadcastrankrequest.increase = bundle.getBoolean("e_increase_rank");
        adjustbroadcastrankrequest.decrease = bundle.getBoolean("e_decrease_rank");
        try
        {
            bundle = mService.adjustBroadcastRank(adjustbroadcastrankrequest);
            bundle = new zu(o.zu.if.aXR, adjustbroadcastrankrequest, bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            return new zu(o.zu.if.aXR, adjustbroadcastrankrequest, bundle);
        }
        return bundle;
    }

    private zu block(BlockRequest blockrequest)
    {
        Object obj;
        try
        {
            obj = mService.block(blockrequest);
            obj.userId = blockrequest.userId;
            obj = new zu(o.zu.if.aYd, blockrequest, obj);
        }
        catch (RetrofitError retrofiterror)
        {
            return new zu(o.zu.if.aYd, blockrequest, retrofiterror);
        }
        return ((zu) (obj));
    }

    private List convert(Collection collection)
    {
        ArrayList arraylist = new ArrayList(collection.size());
        for (collection = collection.iterator(); collection.hasNext(); arraylist.add(((PsBroadcast)collection.next()).create())) { }
        return arraylist;
    }

    private zu deleteBroadcast(Bundle bundle)
    {
        String s = bundle.getString("e_broadcast_id");
        DeleteBroadcastRequest deletebroadcastrequest = new DeleteBroadcastRequest();
        deletebroadcastrequest.cookie = bundle.getString("e_cookie");
        deletebroadcastrequest.broadcastId = s;
        try
        {
            mService.deleteBroadcast(deletebroadcastrequest);
            bundle = new zu(o.zu.if.aXO, deletebroadcastrequest, new atg(s));
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            return new zu(o.zu.if.aXO, deletebroadcastrequest, bundle);
        }
        return bundle;
    }

    private zu deleteReplay(Bundle bundle)
    {
        String s = bundle.getString("e_broadcast_id");
        DeleteReplayRequest deletereplayrequest = new DeleteReplayRequest();
        deletereplayrequest.cookie = bundle.getString("e_cookie");
        deletereplayrequest.broadcastId = s;
        try
        {
            bundle = mService.deleteReplay(deletereplayrequest);
            bundle = new zu(o.zu.if.aXL, deletereplayrequest, bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            return new zu(o.zu.if.aXL, deletereplayrequest, bundle);
        }
        return bundle;
    }

    private zu endBroadcast(Bundle bundle)
    {
        String s = bundle.getString("e_broadcast_id");
        String s1 = bundle.getString("e_logger_name");
        return (new _cls5()).execute(s1);
    }

    private zu execute()
    {
        Object obj;
        Object obj34;
        obj34 = mBundle;
        obj = mRequest;
        mActionCode;
        JVM INSTR tableswitch 1 63: default 280
    //                   1 283
    //                   2 451
    //                   3 578
    //                   4 2737
    //                   5 697
    //                   6 773
    //                   7 862
    //                   8 1016
    //                   9 1473
    //                   10 1626
    //                   11 1878
    //                   12 1788
    //                   13 1968
    //                   14 2095
    //                   15 2273
    //                   16 4851
    //                   17 2353
    //                   18 2422
    //                   19 2491
    //                   20 2604
    //                   21 1280
    //                   22 4851
    //                   23 3231
    //                   24 3392
    //                   25 3462
    //                   26 3583
    //                   27 3796
    //                   28 3803
    //                   29 3810
    //                   30 3922
    //                   31 3987
    //                   32 3994
    //                   33 4022
    //                   34 4029
    //                   35 4112
    //                   36 4121
    //                   37 4128
    //                   38 4001
    //                   39 4135
    //                   40 4212
    //                   41 4008
    //                   42 3576
    //                   43 3789
    //                   44 4522
    //                   45 4656
    //                   46 4742
    //                   47 4735
    //                   48 4851
    //                   49 2953
    //                   50 3018
    //                   51 2877
    //                   52 2870
    //                   53 4749
    //                   54 4800
    //                   55 1104
    //                   56 1192
    //                   57 3189
    //                   58 4015
    //                   59 690
    //                   60 951
    //                   61 1707
    //                   62 3385
    //                   63 1561;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L1 _L17 _L18 _L19 _L20 _L21 _L1 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L1 _L47 _L48 _L49 _L50 _L51 _L52 _L53 _L54 _L55 _L56 _L57 _L58 _L59 _L60 _L61
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        Object obj1 = ((Bundle) (obj34)).getString("e_secret_key");
        String s1 = ((Bundle) (obj34)).getString("e_secret_token");
        String s4 = ((Bundle) (obj34)).getString("e_username");
        String s6 = ((Bundle) (obj34)).getString("e_user_id");
        String s7 = ((Bundle) (obj34)).getString("e_phone_number");
        String s8 = ((Bundle) (obj34)).getString("e_install_id");
        obj34 = ((Bundle) (obj34)).getString("e_session_type");
        obj = new TwitterLoginRequest();
        obj.sessionKey = s1;
        obj.sessionSecret = ((String) (obj1));
        obj.userName = s4;
        obj.userId = s6;
        obj.phoneNumber = s7;
        obj.installId = s8;
        try
        {
            obj1 = mService.login(((TwitterLoginRequest) (obj)));
            obj1.sessionType = o.acj.if.valueOf(((String) (obj34)));
            obj1 = new zu(o.zu.if.aXm, ((PsRequest) (obj)), obj1);
        }
        catch (RetrofitError retrofiterror2)
        {
            return new zu(o.zu.if.aXm, ((PsRequest) (obj)), retrofiterror2);
        }
        return ((zu) (obj1));
_L3:
        obj = new ValidateUsernameRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj.username = ((Bundle) (obj34)).getString("e_username");
        obj.sessionKey = ((Bundle) (obj34)).getString("e_secret_key");
        obj.sessionSecret = ((Bundle) (obj34)).getString("e_secret_token");
        Object obj2;
        try
        {
            obj2 = mService.validateUsername(((ValidateUsernameRequest) (obj)));
            obj2 = new zu(o.zu.if.aXn, ((PsRequest) (obj)), obj2);
        }
        catch (RetrofitError retrofiterror3)
        {
            zu zu1;
            try
            {
                zu1 = new zu(o.zu.if.aXn, ((ValidateUsernameRequest) (obj)), retrofiterror3, retrofiterror3.getBodyAs(tv/periscope/android/api/ValidateUsernameError));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj32)
            {
                return new zu(o.zu.if.aXn, ((PsRequest) (obj)), retrofiterror3);
            }
            return zu1;
        }
        return ((zu) (obj2));
_L4:
        obj = new VerifyUsernameRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj.username = ((Bundle) (obj34)).getString("e_username");
        obj.displayName = ((Bundle) (obj34)).getString("e_display_name");
        obj.sessionKey = ((Bundle) (obj34)).getString("e_secret_key");
        obj.sessionSecret = ((Bundle) (obj34)).getString("e_secret_token");
        Object obj3;
        try
        {
            obj3 = mService.verifyUsername(((VerifyUsernameRequest) (obj)));
            obj3 = new zu(o.zu.if.aXo, ((PsRequest) (obj)), obj3);
        }
        catch (RetrofitError retrofiterror4)
        {
            return new zu(o.zu.if.aXo, ((PsRequest) (obj)), retrofiterror4);
        }
        return ((zu) (obj3));
_L57:
        return hello(((Bundle) (obj34)));
_L6:
        obj = new GetUserRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj.userId = ((Bundle) (obj34)).getString("e_my_user_id");
        Object obj4;
        try
        {
            obj4 = mService.getUser(((GetUserRequest) (obj)));
            obj4 = new zu(o.zu.if.aXq, ((PsRequest) (obj)), obj4);
        }
        catch (RetrofitError retrofiterror5)
        {
            return new zu(o.zu.if.aXq, ((PsRequest) (obj)), retrofiterror5);
        }
        return ((zu) (obj4));
_L7:
        Object obj5 = ((Bundle) (obj34)).getString("e_my_user_id");
        obj = new GetFollowersRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj.userId = ((String) (obj5));
        try
        {
            List list = mService.getFollowers(((GetFollowersRequest) (obj)));
            obj5 = new zu(o.zu.if.aXr, ((PsRequest) (obj)), new FetchUsersResponse(((String) (obj5)), list));
        }
        catch (RetrofitError retrofiterror6)
        {
            return new zu(o.zu.if.aXr, ((PsRequest) (obj)), retrofiterror6);
        }
        return ((zu) (obj5));
_L8:
        Object obj6 = ((Bundle) (obj34)).getString("e_my_user_id");
        obj = new GetFollowingRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj.userId = ((String) (obj6));
        try
        {
            List list1 = mService.getFollowing(((GetFollowingRequest) (obj)));
            obj6 = new zu(o.zu.if.aXs, ((PsRequest) (obj)), new FetchUsersResponse(((String) (obj6)), list1));
        }
        catch (RetrofitError retrofiterror7)
        {
            return new zu(o.zu.if.aXs, ((PsRequest) (obj)), retrofiterror7);
        }
        return ((zu) (obj6));
_L58:
        obj = new PsRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        Object obj7;
        try
        {
            obj7 = mService.getMutualFollows(((PsRequest) (obj)));
            obj7 = new zu(o.zu.if.aXt, ((PsRequest) (obj)), obj7);
        }
        catch (RetrofitError retrofiterror8)
        {
            return new zu(o.zu.if.aXt, ((PsRequest) (obj)), retrofiterror8);
        }
        return ((zu) (obj7));
_L9:
        Object obj8 = ((Bundle) (obj34)).getString("e_user_id");
        obj = new FollowRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj.userId = ((String) (obj8));
        try
        {
            FollowResponse followresponse = mService.follow(((FollowRequest) (obj)));
            followresponse.userId = ((String) (obj8));
            obj8 = new zu(o.zu.if.aXu, ((PsRequest) (obj)), followresponse);
        }
        catch (RetrofitError retrofiterror9)
        {
            return new zu(o.zu.if.aXu, ((PsRequest) (obj)), retrofiterror9);
        }
        return ((zu) (obj8));
_L53:
        Object obj9 = ((Bundle) (obj34)).getString("e_user_id");
        obj = new MuteRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj.userId = ((String) (obj9));
        try
        {
            MuteResponse muteresponse = mService.mute(((MuteRequest) (obj)));
            muteresponse.userId = ((String) (obj9));
            obj9 = new zu(o.zu.if.aXv, ((PsRequest) (obj)), muteresponse);
        }
        catch (RetrofitError retrofiterror10)
        {
            return new zu(o.zu.if.aXv, ((PsRequest) (obj)), retrofiterror10);
        }
        return ((zu) (obj9));
_L54:
        Object obj10 = ((Bundle) (obj34)).getString("e_user_id");
        obj = new UnMuteRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj.userId = ((String) (obj10));
        try
        {
            UnMuteResponse unmuteresponse = mService.unmute(((UnMuteRequest) (obj)));
            unmuteresponse.userId = ((String) (obj10));
            obj10 = new zu(o.zu.if.aXw, ((PsRequest) (obj)), unmuteresponse);
        }
        catch (RetrofitError retrofiterror11)
        {
            return new zu(o.zu.if.aXw, ((PsRequest) (obj)), retrofiterror11);
        }
        return ((zu) (obj10));
_L21:
        String s;
        int i;
        int l;
        int k1;
        int l1;
        String as[] = ((Bundle) (obj34)).getStringArray("extra_ids");
        obj = as;
        if (as.length > 100)
        {
            obj = (String[])Arrays.copyOfRange(as, 0, 100);
        }
        k1 = obj.length;
        i = 0;
        s = ((Bundle) (obj34)).getString("e_cookie");
        l1 = obj.length;
        l = 0;
_L65:
        FollowRequest followrequest;
        int j1;
        if (l >= l1)
        {
            break; /* Loop/switch isn't completed */
        }
        String s5 = obj[l];
        followrequest = new FollowRequest();
        followrequest.cookie = s;
        followrequest.userId = s5;
        j1 = i;
        Object obj33 = mService.follow(followrequest);
        i++;
        if (i != k1) goto _L63; else goto _L62
_L62:
        j1 = i;
        obj33 = new zu(o.zu.if.aXH, followrequest, obj33);
        return ((zu) (obj33));
        RetrofitError retrofiterror30;
        retrofiterror30;
        j1++;
        i = j1;
        if (j1 == k1)
        {
            return new zu(o.zu.if.aXH, followrequest, retrofiterror30);
        }
_L63:
        l++;
        if (true) goto _L65; else goto _L64
_L64:
        break; /* Loop/switch isn't completed */
_L10:
        Object obj11 = ((Bundle) (obj34)).getString("e_user_id");
        obj = new UnfollowRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj.userId = ((String) (obj11));
        try
        {
            UnfollowResponse unfollowresponse = mService.unfollow(((UnfollowRequest) (obj)));
            unfollowresponse.userId = ((String) (obj11));
            obj11 = new zu(o.zu.if.aXx, ((PsRequest) (obj)), unfollowresponse);
        }
        catch (RetrofitError retrofiterror12)
        {
            return new zu(o.zu.if.aXx, ((PsRequest) (obj)), retrofiterror12);
        }
        return ((zu) (obj11));
_L61:
        obj = new PsRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        Object obj12;
        try
        {
            obj12 = mService.unban(((PsRequest) (obj)));
            obj12 = new zu(o.zu.if.aXy, ((PsRequest) (obj)), obj12);
        }
        catch (RetrofitError retrofiterror13)
        {
            return new zu(o.zu.if.aXy, ((PsRequest) (obj)), retrofiterror13);
        }
        return ((zu) (obj12));
_L11:
        Object obj13 = ((Bundle) (obj34)).getString("e_user_id");
        obj = new GetUserRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj.userId = ((String) (obj13));
        try
        {
            obj13 = mService.getUser(((GetUserRequest) (obj)));
            obj13 = new zu(o.zu.if.aXq, ((PsRequest) (obj)), obj13);
        }
        catch (RetrofitError retrofiterror14)
        {
            return new zu(o.zu.if.aXq, ((PsRequest) (obj)), retrofiterror14);
        }
        return ((zu) (obj13));
_L59:
        Object obj14 = ((Bundle) (obj34)).getString("e_username");
        obj = new GetUserRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj.username = ((String) (obj14));
        try
        {
            obj14 = mService.getUser(((GetUserRequest) (obj)));
            obj14 = new zu(o.zu.if.aXq, ((PsRequest) (obj)), obj14);
        }
        catch (RetrofitError retrofiterror15)
        {
            return new zu(o.zu.if.aXq, ((PsRequest) (obj)), retrofiterror15);
        }
        return ((zu) (obj14));
_L13:
        Object obj15 = ((Bundle) (obj34)).getString("e_user_id");
        obj = new GetFollowersRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj.userId = ((String) (obj15));
        try
        {
            List list2 = mService.getFollowers(((GetFollowersRequest) (obj)));
            obj15 = new zu(o.zu.if.aXr, ((PsRequest) (obj)), new FetchUsersResponse(((String) (obj15)), list2));
        }
        catch (RetrofitError retrofiterror16)
        {
            return new zu(o.zu.if.aXr, ((PsRequest) (obj)), retrofiterror16);
        }
        return ((zu) (obj15));
_L12:
        Object obj16 = ((Bundle) (obj34)).getString("e_user_id");
        obj = new GetFollowingRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj.userId = ((String) (obj16));
        try
        {
            List list3 = mService.getFollowing(((GetFollowingRequest) (obj)));
            obj16 = new zu(o.zu.if.aXs, ((PsRequest) (obj)), new FetchUsersResponse(((String) (obj16)), list3));
        }
        catch (RetrofitError retrofiterror17)
        {
            return new zu(o.zu.if.aXs, ((PsRequest) (obj)), retrofiterror17);
        }
        return ((zu) (obj16));
_L14:
        Object obj17 = ((Bundle) (obj34)).getString("e_broadcast_id");
        obj = new AccessChannelRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj.broadcastId = ((String) (obj17));
        try
        {
            FF6A._mth02CB("RTMP", (new StringBuilder("API: accessing channel for ")).append(((String) (obj17))).toString());
            obj17 = mService.accessChannel(((AccessChannelRequest) (obj)));
            FF6A._mth02CB("RTMP", "API: accessChannel succeeded");
            obj17 = new zu(o.zu.if.aXz, ((PsRequest) (obj)), ((AccessChannelResponse) (obj17)).create());
        }
        catch (RetrofitError retrofiterror18)
        {
            FF6A._mth02CA("RTMP", "API: accessChannel failed", retrofiterror18);
            return new zu(o.zu.if.aXz, ((PsRequest) (obj)), retrofiterror18);
        }
        return ((zu) (obj17));
_L15:
        Object obj18 = ((Bundle) (obj34)).getString("e_secret_key");
        String s2 = ((Bundle) (obj34)).getString("e_secret_token");
        boolean flag = ((Bundle) (obj34)).getBoolean("e_sign_up", false);
        retrofiterror30 = ((Bundle) (obj34)).getStringArrayList("e_languages");
        obj = new SuggestedPeopleRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj.twitterSessionKey = ((String) (obj18));
        obj.twitterSessionSecret = s2;
        obj.signup = flag;
        if (retrofiterror30 != null && !retrofiterror30.isEmpty())
        {
            obj.languages = new String[retrofiterror30.size()];
            retrofiterror30.toArray(((SuggestedPeopleRequest) (obj)).languages);
        } else
        {
            obj.languages = (new String[] {
                Locale.getDefault().getLanguage()
            });
        }
        try
        {
            obj18 = mService.suggestedPeople(((SuggestedPeopleRequest) (obj)));
            obj18 = new zu(o.zu.if.aXA, ((PsRequest) (obj)), obj18);
        }
        catch (RetrofitError retrofiterror19)
        {
            return new zu(o.zu.if.aXA, ((PsRequest) (obj)), retrofiterror19);
        }
        return ((zu) (obj18));
_L16:
        Object obj19 = ((Bundle) (obj34)).getString("extra_query");
        obj = new UserSearchRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj.search = ((String) (obj19));
        try
        {
            obj19 = mService.userSearch(((UserSearchRequest) (obj)));
            obj19 = new zu(o.zu.if.aXB, ((PsRequest) (obj)), obj19);
        }
        catch (RetrofitError retrofiterror20)
        {
            return new zu(o.zu.if.aXB, ((PsRequest) (obj)), retrofiterror20);
        }
        return ((zu) (obj19));
_L17:
        obj = new MainBroadcastFollowingRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        Object obj20;
        try
        {
            obj20 = mService.followingBroadcastFeed(((MainBroadcastFollowingRequest) (obj)));
            obj20 = new zu(o.zu.if.aXD, ((PsRequest) (obj)), convert(((Collection) (obj20))));
        }
        catch (RetrofitError retrofiterror21)
        {
            return new zu(o.zu.if.aXD, ((PsRequest) (obj)), retrofiterror21);
        }
        return ((zu) (obj20));
_L18:
        obj = new MainBroadcastFeaturedRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        Object obj21;
        try
        {
            obj21 = mService.featuredBroadcastFeed(((MainBroadcastFeaturedRequest) (obj)));
            obj21 = new zu(o.zu.if.aXC, ((PsRequest) (obj)), convert(((Collection) (obj21))));
        }
        catch (RetrofitError retrofiterror22)
        {
            return new zu(o.zu.if.aXC, ((PsRequest) (obj)), retrofiterror22);
        }
        return ((zu) (obj21));
_L19:
        Object obj22 = ((Bundle) (obj34)).getStringArrayList("extra_ids");
        obj = new GetBroadcastRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj.ids = ((ArrayList) (obj22));
        try
        {
            FF6A._mth02CB("RTMP", "API: getting broadcasts");
            obj22 = mService.getBroadcasts(((GetBroadcastRequest) (obj)));
            FF6A._mth02CB("RTMP", "API: getBroadcasts succeeded");
            obj22 = new zu(o.zu.if.aXE, ((PsRequest) (obj)), convert(((Collection) (obj22))));
        }
        catch (RetrofitError retrofiterror23)
        {
            FF6A._mth02CA("RTMP", "API: getBroadcasts failed", retrofiterror23);
            return new zu(o.zu.if.aXE, ((PsRequest) (obj)), retrofiterror23);
        }
        return ((zu) (obj22));
_L20:
        Object obj23 = ((Bundle) (obj34)).getString("e_broadcast_id");
        String s3 = ((Bundle) (obj34)).getString("e_user_id");
        obj = new GetBroadcastViewersRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj.id = ((String) (obj23));
        try
        {
            FF6A._mth02CB("RTMP", "API: getting broadcast viewers");
            retrofiterror30 = mService.getBroadcastViewers(((GetBroadcastViewersRequest) (obj)));
            FF6A._mth02CB("RTMP", "API: getBroadcastViewers succeeded");
            retrofiterror30.broadcastId = ((String) (obj23));
            retrofiterror30.broadcasterId = s3;
            obj23 = new zu(o.zu.if.aXG, ((PsRequest) (obj)), retrofiterror30);
        }
        catch (RetrofitError retrofiterror24)
        {
            FF6A._mth02CA("RTMP", "API: getBroadcastViewers failed", retrofiterror24);
            return new zu(o.zu.if.aXG, ((PsRequest) (obj)), retrofiterror24);
        }
        return ((zu) (obj23));
_L5:
        obj = new RankedBroadcastsRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        Object obj24 = ((Bundle) (obj34)).getStringArrayList("e_languages");
        if (obj24 != null && !((ArrayList) (obj24)).isEmpty())
        {
            obj.languages = new String[((ArrayList) (obj24)).size()];
            ((ArrayList) (obj24)).toArray(((RankedBroadcastsRequest) (obj)).languages);
        } else
        {
            obj.languages = (new String[] {
                Locale.getDefault().getLanguage()
            });
        }
        try
        {
            obj24 = mService.rankedBroadcastFeed(((RankedBroadcastsRequest) (obj)));
            obj24 = new zu(o.zu.if.aXI, ((PsRequest) (obj)), convert(((Collection) (obj24))));
        }
        catch (RetrofitError retrofiterror25)
        {
            return new zu(o.zu.if.aXI, ((PsRequest) (obj)), retrofiterror25);
        }
        return ((zu) (obj24));
_L50:
        return getMapBroadcastFeed(((Bundle) (obj34)));
_L49:
        obj = new BroadcastRankRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj.broadcastId = ((Bundle) (obj34)).getString("e_broadcast_id");
        Object obj25;
        try
        {
            obj25 = mService.getBroadcastRank(((BroadcastRankRequest) (obj)));
            obj25 = new zu(o.zu.if.aXV, ((PsRequest) (obj)), obj25);
        }
        catch (RetrofitError retrofiterror26)
        {
            return new zu(o.zu.if.aXV, ((PsRequest) (obj)), retrofiterror26);
        }
        return ((zu) (obj25));
_L47:
        obj = new GetBroadcastRankParametersRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        Object obj26;
        try
        {
            obj26 = mService.getBroadcastsRankParameters(((GetBroadcastRankParametersRequest) (obj)));
            obj26 = new zu(o.zu.if.aXW, ((PsRequest) (obj)), obj26);
        }
        catch (RetrofitError retrofiterror27)
        {
            return new zu(o.zu.if.aXW, ((PsRequest) (obj)), retrofiterror27);
        }
        return ((zu) (obj26));
_L48:
        obj = new SetBroadcastRankParametersRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj.stickinessCoefficient = ((Bundle) (obj34)).getString("e_rank_stickiness");
        obj.verifiedCoefficient = ((Bundle) (obj34)).getString("e_rank_verified");
        obj.viewersCountCoefficient = ((Bundle) (obj34)).getString("e_rank_viewers");
        obj.reportRatioCoefficient = ((Bundle) (obj34)).getString("e_rank_report_ratio");
        obj.hasLocationCoefficient = ((Bundle) (obj34)).getString("e_rank_has_location");
        obj.sharesCoefficient = ((Bundle) (obj34)).getString("e_rank_shares");
        obj.cortexScoreCoefficient = ((Bundle) (obj34)).getString("e_rank_cortex_score");
        obj.decayCoefficient = ((Bundle) (obj34)).getString("e_rank_decay");
        obj.decayHalfLife = ((Bundle) (obj34)).getString("e_rank_decay_half_life");
        Object obj27;
        try
        {
            obj27 = mService.setBroadcastsRankParameters(((SetBroadcastRankParametersRequest) (obj)));
            obj27 = new zu(o.zu.if.aXX, ((PsRequest) (obj)), obj27);
        }
        catch (RetrofitError retrofiterror28)
        {
            return new zu(o.zu.if.aXX, ((PsRequest) (obj)), retrofiterror28);
        }
        return ((zu) (obj27));
_L55:
        try
        {
            obj = mService.supportedLanguages("");
            obj = new zu(o.zu.if.aXY, null, obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return new zu(o.zu.if.aXY, null, ((RetrofitError) (obj)));
        }
        return ((zu) (obj));
_L22:
        int j = ((Bundle) (obj34)).getInt("extra_width");
        int i1 = ((Bundle) (obj34)).getInt("extra_height");
        Object obj28 = ((Bundle) (obj34)).getString("e_region");
        obj = new CreateBroadcastRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj.lat = 0.0D;
        obj.lng = 0.0D;
        obj.width = j;
        obj.height = i1;
        obj.region = ((String) (obj28));
        try
        {
            FF6A._mth02CB("RTMP", "API: creating Broadcast");
            obj28 = mService.startBroadcast(((CreateBroadcastRequest) (obj)));
            FF6A._mth02CB("RTMP", "API: createBroadcast succeeded");
            obj28 = new zu(o.zu.if.aXM, ((PsRequest) (obj)), ((CreateBroadcastResponse) (obj28)).create());
        }
        catch (RetrofitError retrofiterror29)
        {
            FF6A._mth02CA("RTMP", "API: createBroadcast failed ", retrofiterror29);
            return new zu(o.zu.if.aXM, ((PsRequest) (obj)), retrofiterror29);
        }
        return ((zu) (obj28));
_L60:
        return replayThumbnailPlaylist(((Bundle) (obj34)));
_L23:
        Object obj32;
        obj = ((Bundle) (obj34)).getString("e_broadcast_id");
        Object obj29 = ((Bundle) (obj34)).getString("e_session_id");
        Object obj31 = new ReplayViewedRequest();
        obj31.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj31.broadcastId = ((String) (obj));
        obj31.session = ((String) (obj29));
        float f;
        float f1;
        Object obj30;
        File file;
        int k;
        long l2;
        boolean flag1;
        boolean flag2;
        try
        {
            mService.replayViewed(((ReplayViewedRequest) (obj31)));
        }
        catch (RetrofitError retrofiterror) { }
        break; /* Loop/switch isn't completed */
_L24:
        obj = ((Bundle) (obj34)).getString("e_broadcast_id");
        obj29 = ((Bundle) (obj34)).getString("e_session_id");
        f = ((Bundle) (obj34)).getFloat("e_duration");
        f1 = ((Bundle) (obj34)).getFloat("e_completion");
        k = ((Bundle) (obj34)).getInt("e_num_hearts");
        obj31 = new EndReplayViewedRequest();
        obj31.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj31.broadcastId = ((String) (obj));
        obj31.session = ((String) (obj29));
        obj31.duration = f;
        obj31.completion = f1;
        obj31.numHearts = k;
        try
        {
            mService.endReplayViewed(((EndReplayViewedRequest) (obj31)));
        }
        catch (RetrofitError retrofiterror1) { }
        break; /* Loop/switch isn't completed */
_L41:
        return deleteReplay(((Bundle) (obj34)));
_L25:
        obj29 = ((Bundle) (obj34)).getString("e_broadcast_id");
        obj31 = ((Bundle) (obj34)).getString("e_title");
        retrofiterror30 = ((Bundle) (obj34)).getStringArrayList("e_locked_ids");
        flag1 = ((Bundle) (obj34)).getBoolean("e_has_loc");
        f = ((Bundle) (obj34)).getFloat("e_lat");
        f1 = ((Bundle) (obj34)).getFloat("e_long");
        flag2 = ((Bundle) (obj34)).getBoolean("e_following_only_chat");
        obj = new PublishBroadcastRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj.broadcastId = ((String) (obj29));
        obj.title = ((String) (obj31));
        obj.lockIds = retrofiterror30;
        obj.hasLocation = flag1;
        obj.lat = f;
        obj.lng = f1;
        obj.followingOnlyChat = flag2;
        obj.locale = Locale.getDefault().getLanguage();
        try
        {
            FF6A._mth02CB("RTMP", "API: publishing broadcast");
            obj29 = mService.publishBroadcast(((PublishBroadcastRequest) (obj)));
            FF6A._mth02CB("RTMP", "API: publishBroadcast succeeded");
            obj29 = new zu(o.zu.if.aXN, ((PsRequest) (obj)), obj29);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj30)
        {
            FF6A._mth02CA("RTMP", "API: publishBroadcast failed", ((Throwable) (obj30)));
            return new zu(o.zu.if.aXN, ((PsRequest) (obj)), ((RetrofitError) (obj30)));
        }
        return ((zu) (obj29));
_L42:
        return deleteBroadcast(((Bundle) (obj34)));
_L26:
        return pingWatching(((Bundle) (obj34)));
_L27:
        return stopWatching(((Bundle) (obj34)));
_L28:
        flag1 = ((Bundle) (obj34)).getBoolean("e_user_follow_enabled");
        flag2 = ((Bundle) (obj34)).getBoolean("e_autosave_enabled");
        obj = new SetSettingsRequest();
        obj30 = new PsSettings();
        obj30.pushNewFollower = flag1;
        obj30.autoSaveToCamera = flag2;
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj.settings = ((PsSettings) (obj30));
        try
        {
            obj30 = mService.setSettings(((SetSettingsRequest) (obj)));
            obj30 = new zu(o.zu.if.aXZ, ((PsRequest) (obj)), obj30);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj30)
        {
            return new zu(o.zu.if.aXZ, ((PsRequest) (obj)), ((RetrofitError) (obj30)));
        }
        return ((zu) (obj30));
_L29:
        obj = new GetSettingsRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        try
        {
            obj30 = mService.getSettings(((GetSettingsRequest) (obj)));
            obj30 = new zu(o.zu.if.aXU, ((PsRequest) (obj)), obj30);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj30)
        {
            return new zu(o.zu.if.aXU, ((PsRequest) (obj)), ((RetrofitError) (obj30)));
        }
        return ((zu) (obj30));
_L30:
        return endBroadcast(((Bundle) (obj34)));
_L31:
        return pingBroadcast(((Bundle) (obj34)));
_L37:
        return shareBroadcast(((Bundle) (obj34)));
_L40:
        return reportBroadcast(((Bundle) (obj34)));
_L56:
        return adjustBroadcastRank(((Bundle) (obj34)));
_L32:
        return getBroadcastShareUrl(((Bundle) (obj34)));
_L33:
        obj30 = ((Bundle) (obj34)).getString("e_broadcast_id");
        obj = new BroadcastSummaryRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj.broadcastId = ((String) (obj30));
        try
        {
            obj30 = mService.broadcastSummary(((BroadcastSummaryRequest) (obj)));
            obj30 = new zu(o.zu.if.aYc, ((PsRequest) (obj)), ((BroadcastSummaryResponse) (obj30)).create());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj30)
        {
            return new zu(o.zu.if.aYc, ((PsRequest) (obj)), ((RetrofitError) (obj30)));
        }
        return ((zu) (obj30));
_L34:
        return block((BlockRequest)obj);
_L35:
        return unblock(((Bundle) (obj34)));
_L36:
        return getBlocked(((Bundle) (obj34)));
_L38:
        obj30 = ((Bundle) (obj34)).getString("e_token");
        obj = new BroadcastIdForTokenRequest();
        obj.cookie = ((Bundle) (obj34)).getString("e_cookie");
        obj.token = ((String) (obj30));
        try
        {
            obj30 = new zu(o.zu.if.aYg, ((PsRequest) (obj)), mService.getBroadcastIdForShareToken(((BroadcastIdForTokenRequest) (obj))));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj30)
        {
            return new zu(o.zu.if.aYg, ((PsRequest) (obj)), ((RetrofitError) (obj30)));
        }
        return ((zu) (obj30));
_L39:
        retrofiterror30 = null;
        obj31 = null;
        obj30 = obj31;
        obj = retrofiterror30;
        file = new File(((Bundle) (obj34)).getString("e_file_dir"), "padding.padding");
        obj30 = obj31;
        obj = retrofiterror30;
        obj31 = new OutputStreamWriter(new FileOutputStream(file));
        obj30 = obj31;
        obj = obj31;
        ((OutputStreamWriter) (obj31)).write(new char[0x3d090]);
        obj30 = obj31;
        obj = obj31;
        retrofiterror30 = new TypedFile("multipart/form-data", file);
        obj30 = obj31;
        obj = obj31;
        l2 = System.currentTimeMillis();
        obj30 = obj31;
        obj = obj31;
        obj34 = ((Bundle) (obj34)).getString("e_cookie");
        obj30 = obj31;
        obj = obj31;
        retrofiterror30 = mSigner.uploadPadding(((String) (obj34)), retrofiterror30);
        obj30 = obj31;
        obj = obj31;
        ((OutputStreamWriter) (obj31)).flush();
        obj30 = obj31;
        obj = obj31;
        retrofiterror30.byteRateSeconds = 250000F / ((float)(System.currentTimeMillis() - l2) / 1000F);
        obj30 = obj31;
        obj = obj31;
        retrofiterror30 = new zu(o.zu.if.aYh, null, retrofiterror30);
        if (obj31 != null)
        {
            try
            {
                ((Closeable) (obj31)).close();
            }
            catch (IOException ioexception)
            {
                return retrofiterror30;
            }
        }
        return retrofiterror30;
        retrofiterror30;
        obj30 = obj31;
        obj = obj31;
        retrofiterror30 = new zu(o.zu.if.aYh, null, retrofiterror30);
        if (obj31 != null)
        {
            try
            {
                ((Closeable) (obj31)).close();
            }
            catch (IOException ioexception1)
            {
                return retrofiterror30;
            }
        }
        return retrofiterror30;
        obj32;
        obj = obj30;
        obj32 = new zu(o.zu.if.aYh, null, ((IOException) (obj32)));
        if (obj30 != null)
        {
            try
            {
                ((Closeable) (obj30)).close();
            }
            catch (IOException ioexception2)
            {
                return ((zu) (obj32));
            }
        }
        return ((zu) (obj32));
        obj30;
        if (obj != null)
        {
            try
            {
                ((Closeable) (obj)).close();
            }
            catch (IOException ioexception3) { }
        }
        throw obj30;
_L43:
        obj = (UserBroadcastsRequest)obj;
        obj30 = mService.userBroadcasts(((UserBroadcastsRequest) (obj)));
        if (!aui._mth02BF(((UserBroadcastsRequest) (obj)).userId)) goto _L67; else goto _L66
_L66:
        obj30 = new zu(o.zu.if.aYi, ((PsRequest) (obj)), new atm(((UserBroadcastsRequest) (obj)).userId, "", Collections.unmodifiableList(convert(((Collection) (obj30))))));
        return ((zu) (obj30));
_L67:
        if (!aui._mth02BF(((UserBroadcastsRequest) (obj)).username)) goto _L44; else goto _L68
_L68:
        obj30 = new zu(o.zu.if.aYi, ((PsRequest) (obj)), new atm("", ((UserBroadcastsRequest) (obj)).username, Collections.unmodifiableList(convert(((Collection) (obj30))))));
        return ((zu) (obj30));
        obj30;
        return new zu(o.zu.if.aYi, ((PsRequest) (obj)), ((RetrofitError) (obj30)));
_L44:
        obj = new File(((Bundle) (obj34)).getString("e_file_dir"));
        obj30 = ((Bundle) (obj34)).getString("e_cookie");
        obj = new _cls1("image/jpeg", ((File) (obj)));
        try
        {
            obj = mService.uploadProfileImage(((String) (obj30)), ((TypedFile) (obj)));
            obj = new zu(o.zu.if.aYj, null, obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return new zu(o.zu.if.aYj, null, ((RetrofitError) (obj)));
        }
        return ((zu) (obj));
_L46:
        return updateProfileDisplayName(((Bundle) (obj34)));
_L45:
        return updateProfileDescription(((Bundle) (obj34)));
_L51:
        obj = (PlaybackMetaRequest)obj;
        try
        {
            obj30 = mService.playbackMeta(((PlaybackMetaRequest) (obj)));
            obj30 = new zu(o.zu.if.aYm, ((PsRequest) (obj)), obj30);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj30)
        {
            return new zu(o.zu.if.aYm, ((PsRequest) (obj)), ((RetrofitError) (obj30)));
        }
        return ((zu) (obj30));
_L52:
        obj = (BroadcastMetaRequest)obj;
        try
        {
            obj30 = mService.broadcastMeta(((BroadcastMetaRequest) (obj)));
            obj30 = new zu(o.zu.if.aYn, ((PsRequest) (obj)), obj30);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj30)
        {
            return new zu(o.zu.if.aYn, ((PsRequest) (obj)), ((RetrofitError) (obj30)));
        }
        return ((zu) (obj30));
        return null;
    }

    private zu getBlocked(Bundle bundle)
    {
        PsRequest psrequest = new PsRequest();
        psrequest.cookie = bundle.getString("e_cookie");
        try
        {
            bundle = mService.getBlocked(psrequest);
            bundle = new zu(o.zu.if.aYf, psrequest, bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            return new zu(o.zu.if.aYf, psrequest, bundle);
        }
        return bundle;
    }

    private zu getBroadcastShareUrl(Bundle bundle)
    {
        GetBroadcastShareUrlRequest getbroadcastshareurlrequest = new GetBroadcastShareUrlRequest();
        getbroadcastshareurlrequest.cookie = bundle.getString("e_cookie");
        getbroadcastshareurlrequest.id = bundle.getString("e_broadcast_id");
        try
        {
            FF6A._mth02CB("RTMP", "API: getting broadcast share url");
            bundle = mService.getBroadcastShareUrl(getbroadcastshareurlrequest);
            FF6A._mth02CB("RTMP", "API: getBroadcastShareUrl succeeded");
            bundle.id = getbroadcastshareurlrequest.id;
            bundle = new zu(o.zu.if.aXF, getbroadcastshareurlrequest, bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            FF6A._mth02CA("RTMP", "API: getBroadcastShareUrl failed", bundle);
            return new zu(o.zu.if.aXF, getbroadcastshareurlrequest, bundle);
        }
        return bundle;
    }

    private zu getMapBroadcastFeed(Bundle bundle)
    {
        MapGeoBroadcastFeedRequest mapgeobroadcastfeedrequest = new MapGeoBroadcastFeedRequest();
        mapgeobroadcastfeedrequest.cookie = bundle.getString("e_cookie");
        mapgeobroadcastfeedrequest.p1Lat = bundle.getFloat("e_point_1_lat");
        mapgeobroadcastfeedrequest.p1Lng = bundle.getFloat("e_point_1_lng");
        mapgeobroadcastfeedrequest.p2Lat = bundle.getFloat("e_point_2_lat");
        mapgeobroadcastfeedrequest.p2Lng = bundle.getFloat("e_point_2_lng");
        mapgeobroadcastfeedrequest.includeReplay = true;
        try
        {
            bundle = mService.mapGeoBroadcastFeed(mapgeobroadcastfeedrequest);
            bundle = new zu(o.zu.if.aXJ, mapgeobroadcastfeedrequest, convert(bundle));
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            return new zu(o.zu.if.aXJ, mapgeobroadcastfeedrequest, bundle);
        }
        return bundle;
    }

    private zu hello(Bundle bundle)
    {
        HelloRequest hellorequest = new HelloRequest();
        hellorequest.cookie = bundle.getString("e_cookie");
        hellorequest.locale = bundle.getStringArrayList("e_locale");
        try
        {
            bundle = mService.hello(hellorequest);
            bundle = new zu(o.zu.if.aXp, hellorequest, bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            return new zu(o.zu.if.aXp, hellorequest, bundle);
        }
        return bundle;
    }

    private boolean is500Error(RetrofitError retrofiterror)
    {
        if (retrofiterror.getResponse() != null)
        {
            int i = retrofiterror.getResponse().getStatus();
            return i >= 500 && i < 600;
        } else
        {
            return false;
        }
    }

    private boolean isTimeout(RetrofitError retrofiterror)
    {
        return retrofiterror.getKind() == retrofit.RetrofitError.Kind.NETWORK || retrofiterror.getCause() != null && ((retrofiterror.getCause() instanceof UnknownHostException) || (retrofiterror.getCause() instanceof ConnectException));
    }

    private TypedInput newLogFileForUpload(File afile[])
    {
        if (afile != null)
        {
            return new TypedFiles(afile, "logs.txt");
        } else
        {
            return new TypedFileString("", "logs.txt");
        }
    }

    private zu pingBroadcast(Bundle bundle)
    {
        String s = bundle.getString("e_broadcast_id");
        String s1 = bundle.getString("e_logger_name");
        return (new _cls4()).execute(s1);
    }

    private zu pingWatching(Bundle bundle)
    {
        String s = bundle.getString("e_broadcast_id");
        String s1 = bundle.getString("e_session_id");
        String s2 = bundle.getString("e_logger_name");
        return (new _cls2()).execute(s2);
    }

    private zu replayThumbnailPlaylist(Bundle bundle)
    {
        String s = bundle.getString("e_broadcast_id");
        ThumbnailPlaylistRequest thumbnailplaylistrequest = new ThumbnailPlaylistRequest();
        thumbnailplaylistrequest.cookie = bundle.getString("e_cookie");
        thumbnailplaylistrequest.broadcastId = s;
        try
        {
            bundle = mService.replayThumbnailPlayList(thumbnailplaylistrequest);
            bundle.broadcastId = s;
            bundle = new zu(o.zu.if.aXK, thumbnailplaylistrequest, bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            return new zu(o.zu.if.aXK, thumbnailplaylistrequest, bundle);
        }
        return bundle;
    }

    private zu reportBroadcast(Bundle bundle)
    {
        MarkAbuseRequest markabuserequest = new MarkAbuseRequest();
        markabuserequest.cookie = bundle.getString("e_cookie");
        markabuserequest.broadcastId = bundle.getString("e_broadcast_id");
        try
        {
            FF6A._mth02CB("RTMP", "API: reporting broadcast");
            bundle = mService.markAbuse(markabuserequest);
            FF6A._mth02CB("RTMP", "API: report Broadcast succeeded");
            bundle = new zu(o.zu.if.aXQ, markabuserequest, bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            FF6A._mth02CA("RTMP", "API: report Broadcast failed", bundle);
            return new zu(o.zu.if.aXQ, markabuserequest, bundle);
        }
        return bundle;
    }

    private zu shareBroadcast(Bundle bundle)
    {
        ShareBroadcastRequest sharebroadcastrequest = new ShareBroadcastRequest();
        sharebroadcastrequest.cookie = bundle.getString("e_cookie");
        sharebroadcastrequest.broadcastId = bundle.getString("e_broadcast_id");
        sharebroadcastrequest.userIds = bundle.getStringArrayList("e_user_ids");
        try
        {
            FF6A._mth02CB("RTMP", "API: sharing broadcast");
            bundle = mService.shareBroadcast(sharebroadcastrequest);
            FF6A._mth02CB("RTMP", "API: shareBroadcast succeeded");
            bundle = new zu(o.zu.if.aXP, sharebroadcastrequest, bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            FF6A._mth02CA("RTMP", "API: shareBroadcast failed", bundle);
            return new zu(o.zu.if.aXP, sharebroadcastrequest, bundle);
        }
        return bundle;
    }

    private zu stopWatching(Bundle bundle)
    {
        String s = bundle.getString("e_broadcast_id");
        String s1 = bundle.getString("e_session_id");
        String s2 = bundle.getString("e_logger_name");
        int i = bundle.getInt("e_num_hearts");
        int j = bundle.getInt("e_n_comments");
        float f = bundle.getFloat("e_duration");
        return (new _cls3()).execute(s2);
    }

    private zu unblock(Bundle bundle)
    {
        String s = bundle.getString("e_user_id");
        BlockRequest blockrequest = new BlockRequest();
        blockrequest.cookie = bundle.getString("e_cookie");
        blockrequest.userId = s;
        try
        {
            bundle = mService.unblock(blockrequest);
            bundle.userId = s;
            bundle = new zu(o.zu.if.aYe, blockrequest, bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            return new zu(o.zu.if.aYe, blockrequest, bundle);
        }
        return bundle;
    }

    private zu updateProfileDescription(Bundle bundle)
    {
        String s = bundle.getString("e_description");
        UpdateDescriptionRequest updatedescriptionrequest = new UpdateDescriptionRequest();
        updatedescriptionrequest.cookie = bundle.getString("e_cookie");
        updatedescriptionrequest.description = s;
        try
        {
            bundle = mService.updateDescription(updatedescriptionrequest);
            bundle = new zu(o.zu.if.aYl, updatedescriptionrequest, bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            return new zu(o.zu.if.aYl, updatedescriptionrequest, bundle);
        }
        return bundle;
    }

    private zu updateProfileDisplayName(Bundle bundle)
    {
        String s = bundle.getString("e_display_name");
        UpdateDisplayNameRequest updatedisplaynamerequest = new UpdateDisplayNameRequest();
        updatedisplaynamerequest.cookie = bundle.getString("e_cookie");
        updatedisplaynamerequest.displayName = s;
        try
        {
            bundle = mService.updateDisplayName(updatedisplaynamerequest);
            bundle = new zu(o.zu.if.aYk, updatedisplaynamerequest, bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            return new zu(o.zu.if.aYk, updatedisplaynamerequest, bundle);
        }
        return bundle;
    }

    public long getCurrentBackoff()
    {
        return mRetryBackoff;
    }

    public void run()
    {
        Process.setThreadPriority(10);
        zu zu1 = execute();
        if (zu1 != null)
        {
            boolean flag;
            if (zu1.aXl == null && zu1.mU == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag && (is500Error(zu1.aXl) || isTimeout(zu1.aXl)))
            {
                if (mNumRetries <= 0)
                {
                    mEventBus._mth1429(zu1);
                    return;
                } else
                {
                    mNumRetries = mNumRetries - 1;
                    mRetryBackoff = mRetryBackoff + mRetryInterval;
                    mEventBus._mth1429(new zy(this));
                    return;
                }
            }
        }
        if (zu1 != null)
        {
            mEventBus._mth1429(zu1);
        }
    }



    private class _cls5 extends ApiRequestWithLogs
    {

        final ApiRunnable this$0;
        final String val$broadcastId;
        final String val$cookie;

        public zu doExecute(File afile[])
        {
            try
            {
                FF6A._mth02CB("RTMP", "API: ending broadcast");
                afile = mService.endBroadcast(cookie, broadcastId, newLogFileForUpload(afile));
                FF6A._mth02CB("RTMP", "API: endBroadcast succeeded");
                afile = new zu(o.zu.if.aYa, null, afile);
            }
            // Misplaced declaration of an exception variable
            catch (File afile[])
            {
                FF6A._mth02CA("RTMP", "API: endBroadcast failed", afile);
                return new zu(o.zu.if.aYa, null, afile);
            }
            return afile;
        }

        _cls5()
        {
            this$0 = ApiRunnable.this;
            cookie = s;
            broadcastId = s1;
            super();
        }
    }


    private class _cls1 extends TypedFile
    {

        final ApiRunnable this$0;

        public String fileName()
        {
            return "image.jpeg";
        }

        _cls1(String s, File file)
        {
            this$0 = ApiRunnable.this;
            super(s, file);
        }
    }


    private class _cls4 extends ApiRequestWithLogs
    {

        final ApiRunnable this$0;
        final String val$broadcastId;
        final String val$cookie;

        public zu doExecute(File afile[])
        {
            try
            {
                FF6A._mth02CB("RTMP", "API: pinging broadcast");
                afile = mService.pingBroadcast(cookie, broadcastId, newLogFileForUpload(afile));
                FF6A._mth02CB("RTMP", "API: pingBroadcast succeeded");
                afile = new zu(o.zu.if.aYb, null, afile);
            }
            // Misplaced declaration of an exception variable
            catch (File afile[])
            {
                FF6A._mth02CA("RTMP", "API: pingBroadcast failed", afile);
                return new zu(o.zu.if.aYb, null, afile);
            }
            return afile;
        }

        _cls4()
        {
            this$0 = ApiRunnable.this;
            cookie = s;
            broadcastId = s1;
            super();
        }
    }


    private class _cls2 extends ApiRequestWithLogs
    {

        final ApiRunnable this$0;
        final String val$broadcastId;
        final String val$cookie;
        final String val$session;

        public zu doExecute(File afile[])
        {
            try
            {
                FF6A._mth02CB("RTMP", "API: ping watching");
                afile = mService.pingWatching(cookie, broadcastId, session, newLogFileForUpload(afile));
                FF6A._mth02CB("RTMP", "API: pingWatching succeeded");
                afile = new zu(o.zu.if.aXS, null, afile);
            }
            // Misplaced declaration of an exception variable
            catch (File afile[])
            {
                FF6A._mth02CA("RTMP", "API: pingWatching failed", afile);
                return new zu(o.zu.if.aXS, null, afile);
            }
            return afile;
        }

        _cls2()
        {
            this$0 = ApiRunnable.this;
            cookie = s;
            broadcastId = s1;
            session = s2;
            super();
        }
    }


    private class _cls3 extends ApiRequestWithLogs
    {

        final ApiRunnable this$0;
        final String val$broadcastId;
        final String val$cookie;
        final String val$duration;
        final String val$numComments;
        final String val$numHearts;
        final String val$session;

        public zu doExecute(File afile[])
        {
            try
            {
                FF6A._mth02CB("RTMP", "API: stop watching");
                afile = mService.stopWatching(cookie, broadcastId, session, newLogFileForUpload(afile), numHearts, numComments, duration);
                FF6A._mth02CB("RTMP", "API: stopWatching succeeded");
                afile = new zu(o.zu.if.aXT, null, afile);
            }
            // Misplaced declaration of an exception variable
            catch (File afile[])
            {
                FF6A._mth02CA("RTMP", "API: stopWatching failed", afile);
                return new zu(o.zu.if.aXT, null, afile);
            }
            return afile;
        }

        _cls3()
        {
            this$0 = ApiRunnable.this;
            cookie = s;
            broadcastId = s1;
            session = s2;
            numHearts = s3;
            numComments = s4;
            duration = s5;
            super();
        }
    }

}
