// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.teletrust;

import java.util.Hashtable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ECParametersHolder;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.util.Strings;

// Referenced classes of package org.spongycastle.asn1.teletrust:
//            TeleTrusTObjectIdentifiers

public class TeleTrusTNamedCurves
{

    private static Hashtable Yi;
    private static Hashtable Yj;
    private static _cls1 aeU;
    private static _cls2 aeV;
    private static _cls3 aeW;
    private static _cls4 aeX;
    private static _cls5 aeY;
    private static _cls6 aeZ;
    private static Hashtable aek;
    private static _cls7 afa;
    private static _cls8 afb;
    private static _cls9 afc;
    private static _cls10 afd;
    private static _cls11 afe;
    private static _cls12 aff;
    private static _cls13 afg;
    private static _cls14 afh;

    public TeleTrusTNamedCurves()
    {
    }

    static ECCurve _mth02CA(org.spongycastle.math.ec.ECCurve.Fp fp)
    {
        return fp;
    }

    public static String _mth02CE(ASN1ObjectIdentifier asn1objectidentifier)
    {
        return (String)Yj.get(asn1objectidentifier);
    }

    public static X9ECParameters _mth141D(ASN1ObjectIdentifier asn1objectidentifier)
    {
        asn1objectidentifier = (X9ECParametersHolder)aek.get(asn1objectidentifier);
        if (asn1objectidentifier != null)
        {
            return asn1objectidentifier.getParameters();
        } else
        {
            return null;
        }
    }

    public static ASN1ObjectIdentifier _mth1422(String s)
    {
        return (ASN1ObjectIdentifier)Yi.get(Strings.FE91(s));
    }

    public static X9ECParameters _mth14BB(String s)
    {
        s = (ASN1ObjectIdentifier)Yi.get(Strings.FE91(s));
        if (s != null)
        {
            s = (X9ECParametersHolder)aek.get(s);
            if (s != null)
            {
                return s.getParameters();
            } else
            {
                return null;
            }
        } else
        {
            return null;
        }
    }

    static 
    {
        aeU = new _cls1();
        aeV = new _cls2();
        aeW = new _cls3();
        aeX = new _cls4();
        aeY = new _cls5();
        aeZ = new _cls6();
        afa = new _cls7();
        afb = new _cls8();
        afc = new _cls9();
        afd = new _cls10();
        afe = new _cls11();
        aff = new _cls12();
        afg = new _cls13();
        afh = new _cls14();
        Yi = new Hashtable();
        aek = new Hashtable();
        Yj = new Hashtable();
        ASN1ObjectIdentifier asn1objectidentifier = TeleTrusTObjectIdentifiers.afv;
        Object obj = aeU;
        Yi.put("brainpoolp160r1", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "brainpoolp160r1");
        aek.put(asn1objectidentifier, obj);
        asn1objectidentifier = TeleTrusTObjectIdentifiers.afw;
        obj = aeV;
        Yi.put("brainpoolp160t1", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "brainpoolp160t1");
        aek.put(asn1objectidentifier, obj);
        asn1objectidentifier = TeleTrusTObjectIdentifiers.afx;
        obj = aeW;
        Yi.put("brainpoolp192r1", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "brainpoolp192r1");
        aek.put(asn1objectidentifier, obj);
        asn1objectidentifier = TeleTrusTObjectIdentifiers.afy;
        obj = aeX;
        Yi.put("brainpoolp192t1", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "brainpoolp192t1");
        aek.put(asn1objectidentifier, obj);
        asn1objectidentifier = TeleTrusTObjectIdentifiers.afz;
        obj = aeY;
        Yi.put("brainpoolp224r1", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "brainpoolp224r1");
        aek.put(asn1objectidentifier, obj);
        asn1objectidentifier = TeleTrusTObjectIdentifiers.afA;
        obj = aeZ;
        Yi.put("brainpoolp224t1", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "brainpoolp224t1");
        aek.put(asn1objectidentifier, obj);
        asn1objectidentifier = TeleTrusTObjectIdentifiers.afB;
        obj = afa;
        Yi.put("brainpoolp256r1", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "brainpoolp256r1");
        aek.put(asn1objectidentifier, obj);
        asn1objectidentifier = TeleTrusTObjectIdentifiers.afC;
        obj = afb;
        Yi.put("brainpoolp256t1", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "brainpoolp256t1");
        aek.put(asn1objectidentifier, obj);
        asn1objectidentifier = TeleTrusTObjectIdentifiers.afD;
        obj = afc;
        Yi.put("brainpoolp320r1", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "brainpoolp320r1");
        aek.put(asn1objectidentifier, obj);
        asn1objectidentifier = TeleTrusTObjectIdentifiers.afE;
        obj = afd;
        Yi.put("brainpoolp320t1", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "brainpoolp320t1");
        aek.put(asn1objectidentifier, obj);
        asn1objectidentifier = TeleTrusTObjectIdentifiers.afF;
        obj = afe;
        Yi.put("brainpoolp384r1", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "brainpoolp384r1");
        aek.put(asn1objectidentifier, obj);
        asn1objectidentifier = TeleTrusTObjectIdentifiers.afG;
        obj = aff;
        Yi.put("brainpoolp384t1", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "brainpoolp384t1");
        aek.put(asn1objectidentifier, obj);
        asn1objectidentifier = TeleTrusTObjectIdentifiers.afH;
        obj = afg;
        Yi.put("brainpoolp512r1", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "brainpoolp512r1");
        aek.put(asn1objectidentifier, obj);
        asn1objectidentifier = TeleTrusTObjectIdentifiers.afI;
        obj = afh;
        Yi.put("brainpoolp512t1", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "brainpoolp512t1");
        aek.put(asn1objectidentifier, obj);
    }

