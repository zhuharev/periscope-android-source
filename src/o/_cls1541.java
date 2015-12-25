// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


public class _cls1541
{

    public static final int actionBarPopupTheme = 0x7f0100a0;
    public static final int actionBarSize = 0x7f0100a5;
    public static final int actionBarStyle = 0x7f0100a1;
    public static final int actionBarTabBarStyle = 0x7f01009c;
    public static final int actionBarTabStyle = 0x7f01009b;
    public static final int actionBarTabTextStyle = 0x7f01009d;
    public static final int actionBarTheme = 0x7f0100a3;
    public static final int actionBarWidgetTheme = 0x7f0100a4;
    public static final int actionDropDownStyle = 0x7f0100bc;
    public static final int actionModePopupWindowStyle = 0x7f0100b6;
    public static final int actionModeStyle = 0x7f0100aa;
    public static final int actionOverflowButtonStyle = 0x7f01009e;
    public static final int actionOverflowMenuStyle = 0x7f01009f;
    public static final int alertDialogStyle = 0x7f0100ea;
    public static final int alertDialogTheme = 0x7f0100ed;
    public static final int autoCompleteTextViewStyle = 0x7f0100f2;
    public static final int buttonStyle = 0x7f0100f3;
    public static final int checkboxStyle = 0x7f0100f5;
    public static final int colorAccent = 0x7f0100e3;
    public static final int colorButtonNormal = 0x7f0100e7;
    public static final int colorControlActivated = 0x7f0100e5;
    public static final int colorControlHighlight = 0x7f0100e6;
    public static final int colorControlNormal = 0x7f0100e4;
    public static final int colorSwitchThumbNormal = 0x7f0100e8;
    public static final int dialogTheme = 0x7f0100b9;
    public static final int dropDownListViewStyle = 0x7f0100d9;
    public static final int editTextStyle = 0x7f0100f7;
    public static final int imageButtonStyle = 0x7f0100cf;
    public static final int listPopupWindowStyle = 0x7f0100da;
    public static final int panelMenuListTheme = 0x7f0100df;
    public static final int popupMenuStyle = 0x7f0100cb;
    public static final int radioButtonStyle = 0x7f0100f8;
    public static final int ratingBarStyle = 0x7f0100f9;
    public static final int searchViewStyle = 0x7f0100d3;
    public static final int seekBarStyle = 0x7f0100fa;
    public static final int spinnerStyle = 0x7f0100fb;
    public static final int textAllCaps = 0x7f010030;
    public static final int textColorSearchUrl = 0x7f0100d2;
    public static final int toolbarNavigationButtonStyle = 0x7f0100ca;
    public static final int toolbarStyle = 0x7f0100c9;
    final Object _fld309D[];
    int _fld30FC;

    public _cls1541()
    {
    }

    public _cls1541(int i)
    {
        _fld309D = new Object[30];
    }

    public boolean _mth02CA(FB1F._cls02CA _pcls02ca)
    {
        if (_mth141D(_pcls02ca))
        {
            throw new IllegalStateException("Already in the pool!");
        }
        if (_fld30FC < _fld309D.length)
        {
            _fld309D[_fld30FC] = _pcls02ca;
            _fld30FC = _fld30FC + 1;
            return true;
        } else
        {
            return false;
        }
    }

    boolean _mth141D(Object obj)
    {
        for (int i = 0; i < _fld30FC; i++)
        {
            if (_fld309D[i] == obj)
            {
                return true;
            }
        }

        return false;
    }

    public Object _mth1540()
    {
        if (_fld30FC > 0)
        {
            int i = _fld30FC - 1;
            Object obj = _fld309D[i];
            _fld309D[i] = null;
            _fld30FC = _fld30FC - 1;
            return obj;
        } else
        {
            return null;
        }
    }
}
