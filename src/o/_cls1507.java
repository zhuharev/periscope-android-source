// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Bundle;

class _cls1507
{

    _cls1507()
    {
    }

    static Bundle _mth02CA(_cls14BD.if if1)
    {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", if1.getResultKey());
        bundle.putCharSequence("label", if1.getLabel());
        bundle.putCharSequenceArray("choices", if1.getChoices());
        bundle.putBoolean("allowFreeFormInput", if1.getAllowFreeFormInput());
        bundle.putBundle("extras", if1.getExtras());
        return bundle;
    }

    static Bundle[] _mth02CB(_cls14BD.if aif[])
    {
        if (aif == null)
        {
            return null;
        }
        Bundle abundle[] = new Bundle[aif.length];
        for (int i = 0; i < aif.length; i++)
        {
            abundle[i] = _mth02CA(aif[i]);
        }

        return abundle;
    }
}