    private class _cls1 extends X9ECParametersHolder
    {

        protected final X9ECParameters _mth098C()
        {
            BigInteger biginteger = new BigInteger("E95E4A5F737059DC60DF5991D45029409E60FC09", 16);
            BigInteger biginteger1 = new BigInteger("01", 16);
            ECCurve eccurve = TeleTrusTNamedCurves._mth02CA(new org.spongycastle.math.ec.ECCurve.Fp(new BigInteger("E95E4A5F737059DC60DFC7AD95B3D8139515620F", 16), new BigInteger("340E7BE2A280EB74E2BE61BADA745D97E8F7C300", 16), new BigInteger("1E589A8595423412134FAA2DBDEC95C8D8675E58", 16), biginteger, biginteger1));
            return new X9ECParameters(eccurve, eccurve._mth01C3(Hex._mth1508("04BED5AF16EA3F6A4F62938C4631EB5AF7BDBCDBC31667CB477A1A8EC338F94741669C976316DA6321")), biginteger, biginteger1);
        }

        _cls1()
        {
        }
    }


    private class _cls2 extends X9ECParametersHolder
    {

        protected final X9ECParameters _mth098C()
        {
            BigInteger biginteger = new BigInteger("E95E4A5F737059DC60DF5991D45029409E60FC09", 16);
            BigInteger biginteger1 = new BigInteger("01", 16);
            ECCurve eccurve = TeleTrusTNamedCurves._mth02CA(new org.spongycastle.math.ec.ECCurve.Fp(new BigInteger("E95E4A5F737059DC60DFC7AD95B3D8139515620F", 16), new BigInteger("E95E4A5F737059DC60DFC7AD95B3D8139515620C", 16), new BigInteger("7A556B6DAE535B7B51ED2C4D7DAA7A0B5C55F380", 16), biginteger, biginteger1));
            return new X9ECParameters(eccurve, eccurve._mth01C3(Hex._mth1508("04B199B13B9B34EFC1397E64BAEB05ACC265FF2378ADD6718B7C7C1961F0991B842443772152C9E0AD")), biginteger, biginteger1);
        }

        _cls2()
        {
        }
    }


    private class _cls3 extends X9ECParametersHolder
    {

        protected final X9ECParameters _mth098C()
        {
            BigInteger biginteger = new BigInteger("C302F41D932A36CDA7A3462F9E9E916B5BE8F1029AC4ACC1", 16);
            BigInteger biginteger1 = new BigInteger("01", 16);
            ECCurve eccurve = TeleTrusTNamedCurves._mth02CA(new org.spongycastle.math.ec.ECCurve.Fp(new BigInteger("C302F41D932A36CDA7A3463093D18DB78FCE476DE1A86297", 16), new BigInteger("6A91174076B1E0E19C39C031FE8685C1CAE040E5C69A28EF", 16), new BigInteger("469A28EF7C28CCA3DC721D044F4496BCCA7EF4146FBF25C9", 16), biginteger, biginteger1));
            return new X9ECParameters(eccurve, eccurve._mth01C3(Hex._mth1508("04C0A0647EAAB6A48753B033C56CB0F0900A2F5C4853375FD614B690866ABD5BB88B5F4828C1490002E6773FA2FA299B8F")), biginteger, biginteger1);
        }

