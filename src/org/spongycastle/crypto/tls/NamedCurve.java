// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;


public class NamedCurve
{

    public NamedCurve()
    {
    }

    public static boolean isValid(int i)
    {
        return i > 0 && i <= 28 || i >= 65281 && i <= 65282;
    }

    public static boolean _mth0279(int i)
    {
        switch (i)
        {
        case 65281: 
        case 65282: 
            return false;
        }
        return true;
    }
}
