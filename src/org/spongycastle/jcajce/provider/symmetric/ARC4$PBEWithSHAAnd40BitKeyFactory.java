// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            ARC4

public static class  extends PBESecretKeyFactory
{

    public ()
    {
        super("PBEWithSHAAnd128BitRC4", PKCSObjectIdentifiers.acO, true, 2, 1, 40, 0);
    }
}
