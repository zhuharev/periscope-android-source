// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric.util;

import java.lang.reflect.Constructor;
import javax.crypto.BadPaddingException;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.modes.AEADBlockCipher;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric.util:
//            BaseBlockCipher

static class aFR
    implements aFR
{

    private static final Constructor aFQ;
    private AEADBlockCipher aFR;

    private static Constructor _mth02C9(Class class1)
    {
        try
        {
            class1 = class1.getConstructor(new Class[] {
                java/lang/String
            });
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        return class1;
    }

    public final int doFinal(byte abyte0[], int i)
    {
        i = aFR.doFinal(abyte0, i);
        return i;
        InvalidCipherTextException invalidciphertextexception;
        invalidciphertextexception;
        if (aFQ == null) goto _L2; else goto _L1
_L1:
        abyte0 = null;
        BadPaddingException badpaddingexception = (BadPaddingException)aFQ.newInstance(new Object[] {
            invalidciphertextexception.getMessage()
        });
        abyte0 = badpaddingexception;
_L4:
        if (abyte0 != null)
        {
            throw abyte0;
        }
_L2:
        throw new BadPaddingException(invalidciphertextexception.getMessage());
        Exception exception;
        exception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final int getOutputSize(int i)
    {
        return aFR.getOutputSize(i);
    }

    public final void updateAAD(byte abyte0[], int i, int j)
    {
        aFR._mth1428(abyte0, i, j);
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        aFR._mth02CA(flag, cipherparameters);
    }

    public final int _mth02CB(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        return aFR._mth02CB(abyte0, i, j, abyte1, k);
    }

    public final BlockCipher _mth14AD()
    {
        return aFR._mth14AD();
    }

    public final int _mth1550(int i)
    {
        return aFR._mth1550(i);
    }

    public final boolean _mth1D09()
    {
        return false;
    }

    static 
    {
        Class class1 = BaseBlockCipher.FB35("javax.crypto.AEADBadTagException");
        if (class1 != null)
        {
            aFQ = _mth02C9(class1);
        } else
        {
            aFQ = null;
        }
    }

    (AEADBlockCipher aeadblockcipher)
    {
        aFR = aeadblockcipher;
    }
}
