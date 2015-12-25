// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;

import org.spongycastle.crypto.DerivationParameters;

public class HKDFParameters
    implements DerivationParameters
{

    public final byte aaN[];
    public final byte aug[];
    public final byte axn[];
    public final boolean axo;
}
