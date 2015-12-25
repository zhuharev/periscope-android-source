// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package o:
//            FE77, _cls1D53

public final class FE7D extends MenuInflater
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}


    private static final Class _fld0109[];
    private static final Class _fld010D[];
    private Context mContext;
    private final Object _fld0176[];
    private final Object _fld017C[];
    private Object _fld01A8;

    public FE7D(Context context)
    {
        super(context);
        mContext = context;
        _fld0176 = (new Object[] {
            context
        });
        _fld017C = _fld0176;
    }

    private Object _mth02BC(Context context)
    {
        do
        {
            if (context instanceof Activity)
            {
                return context;
            }
            if (context instanceof ContextWrapper)
            {
                context = ((ContextWrapper)context).getBaseContext();
            } else
            {
                return context;
            }
        } while (true);
    }

    static Context _mth02CA(FE7D fe7d)
    {
        return fe7d.mContext;
    }

    private void _mth02CA(XmlPullParser xmlpullparser, AttributeSet attributeset, Menu menu)
    {
        _cls02CA _lcls02ca = new _cls02CA(menu);
        int j = xmlpullparser.getEventType();
        boolean flag2 = false;
        Menu menu1 = null;
        int i;
        int k;
        do
        {
            if (j == 2)
            {
                menu = xmlpullparser.getName();
                if (menu.equals("menu"))
                {
                    i = xmlpullparser.next();
                } else
                {
                    throw new RuntimeException((new StringBuilder("Expecting menu, got ")).append(menu).toString());
                }
                break;
            }
            k = xmlpullparser.next();
            i = k;
            j = i;
        } while (k != 1);
        boolean flag1 = false;
        int l = i;
        boolean flag3;
        for (; !flag1; flag1 = flag3)
        {
            boolean flag;
            switch (l)
            {
            default:
                flag = flag2;
                menu = menu1;
                flag3 = flag1;
                break;

            case 2: // '\002'
                flag = flag2;
                menu = menu1;
                flag3 = flag1;
                if (flag2)
                {
                    break;
                }
                menu = xmlpullparser.getName();
                if (menu.equals("group"))
                {
                    _lcls02ca._mth02CA(attributeset);
                    flag = flag2;
                    menu = menu1;
                    flag3 = flag1;
                    break;
                }
                if (menu.equals("item"))
                {
                    _lcls02ca._mth02CB(attributeset);
                    flag = flag2;
                    menu = menu1;
                    flag3 = flag1;
                    break;
                }
                if (menu.equals("menu"))
                {
                    _mth02CA(xmlpullparser, attributeset, ((Menu) (_lcls02ca.FE7B())));
                    flag = flag2;
                    menu = menu1;
                    flag3 = flag1;
                } else
                {
                    flag = true;
                    flag3 = flag1;
                }
                break;

            case 3: // '\003'
                String s = xmlpullparser.getName();
                if (flag2 && s.equals(menu1))
                {
                    flag = false;
                    menu = null;
                    flag3 = flag1;
                    break;
                }
                if (s.equals("group"))
                {
                    _lcls02ca._fld022F = 0;
                    _lcls02ca._fld0262 = 0;
                    _lcls02ca._fld028E = 0;
                    _lcls02ca._fld029D = 0;
                    _lcls02ca._fld02AD = true;
                    _lcls02ca._fld03BB = true;
                    flag = flag2;
                    menu = menu1;
                    flag3 = flag1;
                    break;
                }
                if (s.equals("item"))
                {
                    flag = flag2;
                    menu = menu1;
                    flag3 = flag1;
                    if (_lcls02ca._fld03CB)
                    {
                        break;
                    }
                    if (_lcls02ca._fld0693 != null && _lcls02ca._fld0693.hasSubMenu())
                    {
                        _lcls02ca.FE7B();
                        flag = flag2;
                        menu = menu1;
                        flag3 = flag1;
                    } else
                    {
                        _lcls02ca.FE77();
                        flag = flag2;
                        menu = menu1;
                        flag3 = flag1;
                    }
                    break;
                }
                flag = flag2;
                menu = menu1;
                flag3 = flag1;
                if (s.equals("menu"))
                {
                    flag3 = true;
                    flag = flag2;
                    menu = menu1;
                }
                break;

            case 1: // '\001'
                throw new RuntimeException("Unexpected end of document");
            }
            l = xmlpullparser.next();
            flag2 = flag;
            menu1 = menu;
        }

    }

    static Object[] _mth02CB(FE7D fe7d)
    {
        return fe7d._fld017C;
    }

    static Object _mth02CE(FE7D fe7d)
    {
        if (fe7d._fld01A8 == null)
        {
            Object obj = fe7d.mContext;
            if (!(obj instanceof Activity) && (obj instanceof ContextWrapper))
            {
                obj = fe7d._mth02BC(((ContextWrapper)obj).getBaseContext());
            }
            fe7d._fld01A8 = obj;
        }
        return fe7d._fld01A8;
    }

    static Object[] _mth02CF(FE7D fe7d)
    {
        return fe7d._fld0176;
    }

    static Class[] FB4B()
    {
        return _fld010D;
    }

    static Class[] FE72()
    {
        return _fld0109;
    }

    public final void inflate(int i, Menu menu)
    {
        XmlResourceParser xmlresourceparser;
        XmlResourceParser xmlresourceparser2;
        XmlResourceParser xmlresourceparser3;
        if (!(menu instanceof _cls1D53))
        {
            super.inflate(i, menu);
            return;
        }
        xmlresourceparser3 = null;
        xmlresourceparser = null;
        xmlresourceparser2 = null;
        XmlResourceParser xmlresourceparser4 = mContext.getResources().getLayout(i);
        XmlResourceParser xmlresourceparser1;
        xmlresourceparser1 = xmlresourceparser4;
        xmlresourceparser2 = xmlresourceparser1;
        xmlresourceparser3 = xmlresourceparser1;
        xmlresourceparser = xmlresourceparser1;
        _mth02CA(xmlresourceparser1, Xml.asAttributeSet(xmlresourceparser4), menu);
        if (xmlresourceparser1 != null)
        {
            xmlresourceparser1.close();
            return;
        } else
        {
            return;
        }
        menu;
        xmlresourceparser = xmlresourceparser2;
        throw new InflateException("Error inflating menu XML", menu);
        menu;
        xmlresourceparser = xmlresourceparser3;
        throw new InflateException("Error inflating menu XML", menu);
        menu;
        if (xmlresourceparser != null)
        {
            xmlresourceparser.close();
        }
        throw menu;
    }

    static 
    {
        Class aclass[] = new Class[1];
        aclass[0] = android/content/Context;
        _fld0109 = aclass;
        _fld010D = aclass;
    }
}
