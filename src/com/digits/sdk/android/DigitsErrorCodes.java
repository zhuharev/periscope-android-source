// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.res.Resources;
import android.util.SparseIntArray;

// Referenced classes of package com.digits.sdk.android:
//            ErrorCodes

class DigitsErrorCodes
    implements ErrorCodes
{

    private static final int INITIAL_CAPACITY = 10;
    protected final SparseIntArray codeIdMap = new SparseIntArray(10);
    private final Resources resources;

    DigitsErrorCodes(Resources resources1)
    {
        codeIdMap.put(88, R.string.dgts__confirmation_error_alternative);
        codeIdMap.put(284, R.string.dgts__network_error);
        codeIdMap.put(302, R.string.dgts__network_error);
        codeIdMap.put(240, R.string.dgts__network_error);
        codeIdMap.put(87, R.string.dgts__network_error);
        resources = resources1;
    }

    public String getDefaultMessage()
    {
        return resources.getString(R.string.dgts__try_again);
    }

    public String getMessage(int i)
    {
        i = codeIdMap.get(i, -1);
        if (i == -1)
        {
            return getDefaultMessage();
        } else
        {
            return resources.getString(i);
        }
    }

    public String getNetworkError()
    {
        return resources.getString(R.string.dgts__network_error);
    }
}
