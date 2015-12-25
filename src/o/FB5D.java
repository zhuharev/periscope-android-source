// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

// Referenced classes of package o:
//            FBE6, _cls1541, _cls0715, FB33, 
//            _cls03C4

public class FB5D extends Button
    implements FBE6
{

    private final _cls0715 E;
    private final FB33 F;
    private final _cls03C4 G;

    public FB5D(Context context)
    {
        this(context, null);
    }

    public FB5D(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, _cls1541.buttonStyle);
    }

    public FB5D(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        E = _cls0715._mth1FBE(getContext());
        F = new FB33(this, E);
        F._mth02CA(attributeset, i);
        G = _cls03C4._mth02CA(this);
        G._mth02CA(attributeset, i);
        G._mth156A();
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        if (F != null)
        {
            F._mth05E8();
        }
        if (G != null)
        {
            G._mth156A();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/Button.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo)
    {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/Button.getName());
    }

    public void setBackgroundDrawable(Drawable drawable)
    {
        super.setBackgroundDrawable(drawable);
        if (F != null)
        {
            F._mth02BC(drawable);
        }
    }

    public void setBackgroundResource(int i)
    {
        super.setBackgroundResource(i);
        if (F != null)
        {
            F._mth1D55(i);
        }
    }

    public void setSupportAllCaps(boolean flag)
    {
        if (G != null)
        {
            G.setAllCaps(flag);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorstatelist)
    {
        if (F != null)
        {
            F.setSupportBackgroundTintList(colorstatelist);
        }
    }

    public void setSupportBackgroundTintMode(android.graphics.PorterDuff.Mode mode)
    {
        if (F != null)
        {
            F.setSupportBackgroundTintMode(mode);
        }
    }

    public void setTextAppearance(Context context, int i)
    {
        super.setTextAppearance(context, i);
        if (G != null)
        {
            G._mth141D(context, i);
        }
    }
}
