// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package o:
//            FF83, _cls0501, _cls1E3D, _cls1E5D

public final class _cls0135
    implements FF83
{
    /* member class not found */
    class if {}


    private static final if mc = new if((byte)0);
    private final _cls1E3D md;
    private final if me;
    private HttpURLConnection mf;
    private volatile boolean mg;
    private InputStream stream;

    public _cls0135(_cls1E3D _pcls1e3d)
    {
        this(_pcls1e3d, mc);
    }

    private _cls0135(_cls1E3D _pcls1e3d, if if1)
    {
        md = _pcls1e3d;
        me = if1;
    }

    private InputStream _mth02CA(URL url, int i, URL url1, Map map)
    {
        do
        {
            if (i >= 5)
            {
                throw new IOException("Too many (> 5) redirects!");
            }
            int j;
            if (url1 != null)
            {
                try
                {
                    if (url.toURI().equals(url1.toURI()))
                    {
                        throw new IOException("In re-direct loop");
                    }
                }
                // Misplaced declaration of an exception variable
                catch (URL url1) { }
            }
            mf = me._mth02CA(url);
            java.util.Map.Entry entry;
            for (url1 = map.entrySet().iterator(); url1.hasNext(); mf.addRequestProperty((String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)url1.next();
            }

            if (TextUtils.isEmpty(mf.getRequestProperty("Accept-Encoding")))
            {
                mf.setRequestProperty("Accept-Encoding", "identity");
            }
            mf.setConnectTimeout(2500);
            mf.setReadTimeout(2500);
            mf.setUseCaches(false);
            mf.setDoInput(true);
            mf.connect();
            if (mg)
            {
                return null;
            }
            j = mf.getResponseCode();
            if (j / 100 == 2)
            {
                url = mf;
                if (TextUtils.isEmpty(url.getContentEncoding()))
                {
                    i = url.getContentLength();
                    stream = new _cls0501(url.getInputStream(), i);
                } else
                {
                    if (Log.isLoggable("HttpUrlFetcher", 3))
                    {
                        Log.d("HttpUrlFetcher", (new StringBuilder("Got non empty content encoding: ")).append(url.getContentEncoding()).toString());
                    }
                    stream = url.getInputStream();
                }
                return stream;
            }
            if (j / 100 == 3)
            {
                url1 = mf.getHeaderField("Location");
                if (TextUtils.isEmpty(url1))
                {
                    throw new IOException("Received empty or null redirect url");
                }
                URL url2 = new URL(url, url1);
                i++;
                url1 = url;
                url = url2;
            } else
            if (j == -1)
            {
                throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
            } else
            {
                throw new IOException((new StringBuilder("Request failed ")).append(j).append(": ").append(mf.getResponseMessage()).toString());
            }
        } while (true);
    }

    public final void cancel()
    {
        mg = true;
    }

    public final String getId()
    {
        _cls1E3D _lcls1e3d = md;
        if (_lcls1e3d.oA != null)
        {
            return _lcls1e3d.oA;
        } else
        {
            return _lcls1e3d.url.toString();
        }
    }

    public final Object _mth1424(int i)
    {
        _cls1E3D _lcls1e3d = md;
        if (_lcls1e3d.oC == null)
        {
            if (TextUtils.isEmpty(_lcls1e3d.oB))
            {
                String s1 = _lcls1e3d.oA;
                String s = s1;
                if (TextUtils.isEmpty(s1))
                {
                    s = _lcls1e3d.url.toString();
                }
                _lcls1e3d.oB = Uri.encode(s, "@#&=*+-_.,:!?()/~'%");
            }
            _lcls1e3d.oC = new URL(_lcls1e3d.oB);
        }
        return _mth02CA(_lcls1e3d.oC, 0, null, md.oz.getHeaders());
    }

    public final void _mth14F4()
    {
        if (stream != null)
        {
            try
            {
                stream.close();
            }
            catch (IOException ioexception) { }
        }
        if (mf != null)
        {
            mf.disconnect();
        }
    }

}
