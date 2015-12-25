// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

// Referenced classes of package o:
//            _cls1E8D

final class _cls3033 extends ByteArrayOutputStream
{

    private _cls1E8D kr;

    _cls3033(_cls1E8D _pcls1e8d, int i)
    {
        kr = _pcls1e8d;
        super(i);
    }

    public final String toString()
    {
        int i;
        if (count > 0 && buf[count - 1] == 13)
        {
            i = count - 1;
        } else
        {
            i = count;
        }
        String s;
        try
        {
            s = new String(buf, 0, i, kr.kq.name());
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new AssertionError(unsupportedencodingexception);
        }
        return s;
    }
}
