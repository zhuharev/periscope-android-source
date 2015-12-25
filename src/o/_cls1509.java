// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.util.Log;
import java.io.Writer;

public final class _cls1509 extends Writer
{

    private StringBuilder mBuilder;
    private final String mTag;

    public _cls1509(String s)
    {
        mBuilder = new StringBuilder(128);
        mTag = s;
    }

    private void _mth144A()
    {
        if (mBuilder.length() > 0)
        {
            Log.d(mTag, mBuilder.toString());
            mBuilder.delete(0, mBuilder.length());
        }
    }

    public final void close()
    {
        _mth144A();
    }

    public final void flush()
    {
        _mth144A();
    }

    public final void write(char ac[], int i, int j)
    {
        for (int k = 0; k < j; k++)
        {
            char c = ac[i + k];
            if (c == '\n')
            {
                _mth144A();
            } else
            {
                mBuilder.append(c);
            }
        }

    }
}
