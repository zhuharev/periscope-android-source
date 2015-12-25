// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.spongycastle.asn1.cms.GCMParameters;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Integers;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            AES

public static class mParameters extends BaseAlgorithmParameters
{

    private GCMParameters aFs;

    protected byte[] engineGetEncoded()
    {
        return aFs.getEncoded();
    }

    protected byte[] engineGetEncoded(String s)
    {
        boolean flag;
        if (s == null || s.equals("ASN.1"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new IOException("unknown format specified");
        } else
        {
            return aFs.getEncoded();
        }
    }

    protected void engineInit(AlgorithmParameterSpec algorithmparameterspec)
    {
        if (AES._mth1626() != null)
        {
            try
            {
                Method method = AES._mth1626().getDeclaredMethod("getTLen", new Class[0]);
                aFs = new GCMParameters((byte[])AES._mth1626().getDeclaredMethod("getIV", new Class[0]).invoke(algorithmparameterspec, new Object[0]), ((Integer)method.invoke(algorithmparameterspec, new Object[0])).intValue());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (AlgorithmParameterSpec algorithmparameterspec)
            {
                throw new InvalidParameterSpecException("Cannot process GCMParameterSpec.");
            }
        } else
        {
            return;
        }
    }

    protected void engineInit(byte abyte0[])
    {
        aFs = GCMParameters._mth1507(abyte0);
    }

    protected void engineInit(byte abyte0[], String s)
    {
        boolean flag;
        if (s == null || s.equals("ASN.1"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new IOException("unknown format specified");
        } else
        {
            aFs = GCMParameters._mth1507(abyte0);
            return;
        }
    }

    protected String engineToString()
    {
        return "GCM";
    }

    protected final AlgorithmParameterSpec _mth02C8(Class class1)
    {
        if (AES._mth1626() != null)
        {
            try
            {
                class1 = (AlgorithmParameterSpec)AES._mth1626().getConstructor(new Class[] {
                    Integer.TYPE, [B
                }).newInstance(new Object[] {
                    Integers.valueOf(aFs.XE), Arrays._mth1D4C(aFs.XD)
                });
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                throw new InvalidParameterSpecException("no constructor found!");
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                throw new InvalidParameterSpecException((new StringBuilder("construction failed: ")).append(class1.getMessage()).toString());
            }
            return class1;
        } else
        {
            throw new InvalidParameterSpecException((new StringBuilder("unknown parameter spec: ")).append(class1.getName()).toString());
        }
    }

    public mParameters()
    {
    }
}
