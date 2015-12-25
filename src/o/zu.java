// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.IOException;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedInput;
import tv.periscope.android.api.ErrorResponse;
import tv.periscope.android.api.PsRequest;
import tv.periscope.android.api.ValidateUsernameRequest;

public final class zu
{
    public static final class if extends Enum
    {

        public static final if aXA;
        public static final if aXB;
        public static final if aXC;
        public static final if aXD;
        public static final if aXE;
        public static final if aXF;
        public static final if aXG;
        public static final if aXH;
        public static final if aXI;
        public static final if aXJ;
        public static final if aXK;
        public static final if aXL;
        public static final if aXM;
        public static final if aXN;
        public static final if aXO;
        public static final if aXP;
        public static final if aXQ;
        public static final if aXR;
        public static final if aXS;
        public static final if aXT;
        public static final if aXU;
        public static final if aXV;
        public static final if aXW;
        public static final if aXX;
        public static final if aXY;
        public static final if aXZ;
        public static final if aXm;
        public static final if aXn;
        public static final if aXo;
        public static final if aXp;
        public static final if aXq;
        public static final if aXr;
        public static final if aXs;
        public static final if aXt;
        public static final if aXu;
        public static final if aXv;
        public static final if aXw;
        public static final if aXx;
        public static final if aXy;
        public static final if aXz;
        public static final if aYa;
        public static final if aYb;
        public static final if aYc;
        public static final if aYd;
        public static final if aYe;
        public static final if aYf;
        public static final if aYg;
        public static final if aYh;
        public static final if aYi;
        public static final if aYj;
        public static final if aYk;
        public static final if aYl;
        public static final if aYm;
        public static final if aYn;
        private static final if aYo[];

        public static if valueOf(String s)
        {
            return (if)Enum.valueOf(o/zu$if, s);
        }

        public static if[] values()
        {
            return (if[])aYo.clone();
        }

        static 
        {
            aXm = new if("OnTwitterLoginComplete", 0);
            aXn = new if("OnValidateUsernameComplete", 1);
            aXo = new if("OnVerifyUsernameComplete", 2);
            aXp = new if("OnHelloComplete", 3);
            aXq = new if("OnGetUserComplete", 4);
            aXr = new if("OnGetFollowersComplete", 5);
            aXs = new if("OnGetFollowingComplete", 6);
            aXt = new if("OnGetMutualFollowsComplete", 7);
            aXu = new if("OnFollowComplete", 8);
            aXv = new if("OnMuteComplete", 9);
            aXw = new if("OnUnMuteComplete", 10);
            aXx = new if("OnUnfollowComplete", 11);
            aXy = new if("OnUnbanComplete", 12);
            aXz = new if("OnAccessChannelComplete", 13);
            aXA = new if("OnSuggestedUsersComplete", 14);
            aXB = new if("OnUserSearchComplete", 15);
            aXC = new if("OnMainFeaturedComplete", 16);
            aXD = new if("OnMainFollowingComplete", 17);
            aXE = new if("OnGetBroadcastsComplete", 18);
            aXF = new if("OnGetBroadcastShareUrlComplete", 19);
            aXG = new if("OnGetBroadcastViewersComplete", 20);
            aXH = new if("OnFollowAllComplete", 21);
            aXI = new if("OnGetGlobalBroadcastComplete", 22);
            aXJ = new if("OnGetGlobalMapComplete", 23);
            aXK = new if("OnReplayThumbnailPlaylistComplete", 24);
            aXL = new if("OnDeleteReplayComplete", 25);
            aXM = new if("OnCreateBroadcastComplete", 26);
            aXN = new if("OnPublishBroadcastComplete", 27);
            aXO = new if("OnDeleteBroadcastComplete", 28);
            aXP = new if("OnShareBroadcastComplete", 29);
            aXQ = new if("OnReportBroadcastComplete", 30);
            aXR = new if("OnAdjustBroadcastRankComplete", 31);
            aXS = new if("OnPingWatchingComplete", 32);
            aXT = new if("OnStopWatchingComplete", 33);
            aXU = new if("OnGetSettingsComplete", 34);
            aXV = new if("OnGetBroadcastRankComplete", 35);
            aXW = new if("OnGetBroadcastRankParametersComplete", 36);
            aXX = new if("OnSetBroadcastRankParametersComplete", 37);
            aXY = new if("OnSupportedLanguagesComplete", 38);
            aXZ = new if("OnSetSettingsComplete", 39);
            aYa = new if("OnEndBroadcastComplete", 40);
            aYb = new if("OnPingBroadcastComplete", 41);
            aYc = new if("OnBroadcastSummaryComplete", 42);
            aYd = new if("OnBlockComplete", 43);
            aYe = new if("OnUnblockComplete", 44);
            aYf = new if("OnGetBlockedComplete", 45);
            aYg = new if("OnGetBroadcastIdForTokenComplete", 46);
            aYh = new if("OnUploadTestComplete", 47);
            aYi = new if("OnGetUserBroadcastsComplete", 48);
            aYj = new if("OnUploadProfilePictureComplete", 49);
            aYk = new if("OnUpdateProfileDisplayNameComplete", 50);
            aYl = new if("OnUpdateProfileDescriptionComplete", 51);
            aYm = new if("OnPlayerMetaComplete", 52);
            aYn = new if("OnBroadcastMetaComplete", 53);
            aYo = (new if[] {
                aXm, aXn, aXo, aXp, aXq, aXr, aXs, aXt, aXu, aXv, 
                aXw, aXx, aXy, aXz, aXA, aXB, aXC, aXD, aXE, aXF, 
                aXG, aXH, aXI, aXJ, aXK, aXL, aXM, aXN, aXO, aXP, 
                aXQ, aXR, aXS, aXT, aXU, aXV, aXW, aXX, aXY, aXZ, 
                aYa, aYb, aYc, aYd, aYe, aYf, aYg, aYh, aYi, aYj, 
                aYk, aYl, aYm, aYn
            });
        }

        private if(String s, int i)
        {
            super(s, i);
        }
    }


    public if aXk;
    public RetrofitError aXl;
    public Object data;
    public Exception mU;
    public final PsRequest request;

    public zu(if if1, PsRequest psrequest, IOException ioexception)
    {
        aXk = if1;
        request = null;
        mU = ioexception;
    }

    public zu(if if1, PsRequest psrequest, Object obj)
    {
        aXk = if1;
        request = psrequest;
        data = obj;
    }

    public zu(if if1, PsRequest psrequest, RetrofitError retrofiterror)
    {
        aXk = if1;
        request = psrequest;
        aXl = retrofiterror;
    }

    public zu(if if1, ValidateUsernameRequest validateusernamerequest, RetrofitError retrofiterror, Object obj)
    {
        aXk = if1;
        request = validateusernamerequest;
        aXl = retrofiterror;
        data = obj;
    }

    public final ErrorResponse I()
    {
        if (aXl == null || aXl.getResponse() == null || aXl.getResponse().getBody() == null || !"application/json".equals(aXl.getResponse().getBody().mimeType()))
        {
            break MISSING_BLOCK_LABEL_77;
        }
        ErrorResponse errorresponse;
        tv.periscope.android.api.ErrorResponseItem errorresponseitem;
        errorresponse = (ErrorResponse)aXl.getBodyAs(tv/periscope/android/api/ErrorResponse);
        errorresponseitem = errorresponse.error;
        if (errorresponseitem != null)
        {
            return errorresponse;
        }
_L2:
        return null;
        RuntimeException runtimeexception;
        runtimeexception;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
