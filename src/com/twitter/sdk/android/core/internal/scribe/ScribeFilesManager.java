// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import java.util.UUID;
import o.sc;
import o.tp;
import o.tq;
import o.ty;

class ScribeFilesManager extends tq
{

    static final String FILE_EXTENSION = ".tap";
    static final String FILE_PREFIX = "se";

    public ScribeFilesManager(Context context, tp tp, sc sc1, ty ty, int i)
    {
        super(context, tp, sc1, ty, i);
    }

    protected String generateUniqueRollOverFileName()
    {
        UUID uuid = UUID.randomUUID();
        return (new StringBuilder("se")).append("_").append(uuid.toString()).append("_").append(currentTimeProvider.getCurrentTimeMillis()).append(".tap").toString();
    }
}
