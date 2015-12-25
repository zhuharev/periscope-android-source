// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import org.spongycastle.asn1.x509.ReasonFlags;

class ReasonsMask
{

    static final ReasonsMask aId = new ReasonsMask(33023);
    int aIc;

    ReasonsMask()
    {
        this(0);
    }

    ReasonsMask(int i)
    {
        aIc = i;
    }

    ReasonsMask(ReasonFlags reasonflags)
    {
        aIc = reasonflags.intValue();
    }

}
