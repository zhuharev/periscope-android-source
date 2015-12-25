// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1Integer;

public class SubsequentMessage extends ASN1Integer
{

    private SubsequentMessage(int i)
    {
        super(i);
    }

    static 
    {
        new SubsequentMessage(0);
        new SubsequentMessage(1);
    }
}
