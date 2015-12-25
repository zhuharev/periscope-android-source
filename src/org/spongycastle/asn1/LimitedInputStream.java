// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.InputStream;

// Referenced classes of package org.spongycastle.asn1:
//            IndefiniteLengthInputStream

abstract class LimitedInputStream extends InputStream
{

    protected final InputStream Wi;
    private int Wj;

    LimitedInputStream(InputStream inputstream, int i)
    {
        Wi = inputstream;
        Wj = i;
    }

    int getRemaining()
    {
        return Wj;
    }

    protected final void _mth05D5(boolean flag)
    {
        if (Wi instanceof IndefiniteLengthInputStream)
        {
            IndefiniteLengthInputStream indefinitelengthinputstream = (IndefiniteLengthInputStream)Wi;
            indefinitelengthinputstream.WW = true;
            indefinitelengthinputstream._mth06CA();
        }
    }
}
