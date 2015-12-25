// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.spec;

import javax.crypto.spec.PBEKeySpec;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class PBKDF2KeySpec extends PBEKeySpec
{

    public AlgorithmIdentifier aaU;

    public PBKDF2KeySpec(char ac[], byte abyte0[], int i, int j, AlgorithmIdentifier algorithmidentifier)
    {
        super(ac, abyte0, i, j);
        aaU = algorithmidentifier;
    }
}
