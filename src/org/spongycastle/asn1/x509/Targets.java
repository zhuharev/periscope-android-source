// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;

// Referenced classes of package org.spongycastle.asn1.x509:
//            Target

public class Targets extends ASN1Object
{

    private ASN1Sequence ajV;

    private Targets(ASN1Sequence asn1sequence)
    {
        ajV = asn1sequence;
    }

    public static Targets _mth14A2(Object obj)
    {
        if (obj instanceof Targets)
        {
            return (Targets)obj;
        }
        if (obj != null)
        {
            return new Targets(ASN1Sequence._mth141F(obj));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        return ajV;
    }

    public final Target[] _mth1434()
    {
        Target atarget[] = new Target[ajV.size()];
        int i = 0;
        for (Enumeration enumeration = ajV._mth0675(); enumeration.hasMoreElements();)
        {
            int j = i + 1;
            atarget[i] = Target._mth14A1(enumeration.nextElement());
            i = j;
        }

        return atarget;
    }
}
