// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.digits.sdk.android.DigitsSession;
import com.twitter.sdk.android.core.TwitterSession;

final class akx
{

    public final TwitterSession brf;
    public final DigitsSession brg;
    private Exception mU;
    public final String phoneNumber;

    akx(TwitterSession twittersession, DigitsSession digitssession, String s, RuntimeException runtimeexception)
    {
        brf = twittersession;
        brg = digitssession;
        phoneNumber = s;
        mU = runtimeexception;
    }
}
