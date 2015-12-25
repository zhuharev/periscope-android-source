// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;

import java.util.List;
import retrofit.mime.TypedFile;
import retrofit.mime.TypedInput;

// Referenced classes of package tv.periscope.android.api:
//            AccessChannelRequest, AccessChannelResponse, AdjustBroadcastRankRequest, AdjustBroadcastRankResponse, 
//            BlockRequest, BlockResponse, BroadcastMetaRequest, BroadcastMetaResponse, 
//            BroadcastSummaryRequest, BroadcastSummaryResponse, DeleteBroadcastRequest, PsResponse, 
//            DeleteReplayRequest, DeleteReplayResponse, EndBroadcastResponse, EndReplayViewedRequest, 
//            EndReplayViewedResponse, MainBroadcastFeaturedRequest, FollowRequest, FollowResponse, 
//            MainBroadcastFollowingRequest, PsRequest, BroadcastIdForTokenRequest, BroadcastResponse, 
//            BroadcastRankRequest, BroadcastRankResponse, GetBroadcastShareUrlRequest, GetBroadcastShareUrlResponse, 
//            GetBroadcastViewersRequest, GetBroadcastViewersResponse, GetBroadcastRequest, GetBroadcastRankParametersRequest, 
//            GetBroadcastRankParametersResponse, GetFollowersRequest, GetFollowingRequest, GetSettingsRequest, 
//            GetSettingsResponse, GetUserRequest, GetUserResponse, HelloRequest, 
//            HelloResponse, LoginRequest, LoginResponse, TwitterLoginRequest, 
//            TwitterLoginResponse, MapGeoBroadcastFeedRequest, MarkAbuseRequest, MarkAbuseResponse, 
//            MuteRequest, MuteResponse, PingBroadcastResponse, PingWatchingResponse, 
//            PlaybackMetaRequest, PlaybackMetaResponse, PublishBroadcastRequest, PublishBroadcastResponse, 
//            RankedBroadcastsRequest, ThumbnailPlaylistRequest, ThumbnailPlaylistResponse, ReplayViewedRequest, 
//            ReplayViewedResponse, SetBroadcastRankParametersRequest, SetBroadcastRankParametersResponse, SetSettingsRequest, 
//            SetSettingsResponse, ShareBroadcastRequest, ShareBroadcastResponse, CreateBroadcastRequest, 
//            CreateBroadcastResponse, StopWatchingResponse, SuggestedPeopleRequest, SuggestedPeopleResponse, 
//            UnfollowRequest, UnfollowResponse, UnMuteRequest, UnMuteResponse, 
//            UpdateDescriptionRequest, UpdateDescriptionResponse, UpdateDisplayNameRequest, UpdateDisplayNameResponse, 
//            UploadProfileImageResponse, UserBroadcastsRequest, UserSearchRequest, ValidateUsernameRequest, 
//            ValidateUsernameResponse, VerifyUsernameRequest, VerifyUsernameResponse

public interface ApiService
{

    public abstract AccessChannelResponse accessChannel(AccessChannelRequest accesschannelrequest);

    public abstract AdjustBroadcastRankResponse adjustBroadcastRank(AdjustBroadcastRankRequest adjustbroadcastrankrequest);

    public abstract BlockResponse block(BlockRequest blockrequest);

    public abstract BroadcastMetaResponse broadcastMeta(BroadcastMetaRequest broadcastmetarequest);

    public abstract BroadcastSummaryResponse broadcastSummary(BroadcastSummaryRequest broadcastsummaryrequest);

    public abstract PsResponse deleteBroadcast(DeleteBroadcastRequest deletebroadcastrequest);

    public abstract DeleteReplayResponse deleteReplay(DeleteReplayRequest deletereplayrequest);

    public abstract EndBroadcastResponse endBroadcast(String s, String s1, TypedInput typedinput);

    public abstract EndReplayViewedResponse endReplayViewed(EndReplayViewedRequest endreplayviewedrequest);

    public abstract List featuredBroadcastFeed(MainBroadcastFeaturedRequest mainbroadcastfeaturedrequest);

    public abstract FollowResponse follow(FollowRequest followrequest);

    public abstract List followingBroadcastFeed(MainBroadcastFollowingRequest mainbroadcastfollowingrequest);

    public abstract List getBlocked(PsRequest psrequest);

