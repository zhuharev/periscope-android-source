// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x500.style;

import java.util.Hashtable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.x500.RDN;
import org.spongycastle.asn1.x500.X500Name;

// Referenced classes of package org.spongycastle.asn1.x500.style:
//            AbstractX500NameStyle, IETFUtils

public class RFC4519Style extends AbstractX500NameStyle
{

    private static final Hashtable agS;
    private static final Hashtable agT;
    private static ASN1ObjectIdentifier agX;
    private static ASN1ObjectIdentifier agY;
    private static ASN1ObjectIdentifier agZ;
    private static ASN1ObjectIdentifier ahA;
    private static ASN1ObjectIdentifier ahB;
    private static ASN1ObjectIdentifier ahC;
    private static ASN1ObjectIdentifier ahD;
    private static ASN1ObjectIdentifier ahE;
    private static ASN1ObjectIdentifier ahF;
    private static ASN1ObjectIdentifier ahG;
    private static ASN1ObjectIdentifier ahH;
    private static ASN1ObjectIdentifier ahI;
    private static ASN1ObjectIdentifier ahJ;
    private static ASN1ObjectIdentifier ahK;
    private static ASN1ObjectIdentifier ahL;
    private static ASN1ObjectIdentifier ahM;
    private static ASN1ObjectIdentifier ahN;
    public static final RFC4519Style ahO = new RFC4519Style();
    private static ASN1ObjectIdentifier aha;
    private static ASN1ObjectIdentifier ahb;
    private static ASN1ObjectIdentifier ahc;
    private static ASN1ObjectIdentifier ahd;
    private static ASN1ObjectIdentifier ahe;
    private static ASN1ObjectIdentifier ahf;
    private static ASN1ObjectIdentifier ahg;
    private static ASN1ObjectIdentifier ahh;
    private static ASN1ObjectIdentifier ahi;
    private static ASN1ObjectIdentifier ahj;
    private static ASN1ObjectIdentifier ahk;
    private static ASN1ObjectIdentifier ahl;
    private static ASN1ObjectIdentifier ahm;
    private static ASN1ObjectIdentifier ahn;
    private static ASN1ObjectIdentifier aho;
    private static ASN1ObjectIdentifier ahp;
    private static ASN1ObjectIdentifier ahq;
    private static ASN1ObjectIdentifier ahr;
    private static ASN1ObjectIdentifier ahs;
    private static ASN1ObjectIdentifier aht;
    private static ASN1ObjectIdentifier ahu;
    private static ASN1ObjectIdentifier ahv;
    private static ASN1ObjectIdentifier ahw;
    private static ASN1ObjectIdentifier ahx;
    private static ASN1ObjectIdentifier ahy;
    private static ASN1ObjectIdentifier ahz;
    private Hashtable agV;
    private Hashtable agW;

