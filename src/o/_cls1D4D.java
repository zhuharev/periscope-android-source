// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import java.io.PrintStream;

// Referenced classes of package o:
//            _cls028B, _cls14FC, _cls1504, _cls14F8, 
//            _cls06BA, FC60

public class _cls1D4D
{

    final Context context;
    _cls028B jK;
    _cls14FC jV;
    _cls1504 jW;
    _cls1504 jX;
    _cls14F8 jY;
    _cls06BA je;
    FC60 jg;

    public _cls1D4D()
    {
    }

    public _cls1D4D(Context context1)
    {
        context = context1.getApplicationContext();
    }

    public static void _mth02BF(String s)
    {
        System.err.println((new StringBuilder("SLF4J: ")).append(s).toString());
    }

    public static void _mth02CA(String s, Throwable throwable)
    {
        System.err.println(s);
        System.err.println("Reported exception:");
        throwable.printStackTrace();
    }
}
