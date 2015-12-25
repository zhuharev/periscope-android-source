// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.res.Resources;
import android.util.SparseIntArray;

// Referenced classes of package com.digits.sdk.android:
//            DigitsErrorCodes

class PhoneNumberErrorCodes extends DigitsErrorCodes
{

    PhoneNumberErrorCodes(Resources resources)
    {
        super(resources);
        codeIdMap.put(44, R.string.dgts__try_again_phone_number);
        codeIdMap.put(300, R.string.dgts__try_again_phone_number);
        codeIdMap.put(303, R.string.dgts__try_again_phone_number);
        codeIdMap.put(285, R.string.dgts__confirmation_error_alternative);
        codeIdMap.put(286, R.string.dgts__unsupported_operator_error);
    }
}
