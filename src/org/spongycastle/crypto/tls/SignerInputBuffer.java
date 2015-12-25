// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import org.spongycastle.crypto.Signer;

public class SignerInputBuffer extends ByteArrayOutputStream
{

    SignerInputBuffer()
    {
    }

    final void _mth02CA(Signer signer)
    {
        signer.update(buf, 0, count);
    }
}
