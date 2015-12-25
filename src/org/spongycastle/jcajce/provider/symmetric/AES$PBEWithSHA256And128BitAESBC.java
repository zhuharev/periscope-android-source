// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            AES

public static class  extends PBESecretKeyFactory
{

    public ()
    {
        super("PBEWithSHA256And128BitAES-CBC-BC", null, true, 2, 4, 128, 128);
    }
}
