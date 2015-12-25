// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;

import java.security.SecureRandom;

public class DSAParameterGenerationParameters
{

    public final int afM;
    public final SecureRandom amC;
    public final int atV;
    public final int aua;
    public final int axg;

    public DSAParameterGenerationParameters(int i, int j, int k, SecureRandom securerandom)
    {
        this(i, j, 80, securerandom, -1);
    }

    private DSAParameterGenerationParameters(int i, int j, int k, SecureRandom securerandom, int l)
    {
        afM = i;
        axg = j;
        atV = k;
        aua = -1;
        amC = securerandom;
    }
}
