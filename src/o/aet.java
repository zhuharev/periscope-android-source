// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;

// Referenced classes of package o:
//            FF6A

final class aet
    implements Runnable
{

    private aed._cls02CB bhN;

    aet(aed._cls02CB _pcls02cb)
    {
        bhN = _pcls02cb;
        super();
    }

    public final void run()
    {
        Object obj = (new com.squareup.okhttp.Request.Builder()).method("PUT", RequestBody.create(MediaType.parse("image/jpeg"), bhN.bhM)).url(bhN.uploadUrl).build();
        OkHttpClient okhttpclient = new OkHttpClient();
        try
        {
            obj = okhttpclient.newCall(((com.squareup.okhttp.Request) (obj))).execute();
            if (!((Response) (obj)).isSuccessful())
            {
                FF6A._mth02CA("RTMP", (new StringBuilder("thumb upload failed ")).append(((Response) (obj)).code()).toString());
            }
        }
        catch (IOException ioexception)
        {
            FF6A._mth02CA("RTMP", "thumbnail upload", ioexception);
        }
        bhN.uploadUrl = null;
        bhN.bhM = null;
    }
}
