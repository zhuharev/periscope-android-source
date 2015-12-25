// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.Vector;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.BasicConstraints;
import org.spongycastle.asn1.x509.CRLDistPoint;
import org.spongycastle.asn1.x509.DistributionPoint;
import org.spongycastle.asn1.x509.DistributionPointName;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.GeneralSubtree;
import org.spongycastle.asn1.x509.IssuingDistributionPoint;
import org.spongycastle.asn1.x509.NameConstraints;
import org.spongycastle.asn1.x509.PolicyInformation;
import org.spongycastle.asn1.x509.X509Extensions;
import org.spongycastle.asn1.x509.X509Name;
import org.spongycastle.jce.exception.ExtCertPathValidatorException;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Integers;
import org.spongycastle.x509.ExtendedPKIXBuilderParameters;
import org.spongycastle.x509.ExtendedPKIXParameters;
import org.spongycastle.x509.X509CertStoreSelector;

// Referenced classes of package org.spongycastle.jce.provider:
//            PKIXCRLUtil, CertPathValidatorUtilities, AnnotatedException, PKIXPolicyNode, 
//            ReasonsMask, PKIXNameConstraintValidatorException, PKIXNameConstraintValidator, CertStatus

public class RFC3280CertPathUtilities
{

    public static final String aHN;
    public static final String aHO;
    public static final String aHP;
    public static final String aHQ;
    public static final String aHR;
    public static final String aHS;
    public static final String aHT;
    public static final String aHU;
    public static final String aHV;
    private static String aHW;
    public static final String aHX;
    protected static final String aHY[] = {
        "unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", 
        "aACompromise"
    };
    public static final String aHr;

    public RFC3280CertPathUtilities()
    {
    }

    protected static int _mth02BB(CertPath certpath, int i, int j)
    {
        if (!CertPathValidatorUtilities._mth02BD((X509Certificate)certpath.getCertificates().get(i)) && j != 0)
        {
            return j - 1;
        } else
        {
            return j;
        }
    }

    protected static int _mth02BC(CertPath certpath, int i, int j)
    {
        if (!CertPathValidatorUtilities._mth02BD((X509Certificate)certpath.getCertificates().get(i)) && j != 0)
        {
            return j - 1;
        } else
        {
            return j;
        }
    }

    protected static int _mth02BD(CertPath certpath, int i, int j)
    {
        if (!CertPathValidatorUtilities._mth02BD((X509Certificate)certpath.getCertificates().get(i)) && j != 0)
        {
            return j - 1;
        } else
        {
            return j;
        }
    }

    protected static int _mth02CA(int i, X509Certificate x509certificate)
    {
        int j = i;
        if (!CertPathValidatorUtilities._mth02BD(x509certificate))
        {
            j = i;
            if (i != 0)
            {
                j = i - 1;
            }
        }
        return j;
    }

