// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.Target;
import org.spongycastle.asn1.x509.TargetInformation;
import org.spongycastle.asn1.x509.Targets;
import org.spongycastle.asn1.x509.X509Extensions;
import org.spongycastle.util.Selector;

// Referenced classes of package org.spongycastle.x509:
//            X509AttributeCertificate, AttributeCertificateHolder, AttributeCertificateIssuer

public class X509AttributeCertStoreSelector
    implements Selector
{

    public AttributeCertificateHolder aPU;
    private AttributeCertificateIssuer aPV;
    public BigInteger aPW;
    private Date aPX;
    public X509AttributeCertificate aPY;
    private Collection aPZ;
    private Collection aQa;

    public X509AttributeCertStoreSelector()
    {
        aPZ = new HashSet();
        aQa = new HashSet();
    }

    public Object clone()
    {
        X509AttributeCertStoreSelector x509attributecertstoreselector = new X509AttributeCertStoreSelector();
        x509attributecertstoreselector.aPY = aPY;
        Date date;
        if (aPX != null)
        {
            date = new Date(aPX.getTime());
        } else
        {
            date = null;
        }
        x509attributecertstoreselector.aPX = date;
        x509attributecertstoreselector.aPU = aPU;
        x509attributecertstoreselector.aPV = aPV;
        x509attributecertstoreselector.aPW = aPW;
        x509attributecertstoreselector.aQa = Collections.unmodifiableCollection(aQa);
        x509attributecertstoreselector.aPZ = Collections.unmodifiableCollection(aPZ);
        return x509attributecertstoreselector;
    }

    public final boolean _mth1D59(Object obj)
    {
        if (!(obj instanceof X509AttributeCertificate))
        {
            return false;
        }
        obj = (X509AttributeCertificate)obj;
        if (aPY != null && !aPY.equals(obj))
        {
            return false;
        }
        if (aPW != null && !((X509AttributeCertificate) (obj)).getSerialNumber().equals(aPW))
        {
            return false;
        }
        if (aPU != null && !((X509AttributeCertificate) (obj))._mth1F59().equals(aPU))
        {
            return false;
        }
        if (aPV != null && !((X509AttributeCertificate) (obj))._mth1FE8().equals(aPV))
        {
            return false;
        }
        if (aPX != null)
        {
            try
            {
                ((X509AttributeCertificate) (obj)).checkValidity(aPX);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return false;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return false;
            }
        }
        if (!aPZ.isEmpty() || !aQa.isEmpty())
        {
            obj = ((X509AttributeCertificate) (obj)).getExtensionValue(X509Extensions.aku.identifier);
            if (obj != null)
            {
                Object obj1;
                try
                {
                    obj1 = TargetInformation._mth02C9((new ASN1InputStream(((DEROctetString)DEROctetString._mth0640(((byte []) (obj))))._mth0501()))._mth04B7());
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    return false;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    return false;
                }
                obj = new Targets[((TargetInformation) (obj1)).ajV.size()];
                int i = 0;
                for (obj1 = ((TargetInformation) (obj1)).ajV._mth0675(); ((Enumeration) (obj1)).hasMoreElements();)
                {
                    int l = i + 1;
                    obj[i] = Targets._mth14A2(((Enumeration) (obj1)).nextElement());
                    i = l;
                }

                if (!aPZ.isEmpty())
                {
                    boolean flag = false;
                    for (int j = 0; j < obj.length;)
                    {
                        Target atarget[] = obj[j]._mth1434();
                        int i1 = 0;
                        boolean flag2;
                        do
                        {
                            flag2 = flag;
                            if (i1 >= atarget.length)
                            {
                                break;
                            }
                            if (aPZ.contains(GeneralName._mth02E3(atarget[i1].ajT)))
                            {
                                flag2 = true;
                                break;
                            }
                            i1++;
                        } while (true);
                        j++;
                        flag = flag2;
                    }

                    if (!flag)
                    {
                        return false;
                    }
                }
                if (!aQa.isEmpty())
                {
                    boolean flag1 = false;
                    for (int k = 0; k < obj.length;)
                    {
                        Target atarget1[] = obj[k]._mth1434();
                        int j1 = 0;
                        boolean flag3;
                        do
                        {
                            flag3 = flag1;
                            if (j1 >= atarget1.length)
                            {
                                break;
                            }
                            if (aQa.contains(GeneralName._mth02E3(atarget1[j1].ajU)))
                            {
                                flag3 = true;
                                break;
                            }
                            j1++;
                        } while (true);
                        k++;
                        flag1 = flag3;
                    }

                    if (!flag1)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
