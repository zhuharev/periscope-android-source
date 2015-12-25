// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.util.Strings;

public class DigestFactory
{

    private static HashSet aGb;
    private static HashSet aGc;
    private static HashSet aGd;
    private static HashSet aGe;
    private static HashSet aGf;
    private static HashSet aGg;
    private static HashMap aGh;

    public DigestFactory()
    {
    }

    public static ASN1ObjectIdentifier _mth1422(String s)
    {
        return (ASN1ObjectIdentifier)aGh.get(s);
    }

    public static boolean _mth1428(String s, String s1)
    {
        return aGc.contains(s) && aGc.contains(s1) || aGd.contains(s) && aGd.contains(s1) || aGe.contains(s) && aGe.contains(s1) || aGf.contains(s) && aGf.contains(s1) || aGg.contains(s) && aGg.contains(s1) || aGb.contains(s) && aGb.contains(s1);
    }

    public static ExtendedDigest FB4B(String s)
    {
        s = Strings.FE7C(s);
        if (aGc.contains(s))
        {
            return new SHA1Digest();
        }
        if (aGb.contains(s))
        {
            return new MD5Digest();
        }
        if (aGd.contains(s))
        {
            return new SHA224Digest();
        }
        if (aGe.contains(s))
        {
            return new SHA256Digest();
        }
        if (aGf.contains(s))
        {
            return new SHA384Digest();
        }
        if (aGg.contains(s))
        {
            return new SHA512Digest();
        } else
        {
            return null;
        }
    }

    static 
    {
        aGb = new HashSet();
        aGc = new HashSet();
        aGd = new HashSet();
        aGe = new HashSet();
        aGf = new HashSet();
        aGg = new HashSet();
        aGh = new HashMap();
        aGb.add("MD5");
        aGb.add(PKCSObjectIdentifiers.abC.identifier);
        aGc.add("SHA1");
        aGc.add("SHA-1");
        aGc.add(OIWObjectIdentifiers.aav.identifier);
        aGd.add("SHA224");
        aGd.add("SHA-224");
        aGd.add(NISTObjectIdentifiers.ZG.identifier);
        aGe.add("SHA256");
        aGe.add("SHA-256");
        aGe.add(NISTObjectIdentifiers.ZD.identifier);
        aGf.add("SHA384");
        aGf.add("SHA-384");
        aGf.add(NISTObjectIdentifiers.ZE.identifier);
        aGg.add("SHA512");
        aGg.add("SHA-512");
        aGg.add(NISTObjectIdentifiers.ZF.identifier);
        aGh.put("MD5", PKCSObjectIdentifiers.abC);
        aGh.put(PKCSObjectIdentifiers.abC.identifier, PKCSObjectIdentifiers.abC);
        aGh.put("SHA1", OIWObjectIdentifiers.aav);
        aGh.put("SHA-1", OIWObjectIdentifiers.aav);
        aGh.put(OIWObjectIdentifiers.aav.identifier, OIWObjectIdentifiers.aav);
        aGh.put("SHA224", NISTObjectIdentifiers.ZG);
        aGh.put("SHA-224", NISTObjectIdentifiers.ZG);
        aGh.put(NISTObjectIdentifiers.ZG.identifier, NISTObjectIdentifiers.ZG);
        aGh.put("SHA256", NISTObjectIdentifiers.ZD);
        aGh.put("SHA-256", NISTObjectIdentifiers.ZD);
        aGh.put(NISTObjectIdentifiers.ZD.identifier, NISTObjectIdentifiers.ZD);
        aGh.put("SHA384", NISTObjectIdentifiers.ZE);
        aGh.put("SHA-384", NISTObjectIdentifiers.ZE);
        aGh.put(NISTObjectIdentifiers.ZE.identifier, NISTObjectIdentifiers.ZE);
        aGh.put("SHA512", NISTObjectIdentifiers.ZF);
        aGh.put("SHA-512", NISTObjectIdentifiers.ZF);
        aGh.put(NISTObjectIdentifiers.ZF.identifier, NISTObjectIdentifiers.ZF);
    }
}
