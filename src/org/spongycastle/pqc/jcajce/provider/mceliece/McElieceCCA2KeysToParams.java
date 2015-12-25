// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;

// Referenced classes of package org.spongycastle.pqc.jcajce.provider.mceliece:
//            BCMcElieceCCA2PrivateKey, BCMcElieceCCA2PublicKey

public class McElieceCCA2KeysToParams
{

    public McElieceCCA2KeysToParams()
    {
    }

    public static McElieceCCA2PrivateKeyParameters _mth02BB(PrivateKey privatekey)
    {
        if (privatekey instanceof BCMcElieceCCA2PrivateKey)
        {
            privatekey = (BCMcElieceCCA2PrivateKey)privatekey;
            return new McElieceCCA2PrivateKeyParameters(((BCMcElieceCCA2PrivateKey) (privatekey)).Xa, ((BCMcElieceCCA2PrivateKey) (privatekey)).axg, ((BCMcElieceCCA2PrivateKey) (privatekey)).afK, ((BCMcElieceCCA2PrivateKey) (privatekey)).aLU, ((BCMcElieceCCA2PrivateKey) (privatekey)).aLV, ((BCMcElieceCCA2PrivateKey) (privatekey)).aLW, ((BCMcElieceCCA2PrivateKey) (privatekey)).aLX, ((BCMcElieceCCA2PrivateKey) (privatekey)).aLY, ((BCMcElieceCCA2PrivateKey) (privatekey)).aOb);
        } else
        {
            throw new InvalidKeyException("can't identify McElieceCCA2 private key.");
        }
    }

    public static McElieceCCA2PublicKeyParameters _mth02BD(PublicKey publickey)
    {
        if (publickey instanceof BCMcElieceCCA2PublicKey)
        {
            publickey = (BCMcElieceCCA2PublicKey)publickey;
            return new McElieceCCA2PublicKeyParameters(((BCMcElieceCCA2PublicKey) (publickey)).Xa, ((BCMcElieceCCA2PublicKey) (publickey)).axg, ((BCMcElieceCCA2PublicKey) (publickey)).aJP, ((BCMcElieceCCA2PublicKey) (publickey)).aMk, ((BCMcElieceCCA2PublicKey) (publickey)).aOc);
        } else
        {
            throw new InvalidKeyException((new StringBuilder("can't identify McElieceCCA2 public key: ")).append(publickey.getClass().getName()).toString());
        }
    }
}
