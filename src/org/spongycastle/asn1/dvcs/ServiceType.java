// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.dvcs;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;

public class ServiceType extends ASN1Object
{

    private static ServiceType YA = new ServiceType(3);
    private static ServiceType YB = new ServiceType(4);
    private static ServiceType Yy = new ServiceType(1);
    private static ServiceType Yz = new ServiceType(2);
    private ASN1Enumerated YC;

    private ServiceType(int i)
    {
        YC = new ASN1Enumerated(i);
    }

    public String toString()
    {
        int i = (new BigInteger(YC.bytes)).intValue();
        StringBuilder stringbuilder = (new StringBuilder()).append(i);
        String s;
        if (i == (new BigInteger(Yy.YC.bytes)).intValue())
        {
            s = "(CPD)";
        } else
        if (i == (new BigInteger(Yz.YC.bytes)).intValue())
        {
            s = "(VSD)";
        } else
        if (i == (new BigInteger(YA.YC.bytes)).intValue())
        {
            s = "(VPKC)";
        } else
        if (i == (new BigInteger(YB.YC.bytes)).intValue())
        {
            s = "(CCPD)";
        } else
        {
            s = "?";
        }
        return stringbuilder.append(s).toString();
    }

    public final ASN1Primitive _mth0427()
    {
        return YC;
    }

}
