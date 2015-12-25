// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

// Referenced classes of package o:
//            _cls1541, _cls1FD1, _cls012E, _cls03B9, 
//            _cls1E5F, _cls1E9B, FB32

public class _cls1E3B
{
    /* member class not found */
    class aux {}

    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class _cls02CF {}

    /* member class not found */
    class _cls141D {}


    public static final int cQ = 0x7f030087;
    private static Method cr;
    private static Method cs;
    private int ak;
    private boolean cA;
    private boolean cB;
    int cC;
    private View cD;
    private int cE;
    private DataSetObserver cF;
    private View cG;
    private Drawable cH;
    private android.widget.AdapterView.OnItemClickListener cI;
    private android.widget.AdapterView.OnItemSelectedListener cJ;
    private final _cls141D cK;
    private final aux cL;
    private final _cls02CF cM;
    private final _cls02CB cN;
    private Runnable cO;
    private boolean cP;
    private int ci;
    private PopupWindow ct;
    private if cu;
    private int cv;
    private int cw;
    private int cx;
    private int cy;
    private boolean cz;
    private ListAdapter mAdapter;
    private Context mContext;
    private final Handler mHandler;
    private int _fld0186;
    private Rect _fld01C0;

    public _cls1E3B()
    {
    }

    public _cls1E3B(Context context)
    {
        this(context, null, _cls1541.listPopupWindowStyle);
    }

