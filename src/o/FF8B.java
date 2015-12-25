// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Future;

// Referenced classes of package o:
//            FF90, _cls0437, FF9A, _cls0645, 
//            _cls04AD, FF7A, _cls0287, FF98, 
//            _cls044C, _cls0582, _cls03A5, _cls04AE, 
//            _cls026B, FF83, _cls03DF, _cls2110, 
//            _cls028B, _cls05D4, _cls025B, FF43, 
//            FEAE, FF49

public final class FF8B
    implements FF90, _cls0437, FF9A
{
    /* member class not found */
    class if {}


    private static final Queue ri = _cls0645._mth1D5B(0);
    private Context context;
    private int jA;
    private int jB;
    private _cls0287 jC;
    private FF43 jD;
    private _cls028B jK;
    private Class jo;
    private Object js;
    private FEAE jt;
    private int jx;
    private _cls025B jz;
    private _cls05D4 mS;
    private Drawable rj;
    private int rk;
    private int rl;
    private int rm;
    private FF7A rn;
    private FF98 ro;
    private boolean rp;
    private _cls044C rq;
    private _cls1427.if rr;
    private float rs;
    private Drawable rt;
    private Drawable ru;
    private boolean rv;
    private _cls028B._cls02CA rw;
    private int rx;
    private long startTime;
    private final String tag = String.valueOf(hashCode());

    private FF8B()
    {
    }

    private Drawable _mth02B1()
    {
        if (rt == null && rl > 0)
        {
            rt = context.getResources().getDrawable(rl);
        }
        return rt;
    }

    private void _mth02BD(_cls05D4 _pcls05d4)
    {
        _cls0645._mth0631();
        if (_pcls05d4 instanceof _cls04AD)
        {
            ((_cls04AD)_pcls05d4).release();
        } else
        {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        mS = null;
    }

    public static FF8B _mth02CA(FF49 ff49, Object obj, FEAE feae, Context context1, int i, _cls044C _pcls044c, float f, Drawable drawable, 
            int j, Drawable drawable1, int k, Drawable drawable2, int l, _cls1427.if if1, FF98 ff98, 
            _cls028B _pcls028b, FF43 ff43, Class class1, boolean flag, _cls025B _pcls025b, int i1, int j1, 
            _cls0287 _pcls0287)
    {
        FF8B ff8b1 = (FF8B)ri.poll();
        FF8B ff8b = ff8b1;
        if (ff8b1 == null)
        {
            ff8b = new FF8B();
        }
        ff8b.rn = ff49;
        ff8b.js = obj;
        ff8b.jt = feae;
        ff8b.rj = drawable2;
        ff8b.rk = l;
        ff8b.context = context1.getApplicationContext();
        ff8b.jx = i;
        ff8b.rq = _pcls044c;
        ff8b.rs = f;
        ff8b.rt = drawable;
        ff8b.rl = j;
        ff8b.ru = drawable1;
        ff8b.rm = k;
        ff8b.rr = if1;
        ff8b.ro = ff98;
        ff8b.jK = _pcls028b;
        ff8b.jD = ff43;
        ff8b.jo = class1;
        ff8b.rp = flag;
        ff8b.jz = _pcls025b;
        ff8b.jB = i1;
        ff8b.jA = j1;
        ff8b.jC = _pcls0287;
        ff8b.rx = if.ry;
        if (obj != null)
        {
            _mth02CA("ModelLoader", ff49._mth01C0(), "try .using(ModelLoader)");
            _mth02CA("Transcoder", ff49._mth0254(), "try .as*(Class).transcode(ResourceTranscoder)");
            _mth02CA("Transformation", ff43, "try .transform(UnitTransformation.get())");
            if (_pcls0287.mw)
            {
                _mth02CA("SourceEncoder", ff49._mth706C(), "try .sourceEncoder(Encoder) or .diskCacheStrategy(NONE/RESULT)");
            } else
            {
                _mth02CA("SourceDecoder", ff49._mth6C35(), "try .decoder/.imageDecoder/.videoDecoder(ResourceDecoder) or .diskCacheStrategy(ALL/SOURCE)");
            }
            if (_pcls0287.mw || _pcls0287.mx)
            {
                _mth02CA("CacheDecoder", ff49._mth4E28(), "try .cacheDecoder(ResouceDecoder) or .diskCacheStrategy(NONE)");
            }
            if (_pcls0287.mx)
            {
                _mth02CA("Encoder", ff49.FB59(), "try .encode(ResourceEncoder) or .diskCacheStrategy(NONE/SOURCE)");
            }
        }
        return ff8b;
    }

    private static void _mth02CA(String s, Object obj, String s1)
    {
        if (obj == null)
        {
            s = new StringBuilder(s);
            s.append(" must not be null");
            s.append(", ");
            s.append(s1);
            throw new NullPointerException(s.toString());
        } else
        {
            return;
        }
    }

    private void _mth02CB(Exception exception)
    {
        boolean flag;
        if (ro == null || ro._mth02CB(this))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            return;
        }
        Object obj;
        if (js == null)
        {
            if (rj == null && rk > 0)
            {
                rj = context.getResources().getDrawable(rk);
            }
            obj = rj;
        } else
        {
            obj = null;
        }
        exception = ((Exception) (obj));
        if (obj == null)
        {
            if (ru == null && rm > 0)
            {
                ru = context.getResources().getDrawable(rm);
            }
            exception = ru;
        }
        obj = exception;
        if (exception == null)
        {
            obj = _mth02B1();
        }
        rq._mth02BE(((Drawable) (obj)));
    }

    private void _mth02CC(String s)
    {
        Log.v("GenericRequest", (new StringBuilder()).append(s).append(" this: ").append(tag).toString());
    }

    public final void begin()
    {
        startTime = _cls0582._mth0621();
        if (js == null)
        {
            _mth02CA(null);
            return;
        }
        rx = if.rA;
        if (_cls0645._mth02E1(jB, jA))
        {
            _mth02C7(jB, jA);
        } else
        {
            rq._mth02CA(this);
        }
        boolean flag;
        if (rx == if.rB)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            boolean flag1;
            if (rx == if.rC)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag1)
            {
                boolean flag2;
                if (ro == null || ro._mth02CB(this))
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if (flag2)
                {
                    rq._mth1FBE(_mth02B1());
                }
            }
        }
        if (Log.isLoggable("GenericRequest", 2))
        {
            _mth02CC((new StringBuilder("finished run method in ")).append(_cls0582._mth02BB(startTime)).toString());
        }
    }

    public final void clear()
    {
        _cls0645._mth0631();
        if (rx == if.rE)
        {
            return;
        }
        rx = if.rD;
        if (rw != null)
        {
            Object obj = rw;
            _cls03A5 _lcls03a5 = ((_cls028B._cls02CA) (obj)).mK;
            obj = ((_cls028B._cls02CA) (obj)).mL;
            _cls0645._mth0631();
            if (_lcls03a5.mT || _lcls03a5.mV)
            {
                if (_lcls03a5.mW == null)
                {
                    _lcls03a5.mW = new HashSet();
                }
                _lcls03a5.mW.add(obj);
            } else
            {
                _lcls03a5.mQ.remove(obj);
                if (_lcls03a5.mQ.isEmpty() && (!_lcls03a5.mV && !_lcls03a5.mT && !_lcls03a5.mg))
                {
                    Object obj1 = _lcls03a5.mX;
                    obj1.mg = true;
                    obj1 = ((_cls04AE) (obj1)).nk;
                    obj1.mg = true;
                    ((_cls026B) (obj1)).mj.cancel();
                    obj1 = _lcls03a5.mZ;
                    if (obj1 != null)
                    {
                        ((Future) (obj1)).cancel(true);
                    }
                    _lcls03a5.mg = true;
                    _lcls03a5.mJ._mth02CA(_lcls03a5, _lcls03a5.mN);
                }
            }
            rw = null;
        }
        if (mS != null)
        {
            _cls05D4 _lcls05d4 = mS;
            _cls0645._mth0631();
            if (_lcls05d4 instanceof _cls04AD)
            {
                ((_cls04AD)_lcls05d4).release();
            } else
            {
                throw new IllegalArgumentException("Cannot release anything but an EngineResource");
            }
            mS = null;
        }
        boolean flag;
        if (ro == null || ro._mth02CB(this))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            rq._mth02BF(_mth02B1());
        }
        rx = if.rE;
    }

    public final boolean isCancelled()
    {
        return rx == if.rD || rx == if.rE;
    }

    public final boolean isRunning()
    {
        return rx == if.rz || rx == if.rA;
    }

    public final void pause()
    {
        clear();
        rx = if.rF;
    }

    public final void recycle()
    {
        rn = null;
        js = null;
        context = null;
        rq = null;
        rt = null;
        ru = null;
        rj = null;
        rr = null;
        ro = null;
        jD = null;
        jz = null;
        rv = false;
        rw = null;
        ri.offer(this);
    }

    public final boolean _mth027C()
    {
        return rx == if.rB;
    }

    public final void _mth02C7(int i, int j)
    {
        if (Log.isLoggable("GenericRequest", 2))
        {
            _mth02CC((new StringBuilder("Got onSizeReady in ")).append(_cls0582._mth02BB(startTime)).toString());
        }
        if (rx != if.rA)
        {
            return;
        }
        rx = if.rz;
        i = Math.round(rs * (float)i);
        j = Math.round(rs * (float)j);
        FF83 ff83 = rn._mth01C0()._mth02CE(js, i, j);
        if (ff83 == null)
        {
            _mth02CA(new Exception((new StringBuilder("Failed to load model: '")).append(js).append("'").toString()));
            return;
        }
        _cls1D08 _lcls1d08 = rn._mth0254();
        if (Log.isLoggable("GenericRequest", 2))
        {
            _mth02CC((new StringBuilder("finished setup for calling load in ")).append(_cls0582._mth02BB(startTime)).toString());
        }
        rv = true;
        rw = jK._mth02CA(jt, i, j, ff83, rn, jD, _lcls1d08, jx, rp, jC, this);
        boolean flag;
        if (mS != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        rv = flag;
        if (Log.isLoggable("GenericRequest", 2))
        {
            _mth02CC((new StringBuilder("finished onSizeReady in ")).append(_cls0582._mth02BB(startTime)).toString());
        }
    }

    public final void _mth02CA(Exception exception)
    {
label0:
        {
            if (Log.isLoggable("GenericRequest", 3))
            {
                Log.d("GenericRequest", "load failed", exception);
            }
            rx = if.rC;
            if (rr != null)
            {
                _cls1427.if if1 = rr;
                if (ro != null)
                {
                    if (ro._mth02E0());
                }
                if (if1._mth02BF())
                {
                    break label0;
                }
            }
            _mth02CB(exception);
        }
    }

    public final void _mth141D(_cls05D4 _pcls05d4)
    {
        if (_pcls05d4 == null)
        {
            _mth02CA(new Exception((new StringBuilder("Expected to receive a Resource<R> with an object of ")).append(jo).append(" inside, but instead got null.").toString()));
            return;
        }
        Object obj1 = _pcls05d4.get();
        if (obj1 == null || !jo.isAssignableFrom(obj1.getClass()))
        {
            _mth02BD(_pcls05d4);
            StringBuilder stringbuilder = (new StringBuilder("Expected to receive an object of ")).append(jo).append(" but instead got ");
            Object obj;
            if (obj1 != null)
            {
                obj = obj1.getClass();
            } else
            {
                obj = "";
            }
            obj = stringbuilder.append(obj).append("{").append(obj1).append("} inside Resource{").append(_pcls05d4).append("}.");
            if (obj1 != null)
            {
                _pcls05d4 = "";
            } else
            {
                _pcls05d4 = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
            }
            _mth02CA(new Exception(((StringBuilder) (obj)).append(_pcls05d4).toString()));
            return;
        }
        boolean flag;
        if (ro == null || ro._mth02CA(this))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            _mth02BD(_pcls05d4);
            rx = if.rB;
            return;
        }
        boolean flag1;
        if (ro == null || !ro._mth02E0())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        rx = if.rB;
        mS = _pcls05d4;
        if (rr == null || !rr._mth02C8())
        {
            _cls0192 _lcls0192 = jz._mth02CF(rv, flag1);
            rq._mth02CA(obj1, _lcls0192);
        }
        if (ro != null)
        {
            ro._mth02CE(this);
        }
        if (Log.isLoggable("GenericRequest", 2))
        {
            _mth02CC((new StringBuilder("Resource ready in ")).append(_cls0582._mth02BB(startTime)).append(" size: ").append((double)_pcls05d4.getSize() * 9.5367431640625E-07D).append(" fromCache: ").append(rv).toString());
        }
    }

}
