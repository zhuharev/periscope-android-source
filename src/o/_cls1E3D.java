// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.text.TextUtils;
import java.net.URL;

// Referenced classes of package o:
//            _cls1E5D

public class _cls1E3D
{

    public final String oA;
    public String oB;
    public URL oC;
    public final _cls1E5D oz;
    public final URL url;

    public _cls1E3D(String s)
    {
        this(s, ((_cls1E5D) (_cls1E5D.oD)));
    }

    private _cls1E3D(String s, _cls1E5D _pcls1e5d)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException((new StringBuilder("String url must not be empty or null: ")).append(s).toString());
        }
        if (_pcls1e5d == null)
        {
            throw new IllegalArgumentException("Headers must not be null");
        } else
        {
            oA = s;
            url = null;
            oz = _pcls1e5d;
            return;
        }
    }

    public _cls1E3D(URL url1)
    {
        this(url1, ((_cls1E5D) (_cls1E5D.oD)));
    }

    private _cls1E3D(URL url1, _cls1E5D _pcls1e5d)
    {
        if (url1 == null)
        {
            throw new IllegalArgumentException("URL must not be null!");
        }
        if (_pcls1e5d == null)
        {
            throw new IllegalArgumentException("Headers must not be null");
        } else
        {
            url = url1;
            oA = null;
            oz = _pcls1e5d;
            return;
        }
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof _cls1E3D)
        {
            _cls1E3D _lcls1e3d = (_cls1E3D)obj;
            if (oA != null)
            {
                obj = oA;
            } else
            {
                obj = url.toString();
            }
            String s;
            if (_lcls1e3d.oA != null)
            {
                s = _lcls1e3d.oA;
            } else
            {
                s = _lcls1e3d.url.toString();
            }
            return ((String) (obj)).equals(s) && oz.equals(_lcls1e3d.oz);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        String s;
        if (oA != null)
        {
            s = oA;
        } else
        {
            s = url.toString();
        }
        return s.hashCode() * 31 + oz.hashCode();
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        if (oA != null)
        {
            s = oA;
        } else
        {
            s = url.toString();
        }
        return stringbuilder.append(s).append('\n').append(oz.toString()).toString();
    }
}