    public _cls1E3B(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, _cls1541.listPopupWindowStyle);
    }

    public _cls1E3B(Context context, AttributeSet attributeset, int i)
    {
        this(context, attributeset, i, 0);
    }

    public _cls1E3B(Context context, AttributeSet attributeset, int i, int j)
    {
        cv = -2;
        ak = -2;
        cy = 1002;
        _fld0186 = 0;
        cA = false;
        cB = false;
        cC = 0x7fffffff;
        cE = 0;
        cK = new _cls141D((byte)0);
        cL = new aux((byte)0);
        cM = new _cls02CF((byte)0);
        cN = new _cls02CB((byte)0);
        _fld01C0 = new Rect();
        mContext = context;
        mHandler = new Handler(context.getMainLooper());
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, _cls1FD1.ListPopupWindow, i, j);
        cw = typedarray.getDimensionPixelOffset(_cls1FD1.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        cx = typedarray.getDimensionPixelOffset(_cls1FD1.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (cx != 0)
        {
            cz = true;
        }
        typedarray.recycle();
        ct = new _cls012E(context, attributeset, i);
        ct.setInputMethodMode(1);
        ci = _cls03B9.getLayoutDirectionFromLocale(mContext.getResources().getConfiguration().locale);
    }

    static if _mth02CA(_cls1E3B _pcls1e3b)
    {
        return _pcls1e3b.cu;
    }

    private int _mth02CB(View view, int i, boolean flag)
    {
        if (cs == null) goto _L2; else goto _L1
_L1:
        int j = ((Integer)cs.invoke(ct, new Object[] {
            view, Integer.valueOf(i), Boolean.valueOf(flag)
        })).intValue();
        return j;
_L4:
        Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
_L2:
        return ct.getMaxAvailableHeight(view, i);
        Exception exception;
        exception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    static PopupWindow _mth02CB(_cls1E3B _pcls1e3b)
    {
        return _pcls1e3b.ct;
    }

    static _cls141D _mth02CE(_cls1E3B _pcls1e3b)
    {
        return _pcls1e3b.cK;
    }

    static Handler _mth02CF(_cls1E3B _pcls1e3b)
    {
        return _pcls1e3b.mHandler;
    }

    private void _mth068A()
    {
        if (cD != null)
        {
            android.view.ViewParent viewparent = cD.getParent();
            if (viewparent instanceof ViewGroup)
            {
                ((ViewGroup)viewparent).removeView(cD);
            }
        }
    }

    private int _mth0719()
    {
        int j = 0;
        int i = 0;
        if (cu == null)
        {
            Object obj2 = mContext;
            cO = new _cls1E5F(this);
            boolean flag;
            if (!cP)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            cu = new if(((Context) (obj2)), flag);
            if (cH != null)
            {
                cu.setSelector(cH);
            }
            cu.setAdapter(mAdapter);
            cu.setOnItemClickListener(cI);
            cu.setFocusable(true);
            cu.setFocusableInTouchMode(true);
            cu.setOnItemSelectedListener(new _cls1E9B(this));
            cu.setOnScrollListener(cM);
            if (cJ != null)
            {
                cu.setOnItemSelectedListener(cJ);
            }
            Object obj1 = cu;
            View view1 = cD;
            Object obj = obj1;
            if (view1 != null)
            {
                obj = new LinearLayout(((Context) (obj2)));
                ((LinearLayout) (obj)).setOrientation(1);
                obj2 = new android.widget.LinearLayout.LayoutParams(-1, 0, 1.0F);
                switch (cE)
                {
                case 1: // '\001'
                    ((LinearLayout) (obj)).addView(((View) (obj1)), ((android.view.ViewGroup.LayoutParams) (obj2)));
                    ((LinearLayout) (obj)).addView(view1);
                    break;

                case 0: // '\0'
                    ((LinearLayout) (obj)).addView(view1);
                    ((LinearLayout) (obj)).addView(((View) (obj1)), ((android.view.ViewGroup.LayoutParams) (obj2)));
                    break;

                default:
                    Log.e("ListPopupWindow", (new StringBuilder("Invalid hint position ")).append(cE).toString());
                    break;
                }
                if (ak >= 0)
                {
                    j = 0x80000000;
                    i = ak;
                } else
                {
                    j = 0;
                    i = 0;
                }
                view1.measure(android.view.View.MeasureSpec.makeMeasureSpec(i, j), 0);
                obj1 = (android.widget.LinearLayout.LayoutParams)view1.getLayoutParams();
                i = view1.getMeasuredHeight() + ((android.widget.LinearLayout.LayoutParams) (obj1)).topMargin + ((android.widget.LinearLayout.LayoutParams) (obj1)).bottomMargin;
            }
            ct.setContentView(((View) (obj)));
        } else
        {
            ct.getContentView();
            View view = cD;
            i = j;
            if (view != null)
            {
                android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)view.getLayoutParams();
                i = view.getMeasuredHeight() + layoutparams.topMargin + layoutparams.bottomMargin;
            }
        }
        int k = 0;
        Drawable drawable = ct.getBackground();
        if (drawable != null)
        {
            drawable.getPadding(_fld01C0);
            j = _fld01C0.top + _fld01C0.bottom;
            k = j;
            if (!cz)
            {
                cx = -_fld01C0.top;
                k = j;
            }
        } else
        {
            _fld01C0.setEmpty();
        }
        boolean flag1;
        if (ct.getInputMethodMode() == 2)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        int l = _mth02CB(getAnchorView(), cx, flag1);
        if (cA || cv == -1)
        {
            return l + k;
        }
        switch (ak)
        {
        case -2: 
            j = android.view.View.MeasureSpec.makeMeasureSpec(mContext.getResources().getDisplayMetrics().widthPixels - (_fld01C0.left + _fld01C0.right), 0x80000000);
            break;

        case -1: 
            j = android.view.View.MeasureSpec.makeMeasureSpec(mContext.getResources().getDisplayMetrics().widthPixels - (_fld01C0.left + _fld01C0.right), 0x40000000);
            break;

        default:
            j = android.view.View.MeasureSpec.makeMeasureSpec(ak, 0x40000000);
            break;
        }
        l = cu._mth02CB(j, 0, -1, l - i, -1);
        j = i;
        if (l > 0)
        {
            j = i + k;
        }
        return l + j;
    }

    private void _mth1D54(boolean flag)
    {
        Exception exception;
        if (cr != null)
        {
            try
            {
                cr.invoke(ct, new Object[] {
                    Boolean.valueOf(flag)
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception)
            {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    public void clearListSelection()
    {
        if if1 = cu;
        if (if1 != null)
        {
            if._mth02CA(if1, true);
            if1.requestLayout();
        }
    }

    public void dismiss()
    {
        ct.dismiss();
        _mth068A();
        ct.setContentView(null);
        cu = null;
        mHandler.removeCallbacks(cK);
    }

    public View getAnchorView()
    {
        return cG;
    }

    public Drawable getBackground()
    {
        return ct.getBackground();
    }

    public int getHorizontalOffset()
    {
        return cw;
    }

    public ListView getListView()
    {
        return cu;
    }

    public int getVerticalOffset()
    {
        if (!cz)
        {
            return 0;
        } else
        {
            return cx;
        }
    }

    public int getWidth()
    {
        return ak;
    }

    public boolean isInputMethodNotNeeded()
    {
        return ct.getInputMethodMode() == 2;
    }

    public boolean isShowing()
    {
        return ct.isShowing();
    }

    public void setAdapter(ListAdapter listadapter)
    {
        if (cF == null)
        {
            cF = new _cls02CE((byte)0);
        } else
        if (mAdapter != null)
        {
            mAdapter.unregisterDataSetObserver(cF);
        }
        mAdapter = listadapter;
        if (mAdapter != null)
        {
            listadapter.registerDataSetObserver(cF);
        }
        if (cu != null)
        {
            cu.setAdapter(mAdapter);
        }
    }

    public void setAnchorView(View view)
    {
        cG = view;
    }

    public void setBackgroundDrawable(Drawable drawable)
    {
        ct.setBackgroundDrawable(drawable);
    }

    public void setContentWidth(int i)
    {
        Drawable drawable = ct.getBackground();
        if (drawable != null)
        {
            drawable.getPadding(_fld01C0);
            ak = _fld01C0.left + _fld01C0.right + i;
            return;
        } else
        {
            setWidth(i);
            return;
        }
    }

    public void setDropDownGravity(int i)
    {
        _fld0186 = i;
    }

    public void setHorizontalOffset(int i)
    {
        cw = i;
    }

    public void setInputMethodMode(int i)
    {
        ct.setInputMethodMode(i);
    }

    public void setModal(boolean flag)
    {
        cP = flag;
        ct.setFocusable(flag);
    }

    public void setOnDismissListener(android.widget.PopupWindow.OnDismissListener ondismisslistener)
    {
        ct.setOnDismissListener(ondismisslistener);
    }

    public void setOnItemClickListener(android.widget.AdapterView.OnItemClickListener onitemclicklistener)
    {
        cI = onitemclicklistener;
    }

    public void setPromptPosition(int i)
    {
        cE = i;
    }

    public void setSelection(int i)
    {
        if if1 = cu;
        if (isShowing() && if1 != null)
        {
            if._mth02CA(if1, false);
            if1.setSelection(i);
            if (android.os.Build.VERSION.SDK_INT >= 11 && if1.getChoiceMode() != 0)
            {
                if1.setItemChecked(i, true);
            }
        }
    }

    public void setVerticalOffset(int i)
    {
        cx = i;
        cz = true;
    }

    public void setWidth(int i)
    {
        ak = i;
    }

    public void show()
    {
        int k = _mth0719();
        boolean flag = isInputMethodNotNeeded();
        FB32._mth02CA(ct, cy);
        if (ct.isShowing())
        {
            int i;
            if (ak == -1)
            {
                i = -1;
            } else
            if (ak == -2)
            {
                i = getAnchorView().getWidth();
            } else
            {
                i = ak;
            }
            if (cv == -1)
            {
                if (!flag)
                {
                    k = -1;
                }
                if (flag)
                {
                    PopupWindow popupwindow = ct;
                    byte byte0;
                    if (ak == -1)
                    {
                        byte0 = -1;
                    } else
                    {
                        byte0 = 0;
                    }
                    popupwindow.setWidth(byte0);
                    ct.setHeight(0);
                } else
                {
                    PopupWindow popupwindow1 = ct;
                    byte byte1;
                    if (ak == -1)
                    {
                        byte1 = -1;
                    } else
                    {
                        byte1 = 0;
                    }
                    popupwindow1.setWidth(byte1);
                    ct.setHeight(-1);
                }
            } else
            if (cv != -2)
            {
                k = cv;
            }
            PopupWindow popupwindow2 = ct;
            if (!cB && !cA)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            popupwindow2.setOutsideTouchable(flag);
            popupwindow2 = ct;
            View view = getAnchorView();
            int l = cw;
            int i1 = cx;
            if (i < 0)
            {
                i = -1;
            }
            if (k < 0)
            {
                k = -1;
            }
            popupwindow2.update(view, l, i1, i, k);
            return;
        }
        int j;
        if (ak == -1)
        {
            j = -1;
        } else
        if (ak == -2)
        {
            j = getAnchorView().getWidth();
        } else
        {
            j = ak;
        }
        if (cv == -1)
        {
            k = -1;
        } else
        if (cv != -2)
        {
            k = cv;
        }
        ct.setWidth(j);
        ct.setHeight(k);
        _mth1D54(true);
        PopupWindow popupwindow3 = ct;
        if (!cB && !cA)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        popupwindow3.setOutsideTouchable(flag);
        ct.setTouchInterceptor(cL);
        FB32._mth02CA(ct, getAnchorView(), cw, cx, _fld0186);
        cu.setSelection(-1);
        if (!cP || cu.isInTouchMode())
        {
            clearListSelection();
        }
        if (!cP)
        {
            mHandler.post(cN);
        }
    }

    static 
    {
        NoSuchMethodException nosuchmethodexception;
        try
        {
            cr = android/widget/PopupWindow.getDeclaredMethod("setClipToScreenEnabled", new Class[] {
                Boolean.TYPE
            });
        }
        // Misplaced declaration of an exception variable
        catch (NoSuchMethodException nosuchmethodexception)
        {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try
        {
            cs = android/widget/PopupWindow.getDeclaredMethod("getMaxAvailableHeight", new Class[] {
                android/view/View, Integer.TYPE, Boolean.TYPE
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (NoSuchMethodException nosuchmethodexception)
        {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
    }
}
