// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.lang.reflect.Type;

// Referenced classes of package o:
//            kh, kk, jm

final class jq
    implements kh
{

    private Type GR;
    private jm GS;
    private final kk GT = kk._mth0E43();
    private Class GU;

    jq(jm jm, Class class1, Type type)
    {
        GS = jm;
        GU = class1;
        GR = type;
        super();
    }

    public final Object _mth0725()
    {
        Object obj;
        try
        {
            obj = GT._mth02BD(GU);
        }
        catch (Exception exception)
        {
            throw new RuntimeException((new StringBuilder("Unable to invoke no-args constructor for ")).append(GR).append(". Register an InstanceCreator with Gson for this type may fix this problem.").toString(), exception);
        }
        return obj;
    }
}
