// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.os.Bundle;

class BundleManager
{

    BundleManager()
    {
    }

    static transient boolean assertContains(Bundle bundle, String as[])
    {
        if (bundle == null || as == null)
        {
            return false;
        }
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            if (!bundle.containsKey(as[i]))
            {
                return false;
            }
        }

        return true;
    }
}