    protected RFC4519Style()
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
        for (int i = ardn.length - 1; i >= 0; i--)
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
        agX = new ASN1ObjectIdentifier("2.5.4.15");
        agY = new ASN1ObjectIdentifier("2.5.4.6");
        agZ = new ASN1ObjectIdentifier("2.5.4.3");
        aha = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
        ahb = new ASN1ObjectIdentifier("2.5.4.13");
        ahc = new ASN1ObjectIdentifier("2.5.4.27");
        ahd = new ASN1ObjectIdentifier("2.5.4.49");
        ahe = new ASN1ObjectIdentifier("2.5.4.46");
        ahf = new ASN1ObjectIdentifier("2.5.4.47");
        ahg = new ASN1ObjectIdentifier("2.5.4.23");
        ahh = new ASN1ObjectIdentifier("2.5.4.44");
        ahi = new ASN1ObjectIdentifier("2.5.4.42");
        ahj = new ASN1ObjectIdentifier("2.5.4.51");
        ahk = new ASN1ObjectIdentifier("2.5.4.43");
        ahl = new ASN1ObjectIdentifier("2.5.4.25");
        ahm = new ASN1ObjectIdentifier("2.5.4.7");
        ahn = new ASN1ObjectIdentifier("2.5.4.31");
        aho = new ASN1ObjectIdentifier("2.5.4.41");
        ahp = new ASN1ObjectIdentifier("2.5.4.10");
        ahq = new ASN1ObjectIdentifier("2.5.4.11");
        ahr = new ASN1ObjectIdentifier("2.5.4.32");
        ahs = new ASN1ObjectIdentifier("2.5.4.19");
        aht = new ASN1ObjectIdentifier("2.5.4.16");
        ahu = new ASN1ObjectIdentifier("2.5.4.17");
        ahv = new ASN1ObjectIdentifier("2.5.4.18");
        ahw = new ASN1ObjectIdentifier("2.5.4.28");
        ahx = new ASN1ObjectIdentifier("2.5.4.26");
        ahy = new ASN1ObjectIdentifier("2.5.4.33");
        ahz = new ASN1ObjectIdentifier("2.5.4.14");
        ahA = new ASN1ObjectIdentifier("2.5.4.34");
        ahB = new ASN1ObjectIdentifier("2.5.4.5");
        ahC = new ASN1ObjectIdentifier("2.5.4.4");
        ahD = new ASN1ObjectIdentifier("2.5.4.8");
        ahE = new ASN1ObjectIdentifier("2.5.4.9");
        ahF = new ASN1ObjectIdentifier("2.5.4.20");
        ahG = new ASN1ObjectIdentifier("2.5.4.22");
        ahH = new ASN1ObjectIdentifier("2.5.4.21");
        ahI = new ASN1ObjectIdentifier("2.5.4.12");
        ahJ = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
        ahK = new ASN1ObjectIdentifier("2.5.4.50");
        ahL = new ASN1ObjectIdentifier("2.5.4.35");
        ahM = new ASN1ObjectIdentifier("2.5.4.24");
        ahN = new ASN1ObjectIdentifier("2.5.4.45");
        agS = new Hashtable();
        agT = new Hashtable();
        agS.put(agX, "businessCategory");
        agS.put(agY, "c");
        agS.put(agZ, "cn");
        agS.put(aha, "dc");
        agS.put(ahb, "description");
        agS.put(ahc, "destinationIndicator");
        agS.put(ahd, "distinguishedName");
        agS.put(ahe, "dnQualifier");
        agS.put(ahf, "enhancedSearchGuide");
        agS.put(ahg, "facsimileTelephoneNumber");
        agS.put(ahh, "generationQualifier");
        agS.put(ahi, "givenName");
        agS.put(ahj, "houseIdentifier");
        agS.put(ahk, "initials");
        agS.put(ahl, "internationalISDNNumber");
        agS.put(ahm, "l");
        agS.put(ahn, "member");
        agS.put(aho, "name");
        agS.put(ahp, "o");
        agS.put(ahq, "ou");
        agS.put(ahr, "owner");
        agS.put(ahs, "physicalDeliveryOfficeName");
        agS.put(aht, "postalAddress");
        agS.put(ahu, "postalCode");
        agS.put(ahv, "postOfficeBox");
        agS.put(ahw, "preferredDeliveryMethod");
        agS.put(ahx, "registeredAddress");
        agS.put(ahy, "roleOccupant");
        agS.put(ahz, "searchGuide");
        agS.put(ahA, "seeAlso");
        agS.put(ahB, "serialNumber");
        agS.put(ahC, "sn");
        agS.put(ahD, "st");
        agS.put(ahE, "street");
        agS.put(ahF, "telephoneNumber");
        agS.put(ahG, "teletexTerminalIdentifier");
        agS.put(ahH, "telexNumber");
        agS.put(ahI, "title");
        agS.put(ahJ, "uid");
        agS.put(ahK, "uniqueMember");
        agS.put(ahL, "userPassword");
        agS.put(ahM, "x121Address");
        agS.put(ahN, "x500UniqueIdentifier");
        agT.put("businesscategory", agX);
        agT.put("c", agY);
        agT.put("cn", agZ);
        agT.put("dc", aha);
        agT.put("description", ahb);
        agT.put("destinationindicator", ahc);
        agT.put("distinguishedname", ahd);
        agT.put("dnqualifier", ahe);
        agT.put("enhancedsearchguide", ahf);
        agT.put("facsimiletelephonenumber", ahg);
        agT.put("generationqualifier", ahh);
        agT.put("givenname", ahi);
        agT.put("houseidentifier", ahj);
        agT.put("initials", ahk);
        agT.put("internationalisdnnumber", ahl);
        agT.put("l", ahm);
        agT.put("member", ahn);
        agT.put("name", aho);
        agT.put("o", ahp);
        agT.put("ou", ahq);
        agT.put("owner", ahr);
        agT.put("physicaldeliveryofficename", ahs);
        agT.put("postaladdress", aht);
        agT.put("postalcode", ahu);
        agT.put("postofficebox", ahv);
        agT.put("preferreddeliverymethod", ahw);
        agT.put("registeredaddress", ahx);
        agT.put("roleoccupant", ahy);
        agT.put("searchguide", ahz);
        agT.put("seealso", ahA);
        agT.put("serialnumber", ahB);
        agT.put("sn", ahC);
        agT.put("st", ahD);
        agT.put("street", ahE);
        agT.put("telephonenumber", ahF);
        agT.put("teletexterminalidentifier", ahG);
        agT.put("telexnumber", ahH);
        agT.put("title", ahI);
        agT.put("uid", ahJ);
        agT.put("uniquemember", ahK);
        agT.put("userpassword", ahL);
        agT.put("x121address", ahM);
        agT.put("x500uniqueidentifier", ahN);
    }
}
