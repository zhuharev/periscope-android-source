// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import o.vv;
import o.vw;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            FrameReader, Http2, ErrorCode, HeadersMode, 
//            Settings

static final class continuation
    implements FrameReader
{

    private final boolean client;
    private final ationSource continuation;
    final ationSource hpackReader;
    private final vv source;

    private void readData(andler andler, int i, byte byte0, int j)
    {
        boolean flag1;
        if ((byte0 & 1) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        boolean flag;
        if ((byte0 & 0x20) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            throw Http2.access$200("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        int k;
        if ((byte0 & 8) != 0)
        {
            k = (short)(source.readByte() & 0xff);
        } else
        {
            k = 0;
        }
        i = Http2.access$400(i, byte0, k);
        andler.data(flag1, j, source, i);
        source._mth02D1(k);
    }

    private void readGoAway(andler andler, int i, byte byte0, int j)
    {
        if (i < 8)
        {
            throw Http2.access$200("TYPE_GOAWAY length < 8: %s", new Object[] {
                Integer.valueOf(i)
            });
        }
        if (j != 0)
        {
            throw Http2.access$200("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        byte0 = source.readInt();
        j = source.readInt();
        i -= 8;
        ErrorCode errorcode = ErrorCode.fromHttp2(j);
        if (errorcode == null)
        {
            throw Http2.access$200("TYPE_GOAWAY unexpected error code: %d", new Object[] {
                Integer.valueOf(j)
            });
        }
        vw vw1 = vw.Vk;
        if (i > 0)
        {
            vw1 = source._mth02C9(i);
        }
        andler.goAway(byte0, errorcode, vw1);
    }

    private List readHeaderBlock(int i, short word0, byte byte0, int j)
    {
        ationSource ationsource = continuation;
        continuation.left = i;
        ationsource.length = i;
        continuation.padding = word0;
        continuation.flags = byte0;
        continuation.streamId = j;
        hpackReader.readHeaders();
        return hpackReader.getAndResetHeaderList();
    }

    private void readHeaders(andler andler, int i, byte byte0, int j)
    {
        if (j == 0)
        {
            throw Http2.access$200("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean flag;
        if ((byte0 & 1) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        short word0;
        if ((byte0 & 8) != 0)
        {
            word0 = (short)(source.readByte() & 0xff);
        } else
        {
            word0 = 0;
        }
        int k = i;
        if ((byte0 & 0x20) != 0)
        {
            readPriority(andler, j);
            k = i - 5;
        }
        andler.headers(false, flag, j, -1, readHeaderBlock(Http2.access$400(k, byte0, word0), word0, byte0, j), HeadersMode.HTTP_20_HEADERS);
    }

    private void readPing(andler andler, int i, byte byte0, int j)
    {
        if (i != 8)
        {
            throw Http2.access$200("TYPE_PING length != 8: %s", new Object[] {
                Integer.valueOf(i)
            });
        }
        if (j != 0)
        {
            throw Http2.access$200("TYPE_PING streamId != 0", new Object[0]);
        }
        i = source.readInt();
        j = source.readInt();
        boolean flag;
        if ((byte0 & 1) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        andler.ping(flag, i, j);
    }

    private void readPriority(andler andler, int i)
    {
        int j = source.readInt();
        boolean flag;
        if ((j & 0x80000000) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        andler.priority(i, j & 0x7fffffff, (source.readByte() & 0xff) + 1, flag);
    }

    private void readPriority(andler andler, int i, byte byte0, int j)
    {
        if (i != 5)
        {
            throw Http2.access$200("TYPE_PRIORITY length: %d != 5", new Object[] {
                Integer.valueOf(i)
            });
        }
        if (j == 0)
        {
            throw Http2.access$200("TYPE_PRIORITY streamId == 0", new Object[0]);
        } else
        {
            readPriority(andler, j);
            return;
        }
    }

    private void readPushPromise(andler andler, int i, byte byte0, int j)
    {
        if (j == 0)
        {
            throw Http2.access$200("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short word0;
        if ((byte0 & 8) != 0)
        {
            word0 = (short)(source.readByte() & 0xff);
        } else
        {
            word0 = 0;
        }
        andler.pushPromise(j, source.readInt() & 0x7fffffff, readHeaderBlock(Http2.access$400(i - 4, byte0, word0), word0, byte0, j));
    }

    private void readRstStream(andler andler, int i, byte byte0, int j)
    {
        if (i != 4)
        {
            throw Http2.access$200("TYPE_RST_STREAM length: %d != 4", new Object[] {
                Integer.valueOf(i)
            });
        }
        if (j == 0)
        {
            throw Http2.access$200("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        i = source.readInt();
        ErrorCode errorcode = ErrorCode.fromHttp2(i);
        if (errorcode == null)
        {
            throw Http2.access$200("TYPE_RST_STREAM unexpected error code: %d", new Object[] {
                Integer.valueOf(i)
            });
        } else
        {
            andler.rstStream(j, errorcode);
            return;
        }
    }

    private void readSettings(andler andler, int i, byte byte0, int j)
    {
        if (j != 0)
        {
            throw Http2.access$200("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((byte0 & 1) != 0)
        {
            if (i != 0)
            {
                throw Http2.access$200("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            } else
            {
                andler.ackSettings();
                return;
            }
        }
        if (i % 6 != 0)
        {
            throw Http2.access$200("TYPE_SETTINGS length %% 6 != 0: %s", new Object[] {
                Integer.valueOf(i)
            });
        }
        Settings settings = new Settings();
        for (byte0 = 0; byte0 < i; byte0 += 6)
        {
            short word0 = source.readShort();
            int k = source.readInt();
            switch (word0)
            {
            case 1: // '\001'
                j = word0;
                break;

            case 2: // '\002'
                j = word0;
                if (k == 0)
                {
                    break;
                }
                j = word0;
                if (k != 1)
                {
                    throw Http2.access$200("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
                break;

            case 3: // '\003'
                j = 4;
                break;

            case 4: // '\004'
                j = 7;
                if (k < 0)
                {
                    throw Http2.access$200("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                }
                break;

            case 5: // '\005'
                if (k >= 16384)
                {
                    j = word0;
                    if (k <= 0xffffff)
                    {
                        break;
                    }
                }
                throw Http2.access$200("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[] {
                    Integer.valueOf(k)
                });

            case 6: // '\006'
                j = word0;
                break;

            default:
                throw Http2.access$200("PROTOCOL_ERROR invalid settings id: %s", new Object[] {
                    Short.valueOf(word0)
                });
            }
            settings.set(j, 0, k);
        }

        andler.settings(false, settings);
        if (settings.getHeaderTableSize() >= 0)
        {
            hpackReader.headerTableSizeSetting(settings.getHeaderTableSize());
        }
    }

    private void readWindowUpdate(andler andler, int i, byte byte0, int j)
    {
        if (i != 4)
        {
            throw Http2.access$200("TYPE_WINDOW_UPDATE length !=4: %s", new Object[] {
                Integer.valueOf(i)
            });
        }
        long l = (long)source.readInt() & 0x7fffffffL;
        if (l == 0L)
        {
            throw Http2.access$200("windowSizeIncrement was 0", new Object[] {
                Long.valueOf(l)
            });
        } else
        {
            andler.windowUpdate(j, l);
            return;
        }
    }

    public final void close()
    {
        source.close();
    }

    public final boolean nextFrame(andler andler)
    {
        try
        {
            source._mth02BF(9L);
        }
        // Misplaced declaration of an exception variable
        catch (andler andler)
        {
            return false;
        }
        int i = Http2.access$300(source);
        if (i < 0 || i > 16384)
        {
            throw Http2.access$200("FRAME_SIZE_ERROR: %s", new Object[] {
                Integer.valueOf(i)
            });
        }
        byte byte0 = source.readByte();
        byte byte1 = source.readByte();
        int j = source.readInt() & 0x7fffffff;
        if (Http2.access$100().isLoggable(Level.FINE))
        {
            Http2.access$100().fine(gger.formatHeader(true, j, i, byte0, byte1));
        }
        switch (byte0)
        {
        case 0: // '\0'
            readData(andler, i, byte1, j);
            break;

        case 1: // '\001'
            readHeaders(andler, i, byte1, j);
            break;

        case 2: // '\002'
            readPriority(andler, i, byte1, j);
            break;

        case 3: // '\003'
            readRstStream(andler, i, byte1, j);
            break;

        case 4: // '\004'
            readSettings(andler, i, byte1, j);
            break;

        case 5: // '\005'
            readPushPromise(andler, i, byte1, j);
            break;

        case 6: // '\006'
            readPing(andler, i, byte1, j);
            break;

        case 7: // '\007'
            readGoAway(andler, i, byte1, j);
            break;

        case 8: // '\b'
            readWindowUpdate(andler, i, byte1, j);
            break;

        default:
            source._mth02D1(i);
            break;
        }
        return true;
    }

    public final void readConnectionPreface()
    {
        if (client)
        {
            return;
        }
        vw vw1 = source._mth02C9(Http2.access$000().data.length);
        if (Http2.access$100().isLoggable(Level.FINE))
        {
            Http2.access$100().fine(String.format("<< CONNECTION %s", new Object[] {
                vw1._mth0192()
            }));
        }
        if (!Http2.access$000().equals(vw1))
        {
            throw Http2.access$200("Expected a connection header but was %s", new Object[] {
                vw1._mth0178()
            });
        } else
        {
            return;
        }
    }

    andler(vv vv1, int i, boolean flag)
    {
        source = vv1;
        client = flag;
        continuation = new ationSource(source);
        hpackReader = new <init>(i, continuation);
    }
}
