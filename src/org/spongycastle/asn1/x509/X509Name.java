// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1String;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.DERUniversalString;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;

// Referenced classes of package org.spongycastle.asn1.x509:
//            X509ObjectIdentifiers, X509NameEntryConverter

public class X509Name extends ASN1Object
{

    private static final Boolean FALSE = new Boolean(false);
    private static final Boolean TRUE = new Boolean(true);
    private static ASN1ObjectIdentifier agA;
    public static final ASN1ObjectIdentifier agB;
    private static ASN1ObjectIdentifier agC;
    public static final ASN1ObjectIdentifier agD;
    private static ASN1ObjectIdentifier agE;
    private static ASN1ObjectIdentifier agF;
    private static ASN1ObjectIdentifier agG;
    private static ASN1ObjectIdentifier agH;
    private static ASN1ObjectIdentifier agI;
    private static ASN1ObjectIdentifier agJ;
    public static final ASN1ObjectIdentifier agK;
    private static ASN1ObjectIdentifier agL;
    public static final ASN1ObjectIdentifier agM;
    private static ASN1ObjectIdentifier agN;
    private static ASN1ObjectIdentifier agO;
    private static ASN1ObjectIdentifier agP;
    public static final ASN1ObjectIdentifier agQ;
    private static ASN1ObjectIdentifier agR;
    private static Hashtable agS;
    private static Hashtable agT;
    public static final ASN1ObjectIdentifier agl;
    private static ASN1ObjectIdentifier agm;
    private static ASN1ObjectIdentifier agn;
    private static ASN1ObjectIdentifier ago;
    private static ASN1ObjectIdentifier agp;
    public static final ASN1ObjectIdentifier agq;
    private static ASN1ObjectIdentifier agr;
    private static ASN1ObjectIdentifier ags;
    private static ASN1ObjectIdentifier agt;
    private static ASN1ObjectIdentifier agu;
    private static ASN1ObjectIdentifier agv;
    private static ASN1ObjectIdentifier agw;
    private static ASN1ObjectIdentifier agx;
    private static ASN1ObjectIdentifier agy;
    private static ASN1ObjectIdentifier agz;
    private static boolean akv = false;
    private static Hashtable akw;
    private static Hashtable akx;
    private ASN1Sequence adC;
    private boolean agf;
    private int agg;
    private Vector aiZ;
    private Vector akA;
    private X509NameEntryConverter aky;
    private Vector akz;

    protected X509Name()
    {
        aky = null;
        aiZ = new Vector();
        akz = new Vector();
        akA = new Vector();
    }

    public X509Name(ASN1Sequence asn1sequence)
    {
        aky = null;
        aiZ = new Vector();
        akz = new Vector();
        akA = new Vector();
        adC = asn1sequence;
        for (Enumeration enumeration = asn1sequence._mth0675(); enumeration.hasMoreElements();)
        {
            ASN1Set asn1set = ASN1Set._mth1421(((ASN1Encodable)enumeration.nextElement())._mth0427());
            int i = 0;
            while (i < asn1set.Wf.size()) 
            {
                asn1sequence = ASN1Sequence._mth141F(((ASN1Encodable)asn1set.Wf.elementAt(i))._mth0427());
                if (asn1sequence.size() != 2)
                {
                    throw new IllegalArgumentException("badly sized pair");
                }
                aiZ.addElement(ASN1ObjectIdentifier._mth02CE(asn1sequence._mth144B(0)));
                asn1sequence = asn1sequence._mth144B(1);
                if ((asn1sequence instanceof ASN1String) && !(asn1sequence instanceof DERUniversalString))
                {
                    asn1sequence = ((ASN1String)asn1sequence).getString();
                    if (asn1sequence.length() > 0 && asn1sequence.charAt(0) == '#')
                    {
                        akz.addElement((new StringBuilder("\\")).append(asn1sequence).toString());
                    } else
                    {
                        akz.addElement(asn1sequence);
                    }
                } else
                {
                    try
                    {
                        akz.addElement((new StringBuilder("#")).append(_mth1427(Hex._mth1D65(asn1sequence._mth0427().getEncoded("DER")))).toString());
                    }
                    // Misplaced declaration of an exception variable
                    catch (ASN1Sequence asn1sequence)
                    {
                        throw new IllegalArgumentException("cannot encode value");
                    }
                }
                Vector vector = akA;
                if (i != 0)
                {
                    asn1sequence = TRUE;
                } else
                {
                    asn1sequence = FALSE;
                }
                vector.addElement(asn1sequence);
                i++;
            }
        }

    }

