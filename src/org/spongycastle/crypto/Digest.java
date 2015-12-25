// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto;


public interface Digest
{

    public abstract int doFinal(byte abyte0[], int i);

    public abstract void reset();

    public abstract void update(byte byte0);

    public abstract void update(byte abyte0[], int i, int j);

    public abstract String _mth14AC();

    public abstract int _mth14AF();
}
