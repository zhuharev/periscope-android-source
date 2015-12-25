// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.drm;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class DrmInitData
{
    public static final class Mapped extends DrmInitData
    {

        private final Map schemeData = new HashMap();

        public final byte[] get(UUID uuid)
        {
            return (byte[])schemeData.get(uuid);
        }

        public final void put(UUID uuid, byte abyte0[])
        {
            schemeData.put(uuid, abyte0);
        }

        public Mapped(String s)
        {
            super(s);
        }
    }

    public static final class Universal extends DrmInitData
    {

        private byte data[];

        public final byte[] get(UUID uuid)
        {
            return data;
        }

        public Universal(String s, byte abyte0[])
        {
            super(s);
            data = abyte0;
        }
    }


    public final String mimeType;

    public DrmInitData(String s)
    {
        mimeType = s;
    }

    public abstract byte[] get(UUID uuid);
}
