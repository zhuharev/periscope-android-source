// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.res.Resources;
import android.util.SparseIntArray;

// Referenced classes of package com.digits.sdk.android:
//            DigitsErrorCodes

class ConfirmationErrorCodes extends DigitsErrorCodes
{

    ConfirmationErrorCodes(Resources resources)
    {
        super(resources);
        codeIdMap.put(44, R.string.dgts__try_again_confirmation);
    }
}
