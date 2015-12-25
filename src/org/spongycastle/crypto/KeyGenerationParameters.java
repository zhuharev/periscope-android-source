// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto;

import java.security.SecureRandom;

public class KeyGenerationParameters
{

    public SecureRandom amC;
    public int amD;

    public KeyGenerationParameters(SecureRandom securerandom, int i)
    {
        amC = securerandom;
        amD = i;
    }
}
