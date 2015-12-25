// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;

import java.util.List;
import java.util.Random;

// Referenced classes of package com.google.android.exoplayer.chunk:
//            FormatEvaluator, Format

public static final class random
    implements FormatEvaluator
{

    private final Random random;

    public final void disable()
    {
    }

    public final void enable()
    {
    }

    public final void evaluate(List list, long l, Format aformat[], random random1)
    {
        list = aformat[random.nextInt(aformat.length)];
        if (random1.t != null && !random1.t.equals(list))
        {
            random1.er = 3;
        }
        random1.t = list;
    }

    public ()
    {
        random = new Random();
    }

    public random(int i)
    {
        random = new Random(i);
    }
}
