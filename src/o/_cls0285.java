// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

// Referenced classes of package o:
//            _cls03AF, _cls1FD1, _cls1541, FE70, 
//            _cls1E37, _cls09F3

public class _cls0285
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}


    public static final int action_bar = 0x7f0d004e;
    public static final int action_bar_activity_content = 0x7f0d0000;
    public static final int action_bar_container = 0x7f0d004d;
    public static final int action_bar_subtitle = 0x7f0d002f;
    public static final int action_bar_title = 0x7f0d002e;
    public static final int action_context_bar = 0x7f0d004f;
    public static final int action_menu_presenter = 0x7f0d0003;
    public static final int action_mode_bar_stub = 0x7f0d004a;
    public static final int action_mode_close_button = 0x7f0d0030;
    public static final int activity_chooser_view_content = 0x7f0d0031;
    public static final int custom = 0x7f0d0044;
    public static final int decor_content_parent = 0x7f0d004c;
    public static final int default_activity_button = 0x7f0d0034;
    public static final int edit_query = 0x7f0d0050;
    public static final int expand_activities_button = 0x7f0d0032;
    public static final int icon = 0x7f0d0036;
    public static final int image = 0x7f0d0033;
    public static final int list_item = 0x7f0d0035;
    public static final int search_button = 0x7f0d0053;
    public static final int search_close_btn = 0x7f0d0058;
    public static final int search_edit_frame = 0x7f0d0054;
    public static final int search_go_btn = 0x7f0d005a;
    public static final int search_mag_icon = 0x7f0d0055;
    public static final int search_plate = 0x7f0d0056;
    public static final int search_src_text = 0x7f0d0057;
    public static final int search_voice_btn = 0x7f0d005b;
    public static final int shortcut = 0x7f0d0047;
    public static final int split_action_bar = 0x7f0d000b;
    public static final int submit_area = 0x7f0d0059;
    public static final int title = 0x7f0d0037;
    public static final int _fld1502 = 0x7f0d003d;
    public static final int _fld1503 = 0x7f0d0038;
    public static final int _fld1526 = 0x7f0d003e;
    public static final int _fld1529 = 0x7f0d0043;
    public static final int _fld152A = 0x7f0d003a;
    public static final int _fld152E = 0x7f0d0042;
    public static final int _fld1624 = 0x7f0d003f;
    public static final int _fld1690 = 0x7f0d0040;
    public static final int _fld1D08 = 0x7f0d0039;
    public static final int _fld1D0F = 0x7f0d0041;
    public static final int _fld1D22 = 0x7f0d003c;
    public static final int _fld1D23 = 0x7f0d003b;
    public ListAdapter mAdapter;
    final Context mContext;
    public CharSequence mTitle;
    View mView;
    final _cls1E37 _fld03C5;
    final Window _fld0422;
    CharSequence _fld043E;
    public ListView _fld0443;
    int _fld044D;
    int _fld0454;
    int _fld04F5;
    int _fld050D;
    int _fld0585;
    boolean _fld05D0;
    Button _fld05E2;
    CharSequence _fld0629;
    Message _fld0646;
    Button _fld066E;
    CharSequence _fld0671;
    Message _fld0688;
    Button _fld0699;
    CharSequence _fld093D;
    Message _fld0E1A;
    NestedScrollView _fld0E22;
    public int _fld0E30;
    public Drawable _fld0EB2;
    public ImageView _fld1433;
    public TextView _fld1438;
    TextView _fld1489;
    public View _fld148B;
    public int _fld148D;
    int _fld1490;
    int _fld14D3;
    public int _fld14D5;
    int _fld14D7;
    private int _fld14DA;
    public int _fld14FA;
    private int _fld14FB;
    _cls02CA _fld14FE;
    final _cls03AF _fld14FF;

    public _cls0285()
    {
    }

    public _cls0285(Context context, _cls09F3 _pcls09f3, Window window)
    {
        _fld05D0 = false;
        _fld0E30 = 0;
        _fld148D = -1;
        _fld14FB = 0;
        _fld14FF = new _cls03AF(this);
        mContext = context;
        _fld03C5 = _pcls09f3;
        _fld0422 = window;
        _fld14FE = new _cls02CA(_pcls09f3);
        context = context.obtainStyledAttributes(null, _cls1FD1.AlertDialog, _cls1541.alertDialogStyle, 0);
        _fld1490 = context.getResourceId(_cls1FD1.AlertDialog_android_layout, 0);
        _fld14D3 = context.getResourceId(_cls1FD1.AlertDialog_buttonPanelSideLayout, 0);
        _fld14D5 = context.getResourceId(_cls1FD1.AlertDialog_listLayout, 0);
        _fld14D7 = context.getResourceId(_cls1FD1.AlertDialog_multiChoiceItemLayout, 0);
        _fld14DA = context.getResourceId(_cls1FD1.AlertDialog_singleChoiceItemLayout, 0);
        _fld14FA = context.getResourceId(_cls1FD1.AlertDialog_listItemLayout, 0);
        context.recycle();
    }

    static void _mth02CA(ViewGroup viewgroup, View view, View view1)
    {
        if (view != null)
        {
            byte byte0;
            if (FE70._mth02CB(viewgroup, -1))
            {
                byte0 = 0;
            } else
            {
                byte0 = 4;
            }
            view.setVisibility(byte0);
        }
        if (view1 != null)
        {
            byte byte1;
            if (FE70._mth02CB(viewgroup, 1))
            {
                byte1 = 0;
            } else
            {
                byte1 = 4;
            }
            view1.setVisibility(byte1);
        }
    }

    static ViewGroup _mth02CB(View view, View view1)
    {
        if (view == null)
        {
            view = view1;
            if (view1 instanceof ViewStub)
            {
                view = ((ViewStub)view1).inflate();
            }
            return (ViewGroup)view;
        }
        if (view1 != null)
        {
            android.view.ViewParent viewparent = view1.getParent();
            if (viewparent instanceof ViewGroup)
            {
                ((ViewGroup)viewparent).removeView(view1);
            }
        }
        view1 = view;
        if (view instanceof ViewStub)
        {
            view1 = ((ViewStub)view).inflate();
        }
        return (ViewGroup)view1;
    }

    static boolean _mth1423(View view)
    {
        if (view.onCheckIsTextEditor())
        {
            return true;
        }
        if (!(view instanceof ViewGroup))
        {
            return false;
        }
        view = (ViewGroup)view;
        for (int i = view.getChildCount(); i > 0;)
        {
            int j = i - 1;
            i = j;
            if (_mth1423(view.getChildAt(j)))
            {
                return true;
            }
        }

        return false;
    }
}