        _cls3()
        {
        }
    }


    private class _cls4 extends X9ECParametersHolder
    {

        protected final X9ECParameters _mth098C()
        {
            BigInteger biginteger = new BigInteger("C302F41D932A36CDA7A3462F9E9E916B5BE8F1029AC4ACC1", 16);
            BigInteger biginteger1 = new BigInteger("01", 16);
            ECCurve eccurve = TeleTrusTNamedCurves._mth02CA(new org.spongycastle.math.ec.ECCurve.Fp(new BigInteger("C302F41D932A36CDA7A3463093D18DB78FCE476DE1A86297", 16), new BigInteger("C302F41D932A36CDA7A3463093D18DB78FCE476DE1A86294", 16), new BigInteger("13D56FFAEC78681E68F9DEB43B35BEC2FB68542E27897B79", 16), biginteger, biginteger1));
            return new X9ECParameters(eccurve, eccurve._mth01C3(Hex._mth1508("043AE9E58C82F63C30282E1FE7BBF43FA72C446AF6F4618129097E2C5667C2223A902AB5CA449D0084B7E5B3DE7CCC01C9")), biginteger, biginteger1);
        }

        _cls4()
        {
        }
    }


    private class _cls5 extends X9ECParametersHolder
    {

        protected final X9ECParameters _mth098C()
        {
            BigInteger biginteger = new BigInteger("D7C134AA264366862A18302575D0FB98D116BC4B6DDEBCA3A5A7939F", 16);
            BigInteger biginteger1 = new BigInteger("01", 16);
            ECCurve eccurve = TeleTrusTNamedCurves._mth02CA(new org.spongycastle.math.ec.ECCurve.Fp(new BigInteger("D7C134AA264366862A18302575D1D787B09F075797DA89F57EC8C0FF", 16), new BigInteger("68A5E62CA9CE6C1C299803A6C1530B514E182AD8B0042A59CAD29F43", 16), new BigInteger("2580F63CCFE44138870713B1A92369E33E2135D266DBB372386C400B", 16), biginteger, biginteger1));
            return new X9ECParameters(eccurve, eccurve._mth01C3(Hex._mth1508("040D9029AD2C7E5CF4340823B2A87DC68C9E4CE3174C1E6EFDEE12C07D58AA56F772C0726F24C6B89E4ECDAC24354B9E99CAA3F6D3761402CD")), biginteger, biginteger1);
        }

        _cls5()
        {
        }
    }


    private class _cls6 extends X9ECParametersHolder
    {

        protected final X9ECParameters _mth098C()
        {
            BigInteger biginteger = new BigInteger("D7C134AA264366862A18302575D0FB98D116BC4B6DDEBCA3A5A7939F", 16);
            BigInteger biginteger1 = new BigInteger("01", 16);
            ECCurve eccurve = TeleTrusTNamedCurves._mth02CA(new org.spongycastle.math.ec.ECCurve.Fp(new BigInteger("D7C134AA264366862A18302575D1D787B09F075797DA89F57EC8C0FF", 16), new BigInteger("D7C134AA264366862A18302575D1D787B09F075797DA89F57EC8C0FC", 16), new BigInteger("4B337D934104CD7BEF271BF60CED1ED20DA14C08B3BB64F18A60888D", 16), biginteger, biginteger1));
            return new X9ECParameters(eccurve, eccurve._mth01C3(Hex._mth1508("046AB1E344CE25FF3896424E7FFE14762ECB49F8928AC0C76029B4D5800374E9F5143E568CD23F3F4D7C0D4B1E41C8CC0D1C6ABD5F1A46DB4C")), biginteger, biginteger1);
        }

        _cls6()
        {
        }
    }


    private class _cls7 extends X9ECParametersHolder
    {