    protected static int _mth02CA(CertPath certpath, int i, int j)
    {
        Object obj;
        obj = (X509Certificate)certpath.getCertificates().get(i);
        try
        {
            obj = DERSequence._mth141F(CertPathValidatorUtilities._mth02CA(((X509Extension) (obj)), aHR));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new ExtCertPathValidatorException("Policy constraints extension cannot be decoded.", ((Throwable) (obj)), certpath, i);
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        obj = ((ASN1Sequence) (obj))._mth0675();
_L2:
        if (!((Enumeration) (obj)).hasMoreElements())
        {
            break MISSING_BLOCK_LABEL_128;
        }
        ASN1TaggedObject asn1taggedobject = ASN1TaggedObject._mth142A(((Enumeration) (obj)).nextElement());
        if (asn1taggedobject.Wk != 0) goto _L2; else goto _L1
_L1:
        int k = (new BigInteger(ASN1Integer._mth02CB(asn1taggedobject, false).bytes)).intValue();
        if (k < j)
        {
            return k;
        } else
        {
            return j;
        }
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        throw new ExtCertPathValidatorException("Policy constraints extension contents cannot be decoded.", illegalargumentexception, certpath, i);
        return j;
    }

    protected static PublicKey _mth02CA(X509CRL x509crl, Set set)
    {
        Iterator iterator;
        Object obj = null;
        iterator = set.iterator();
        set = obj;
_L2:
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        set = (PublicKey)iterator.next();
        x509crl.verify(set);
        return set;
        set;
        if (true) goto _L2; else goto _L1
_L1:
        throw new AnnotatedException("Cannot verify CRL.", set);
    }

    protected static X509CRL _mth02CA(Set set, PublicKey publickey)
    {
        Iterator iterator;
        Object obj = null;
        iterator = set.iterator();
        set = obj;
_L2:
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        set = (X509CRL)iterator.next();
        set.verify(publickey);
        return set;
        set;
        if (true) goto _L2; else goto _L1
_L1:
        if (set != null)
        {
            throw new AnnotatedException("Cannot verify delta CRL.", set);
        } else
        {
            return null;
        }
    }

    protected static HashSet _mth02CA(X509CRL x509crl, X509Certificate x509certificate, PublicKey publickey, ExtendedPKIXParameters extendedpkixparameters, List list)
    {
        Object obj;
        ArrayList arraylist;
        obj = new X509CertStoreSelector();
        try
        {
            ((X509CertStoreSelector) (obj)).setSubject(CertPathValidatorUtilities._mth02CA(x509crl).getEncoded());
        }
        // Misplaced declaration of an exception variable
        catch (X509CRL x509crl)
        {
            throw new AnnotatedException("Subject criteria for certificate selector to find issuer certificate for CRL could not be set.", x509crl);
        }
        try
        {
            x509crl = CertPathValidatorUtilities._mth02CA(((X509CertStoreSelector) (obj)), Collections.unmodifiableList(new ArrayList(extendedpkixparameters.aPJ)));
            x509crl.addAll(CertPathValidatorUtilities._mth02CA(((X509CertStoreSelector) (obj)), Collections.unmodifiableList(extendedpkixparameters.aPM)));
            x509crl.addAll(CertPathValidatorUtilities._mth02CA(((X509CertStoreSelector) (obj)), extendedpkixparameters.getCertStores()));
        }
        // Misplaced declaration of an exception variable
        catch (X509CRL x509crl)
        {
            throw new AnnotatedException("Issuer certificate for CRL cannot be searched.", x509crl);
        }
        x509crl.add(x509certificate);
        x509crl = x509crl.iterator();
        obj = new ArrayList();
        arraylist = new ArrayList();
_L2:
label0:
        {
            if (!x509crl.hasNext())
            {
                break label0;
            }
            X509Certificate x509certificate1 = (X509Certificate)x509crl.next();
            if (x509certificate1.equals(x509certificate))
            {
                ((List) (obj)).add(x509certificate1);
                arraylist.add(publickey);
                continue; /* Loop/switch isn't completed */
            }
            Object obj1;
            Object obj2;
            try
            {
                obj1 = CertPathBuilder.getInstance("PKIX", "SC");
                obj2 = new X509CertStoreSelector();
                ((X509CertStoreSelector) (obj2)).setCertificate(x509certificate1);
                ExtendedPKIXParameters extendedpkixparameters1 = (ExtendedPKIXParameters)extendedpkixparameters.clone();
                extendedpkixparameters1.setTargetCertConstraints(((java.security.cert.CertSelector) (obj2)));
                obj2 = (ExtendedPKIXBuilderParameters)ExtendedPKIXBuilderParameters._mth02CB(extendedpkixparameters1);
                if (list.contains(x509certificate1))
                {
                    ((ExtendedPKIXBuilderParameters) (obj2)).setRevocationEnabled(false);
                    break MISSING_BLOCK_LABEL_272;
                }
            }
            // Misplaced declaration of an exception variable
            catch (X509CRL x509crl)
            {
                throw new AnnotatedException("Internal error.", x509crl);
            }
            // Misplaced declaration of an exception variable
            catch (X509CRL x509crl)
            {
                throw new AnnotatedException("Public key of issuer certificate of CRL could not be retrieved.", x509crl);
            }
            // Misplaced declaration of an exception variable
            catch (X509CRL x509crl)
            {
                throw new RuntimeException(x509crl.getMessage());
            }
        }
        ((ExtendedPKIXBuilderParameters) (obj2)).setRevocationEnabled(true);
        obj1 = ((CertPathBuilder) (obj1)).build(((java.security.cert.CertPathParameters) (obj2))).getCertPath().getCertificates();
        ((List) (obj)).add(x509certificate1);
        arraylist.add(CertPathValidatorUtilities._mth02CA(((List) (obj1)), 0));
        if (true) goto _L2; else goto _L1
_L1:
        x509certificate = new HashSet();
        x509crl = null;
        for (int i = 0; i < ((List) (obj)).size(); i++)
        {
            publickey = ((X509Certificate)((List) (obj)).get(i)).getKeyUsage();
            if (publickey != null && (publickey.length < 7 || publickey[6] == 0))
            {
                x509crl = new AnnotatedException("Issuer certificate key usage extension does not permit CRL signing.");
            } else
            {
                x509certificate.add(arraylist.get(i));
            }
        }

        if (x509certificate.isEmpty() && x509crl == null)
        {
            throw new AnnotatedException("Cannot find a valid issuer certificate.");
        }
        if (x509certificate.isEmpty() && x509crl != null)
        {
            throw x509crl;
        } else
        {
            return x509certificate;
        }
    }

    protected static PKIXPolicyNode _mth02CA(CertPath certpath, int i, HashSet hashset, PKIXPolicyNode pkixpolicynode, ArrayList aarraylist[], int j)
    {
label0:
        {
            X509Certificate x509certificate;
            int k;
label1:
            {
                Object obj = certpath.getCertificates();
                x509certificate = (X509Certificate)((List) (obj)).get(i);
                int l = ((List) (obj)).size();
                k = l - i;
                try
                {
                    obj = DERSequence._mth141F(CertPathValidatorUtilities._mth02CA(x509certificate, aHN));
                }
                // Misplaced declaration of an exception variable
                catch (HashSet hashset)
                {
                    throw new ExtCertPathValidatorException("Could not read certificate policies extension from certificate.", hashset, certpath, i);
                }
                if (obj == null || pkixpolicynode == null)
                {
                    break label0;
                }
                Enumeration enumeration = ((ASN1Sequence) (obj))._mth0675();
                HashSet hashset1 = new HashSet();
                do
                {
                    if (!enumeration.hasMoreElements())
                    {
                        break;
                    }
                    Object obj2 = PolicyInformation._mth0E40(enumeration.nextElement());
                    ASN1ObjectIdentifier asn1objectidentifier = ((PolicyInformation) (obj2)).ajA;
                    hashset1.add(asn1objectidentifier.identifier);
                    if (!"2.5.29.32.0".equals(asn1objectidentifier.identifier))
                    {
                        try
                        {
                            obj2 = CertPathValidatorUtilities._mth02BD(((PolicyInformation) (obj2)).ajB);
                        }
                        // Misplaced declaration of an exception variable
                        catch (HashSet hashset)
                        {
                            throw new ExtCertPathValidatorException("Policy qualifier info set could not be build.", hashset, certpath, i);
                        }
                        if (!CertPathValidatorUtilities._mth02CA(k, aarraylist, asn1objectidentifier, ((Set) (obj2))))
                        {
                            CertPathValidatorUtilities._mth02CB(k, aarraylist, asn1objectidentifier, ((Set) (obj2)));
                        }
                    }
                } while (true);
                if (hashset.isEmpty() || hashset.contains("2.5.29.32.0"))
                {
                    hashset.clear();
                    hashset.addAll(hashset1);
                } else
                {
                    certpath = hashset.iterator();
                    HashSet hashset2 = new HashSet();
                    do
                    {
                        if (!certpath.hasNext())
                        {
                            break;
                        }
                        Object obj1 = certpath.next();
                        if (hashset1.contains(obj1))
                        {
                            hashset2.add(obj1);
                        }
                    } while (true);
                    hashset.clear();
                    hashset.addAll(hashset2);
                }
                if (j <= 0 && (k >= l || !CertPathValidatorUtilities._mth02BD(x509certificate)))
                {
                    break label1;
                }
                certpath = ((ASN1Sequence) (obj))._mth0675();
                do
                {
                    if (!certpath.hasMoreElements())
                    {
                        break label1;
                    }
                    hashset = PolicyInformation._mth0E40(certpath.nextElement());
                } while (!"2.5.29.32.0".equals(((PolicyInformation) (hashset)).ajA.identifier));
                hashset = CertPathValidatorUtilities._mth02BD(((PolicyInformation) (hashset)).ajB);
                obj = aarraylist[k - 1];
label2:
                for (i = 0; i < ((List) (obj)).size(); i++)
                {
                    PKIXPolicyNode pkixpolicynode2 = (PKIXPolicyNode)((List) (obj)).get(i);
                    Iterator iterator = pkixpolicynode2.getExpectedPolicies().iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            continue label2;
                        }
                        certpath = ((CertPath) (iterator.next()));
                        if (certpath instanceof String)
                        {
                            certpath = (String)certpath;
                        } else
                        {
                            if (!(certpath instanceof ASN1ObjectIdentifier))
                            {
                                continue;
                            }
                            certpath = ((ASN1ObjectIdentifier)certpath).identifier;
                        }
                        j = 0;
                        Iterator iterator1 = pkixpolicynode2.getChildren();
                        do
                        {
                            if (!iterator1.hasNext())
                            {
                                break;
                            }
                            if (certpath.equals(((PKIXPolicyNode)iterator1.next()).getValidPolicy()))
                            {
                                j = 1;
                            }
                        } while (true);
                        if (j == 0)
                        {
                            HashSet hashset3 = new HashSet();
                            hashset3.add(certpath);
                            certpath = new PKIXPolicyNode(new ArrayList(), k, hashset3, pkixpolicynode2, hashset, certpath, false);
                            pkixpolicynode2._mth02CA(certpath);
                            aarraylist[k].add(certpath);
                        }
                    } while (true);
                }

            }
            certpath = pkixpolicynode;
            for (i = k - 1; i >= 0;)
            {
                pkixpolicynode = aarraylist[i];
                j = 0;
                do
                {
                    hashset = certpath;
                    if (j >= pkixpolicynode.size())
                    {
                        break;
                    }
                    PKIXPolicyNode pkixpolicynode1 = (PKIXPolicyNode)pkixpolicynode.get(j);
                    hashset = certpath;
                    if (!pkixpolicynode1.hasChildren())
                    {
                        certpath = CertPathValidatorUtilities._mth02CA(certpath, aarraylist, pkixpolicynode1);
                        hashset = certpath;
                        if (certpath == null)
                        {
                            break;
                        }
                        hashset = certpath;
                    }
                    j++;
                    certpath = hashset;
                } while (true);
                i--;
                certpath = hashset;
            }

            hashset = x509certificate.getCriticalExtensionOIDs();
            if (hashset != null)
            {
                boolean flag = hashset.contains(aHN);
                hashset = aarraylist[k];
                for (i = 0; i < hashset.size(); i++)
                {
                    ((PKIXPolicyNode)hashset.get(i))._mth14A2(flag);
                }

            }
            return certpath;
        }
        return null;
    }

    protected static PKIXPolicyNode _mth02CA(CertPath certpath, int i, PKIXPolicyNode pkixpolicynode)
    {
        Object obj = (X509Certificate)certpath.getCertificates().get(i);
        try
        {
            obj = DERSequence._mth141F(CertPathValidatorUtilities._mth02CA(((X509Extension) (obj)), aHN));
        }
        // Misplaced declaration of an exception variable
        catch (PKIXPolicyNode pkixpolicynode)
        {
            throw new ExtCertPathValidatorException("Could not read certificate policies extension from certificate.", pkixpolicynode, certpath, i);
        }
        if (obj == null)
        {
            pkixpolicynode = null;
        }
        return pkixpolicynode;
    }

    protected static PKIXPolicyNode _mth02CA(CertPath certpath, int i, ArrayList aarraylist[], PKIXPolicyNode pkixpolicynode, int j)
    {
        Object obj = certpath.getCertificates();
        X509Certificate x509certificate = (X509Certificate)((List) (obj)).get(i);
        int j1 = ((List) (obj)).size() - i;
        ASN1Sequence asn1sequence;
        try
        {
            asn1sequence = DERSequence._mth141F(CertPathValidatorUtilities._mth02CA(x509certificate, aHO));
        }
        // Misplaced declaration of an exception variable
        catch (ArrayList aarraylist[])
        {
            throw new ExtCertPathValidatorException("Policy mappings extension could not be decoded.", aarraylist, certpath, i);
        }
        obj = pkixpolicynode;
        if (asn1sequence != null)
        {
            HashMap hashmap = new HashMap();
            obj = new HashSet();
            for (int k = 0; k < asn1sequence.size(); k++)
            {
                Object obj1 = (ASN1Sequence)asn1sequence._mth144B(k);
                String s = ((ASN1ObjectIdentifier)((ASN1Sequence) (obj1))._mth144B(0)).identifier;
                obj1 = ((ASN1ObjectIdentifier)((ASN1Sequence) (obj1))._mth144B(1)).identifier;
                if (!hashmap.containsKey(s))
                {
                    HashSet hashset = new HashSet();
                    hashset.add(obj1);
                    hashmap.put(s, hashset);
                    ((Set) (obj)).add(s);
                } else
                {
                    ((Set)hashmap.get(s)).add(obj1);
                }
            }

            Iterator iterator1 = ((Set) (obj)).iterator();
label0:
            do
            {
                obj = pkixpolicynode;
                if (!iterator1.hasNext())
                {
                    break;
                }
                String s1 = (String)iterator1.next();
                if (j > 0)
                {
                    boolean flag1 = false;
                    obj = aarraylist[j1].iterator();
                    boolean flag;
                    do
                    {
                        flag = flag1;
                        if (!((Iterator) (obj)).hasNext())
                        {
                            break;
                        }
                        PKIXPolicyNode pkixpolicynode1 = (PKIXPolicyNode)((Iterator) (obj)).next();
                        if (!pkixpolicynode1.getValidPolicy().equals(s1))
                        {
                            continue;
                        }
                        flag = true;
                        pkixpolicynode1.aHJ = (Set)hashmap.get(s1);
                        break;
                    } while (true);
                    if (flag)
                    {
                        continue;
                    }
                    obj = aarraylist[j1].iterator();
                    PKIXPolicyNode pkixpolicynode3;
                    do
                    {
                        if (!((Iterator) (obj)).hasNext())
                        {
                            continue label0;
                        }
                        pkixpolicynode3 = (PKIXPolicyNode)((Iterator) (obj)).next();
                    } while (!"2.5.29.32.0".equals(pkixpolicynode3.getValidPolicy()));
                    PKIXPolicyNode pkixpolicynode2 = null;
                    try
                    {
                        obj = (ASN1Sequence)CertPathValidatorUtilities._mth02CA(x509certificate, aHN);
                    }
                    // Misplaced declaration of an exception variable
                    catch (ArrayList aarraylist[])
                    {
                        throw new ExtCertPathValidatorException("Certificate policies extension could not be decoded.", aarraylist, certpath, i);
                    }
                    Enumeration enumeration = ((ASN1Sequence) (obj))._mth0675();
                    do
                    {
                        obj = pkixpolicynode2;
                        if (!enumeration.hasMoreElements())
                        {
                            break;
                        }
                        try
                        {
                            obj = PolicyInformation._mth0E40(enumeration.nextElement());
                        }
                        // Misplaced declaration of an exception variable
                        catch (ArrayList aarraylist[])
                        {
                            throw new CertPathValidatorException("Policy information could not be decoded.", aarraylist, certpath, i);
                        }
                        if (!"2.5.29.32.0".equals(((PolicyInformation) (obj)).ajA.identifier))
                        {
                            continue;
                        }
                        try
                        {
                            obj = CertPathValidatorUtilities._mth02BD(((PolicyInformation) (obj)).ajB);
                        }
                        // Misplaced declaration of an exception variable
                        catch (ArrayList aarraylist[])
                        {
                            throw new ExtCertPathValidatorException("Policy qualifier info set could not be decoded.", aarraylist, certpath, i);
                        }
                        break;
                    } while (true);
                    boolean flag2 = false;
                    if (x509certificate.getCriticalExtensionOIDs() != null)
                    {
                        flag2 = x509certificate.getCriticalExtensionOIDs().contains(aHN);
                    }
                    pkixpolicynode2 = (PKIXPolicyNode)pkixpolicynode3.getParent();
                    if (!"2.5.29.32.0".equals(pkixpolicynode2.getValidPolicy()))
                    {
                        continue;
                    }
                    obj = new PKIXPolicyNode(new ArrayList(), j1, (Set)hashmap.get(s1), pkixpolicynode2, ((Set) (obj)), s1, flag2);
                    pkixpolicynode2._mth02CA(((PKIXPolicyNode) (obj)));
                    aarraylist[j1].add(obj);
                    obj = pkixpolicynode;
                } else
                {
                    obj = pkixpolicynode;
                    if (j <= 0)
                    {
                        Iterator iterator = aarraylist[j1].iterator();
                        do
                        {
                            obj = pkixpolicynode;
                            if (!iterator.hasNext())
                            {
                                break;
                            }
                            PKIXPolicyNode pkixpolicynode4 = (PKIXPolicyNode)iterator.next();
                            obj = pkixpolicynode;
                            if (pkixpolicynode4.getValidPolicy().equals(s1))
                            {
                                ((PKIXPolicyNode)pkixpolicynode4.getParent())._mth02CB(pkixpolicynode4);
                                iterator.remove();
                                int l = j1 - 1;
                                do
                                {
                                    obj = pkixpolicynode;
                                    if (l < 0)
                                    {
                                        break;
                                    }
                                    ArrayList arraylist = aarraylist[l];
                                    int i1 = 0;
                                    do
                                    {
                                        obj = pkixpolicynode;
                                        if (i1 >= arraylist.size())
                                        {
                                            break;
                                        }
                                        PKIXPolicyNode pkixpolicynode5 = (PKIXPolicyNode)arraylist.get(i1);
                                        obj = pkixpolicynode;
                                        if (!pkixpolicynode5.hasChildren())
                                        {
                                            pkixpolicynode = CertPathValidatorUtilities._mth02CA(pkixpolicynode, aarraylist, pkixpolicynode5);
                                            obj = pkixpolicynode;
                                            if (pkixpolicynode == null)
                                            {
                                                break;
                                            }
                                            obj = pkixpolicynode;
                                        }
                                        i1++;
                                        pkixpolicynode = ((PKIXPolicyNode) (obj));
                                    } while (true);
                                    l--;
                                    pkixpolicynode = ((PKIXPolicyNode) (obj));
                                } while (true);
                            }
                            pkixpolicynode = ((PKIXPolicyNode) (obj));
                        } while (true);
                    }
                }
                pkixpolicynode = ((PKIXPolicyNode) (obj));
            } while (true);
        }
        return ((PKIXPolicyNode) (obj));
    }

    protected static PKIXPolicyNode _mth02CA(CertPath certpath, ExtendedPKIXParameters extendedpkixparameters, Set set, int i, ArrayList aarraylist[], PKIXPolicyNode pkixpolicynode, HashSet hashset)
    {
        int j1 = certpath.getCertificates().size();
        if (pkixpolicynode == null)
        {
            if (extendedpkixparameters.isExplicitPolicyRequired())
            {
                throw new ExtCertPathValidatorException("Explicit policy requested but none available.", null, certpath, i);
            } else
            {
                return null;
            }
        }
        if (CertPathValidatorUtilities._mth02CF(set))
        {
            set = pkixpolicynode;
            if (extendedpkixparameters.isExplicitPolicyRequired())
            {
                if (hashset.isEmpty())
                {
                    throw new ExtCertPathValidatorException("Explicit policy requested but none available.", null, certpath, i);
                }
                certpath = new HashSet();
                for (i = 0; i < aarraylist.length; i++)
                {
                    extendedpkixparameters = aarraylist[i];
                    for (int j = 0; j < extendedpkixparameters.size(); j++)
                    {
                        set = (PKIXPolicyNode)extendedpkixparameters.get(j);
                        if (!"2.5.29.32.0".equals(set.getValidPolicy()))
                        {
                            continue;
                        }
                        for (set = set.getChildren(); set.hasNext(); certpath.add(set.next())) { }
                    }

                }

                for (certpath = certpath.iterator(); certpath.hasNext(); hashset.contains(((PKIXPolicyNode)certpath.next()).getValidPolicy())) { }
                set = pkixpolicynode;
                if (pkixpolicynode != null)
                {
                    i = j1 - 1;
                    do
                    {
                        set = pkixpolicynode;
                        if (i < 0)
                        {
                            break;
                        }
                        extendedpkixparameters = aarraylist[i];
                        for (int k = 0; k < extendedpkixparameters.size();)
                        {
                            set = (PKIXPolicyNode)extendedpkixparameters.get(k);
                            certpath = pkixpolicynode;
                            if (!set.hasChildren())
                            {
                                certpath = CertPathValidatorUtilities._mth02CA(pkixpolicynode, aarraylist, set);
                            }
                            k++;
                            pkixpolicynode = certpath;
                        }

                        i--;
                    } while (true);
                }
            }
            return set;
        }
        certpath = new HashSet();
        for (i = 0; i < aarraylist.length; i++)
        {
            extendedpkixparameters = aarraylist[i];
label0:
            for (int l = 0; l < extendedpkixparameters.size(); l++)
            {
                hashset = (PKIXPolicyNode)extendedpkixparameters.get(l);
                if (!"2.5.29.32.0".equals(hashset.getValidPolicy()))
                {
                    continue;
                }
                hashset = hashset.getChildren();
                do
                {
                    PKIXPolicyNode pkixpolicynode1;
                    do
                    {
                        if (!hashset.hasNext())
                        {
                            continue label0;
                        }
                        pkixpolicynode1 = (PKIXPolicyNode)hashset.next();
                    } while ("2.5.29.32.0".equals(pkixpolicynode1.getValidPolicy()));
                    certpath.add(pkixpolicynode1);
                } while (true);
            }

        }

        for (extendedpkixparameters = certpath.iterator(); extendedpkixparameters.hasNext();)
        {
            hashset = (PKIXPolicyNode)extendedpkixparameters.next();
            certpath = pkixpolicynode;
            if (!set.contains(hashset.getValidPolicy()))
            {
                certpath = CertPathValidatorUtilities._mth02CA(pkixpolicynode, aarraylist, hashset);
            }
            pkixpolicynode = certpath;
        }

        certpath = pkixpolicynode;
        if (pkixpolicynode != null)
        {
            i = j1 - 1;
            do
            {
                certpath = pkixpolicynode;
                if (i < 0)
                {
                    break;
                }
                extendedpkixparameters = aarraylist[i];
                for (int i1 = 0; i1 < extendedpkixparameters.size();)
                {
                    set = (PKIXPolicyNode)extendedpkixparameters.get(i1);
                    certpath = pkixpolicynode;
                    if (!set.hasChildren())
                    {
                        certpath = CertPathValidatorUtilities._mth02CA(pkixpolicynode, aarraylist, set);
                    }
                    i1++;
                    pkixpolicynode = certpath;
                }

                i--;
            } while (true);
        }
        return certpath;
    }

    protected static ReasonsMask _mth02CA(X509CRL x509crl, DistributionPoint distributionpoint)
    {
        Object obj;
        try
        {
            obj = IssuingDistributionPoint._mth06E6(CertPathValidatorUtilities._mth02CA(x509crl, aHr));
        }
        // Misplaced declaration of an exception variable
        catch (X509CRL x509crl)
        {
            throw new AnnotatedException("Issuing distribution point extension could not be decoded.", x509crl);
        }
        if (obj != null && ((IssuingDistributionPoint) (obj)).ajo != null && distributionpoint.aiA != null)
        {
            x509crl = new ReasonsMask(distributionpoint.aiA);
            obj = new ReasonsMask(((IssuingDistributionPoint) (obj)).ajo);
            distributionpoint = new ReasonsMask();
            x509crl = new ReasonsMask(((ReasonsMask) (x509crl)).aIc & ((ReasonsMask) (obj)).aIc);
            distributionpoint.aIc = ((ReasonsMask) (distributionpoint)).aIc | ((ReasonsMask) (x509crl)).aIc;
            return distributionpoint;
        }
        if ((obj == null || ((IssuingDistributionPoint) (obj)).ajo == null) && distributionpoint.aiA == null)
        {
            return ReasonsMask.aId;
        }
        if (distributionpoint.aiA == null)
        {
            x509crl = ReasonsMask.aId;
        } else
        {
            x509crl = new ReasonsMask(distributionpoint.aiA);
        }
        if (obj == null)
        {
            distributionpoint = ReasonsMask.aId;
        } else
        {
            distributionpoint = new ReasonsMask(((IssuingDistributionPoint) (obj)).ajo);
        }
        obj = new ReasonsMask();
        x509crl = new ReasonsMask(((ReasonsMask) (x509crl)).aIc & ((ReasonsMask) (distributionpoint)).aIc);
        obj.aIc = ((ReasonsMask) (obj)).aIc | ((ReasonsMask) (x509crl)).aIc;
        return ((ReasonsMask) (obj));
    }

    protected static void _mth02CA(CertPath certpath, int i)
    {
        Object obj = (X509Certificate)certpath.getCertificates().get(i);
        try
        {
            obj = DERSequence._mth141F(CertPathValidatorUtilities._mth02CA(((X509Extension) (obj)), aHO));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new ExtCertPathValidatorException("Policy mappings extension could not be decoded.", ((Throwable) (obj)), certpath, i);
        }
        if (obj != null)
        {
            for (int j = 0; j < ((ASN1Sequence) (obj)).size(); j++)
            {
                ASN1ObjectIdentifier asn1objectidentifier;
                Object obj1;
                try
                {
                    obj1 = DERSequence._mth141F(((ASN1Sequence) (obj))._mth144B(j));
                    asn1objectidentifier = ASN1ObjectIdentifier._mth02CE(((ASN1Sequence) (obj1))._mth144B(0));
                    obj1 = ASN1ObjectIdentifier._mth02CE(((ASN1Sequence) (obj1))._mth144B(1));
                }
                catch (Exception exception)
                {
                    throw new ExtCertPathValidatorException("Policy mappings extension contents could not be decoded.", exception, certpath, i);
                }
                if ("2.5.29.32.0".equals(asn1objectidentifier.identifier))
                {
                    throw new CertPathValidatorException("IssuerDomainPolicy is anyPolicy", null, certpath, i);
                }
                if ("2.5.29.32.0".equals(((ASN1ObjectIdentifier) (obj1)).identifier))
                {
                    throw new CertPathValidatorException("SubjectDomainPolicy is anyPolicy,", null, certpath, i);
                }
            }

        }
    }

    protected static void _mth02CA(CertPath certpath, int i, HashSet hashset, List list)
    {
        X509Certificate x509certificate = (X509Certificate)certpath.getCertificates().get(i);
        for (list = list.iterator(); list.hasNext();)
        {
            try
            {
                ((PKIXCertPathChecker)list.next()).check(x509certificate, hashset);
            }
            // Misplaced declaration of an exception variable
            catch (HashSet hashset)
            {
                throw new CertPathValidatorException(hashset.getMessage(), hashset.getCause(), certpath, i);
            }
        }

        if (!hashset.isEmpty())
        {
            throw new ExtCertPathValidatorException((new StringBuilder("Certificate has unsupported critical extension: ")).append(hashset).toString(), null, certpath, i);
        } else
        {
            return;
        }
    }

    protected static void _mth02CA(CertPath certpath, int i, List list, HashSet hashset)
    {
        X509Certificate x509certificate = (X509Certificate)certpath.getCertificates().get(i);
        for (list = list.iterator(); list.hasNext();)
        {
            try
            {
                ((PKIXCertPathChecker)list.next()).check(x509certificate, hashset);
            }
            // Misplaced declaration of an exception variable
            catch (List list)
            {
                throw new ExtCertPathValidatorException("Additional certificate path checker failed.", list, certpath, i);
            }
        }

        if (!hashset.isEmpty())
        {
            throw new ExtCertPathValidatorException((new StringBuilder("Certificate has unsupported critical extension: ")).append(hashset).toString(), null, certpath, i);
        } else
        {
            return;
        }
    }

    protected static void _mth02CA(CertPath certpath, int i, PKIXNameConstraintValidator pkixnameconstraintvalidator)
    {
        List list = certpath.getCertificates();
        Object obj = (X509Certificate)list.get(i);
        int j = list.size();
        if (!CertPathValidatorUtilities._mth02BD(((X509Certificate) (obj))) || j - i >= j)
        {
            Object obj1 = new ASN1InputStream(CertPathValidatorUtilities._mth02BC(((X509Certificate) (obj))).getEncoded());
            try
            {
                obj1 = DERSequence._mth141F(((ASN1InputStream) (obj1))._mth04B7());
            }
            // Misplaced declaration of an exception variable
            catch (PKIXNameConstraintValidator pkixnameconstraintvalidator)
            {
                throw new CertPathValidatorException("Exception extracting subject name when checking subtrees.", pkixnameconstraintvalidator, certpath, i);
            }
            try
            {
                pkixnameconstraintvalidator._mth037A(((ASN1Sequence) (obj1)));
                pkixnameconstraintvalidator._mth1FBE(((ASN1Sequence) (obj1)));
            }
            // Misplaced declaration of an exception variable
            catch (PKIXNameConstraintValidator pkixnameconstraintvalidator)
            {
                throw new CertPathValidatorException("Subtree check for certificate subject failed.", pkixnameconstraintvalidator, certpath, i);
            }
            try
            {
                obj = GeneralNames._mth05D5(CertPathValidatorUtilities._mth02CA(((X509Extension) (obj)), aHU));
            }
            // Misplaced declaration of an exception variable
            catch (PKIXNameConstraintValidator pkixnameconstraintvalidator)
            {
                throw new CertPathValidatorException("Subject alternative name extension could not be decoded.", pkixnameconstraintvalidator, certpath, i);
            }
            for (obj1 = (new X509Name(((ASN1Sequence) (obj1))))._mth02BB(X509Name.agM).elements(); ((Enumeration) (obj1)).hasMoreElements();)
            {
                GeneralName generalname = new GeneralName(1, (String)((Enumeration) (obj1)).nextElement());
                try
                {
                    pkixnameconstraintvalidator._mth02CA(generalname);
                    pkixnameconstraintvalidator._mth02CB(generalname);
                }
                // Misplaced declaration of an exception variable
                catch (PKIXNameConstraintValidator pkixnameconstraintvalidator)
                {
                    throw new CertPathValidatorException("Subtree check for certificate subject alternative email failed.", pkixnameconstraintvalidator, certpath, i);
                }
            }

            if (obj != null)
            {
                GeneralName ageneralname[];
                try
                {
                    ageneralname = new GeneralName[((GeneralNames) (obj)).ajb.length];
                    System.arraycopy(((GeneralNames) (obj)).ajb, 0, ageneralname, 0, ((GeneralNames) (obj)).ajb.length);
                }
                // Misplaced declaration of an exception variable
                catch (PKIXNameConstraintValidator pkixnameconstraintvalidator)
                {
                    throw new CertPathValidatorException("Subject alternative name contents could not be decoded.", pkixnameconstraintvalidator, certpath, i);
                }
                for (int k = 0; k < ageneralname.length; k++)
                {
                    try
                    {
                        pkixnameconstraintvalidator._mth02CA(ageneralname[k]);
                        pkixnameconstraintvalidator._mth02CB(ageneralname[k]);
                    }
                    // Misplaced declaration of an exception variable
                    catch (PKIXNameConstraintValidator pkixnameconstraintvalidator)
                    {
                        throw new CertPathValidatorException("Subtree check for certificate subject alternative name failed.", pkixnameconstraintvalidator, certpath, i);
                    }
                }

            }
        }
    }

    protected static void _mth02CA(CertPath certpath, int i, PKIXPolicyNode pkixpolicynode, int j)
    {
        if (j <= 0 && pkixpolicynode == null)
        {
            throw new ExtCertPathValidatorException("No valid policy tree found when one expected.", null, certpath, i);
        } else
        {
            return;
        }
    }

    protected static void _mth02CA(CertPath certpath, ExtendedPKIXParameters extendedpkixparameters, int i, PublicKey publickey, boolean flag, X500Principal x500principal, X509Certificate x509certificate)
    {
        List list = certpath.getCertificates();
        X509Certificate x509certificate1 = (X509Certificate)list.get(i);
        if (!flag)
        {
            try
            {
                CertPathValidatorUtilities._mth02CA(x509certificate1, publickey, extendedpkixparameters.getSigProvider());
            }
            // Misplaced declaration of an exception variable
            catch (ExtendedPKIXParameters extendedpkixparameters)
            {
                throw new ExtCertPathValidatorException("Could not validate certificate signature.", extendedpkixparameters, certpath, i);
            }
        }
        try
        {
            x509certificate1.checkValidity(CertPathValidatorUtilities._mth02CA(extendedpkixparameters, certpath, i));
        }
        // Misplaced declaration of an exception variable
        catch (ExtendedPKIXParameters extendedpkixparameters)
        {
            throw new ExtCertPathValidatorException((new StringBuilder("Could not validate certificate: ")).append(extendedpkixparameters.getMessage()).toString(), extendedpkixparameters, certpath, i);
        }
        // Misplaced declaration of an exception variable
        catch (ExtendedPKIXParameters extendedpkixparameters)
        {
            throw new ExtCertPathValidatorException((new StringBuilder("Could not validate certificate: ")).append(extendedpkixparameters.getMessage()).toString(), extendedpkixparameters, certpath, i);
        }
        // Misplaced declaration of an exception variable
        catch (ExtendedPKIXParameters extendedpkixparameters)
        {
            throw new ExtCertPathValidatorException("Could not validate time of certificate.", extendedpkixparameters, certpath, i);
        }
        if (extendedpkixparameters.isRevocationEnabled())
        {
            try
            {
                _mth02CA(extendedpkixparameters, x509certificate1, CertPathValidatorUtilities._mth02CA(extendedpkixparameters, certpath, i), x509certificate, publickey, list);
            }
            // Misplaced declaration of an exception variable
            catch (PublicKey publickey)
            {
                extendedpkixparameters = publickey;
                if (publickey.getCause() != null)
                {
                    extendedpkixparameters = publickey.getCause();
                }
                throw new ExtCertPathValidatorException(publickey.getMessage(), extendedpkixparameters, certpath, i);
            }
        }
        if (!CertPathValidatorUtilities._mth1D53(x509certificate1).equals(x500principal))
        {
            throw new ExtCertPathValidatorException((new StringBuilder("IssuerName(")).append(CertPathValidatorUtilities._mth1D53(x509certificate1)).append(") does not match SubjectName(").append(x500principal).append(") of signing certificate.").toString(), null, certpath, i);
        } else
        {
            return;
        }
    }

    protected static void _mth02CA(X509CRL x509crl, X509CRL x509crl1, ExtendedPKIXParameters extendedpkixparameters)
    {
        if (x509crl == null)
        {
            return;
        }
        IssuingDistributionPoint issuingdistributionpoint;
        try
        {
            issuingdistributionpoint = IssuingDistributionPoint._mth06E6(CertPathValidatorUtilities._mth02CA(x509crl1, aHr));
        }
        // Misplaced declaration of an exception variable
        catch (X509CRL x509crl)
        {
            throw new AnnotatedException("Issuing distribution point extension could not be decoded.", x509crl);
        }
        if (extendedpkixparameters.aPS)
        {
            if (!x509crl.getIssuerX500Principal().equals(x509crl1.getIssuerX500Principal()))
            {
                throw new AnnotatedException("Complete CRL issuer does not match delta CRL issuer.");
            }
            try
            {
                extendedpkixparameters = IssuingDistributionPoint._mth06E6(CertPathValidatorUtilities._mth02CA(x509crl, aHr));
            }
            // Misplaced declaration of an exception variable
            catch (X509CRL x509crl)
            {
                throw new AnnotatedException("Issuing distribution point extension from delta CRL could not be decoded.", x509crl);
            }
            boolean flag = false;
            if (issuingdistributionpoint == null)
            {
                if (extendedpkixparameters == null)
                {
                    flag = true;
                }
            } else
            if (issuingdistributionpoint.equals(extendedpkixparameters))
            {
                flag = true;
            }
            if (!flag)
            {
                throw new AnnotatedException("Issuing distribution point extension from delta CRL and complete CRL does not match.");
            }
            try
            {
                x509crl1 = CertPathValidatorUtilities._mth02CA(x509crl1, aHW);
            }
            // Misplaced declaration of an exception variable
            catch (X509CRL x509crl)
            {
                throw new AnnotatedException("Authority key identifier extension could not be extracted from complete CRL.", x509crl);
            }
            try
            {
                x509crl = CertPathValidatorUtilities._mth02CA(x509crl, aHW);
            }
            // Misplaced declaration of an exception variable
            catch (X509CRL x509crl)
            {
                throw new AnnotatedException("Authority key identifier extension could not be extracted from delta CRL.", x509crl);
            }
            if (x509crl1 == null)
            {
                throw new AnnotatedException("CRL authority key identifier is null.");
            }
            if (x509crl == null)
            {
                throw new AnnotatedException("Delta CRL authority key identifier is null.");
            }
            if (!x509crl1.equals(x509crl))
            {
                throw new AnnotatedException("Delta CRL authority key identifier does not match complete CRL authority key identifier.");
            }
        }
    }

    protected static void _mth02CA(Date date, X509CRL x509crl, X509Extension x509extension, CertStatus certstatus)
    {
        if (certstatus.aHt == 11)
        {
            CertPathValidatorUtilities._mth02CA(date, x509crl, x509extension, certstatus);
        }
    }

    protected static void _mth02CA(Date date, X509CRL x509crl, X509Extension x509extension, CertStatus certstatus, ExtendedPKIXParameters extendedpkixparameters)
    {
        if (extendedpkixparameters.aPS && x509crl != null)
        {
            CertPathValidatorUtilities._mth02CA(date, x509crl, x509extension, certstatus);
        }
    }

    protected static void _mth02CA(DistributionPoint distributionpoint, X509Extension x509extension, X509CRL x509crl)
    {
        IssuingDistributionPoint issuingdistributionpoint;
        try
        {
            issuingdistributionpoint = IssuingDistributionPoint._mth06E6(CertPathValidatorUtilities._mth02CA(x509crl, aHr));
        }
        // Misplaced declaration of an exception variable
        catch (DistributionPoint distributionpoint)
        {
            throw new AnnotatedException("Issuing distribution point extension could not be decoded.", distributionpoint);
        }
        if (issuingdistributionpoint != null)
        {
            if (issuingdistributionpoint.aiz != null)
            {
                DistributionPointName distributionpointname = IssuingDistributionPoint._mth06E6(issuingdistributionpoint).aiz;
                ArrayList arraylist = new ArrayList();
                if (distributionpointname.type == 0)
                {
                    GeneralNames generalnames = GeneralNames._mth05D5(distributionpointname.aiC);
                    GeneralName ageneralname[] = new GeneralName[generalnames.ajb.length];
                    System.arraycopy(generalnames.ajb, 0, ageneralname, 0, generalnames.ajb.length);
                    for (int i = 0; i < ageneralname.length; i++)
                    {
                        arraylist.add(ageneralname[i]);
                    }

                }
                if (distributionpointname.type == 1)
                {
                    ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
                    try
                    {
                        ASN1Encodable asn1encodable;
                        for (x509crl = ASN1Sequence._mth141F(ASN1Sequence._mth0640(CertPathValidatorUtilities._mth02CA(x509crl).getEncoded()))._mth0675(); x509crl.hasMoreElements(); asn1encodablevector.VS.addElement(asn1encodable))
                        {
                            asn1encodable = (ASN1Encodable)x509crl.nextElement();
                        }

                    }
                    // Misplaced declaration of an exception variable
                    catch (DistributionPoint distributionpoint)
                    {
                        throw new AnnotatedException("Could not read CRL issuer.", distributionpoint);
                    }
                    x509crl = distributionpointname.aiC;
                    asn1encodablevector.VS.addElement(x509crl);
                    arraylist.add(new GeneralName(X509Name._mth1D4C(new DERSequence(asn1encodablevector))));
                }
                boolean flag3 = false;
                boolean flag2 = false;
                if (distributionpoint.aiz != null)
                {
                    DistributionPointName distributionpointname1 = distributionpoint.aiz;
                    x509crl = null;
                    if (distributionpointname1.type == 0)
                    {
                        GeneralNames generalnames1 = GeneralNames._mth05D5(distributionpointname1.aiC);
                        x509crl = new GeneralName[generalnames1.ajb.length];
                        System.arraycopy(generalnames1.ajb, 0, x509crl, 0, generalnames1.ajb.length);
                    }
                    if (distributionpointname1.type == 1)
                    {
                        if (distributionpoint.aiB != null)
                        {
                            x509crl = distributionpoint.aiB;
                            distributionpoint = new GeneralName[((GeneralNames) (x509crl)).ajb.length];
                            System.arraycopy(((GeneralNames) (x509crl)).ajb, 0, distributionpoint, 0, ((GeneralNames) (x509crl)).ajb.length);
                        } else
                        {
                            distributionpoint = new GeneralName[1];
                            try
                            {
                                distributionpoint[0] = new GeneralName(new X509Name((ASN1Sequence)ASN1Sequence._mth0640(CertPathValidatorUtilities._mth1D53(x509extension).getEncoded())));
                            }
                            // Misplaced declaration of an exception variable
                            catch (DistributionPoint distributionpoint)
                            {
                                throw new AnnotatedException("Could not read certificate issuer.", distributionpoint);
                            }
                        }
                        int j = 0;
                        do
                        {
                            x509crl = distributionpoint;
                            if (j >= distributionpoint.length)
                            {
                                break;
                            }
                            Object obj = ASN1Sequence._mth141F(((GeneralName) (distributionpoint[j])).Wn._mth0427())._mth0675();
                            x509crl = new ASN1EncodableVector();
                            ASN1Encodable asn1encodable1;
                            for (; ((Enumeration) (obj)).hasMoreElements(); ((ASN1EncodableVector) (x509crl)).VS.addElement(asn1encodable1))
                            {
                                asn1encodable1 = (ASN1Encodable)((Enumeration) (obj)).nextElement();
                            }

                            obj = distributionpointname1.aiC;
                            ((ASN1EncodableVector) (x509crl)).VS.addElement(obj);
                            distributionpoint[j] = new GeneralName(new X509Name(new DERSequence(x509crl)));
                            j++;
                        } while (true);
                    }
                    boolean flag = flag2;
                    if (x509crl != null)
                    {
                        int k = 0;
                        do
                        {
                            flag = flag2;
                            if (k >= x509crl.length)
                            {
                                break;
                            }
                            if (arraylist.contains(x509crl[k]))
                            {
                                flag = true;
                                break;
                            }
                            k++;
                        } while (true);
                    }
                    if (!flag)
                    {
                        throw new AnnotatedException("No match for certificate CRL issuing distribution point name to cRLIssuer CRL distribution point.");
                    }
                } else
                {
                    if (distributionpoint.aiB == null)
                    {
                        throw new AnnotatedException("Either the cRLIssuer or the distributionPoint field must be contained in DistributionPoint.");
                    }
                    distributionpoint = distributionpoint.aiB;
                    x509crl = new GeneralName[((GeneralNames) (distributionpoint)).ajb.length];
                    System.arraycopy(((GeneralNames) (distributionpoint)).ajb, 0, x509crl, 0, ((GeneralNames) (distributionpoint)).ajb.length);
                    int l = 0;
                    boolean flag1;
                    do
                    {
                        flag1 = flag3;
                        if (l >= x509crl.length)
                        {
                            break;
                        }
                        if (arraylist.contains(x509crl[l]))
                        {
                            flag1 = true;
                            break;
                        }
                        l++;
                    } while (true);
                    if (!flag1)
                    {
                        throw new AnnotatedException("No match for certificate CRL issuing distribution point name to cRLIssuer CRL distribution point.");
                    }
                }
            }
            try
            {
                distributionpoint = BasicConstraints._mth1FBE(CertPathValidatorUtilities._mth02CA((X509Extension)x509extension, aHS));
            }
            // Misplaced declaration of an exception variable
            catch (DistributionPoint distributionpoint)
            {
                throw new AnnotatedException("Basic constraints extension could not be decoded.", distributionpoint);
            }
            if (x509extension instanceof X509Certificate)
            {
                if (issuingdistributionpoint.ajm && distributionpoint != null && distributionpoint._mth09B6())
                {
                    throw new AnnotatedException("CA Cert CRL only contains user certificates.");
                }
                if (issuingdistributionpoint.ajn && (distributionpoint == null || !distributionpoint._mth09B6()))
                {
                    throw new AnnotatedException("End CRL only contains CA certificates.");
                }
            }
            if (issuingdistributionpoint.ajq)
            {
                throw new AnnotatedException("onlyContainsAttributeCerts boolean is asserted.");
            }
        }
    }

    private static void _mth02CA(DistributionPoint distributionpoint, ExtendedPKIXParameters extendedpkixparameters, X509Certificate x509certificate, Date date, X509Certificate x509certificate1, PublicKey publickey, CertStatus certstatus, ReasonsMask reasonsmask, 
            List list)
    {
        AnnotatedException annotatedexception;
        Date date1;
        Iterator iterator;
        boolean flag;
        date1 = new Date(System.currentTimeMillis());
        if (date.getTime() > date1.getTime())
        {
            throw new AnnotatedException("Validation time is in future.");
        }
        Set set = CertPathValidatorUtilities._mth02CA(distributionpoint, x509certificate, date1, extendedpkixparameters);
        flag = false;
        annotatedexception = null;
        iterator = set.iterator();
_L2:
        if (!iterator.hasNext() || certstatus.aHt != 11)
        {
            break; /* Loop/switch isn't completed */
        }
        boolean flag1;
        if (reasonsmask.aIc == ReasonsMask.aId.aIc)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj1;
        ReasonsMask reasonsmask1;
        int i;
        int j;
        int k;
        obj1 = (X509CRL)iterator.next();
        reasonsmask1 = _mth02CA(((X509CRL) (obj1)), distributionpoint);
        i = reasonsmask1.aIc;
        j = reasonsmask.aIc;
        k = reasonsmask1.aIc;
        boolean flag2;
        if ((i | j ^ k) != 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (!flag2)
        {
            continue; /* Loop/switch isn't completed */
        }
        PublicKey publickey1 = _mth02CA(((X509CRL) (obj1)), ((Set) (_mth02CA(((X509CRL) (obj1)), x509certificate1, publickey, extendedpkixparameters, list))));
        Object obj = null;
        if (extendedpkixparameters.aPS)
        {
            obj = _mth02CA(((Set) (CertPathValidatorUtilities._mth02CA(date1, extendedpkixparameters, ((X509CRL) (obj1))))), publickey1);
        }
        if (extendedpkixparameters.aPR != 1 && x509certificate.getNotAfter().getTime() < ((X509CRL) (obj1)).getThisUpdate().getTime())
        {
            throw new AnnotatedException("No valid CRL for current time found.");
        }
        _mth02CB(distributionpoint, x509certificate, ((X509CRL) (obj1)));
        _mth02CA(distributionpoint, ((X509Extension) (x509certificate)), ((X509CRL) (obj1)));
        _mth02CA(((X509CRL) (obj)), ((X509CRL) (obj1)), extendedpkixparameters);
        if (!extendedpkixparameters.aPS || obj == null)
        {
            break MISSING_BLOCK_LABEL_303;
        }
        CertPathValidatorUtilities._mth02CA(date, ((X509CRL) (obj)), x509certificate, certstatus);
        if (certstatus.aHt == 11)
        {
            CertPathValidatorUtilities._mth02CA(date, ((X509CRL) (obj1)), x509certificate, certstatus);
        }
        if (certstatus.aHt == 8)
        {
            certstatus.aHt = 11;
        }
        reasonsmask.aIc = reasonsmask.aIc | reasonsmask1.aIc;
        obj1 = ((X509CRL) (obj1)).getCriticalExtensionOIDs();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_427;
        }
        obj1 = new HashSet(((Collection) (obj1)));
        ((Set) (obj1)).remove(X509Extensions.aki.identifier);
        ((Set) (obj1)).remove(X509Extensions.akh.identifier);
        if (!((Set) (obj1)).isEmpty())
        {
            throw new AnnotatedException("CRL contains unsupported critical extensions.");
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_504;
        }
        obj = ((X509CRL) (obj)).getCriticalExtensionOIDs();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_504;
        }
        obj = new HashSet(((Collection) (obj)));
        ((Set) (obj)).remove(X509Extensions.aki.identifier);
        ((Set) (obj)).remove(X509Extensions.akh.identifier);
        if (!((Set) (obj)).isEmpty())
        {
            throw new AnnotatedException("Delta CRL contains unsupported critical extension.");
        }
        flag = true;
        continue; /* Loop/switch isn't completed */
        annotatedexception;
        if (true) goto _L2; else goto _L1
