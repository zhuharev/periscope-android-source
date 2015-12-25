// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.database.Cursor;

// Referenced classes of package o:
//            _cls1D49

static interface String
{

    public abstract void changeCursor(Cursor cursor);

    public abstract Cursor getCursor();

    public abstract Cursor runQueryOnBackgroundThread(CharSequence charsequence);

    public abstract String _mth02CA(Cursor cursor);
}
