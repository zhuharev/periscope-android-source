// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.util;

import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OutputStream;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;

public class PKCS12BagAttributeCarrierImpl
    implements PKCS12BagAttributeCarrier
{

    public Hashtable aEq;
    public Vector aEr;

    public PKCS12BagAttributeCarrierImpl()
    {
        this(new Hashtable(), new Vector());
    }

    private PKCS12BagAttributeCarrierImpl(Hashtable hashtable, Vector vector)
    {
        aEq = hashtable;
        aEr = vector;
    }

    public final void readObject(ObjectInputStream objectinputstream)
    {
        Object obj = objectinputstream.readObject();
        if (obj instanceof Hashtable)
        {
            aEq = (Hashtable)obj;
            aEr = (Vector)objectinputstream.readObject();
            return;
        }
        objectinputstream = new ASN1InputStream((byte[])obj);
        do
        {
            ASN1ObjectIdentifier asn1objectidentifier = (ASN1ObjectIdentifier)objectinputstream._mth04B7();
            if (asn1objectidentifier != null)
            {
                _mth02CA(asn1objectidentifier, objectinputstream._mth04B7());
            } else
            {
                return;
            }
        } while (true);
    }

    public final void writeObject(ObjectOutputStream objectoutputstream)
    {
        if (aEr.size() == 0)
        {
            objectoutputstream.writeObject(new Hashtable());
            objectoutputstream.writeObject(new Vector());
            return;
        }
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        ASN1OutputStream asn1outputstream = new ASN1OutputStream(bytearrayoutputstream);
        ASN1ObjectIdentifier asn1objectidentifier;
        for (Enumeration enumeration = aEr.elements(); enumeration.hasMoreElements(); asn1outputstream._mth02CF((ASN1Encodable)aEq.get(asn1objectidentifier)))
        {
            asn1objectidentifier = (ASN1ObjectIdentifier)enumeration.nextElement();
            asn1outputstream._mth02CF(asn1objectidentifier);
        }

        objectoutputstream.writeObject(bytearrayoutputstream.toByteArray());
    }

    public final ASN1Encodable _mth02BC(ASN1ObjectIdentifier asn1objectidentifier)
    {
        return (ASN1Encodable)aEq.get(asn1objectidentifier);
    }

    public final void _mth02CA(ASN1ObjectIdentifier asn1objectidentifier, ASN1Encodable asn1encodable)
    {
        if (aEq.containsKey(asn1objectidentifier))
        {
            aEq.put(asn1objectidentifier, asn1encodable);
            return;
        } else
        {
            aEq.put(asn1objectidentifier, asn1encodable);
            aEr.addElement(asn1objectidentifier);
            return;
        }
    }

    public final Enumeration _mth152C()
    {
        return aEr.elements();
    }
}
