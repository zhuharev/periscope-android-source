// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x500.style;

import java.util.Hashtable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x500.RDN;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;

// Referenced classes of package org.spongycastle.asn1.x500.style:
//            AbstractX500NameStyle, IETFUtils

public class BCStyle extends AbstractX500NameStyle
{

    private static ASN1ObjectIdentifier agA;
    private static ASN1ObjectIdentifier agB;
    private static ASN1ObjectIdentifier agC;
    private static ASN1ObjectIdentifier agD;
    private static ASN1ObjectIdentifier agE;
    private static ASN1ObjectIdentifier agF;
    private static ASN1ObjectIdentifier agG;
    private static ASN1ObjectIdentifier agH;
    private static ASN1ObjectIdentifier agI;
    private static ASN1ObjectIdentifier agJ;
    private static ASN1ObjectIdentifier agK;
    private static ASN1ObjectIdentifier agL;
    private static ASN1ObjectIdentifier agM;
    private static ASN1ObjectIdentifier agN;
    private static ASN1ObjectIdentifier agO;
    private static ASN1ObjectIdentifier agP;
    private static ASN1ObjectIdentifier agQ;
    private static ASN1ObjectIdentifier agR;
    private static final Hashtable agS;
    private static final Hashtable agT;
    public static final BCStyle agU = new BCStyle();
    private static ASN1ObjectIdentifier agl;
    private static ASN1ObjectIdentifier agm;
    private static ASN1ObjectIdentifier agn;
    private static ASN1ObjectIdentifier ago;
    private static ASN1ObjectIdentifier agp;
    private static ASN1ObjectIdentifier agq;
    private static ASN1ObjectIdentifier agr;
    private static ASN1ObjectIdentifier ags;
    private static ASN1ObjectIdentifier agt;
    private static ASN1ObjectIdentifier agu;
    private static ASN1ObjectIdentifier agv;
    private static ASN1ObjectIdentifier agw;
    private static ASN1ObjectIdentifier agx;
    private static ASN1ObjectIdentifier agy;
    private static ASN1ObjectIdentifier agz;
    private Hashtable agV;
    private Hashtable agW;

    protected BCStyle()
    {
        agW = _mth02BC(agS);
        agV = _mth02BC(agT);
    }

    public final String _mth02CB(X500Name x500name)
    {
        StringBuffer stringbuffer = new StringBuffer();
        boolean flag = true;
        RDN ardn[] = new RDN[x500name.agi.length];
        System.arraycopy(x500name.agi, 0, ardn, 0, ardn.length);
        for (int i = 0; i < ardn.length; i++)
        {
            if (flag)
            {
                flag = false;
            } else
            {
                stringbuffer.append(',');
            }
            IETFUtils._mth02CA(stringbuffer, ardn[i], agW);
        }

        return stringbuffer.toString();
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
