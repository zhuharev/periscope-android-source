// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce;


// Referenced classes of package org.spongycastle.jce:
//            X509LDAPCertStoreParameters

public static class aGX
{

    private String aGA;
    private String aGB;
    private String aGC;
    private String aGD;
    private String aGE;
    private String aGF;
    private String aGG;
    private String aGH;
    private String aGI;
    private String aGJ;
    private String aGK;
    private String aGL;
    private String aGM;
    private String aGN;
    private String aGO;
    private String aGP;
    private String aGQ;
    private String aGR;
    private String aGS;
    private String aGT;
    private String aGU;
    private String aGV;
    private String aGW;
    private String aGX;
    private String aGo;
    private String aGp;
    private String aGq;
    private String aGr;
    private String aGs;
    private String aGt;
    private String aGu;
    private String aGv;
    private String aGw;
    private String aGx;
    private String aGy;
    private String aGz;

    static String _mth02B3(aGX agx)
    {
        return agx.aGW;
    }

    static String _mth02B4(aGW agw)
    {
        return agw.aGX;
    }

    static String _mth02B9(aGX agx)
    {
        return agx.aGK;
    }

    static String _mth02BB(aGK agk)
    {
        return agk.aGt;
    }

    static String _mth02BC(aGt agt)
    {
        return agt.aGu;
    }

    static String _mth02BD(aGu agu)
    {
        return agu.aGv;
    }

    static String _mth02BE(aGv agv)
    {
        return agv.aGy;
    }

    static String _mth02BF(aGy agy)
    {
        return agy.aGz;
    }

    static String _mth02C8(aGz agz)
    {
        return agz.aGA;
    }

    static String _mth02C9(aGA aga)
    {
        return aga.aGB;
    }

    static String _mth02CA(aGB agb)
    {
        return agb.aGo;
    }

    static String _mth02CB(aGo ago)
    {
        return ago.aGp;
    }

    static String _mth02CC(aGp agp)
    {
        return agp.aGC;
    }

    static String _mth02CD(aGC agc)
    {
        return agc.aGD;
    }

    static String _mth02CE(aGD agd)
    {
        return agd.aGq;
    }

    static String _mth02CF(aGq agq)
    {
        return agq.aGr;
    }

    static String _mth02D1(aGr agr)
    {
        return agr.aGE;
    }

    static String _mth037A(aGE age)
    {
        return age.aGw;
    }

    static String _mth0559(aGw agw)
    {
        return agw.aGL;
    }

    static String _mth05D9(aGL agl)
    {
        return agl.aGM;
    }

    static String _mth0640(aGM agm)
    {
        return agm.aGF;
    }

    static String _mth0674(aGF agf)
    {
        return agf.aGN;
    }

    static String _mth141D(aGN agn)
    {
        return agn.aGs;
    }

    static String _mth1427(aGs ags)
    {
        return ags.aGG;
    }

    static String _mth1428(aGG agg)
    {
        return agg.aGH;
    }

    static String _mth1D35(aGH agh)
    {
        return agh.aGO;
    }

    static String _mth1D4E(aGO ago)
    {
        return ago.aGP;
    }

    static String _mth1D54(aGP agp)
    {
        return agp.aGQ;
    }

    static String _mth1D62(aGQ agq)
    {
        return agq.aGR;
    }

    static String _mth1FBE(aGR agr)
    {
        return agr.aGx;
    }

    static String _mth2071(aGx agx)
    {
        return agx.aGS;
    }

    static String FE73(aGS ags)
    {
        return ags.aGI;
    }

    static String FE76(aGI agi)
    {
        return agi.aGT;
    }

    static String FE7A(aGT agt)
    {
        return agt.aGU;
    }

    static String FF70(aGU agu)
    {
        return agu.aGV;
    }

    static String FF9E(aGV agv)
    {
        return agv.aGJ;
    }

    public final X509LDAPCertStoreParameters _mth1D18()
    {
        if (aGB == null || aGC == null || aGD == null || aGE == null || aGF == null || aGG == null || aGH == null || aGI == null || aGJ == null || aGK == null || aGL == null || aGM == null || aGN == null || aGO == null || aGP == null || aGQ == null || aGR == null || aGS == null || aGT == null || aGU == null || aGV == null || aGW == null)
        {
            throw new IllegalArgumentException("Necessary parameters not specified.");
        } else
        {
            return new X509LDAPCertStoreParameters(this, (byte)0);
        }
    }

    public ()
    {
        this("ldap://localhost:389", "");
    }

    public <init>(String s, String s1)
    {
        aGo = s;
        if (s1 == null)
        {
            aGp = "";
        } else
        {
            aGp = s1;
        }
        aGq = "userCertificate";
        aGr = "cACertificate";
        aGs = "crossCertificatePair";
        aGt = "certificateRevocationList";
        aGu = "deltaRevocationList";
        aGv = "authorityRevocationList";
        aGw = "attributeCertificateAttribute";
        aGx = "aACertificate";
        aGy = "attributeDescriptorCertificate";
        aGz = "attributeCertificateRevocationList";
        aGA = "attributeAuthorityRevocationList";
        aGB = "cn";
        aGC = "cn ou o";
        aGD = "cn ou o";
        aGE = "cn ou o";
        aGF = "cn ou o";
        aGG = "cn ou o";
        aGH = "cn";
        aGI = "cn o ou";
        aGJ = "cn o ou";
        aGK = "cn o ou";
        aGL = "cn o ou";
        aGM = "cn";
        aGN = "o ou";
        aGO = "o ou";
        aGP = "o ou";
        aGQ = "o ou";
        aGR = "o ou";
        aGS = "cn";
        aGT = "o ou";
        aGU = "o ou";
        aGV = "o ou";
        aGW = "o ou";
        aGX = "uid serialNumber cn";
    }
}
