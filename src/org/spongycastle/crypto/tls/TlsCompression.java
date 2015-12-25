// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public interface TlsCompression
{

    public abstract OutputStream _mth02CE(ByteArrayOutputStream bytearrayoutputstream);

    public abstract OutputStream _mth02CF(ByteArrayOutputStream bytearrayoutputstream);
}
