// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce;

import java.security.cert.CertStoreParameters;
import org.spongycastle.x509.X509StoreParameters;

public class X509LDAPCertStoreParameters
    implements X509StoreParameters, CertStoreParameters
{
    public static class Builder
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

        static String _mth02B3(Builder builder)
        {
            return builder.aGW;
        }

        static String _mth02B4(Builder builder)
        {
            return builder.aGX;
        }

        static String _mth02B9(Builder builder)
        {
            return builder.aGK;
        }

        static String _mth02BB(Builder builder)
        {
            return builder.aGt;
        }

        static String _mth02BC(Builder builder)
        {
            return builder.aGu;
        }

        static String _mth02BD(Builder builder)
        {
            return builder.aGv;
        }

        static String _mth02BE(Builder builder)
        {
            return builder.aGy;
        }

        static String _mth02BF(Builder builder)
        {
            return builder.aGz;
        }

        static String _mth02C8(Builder builder)
        {
            return builder.aGA;
        }

        static String _mth02C9(Builder builder)
        {
            return builder.aGB;
        }

        static String _mth02CA(Builder builder)
        {
            return builder.aGo;
        }

        static String _mth02CB(Builder builder)
        {
            return builder.aGp;
        }

        static String _mth02CC(Builder builder)
        {
            return builder.aGC;
        }

        static String _mth02CD(Builder builder)
        {
            return builder.aGD;
        }

        static String _mth02CE(Builder builder)
        {
            return builder.aGq;
        }

        static String _mth02CF(Builder builder)
        {
            return builder.aGr;
        }

        static String _mth02D1(Builder builder)
        {
            return builder.aGE;
        }

        static String _mth037A(Builder builder)
        {
            return builder.aGw;
        }

        static String _mth0559(Builder builder)
        {
            return builder.aGL;
        }

        static String _mth05D9(Builder builder)
        {
            return builder.aGM;
        }

        static String _mth0640(Builder builder)
        {
            return builder.aGF;
        }

        static String _mth0674(Builder builder)
        {
            return builder.aGN;
        }

        static String _mth141D(Builder builder)
        {
            return builder.aGs;
        }

        static String _mth1427(Builder builder)
        {
            return builder.aGG;
        }

        static String _mth1428(Builder builder)
        {
            return builder.aGH;
        }

        static String _mth1D35(Builder builder)
        {
            return builder.aGO;
        }

        static String _mth1D4E(Builder builder)
        {
            return builder.aGP;
        }

        static String _mth1D54(Builder builder)
        {
            return builder.aGQ;
        }

        static String _mth1D62(Builder builder)
        {
            return builder.aGR;
        }

        static String _mth1FBE(Builder builder)
        {
            return builder.aGx;
        }

        static String _mth2071(Builder builder)
        {
            return builder.aGS;
        }

        static String FE73(Builder builder)
        {
            return builder.aGI;
        }

        static String FE76(Builder builder)
        {
            return builder.aGT;
        }

        static String FE7A(Builder builder)
        {
            return builder.aGU;
        }

        static String FF70(Builder builder)
        {
            return builder.aGV;
        }

        static String FF9E(Builder builder)
        {
            return builder.aGJ;
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

        public Builder()
        {
            this("ldap://localhost:389", "");
        }

        public Builder(String s, String s1)
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


    public String aGA;
    public String aGB;
    public String aGC;
    public String aGD;
    public String aGE;
    public String aGF;
    public String aGG;
    public String aGH;
    public String aGI;
    public String aGJ;
    public String aGK;
    public String aGL;
    public String aGM;
    public String aGN;
    public String aGO;
    public String aGP;
    public String aGQ;
    public String aGR;
    public String aGS;
    public String aGT;
    public String aGU;
    public String aGV;
    public String aGW;
    public String aGX;
    public String aGo;
    public String aGp;
    public String aGq;
    public String aGr;
    public String aGs;
    public String aGt;
    public String aGu;
    public String aGv;
    public String aGw;
    public String aGx;
    public String aGy;
    public String aGz;

    private X509LDAPCertStoreParameters(Builder builder)
    {
        aGo = Builder._mth02CA(builder);
        aGp = Builder._mth02CB(builder);
        aGq = Builder._mth02CE(builder);
        aGr = Builder._mth02CF(builder);
        aGs = Builder._mth141D(builder);
        aGt = Builder._mth02BB(builder);
        aGu = Builder._mth02BC(builder);
        aGv = Builder._mth02BD(builder);
        aGw = Builder._mth037A(builder);
        aGx = Builder._mth1FBE(builder);
        aGy = Builder._mth02BE(builder);
        aGz = Builder._mth02BF(builder);
        aGA = Builder._mth02C8(builder);
        aGB = Builder._mth02C9(builder);
        aGC = Builder._mth02CC(builder);
        aGD = Builder._mth02CD(builder);
        aGE = Builder._mth02D1(builder);
        aGF = Builder._mth0640(builder);
        aGG = Builder._mth1427(builder);
        aGH = Builder._mth1428(builder);
        aGI = Builder.FE73(builder);
        aGJ = Builder.FF9E(builder);
        aGK = Builder._mth02B9(builder);
        aGL = Builder._mth0559(builder);
        aGM = Builder._mth05D9(builder);
        aGN = Builder._mth0674(builder);
        aGO = Builder._mth1D35(builder);
        aGP = Builder._mth1D4E(builder);
        aGQ = Builder._mth1D54(builder);
        aGR = Builder._mth1D62(builder);
        aGS = Builder._mth2071(builder);
        aGT = Builder.FE76(builder);
        aGU = Builder.FE7A(builder);
        aGV = Builder.FF70(builder);
        aGW = Builder._mth02B3(builder);
        aGX = Builder._mth02B4(builder);
    }

    X509LDAPCertStoreParameters(Builder builder, byte byte0)
    {
        this(builder);
    }

    public Object clone()
    {
        return this;
    }

    public int hashCode()
    {
        String s = aGq;
        int i;
        if (s == null)
        {
            i = 0;
        } else
        {
            i = s.hashCode();
        }
        s = aGr;
        int j;
        if (s == null)
        {
            j = 0;
        } else
        {
            j = s.hashCode();
        }
        s = aGs;
        int k;
        if (s == null)
        {
            k = 0;
        } else
        {
            k = s.hashCode();
        }
        s = aGt;
        int l;
        if (s == null)
        {
            l = 0;
        } else
        {
            l = s.hashCode();
        }
        s = aGu;
        int i1;
        if (s == null)
        {
            i1 = 0;
        } else
        {
            i1 = s.hashCode();
        }
        s = aGv;
        int j1;
        if (s == null)
        {
            j1 = 0;
        } else
        {
            j1 = s.hashCode();
        }
        s = aGw;
        int k1;
        if (s == null)
        {
            k1 = 0;
        } else
        {
            k1 = s.hashCode();
        }
        s = aGx;
        int l1;
        if (s == null)
        {
            l1 = 0;
        } else
        {
            l1 = s.hashCode();
        }
        s = aGy;
        int i2;
        if (s == null)
        {
            i2 = 0;
        } else
        {
            i2 = s.hashCode();
        }
        s = aGz;
        int j2;
        if (s == null)
        {
            j2 = 0;
        } else
        {
            j2 = s.hashCode();
        }
        s = aGA;
        int k2;
        if (s == null)
        {
            k2 = 0;
        } else
        {
            k2 = s.hashCode();
        }
        s = aGB;
        int l2;
        if (s == null)
        {
            l2 = 0;
        } else
        {
            l2 = s.hashCode();
        }
        s = aGC;
        int i3;
        if (s == null)
        {
            i3 = 0;
        } else
        {
            i3 = s.hashCode();
        }
        s = aGD;
        int j3;
        if (s == null)
        {
            j3 = 0;
        } else
        {
            j3 = s.hashCode();
        }
        s = aGE;
        int k3;
        if (s == null)
        {
            k3 = 0;
        } else
        {
            k3 = s.hashCode();
        }
        s = aGF;
        int l3;
        if (s == null)
        {
            l3 = 0;
        } else
        {
            l3 = s.hashCode();
        }
        s = aGG;
        int i4;
        if (s == null)
        {
            i4 = 0;
        } else
        {
            i4 = s.hashCode();
        }
        s = aGH;
        int j4;
        if (s == null)
        {
            j4 = 0;
        } else
        {
            j4 = s.hashCode();
        }
        s = aGI;
        int k4;
        if (s == null)
        {
            k4 = 0;
        } else
        {
            k4 = s.hashCode();
        }
        s = aGJ;
        int l4;
        if (s == null)
        {
            l4 = 0;
        } else
        {
            l4 = s.hashCode();
        }
        s = aGK;
        int i5;
        if (s == null)
        {
            i5 = 0;
        } else
        {
            i5 = s.hashCode();
        }
        s = aGL;
        int j5;
        if (s == null)
        {
            j5 = 0;
        } else
        {
            j5 = s.hashCode();
        }
        s = aGM;
        int k5;
        if (s == null)
        {
            k5 = 0;
        } else
        {
            k5 = s.hashCode();
        }
        s = aGN;
        int l5;
        if (s == null)
        {
            l5 = 0;
        } else
        {
            l5 = s.hashCode();
        }
        s = aGO;
        int i6;
        if (s == null)
        {
            i6 = 0;
        } else
        {
            i6 = s.hashCode();
        }
        s = aGP;
        int j6;
        if (s == null)
        {
            j6 = 0;
        } else
        {
            j6 = s.hashCode();
        }
        s = aGQ;
        int k6;
        if (s == null)
        {
            k6 = 0;
        } else
        {
            k6 = s.hashCode();
        }
        s = aGR;
        int l6;
        if (s == null)
        {
            l6 = 0;
        } else
        {
            l6 = s.hashCode();
        }
        s = aGS;
        int i7;
        if (s == null)
        {
            i7 = 0;
        } else
        {
            i7 = s.hashCode();
        }
        s = aGT;
        int j7;
        if (s == null)
        {
            j7 = 0;
        } else
        {
            j7 = s.hashCode();
        }
        s = aGU;
        int k7;
        if (s == null)
        {
            k7 = 0;
        } else
        {
            k7 = s.hashCode();
        }
        s = aGV;
        int l7;
        if (s == null)
        {
            l7 = 0;
        } else
        {
            l7 = s.hashCode();
        }
        s = aGW;
        int i8;
        if (s == null)
        {
            i8 = 0;
        } else
        {
            i8 = s.hashCode();
        }
        s = aGX;
        int j8;
        if (s == null)
        {
            j8 = 0;
        } else
        {
            j8 = s.hashCode();
        }
        return (((((((((((((((((((((((((((((((((i + 0) * 29 + j) * 29 + k) * 29 + l) * 29 + i1) * 29 + j1) * 29 + k1) * 29 + l1) * 29 + i2) * 29 + j2) * 29 + k2) * 29 + l2) * 29 + i3) * 29 + j3) * 29 + k3) * 29 + l3) * 29 + i4) * 29 + j4) * 29 + k4) * 29 + l4) * 29 + i5) * 29 + j5) * 29 + k5) * 29 + l5) * 29 + i6) * 29 + j6) * 29 + k6) * 29 + l6) * 29 + i7) * 29 + j7) * 29 + k7) * 29 + l7) * 29 + i8) * 29 + j8;
    }
}