    private static void _mth02CA(StringBuffer stringbuffer, Hashtable hashtable, ASN1ObjectIdentifier asn1objectidentifier, String s)
    {
        hashtable = (String)hashtable.get(asn1objectidentifier);
        if (hashtable != null)
        {
            stringbuffer.append(hashtable);
        } else
        {
            stringbuffer.append(asn1objectidentifier.identifier);
        }
        stringbuffer.append('=');
        int l = stringbuffer.length();
        stringbuffer.append(s);
        int k = stringbuffer.length();
        int i = l;
        int j = k;
        if (s.length() >= 2)
        {
            i = l;
            j = k;
            if (s.charAt(0) == '\\')
            {
                i = l;
                j = k;
                if (s.charAt(1) == '#')
                {
                    i = l + 2;
                    j = k;
                }
            }
        }
        do
        {
            l = j;
            if (i >= j)
            {
                break;
            }
            l = j;
            if (stringbuffer.charAt(i) != ' ')
            {
                break;
            }
            stringbuffer.insert(i, "\\");
            i += 2;
            j++;
        } while (true);
        do
        {
            l--;
            j = i;
            k = l;
            if (l <= i)
            {
                break;
            }
            j = i;
            k = l;
            if (stringbuffer.charAt(l) != ' ')
            {
                break;
            }
            stringbuffer.insert(l, '\\');
        } while (true);
        do
        {
            if (j > k)
            {
                break;
            }
            switch (stringbuffer.charAt(j))
            {
            case 34: // '"'
            case 43: // '+'
            case 44: // ','
            case 59: // ';'
            case 60: // '<'
            case 61: // '='
            case 62: // '>'
            case 92: // '\\'
                stringbuffer.insert(j, "\\");
                j += 2;
                k++;
                break;

            default:
                j++;
                break;
            }
        } while (true);
    }

    private static String _mth1427(byte abyte0[])
    {
        char ac[] = new char[abyte0.length];
        for (int i = 0; i != ac.length; i++)
        {
            ac[i] = (char)(abyte0[i] & 0xff);
        }

        return new String(ac);
    }

    private String _mth1509(String s)
    {
        String s1 = Strings.FE91(s.trim());
        s = s1;
        if (s1.length() > 0)
        {
            s = s1;
            if (s1.charAt(0) == '#')
            {
                ASN1Primitive asn1primitive = _mth150A(s1);
                s = s1;
                if (asn1primitive instanceof ASN1String)
                {
                    s = Strings.FE91(((ASN1String)asn1primitive).getString().trim());
                }
            }
        }
        return s;
    }

