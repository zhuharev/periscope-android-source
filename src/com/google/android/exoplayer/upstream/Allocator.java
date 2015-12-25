// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;


// Referenced classes of package com.google.android.exoplayer.upstream:
//            Allocation

public interface Allocator
{

    public abstract Allocation allocate();

    public abstract void blockWhileTotalBytesAllocatedExceeds(int i);

    public abstract int getIndividualAllocationLength();

    public abstract int getTotalBytesAllocated();

    public abstract void release(Allocation allocation);

    public abstract void trim(int i);
}
