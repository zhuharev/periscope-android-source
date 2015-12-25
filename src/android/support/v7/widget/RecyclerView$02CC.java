// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.util.Log;
import android.view.View;
import o.FE70;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView

public static abstract class fy
{

    public int bX;
    long fA;
    int fB;
    int fC;
    eL fD;
    eL fE;
    private int fF;
    eL fG;
    RecyclerView fH;
    public final View fy;
    int fz;
    public int _fld0E20;

    public final int getAdapterPosition()
    {
        if (fH == null)
        {
            return -1;
        } else
        {
            return RecyclerView._mth02CA(fH, this);
        }
    }

    public final long getItemId()
    {
        return fA;
    }

    public final int getItemViewType()
    {
        return fB;
    }

    public final int getLayoutPosition()
    {
        if (fC == -1)
        {
            return bX;
        } else
        {
            return fC;
        }
    }

    public final int getOldPosition()
    {
        return fz;
    }

    public final int getPosition()
    {
        if (fC == -1)
        {
            return bX;
        } else
        {
            return fC;
        }
    }

    final void resetInternal()
    {
        _fld0E20 = 0;
        bX = -1;
        fz = -1;
        fA = -1L;
        fC = -1;
        fF = 0;
        fD = null;
        fE = null;
    }

    public final void setIsRecyclable(boolean flag)
    {
        int i;
        if (flag)
        {
            i = fF - 1;
        } else
        {
            i = fF + 1;
        }
        fF = i;
        if (fF < 0)
        {
            fF = 0;
            Log.e("View", (new StringBuilder("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ")).append(this).toString());
            return;
        }
        if (!flag && fF == 1)
        {
            _fld0E20 = _fld0E20 | 0x10;
            return;
        }
        if (flag && fF == 0)
        {
            _fld0E20 = _fld0E20 & 0xffffffef;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder;
        boolean flag;
label0:
        {
label1:
            {
                stringbuilder = new StringBuilder((new StringBuilder("ViewHolder{")).append(Integer.toHexString(hashCode())).append(" position=").append(bX).append(" id=").append(fA).append(", oldPos=").append(fz).append(", pLpos:").append(fC).toString());
                if (fG != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    stringbuilder.append(" scrap");
                }
                if ((_fld0E20 & 4) != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    stringbuilder.append(" invalid");
                }
                if ((_fld0E20 & 1) != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    stringbuilder.append(" unbound");
                }
                if ((_fld0E20 & 2) != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    stringbuilder.append(" update");
                }
                if ((_fld0E20 & 8) != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    stringbuilder.append(" removed");
                }
                if ((_fld0E20 & 0x80) != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    stringbuilder.append(" ignored");
                }
                if ((_fld0E20 & 0x40) != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    stringbuilder.append(" changed");
                }
                if ((_fld0E20 & 0x100) != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    stringbuilder.append(" tmpDetached");
                }
                if ((_fld0E20 & 0x10) == 0 && !FE70._mth037A(fy))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    stringbuilder.append((new StringBuilder(" not recyclable(")).append(fF).append(")").toString());
                }
                if ((_fld0E20 & 0x200) == 0)
                {
                    if ((_fld0E20 & 4) != 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (!flag)
                    {
                        break label1;
                    }
                }
                flag = true;
                break label0;
            }
            flag = false;
        }
        if (flag)
        {
            stringbuilder.append("undefined adapter position");
        }
        if (fy.getParent() == null)
        {
            stringbuilder.append(" no parent");
        }
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    public final void _mth02BC(int i, boolean flag)
    {
        if (fz == -1)
        {
            fz = bX;
        }
        if (fC == -1)
        {
            fC = bX;
        }
        if (flag)
        {
            fC = fC + i;
        }
        bX = bX + i;
        if (fy.getLayoutParams() != null)
        {
            ((fy)fy.getLayoutParams()).eL = true;
        }
    }

    public (View view)
    {
        bX = -1;
        fz = -1;
        fA = -1L;
        fB = -1;
        fC = -1;
        fD = null;
        fE = null;
        fF = 0;
        fG = null;
        if (view == null)
        {
            throw new IllegalArgumentException("itemView may not be null");
        } else
        {
            fy = view;
            return;
        }
    }
}
