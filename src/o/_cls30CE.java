// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Bitmap;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package o:
//            _cls4EA0, _cls4E85

public class _cls30CE
{
    /* member class not found */
    class if {}


    private static final String TAG = o/30CE.getSimpleName();
    private static final android.graphics.Bitmap.Config ks;
    public byte data[];
    public int kA[];
    public int kB;
    public _cls4EA0 kC;
    public if kD;
    public Bitmap kE;
    private boolean kF;
    private int kt[];
    private ByteBuffer ku;
    private final byte kv[] = new byte[256];
    private short kw[];
    private byte kx[];
    private byte ky[];
    public byte kz[];
    private int status;

    public _cls30CE(if if1)
    {
        kD = if1;
        kC = new _cls4EA0();
    }

    private int read()
    {
        Exception exception;
        byte byte0;
        try
        {
            byte0 = ku.get();
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            status = 1;
            return 0;
        }
        return byte0 & 0xff;
    }

    private Bitmap _mth02CA(_cls4E85 _pcls4e85, _cls4E85 _pcls4e85_1)
    {
        int k9 = kC.width;
        int l9 = kC.height;
        int ai[] = kA;
        if (_pcls4e85_1 != null && _pcls4e85_1.kM > 0)
        {
            if (_pcls4e85_1.kM == 2)
            {
                int i = 0;
                if (!_pcls4e85.kL)
                {
                    i = kC.bgColor;
                }
                Arrays.fill(ai, i);
            } else
            if (_pcls4e85_1.kM == 3 && kE != null)
            {
                kE.getPixels(ai, 0, k9, 0, 0, k9, l9);
            }
        }
        if (_pcls4e85 != null)
        {
            ku.position(_pcls4e85.kO);
        }
        int k6;
        if (_pcls4e85 == null)
        {
            k6 = kC.width * kC.height;
        } else
        {
            k6 = _pcls4e85.kI * _pcls4e85.kJ;
        }
        if (kz == null || kz.length < k6)
        {
            kz = new byte[k6];
        }
        if (kw == null)
        {
            kw = new short[4096];
        }
        if (kx == null)
        {
            kx = new byte[4096];
        }
        if (ky == null)
        {
            ky = new byte[4097];
        }
        int i10 = read();
        int j10 = 1 << i10;
        int l8 = j10 + 2;
        int i8 = -1;
        int j8 = i10 + 1;
        int k8 = (1 << j8) - 1;
        for (int j = 0; j < j10; j++)
        {
            kw[j] = 0;
            kx[j] = (byte)j;
        }

        int i5 = 0;
        int k1 = 0;
        int i2 = 0;
        int k7 = 0;
        int i6 = 0;
        int k5 = 0;
        int k4 = 0;
        int l7 = 0;
label0:
        do
        {
label1:
            {
                if (l7 >= k6)
                {
                    break label1;
                }
                int k = i6;
                if (i6 == 0)
                {
                    int i1 = _mth03AF();
                    k = i1;
                    if (i1 <= 0)
                    {
                        status = 3;
                        break label1;
                    }
                    i5 = 0;
                }
                int l4 = k4 + ((kv[i5] & 0xff) << k5);
                int j5 = k5 + 8;
                int i9 = i5 + 1;
                int j9 = k - 1;
                int j2 = k1;
                int j1 = i2;
                int j4 = k7;
                int j7 = l7;
                k = i8;
                int l3 = j8;
                int l2 = k8;
                int j3 = l8;
                do
                {
                    int l5;
                    int l6;
                    int i7;
                    do
                    {
                        l5 = j1;
                        l8 = j3;
                        k8 = l2;
                        j8 = l3;
                        i8 = k;
                        k5 = j5;
                        i6 = j9;
                        l7 = j7;
                        k4 = l4;
                        k7 = j4;
                        i2 = l5;
                        i5 = i9;
                        k1 = j2;
                        if (j5 < l3)
                        {
                            continue label0;
                        }
                        j1 = l4 & l2;
                        l6 = l4 >> l3;
                        i7 = j5 - l3;
                        if (j1 == j10)
                        {
                            l3 = i10 + 1;
                            l2 = (1 << l3) - 1;
                            j3 = j10 + 2;
                            k = -1;
                            j5 = i7;
                            l4 = l6;
                            j1 = l5;
                            continue;
                        }
                        if (j1 > j3)
                        {
                            status = 3;
                            l8 = j3;
                            k8 = l2;
                            j8 = l3;
                            i8 = k;
                            k5 = i7;
                            i6 = j9;
                            l7 = j7;
                            k4 = l6;
                            k7 = j4;
                            i2 = l5;
                            i5 = i9;
                            k1 = j2;
                            continue label0;
                        }
                        l8 = j3;
                        k8 = l2;
                        j8 = l3;
                        i8 = k;
                        k5 = i7;
                        i6 = j9;
                        l7 = j7;
                        k4 = l6;
                        k7 = j4;
                        i2 = l5;
                        i5 = i9;
                        k1 = j2;
                        if (j1 == j10 + 1)
                        {
                            continue label0;
                        }
                        if (k != -1)
                        {
                            break;
                        }
                        _pcls4e85_1 = ky;
                        k1 = l5 + 1;
                        _pcls4e85_1[l5] = kx[j1];
                        k = j1;
                        j5 = i7;
                        l4 = l6;
                        j4 = j1;
                        j1 = k1;
                    } while (true);
                    k1 = j1;
                    i2 = l5;
                    if (j1 >= j3)
                    {
                        _pcls4e85_1 = ky;
                        i2 = l5 + 1;
                        _pcls4e85_1[l5] = (byte)j4;
                        k1 = k;
                    }
                    while (k1 >= j10) 
                    {
                        _pcls4e85_1 = ky;
                        j4 = i2 + 1;
                        _pcls4e85_1[i2] = kx[k1];
                        k1 = kw[k1];
                        i2 = j4;
                    }
                    k7 = kx[k1] & 0xff;
                    _pcls4e85_1 = ky;
                    k1 = i2 + 1;
                    _pcls4e85_1[i2] = (byte)k7;
                    k4 = j3;
                    i5 = l2;
                    i2 = l3;
                    if (j3 < 4096)
                    {
                        kw[j3] = (short)k;
                        kx[j3] = (byte)k7;
                        k = j3 + 1;
                        k4 = k;
                        i5 = l2;
                        i2 = l3;
                        if ((k & l2) == 0)
                        {
                            k4 = k;
                            i5 = l2;
                            i2 = l3;
                            if (k < 4096)
                            {
                                i2 = l3 + 1;
                                i5 = l2 + k;
                                k4 = k;
                            }
                        }
                    }
                    k5 = j1;
                    l5 = j7;
                    do
                    {
                        int j6 = j2;
                        j3 = k4;
                        l2 = i5;
                        l3 = i2;
                        k = k5;
                        j5 = i7;
                        j7 = l5;
                        l4 = l6;
                        j4 = k7;
                        j1 = k1;
                        j2 = j6;
                        if (k1 <= 0)
                        {
                            break;
                        }
                        k1--;
                        _pcls4e85_1 = kz;
                        j2 = j6 + 1;
                        _pcls4e85_1[j6] = ky[k1];
                        l5++;
                    } while (true);
                } while (true);
            }
            for (; k1 < k6; k1++)
            {
                kz[k1] = 0;
            }

            int i3 = 1;
            i2 = 8;
            int k2 = 0;
            for (int l1 = 0; l1 < _pcls4e85.kJ;)
            {
                int l = l1;
                byte byte0 = i2;
                int i4 = k2;
                int k3 = i3;
                if (_pcls4e85.kK)
                {
                    byte0 = i2;
                    l = k2;
                    k3 = i3;
                    if (k2 >= _pcls4e85.kJ)
                    {
                        k3 = i3 + 1;
                        switch (k3)
                        {
                        default:
                            byte0 = i2;
                            l = k2;
                            break;

                        case 2: // '\002'
                            l = 4;
                            byte0 = i2;
                            break;

                        case 3: // '\003'
                            l = 2;
                            byte0 = 4;
                            break;

                        case 4: // '\004'
                            l = 1;
                            byte0 = 2;
                            break;
                        }
                    }
                    i2 = l;
                    i4 = l + byte0;
                    l = i2;
                }
                l = _pcls4e85.kH + l;
                if (l < kC.height)
                {
                    i3 = kC.width * l;
                    l = i3 + _pcls4e85.kG;
                    k2 = l;
                    l += _pcls4e85.kI;
                    i2 = l;
                    if (kC.width + i3 < l)
                    {
                        i2 = i3 + kC.width;
                    }
                    l = l1 * _pcls4e85.kI;
                    do
                    {
                        i3 = l;
                        if (k2 >= i2)
                        {
                            break;
                        }
                        _pcls4e85_1 = kz;
                        l = i3 + 1;
                        i3 = _pcls4e85_1[i3];
                        i3 = kt[i3 & 0xff];
                        if (i3 != 0)
                        {
                            ai[k2] = i3;
                        }
                        k2++;
                    } while (true);
                }
                l1++;
                i2 = byte0;
                k2 = i4;
                i3 = k3;
            }

            if (kF && (_pcls4e85.kM == 0 || _pcls4e85.kM == 1))
            {
                if (kE == null)
                {
                    kE = _mth05D3();
                }
                kE.setPixels(ai, 0, k9, 0, 0, k9, l9);
            }
            _pcls4e85 = _mth05D3();
            _pcls4e85.setPixels(ai, 0, k9, 0, 0, k9, l9);
            return _pcls4e85;
        } while (true);
    }