_L1:
        if (!flag)
        {
            throw annotatedexception;
        } else
        {
            return;
        }
    }

    private static void _mth02CA(ExtendedPKIXParameters extendedpkixparameters, X509Certificate x509certificate, Date date, X509Certificate x509certificate1, PublicKey publickey, List list)
    {
        ExtendedPKIXParameters extendedpkixparameters1;
        Object obj;
        CertStatus certstatus;
        ReasonsMask reasonsmask;
        CRLDistPoint crldistpoint;
        boolean flag;
        boolean flag2;
        extendedpkixparameters1 = null;
        obj = null;
        try
        {
            crldistpoint = CRLDistPoint._mth02BE(CertPathValidatorUtilities._mth02CA(x509certificate, aHT));
        }
        // Misplaced declaration of an exception variable
        catch (ExtendedPKIXParameters extendedpkixparameters)
        {
            throw new AnnotatedException("CRL distribution point extension could not be read.", extendedpkixparameters);
        }
        try
        {
            CertPathValidatorUtilities._mth02CA(crldistpoint, extendedpkixparameters);
        }
        // Misplaced declaration of an exception variable
        catch (ExtendedPKIXParameters extendedpkixparameters)
        {
            throw new AnnotatedException("No additional CRL locations could be decoded from CRL distribution point extension.", extendedpkixparameters);
        }
        certstatus = new CertStatus();
        reasonsmask = new ReasonsMask();
        flag = false;
        flag2 = false;
        if (crldistpoint == null) goto _L2; else goto _L1
_L1:
        DistributionPoint adistributionpoint[];
        int i;
        try
        {
            adistributionpoint = crldistpoint._mth09BD();
        }
        // Misplaced declaration of an exception variable
        catch (ExtendedPKIXParameters extendedpkixparameters)
        {
            throw new AnnotatedException("Distribution points could not be read.", extendedpkixparameters);
        }
        i = 0;
_L3:
        extendedpkixparameters1 = ((ExtendedPKIXParameters) (obj));
        flag = flag2;
        if (i >= adistributionpoint.length)
        {
            break; /* Loop/switch isn't completed */
        }
        extendedpkixparameters1 = ((ExtendedPKIXParameters) (obj));
        flag = flag2;
        if (certstatus.aHt != 11)
        {
            break; /* Loop/switch isn't completed */
        }
        boolean flag5;
        if (reasonsmask.aIc == ReasonsMask.aId.aIc)
        {
            flag5 = true;
        } else
        {
            flag5 = false;
        }
        extendedpkixparameters1 = ((ExtendedPKIXParameters) (obj));
        flag = flag2;
        if (flag5)
        {
            break; /* Loop/switch isn't completed */
        }
        extendedpkixparameters1 = (ExtendedPKIXParameters)extendedpkixparameters.clone();
        _mth02CA(adistributionpoint[i], extendedpkixparameters1, x509certificate, date, x509certificate1, publickey, certstatus, reasonsmask, list);
        flag2 = true;
        break MISSING_BLOCK_LABEL_219;
        obj;
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        boolean flag4;
        obj = extendedpkixparameters1;
        flag4 = flag;
        if (certstatus.aHt != 11)
        {
            break MISSING_BLOCK_LABEL_388;
        }
        boolean flag3;
        if (reasonsmask.aIc == ReasonsMask.aId.aIc)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        obj = extendedpkixparameters1;
        flag4 = flag;
        if (flag3)
        {
            break MISSING_BLOCK_LABEL_388;
        }
        obj = (new ASN1InputStream(CertPathValidatorUtilities._mth1D53(x509certificate).getEncoded()))._mth04B7();
        break MISSING_BLOCK_LABEL_317;
        extendedpkixparameters;
        throw new AnnotatedException("Issuer from certificate for CRL could not be reencoded.", extendedpkixparameters);
        _mth02CA(new DistributionPoint(new DistributionPointName(0, new GeneralNames(new GeneralName(4, ((org.spongycastle.asn1.ASN1Object) (obj))))), null, null), (ExtendedPKIXParameters)extendedpkixparameters.clone(), x509certificate, date, x509certificate1, publickey, certstatus, reasonsmask, list);
        flag4 = true;
        obj = extendedpkixparameters1;
        break MISSING_BLOCK_LABEL_388;
        obj;
        flag4 = flag;
        if (!flag4)
        {
            if (obj instanceof AnnotatedException)
            {
                throw obj;
            } else
            {
                throw new AnnotatedException("No valid CRL found.", ((Exception) (obj)));
            }
        }
        if (certstatus.aHt != 11)
        {
            extendedpkixparameters = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
            extendedpkixparameters.setTimeZone(TimeZone.getTimeZone("UTC"));
            extendedpkixparameters = (new StringBuilder("Certificate revocation after ")).append(extendedpkixparameters.format(certstatus.aHu)).toString();
            throw new AnnotatedException((new StringBuilder()).append(extendedpkixparameters).append(", reason: ").append(aHY[certstatus.aHt]).toString());
        }
        boolean flag1;
        if (reasonsmask.aIc == ReasonsMask.aId.aIc)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1 && certstatus.aHt == 11)
        {
            certstatus.aHt = 12;
        }
        if (certstatus.aHt == 12)
        {
            throw new AnnotatedException("Certificate status could not be determined.");
        } else
        {
            return;
        }
    }

    protected static int _mth02CB(CertPath certpath, int i, int j)
    {
        Object obj;
        obj = (X509Certificate)certpath.getCertificates().get(i);
        try
        {
            obj = DERSequence._mth141F(CertPathValidatorUtilities._mth02CA(((X509Extension) (obj)), aHR));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new ExtCertPathValidatorException("Policy constraints extension cannot be decoded.", ((Throwable) (obj)), certpath, i);
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        obj = ((ASN1Sequence) (obj))._mth0675();
_L2:
        if (!((Enumeration) (obj)).hasMoreElements())
        {
            break MISSING_BLOCK_LABEL_129;
        }
        ASN1TaggedObject asn1taggedobject = ASN1TaggedObject._mth142A(((Enumeration) (obj)).nextElement());
        if (asn1taggedobject.Wk != 1) goto _L2; else goto _L1
_L1:
        int k = (new BigInteger(ASN1Integer._mth02CB(asn1taggedobject, false).bytes)).intValue();
        if (k < j)
        {
            return k;
        } else
        {
            return j;
        }
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        throw new ExtCertPathValidatorException("Policy constraints extension contents cannot be decoded.", illegalargumentexception, certpath, i);
        return j;
    }

    protected static void _mth02CB(CertPath certpath, int i)
    {
        Object obj = (X509Certificate)certpath.getCertificates().get(i);
        try
        {
            obj = BasicConstraints._mth1FBE(CertPathValidatorUtilities._mth02CA(((X509Extension) (obj)), aHS));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new ExtCertPathValidatorException("Basic constraints extension cannot be decoded.", ((Throwable) (obj)), certpath, i);
        }
        if (obj != null)
        {
            if (!((BasicConstraints) (obj))._mth09B6())
            {
                throw new CertPathValidatorException("Not a CA certificate");
            } else
            {
                return;
            }
        } else
        {
            throw new CertPathValidatorException("Intermediate certificate lacks BasicConstraints");
        }
    }

    protected static void _mth02CB(CertPath certpath, int i, PKIXNameConstraintValidator pkixnameconstraintvalidator)
    {
        NameConstraints nameconstraints;
        Object obj = (X509Certificate)certpath.getCertificates().get(i);
        nameconstraints = null;
        try
        {
            obj = DERSequence._mth141F(CertPathValidatorUtilities._mth02CA(((X509Extension) (obj)), aHV));
        }
        // Misplaced declaration of an exception variable
        catch (PKIXNameConstraintValidator pkixnameconstraintvalidator)
        {
            throw new ExtCertPathValidatorException("Name constraints extension could not be decoded.", pkixnameconstraintvalidator, certpath, i);
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        nameconstraints = NameConstraints._mth02BB(((ASN1Sequence) (obj)));
        if (nameconstraints == null) goto _L2; else goto _L1
_L1:
        GeneralSubtree ageneralsubtree1[] = nameconstraints.aju;
        if (ageneralsubtree1 == null) goto _L4; else goto _L3
_L3:
        Iterator iterator;
        Object obj1;
        GeneralSubtree generalsubtree;
        Integer integer;
        int j;
        try
        {
            obj1 = new HashMap();
        }
        // Misplaced declaration of an exception variable
        catch (PKIXNameConstraintValidator pkixnameconstraintvalidator)
        {
            throw new ExtCertPathValidatorException("Permitted subtrees cannot be build from name constraints extension.", pkixnameconstraintvalidator, certpath, i);
        }
        j = 0;
        if (j == ageneralsubtree1.length)
        {
            break; /* Loop/switch isn't completed */
        }
        generalsubtree = ageneralsubtree1[j];
        integer = Integers.valueOf(generalsubtree.ajd.tag);
        if (((Map) (obj1)).get(integer) == null)
        {
            ((Map) (obj1)).put(integer, new HashSet());
        }
        ((Set)((Map) (obj1)).get(integer)).add(generalsubtree);
        j++;
        if (true) goto _L6; else goto _L5
_L6:
        break MISSING_BLOCK_LABEL_86;
_L5:
        iterator = ((Map) (obj1)).entrySet().iterator();
_L15:
        if (!iterator.hasNext()) goto _L4; else goto _L7
_L7:
        obj1 = (java.util.Map.Entry)iterator.next();
        ((Integer)((java.util.Map.Entry) (obj1)).getKey()).intValue();
        JVM INSTR tableswitch 1 7: default 461
    //                   1 264
    //                   2 289
    //                   3 385
    //                   4 314
    //                   5 385
    //                   6 338
    //                   7 363;
           goto _L8 _L9 _L10 _L8 _L11 _L8 _L12 _L13
_L9:
        pkixnameconstraintvalidator.aHF = pkixnameconstraintvalidator._mth02CB(pkixnameconstraintvalidator.aHF, (Set)((java.util.Map.Entry) (obj1)).getValue());
_L8:
        if (true) goto _L15; else goto _L14
_L14:
_L10:
        pkixnameconstraintvalidator.aHE = pkixnameconstraintvalidator._mth02CF(pkixnameconstraintvalidator.aHE, (Set)((java.util.Map.Entry) (obj1)).getValue());
          goto _L15
_L11:
        pkixnameconstraintvalidator.aHD = PKIXNameConstraintValidator._mth02CA(pkixnameconstraintvalidator.aHD, (Set)((java.util.Map.Entry) (obj1)).getValue());
          goto _L15
_L12:
        pkixnameconstraintvalidator.aHG = pkixnameconstraintvalidator._mth141D(pkixnameconstraintvalidator.aHG, (Set)((java.util.Map.Entry) (obj1)).getValue());
          goto _L15
_L13:
        pkixnameconstraintvalidator.aHH = pkixnameconstraintvalidator._mth02CE(pkixnameconstraintvalidator.aHH, (Set)((java.util.Map.Entry) (obj1)).getValue());
          goto _L15
_L4:
        GeneralSubtree ageneralsubtree[] = nameconstraints.ajv;
        if (ageneralsubtree != null)
        {
            for (int k = 0; k != ageneralsubtree.length; k++)
            {
                try
                {
                    pkixnameconstraintvalidator._mth02CA(ageneralsubtree[k]);
                }
                // Misplaced declaration of an exception variable
                catch (PKIXNameConstraintValidator pkixnameconstraintvalidator)
                {
                    throw new ExtCertPathValidatorException("Excluded subtrees cannot be build from name constraints extension.", pkixnameconstraintvalidator, certpath, i);
                }
            }

        }
_L2:
    }

    protected static void _mth02CB(DistributionPoint distributionpoint, X509Extension x509extension, X509CRL x509crl)
    {
        ASN1Primitive asn1primitive = CertPathValidatorUtilities._mth02CA(x509crl, aHr);
        int i = 0;
        boolean flag = i;
        if (asn1primitive != null)
        {
            flag = i;
            if (IssuingDistributionPoint._mth06E6(asn1primitive).ajp)
            {
                flag = true;
            }
        }
        byte abyte0[] = CertPathValidatorUtilities._mth02CA(x509crl).getEncoded();
        int j = 0;
        i = 0;
        if (distributionpoint.aiB != null)
        {
            distributionpoint = distributionpoint.aiB;
            x509extension = new GeneralName[((GeneralNames) (distributionpoint)).ajb.length];
            System.arraycopy(((GeneralNames) (distributionpoint)).ajb, 0, x509extension, 0, ((GeneralNames) (distributionpoint)).ajb.length);
            for (j = 0; j < x509extension.length;)
            {
                int k = i;
                if (((GeneralName) (x509extension[j])).tag == 4)
                {
                    boolean flag1;
                    try
                    {
                        flag1 = Arrays._mth1427(((GeneralName) (x509extension[j])).Wn._mth0427().getEncoded(), abyte0);
                    }
                    // Misplaced declaration of an exception variable
                    catch (DistributionPoint distributionpoint)
                    {
                        throw new AnnotatedException("CRL issuer information from distribution point cannot be decoded.", distributionpoint);
                    }
                    if (flag1)
                    {
                        i = 1;
                    }
                    k = i;
                }
                j++;
                i = k;
            }

            if (i != 0 && !flag)
            {
                throw new AnnotatedException("Distribution point contains cRLIssuer field but CRL is not indirect.");
            }
            if (i == 0)
            {
                throw new AnnotatedException("CRL issuer of CRL does not match CRL issuer of distribution point.");
            }
        } else
        {
            i = j;
            if (CertPathValidatorUtilities._mth02CA(x509crl).equals(CertPathValidatorUtilities._mth1D53(x509extension)))
            {
                i = 1;
            }
        }
        if (i == 0)
        {
            throw new AnnotatedException("Cannot find matching CRL issuer for certificate.");
        } else
        {
            return;
        }
    }

    protected static int _mth02CE(CertPath certpath, int i, int j)
    {
        Object obj = (X509Certificate)certpath.getCertificates().get(i);
        try
        {
            obj = ASN1Integer.FB1D(CertPathValidatorUtilities._mth02CA(((X509Extension) (obj)), aHP));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new ExtCertPathValidatorException("Inhibit any-policy extension cannot be decoded.", ((Throwable) (obj)), certpath, i);
        }
        if (obj != null)
        {
            i = (new BigInteger(((ASN1Integer) (obj)).bytes)).intValue();
            if (i < j)
            {
                return i;
            }
        }
        return j;
    }

    protected static void _mth02CE(CertPath certpath, int i)
    {
        boolean aflag[] = ((X509Certificate)certpath.getCertificates().get(i)).getKeyUsage();
        if (aflag != null && !aflag[5])
        {
            throw new ExtCertPathValidatorException("Issuer certificate keyusage extension is critical and does not permit key signing.", null, certpath, i);
        } else
        {
            return;
        }
    }

    protected static int _mth02CF(CertPath certpath, int i, int j)
    {
        if (!CertPathValidatorUtilities._mth02BD((X509Certificate)certpath.getCertificates().get(i)))
        {
            if (j <= 0)
            {
                throw new ExtCertPathValidatorException("Max path length not greater than zero", null, certpath, i);
            } else
            {
                return j - 1;
            }
        } else
        {
            return j;
        }
    }

    protected static int _mth037A(CertPath certpath, int i, int j)
    {
label0:
        {
            Object obj = (X509Certificate)certpath.getCertificates().get(i);
            try
            {
                obj = DERSequence._mth141F(CertPathValidatorUtilities._mth02CA(((X509Extension) (obj)), aHR));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new ExtCertPathValidatorException("Policy constraints could not be decoded.", ((Throwable) (obj)), certpath, i);
            }
            if (obj == null)
            {
                break label0;
            }
            obj = ((ASN1Sequence) (obj))._mth0675();
            int k;
label1:
            do
            {
                do
                {
                    if (!((Enumeration) (obj)).hasMoreElements())
                    {
                        break;
                    }
                    ASN1TaggedObject asn1taggedobject = (ASN1TaggedObject)((Enumeration) (obj)).nextElement();
                    switch (asn1taggedobject.Wk)
                    {
                    default:
                        break;

                    case 0: // '\0'
                        try
                        {
                            k = (new BigInteger(ASN1Integer._mth02CB(asn1taggedobject, false).bytes)).intValue();
                        }
                        catch (Exception exception)
                        {
                            throw new ExtCertPathValidatorException("Policy constraints requireExplicitPolicy field could not be decoded.", exception, certpath, i);
                        }
                        continue label1;
                    }
                } while (true);
                break label0;
            } while (k != 0);
            return 0;
        }
        return j;
    }

    protected static int _mth141D(CertPath certpath, int i, int j)
    {
        Object obj = (X509Certificate)certpath.getCertificates().get(i);
        try
        {
            obj = BasicConstraints._mth1FBE(CertPathValidatorUtilities._mth02CA(((X509Extension) (obj)), aHS));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new ExtCertPathValidatorException("Basic constraints extension cannot be decoded.", ((Throwable) (obj)), certpath, i);
        }
        if (obj != null)
        {
            if (((BasicConstraints) (obj)).ain != null)
            {
                certpath = new BigInteger(((BasicConstraints) (obj)).ain.bytes);
            } else
            {
                certpath = null;
            }
            if (certpath != null)
            {
                i = certpath.intValue();
                if (i < j)
                {
                    return i;
                }
            }
        }
        return j;
    }

    static 
    {
        new PKIXCRLUtil();
        aHN = X509Extensions.akl.identifier;
        aHO = X509Extensions.akm.identifier;
        aHP = X509Extensions.akq.identifier;
        aHr = X509Extensions.aki.identifier;
        ASN1ObjectIdentifier asn1objectidentifier = X509Extensions.akp;
        aHQ = X509Extensions.akh.identifier;
        aHR = X509Extensions.ako.identifier;
        aHS = X509Extensions.akf.identifier;
        aHT = X509Extensions.akk.identifier;
        aHU = X509Extensions.ake.identifier;
        aHV = X509Extensions.akj.identifier;
        aHW = X509Extensions.akn.identifier;
        aHX = X509Extensions.akd.identifier;
        asn1objectidentifier = X509Extensions.akg;
    }
}
