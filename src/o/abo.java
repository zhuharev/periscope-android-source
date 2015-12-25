// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import retrofit.ResponseCallback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedInput;
import tv.periscope.android.api.PsMessage;

// Referenced classes of package o:
//            FF6A, iv, it, iq, 
//            kd, abm

final class abo extends ResponseCallback
{

    private String MG;
    private PsMessage bct;

    abo(String s, PsMessage psmessage)
    {
        MG = s;
        bct = psmessage;
        super();
    }

    public final void failure(RetrofitError retrofiterror)
    {
        FF6A._mth02CA("RTMP", "PubNub failure", retrofiterror);
    }

    public final void success(Response response)
    {
        Response response1;
        Response response2;
        response2 = null;
        response1 = null;
        response = response.getBody().in();
        response1 = response;
        response2 = response;
        iq iq1 = (new iv())._mth02CA(new InputStreamReader(response));
        if (!(iq1 instanceof it))
        {
            Util.closeQuietly(response);
            return;
        }
        response1 = response;
        response2 = response;
        iq1 = (iq)iq1._mth0673().GC.get("message");
        if (iq1 == null)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        response1 = response;
        response2 = response;
        if (iq1 instanceof it)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        response1 = response;
        response2 = response;
        FF6A._mth02CA("RTMP", "PubNub SIGNER: No message");
        Util.closeQuietly(response);
        return;
        response1 = response;
        response2 = response;
        abm._mth02CA(MG, iq1._mth0673());
        response1 = response;
        response2 = response;
        abm.at();
        response1 = response;
        response2 = response;
        abm.au().add(bct.uuid);
        Util.closeQuietly(response);
        return;
        response;
        response2 = response1;
        FF6A._mth02CA("RTMP", "PubNub SIGNER", response);
        Util.closeQuietly(response1);
        return;
        response;
        Util.closeQuietly(response2);
        throw response;
    }
}
