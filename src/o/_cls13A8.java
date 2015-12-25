// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package o:
//            _cls0E43, _cls09A7, _cls0645, _cls0698

public final class _cls13A8
    implements _cls0E43
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}


    private static final android.graphics.Bitmap.Config nL[];
    private static final android.graphics.Bitmap.Config nM[];
    private static final android.graphics.Bitmap.Config nN[];
    private static final android.graphics.Bitmap.Config nO[];
    private final _cls02CA nP = new _cls02CA();
    private final HashMap nQ = new HashMap();
    private final _cls09A7 nr = new _cls09A7();

    public _cls13A8()
    {
    }

    private static String _mth02CA(int i, android.graphics.Bitmap.Config config)
    {
        return (new StringBuilder("[")).append(i).append("](").append(config).append(")").toString();
    }

    private NavigableMap _mth02CA(android.graphics.Bitmap.Config config)
    {
        NavigableMap navigablemap = (NavigableMap)nQ.get(config);
        Object obj = navigablemap;
        if (navigablemap == null)
        {
            obj = new TreeMap();
            nQ.put(config, obj);
        }
        return ((NavigableMap) (obj));
    }

    private void _mth02CA(Integer integer, android.graphics.Bitmap.Config config)
    {
        config = _mth02CA(config);
        Integer integer1 = (Integer)config.get(integer);
        if (integer1.intValue() == 1)
        {
            config.remove(integer);
            return;
        } else
        {
            config.put(integer, Integer.valueOf(integer1.intValue() - 1));
            return;
        }
    }

    static String _mth02CB(int i, android.graphics.Bitmap.Config config)
    {
        return _mth02CA(i, config);
    }

    public final String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder("SizeConfigStrategy{groupedMap=")).append(nr).append(", sortedSizes=(");
        java.util.Map.Entry entry;
        for (Iterator iterator = nQ.entrySet().iterator(); iterator.hasNext(); stringbuilder.append(entry.getKey()).append('[').append(entry.getValue()).append("], "))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        if (!nQ.isEmpty())
        {
            stringbuilder.replace(stringbuilder.length() - 2, stringbuilder.length(), "");
        }
        return stringbuilder.append(")}").toString();
    }

    public final String _mth02BB(Bitmap bitmap)
    {
        return _mth02CA(_cls0645._mth037A(bitmap), bitmap.getConfig());
    }

    public final int _mth02BC(Bitmap bitmap)
    {
        return _cls0645._mth037A(bitmap);
    }

    public final Bitmap _mth02CB(int i, int j, android.graphics.Bitmap.Config config)
    {
        int l = _cls0645._mth02BC(i, j, config);
        if if3 = nP._mth02CE(l, config);
        if if1 = if3;
    /* anonymous class not found */
    class _anm1 {}

        android.graphics.Bitmap.Config aconfig[];
        switch (_cls1.nR[config.ordinal()])
        {
        case 1: // '\001'
            aconfig = nL;
            break;

        case 2: // '\002'
            aconfig = nM;
            break;

        case 3: // '\003'
            aconfig = nN;
            break;

        case 4: // '\004'
            aconfig = nO;
            break;

        default:
            aconfig = new android.graphics.Bitmap.Config[1];
            aconfig[0] = config;
            break;
        }
        int i1 = aconfig.length;
        int k = 0;
        if if2;
        do
        {
            if2 = if1;
            if (k >= i1)
            {
                break;
            }
            android.graphics.Bitmap.Config config1 = aconfig[k];
            Integer integer = (Integer)_mth02CA(config1).ceilingKey(Integer.valueOf(l));
            if (integer != null && integer.intValue() <= l << 3)
            {
                if (integer.intValue() == l)
                {
                    if (config1 == null)
                    {
                        if2 = if1;
                        if (config == null)
                        {
                            break;
                        }
                    } else
                    {
                        if2 = if1;
                        if (config1.equals(config))
                        {
                            break;
                        }
                    }
                }
                config = nP;
                if (((_cls0698) (config)).nu.size() < 20)
                {
                    ((_cls0698) (config)).nu.offer(if3);
                }
                if2 = nP._mth02CE(integer.intValue(), config1);
                break;
            }
            k++;
        } while (true);
        Bitmap bitmap = (Bitmap)nr._mth02CA(if2);
        if (bitmap != null)
        {
            _mth02CA(Integer.valueOf(_cls0645._mth037A(bitmap)), bitmap.getConfig());
            if (bitmap.getConfig() != null)
            {
                config = bitmap.getConfig();
            } else
            {
                config = android.graphics.Bitmap.Config.ARGB_8888;
            }
            bitmap.reconfigure(i, j, config);
        }
        return bitmap;
    }

    public final String _mth02CE(int i, int j, android.graphics.Bitmap.Config config)
    {
        return _mth02CA(_cls0645._mth02BC(i, j, config), config);
    }

    public final void _mth141D(Bitmap bitmap)
    {
        int i = _cls0645._mth037A(bitmap);
        if if1 = nP._mth02CE(i, bitmap.getConfig());
        nr._mth02CA(if1, bitmap);
        bitmap = _mth02CA(bitmap.getConfig());
        Integer integer = (Integer)bitmap.get(Integer.valueOf(if1.size));
        int j = if1.size;
        if (integer == null)
        {
            i = 1;
        } else
        {
            i = integer.intValue() + 1;
        }
        bitmap.put(Integer.valueOf(j), Integer.valueOf(i));
    }

    public final Bitmap _mth1D47()
    {
        Bitmap bitmap = (Bitmap)nr.removeLast();
        if (bitmap != null)
        {
            _mth02CA(Integer.valueOf(_cls0645._mth037A(bitmap)), bitmap.getConfig());
        }
        return bitmap;
    }

    static 
    {
        nL = (new android.graphics.Bitmap.Config[] {
            android.graphics.Bitmap.Config.ARGB_8888, null
        });
        nM = (new android.graphics.Bitmap.Config[] {
            android.graphics.Bitmap.Config.RGB_565
        });
        nN = (new android.graphics.Bitmap.Config[] {
            android.graphics.Bitmap.Config.ARGB_4444
        });
        nO = (new android.graphics.Bitmap.Config[] {
            android.graphics.Bitmap.Config.ALPHA_8
        });
    }
}