        protected final X9ECParameters _mth098C()
        {
            BigInteger biginteger = new BigInteger("A9FB57DBA1EEA9BC3E660A909D838D718C397AA3B561A6F7901E0E82974856A7", 16);
            BigInteger biginteger1 = new BigInteger("01", 16);
            ECCurve eccurve = TeleTrusTNamedCurves._mth02CA(new org.spongycastle.math.ec.ECCurve.Fp(new BigInteger("A9FB57DBA1EEA9BC3E660A909D838D726E3BF623D52620282013481D1F6E5377", 16), new BigInteger("7D5A0975FC2C3057EEF67530417AFFE7FB8055C126DC5C6CE94A4B44F330B5D9", 16), new BigInteger("26DC5C6CE94A4B44F330B5D9BBD77CBF958416295CF7E1CE6BCCDC18FF8C07B6", 16), biginteger, biginteger1));
            return new X9ECParameters(eccurve, eccurve._mth01C3(Hex._mth1508("048BD2AEB9CB7E57CB2C4B482FFC81B7AFB9DE27E1E3BD23C23A4453BD9ACE3262547EF835C3DAC4FD97F8461A14611DC9C27745132DED8E545C1D54C72F046997")), biginteger, biginteger1);
        }

        _cls7()
        {
        }
    }


    private class _cls8 extends X9ECParametersHolder
    {

        protected final X9ECParameters _mth098C()
        {
            BigInteger biginteger = new BigInteger("A9FB57DBA1EEA9BC3E660A909D838D718C397AA3B561A6F7901E0E82974856A7", 16);
            BigInteger biginteger1 = new BigInteger("01", 16);
            ECCurve eccurve = TeleTrusTNamedCurves._mth02CA(new org.spongycastle.math.ec.ECCurve.Fp(new BigInteger("A9FB57DBA1EEA9BC3E660A909D838D726E3BF623D52620282013481D1F6E5377", 16), new BigInteger("A9FB57DBA1EEA9BC3E660A909D838D726E3BF623D52620282013481D1F6E5374", 16), new BigInteger("662C61C430D84EA4FE66A7733D0B76B7BF93EBC4AF2F49256AE58101FEE92B04", 16), biginteger, biginteger1));
            return new X9ECParameters(eccurve, eccurve._mth01C3(Hex._mth1508("04A3E8EB3CC1CFE7B7732213B23A656149AFA142C47AAFBC2B79A191562E1305F42D996C823439C56D7F7B22E14644417E69BCB6DE39D027001DABE8F35B25C9BE")), biginteger, biginteger1);
        }

        _cls8()
        {
        }
    }


    private class _cls9 extends X9ECParametersHolder
    {

        protected final X9ECParameters _mth098C()
        {
            BigInteger biginteger = new BigInteger("D35E472036BC4FB7E13C785ED201E065F98FCFA5B68F12A32D482EC7EE8658E98691555B44C59311", 16);
            BigInteger biginteger1 = new BigInteger("01", 16);
            ECCurve eccurve = TeleTrusTNamedCurves._mth02CA(new org.spongycastle.math.ec.ECCurve.Fp(new BigInteger("D35E472036BC4FB7E13C785ED201E065F98FCFA6F6F40DEF4F92B9EC7893EC28FCD412B1F1B32E27", 16), new BigInteger("3EE30B568FBAB0F883CCEBD46D3F3BB8A2A73513F5EB79DA66190EB085FFA9F492F375A97D860EB4", 16), new BigInteger("520883949DFDBC42D3AD198640688A6FE13F41349554B49ACC31DCCD884539816F5EB4AC8FB1F1A6", 16), biginteger, biginteger1));
            return new X9ECParameters(eccurve, eccurve._mth01C3(Hex._mth1508("0443BD7E9AFB53D8B85289BCC48EE5BFE6F20137D10A087EB6E7871E2A10A599C710AF8D0D39E2061114FDD05545EC1CC8AB4093247F77275E0743FFED117182EAA9C77877AAAC6AC7D35245D1692E8EE1")), biginteger, biginteger1);
        }

        _cls9()
        {
        }
    }


    private class _cls10 extends X9ECParametersHolder
    {

