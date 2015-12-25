// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;

// Referenced classes of package org.spongycastle.pqc.crypto.mceliece:
//            McElieceParameters

public class McElieceKeyParameters extends AsymmetricKeyParameter
{

    public McElieceParameters aMb;

    public McElieceKeyParameters(boolean flag, McElieceParameters mcelieceparameters)
    {
        super(flag);
        aMb = mcelieceparameters;
    }
}
