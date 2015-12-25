// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.InputStream;

// Referenced classes of package o:
//            uk

public final class FF5A
    implements uk
{

    private final _cls1427.if um;

    public FF5A(_cls1427.if if1)
    {
        um = if1;
    }

    public final String getKeyStorePassword()
    {
        return um.getKeyStorePassword();
    }

    public final InputStream getKeyStoreStream()
    {
        return um.getKeyStoreStream();
    }

    public final long getPinCreationTimeInMillis()
    {
        return -1L;
    }

    public final String[] getPins()
    {
        return um.getPins();
    }
}
