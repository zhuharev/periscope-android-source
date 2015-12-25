// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

// Referenced classes of package o:
//            _cls1E37, _cls0285, _cls1541, FE70, 
//            _cls05D3, _cls05F1, _cls068C, _cls068D

public final class _cls09F3 extends _cls1E37
    implements DialogInterface
{
    /* member class not found */
    class if {}


    private _cls0285 _fld2148;

    public _cls09F3(Context context, int i)
    {
        super(context, _mth02CE(context, i));
        _fld2148 = new _cls0285(getContext(), this, getWindow());
    }

    public static _cls0285 _mth02CA(_cls09F3 _pcls09f3)
    {
        return _pcls09f3._fld2148;
    }

    static int _mth02CE(Context context, int i)
    {
        if (i >= 0x1000000)
        {
            return i;
        } else
        {
            TypedValue typedvalue = new TypedValue();
            context.getTheme().resolveAttribute(_cls1541.alertDialogTheme, typedvalue, true);
            return typedvalue.resourceId;
        }
    }

    protected final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _cls0285 _lcls0285 = _fld2148;
        _lcls0285._fld03C5.supportRequestWindowFeature(1);
        int i = _lcls0285._fld14D3;
        i = _lcls0285._fld1490;
        _lcls0285._fld03C5.setContentView(i);
        bundle = _lcls0285._fld0422.findViewById(_cls0285._fld152A);
        View view2 = bundle.findViewById(_cls0285._fld1D23);
        Object obj1 = bundle.findViewById(_cls0285._fld1526);
        Object obj = bundle.findViewById(_cls0285._fld1503);
        ViewGroup viewgroup = (ViewGroup)bundle.findViewById(_cls0285._fld1529);
        if (_lcls0285.mView != null)
        {
            bundle = _lcls0285.mView;
        } else
        if (_lcls0285._fld044D != 0)
        {
            bundle = LayoutInflater.from(_lcls0285.mContext).inflate(_lcls0285._fld044D, viewgroup, false);
        } else
        {
            bundle = null;
        }
        boolean flag;
        if (bundle != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag || !_cls0285._mth1423(bundle))
        {
            _lcls0285._fld0422.setFlags(0x20000, 0x20000);
        }
        if (flag)
        {
            FrameLayout framelayout = (FrameLayout)_lcls0285._fld0422.findViewById(_cls0285.custom);
            framelayout.addView(bundle, new android.view.ViewGroup.LayoutParams(-1, -1));
            if (_lcls0285._fld05D0)
            {
                framelayout.setPadding(_lcls0285._fld0454, _lcls0285._fld04F5, _lcls0285._fld050D, _lcls0285._fld0585);
            }
            if (_lcls0285._fld0443 != null)
            {
                ((android.widget.LinearLayout.LayoutParams)viewgroup.getLayoutParams()).weight = 0.0F;
            }
        } else
        {
            viewgroup.setVisibility(8);
        }
        bundle = viewgroup.findViewById(_cls0285._fld1D23);
        View view4 = viewgroup.findViewById(_cls0285._fld1526);
        View view3 = viewgroup.findViewById(_cls0285._fld1503);
        bundle = _cls0285._mth02CB(bundle, view2);
        obj1 = _cls0285._mth02CB(view4, ((View) (obj1)));
        obj = _cls0285._mth02CB(view3, ((View) (obj)));
        _lcls0285._fld0E22 = (NestedScrollView)_lcls0285._fld0422.findViewById(_cls0285._fld1690);
        _lcls0285._fld0E22.setFocusable(false);
        _lcls0285._fld0E22.setNestedScrollingEnabled(false);
        _lcls0285._fld1489 = (TextView)((ViewGroup) (obj1)).findViewById(0x102000b);
        if (_lcls0285._fld1489 != null)
        {
            if (_lcls0285._fld043E != null)
            {
                _lcls0285._fld1489.setText(_lcls0285._fld043E);
            } else
            {
                _lcls0285._fld1489.setVisibility(8);
                _lcls0285._fld0E22.removeView(_lcls0285._fld1489);
                if (_lcls0285._fld0443 != null)
                {
                    ViewGroup viewgroup1 = (ViewGroup)_lcls0285._fld0E22.getParent();
                    flag = viewgroup1.indexOfChild(_lcls0285._fld0E22);
                    viewgroup1.removeViewAt(flag);
                    viewgroup1.addView(_lcls0285._fld0443, flag, new android.view.ViewGroup.LayoutParams(-1, -1));
                } else
                {
                    ((ViewGroup) (obj1)).setVisibility(8);
                }
            }
        }
        flag = false;
        _lcls0285._fld05E2 = (Button)((ViewGroup) (obj)).findViewById(0x1020019);
        _lcls0285._fld05E2.setOnClickListener(_lcls0285._fld14FF);
        if (TextUtils.isEmpty(_lcls0285._fld0629))
        {
            _lcls0285._fld05E2.setVisibility(8);
        } else
        {
            _lcls0285._fld05E2.setText(_lcls0285._fld0629);
            _lcls0285._fld05E2.setVisibility(0);
            flag = true;
        }
        _lcls0285._fld066E = (Button)((ViewGroup) (obj)).findViewById(0x102001a);
        _lcls0285._fld066E.setOnClickListener(_lcls0285._fld14FF);
        if (TextUtils.isEmpty(_lcls0285._fld0671))
        {
            _lcls0285._fld066E.setVisibility(8);
        } else
        {
            _lcls0285._fld066E.setText(_lcls0285._fld0671);
            _lcls0285._fld066E.setVisibility(0);
            flag |= 2;
        }
        _lcls0285._fld0699 = (Button)((ViewGroup) (obj)).findViewById(0x102001b);
        _lcls0285._fld0699.setOnClickListener(_lcls0285._fld14FF);
        if (TextUtils.isEmpty(_lcls0285._fld093D))
        {
            _lcls0285._fld0699.setVisibility(8);
        } else
        {
            _lcls0285._fld0699.setText(_lcls0285._fld093D);
            _lcls0285._fld0699.setVisibility(0);
            flag |= 4;
        }
        if (flag != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            ((ViewGroup) (obj)).setVisibility(8);
        }
        if (_lcls0285._fld148B != null)
        {
            android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(-1, -2);
            bundle.addView(_lcls0285._fld148B, 0, layoutparams);
            _lcls0285._fld0422.findViewById(_cls0285._fld1D22).setVisibility(8);
        } else
        {
            _lcls0285._fld1433 = (ImageView)_lcls0285._fld0422.findViewById(0x1020006);
            if (!TextUtils.isEmpty(_lcls0285.mTitle))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                _lcls0285._fld1438 = (TextView)_lcls0285._fld0422.findViewById(_cls0285._fld1502);
                _lcls0285._fld1438.setText(_lcls0285.mTitle);
                if (_lcls0285._fld0E30 != 0)
                {
                    _lcls0285._fld1433.setImageResource(_lcls0285._fld0E30);
                } else
                if (_lcls0285._fld0EB2 != null)
                {
                    _lcls0285._fld1433.setImageDrawable(_lcls0285._fld0EB2);
                } else
                {
                    _lcls0285._fld1438.setPadding(_lcls0285._fld1433.getPaddingLeft(), _lcls0285._fld1433.getPaddingTop(), _lcls0285._fld1433.getPaddingRight(), _lcls0285._fld1433.getPaddingBottom());
                    _lcls0285._fld1433.setVisibility(8);
                }
            } else
            {
                _lcls0285._fld0422.findViewById(_cls0285._fld1D22).setVisibility(8);
                _lcls0285._fld1433.setVisibility(8);
                bundle.setVisibility(8);
            }
        }
        if (viewgroup != null && viewgroup.getVisibility() != 8)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        boolean flag2;
        if (bundle != null && bundle.getVisibility() != 8)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        boolean flag1;
        if (obj != null && ((ViewGroup) (obj)).getVisibility() != 8)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1 && obj1 != null)
        {
            bundle = ((ViewGroup) (obj1)).findViewById(_cls0285._fld1D0F);
            if (bundle != null)
            {
                bundle.setVisibility(0);
            }
        }
        if (flag2 && _lcls0285._fld0E22 != null)
        {
            _lcls0285._fld0E22.setClipToPadding(true);
        }
        if (!flag)
        {
            if (_lcls0285._fld0443 != null)
            {
                bundle = _lcls0285._fld0443;
            } else
            {
                bundle = _lcls0285._fld0E22;
            }
            if (bundle != null)
            {
                int j;
                if (flag2)
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
                byte byte0;
                if (flag1)
                {
                    byte0 = 2;
                } else
                {
                    byte0 = 0;
                }
                j |= byte0;
                View view = _lcls0285._fld0422.findViewById(_cls0285._fld1624);
                View view1 = _lcls0285._fld0422.findViewById(_cls0285._fld152E);
                if (android.os.Build.VERSION.SDK_INT >= 23)
                {
                    FE70._mth02CA(bundle, j, 3);
                    if (view != null)
                    {
                        ((ViewGroup) (obj1)).removeView(view);
                    }
                    if (view1 != null)
                    {
                        ((ViewGroup) (obj1)).removeView(view1);
                    }
                } else
                {
                    bundle = view;
                    if (view != null)
                    {
                        bundle = view;
                        if ((j & 1) == 0)
                        {
                            ((ViewGroup) (obj1)).removeView(view);
                            bundle = null;
                        }
                    }
                    view = view1;
                    if (view1 != null)
                    {
                        view = view1;
                        if ((j & 2) == 0)
                        {
                            ((ViewGroup) (obj1)).removeView(view1);
                            view = null;
                        }
                    }
                    if (bundle != null || view != null)
                    {
                        if (_lcls0285._fld043E != null)
                        {
                            _lcls0285._fld0E22.setOnScrollChangeListener(new _cls05D3(_lcls0285, bundle, view));
                            _lcls0285._fld0E22.post(new _cls05F1(_lcls0285, bundle, view));
                        } else
                        if (_lcls0285._fld0443 != null)
                        {
                            _lcls0285._fld0443.setOnScrollListener(new _cls068C(_lcls0285, bundle, view));
                            _lcls0285._fld0443.post(new _cls068D(_lcls0285, bundle, view));
                        } else
                        {
                            if (bundle != null)
                            {
                                ((ViewGroup) (obj1)).removeView(bundle);
                            }
                            if (view != null)
                            {
                                ((ViewGroup) (obj1)).removeView(view);
                            }
                        }
                    }
                }
            }
        }
        bundle = _lcls0285._fld0443;
        if (bundle != null && _lcls0285.mAdapter != null)
        {
            bundle.setAdapter(_lcls0285.mAdapter);
            int k = _lcls0285._fld148D;
            if (k >= 0)
            {
                bundle.setItemChecked(k, true);
                bundle.setSelection(k);
            }
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyevent)
    {
        _cls0285 _lcls0285 = _fld2148;
        boolean flag;
        if (_lcls0285._fld0E22 != null && _lcls0285._fld0E22.executeKeyEvent(keyevent))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public final boolean onKeyUp(int i, KeyEvent keyevent)
    {
        _cls0285 _lcls0285 = _fld2148;
        boolean flag;
        if (_lcls0285._fld0E22 != null && _lcls0285._fld0E22.executeKeyEvent(keyevent))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return true;
        } else
        {
            return super.onKeyUp(i, keyevent);
        }
    }

    public final void setTitle(CharSequence charsequence)
    {
        super.setTitle(charsequence);
        _cls0285 _lcls0285 = _fld2148;
        _lcls0285.mTitle = charsequence;
        if (_lcls0285._fld1438 != null)
        {
            _lcls0285._fld1438.setText(charsequence);
        }
    }
}
