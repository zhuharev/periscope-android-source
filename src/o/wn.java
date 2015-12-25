// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.Closeable;

// Referenced classes of package o:
//            vr, wo

public interface wn
    extends Closeable
{

    public abstract void close();

    public abstract long read(vr vr, long l);

    public abstract wo timeout();
}
