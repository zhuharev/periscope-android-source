// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;

import retrofit.mime.TypedString;

public class TypedFileString extends TypedString
{

    private final String mFilename;

    public TypedFileString(String s, String s1)
    {
        super(s);
        mFilename = s1;
    }

    public String fileName()
    {
        return mFilename;
    }
}
