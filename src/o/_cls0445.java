// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package o:
//            _cls0491, _cls02E0, _cls1541, _cls1E3B, 
//            _cls0621, _cls03F3

public class _cls0445
    implements android.widget.AdapterView.OnItemClickListener, android.view.View.OnKeyListener, android.view.ViewTreeObserver.OnGlobalLayoutListener, android.widget.PopupWindow.OnDismissListener, _cls0491
{
    /* member class not found */
    class if {}


    static final int FF73;
    private final Context mContext;
    private ViewTreeObserver _fld0134;
    public _cls0491.if _fld0141;
    private FrameLayout _fld014D;
    private boolean _fld0163;
    private int _fld0164;
    public int _fld0186;
    private final LayoutInflater _fld04AE;
    public boolean _fld1627;
    private final _cls02E0 FB30;
    private final if FF77;
    private final boolean FF78;
    private final int FF79;
    private final int FF7D;
    private final int FF81;
    public View FF8A;
    public _cls1E3B FF93;

    public _cls0445(Context context, _cls02E0 _pcls02e0, View view, boolean flag, int i)
    {
        this(context, _pcls02e0, view, flag, i, 0);
    }

    private _cls0445(Context context, _cls02E0 _pcls02e0, View view, boolean flag, int i, int j)
    {
        _fld0186 = 0;
        mContext = context;
        _fld04AE = LayoutInflater.from(context);
        FB30 = _pcls02e0;
        FF77 = new if(FB30);
        FF78 = flag;
        FF7D = i;
        FF81 = 0;
        Resources resources = context.getResources();
        FF79 = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(_cls1ECA.if.abc_config_prefDialogWidth));
        FF8A = view;
        _pcls02e0._fld5B80.add(new WeakReference(this));
        _mth02CA(context, _pcls02e0);
        _pcls02e0._fld1F3F = true;
    }

    private _cls0445(Context context, _cls0621 _pcls0621, View view)
    {
        this(context, ((_cls02E0) (_pcls0621)), view, false, _cls1541.popupMenuStyle);
    }

    static boolean _mth02CA(_cls0445 _pcls0445)
    {
        return _pcls0445.FF78;
    }

    static LayoutInflater _mth02CB(_cls0445 _pcls0445)
    {
        return _pcls0445._fld04AE;
    }

    static _cls02E0 _mth02CE(_cls0445 _pcls0445)
    {
        return _pcls0445.FB30;
    }

    private int _mth207F()
    {
        int j = 0;
        View view = null;
        int l = 0;
        if if1 = FF77;
        int j1 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int k1 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int l1 = if1.getCount();
        for (int i = 0; i < l1;)
        {
            int i1 = if1.getItemViewType(i);
            int k = l;
            if (i1 != l)
            {
                k = i1;
                view = null;
            }
            if (_fld014D == null)
            {
                _fld014D = new FrameLayout(mContext);
            }
            view = if1.getView(i, view, _fld014D);
            view.measure(j1, k1);
            i1 = view.getMeasuredWidth();
            if (i1 >= FF79)
            {
                return FF79;
            }
            l = j;
            if (i1 > j)
            {
                l = i1;
            }
            i++;
            j = l;
            l = k;
        }

        return j;
    }

    public final void dismiss()
    {
        boolean flag;
        if (FF93 != null && FF93.isShowing())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            FF93.dismiss();
        }
    }

    public void onDismiss()
    {
        FF93 = null;
        FB30.close();
        if (_fld0134 != null)
        {
            if (!_fld0134.isAlive())
            {
                _fld0134 = FF8A.getViewTreeObserver();
            }
            _fld0134.removeGlobalOnLayoutListener(this);
            _fld0134 = null;
        }
    }

    public void onGlobalLayout()
    {
        boolean flag;
        if (FF93 != null && FF93.isShowing())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            View view = FF8A;
            if (view == null || !view.isShown())
            {
                dismiss();
                return;
            }
            boolean flag1;
            if (FF93 != null && FF93.isShowing())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                FF93.show();
            }
        }
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = FF77;
        if._mth02CA(adapterview)._mth02CA(adapterview._mth02E1(i), null, 0);
    }

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (keyevent.getAction() == 1 && i == 82)
        {
            dismiss();
            return true;
        } else
        {
            return false;
        }
    }

    public final void _mth02CA(Context context, _cls02E0 _pcls02e0)
    {
    }

    public final boolean _mth02CA(_cls0621 _pcls0621)
    {
        if (_pcls0621.hasVisibleItems())
        {
            _cls0445 _lcls0445 = new _cls0445(mContext, _pcls0621, FF8A);
            _lcls0445._fld0141 = _fld0141;
            boolean flag1 = false;
            int j = _pcls0621.size();
            int i = 0;
            boolean flag;
            do
            {
                flag = flag1;
                if (i >= j)
                {
                    break;
                }
                MenuItem menuitem = _pcls0621.getItem(i);
                if (menuitem.isVisible() && menuitem.getIcon() != null)
                {
                    flag = true;
                    break;
                }
                i++;
            } while (true);
            _lcls0445._fld1627 = flag;
            if (_lcls0445._mth1D64())
            {
                if (_fld0141 != null)
                {
                    _fld0141._mth02CE(_pcls0621);
                }
                return true;
            }
        }
        return false;
    }

    public final void _mth02CB(_cls02E0 _pcls02e0, boolean flag)
    {
        if (_pcls02e0 != FB30)
        {
            return;
        }
        dismiss();
        if (_fld0141 != null)
        {
            _fld0141._mth02CB(_pcls02e0, flag);
        }
    }

    public final boolean _mth02CB(_cls03F3 _pcls03f3)
    {
        return false;
    }

    public final boolean _mth02CE(_cls03F3 _pcls03f3)
    {
        return false;
    }

    public final boolean _mth05F2()
    {
        return false;
    }

    public final void _mth1427(boolean flag)
    {
        _fld0163 = false;
        FF77.notifyDataSetChanged();
    }

    public final boolean _mth1D64()
    {
        FF93 = new _cls1E3B(mContext, null, FF7D, FF81);
        FF93.setOnDismissListener(this);
        FF93.setOnItemClickListener(this);
        FF93.setAdapter(FF77);
        FF93.setModal(true);
        View view = FF8A;
        if (view != null)
        {
            boolean flag;
            if (_fld0134 == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            _fld0134 = view.getViewTreeObserver();
            if (flag)
            {
                _fld0134.addOnGlobalLayoutListener(this);
            }
            FF93.setAnchorView(view);
            FF93.setDropDownGravity(_fld0186);
        } else
        {
            return false;
        }
        if (!_fld0163)
        {
            _fld0164 = _mth207F();
            _fld0163 = true;
        }
        FF93.setContentWidth(_fld0164);
        FF93.setInputMethodMode(2);
        FF93.show();
        FF93.getListView().setOnKeyListener(this);
        return true;
    }

    static 
    {
        FF73 = _cls0285.if.abc_popup_menu_item_layout;
    }
}
