// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;

// Referenced classes of package org.spongycastle.asn1.x509:
//            GeneralName

public class Target extends ASN1Object
    implements ASN1Choice
{

    public GeneralName ajT;
    public GeneralName ajU;

    private Target(ASN1TaggedObject asn1taggedobject)
    {
        switch (asn1taggedobject.Wk)
        {
        case 0: // '\0'
            ajT = GeneralName._mth02CE(asn1taggedobject);
            return;

        case 1: // '\001'
            ajU = GeneralName._mth02CE(asn1taggedobject);
            return;
        }
        throw new IllegalArgumentException((new StringBuilder("unknown tag: ")).append(asn1taggedobject.Wk).toString());
    }

    public static Target _mth14A1(Object obj)
    {
        if (obj == null || (obj instanceof Target))
        {
            return (Target)obj;
        }
        if (obj instanceof ASN1TaggedObject)
        {
            return new Target((ASN1TaggedObject)obj);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("unknown object in factory: ")).append(obj.getClass()).toString());
        }
    }

    public final ASN1Primitive _mth0427()
    {
        if (ajT != null)
        {
            return new DERTaggedObject(true, 0, ajT);
        } else
        {
            return new DERTaggedObject(true, 1, ajU);
        }
    }
}
