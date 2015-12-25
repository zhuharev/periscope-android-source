// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.vcard;


// Referenced classes of package com.digits.sdk.vcard:
//            VCardUtils

public static class 
{

    public static boolean isPrintableAscii(char c)
    {
        return ' ' <= c && c <= '~' || c == '\r' || c == '\n';
    }

    public static boolean isPrintableAsciiOnly(CharSequence charsequence)
    {
        int j = charsequence.length();
        for (int i = 0; i < j; i++)
        {
            if (!isPrintableAscii(charsequence.charAt(i)))
            {
                return false;
            }
        }

        return true;
    }

    public ()
    {
    }
}
