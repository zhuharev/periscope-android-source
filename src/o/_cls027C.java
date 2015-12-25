// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

// Referenced classes of package o:
//            _cls1FD1, _cls0285, _cls03F3, _cls02E0

public class _cls027C extends LinearLayout
    implements _cls05DA.if
{

    private Context mContext;
    private LayoutInflater _fld04AE;
    private _cls03F3 _fld0E25;
    private ImageView _fld1433;
    private TextView _fld1438;
    private RadioButton _fld15AC;
    private CheckBox _fld15BD;
    private TextView _fld15BE;
    private Drawable _fld15BF;
    private int _fld15C1;
    private Context _fld1605;
    private boolean _fld1623;
    private int _fld1626;
    private boolean _fld1627;

    public _cls027C(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public _cls027C(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset);
        mContext = context;
        attributeset = context.obtainStyledAttributes(attributeset, _cls1FD1.MenuView, i, 0);
        _fld15BF = attributeset.getDrawable(_cls1FD1.MenuView_android_itemBackground);
        _fld15C1 = attributeset.getResourceId(_cls1FD1.MenuView_android_itemTextAppearance, -1);
        _fld1623 = attributeset.getBoolean(_cls1FD1.MenuView_preserveIconSpacing, false);
        _fld1605 = context;
        attributeset.recycle();
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        setBackgroundDrawable(_fld15BF);
        _fld1438 = (TextView)findViewById(_cls0285.title);
        if (_fld15C1 != -1)
        {
            _fld1438.setTextAppearance(_fld1605, _fld15C1);
        }
        _fld15BE = (TextView)findViewById(_cls0285.shortcut);
    }

    protected void onMeasure(int i, int j)
    {
        if (_fld1433 != null && _fld1623)
        {
            android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
            android.widget.LinearLayout.LayoutParams layoutparams1 = (android.widget.LinearLayout.LayoutParams)_fld1433.getLayoutParams();
            if (layoutparams.height > 0 && layoutparams1.width <= 0)
            {
                layoutparams1.width = layoutparams.height;
            }
        }
        super.onMeasure(i, j);
    }

    public void setCheckable(boolean flag)
    {
        if (!flag && _fld15AC == null && _fld15BD == null)
        {
            return;
        }
        boolean flag1;
        if ((_fld0E25._fld0E20 & 4) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Object obj;
        Object obj1;
        if (flag1)
        {
            if (_fld15AC == null)
            {
                if (_fld04AE == null)
                {
                    _fld04AE = LayoutInflater.from(mContext);
                }
                _fld15AC = (RadioButton)_fld04AE.inflate(_cls0285.if.abc_list_menu_item_radio, this, false);
                addView(_fld15AC);
            }
            obj = _fld15AC;
            obj1 = _fld15BD;
        } else
        {
            if (_fld15BD == null)
            {
                if (_fld04AE == null)
                {
                    _fld04AE = LayoutInflater.from(mContext);
                }
                _fld15BD = (CheckBox)_fld04AE.inflate(_cls0285.if.abc_list_menu_item_checkbox, this, false);
                addView(_fld15BD);
            }
            obj = _fld15BD;
            obj1 = _fld15AC;
        }
        if (flag)
        {
            ((CompoundButton) (obj)).setChecked(_fld0E25.isChecked());
            byte byte0;
            if (flag)
            {
                byte0 = 0;
            } else
            {
                byte0 = 8;
            }
            if (((CompoundButton) (obj)).getVisibility() != byte0)
            {
                ((CompoundButton) (obj)).setVisibility(byte0);
            }
            if (obj1 != null && ((CompoundButton) (obj1)).getVisibility() != 8)
            {
                ((CompoundButton) (obj1)).setVisibility(8);
            }
            return;
        }
        if (_fld15BD != null)
        {
            _fld15BD.setVisibility(8);
        }
        if (_fld15AC != null)
        {
            _fld15AC.setVisibility(8);
        }
    }

    public void setChecked(boolean flag)
    {
        boolean flag1;
        if ((_fld0E25._fld0E20 & 4) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Object obj;
        if (flag1)
        {
            if (_fld15AC == null)
            {
                if (_fld04AE == null)
                {
                    _fld04AE = LayoutInflater.from(mContext);
                }
                _fld15AC = (RadioButton)_fld04AE.inflate(_cls0285.if.abc_list_menu_item_radio, this, false);
                addView(_fld15AC);
            }
            obj = _fld15AC;
        } else
        {
            if (_fld15BD == null)
            {
                if (_fld04AE == null)
                {
                    _fld04AE = LayoutInflater.from(mContext);
                }
                _fld15BD = (CheckBox)_fld04AE.inflate(_cls0285.if.abc_list_menu_item_checkbox, this, false);
                addView(_fld15BD);
            }
            obj = _fld15BD;
        }
        ((CompoundButton) (obj)).setChecked(flag);
    }

    public void setForceShowIcon(boolean flag)
    {
        _fld1627 = flag;
        _fld1623 = flag;
    }

    public void setIcon(Drawable drawable)
    {
        _cls02E0 _lcls02e0 = _fld0E25.FB30;
        boolean flag;
        if (_fld1627)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag && !_fld1623)
        {
            return;
        }
        if (_fld1433 == null && drawable == null && !_fld1623)
        {
            return;
        }
        if (_fld1433 == null)
        {
            if (_fld04AE == null)
            {
                _fld04AE = LayoutInflater.from(mContext);
            }
            _fld1433 = (ImageView)_fld04AE.inflate(_cls0285.if.abc_list_menu_item_icon, this, false);
            addView(_fld1433, 0);
        }
        if (drawable != null || _fld1623)
        {
            ImageView imageview = _fld1433;
            if (!flag)
            {
                drawable = null;
            }
            imageview.setImageDrawable(drawable);
            if (_fld1433.getVisibility() != 0)
            {
                _fld1433.setVisibility(0);
                return;
            }
        } else
        {
            _fld1433.setVisibility(8);
        }
    }

    public void setShortcut(boolean flag, char c)
    {
label0:
        {
label1:
            {
label2:
                {
                    if (!flag)
                    {
                        break label1;
                    }
                    _cls03F3 _lcls03f3 = _fld0E25;
                    if (_lcls03f3.FB30._mth14EA())
                    {
                        if (_lcls03f3.FB30._mth14BE())
                        {
                            c = _lcls03f3._fld0E16;
                        } else
                        {
                            c = _lcls03f3._fld0E05;
                        }
                        if (c != 0)
                        {
                            c = '\001';
                            break label2;
                        }
                    }
                    c = '\0';
                }
                if (c != 0)
                {
                    c = '\0';
                    break label0;
                }
            }
            c = '\b';
        }
        if (c == 0)
        {
            TextView textview = _fld15BE;
            Object obj = _fld0E25;
            char c1;
            if (((_cls03F3) (obj)).FB30._mth14BE())
            {
                c1 = ((_cls03F3) (obj))._fld0E16;
            } else
            {
                c1 = ((_cls03F3) (obj))._fld0E05;
            }
            if (c1 == 0)
            {
                obj = "";
            } else
            {
                obj = new StringBuilder(null);
                switch (c1)
                {
                case 10: // '\n'
                    ((StringBuilder) (obj)).append(null);
                    break;

                case 8: // '\b'
                    ((StringBuilder) (obj)).append(null);
                    break;

                case 32: // ' '
                    ((StringBuilder) (obj)).append(null);
                    break;

                default:
                    ((StringBuilder) (obj)).append(c1);
                    break;
                }
                obj = ((StringBuilder) (obj)).toString();
            }
            textview.setText(((CharSequence) (obj)));
        }
        if (_fld15BE.getVisibility() != c)
        {
            _fld15BE.setVisibility(c);
        }
    }

    public void setTitle(CharSequence charsequence)
    {
        if (charsequence != null)
        {
            _fld1438.setText(charsequence);
            if (_fld1438.getVisibility() != 0)
            {
                _fld1438.setVisibility(0);
                return;
            }
        } else
        if (_fld1438.getVisibility() != 8)
        {
            _fld1438.setVisibility(8);
        }
    }

    public final boolean _mth02BA()
    {
        return false;
    }

    public final void _mth02CA(_cls03F3 _pcls03f3, int i)
    {
        boolean flag;
label0:
        {
            _fld0E25 = _pcls03f3;
            _fld1626 = 0;
            if (_pcls03f3.isVisible())
            {
                i = 0;
            } else
            {
                i = 8;
            }
            setVisibility(i);
            CharSequence charsequence;
            if (this != null && _mth02BA())
            {
                charsequence = _pcls03f3.getTitleCondensed();
            } else
            {
                charsequence = _pcls03f3.getTitle();
            }
            setTitle(charsequence);
            setCheckable(_pcls03f3.isCheckable());
            if (_pcls03f3.FB30._mth14EA())
            {
                if (_pcls03f3.FB30._mth14BE())
                {
                    i = _pcls03f3._fld0E16;
                } else
                {
                    i = _pcls03f3._fld0E05;
                }
                if (i != 0)
                {
                    flag = true;
                    break label0;
                }
            }
            flag = false;
        }
        char c;
        if (_pcls03f3.FB30._mth14BE())
        {
            c = _pcls03f3._fld0E16;
        } else
        {
            c = _pcls03f3._fld0E05;
        }
        setShortcut(flag, c);
        setIcon(_pcls03f3.getIcon());
        setEnabled(_pcls03f3.isEnabled());
    }

    public final _cls03F3 FEE7()
    {
        return _fld0E25;
    }
}
