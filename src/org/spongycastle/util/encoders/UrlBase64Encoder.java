// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.util.encoders;


// Referenced classes of package org.spongycastle.util.encoders:
//            Base64Encoder

public class UrlBase64Encoder extends Base64Encoder
{

    public UrlBase64Encoder()
    {
        aPw[62] = 45;
        aPw[63] = 95;
        aPx = 46;
        _mth1E38();
    }
}
