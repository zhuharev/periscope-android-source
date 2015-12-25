// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls142A

class _cls1423
{
    /* member class not found */
    class if {}


    _cls1423()
    {
    }

    public static void _mth02CA(android.app.Notification.Builder builder, _cls144A.if if1)
    {
        android.app.Notification.Action.Builder builder1 = new android.app.Notification.Action.Builder(if1.getIcon(), if1.getTitle(), if1.FE7A());
        if (if1._mth02B3() != null)
        {
            android.app.RemoteInput aremoteinput[] = _cls142A._mth02CA(if1._mth02B3());
            int j = aremoteinput.length;
            for (int i = 0; i < j; i++)
            {
                builder1.addRemoteInput(aremoteinput[i]);
            }

        }
        if (if1.getExtras() != null)
        {
            builder1.addExtras(if1.getExtras());
        }
        builder.addAction(builder1.build());
    }
}
