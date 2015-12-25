// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.util.Hashtable;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERBitString;

// Referenced classes of package org.spongycastle.asn1.x509:
//            Extension, Extensions

public class KeyUsage extends ASN1Object
{

    public DERBitString ajt;

    public KeyUsage(int i)
    {
        ajt = new DERBitString(i);
    }

    private KeyUsage(DERBitString derbitstring)
    {
        ajt = derbitstring;
    }

    public static KeyUsage _mth02B4(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof KeyUsage)
        {
            return (KeyUsage)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new KeyUsage(DERBitString._mth14BD(asn1encodable));
        } else
        {
            return null;
        }
    }

    public static KeyUsage _mth02CA(Extensions extensions)
    {
        org.spongycastle.asn1.ASN1ObjectIdentifier asn1objectidentifier = Extension.aiD;
        extensions = (Extension)extensions.aiY.get(asn1objectidentifier);
        if (extensions != null)
        {
            extensions = Extension._mth02CA(extensions);
        } else
        {
            extensions = null;
        }
        if (extensions instanceof KeyUsage)
        {
            return (KeyUsage)extensions;
        }
        if (extensions != null)
        {
            return new KeyUsage(DERBitString._mth14BD(extensions));
        } else
        {
            return null;
        }
    }

    public String toString()
    {
        byte abyte0[] = ajt.getBytes();
        if (abyte0.length == 1)
        {
            return (new StringBuilder("KeyUsage: 0x")).append(Integer.toHexString(abyte0[0] & 0xff)).toString();
        } else
        {
            return (new StringBuilder("KeyUsage: 0x")).append(Integer.toHexString((abyte0[1] & 0xff) << 8 | abyte0[0] & 0xff)).toString();
        }
    }

    public final ASN1Primitive _mth0427()
    {
        return ajt;
    }
}
