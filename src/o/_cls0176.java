// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.File;
import java.util.Comparator;

final class _cls0176
    implements Comparator
{

    _cls0176()
    {
    }

    public final int compare(Object obj, Object obj1)
    {
        obj = (File)obj;
        return ((File)obj1).getName().compareTo(((File) (obj)).getName());
    }
}