    private int _mth03AF()
    {
        int i;
        int k;
        k = read();
        i = 0;
        boolean flag = false;
        if (k <= 0)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        i = ((flag) ? 1 : 0);
_L2:
        int j;
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        j = k - i;
        ku.get(kv, i, j);
        i += j;
        if (true) goto _L2; else goto _L1
_L1:
        return i;
        Exception exception;
        exception;
        Log.w(TAG, "Error Reading Block", exception);
        status = 1;
        return i;
    }

    private Bitmap _mth05D3()
    {
        Bitmap bitmap1 = kD._mth02CA(kC.width, kC.height, ks);
        Bitmap bitmap = bitmap1;
        if (bitmap1 == null)
        {
            bitmap = Bitmap.createBitmap(kC.width, kC.height, ks);
        }
        if (android.os.Build.VERSION.SDK_INT >= 12)
        {
            bitmap.setHasAlpha(true);
        }
        return bitmap;
    }

    public final Bitmap _mth0285()
    {
        this;
        JVM INSTR monitorenter ;
        if (kC.frameCount <= 0 || kB < 0)
        {
            if (Log.isLoggable(TAG, 3))
            {
                Log.d(TAG, (new StringBuilder("unable to decode frame, frameCount=")).append(kC.frameCount).append(" framePointer=").append(kB).toString());
            }
            status = 1;
        }
        if (status != 1 && status != 2)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        if (Log.isLoggable(TAG, 3))
        {
            Log.d(TAG, (new StringBuilder("Unable to decode frame, status=")).append(status).toString());
        }
        this;
        JVM INSTR monitorexit ;
        return null;
        _cls4E85 _lcls4e85;
        status = 0;
        _lcls4e85 = (_cls4E85)kC.kS.get(kB);
        Object obj = null;
        int i = kB - 1;
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_186;
        }
        obj = (_cls4E85)kC.kS.get(i);
        if (_lcls4e85.kP == null)
        {
            kt = kC.kQ;
            break MISSING_BLOCK_LABEL_237;
        }
        kt = _lcls4e85.kP;
        if (kC.kV == _lcls4e85.kN)
        {
            kC.bgColor = 0;
        }
        i = 0;
        if (_lcls4e85.kL)
        {
            i = kt[_lcls4e85.kN];
            kt[_lcls4e85.kN] = 0;
        }
        if (kt != null)
        {
            break MISSING_BLOCK_LABEL_301;
        }
        if (Log.isLoggable(TAG, 3))
        {
            Log.d(TAG, "No Valid Color Table");
        }
        status = 1;
        this;
        JVM INSTR monitorexit ;
        return null;
        obj = _mth02CA(_lcls4e85, ((_cls4E85) (obj)));
        if (_lcls4e85.kL)
        {
            kt[_lcls4e85.kN] = i;
        }
        this;
        JVM INSTR monitorexit ;
        return ((Bitmap) (obj));
        Exception exception;
        exception;
        throw exception;
    }

    public final void _mth02CA(_cls4EA0 _pcls4ea0, byte abyte0[])
    {
        kC = _pcls4ea0;
        data = abyte0;
        status = 0;
        kB = -1;
        ku = ByteBuffer.wrap(abyte0);
        ku.rewind();
        ku.order(ByteOrder.LITTLE_ENDIAN);
        kF = false;
        abyte0 = _pcls4ea0.kS.iterator();
        do
        {
            if (!abyte0.hasNext())
            {
                break;
            }
            if (((_cls4E85)abyte0.next()).kM != 3)
            {
                continue;
            }
            kF = true;
            break;
        } while (true);
        kz = new byte[_pcls4ea0.width * _pcls4ea0.height];
        kA = new int[_pcls4ea0.width * _pcls4ea0.height];
    }

    public final int _mth0E40(int i)
    {
        byte byte0 = -1;
        int j = byte0;
        if (i >= 0)
        {
            j = byte0;
            if (i < kC.frameCount)
            {
                j = ((_cls4E85)kC.kS.get(i)).delay;
            }
        }
        return j;
    }

    static 
    {
        ks = android.graphics.Bitmap.Config.ARGB_8888;
    }
}
