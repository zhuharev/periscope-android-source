// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Build;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package o:
//            rz, ra, rl

static final class g.String extends Enum
{

    private static Ru RA;
    private static Ru RB;
    private static Ru RC;
    private static Ru RD;
    private static final HashMap RE;
    private static final l.HashMap RF[];
    private static p Ru;
    private static p Rv;
    private static p Rw;
    private static p Rx;
    private static p Ry;
    private static p Rz;

    public static g.String valueOf(String s)
    {
        return (g.String)Enum.valueOf(o/rz$if, s);
    }

    public static g.String[] values()
    {
        return ([])RF.clone();
    }

    static ne _mth0E1A()
    {
        Object obj = Build.CPU_ABI;
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            ra._mth0454()._mth02BE("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
            return RB;
        }
        obj = ((String) (obj)).toLowerCase(Locale.US);
        g.Object obj1 = (l.Locale.US)RE.get(obj);
        obj = obj1;
        if (obj1 == null)
        {
            obj = RB;
        }
        return ((RB) (obj));
    }

    static 
    {
        Ru = new <init>("X86_32", 0);
        Rv = new <init>("X86_64", 1);
        Rw = new <init>("ARM_UNKNOWN", 2);
        Rx = new <init>("PPC", 3);
        Ry = new <init>("PPC64", 4);
        Rz = new <init>("ARMV6", 5);
        RA = new <init>("ARMV7", 6);
        RB = new <init>("UNKNOWN", 7);
        RC = new <init>("ARMV7S", 8);
        RD = new <init>("ARM64", 9);
        RF = (new RF[] {
            Ru, Rv, Rw, Rx, Ry, Rz, RA, RB, RC, RD
        });
        HashMap hashmap = new HashMap(4);
        RE = hashmap;
        hashmap.put("armeabi-v7a", RA);
        RE.put("armeabi", Rz);
        RE.put("x86", Ru);
    }

    private g.String(String s, int i)
    {
        super(s, i);
    }
}
