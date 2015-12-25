// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;


public class OIDTokenizer
{

    private String Xa;
    int index;

    public OIDTokenizer(String s)
    {
        Xa = s;
        index = 0;
    }

    public final String nextToken()
    {
        if (index == -1)
        {
            return null;
        }
        int i = Xa.indexOf('.', index);
        if (i == -1)
        {
            String s = Xa.substring(index);
            index = -1;
            return s;
        } else
        {
            String s1 = Xa.substring(index, i);
            index = i + 1;
            return s1;
        }
    }
}
