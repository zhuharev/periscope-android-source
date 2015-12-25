// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.io.IOException;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x500.X500Name;

// Referenced classes of package org.spongycastle.asn1.x509:
//            X509Name

public class GeneralName extends ASN1Object
    implements ASN1Choice
{

    public ASN1Encodable Wn;
    public int tag;

    public GeneralName(int i, String s)
    {
        tag = 1;
        Wn = new DERIA5String(s);
    }

    public GeneralName(int i, ASN1Object asn1object)
    {
        Wn = asn1object;
        tag = i;
    }

    public GeneralName(X500Name x500name)
    {
        Wn = x500name;
        tag = 4;
    }

    public GeneralName(X509Name x509name)
    {
        Wn = X500Name._mth0131(x509name);
        tag = 4;
    }

    public static GeneralName _mth02CE(ASN1TaggedObject asn1taggedobject)
    {
        return _mth02E3(ASN1TaggedObject._mth02BC(asn1taggedobject, true));
    }

    public static GeneralName _mth02E3(Object obj)
    {
        if (obj == null || (obj instanceof GeneralName))
        {
            return (GeneralName)obj;
        }
        if (obj instanceof ASN1TaggedObject)
        {
            ASN1TaggedObject asn1taggedobject = (ASN1TaggedObject)obj;
            int i = asn1taggedobject.Wk;
            switch (i)
            {
            case 0: // '\0'
                return new GeneralName(i, ASN1Sequence._mth141D(asn1taggedobject, false));

            case 1: // '\001'
                return new GeneralName(i, DERIA5String._mth037A(asn1taggedobject, false));

            case 2: // '\002'
                return new GeneralName(i, DERIA5String._mth037A(asn1taggedobject, false));

            case 3: // '\003'
                throw new IllegalArgumentException((new StringBuilder("unknown tag: ")).append(i).toString());

            case 4: // '\004'
                return new GeneralName(i, X500Name._mth02CA(asn1taggedobject));

            case 5: // '\005'
                return new GeneralName(i, ASN1Sequence._mth141D(asn1taggedobject, false));

            case 6: // '\006'
                return new GeneralName(i, DERIA5String._mth037A(asn1taggedobject, false));

            case 7: // '\007'
                return new GeneralName(i, ASN1OctetString._mth02CF(asn1taggedobject, false));

            case 8: // '\b'
                return new GeneralName(i, ASN1ObjectIdentifier._mth02CE(asn1taggedobject, false));
            }
        }
        if (obj instanceof byte[])
        {
            try
            {
                obj = _mth02E3(ASN1Primitive._mth0640((byte[])obj));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new IllegalArgumentException("unable to parse encoded general name");
            }
            return ((GeneralName) (obj));
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("unknown object in getInstance: ")).append(obj.getClass().getName()).toString());
        }
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(tag);
        stringbuffer.append(": ");
        switch (tag)
        {
        case 1: // '\001'
        case 2: // '\002'
        case 6: // '\006'
            stringbuffer.append(DERIA5String._mth02BB(Wn).getString());
            break;

        case 4: // '\004'
            stringbuffer.append(X500Name._mth0131(Wn).toString());
            break;

        case 3: // '\003'
        case 5: // '\005'
        default:
            stringbuffer.append(Wn.toString());
            break;
        }
        return stringbuffer.toString();
    }

    public final ASN1Primitive _mth0427()
    {
        if (tag == 4)
        {
            return new DERTaggedObject(true, tag, Wn);
        } else
        {
            return new DERTaggedObject(false, tag, Wn);
        }
    }
}
