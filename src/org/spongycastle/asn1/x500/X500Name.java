// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x500;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x500.style.BCStyle;

// Referenced classes of package org.spongycastle.asn1.x500:
//            RDN, X500NameStyle

public class X500Name extends ASN1Object
    implements ASN1Choice
{

    private static X500NameStyle age;
    private boolean agf;
    private int agg;
    private X500NameStyle agh;
    public RDN agi[];

    private X500Name(ASN1Sequence asn1sequence)
    {
        this(age, asn1sequence);
    }

    private X500Name(X500NameStyle x500namestyle, ASN1Sequence asn1sequence)
    {
        agh = x500namestyle;
        agi = new RDN[asn1sequence.size()];
        int i = 0;
        for (x500namestyle = asn1sequence._mth0675(); x500namestyle.hasMoreElements();)
        {
            asn1sequence = agi;
            int j = i + 1;
            asn1sequence[i] = RDN.FF9F(x500namestyle.nextElement());
            i = j;
        }

    }

    public static X500Name _mth0131(Object obj)
    {
        if (obj instanceof X500Name)
        {
            return (X500Name)obj;
        }
        if (obj != null)
        {
            return new X500Name(ASN1Sequence._mth141F(obj));
        } else
        {
            return null;
        }
    }

    public static X500Name _mth02CA(ASN1TaggedObject asn1taggedobject)
    {
        asn1taggedobject = ASN1Sequence._mth141D(asn1taggedobject, true);
        if (asn1taggedobject instanceof X500Name)
        {
            return (X500Name)asn1taggedobject;
        }
        if (asn1taggedobject != null)
        {
            return new X500Name(ASN1Sequence._mth141F(asn1taggedobject));
        } else
        {
            return null;
        }
    }

    public static X500Name _mth02CA(X500NameStyle x500namestyle, ASN1Encodable asn1encodable)
    {
        for (; asn1encodable instanceof X500Name; asn1encodable = ((X500Name)asn1encodable)._mth0427()) { }
        if (asn1encodable != null)
        {
            return new X500Name(x500namestyle, ASN1Sequence._mth141F(asn1encodable));
        } else
        {
            return null;
        }
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof X500Name) && !(obj instanceof ASN1Sequence))
        {
            return false;
        }
        ASN1Primitive asn1primitive = ((ASN1Encodable)obj)._mth0427();
        if (_mth0427().equals(asn1primitive))
        {
            return true;
        }
        boolean flag;
        try
        {
            flag = agh._mth02CA(this, new X500Name(ASN1Sequence._mth141F(((ASN1Encodable)obj)._mth0427())));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        return flag;
    }

    public int hashCode()
    {
        if (agf)
        {
            return agg;
        } else
        {
            agf = true;
            agg = agh._mth02CA(this);
            return agg;
        }
    }

    public String toString()
    {
        return agh._mth02CB(this);
    }

    public final ASN1Primitive _mth0427()
    {
        return new DERSequence(agi);
    }

    static 
    {
        age = BCStyle.agU;
    }
}
