// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.io.IOException;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERGeneralizedTime;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERPrintableString;
import org.spongycastle.asn1.DERUTF8String;
import org.spongycastle.util.Strings;

// Referenced classes of package org.spongycastle.asn1.x509:
//            X509NameEntryConverter, X509Name

public class X509DefaultEntryConverter extends X509NameEntryConverter
{

    public X509DefaultEntryConverter()
    {
    }

    public final ASN1Primitive _mth02CA(ASN1ObjectIdentifier asn1objectidentifier, String s)
    {
        if (s.length() == 0 || s.charAt(0) != '#') goto _L2; else goto _L1
_L1:
        Object obj;
        int i;
        char c;
        char c1;
        try
        {
            s = Strings.FE91(s);
            obj = new byte[(s.length() - 1) / 2];
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException((new StringBuilder("can't recode value for oid ")).append(asn1objectidentifier.identifier).toString());
        }
        i = 0;
_L4:
        if (i != obj.length)
        {
            c = s.charAt((i << 1) + 1);
            c1 = s.charAt((i << 1) + 1 + 1);
            break MISSING_BLOCK_LABEL_69;
        }
        s = (new ASN1InputStream(((byte []) (obj))))._mth04B7();
        return s;
_L2:
        obj = s;
        if (s.length() != 0)
        {
            obj = s;
            if (s.charAt(0) == '\\')
            {
                obj = s.substring(1);
            }
        }
        if (asn1objectidentifier.equals(X509Name.agM) || asn1objectidentifier.equals(X509Name.agQ))
        {
            return new DERIA5String(((String) (obj)));
        }
        if (asn1objectidentifier.equals(X509Name.agD))
        {
            return new DERGeneralizedTime(((String) (obj)));
        }
        if (asn1objectidentifier.equals(X509Name.agl) || asn1objectidentifier.equals(X509Name.agq) || asn1objectidentifier.equals(X509Name.agB) || asn1objectidentifier.equals(X509Name.agK))
        {
            return new DERPrintableString(((String) (obj)));
        } else
        {
            return new DERUTF8String(((String) (obj)));
        }
        if (c < 'a')
        {
            obj[i] = (byte)(c - 48 << 4);
        } else
        {
            obj[i] = (byte)((c - 97) + 10 << 4);
        }
        if (c1 < 'a')
        {
            obj[i] = (byte)(obj[i] | (byte)(c1 - 48));
        } else
        {
            obj[i] = (byte)(obj[i] | (byte)((c1 - 97) + 10));
        }
        i++;
        if (true) goto _L4; else goto _L3
_L3:
    }
}
