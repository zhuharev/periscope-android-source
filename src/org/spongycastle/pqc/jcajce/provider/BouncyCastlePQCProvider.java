// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.provider;

import java.security.AccessController;
import java.security.Provider;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

public class BouncyCastlePQCProvider extends Provider
    implements ConfigurableProvider
{

    private static final HashMap aHa = new HashMap();
    private static String aNY = "BCPQC";
    private static final String aNZ[] = {
        "Rainbow", "McEliece"
    };
    private static String info = "BouncyCastle Post-Quantum Security Provider v1.50";

    public BouncyCastlePQCProvider()
    {
        super(aNY, 1.5D, info);
        AccessController.doPrivileged(new _cls1());
    }

    static void _mth02CA(BouncyCastlePQCProvider bouncycastlepqcprovider)
    {
        String as[];
        int i;
        as = aNZ;
        i = 0;
_L3:
        if (i == as.length) goto _L2; else goto _L1
_L1:
        Class class1 = null;
        Object obj = bouncycastlepqcprovider.getClass().getClassLoader();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        obj = ((ClassLoader) (obj)).loadClass((new StringBuilder()).append("org.spongycastle.pqc.jcajce.provider.").append(as[i]).append("$Mappings").toString());
        class1 = ((Class) (obj));
        break MISSING_BLOCK_LABEL_98;
        obj = Class.forName((new StringBuilder()).append("org.spongycastle.pqc.jcajce.provider.").append(as[i]).append("$Mappings").toString());
        class1 = ((Class) (obj));
_L4:
        if (class1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            ((AlgorithmProvider)class1.newInstance())._mth02CA(bouncycastlepqcprovider);
        }
        // Misplaced declaration of an exception variable
        catch (BouncyCastlePQCProvider bouncycastlepqcprovider)
        {
            throw new InternalError((new StringBuilder("cannot create instance of ")).append("org.spongycastle.pqc.jcajce.provider.").append(as[i]).append("$Mappings : ").append(bouncycastlepqcprovider).toString());
        }
        i++;
          goto _L3
_L2:
        return;
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
          goto _L4
    }

    public final void _mth02CA(ASN1ObjectIdentifier asn1objectidentifier, AsymmetricKeyInfoConverter asymmetrickeyinfoconverter)
    {
        aHa.put(asn1objectidentifier, asymmetrickeyinfoconverter);
    }

    public final void _mth0640(String s, String s1)
    {
        if (containsKey(s))
        {
            throw new IllegalStateException((new StringBuilder("duplicate provider key (")).append(s).append(") found").toString());
        } else
        {
            put(s, s1);
            return;
        }
    }

    public final boolean _mth1427(String s, String s1)
    {
        return containsKey((new StringBuilder()).append(s).append(".").append(s1).toString()) || containsKey((new StringBuilder("Alg.Alias.")).append(s).append(".").append(s1).toString());
    }


    private class _cls1
        implements PrivilegedAction
    {

        private BouncyCastlePQCProvider aOa;

        public Object run()
        {
            BouncyCastlePQCProvider._mth02CA(aOa);
            return null;
        }

        _cls1()
        {
            aOa = BouncyCastlePQCProvider.this;
            super();
        }
    }

}
