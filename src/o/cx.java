// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.google.android.gms.common.api.Scope;

// Referenced classes of package o:
//            cy, cz, _cls09A8, da

public final class cx
{

    private static _cls09A8._cls02CB Cg;
    private static _cls09A8._cls02CB Ch;
    public static final cy Ci;
    private static cz Cj;
    public static final _cls09A8 Ck;

    static 
    {
        Cg = new _cls09A8._cls02CB();
        Ch = new _cls09A8._cls02CB();
        Ci = new cy();
        Cj = new cz();
        new Scope("profile");
        new Scope("email");
        Ck = new _cls09A8("SignIn.API", Ci, Cg);
        new _cls09A8("SignIn.INTERNAL_API", Cj, Ch);
        new da();
    }
}
