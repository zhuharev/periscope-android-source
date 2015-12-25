// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import tv.periscope.android.api.ThumbnailPlaylistItem;

// Referenced classes of package o:
//            aft, aos, xf, _cls1D3C, 
//            _cls1D5A, _cls1D27, _cls0287, _cls1647, 
//            zz, _cls0EB2, _cls0192

final class afw
{
    final class if extends _cls02CA
    {

        private afw bjB;

        public final void _mth02BE(Drawable drawable)
        {
            long l = bjC.getTimeInMs();
            drawable = afw._mth02CA(bjB, l, afw._mth02CE(bjB));
            drawable = afw._mth02CA(bjB, drawable);
            if (((ThumbnailPlaylistItem) (drawable)).url == null)
            {
                afw._mth141D(bjB).setThumb(null);
                afw._mth02CA(bjB, null);
                return;
            } else
            {
                _cls1D5A _lcls1d5a = _cls1D3C._mth1427(afw._mth141D(bjB).getContext());
                String s = ((ThumbnailPlaylistItem) (drawable)).url;
                ((_cls1D27)_lcls1d5a._mth02CA(java/lang/String).FF70(s))._mth02CB(_cls0287.mu)._mth02CA(afw._mth141D(bjB).biW);
                afw._mth02CA(bjB, ((ThumbnailPlaylistItem) (drawable)).url);
                return;
            }
        }

        public final volatile void _mth02CA(Object obj, _cls0192 _pcls0192)
        {
            _mth02CA((_cls0EB2)obj, _pcls0192);
        }

        public final void _mth02CA(_cls0EB2 _pcls0eb2, _cls0192 _pcls0192)
        {
            super._mth02CA(_pcls0eb2, _pcls0192);
            if (!afw._mth02CA(bjB) || afw._mth02CF(bjB) != null && afw._mth02CF(bjB).equals(bjC.url))
            {
                afw._mth141D(bjB).setThumb(_pcls0eb2);
            }
        }

        public if(ThumbnailPlaylistItem thumbnailplaylistitem)
        {
            bjB = afw.this;
            super(thumbnailplaylistitem);
        }
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}


    private static final long bjk;
    long bjA;
    private float bjl;
    private float bjm;
    private float bjn;
    final aft bjo;
    final _cls02CE bjp = new _cls02CE((byte)0);
    final TreeMap bjq = new TreeMap();
    private final TreeSet bjr = new TreeSet();
    private String bjs;
    zz bjt;
    _cls02CB bju;
    boolean bjv;
    long bjw;
    long bjx;
    int bjy;
    long bjz;
    boolean FE7B;

    public afw(aft aft1)
    {
        bjo = aft1;
        bjo.setZoomZonePercentage(0.3F);
    }

    static Long _mth02CA(long l, NavigableSet navigableset)
    {
        Long long2 = Long.valueOf(l);
        if (navigableset.contains(long2))
        {
            return long2;
        }
        Long long1 = (Long)navigableset.lower(long2);
        navigableset = (Long)navigableset.higher(long2);
        if (long1 != null && navigableset != null)
        {
            l = Math.abs(long2.longValue() - long1.longValue());
            long l1 = Math.abs(long2.longValue() - navigableset.longValue());
            float f = l + l1;
            if ((float)l1 / f > 0.8F)
            {
                navigableset = long1;
            }
            return navigableset;
        }
        if (long1 != null || navigableset != null)
        {
            if (long1 != null)
            {
                navigableset = long1;
            }
            return navigableset;
        } else
        {
            return null;
        }
    }

    static Long _mth02CA(afw afw1, long l, TreeSet treeset)
    {
        return _mth02CA(l, ((NavigableSet) (treeset)));
    }

    static String _mth02CA(afw afw1, String s)
    {
        afw1.bjs = s;
        return s;
    }

    static ThumbnailPlaylistItem _mth02CA(afw afw1, Long long1)
    {
        return afw1._mth02CA(long1);
    }

    static boolean _mth02CA(afw afw1)
    {
        return afw1.bjv;
    }

    static boolean _mth02CA(afw afw1, float f, float f1)
    {
        int i = aos._mth02B2(afw1.bjo.getContext()).y;
        f = afw1.bjo.biZ.getY();
        if (afw1.bjl != f)
        {
            afw1.bjl = f;
            f = i;
            float f2 = i;
            afw1.bjm = afw1.bjl + f * 0.1F;
            afw1.bjn = (float)i - f2 * 0.05F;
        }
        f = afw1.bjm;
        float f3 = afw1.bjn;
        if (f1 <= f)
        {
            f = 1.0F;
        } else
        if (f1 >= f3)
        {
            f = 5F;
        } else
        {
            f = Math.min((f1 - f) * (4F / (f3 - f)) + 1.0F, 5F);
        }
        if (Float.compare(f, afw1.bjo.KP) != 0)
        {
            afw1 = afw1.bjo;
            int j;
            if (f <= 1.0F)
            {
                j = 0;
            } else
            if (f < 3F)
            {
                j = 0x7f060136;
            } else
            if (f < 5F)
            {
                j = 0x7f060137;
            } else
            {
                j = 0x7f060135;
            }
            afw1.setZoom(f, j);
            return true;
        } else
        {
            return false;
        }
    }

