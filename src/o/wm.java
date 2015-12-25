// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.Closeable;
import java.io.Flushable;

// Referenced classes of package o:
//            wo, vr

public interface wm
    extends Closeable, Flushable
{

    public abstract void close();

    public abstract void flush();

    public abstract wo timeout();

    public abstract void write(vr vr, long l);
}
