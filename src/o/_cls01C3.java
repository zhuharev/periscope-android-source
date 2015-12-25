// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.PrintWriter;

public final class _cls01C3
{

    public boolean _fld0208;
    public boolean _fld020B;
    public boolean FE7B;
    public int FE7C;
    public _cls141F.if FE9B;
    public _cls141F.if FEA9;
    public boolean FEE8;
    public boolean FF68;

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(64);
        _cls141D._cls02CA._mth02CA(this, stringbuilder);
        stringbuilder.append(" id=");
        stringbuilder.append(FE7C);
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    public final void _mth02CA(String s, PrintWriter printwriter)
    {
        printwriter.print(s);
        printwriter.print("mId=");
        printwriter.print(FE7C);
        printwriter.print(" mListener=");
        printwriter.println(FE9B);
        if (FE7B)
        {
            printwriter.print(s);
            printwriter.print("mStarted=");
            printwriter.print(FE7B);
            printwriter.print(" mContentChanged=");
            printwriter.print(false);
            printwriter.print(" mProcessingChange=");
            printwriter.println(false);
        }
        if (FF68)
        {
            printwriter.print(s);
            printwriter.print("mAbandoned=");
            printwriter.print(false);
            printwriter.print(" mReset=");
            printwriter.println(FF68);
        }
    }

    public final void _mth02CA(_cls02B3.if if1)
    {
        if (FE9B == null)
        {
            throw new IllegalStateException("No listener register");
        }
        if (FE9B != if1)
        {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else
        {
            FE9B = null;
            return;
        }
    }

    public final void _mth02CB(_cls02B3.if if1)
    {
        if (FEA9 == null)
        {
            throw new IllegalStateException("No listener register");
        }
        if (FEA9 != if1)
        {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else
        {
            FEA9 = null;
            return;
        }
    }
}