    static void _mth02CB(afw afw1)
    {
        afw1.bjv = true;
        afw1.bjx = afw1.bjo.bji;
        afw1.bjo.setEndTime(afw1.bjx);
        if (afw1.bju != null)
        {
            long l = Math.max(0L, afw1.bjx - bjk);
            afw1.bju._mth02B4(l);
        }
    }

    static void _mth02CB(afw afw1, float f, float f1)
    {
        long l = afw1.bjo.bjh;
        float f2 = Math.abs(f - f1);
        aft aft1 = afw1.bjo;
        long l1 = (long)((f2 / (float)(int)((float)aft1.bje * aft1.KP)) * (float)l);
        long l2 = afw1.bjo.bji;
        if (f > f1)
        {
            l = Math.min(l2 + l1, l);
        } else
        {
            l = Math.max(l2 - l1, 0L);
        }
        afw1._mth02CA(afw1._mth02CA(_mth02CA(l, afw1.bjq.navigableKeySet())));
        afw1.bjo.seekTo(l);
    }

    static TreeSet _mth02CE(afw afw1)
    {
        return afw1.bjr;
    }

    static String _mth02CF(afw afw1)
    {
        return afw1.bjs;
    }

    static aft _mth141D(afw afw1)
    {
        return afw1.bjo;
    }

    static int FE73(float f)
    {
        if (f <= 1.0F)
        {
            return 0;
        }
        if (f < 3F)
        {
            return 0x7f060136;
        }
        return f >= 5F ? 0x7f060135 : 0x7f060137;
    }

    public final void bT()
    {
        if (!FE7B)
        {
            return;
        }
        if (bjz != 0L)
        {
            bjA = bjA + (System.currentTimeMillis() - bjz);
            bjz = 0L;
        }
        if (bjx >= bjw)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("direction", "forward");
            xf._mth02CA(xf.if.aSb, hashmap);
        } else
        {
            HashMap hashmap1 = new HashMap();
            hashmap1.put("direction", "reverse");
            xf._mth02CA(xf.if.aSb, hashmap1);
        }
        bjw = 0L;
        bjx = 0L;
        FE7B = false;
        bjv = false;
        bjo.bjd.start();
        if (bju != null)
        {
            bju.onStopped();
        }
    }

    public final void _mth02BF(List list)
    {
        bjq.clear();
        bjr.clear();
        if (list != null)
        {
            ThumbnailPlaylistItem thumbnailplaylistitem;
            for (Iterator iterator = list.iterator(); iterator.hasNext(); bjq.put(Long.valueOf(thumbnailplaylistitem.getTimeInMs()), thumbnailplaylistitem))
            {
                thumbnailplaylistitem = (ThumbnailPlaylistItem)iterator.next();
            }

            android.content.Context context = bjo.getContext();
            int j = list.size();
            int k = Math.max(1, j / 20);
            for (int i = 0; i < j; i += k)
            {
                ThumbnailPlaylistItem thumbnailplaylistitem1 = (ThumbnailPlaylistItem)list.get(i);
                _cls1D5A _lcls1d5a = _cls1D3C._mth1427(context);
                String s = thumbnailplaylistitem1.url;
                ((_cls1D27)_lcls1d5a._mth02CA(java/lang/String).FF70(s))._mth02CB(_cls0287.mu)._mth02CA(new _cls02CA(thumbnailplaylistitem1));
            }

        }
    }

    ThumbnailPlaylistItem _mth02CA(Long long1)
    {
        if (long1 != null && bjq.containsKey(long1))
        {
            return (ThumbnailPlaylistItem)bjq.get(long1);
        } else
        {
            long1 = new ThumbnailPlaylistItem();
            long1.chunk = -1;
            long1.url = null;
            long1.timeInSecs = 0.0D;
            long1.rotation = 0;
            return long1;
        }
    }

    void _mth02CA(ThumbnailPlaylistItem thumbnailplaylistitem)
    {
        if (thumbnailplaylistitem.url == null)
        {
            bjo.setThumb(null);
            bjs = null;
            return;
        }
        if (!thumbnailplaylistitem.url.equals(bjs))
        {
            _cls1D5A _lcls1d5a = _cls1D3C._mth1427(bjo.getContext());
            String s = thumbnailplaylistitem.url;
            ((_cls1D27)_lcls1d5a._mth02CA(java/lang/String).FF70(s))._mth02CB(_cls0287.mu)._mth02CA(new if(thumbnailplaylistitem));
            bjs = thumbnailplaylistitem.url;
        }
    }

    static 
    {
        bjk = TimeUnit.MILLISECONDS.toMillis(300L);
    }
}
