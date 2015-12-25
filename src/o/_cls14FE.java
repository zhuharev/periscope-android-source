// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package o:
//            FC62, _cls0582, _cls05D4, _cls148D, 
//            _cls0264, _cls51AB, _cls30CE, _cls4EA0, 
//            FB3C, _cls043E, FF43, _cls06BA

public final class _cls14FE
    implements FC62
{
    /* member class not found */
    class if {}


    private static final if qj = new if();
    private final _cls06BA je;
    private final _cls30CE.if qk;
    private final if ql;

    public _cls14FE(_cls06BA _pcls06ba)
    {
        this(_pcls06ba, qj);
    }

    private _cls14FE(_cls06BA _pcls06ba, if if1)
    {
        je = _pcls06ba;
        qk = new _cls30CE.if(_pcls06ba);
        ql = if1;
    }

    private boolean _mth02CA(_cls05D4 _pcls05d4, OutputStream outputstream)
    {
        FF43 ff43;
        Object obj;
        FB3C fb3c;
        int i;
        long l;
        l = _cls0582._mth0621();
        _pcls05d4 = (_cls148D)_pcls05d4.get();
        ff43 = ((_cls148D) (_pcls05d4)).pF.pN;
        if (ff43 instanceof _cls0264)
        {
            return _mth02CA(((_cls148D) (_pcls05d4)).pF.data, outputstream);
        }
        byte abyte0[] = ((_cls148D) (_pcls05d4)).pF.data;
        obj = new _cls51AB();
        ((_cls51AB) (obj))._mth02CA(abyte0);
        _cls4EA0 _lcls4ea0 = ((_cls51AB) (obj))._mth05F1();
        obj = new _cls30CE(qk);
        ((_cls30CE) (obj))._mth02CA(_lcls4ea0, abyte0);
        obj.kB = (((_cls30CE) (obj)).kB + 1) % ((_cls30CE) (obj)).kC.frameCount;
        fb3c = new FB3C();
        if (!fb3c._mth02CA(outputstream))
        {
            return false;
        }
        i = 0;
_L2:
        if (i >= ((_cls30CE) (obj)).kC.frameCount)
        {
            break; /* Loop/switch isn't completed */
        }
        _cls043E _lcls043e = new _cls043E(((_cls30CE) (obj))._mth0285(), je);
        outputstream = ff43._mth02CA(_lcls043e, _pcls05d4.getIntrinsicWidth(), _pcls05d4.getIntrinsicHeight());
        if (!_lcls043e.equals(outputstream))
        {
            _lcls043e.recycle();
        }
        boolean flag = fb3c._mth02CF((Bitmap)outputstream.get());
        if (!flag)
        {
            outputstream.recycle();
            return false;
        }
        fb3c.delay = Math.round((float)((_cls30CE) (obj))._mth0E40(((_cls30CE) (obj)).kB) / 10F);
        obj.kB = (((_cls30CE) (obj)).kB + 1) % ((_cls30CE) (obj)).kC.frameCount;
        outputstream.recycle();
        break MISSING_BLOCK_LABEL_295;
        _pcls05d4;
        outputstream.recycle();
        throw _pcls05d4;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        boolean flag1 = fb3c._mth09F3();
        if (Log.isLoggable("GifEncoder", 2))
        {
            Log.v("GifEncoder", (new StringBuilder("Encoded gif with ")).append(((_cls30CE) (obj)).kC.frameCount).append(" frames and ").append(((_cls148D) (_pcls05d4)).pF.data.length).append(" bytes in ").append(_cls0582._mth02BB(l)).append(" ms").toString());
        }
        return flag1;
    }

    private static boolean _mth02CA(byte abyte0[], OutputStream outputstream)
    {
        try
        {
            outputstream.write(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            if (Log.isLoggable("GifEncoder", 3))
            {
                Log.d("GifEncoder", "Failed to write data to output stream in GifResourceEncoder", abyte0);
            }
            return false;
        }
        return true;
    }

    public final String getId()
    {
        return "";
    }

    public final volatile boolean _mth02CA(Object obj, OutputStream outputstream)
    {
        return _mth02CA((_cls05D4)obj, outputstream);
    }

}
