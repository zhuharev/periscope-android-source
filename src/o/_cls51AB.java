// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package o:
//            _cls4EA0, _cls4E85

public final class _cls51AB
{

    public _cls4EA0 kC;
    private int kY;
    public ByteBuffer ku;
    private final byte kv[] = new byte[256];

    public _cls51AB()
    {
        kY = 0;
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
            kC.status = 1;
            return 0;
        }
        return byte0 & 0xff;
    }

    private void readHeader()
    {
        Object obj = "";
        for (int i = 0; i < 6; i++)
        {
            obj = (new StringBuilder()).append(((String) (obj))).append((char)read()).toString();
        }

        if (!((String) (obj)).startsWith("GIF"))
        {
            kC.status = 1;
            return;
        }
        kC.width = ku.getShort();
        kC.height = ku.getShort();
        int j = read();
        obj = kC;
        boolean flag1;
        if ((j & 0x80) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        obj.kT = flag1;
        kC.kU = 2 << (j & 7);
        kC.kV = read();
        kC.kW = read();
        if (kC.kT)
        {
            boolean flag;
            if (kC.status != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                kC.kQ = _mth13A5(kC.kU);
                kC.bgColor = kC.kQ[kC.kV];
            }
        }
    }

    private int _mth03AF()
    {
        int i;
        int j;
        kY = read();
        i = 0;
        boolean flag = false;
        if (kY <= 0)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        j = 0;
        i = ((flag) ? 1 : 0);
_L2:
        int k = j;
        if (i >= kY)
        {
            break; /* Loop/switch isn't completed */
        }
        k = j;
        j = kY - i;
        k = j;
        ku.get(kv, i, j);
        i += j;
        if (true) goto _L2; else goto _L1
_L1:
        return i;
        Exception exception;
        exception;
        if (Log.isLoggable("GifHeaderParser", 3))
        {
            Log.d("GifHeaderParser", (new StringBuilder("Error Reading Block n: ")).append(i).append(" count: ").append(k).append(" blockSize: ").append(kY).toString(), exception);
        }
        kC.status = 1;
        return i;
    }

    private void _mth068C()
    {
        boolean flag = false;
        do
        {
            if (flag)
            {
                break;
            }
            boolean flag1;
            if (kC.status != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                break;
            }
            switch (read())
            {
            case 44: // ','
                if (kC.kR == null)
                {
                    kC.kR = new _cls4E85();
                }
                kC.kR.kG = ku.getShort();
                kC.kR.kH = ku.getShort();
                kC.kR.kI = ku.getShort();
                kC.kR.kJ = ku.getShort();
                int l = read();
                boolean flag2;
                if ((l & 0x80) != 0)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                int i1 = (int)Math.pow(2D, (l & 7) + 1);
                _cls4E85 _lcls4e85 = kC.kR;
                boolean flag3;
                if ((l & 0x40) != 0)
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
                _lcls4e85.kK = flag3;
                if (flag2)
                {
                    kC.kR.kP = _mth13A5(i1);
                } else
                {
                    kC.kR.kP = null;
                }
                kC.kR.kO = ku.position();
                read();
                int i;
                do
                {
                    i = read();
                    ku.position(ku.position() + i);
                } while (i > 0);
                if (kC.status != 0)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (!i)
                {
                    _cls4EA0 _lcls4ea0 = kC;
                    _lcls4ea0.frameCount = _lcls4ea0.frameCount + 1;
                    kC.kS.add(kC.kR);
                }
                continue;

            case 33: // '!'
                switch (read())
                {
                case 249: 
                    kC.kR = new _cls4E85();
                    read();
                    int j = read();
                    kC.kR.kM = (j & 0x1c) >> 2;
                    if (kC.kR.kM == 0)
                    {
                        kC.kR.kM = 1;
                    }
                    _cls4E85 _lcls4e85_1 = kC.kR;
                    boolean flag4;
                    if ((j & 1) != 0)
                    {
                        flag4 = true;
                    } else
                    {
                        flag4 = false;
                    }
                    _lcls4e85_1.kL = flag4;
                    short word0 = ku.getShort();
                    j = word0;
                    if (word0 < 3)
                    {
                        j = 10;
                    }
                    kC.kR.delay = j * 10;
                    kC.kR.kN = read();
                    read();
                    break;

                case 255: 
                    _mth03AF();
                    String s = "";
                    for (int k = 0; k < 11; k++)
                    {
                        s = (new StringBuilder()).append(s).append((char)kv[k]).toString();
                    }

                    if (s.equals("NETSCAPE2.0"))
                    {
                        _mth068D();
                    } else
                    {
                        _mth06C3();
                    }
                    break;

                case 254: 
                    _mth06C3();
                    break;

                case 1: // '\001'
                    _mth06C3();
                    break;

                default:
                    _mth06C3();
                    break;
                }
                break;

            case 59: // ';'
                flag = true;
                break;

            default:
                kC.status = 1;
                break;
            }
        } while (true);
    }

    private void _mth068D()
    {
        boolean flag;
        do
        {
            _mth03AF();
            if (kv[0] == 1)
            {
                byte byte0 = kv[1];
                byte byte1 = kv[2];
                kC.kX = (byte1 & 0xff) << 8 | byte0 & 0xff;
            }
            if (kY <= 0)
            {
                break;
            }
            if (kC.status != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } while (!flag);
    }

    private void _mth06C3()
    {
        int i;
        do
        {
            i = read();
            ku.position(ku.position() + i);
        } while (i > 0);
    }

    private int[] _mth13A5(int i)
    {
        byte abyte0[] = new byte[i * 3];
        int ai[];
        int j;
        int k;
        try
        {
            ku.get(abyte0);
            ai = new int[256];
        }
        catch (BufferUnderflowException bufferunderflowexception)
        {
            if (Log.isLoggable("GifHeaderParser", 3))
            {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", bufferunderflowexception);
            }
            kC.status = 1;
            return null;
        }
        j = 0;
        k = 0;
        int l;
        for (; j < i; j = l)
        {
            int i1 = k + 1;
            byte byte0 = abyte0[k];
            l = i1 + 1;
            i1 = abyte0[i1];
            k = l + 1;
            byte byte1 = abyte0[l];
            l = j + 1;
            ai[j] = (byte0 & 0xff) << 16 | 0xff000000 | (i1 & 0xff) << 8 | byte1 & 0xff;
        }

        return ai;
    }

    public final _cls51AB _mth02CA(byte abyte0[])
    {
        ku = null;
        Arrays.fill(kv, (byte)0);
        kC = new _cls4EA0();
        kY = 0;
        if (abyte0 != null)
        {
            ku = ByteBuffer.wrap(abyte0);
            ku.rewind();
            ku.order(ByteOrder.LITTLE_ENDIAN);
            return this;
        } else
        {
            ku = null;
            kC.status = 2;
            return this;
        }
    }

    public final _cls4EA0 _mth05F1()
    {
        if (ku == null)
        {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        boolean flag;
        if (kC.status != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return kC;
        }
        readHeader();
        if (kC.status != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            _mth068C();
            if (kC.frameCount < 0)
            {
                kC.status = 1;
            }
        }
        return kC;
    }
}
