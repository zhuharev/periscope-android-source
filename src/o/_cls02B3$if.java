// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

// Referenced classes of package o:
//            _cls02B3, _cls01C3

public final class String
    implements Object
{

    boolean mRetaining;
    private _cls01C3 _fld02BA;
    private boolean _fld0399;
    boolean _fld0406;
    private Object _fld0456;
    boolean _fld0457;
    boolean _fld04C0;
    private boolean _fld05F2;
    private boolean _fld1424;
    boolean FE7B;
    private int FE7C;
    private Bundle FE91;
    .Bundle FEE7;

    final void destroy()
    {
        boolean flag = _cls02B3.DEBUG;
        _fld1424 = true;
        _fld0406 = false;
        FEE7 = null;
        _fld0456 = null;
        _fld0399 = false;
        if (_fld02BA != null)
        {
            if (_fld05F2)
            {
                _fld05F2 = false;
                _fld02BA._mth02CA(this);
                _fld02BA._mth02CB(this);
            }
            _cls01C3 _lcls01c3 = _fld02BA;
            _lcls01c3.FF68 = true;
            _lcls01c3.FE7B = false;
            _lcls01c3.FEE8 = false;
            _lcls01c3._fld0208 = false;
            _lcls01c3._fld020B = false;
        }
    }

    public final void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        printwriter.print(s);
        printwriter.print("mId=");
        printwriter.print(FE7C);
        printwriter.print(" mArgs=");
        printwriter.println(FE91);
        printwriter.print(s);
        printwriter.print("mCallbacks=");
        printwriter.println(null);
        printwriter.print(s);
        printwriter.print("mLoader=");
        printwriter.println(_fld02BA);
        if (_fld02BA != null)
        {
            _fld02BA._mth02CA((new StringBuilder()).append(s).append("  ").toString(), printwriter);
        }
        if (_fld0406)
        {
            printwriter.print(s);
            printwriter.print("mHaveData=");
            printwriter.print(false);
            printwriter.print("  mDeliveredData=");
            printwriter.println(_fld0406);
            printwriter.print(s);
            printwriter.print("mData=");
            printwriter.println(null);
        }
        printwriter.print(s);
        printwriter.print("mStarted=");
        printwriter.print(FE7B);
        printwriter.print(" mReportNextStart=");
        printwriter.print(_fld04C0);
        printwriter.print(" mDestroyed=");
        printwriter.println(_fld1424);
        printwriter.print(s);
        printwriter.print("mRetaining=");
        printwriter.print(mRetaining);
        printwriter.print(" mRetainingStarted=");
        printwriter.print(_fld0457);
        printwriter.print(" mListenerRegistered=");
        printwriter.println(_fld05F2);
    }

    final void start()
    {
        if (mRetaining && _fld0457)
        {
            FE7B = true;
            return;
        }
        if (FE7B)
        {
            return;
        }
        FE7B = true;
        boolean flag = _cls02B3.DEBUG;
        if (_fld02BA != null)
        {
            if (_fld02BA.getClass().isMemberClass() && !Modifier.isStatic(_fld02BA.getClass().getModifiers()))
            {
                throw new IllegalArgumentException((new StringBuilder("Object returned from onCreateLoader must not be a non-static inner member class: ")).append(_fld02BA).toString());
            }
            if (!_fld05F2)
            {
                _cls01C3 _lcls01c3 = _fld02BA;
                int i = FE7C;
                if (_lcls01c3.FE9B != null)
                {
                    throw new IllegalStateException("There is already a listener registered");
                }
                _lcls01c3.FE9B = this;
                _lcls01c3.FE7C = i;
                _lcls01c3 = _fld02BA;
                if (_lcls01c3.FEA9 != null)
                {
                    throw new IllegalStateException("There is already a listener registered");
                }
                _lcls01c3.FEA9 = this;
                _fld05F2 = true;
            }
            _cls01C3 _lcls01c3_1 = _fld02BA;
            _lcls01c3_1.FE7B = true;
            _lcls01c3_1.FF68 = false;
            _lcls01c3_1.FEE8 = false;
        }
    }

    final void stop()
    {
        boolean flag = _cls02B3.DEBUG;
        FE7B = false;
        if (!mRetaining && _fld02BA != null && _fld05F2)
        {
            _fld05F2 = false;
            _fld02BA._mth02CA(this);
            _fld02BA._mth02CB(this);
            _fld02BA.FE7B = false;
        }
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(64);
        stringbuilder.append("LoaderInfo{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(" #");
        stringbuilder.append(FE7C);
        stringbuilder.append(" : ");
        A._mth02CA(_fld02BA, stringbuilder);
        stringbuilder.append("}}");
        return stringbuilder.toString();
    }
}
