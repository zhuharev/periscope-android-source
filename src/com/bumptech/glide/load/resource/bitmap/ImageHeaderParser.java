// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class ImageHeaderParser
{
    public static final class ImageType extends Enum
    {

        private static final ImageType $VALUES[];
        public static final ImageType GIF;
        public static final ImageType JPEG;
        public static final ImageType PNG;
        public static final ImageType PNG_A;
        public static final ImageType UNKNOWN;
        private final boolean pn;

        public static ImageType valueOf(String s)
        {
            return (ImageType)Enum.valueOf(com/bumptech/glide/load/resource/bitmap/ImageHeaderParser$ImageType, s);
        }

        public static ImageType[] values()
        {
            return (ImageType[])$VALUES.clone();
        }

        public final boolean hasAlpha()
        {
            return pn;
        }

        static 
        {
            GIF = new ImageType("GIF", 0, true);
            JPEG = new ImageType("JPEG", 1, false);
            PNG_A = new ImageType("PNG_A", 2, true);
            PNG = new ImageType("PNG", 3, false);
            UNKNOWN = new ImageType("UNKNOWN", 4, false);
            $VALUES = (new ImageType[] {
                GIF, JPEG, PNG_A, PNG, UNKNOWN
            });
        }

        private ImageType(String s, int i, boolean flag)
        {
            super(s, i);
            pn = flag;
        }
    }

    public static final class if
    {

        final ByteBuffer data;

        public if(byte abyte0[])
        {
            data = ByteBuffer.wrap(abyte0);
            data.order(ByteOrder.BIG_ENDIAN);
        }
    }

    /* member class not found */
    class _cls02CA {}


    public static final byte pk[];
    private static final int pl[];
    public final _cls02CA pm;

    public ImageHeaderParser(InputStream inputstream)
    {
        pm = new _cls02CA(inputstream);
    }

    public static int _mth02CA(if if1)
    {
        ByteOrder byteorder;
label0:
        {
            short word0 = if1.data.getShort(6);
            if (word0 != 19789)
            {
                if (word0 == 18761)
                {
                    byteorder = ByteOrder.LITTLE_ENDIAN;
                    break label0;
                }
                if (Log.isLoggable("ImageHeaderParser", 3))
                {
                    Log.d("ImageHeaderParser", (new StringBuilder("Unknown endianness = ")).append(word0).toString());
                }
            }
            byteorder = ByteOrder.BIG_ENDIAN;
        }
        if1.data.order(byteorder);
        int j = if1.data.getInt(10) + 6;
        short word1 = if1.data.getShort(j);
        for (int i = 0; i < word1; i++)
        {
            int k = j + 2 + i * 12;
            short word2 = if1.data.getShort(k);
            if (word2 != 274)
            {
                continue;
            }
            short word3 = if1.data.getShort(k + 2);
            if (word3 <= 0 || word3 > 12)
            {
                if (Log.isLoggable("ImageHeaderParser", 3))
                {
                    Log.d("ImageHeaderParser", (new StringBuilder("Got invalid format code=")).append(word3).toString());
                }
                continue;
            }
            int l = if1.data.getInt(k + 4);
            if (l < 0)
            {
                if (Log.isLoggable("ImageHeaderParser", 3))
                {
                    Log.d("ImageHeaderParser", "Negative tiff component count");
                }
                continue;
            }
            if (Log.isLoggable("ImageHeaderParser", 3))
            {
                Log.d("ImageHeaderParser", (new StringBuilder("Got tagIndex=")).append(i).append(" tagType=").append(word2).append(" formatCode=").append(word3).append(" componentCount=").append(l).toString());
            }
            l = pl[word3] + l;
            if (l > 4)
            {
                if (Log.isLoggable("ImageHeaderParser", 3))
                {
                    Log.d("ImageHeaderParser", (new StringBuilder("Got byte count > 4, not orientation, continuing, formatCode=")).append(word3).toString());
                }
                continue;
            }
            k += 8;
            if (k < 0 || k > if1.data.array().length)
            {
                if (Log.isLoggable("ImageHeaderParser", 3))
                {
                    Log.d("ImageHeaderParser", (new StringBuilder("Illegal tagValueOffset=")).append(k).append(" tagType=").append(word2).toString());
                }
                continue;
            }
            if (l < 0 || k + l > if1.data.array().length)
            {
                if (Log.isLoggable("ImageHeaderParser", 3))
                {
                    Log.d("ImageHeaderParser", (new StringBuilder("Illegal number of bytes for TI tag data tagType=")).append(word2).toString());
                }
            } else
            {
                return if1.data.getShort(k);
            }
        }

        return -1;
    }

    public static boolean _mth1D4C(int i)
    {
        return (0xffd8 & i) == 65496 || i == 19789 || i == 18761;
    }

    public final ImageType FB84()
    {
        _cls02CA _lcls02ca = pm;
        int i = _lcls02ca.po.read() << 8 & 0xff00 | _lcls02ca.po.read() & 0xff;
        if (i == 65496)
        {
            return ImageType.JPEG;
        }
        _lcls02ca = pm;
        i = i << 16 & 0xffff0000 | (_lcls02ca.po.read() << 8 & 0xff00 | _lcls02ca.po.read() & 0xff) & 0xffff;
        if (i == 0x89504e47)
        {
            pm.skip(21L);
            if (pm.po.read() >= 3)
            {
                return ImageType.PNG_A;
            } else
            {
                return ImageType.PNG;
            }
        }
        if (i >> 8 == 0x474946)
        {
            return ImageType.GIF;
        } else
        {
            return ImageType.UNKNOWN;
        }
    }

    static 
    {
        byte abyte0[];
        pl = (new int[] {
            0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 
            8, 4, 8
        });
        abyte0 = new byte[0];
        byte abyte1[] = "Exif\000\0".getBytes("UTF-8");
        abyte0 = abyte1;
_L2:
        pk = abyte0;
        return;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
