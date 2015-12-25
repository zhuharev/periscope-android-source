// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.MacSpi;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.SkeinParameters;
import org.spongycastle.jcajce.spec.SkeinParameterSpec;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric.util:
//            PBE, BCPBEKey

public class BaseMac extends MacSpi
    implements PBE
{

    private int Yp;
    private Mac aFW;
    private int aFX;
    private int aFY;

    public BaseMac(Mac mac)
    {
        aFX = 2;
        aFY = 1;
        Yp = 160;
        aFW = mac;
    }

    public BaseMac(HMac hmac, int i, int j, int k)
    {
        aFX = 2;
        aFY = 1;
        Yp = 160;
        aFW = hmac;
        aFX = 2;
        aFY = j;
        Yp = k;
    }

    private static Hashtable _mth02CE(Map map)
    {
        Hashtable hashtable = new Hashtable();
        Object obj;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); hashtable.put(obj, map.get(obj)))
        {
            obj = iterator.next();
        }

        return hashtable;
    }

    protected byte[] engineDoFinal()
    {
        byte abyte0[] = new byte[engineGetMacLength()];
        aFW.doFinal(abyte0, 0);
        return abyte0;
    }

    protected int engineGetMacLength()
    {
        return aFW._mth14B3();
    }

    protected void engineInit(Key key, AlgorithmParameterSpec algorithmparameterspec)
    {
        if (key == null)
        {
            throw new InvalidKeyException("key is null");
        }
        if (key instanceof BCPBEKey)
        {
            key = (BCPBEKey)key;
            if (((BCPBEKey) (key)).aso != null)
            {
                key = ((BCPBEKey) (key)).aso;
            } else
            if (algorithmparameterspec instanceof PBEParameterSpec)
            {
                key = PBE.Util._mth02CA(key, algorithmparameterspec);
            } else
            {
                throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
            }
        } else
        if (algorithmparameterspec instanceof IvParameterSpec)
        {
            key = new ParametersWithIV(new KeyParameter(key.getEncoded()), ((IvParameterSpec)algorithmparameterspec).getIV());
        } else
        if (algorithmparameterspec instanceof SkeinParameterSpec)
        {
            key = new SkeinParameters((new org.spongycastle.crypto.params.SkeinParameters.Builder(_mth02CE(((SkeinParameterSpec)algorithmparameterspec).aGk)))._mth1D63(key.getEncoded()).axJ, (byte)0);
        } else
        if (algorithmparameterspec == null)
        {
            key = new KeyParameter(key.getEncoded());
        } else
        {
            throw new InvalidAlgorithmParameterException("unknown parameter type.");
        }
        aFW._mth02CA(key);
    }

    protected void engineReset()
    {
        aFW.reset();
    }

    protected void engineUpdate(byte byte0)
    {
        aFW.update(byte0);
    }

    protected void engineUpdate(byte abyte0[], int i, int j)
    {
        aFW.update(abyte0, i, j);
    }
}
