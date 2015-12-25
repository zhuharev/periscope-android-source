// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            DES

public static class t> extends t>
{

    public I()
    {
        super("PBEwithMD5andDES", PKCSObjectIdentifiers.abp, true, 0, 0, 64, 64);
    }
}
