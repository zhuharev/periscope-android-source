// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.Typeface;
import java.util.HashMap;

// Referenced classes of package o:
//            FF6A

public final class art
{

    private static final HashMap bBQ = new HashMap();

    public art()
    {
    }

    public static Typeface _mth02C8(Context context, String s)
    {
        HashMap hashmap = bBQ;
        hashmap;
        JVM INSTR monitorenter ;
        boolean flag = bBQ.containsKey(s);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        try
        {
            context = Typeface.createFromAsset(context.getAssets(), s);
            bBQ.put(s, context);
            break MISSING_BLOCK_LABEL_66;
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        finally
        {
            throw context;
        }
        FF6A._mth02CA("PsTypefaces", (new StringBuilder("Could not get cached typeface ")).append(s).toString(), context);
        hashmap;
        JVM INSTR monitorexit ;
        return null;
        context = (Typeface)bBQ.get(s);
        hashmap;
        JVM INSTR monitorexit ;
        return context;
    }

}
