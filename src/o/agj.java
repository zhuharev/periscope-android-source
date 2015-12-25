// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.res.Resources;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.services.MediaService;
import com.twitter.sdk.android.core.services.StatusesService;
import java.io.File;
import retrofit.mime.TypedFile;

// Referenced classes of package o:
//            agi, agk

public final class agj
    implements agi
{

    private final TwitterApiClient bjJ;
    private final Resources _fld13AB;

    public agj(Resources resources, TwitterApiClient twitterapiclient)
    {
        _fld13AB = resources;
        bjJ = twitterapiclient;
    }

    private String _mth02CA(int i, int j, String s, String s1)
    {
        if (TextUtils.isEmpty(s))
        {
            if (i > 0)
            {
                s = _fld13AB.getString(i);
            } else
            {
                s = "";
            }
        } else
        {
            String s2;
            if (j > 0)
            {
                s2 = _fld13AB.getString(j, new Object[] {
                    s
                });
            } else
            {
                s2 = s;
            }
            s = s2;
            if (s2.length() > 116)
            {
                s = _fld13AB.getString(0x7f0600c7);
                i = s.length();
                s = (new StringBuilder()).append(s2.substring(0, 116 - i)).append(s).toString();
            }
        }
        return (new StringBuilder()).append(s).append(" ").append(s1).toString();
    }

    public final void _mth02CA(int i, int j, String s, String s1, String s2, Callback callback)
    {
        if (s2 != null)
        {
            MediaService mediaservice = bjJ.getMediaService();
            s2 = new File(s2);
            mediaservice.upload(new TypedFile(MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(s2.getName())), s2), null, null, new agk(this, i, j, s, s1, callback));
            return;
        } else
        {
            _mth02CB(i, j, s, s1, s2, callback);
            return;
        }
    }

    void _mth02CB(int i, int j, String s, String s1, String s2, Callback callback)
    {
        bjJ.getStatusesService().update(_mth02CA(i, j, s, s1), null, null, null, null, null, null, null, s2, callback);
    }
}
