// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.util.Random;

// Referenced classes of package com.codahale.metrics:
//            Striped64

static final class code
{

    static final Random rng = new Random();
    int code;


    ()
    {
        int i = rng.nextInt();
        if (i == 0)
        {
            i = 1;
        }
        code = i;
    }
}