    public abstract BroadcastResponse getBroadcastIdForShareToken(BroadcastIdForTokenRequest broadcastidfortokenrequest);

    public abstract BroadcastRankResponse getBroadcastRank(BroadcastRankRequest broadcastrankrequest);

    public abstract GetBroadcastShareUrlResponse getBroadcastShareUrl(GetBroadcastShareUrlRequest getbroadcastshareurlrequest);

    public abstract GetBroadcastViewersResponse getBroadcastViewers(GetBroadcastViewersRequest getbroadcastviewersrequest);

    public abstract List getBroadcasts(GetBroadcastRequest getbroadcastrequest);

    public abstract GetBroadcastRankParametersResponse getBroadcastsRankParameters(GetBroadcastRankParametersRequest getbroadcastrankparametersrequest);

    public abstract List getFollowers(GetFollowersRequest getfollowersrequest);

    public abstract List getFollowing(GetFollowingRequest getfollowingrequest);

    public abstract List getMutualFollows(PsRequest psrequest);

    public abstract GetSettingsResponse getSettings(GetSettingsRequest getsettingsrequest);

    public abstract GetUserResponse getUser(GetUserRequest getuserrequest);

    public abstract HelloResponse hello(HelloRequest hellorequest);

    public abstract LoginResponse login(LoginRequest loginrequest);

    public abstract TwitterLoginResponse login(TwitterLoginRequest twitterloginrequest);

    public abstract List mapGeoBroadcastFeed(MapGeoBroadcastFeedRequest mapgeobroadcastfeedrequest);

    public abstract MarkAbuseResponse markAbuse(MarkAbuseRequest markabuserequest);

    public abstract MuteResponse mute(MuteRequest muterequest);

    public abstract PingBroadcastResponse pingBroadcast(String s, String s1, TypedInput typedinput);

    public abstract PingWatchingResponse pingWatching(String s, String s1, String s2, TypedInput typedinput);

    public abstract PlaybackMetaResponse playbackMeta(PlaybackMetaRequest playbackmetarequest);

    public abstract PublishBroadcastResponse publishBroadcast(PublishBroadcastRequest publishbroadcastrequest);

    public abstract List rankedBroadcastFeed(RankedBroadcastsRequest rankedbroadcastsrequest);

    public abstract ThumbnailPlaylistResponse replayThumbnailPlayList(ThumbnailPlaylistRequest thumbnailplaylistrequest);

    public abstract ReplayViewedResponse replayViewed(ReplayViewedRequest replayviewedrequest);

    public abstract SetBroadcastRankParametersResponse setBroadcastsRankParameters(SetBroadcastRankParametersRequest setbroadcastrankparametersrequest);

    public abstract SetSettingsResponse setSettings(SetSettingsRequest setsettingsrequest);

    public abstract ShareBroadcastResponse shareBroadcast(ShareBroadcastRequest sharebroadcastrequest);

    public abstract CreateBroadcastResponse startBroadcast(CreateBroadcastRequest createbroadcastrequest);

    public abstract StopWatchingResponse stopWatching(String s, String s1, String s2, TypedInput typedinput, String s3, String s4, String s5);

    public abstract SuggestedPeopleResponse suggestedPeople(SuggestedPeopleRequest suggestedpeoplerequest);

    public abstract String[] supportedLanguages(String s);

    public abstract PsResponse unban(PsRequest psrequest);

    public abstract BlockResponse unblock(BlockRequest blockrequest);

    public abstract UnfollowResponse unfollow(UnfollowRequest unfollowrequest);

    public abstract UnMuteResponse unmute(UnMuteRequest unmuterequest);

    public abstract UpdateDescriptionResponse updateDescription(UpdateDescriptionRequest updatedescriptionrequest);

    public abstract UpdateDisplayNameResponse updateDisplayName(UpdateDisplayNameRequest updatedisplaynamerequest);

    public abstract UploadProfileImageResponse uploadProfileImage(String s, TypedFile typedfile);

    public abstract List userBroadcasts(UserBroadcastsRequest userbroadcastsrequest);

    public abstract List userSearch(UserSearchRequest usersearchrequest);

    public abstract ValidateUsernameResponse validateUsername(ValidateUsernameRequest validateusernamerequest);

    public abstract VerifyUsernameResponse verifyUsername(VerifyUsernameRequest verifyusernamerequest);
}
