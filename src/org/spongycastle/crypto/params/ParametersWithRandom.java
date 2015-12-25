// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;

import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;

public class ParametersWithRandom
    implements CipherParameters
{

    public SecureRandom amC;
    public CipherParameters axC;

    public ParametersWithRandom(CipherParameters cipherparameters, SecureRandom securerandom)
    {
        amC = securerandom;
        axC = cipherparameters;
    }
}
