// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;

// Referenced classes of package o:
//            _cls1601, FF2C, FE70, _cls026A, 
//            FB1F

public final class FEE3 extends _cls1601
{

    final RecyclerView eH;
    public final FF2C fI = new FF2C(this);

    public FEE3(RecyclerView recyclerview)
    {
        eH = recyclerview;
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(view, accessibilityevent);
        accessibilityevent.setClassName(android/support/v7/widget/RecyclerView.getName());
        if ((view instanceof RecyclerView) && !FB48())
        {
            view = (RecyclerView)view;
            if (((RecyclerView) (view)).dG != null)
            {
                ((RecyclerView) (view)).dG.onInitializeAccessibilityEvent(accessibilityevent);
            }
        }
    }

    public final boolean performAccessibilityAction(View view, int i, Bundle bundle)
    {
        if (super.performAccessibilityAction(view, i, bundle))
        {
            return true;
        }
        if (!FB48() && eH.dG != null)
        {
            view = eH.dG;
            if (((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH == null)
            {
                return false;
            }
            boolean flag = false;
            int k = 0;
            int j = 0;
            int l = 0;
            switch (i)
            {
            default:
                j = l;
                break;

            case 8192: 
                i = j;
                if (FE70._mth02CB(((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH, -1))
                {
                    if (((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH != null)
                    {
                        i = ((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH.getHeight();
                    } else
                    {
                        i = 0;
                    }
                    if (((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH != null)
                    {
                        j = ((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH.getPaddingTop();
                    } else
                    {
                        j = 0;
                    }
                    if (((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH != null)
                    {
                        k = ((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH.getPaddingBottom();
                    } else
                    {
                        k = 0;
                    }
                    i = -(i - j - k);
                }
                j = l;
                k = i;
                if (FE70._mth02CA(((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH, -1))
                {
                    if (((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH != null)
                    {
                        j = ((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH.getWidth();
                    } else
                    {
                        j = 0;
                    }
                    if (((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH != null)
                    {
                        k = ((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH.getPaddingLeft();
                    } else
                    {
                        k = 0;
                    }
                    if (((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH != null)
                    {
                        l = ((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH.getPaddingRight();
                    } else
                    {
                        l = 0;
                    }
                    j = -(j - k - l);
                    k = i;
                }
                break;

            case 4096: 
                i = ((flag) ? 1 : 0);
                if (FE70._mth02CB(((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH, 1))
                {
                    if (((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH != null)
                    {
                        i = ((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH.getHeight();
                    } else
                    {
                        i = 0;
                    }
                    if (((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH != null)
                    {
                        j = ((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH.getPaddingTop();
                    } else
                    {
                        j = 0;
                    }
                    if (((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH != null)
                    {
                        k = ((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH.getPaddingBottom();
                    } else
                    {
                        k = 0;
                    }
                    i = i - j - k;
                }
                j = l;
                k = i;
                if (FE70._mth02CA(((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH, 1))
                {
                    if (((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH != null)
                    {
                        j = ((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH.getWidth();
                    } else
                    {
                        j = 0;
                    }
                    if (((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH != null)
                    {
                        k = ((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH.getPaddingLeft();
                    } else
                    {
                        k = 0;
                    }
                    int i1;
                    if (((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH != null)
                    {
                        i1 = ((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH.getPaddingRight();
                    } else
                    {
                        i1 = 0;
                    }
                    j = j - k - i1;
                    k = i;
                }
                break;
            }
            if (k == 0 && j == 0)
            {
                return false;
            } else
            {
                ((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH.scrollBy(j, k);
                return true;
            }
        } else
        {
            return false;
        }
    }

    public final void _mth02CA(View view, _cls026A _pcls026a)
    {
        super._mth02CA(view, _pcls026a);
        _pcls026a.setClassName(android/support/v7/widget/RecyclerView.getName());
        if (!FB48() && eH.dG != null)
        {
            view = eH.dG;
            Object obj = ((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH.dz;
            obj = ((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH.ek;
            if (FE70._mth02CB(((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH, -1) || FE70._mth02CA(((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH, -1))
            {
                _pcls026a.addAction(8192);
                _pcls026a.setScrollable(true);
            }
            if (FE70._mth02CB(((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH, 1) || FE70._mth02CA(((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH, 1))
            {
                _pcls026a.addAction(4096);
                _pcls026a.setScrollable(true);
            }
            int i;
            if (((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH == null || RecyclerView._mth02BB(((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH) == null)
            {
                i = 1;
            } else
            if (view._mth027E())
            {
                i = RecyclerView._mth02BB(((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH).getItemCount();
            } else
            {
                i = 1;
            }
            int j;
            if (((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH == null || RecyclerView._mth02BB(((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH) == null)
            {
                j = 1;
            } else
            if (view._mth026A())
            {
                j = RecyclerView._mth02BB(((android.support.v7.widget.RecyclerView._cls02BB) (view)).eH).getItemCount();
            } else
            {
                j = 1;
            }
            _pcls026a._mth02BB(_cls026A._cls02BD._mth02CB(i, j, false, 0));
        }
    }

    boolean FB48()
    {
label0:
        {
            RecyclerView recyclerview = eH;
            if (recyclerview.dN && !recyclerview.dU)
            {
                boolean flag;
                if (recyclerview.dB.s.size() > 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    break label0;
                }
            }
            return true;
        }
        return false;
    }
}