        protected final X9ECParameters _mth098C()
        {
            BigInteger biginteger = new BigInteger("D35E472036BC4FB7E13C785ED201E065F98FCFA5B68F12A32D482EC7EE8658E98691555B44C59311", 16);
            BigInteger biginteger1 = new BigInteger("01", 16);
            ECCurve eccurve = TeleTrusTNamedCurves._mth02CA(new org.spongycastle.math.ec.ECCurve.Fp(new BigInteger("D35E472036BC4FB7E13C785ED201E065F98FCFA6F6F40DEF4F92B9EC7893EC28FCD412B1F1B32E27", 16), new BigInteger("D35E472036BC4FB7E13C785ED201E065F98FCFA6F6F40DEF4F92B9EC7893EC28FCD412B1F1B32E24", 16), new BigInteger("A7F561E038EB1ED560B3D147DB782013064C19F27ED27C6780AAF77FB8A547CEB5B4FEF422340353", 16), biginteger, biginteger1));
            return new X9ECParameters(eccurve, eccurve._mth01C3(Hex._mth1508("04925BE9FB01AFC6FB4D3E7D4990010F813408AB106C4F09CB7EE07868CC136FFF3357F624A21BED5263BA3A7A27483EBF6671DBEF7ABB30EBEE084E58A0B077AD42A5A0989D1EE71B1B9BC0455FB0D2C3")), biginteger, biginteger1);
        }

        _cls10()
        {
        }
    }


    private class _cls11 extends X9ECParametersHolder
    {

        protected final X9ECParameters _mth098C()
        {
            BigInteger biginteger = new BigInteger("8CB91E82A3386D280F5D6F7E50E641DF152F7109ED5456B31F166E6CAC0425A7CF3AB6AF6B7FC3103B883202E9046565", 16);
            BigInteger biginteger1 = new BigInteger("01", 16);
            ECCurve eccurve = TeleTrusTNamedCurves._mth02CA(new org.spongycastle.math.ec.ECCurve.Fp(new BigInteger("8CB91E82A3386D280F5D6F7E50E641DF152F7109ED5456B412B1DA197FB71123ACD3A729901D1A71874700133107EC53", 16), new BigInteger("7BC382C63D8C150C3C72080ACE05AFA0C2BEA28E4FB22787139165EFBA91F90F8AA5814A503AD4EB04A8C7DD22CE2826", 16), new BigInteger("4A8C7DD22CE28268B39B55416F0447C2FB77DE107DCD2A62E880EA53EEB62D57CB4390295DBC9943AB78696FA504C11", 16), biginteger, biginteger1));
            return new X9ECParameters(eccurve, eccurve._mth01C3(Hex._mth1508("041D1C64F068CF45FFA2A63A81B7C13F6B8847A3E77EF14FE3DB7FCAFE0CBD10E8E826E03436D646AAEF87B2E247D4AF1E8ABE1D7520F9C2A45CB1EB8E95CFD55262B70B29FEEC5864E19C054FF99129280E4646217791811142820341263C5315")), biginteger, biginteger1);
        }

        _cls11()
        {
        }
    }


    private class _cls12 extends X9ECParametersHolder
    {

        protected final X9ECParameters _mth098C()
        {
            BigInteger biginteger = new BigInteger("8CB91E82A3386D280F5D6F7E50E641DF152F7109ED5456B31F166E6CAC0425A7CF3AB6AF6B7FC3103B883202E9046565", 16);
            BigInteger biginteger1 = new BigInteger("01", 16);
            ECCurve eccurve = TeleTrusTNamedCurves._mth02CA(new org.spongycastle.math.ec.ECCurve.Fp(new BigInteger("8CB91E82A3386D280F5D6F7E50E641DF152F7109ED5456B412B1DA197FB71123ACD3A729901D1A71874700133107EC53", 16), new BigInteger("8CB91E82A3386D280F5D6F7E50E641DF152F7109ED5456B412B1DA197FB71123ACD3A729901D1A71874700133107EC50", 16), new BigInteger("7F519EADA7BDA81BD826DBA647910F8C4B9346ED8CCDC64E4B1ABD11756DCE1D2074AA263B88805CED70355A33B471EE", 16), biginteger, biginteger1));
            return new X9ECParameters(eccurve, eccurve._mth01C3(Hex._mth1508("0418DE98B02DB9A306F2AFCD7235F72A819B80AB12EBD653172476FECD462AABFFC4FF191B946A5F54D8D0AA2F418808CC25AB056962D30651A114AFD2755AD336747F93475B7A1FCA3B88F2B6A208CCFE469408584DC2B2912675BF5B9E582928")), biginteger, biginteger1);
        }

