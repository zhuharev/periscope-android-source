// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.animation.Interpolator;

final class _cls0157
    implements Interpolator
{

    _cls0157()
    {
    }

    public final float getInterpolation(float f)
    {
        f--;
        return f * f * f * f * f + 1.0F;
    }
}
