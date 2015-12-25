// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.spongycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;

// Referenced classes of package org.spongycastle.pqc.jcajce.provider.mceliece:
//            BCMcEliecePrivateKey, BCMcEliecePublicKey

public class McElieceKeysToParams
{

    public McElieceKeysToParams()
    {
    }

    public static McEliecePrivateKeyParameters _mth02BC(PrivateKey privatekey)
    {
        if (privatekey instanceof BCMcEliecePrivateKey)
        {
            privatekey = (BCMcEliecePrivateKey)privatekey;
            return new McEliecePrivateKeyParameters(((BCMcEliecePrivateKey) (privatekey)).Xa, ((BCMcEliecePrivateKey) (privatekey)).axg, ((BCMcEliecePrivateKey) (privatekey)).afK, ((BCMcEliecePrivateKey) (privatekey)).aLU, ((BCMcEliecePrivateKey) (privatekey)).aLV, ((BCMcEliecePrivateKey) (privatekey)).aMh, ((BCMcEliecePrivateKey) (privatekey)).aMi, ((BCMcEliecePrivateKey) (privatekey)).aMj, ((BCMcEliecePrivateKey) (privatekey)).aLX, ((BCMcEliecePrivateKey) (privatekey)).aLY, ((BCMcEliecePrivateKey) (privatekey)).aOd);
        } else
        {
            throw new InvalidKeyException("can't identify McEliece private key.");
        }
    }

    public static McEliecePublicKeyParameters _mth037A(PublicKey publickey)
    {
        if (publickey instanceof BCMcEliecePublicKey)
        {
            publickey = (BCMcEliecePublicKey)publickey;
            return new McEliecePublicKeyParameters(((BCMcEliecePublicKey) (publickey)).Xa, ((BCMcEliecePublicKey) (publickey)).axg, ((BCMcEliecePublicKey) (publickey)).aJP, ((BCMcEliecePublicKey) (publickey)).aMk, ((BCMcEliecePublicKey) (publickey)).aOe);
        } else
        {
            throw new InvalidKeyException((new StringBuilder("can't identify McEliece public key: ")).append(publickey.getClass().getName()).toString());
        }
    }
}
