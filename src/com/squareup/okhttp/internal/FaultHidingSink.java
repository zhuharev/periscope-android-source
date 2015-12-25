// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import java.io.IOException;
import o.vr;
import o.vy;
import o.wm;

class FaultHidingSink extends vy
{

    private boolean hasErrors;

    public FaultHidingSink(wm wm)
    {
        super(wm);
    }

    public void close()
    {
        if (hasErrors)
        {
            return;
        }
        try
        {
            super.close();
            return;
        }
        catch (IOException ioexception)
        {
            hasErrors = true;
            onException(ioexception);
            return;
        }
    }

    public void flush()
    {
        if (hasErrors)
        {
            return;
        }
        try
        {
            super.flush();
            return;
        }
        catch (IOException ioexception)
        {
            hasErrors = true;
            onException(ioexception);
            return;
        }
    }

    protected void onException(IOException ioexception)
    {
    }

    public void write(vr vr1, long l)
    {
        if (hasErrors)
        {
            vr1._mth02D1(l);
            return;
        }
        try
        {
            super.write(vr1, l);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (vr vr1)
        {
            hasErrors = true;
        }
        onException(vr1);
    }
}
