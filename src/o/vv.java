// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.InputStream;

// Referenced classes of package o:
//            wn, vw, vr

public interface vv
    extends wn
{

    public abstract int read(byte abyte0[], int i, int j);

    public abstract byte readByte();

    public abstract void readFully(byte abyte0[]);

    public abstract int readInt();

    public abstract long readLong();

    public abstract short readShort();

    public abstract void _mth02BF(long l);

    public abstract vw _mth02C9(long l);

    public abstract void _mth02CA(vr vr, long l);

    public abstract byte[] _mth02CD(long l);

    public abstract long _mth02CE(byte byte0);

    public abstract void _mth02D1(long l);

    public abstract vr FE93();

    public abstract boolean FF46();

    public abstract InputStream FF49();

    public abstract short FF56();

    public abstract int FF6C();

    public abstract long FF74();

    public abstract long FF7A();

    public abstract String FF8B();

    public abstract String FF90();

    public abstract byte[] FF98();
}
