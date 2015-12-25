// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.CertSelector;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.Holder;
import org.spongycastle.asn1.x509.IssuerSerial;
import org.spongycastle.asn1.x509.ObjectDigestInfo;
import org.spongycastle.jce.PrincipalUtil;
import org.spongycastle.jce.X509Principal;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Selector;

public class AttributeCertificateHolder
    implements CertSelector, Selector
{

    private Holder aib;

    AttributeCertificateHolder(ASN1Sequence asn1sequence)
    {
        aib = Holder._mth02B3(asn1sequence);
    }

    private static boolean _mth02CA(X509Principal x509principal, GeneralNames generalnames)
    {
        GeneralName ageneralname[];
        int i;
        ageneralname = new GeneralName[generalnames.ajb.length];
        System.arraycopy(generalnames.ajb, 0, ageneralname, 0, generalnames.ajb.length);
        i = 0;
_L2:
        if (i == ageneralname.length)
        {
            break; /* Loop/switch isn't completed */
        }
        generalnames = ageneralname[i];
        if (((GeneralName) (generalnames)).tag != 4)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        boolean flag = (new X509Principal(((GeneralName) (generalnames)).Wn._mth0427().getEncoded())).equals(x509principal);
        if (flag)
        {
            return true;
        }
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return false;
        generalnames;
          goto _L3
    }

    private static Object[] _mth02CA(GeneralName ageneralname[])
    {
        ArrayList arraylist = new ArrayList(ageneralname.length);
        for (int i = 0; i != ageneralname.length; i++)
        {
            if (ageneralname[i].tag != 4)
            {
                continue;
            }
            try
            {
                arraylist.add(new X500Principal(ageneralname[i].Wn._mth0427().getEncoded()));
            }
            // Misplaced declaration of an exception variable
            catch (GeneralName ageneralname[])
            {
                throw new RuntimeException("badly formed Name object");
            }
        }

        return arraylist.toArray(new Object[arraylist.size()]);
    }

    private Principal[] _mth02CA(GeneralNames generalnames)
    {
        GeneralName ageneralname[] = new GeneralName[generalnames.ajb.length];
        System.arraycopy(generalnames.ajb, 0, ageneralname, 0, generalnames.ajb.length);
        generalnames = ((GeneralNames) (_mth02CA(ageneralname)));
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i != generalnames.length; i++)
        {
            if (generalnames[i] instanceof Principal)
            {
                arraylist.add(generalnames[i]);
            }
        }

        return (Principal[])arraylist.toArray(new Principal[arraylist.size()]);
    }

    public Object clone()
    {
        return new AttributeCertificateHolder((ASN1Sequence)aib._mth0427());
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof AttributeCertificateHolder))
        {
            return false;
        } else
        {
            obj = (AttributeCertificateHolder)obj;
            return aib.equals(((AttributeCertificateHolder) (obj)).aib);
        }
    }

    public String getDigestAlgorithm()
    {
        if (aib.getObjectDigestInfo() != null)
        {
            return aib.getObjectDigestInfo().ajy._mth072C().identifier;
        } else
        {
            return null;
        }
    }

    public int getDigestedObjectType()
    {
        if (aib.getObjectDigestInfo() != null)
        {
            return (new BigInteger(aib.getObjectDigestInfo().ajw.bytes)).intValue();
        } else
        {
            return -1;
        }
    }

    public Principal[] getEntityNames()
    {
        if (aib.getEntityName() != null)
        {
            return _mth02CA(aib.getEntityName());
        } else
        {
            return null;
        }
    }

    public Principal[] getIssuer()
    {
        if (aib.getBaseCertificateID() != null)
        {
            return _mth02CA(aib.getBaseCertificateID().ajj);
        } else
        {
            return null;
        }
    }

    public byte[] getObjectDigest()
    {
        if (aib.getObjectDigestInfo() != null)
        {
            return aib.getObjectDigestInfo().ajz.getBytes();
        } else
        {
            return null;
        }
    }

    public String getOtherObjectTypeID()
    {
        if (aib.getObjectDigestInfo() != null)
        {
            aib.getObjectDigestInfo();
        }
        return null;
    }

    public BigInteger getSerialNumber()
    {
        if (aib.getBaseCertificateID() != null)
        {
            return new BigInteger(aib.getBaseCertificateID().ajk.bytes);
        } else
        {
            return null;
        }
    }

    public int hashCode()
    {
        return aib.hashCode();
    }

    public boolean match(Certificate certificate)
    {
        Object obj;
        if (!(certificate instanceof X509Certificate))
        {
            return false;
        }
        obj = (X509Certificate)certificate;
        boolean flag;
        if (aib.getBaseCertificateID() == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        if (!(new BigInteger(aib.getBaseCertificateID().ajk.bytes)).equals(((X509Certificate) (obj)).getSerialNumber()))
        {
            break MISSING_BLOCK_LABEL_78;
        }
        flag = _mth02CA(PrincipalUtil._mth141D(((X509Certificate) (obj))), aib.getBaseCertificateID().ajj);
        if (flag)
        {
            return true;
        }
        return false;
        if (aib.getEntityName() == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        flag = _mth02CA(PrincipalUtil._mth02BB(((X509Certificate) (obj))), aib.getEntityName());
        if (flag)
        {
            return true;
        }
        try
        {
            obj = aib.getObjectDigestInfo();
        }
        // Misplaced declaration of an exception variable
        catch (Certificate certificate)
        {
            return false;
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = MessageDigest.getInstance(getDigestAlgorithm(), "SC");
          goto _L3
_L8:
        return false;
_L3:
        getDigestedObjectType();
        JVM INSTR lookupswitch 2: default 225
    //                   0: 168
    //                   1: 184;
           goto _L4 _L5 _L6
_L4:
        break; /* Loop/switch isn't completed */
_L5:
        ((MessageDigest) (obj)).update(certificate.getPublicKey().getEncoded());
        break; /* Loop/switch isn't completed */
_L6:
        ((MessageDigest) (obj)).update(certificate.getEncoded());
        flag = Arrays._mth1427(((MessageDigest) (obj)).digest(), getObjectDigest());
        if (!flag)
        {
            return false;
        }
_L2:
        return false;
        certificate;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final boolean _mth1D59(Object obj)
    {
        if (!(obj instanceof X509Certificate))
        {
            return false;
        } else
        {
            return match((Certificate)obj);
        }
    }
}
