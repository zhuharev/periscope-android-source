// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

// Referenced classes of package o:
//            acl

public final class acm
{

    private final SharedPreferences aQC;
    private final LinkedHashSet bdq = new LinkedHashSet();

    public acm(Context context)
    {
        aQC = context.getSharedPreferences("tv.periscope", 0);
        bdq.add(Locale.getDefault().getLanguage());
    }

    public final acl aH()
    {
        return new acl(acl.if.valueOf(aQC.getString("notif_sound", acl.if.bdm.name())), aQC.getBoolean("notif_followed_live", true), aQC.getBoolean("notif_followed_shared", true), aQC.getBoolean("notif_user_follows_you", false), aQC.getBoolean("notif_suggested_first", true), aQC.getStringSet("language", bdq), aQC.getBoolean("notif_autosave", false));
    }

    public final void _mth02CA(acl acl1)
    {
        aQC.edit().putString("notif_sound", acl1.bdf.name()).putBoolean("notif_followed_live", acl1.bdg).putBoolean("notif_followed_shared", acl1.bdh).putBoolean("notif_user_follows_you", acl1.bdi).putBoolean("notif_suggested_first", acl1.bdj).putStringSet("language", acl1.bdk).putBoolean("notif_autosave", acl1.bdl).apply();
    }
}