        _cls12()
        {
        }
    }


    private class _cls13 extends X9ECParametersHolder
    {

        protected final X9ECParameters _mth098C()
        {
            BigInteger biginteger = new BigInteger("AADD9DB8DBE9C48B3FD4E6AE33C9FC07CB308DB3B3C9D20ED6639CCA70330870553E5C414CA92619418661197FAC10471DB1D381085DDADDB58796829CA90069", 16);
            BigInteger biginteger1 = new BigInteger("01", 16);
            ECCurve eccurve = TeleTrusTNamedCurves._mth02CA(new org.spongycastle.math.ec.ECCurve.Fp(new BigInteger("AADD9DB8DBE9C48B3FD4E6AE33C9FC07CB308DB3B3C9D20ED6639CCA703308717D4D9B009BC66842AECDA12AE6A380E62881FF2F2D82C68528AA6056583A48F3", 16), new BigInteger("7830A3318B603B89E2327145AC234CC594CBDD8D3DF91610A83441CAEA9863BC2DED5D5AA8253AA10A2EF1C98B9AC8B57F1117A72BF2C7B9E7C1AC4D77FC94CA", 16), new BigInteger("3DF91610A83441CAEA9863BC2DED5D5AA8253AA10A2EF1C98B9AC8B57F1117A72BF2C7B9E7C1AC4D77FC94CADC083E67984050B75EBAE5DD2809BD638016F723", 16), biginteger, biginteger1));
            return new X9ECParameters(eccurve, eccurve._mth01C3(Hex._mth1508("0481AEE4BDD82ED9645A21322E9C4C6A9385ED9F70B5D916C1B43B62EEF4D0098EFF3B1F78E2D0D48D50D1687B93B97D5F7C6D5047406A5E688B352209BCB9F8227DDE385D566332ECC0EABFA9CF7822FDF209F70024A57B1AA000C55B881F8111B2DCDE494A5F485E5BCA4BD88A2763AED1CA2B2FA8F0540678CD1E0F3AD80892")), biginteger, biginteger1);
        }

        _cls13()
        {
        }
    }


    private class _cls14 extends X9ECParametersHolder
    {

        protected final X9ECParameters _mth098C()
        {
            BigInteger biginteger = new BigInteger("AADD9DB8DBE9C48B3FD4E6AE33C9FC07CB308DB3B3C9D20ED6639CCA70330870553E5C414CA92619418661197FAC10471DB1D381085DDADDB58796829CA90069", 16);
            BigInteger biginteger1 = new BigInteger("01", 16);
            ECCurve eccurve = TeleTrusTNamedCurves._mth02CA(new org.spongycastle.math.ec.ECCurve.Fp(new BigInteger("AADD9DB8DBE9C48B3FD4E6AE33C9FC07CB308DB3B3C9D20ED6639CCA703308717D4D9B009BC66842AECDA12AE6A380E62881FF2F2D82C68528AA6056583A48F3", 16), new BigInteger("AADD9DB8DBE9C48B3FD4E6AE33C9FC07CB308DB3B3C9D20ED6639CCA703308717D4D9B009BC66842AECDA12AE6A380E62881FF2F2D82C68528AA6056583A48F0", 16), new BigInteger("7CBBBCF9441CFAB76E1890E46884EAE321F70C0BCB4981527897504BEC3E36A62BCDFA2304976540F6450085F2DAE145C22553B465763689180EA2571867423E", 16), biginteger, biginteger1));
            return new X9ECParameters(eccurve, eccurve._mth01C3(Hex._mth1508("04640ECE5C12788717B9C1BA06CBC2A6FEBA85842458C56DDE9DB1758D39C0313D82BA51735CDB3EA499AA77A7D6943A64F7A3F25FE26F06B51BAA2696FA9035DA5B534BD595F5AF0FA2C892376C84ACE1BB4E3019B71634C01131159CAE03CEE9D9932184BEEF216BD71DF2DADF86A627306ECFF96DBB8BACE198B61E00F8B332")), biginteger, biginteger1);
        }

        _cls14()
        {
        }
    }

}
