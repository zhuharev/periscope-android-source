// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package o:
//            _cls02CD, _cls02C9, _cls1428, _cls1551, 
//            _cls02B3

public abstract class _cls0640 extends _cls02CD
{

    public final Activity mActivity;
    boolean mCheckedForLoaderManager;
    public final Context mContext;
    public final _cls1428 mFragmentManager;
    final Handler mHandler;
    _cls02B3 mLoaderManager;
    boolean mLoadersStarted;
    private int _fld142A;
    _cls1551 _fld14BD;
    public boolean _fld1507;

    _cls0640(_cls02C9 _pcls02c9)
    {
        this(_pcls02c9, _pcls02c9, _pcls02c9.mHandler, 0);
    }

    private _cls0640(_cls02C9 _pcls02c9, _cls02C9 _pcls02c9_1, Handler handler, int i)
    {
        mFragmentManager = new _cls1428();
        mActivity = _pcls02c9;
        mContext = _pcls02c9_1;
        mHandler = handler;
        _fld142A = 0;
    }

    void onAttachFragment(Fragment fragment)
    {
    }

    public void onDump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
    }

    public View onFindViewById(int i)
    {
        return null;
    }

    public LayoutInflater onGetLayoutInflater()
    {
        return (LayoutInflater)mContext.getSystemService("layout_inflater");
    }

    public int onGetWindowAnimations()
    {
        return _fld142A;
    }

    public boolean onHasView()
    {
        return true;
    }

    public boolean onHasWindowAnimations()
    {
        return true;
    }

    final void _mth02BB(String s)
    {
        if (_fld14BD != null)
        {
            _cls02B3 _lcls02b3 = (_cls02B3)_fld14BD.get(s);
            if (_lcls02b3 != null && !_lcls02b3.mRetaining)
            {
                _lcls02b3._mth1D62();
                _fld14BD.remove(s);
            }
        }
    }

    public final _cls02B3 _mth02CA(String s, boolean flag, boolean flag1)
    {
        if (_fld14BD == null)
        {
            _fld14BD = new _cls1551();
        }
        _cls02B3 _lcls02b3 = (_cls02B3)_fld14BD.get(s);
        if (_lcls02b3 == null)
        {
            if (flag1)
            {
                _lcls02b3 = new _cls02B3(s, this, flag);
                _fld14BD.put(s, _lcls02b3);
                return _lcls02b3;
            }
        } else
        {
            _lcls02b3.mHost = this;
        }
        return _lcls02b3;
    }

    public void _mth02CA(Fragment fragment, Intent intent, int i)
    {
        if (i != -1)
        {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        } else
        {
            mContext.startActivity(intent);
            return;
        }
    }

    public void _mth02CA(Fragment fragment, String as[], int i)
    {
    }

    public boolean _mth02CB()
    {
        return true;
    }

    public void _mth02CE()
    {
    }

    public abstract _cls02C9 _mth02CF();

    final _cls1551 _mth141D()
    {
        boolean flag1 = false;
        boolean flag2 = false;
        if (_fld14BD != null)
        {
            int k = _fld14BD.size();
            _cls02B3 a_lcls02b3[] = new _cls02B3[k];
            for (int i = k - 1; i >= 0; i--)
            {
                a_lcls02b3[i] = (_cls02B3)_fld14BD.FB48[(i << 1) + 1];
            }

            int j = 0;
            boolean flag = flag2;
            do
            {
                flag1 = flag;
                if (j >= k)
                {
                    break;
                }
                _cls02B3 _lcls02b3 = a_lcls02b3[j];
                if (_lcls02b3.mRetaining)
                {
                    flag = true;
                } else
                {
                    _lcls02b3._mth1D62();
                    _fld14BD.remove(_lcls02b3.mWho);
                }
                j++;
            } while (true);
        }
        if (flag1)
        {
            return _fld14BD;
        } else
        {
            return null;
        }
    }

    public boolean _mth141D(String s)
    {
        return false;
    }
}
