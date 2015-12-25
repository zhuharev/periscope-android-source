// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.digits.sdk.android.AuthCallback;
import com.digits.sdk.android.DigitsException;
import com.digits.sdk.android.DigitsSession;

// Referenced classes of package o:
//            alo, alk, akx

final class alm
    implements AuthCallback
{

    alm()
    {
    }

    public final void failure(DigitsException digitsexception)
    {
        alk.FB5C(alo.bsb);
        alk._mth02CA(new akx(null, null, null, digitsexception));
    }

    public final void success(DigitsSession digitssession, String s)
    {
        alk.FB5C(alo.bsa);
        alk._mth02CA(new akx(null, digitssession, s, null));
    }
}
