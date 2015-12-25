// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;


// Referenced classes of package com.squareup.okhttp:
//            Interceptor, Connection, Request, Response

public static interface 
{

    public abstract Connection connection();

    public abstract Response proceed(Request request1);

    public abstract Request request();
}
