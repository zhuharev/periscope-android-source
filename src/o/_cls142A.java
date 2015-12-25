// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.RemoteInput;

class _cls142A
{

    _cls142A()
    {
    }

    static RemoteInput[] _mth02CA(_cls14BD.if aif[])
    {
        if (aif == null)
        {
            return null;
        }
        RemoteInput aremoteinput[] = new RemoteInput[aif.length];
        for (int i = 0; i < aif.length; i++)
        {
            _cls14BD.if if1 = aif[i];
            aremoteinput[i] = (new android.app.RemoteInput.Builder(if1.getResultKey())).setLabel(if1.getLabel()).setChoices(if1.getChoices()).setAllowFreeFormInput(if1.getAllowFreeFormInput()).addExtras(if1.getExtras()).build();
        }

        return aremoteinput;
    }
}
