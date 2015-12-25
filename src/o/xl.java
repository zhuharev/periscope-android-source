// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.media.MediaFormat;
import java.nio.ByteBuffer;

// Referenced classes of package o:
//            aed, aav

public interface xl
{
    public static interface if
    {

        public abstract void _mth02B9(int ai[]);

        public abstract void _mth02CA(MediaFormat mediaformat, MediaFormat mediaformat1);

        public abstract void _mth02CA(ByteBuffer bytebuffer, android.media.MediaCodec.BufferInfo bufferinfo);

        public abstract void _mth02CB(ByteBuffer bytebuffer, android.media.MediaCodec.BufferInfo bufferinfo);

        public abstract boolean _mth1D54(long l);
    }


    public abstract int getMaxZoom();

    public abstract void setZoom(int i);

    public abstract void stopPreview();

    public abstract void _mth02CA(aed aed);

    public abstract boolean _mth02CA(aav aav);

    public abstract void _mth1D32(int i);

    public abstract void _mth1D3E(int i);

    public abstract void _mth1D41(int i);

    public abstract void _mth1D43(int i);

    public abstract void _mth30F6();

    public abstract void _mth4E2B();

    public abstract void _mth4E41();

    public abstract int _mth722B();

    public abstract int FB24();

    public abstract void FB38();
}