    private static ASN1Primitive _mth150A(String s)
    {
        try
        {
            s = ASN1Primitive._mth0640(Hex._mth1508(s.substring(1)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalStateException((new StringBuilder("unknown encoding in name: ")).append(s).toString());
        }
        return s;
    }

    private static String _mth150B(String s)
    {
        StringBuffer stringbuffer = new StringBuffer();
        if (s.length() != 0)
        {
            char c = s.charAt(0);
            stringbuffer.append(c);
            int i = 1;
            char c2 = c;
            for (; i < s.length(); i++)
            {
                char c1 = s.charAt(i);
                if (c2 != ' ' || c1 != ' ')
                {
                    stringbuffer.append(c1);
                }
                c2 = c1;
            }

        }
        return stringbuffer.toString();
    }

    public static X509Name _mth1D4C(Object obj)
    {
        if (obj == null || (obj instanceof X509Name))
        {
            return (X509Name)obj;
        }
        if (obj instanceof X500Name)
        {
            return new X509Name(ASN1Sequence._mth141F(((X500Name)obj)._mth0427()));
        }
        if (obj != null)
        {
            return new X509Name(ASN1Sequence._mth141F(obj));
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
        if (!(obj instanceof X509Name) && !(obj instanceof ASN1Sequence))
        {
            return false;
        }
        ASN1Primitive asn1primitive = ((ASN1Encodable)obj)._mth0427();
        if (_mth0427().equals(asn1primitive))
        {
            return true;
        }
        try
        {
            obj = _mth1D4C(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        int l = aiZ.size();
        if (l != ((X509Name) (obj)).aiZ.size())
        {
            return false;
        }
        boolean aflag[] = new boolean[l];
        int i;
        int j;
        byte byte0;
        if (aiZ.elementAt(0).equals(((X509Name) (obj)).aiZ.elementAt(0)))
        {
            i = 0;
            j = l;
            byte0 = 1;
        } else
        {
            i = l - 1;
            j = -1;
            byte0 = -1;
        }
        for (; i != j; i += byte0)
        {
            boolean flag1 = false;
            ASN1ObjectIdentifier asn1objectidentifier = (ASN1ObjectIdentifier)aiZ.elementAt(i);
            String s = (String)akz.elementAt(i);
            int k = 0;
            boolean flag;
            do
            {
                flag = flag1;
                if (k >= l)
                {
                    break;
                }
                if (!aflag[k] && asn1objectidentifier.equals((ASN1ObjectIdentifier)((X509Name) (obj)).aiZ.elementAt(k)))
                {
                    String s2 = (String)((X509Name) (obj)).akz.elementAt(k);
                    String s1 = _mth1509(s);
                    s2 = _mth1509(s2);
                    if (!s1.equals(s2) && !_mth150B(s1).equals(_mth150B(s2)))
                    {
                        flag = false;
                    } else
                    {
                        flag = true;
                    }
                    if (flag)
                    {
                        aflag[k] = true;
                        flag = true;
                        break;
                    }
                }
                k++;
            } while (true);
            if (!flag)
            {
                return false;
            }
        }

        return true;
    }

    public int hashCode()
    {
        if (agf)
        {
            return agg;
        }
        agf = true;
        for (int i = 0; i != aiZ.size(); i++)
        {
            String s = _mth150B(_mth1509((String)akz.elementAt(i)));
            agg = agg ^ aiZ.elementAt(i).hashCode();
            agg = agg ^ s.hashCode();
        }

        return agg;
    }

    public String toString()
    {
        Hashtable hashtable = agS;
        StringBuffer stringbuffer1 = new StringBuffer();
        Vector vector = new Vector();
        boolean flag = true;
        StringBuffer stringbuffer = null;
        for (int i = 0; i < aiZ.size(); i++)
        {
            if (((Boolean)akA.elementAt(i)).booleanValue())
            {
                stringbuffer.append('+');
                _mth02CA(stringbuffer, hashtable, (ASN1ObjectIdentifier)aiZ.elementAt(i), (String)akz.elementAt(i));
            } else
            {
                stringbuffer = new StringBuffer();
                _mth02CA(stringbuffer, hashtable, (ASN1ObjectIdentifier)aiZ.elementAt(i), (String)akz.elementAt(i));
                vector.addElement(stringbuffer);
            }
        }

        for (int j = 0; j < vector.size(); j++)
        {
            if (flag)
            {
                flag = false;
            } else
            {
                stringbuffer1.append(',');
            }
            stringbuffer1.append(vector.elementAt(j).toString());
        }

        return stringbuffer1.toString();
    }

    public final Vector _mth02BB(ASN1ObjectIdentifier asn1objectidentifier)
    {
        Vector vector = new Vector();
        for (int i = 0; i != akz.size(); i++)
        {
            if (!aiZ.elementAt(i).equals(asn1objectidentifier))
            {
                continue;
            }
            String s = (String)akz.elementAt(i);
            if (s.length() > 2 && s.charAt(0) == '\\' && s.charAt(1) == '#')
            {
                vector.addElement(s.substring(1));
            } else
            {
                vector.addElement(s);
            }
        }

        return vector;
    }

    public final ASN1Primitive _mth0427()
    {
        if (adC == null)
        {
            Object obj = new ASN1EncodableVector();
            Object obj1 = new ASN1EncodableVector();
            if (aiZ.size() != 0)
            {
                obj1 = new ASN1EncodableVector();
                obj = (ASN1ObjectIdentifier)aiZ.elementAt(0);
                ((ASN1EncodableVector) (obj1)).VS.addElement(obj);
                obj = (String)akz.elementAt(0);
                throw new NullPointerException();
            }
            obj1 = new DERSet(((ASN1EncodableVector) (obj1)));
            ((ASN1EncodableVector) (obj)).VS.addElement(obj1);
            adC = new DERSequence(((ASN1EncodableVector) (obj)));
        }
        return adC;
    }

    static 
    {
        agl = new ASN1ObjectIdentifier("2.5.4.6");
        agm = new ASN1ObjectIdentifier("2.5.4.10");
        agn = new ASN1ObjectIdentifier("2.5.4.11");
        ago = new ASN1ObjectIdentifier("2.5.4.12");
        agp = new ASN1ObjectIdentifier("2.5.4.3");
        agq = new ASN1ObjectIdentifier("2.5.4.5");
        agr = new ASN1ObjectIdentifier("2.5.4.9");
        ags = new ASN1ObjectIdentifier("2.5.4.7");
        agt = new ASN1ObjectIdentifier("2.5.4.8");
        agu = new ASN1ObjectIdentifier("2.5.4.4");
        agv = new ASN1ObjectIdentifier("2.5.4.42");
        agw = new ASN1ObjectIdentifier("2.5.4.43");
        agx = new ASN1ObjectIdentifier("2.5.4.44");
        agy = new ASN1ObjectIdentifier("2.5.4.45");
        agz = new ASN1ObjectIdentifier("2.5.4.15");
        agA = new ASN1ObjectIdentifier("2.5.4.17");
        agB = new ASN1ObjectIdentifier("2.5.4.46");
        agC = new ASN1ObjectIdentifier("2.5.4.65");
        agD = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.1");
        agE = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.2");
        agF = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.3");
        agG = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.4");
        agH = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.5");
        agI = new ASN1ObjectIdentifier("1.3.36.8.3.14");
        agJ = new ASN1ObjectIdentifier("2.5.4.16");
        new ASN1ObjectIdentifier("2.5.4.54");
        agK = X509ObjectIdentifiers.akB;
        agL = X509ObjectIdentifiers.akC;
        agM = PKCSObjectIdentifiers.abP;
        agN = PKCSObjectIdentifiers.abQ;
        agO = PKCSObjectIdentifiers.abV;
        agP = agM;
        agQ = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
        agR = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
        agS = new Hashtable();
        akw = new Hashtable();
        akx = new Hashtable();
        agT = new Hashtable();
        agS.put(agl, "C");
        agS.put(agm, "O");
        agS.put(ago, "T");
        agS.put(agn, "OU");
        agS.put(agp, "CN");
        agS.put(ags, "L");
        agS.put(agt, "ST");
        agS.put(agq, "SERIALNUMBER");
        agS.put(agM, "E");
        agS.put(agQ, "DC");
        agS.put(agR, "UID");
        agS.put(agr, "STREET");
        agS.put(agu, "SURNAME");
        agS.put(agv, "GIVENNAME");
        agS.put(agw, "INITIALS");
        agS.put(agx, "GENERATION");
        agS.put(agO, "unstructuredAddress");
        agS.put(agN, "unstructuredName");
        agS.put(agy, "UniqueIdentifier");
        agS.put(agB, "DN");
        agS.put(agC, "Pseudonym");
        agS.put(agJ, "PostalAddress");
        agS.put(agI, "NameAtBirth");
        agS.put(agG, "CountryOfCitizenship");
        agS.put(agH, "CountryOfResidence");
        agS.put(agF, "Gender");
        agS.put(agE, "PlaceOfBirth");
        agS.put(agD, "DateOfBirth");
        agS.put(agA, "PostalCode");
        agS.put(agz, "BusinessCategory");
        agS.put(agK, "TelephoneNumber");
        agS.put(agL, "Name");
        akw.put(agl, "C");
        akw.put(agm, "O");
        akw.put(agn, "OU");
        akw.put(agp, "CN");
        akw.put(ags, "L");
        akw.put(agt, "ST");
        akw.put(agr, "STREET");
        akw.put(agQ, "DC");
        akw.put(agR, "UID");
        akx.put(agl, "C");
        akx.put(agm, "O");
        akx.put(agn, "OU");
        akx.put(agp, "CN");
        akx.put(ags, "L");
        akx.put(agt, "ST");
        akx.put(agr, "STREET");
        agT.put("c", agl);
        agT.put("o", agm);
        agT.put("t", ago);
        agT.put("ou", agn);
        agT.put("cn", agp);
        agT.put("l", ags);
        agT.put("st", agt);
        agT.put("sn", agq);
        agT.put("serialnumber", agq);
        agT.put("street", agr);
        agT.put("emailaddress", agP);
        agT.put("dc", agQ);
        agT.put("e", agP);
        agT.put("uid", agR);
        agT.put("surname", agu);
        agT.put("givenname", agv);
        agT.put("initials", agw);
        agT.put("generation", agx);
        agT.put("unstructuredaddress", agO);
        agT.put("unstructuredname", agN);
        agT.put("uniqueidentifier", agy);
        agT.put("dn", agB);
        agT.put("pseudonym", agC);
        agT.put("postaladdress", agJ);
        agT.put("nameofbirth", agI);
        agT.put("countryofcitizenship", agG);
        agT.put("countryofresidence", agH);
        agT.put("gender", agF);
        agT.put("placeofbirth", agE);
        agT.put("dateofbirth", agD);
        agT.put("postalcode", agA);
        agT.put("businesscategory", agz);
        agT.put("telephonenumber", agK);
        agT.put("name", agL);
    }
}
