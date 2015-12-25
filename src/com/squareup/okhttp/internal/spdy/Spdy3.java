// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.zip.Deflater;
import o.vr;
import o.vu;
import o.vv;
import o.vw;
import o.vx;
import o.wc;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Variant, FrameReader, FrameWriter, NameValueBlockReader, 
//            ErrorCode, HeadersMode, Settings, Header

public final class Spdy3
    implements Variant
{
    static final class Reader
        implements FrameReader
    {

        private final boolean client;
        private final NameValueBlockReader headerBlockReader;
        private final vv source;

        private static transient IOException ioException(String s, Object aobj[])
        {
            throw new IOException(String.format(s, aobj));
        }

        private void readGoAway(FrameReader.Handler handler, int i, int j)
        {
            if (j != 8)
            {
                throw ioException("TYPE_GOAWAY length: %d != 8", new Object[] {
                    Integer.valueOf(j)
                });
            }
            i = source.readInt();
            j = source.readInt();
            ErrorCode errorcode = ErrorCode.fromSpdyGoAway(j);
            if (errorcode == null)
            {
                throw ioException("TYPE_GOAWAY unexpected error code: %d", new Object[] {
                    Integer.valueOf(j)
                });
            } else
            {
                handler.goAway(i & 0x7fffffff, errorcode, vw.Vk);
                return;
            }
        }

        private void readHeaders(FrameReader.Handler handler, int i, int j)
        {
            handler.headers(false, false, source.readInt() & 0x7fffffff, -1, headerBlockReader.readNameValueBlock(j - 4), HeadersMode.SPDY_HEADERS);
        }

        private void readPing(FrameReader.Handler handler, int i, int j)
        {
            if (j != 4)
            {
                throw ioException("TYPE_PING length: %d != 4", new Object[] {
                    Integer.valueOf(j)
                });
            }
            i = source.readInt();
            boolean flag1 = client;
            boolean flag;
            if ((i & 1) == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag1 == flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            handler.ping(flag, i, 0);
        }

        private void readRstStream(FrameReader.Handler handler, int i, int j)
        {
            if (j != 8)
            {
                throw ioException("TYPE_RST_STREAM length: %d != 8", new Object[] {
                    Integer.valueOf(j)
                });
            }
            i = source.readInt();
            j = source.readInt();
            ErrorCode errorcode = ErrorCode.fromSpdy3Rst(j);
            if (errorcode == null)
            {
                throw ioException("TYPE_RST_STREAM unexpected error code: %d", new Object[] {
                    Integer.valueOf(j)
                });
            } else
            {
                handler.rstStream(i & 0x7fffffff, errorcode);
                return;
            }
        }

        private void readSettings(FrameReader.Handler handler, int i, int j)
        {
            int k = source.readInt();
            if (j != k * 8 + 4)
            {
                throw ioException("TYPE_SETTINGS length: %d != 4 + 8 * %d", new Object[] {
                    Integer.valueOf(j), Integer.valueOf(k)
                });
            }
            Settings settings = new Settings();
            for (j = 0; j < k; j++)
            {
                int l = source.readInt();
                settings.set(l & 0xffffff, (0xff000000 & l) >>> 24, source.readInt());
            }

            boolean flag;
            if ((i & 1) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            handler.settings(flag, settings);
        }

        private void readSynReply(FrameReader.Handler handler, int i, int j)
        {
            int k = source.readInt();
            List list = headerBlockReader.readNameValueBlock(j - 4);
            boolean flag;
            if ((i & 1) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            handler.headers(false, flag, k & 0x7fffffff, -1, list, HeadersMode.SPDY_REPLY);
        }

        private void readSynStream(FrameReader.Handler handler, int i, int j)
        {
            int k = source.readInt();
            int l = source.readInt();
            source.readShort();
            List list = headerBlockReader.readNameValueBlock(j - 10);
            boolean flag;
            if ((i & 1) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            boolean flag1;
            if ((i & 2) != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            handler.headers(flag1, flag, k & 0x7fffffff, l & 0x7fffffff, list, HeadersMode.SPDY_SYN_STREAM);
        }

        private void readWindowUpdate(FrameReader.Handler handler, int i, int j)
        {
            if (j != 8)
            {
                throw ioException("TYPE_WINDOW_UPDATE length: %d != 8", new Object[] {
                    Integer.valueOf(j)
                });
            }
            i = source.readInt();
            long l = 0x7fffffff & source.readInt();
            if (l == 0L)
            {
                throw ioException("windowSizeIncrement was 0", new Object[] {
                    Long.valueOf(l)
                });
            } else
            {
                handler.windowUpdate(i & 0x7fffffff, l);
                return;
            }
        }

        public final void close()
        {
            headerBlockReader.close();
        }

        public final boolean nextFrame(FrameReader.Handler handler)
        {
            int j;
            int k;
            try
            {
                j = source.readInt();
                k = source.readInt();
            }
            // Misplaced declaration of an exception variable
            catch (FrameReader.Handler handler)
            {
                return false;
            }
            boolean flag;
            if ((0x80000000 & j) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            int l = (0xff000000 & k) >>> 24;
            k &= 0xffffff;
            if (flag)
            {
                int i = (0x7fff0000 & j) >>> 16;
                if (i != 3)
                {
                    throw new ProtocolException((new StringBuilder("version != 3: ")).append(i).toString());
                }
                switch (j & 0xffff)
                {
                case 1: // '\001'
                    readSynStream(handler, l, k);
                    return true;

                case 2: // '\002'
                    readSynReply(handler, l, k);
                    return true;

                case 3: // '\003'
                    readRstStream(handler, l, k);
                    return true;

                case 4: // '\004'
                    readSettings(handler, l, k);
                    return true;

                case 6: // '\006'
                    readPing(handler, l, k);
                    return true;

                case 7: // '\007'
                    readGoAway(handler, l, k);
                    return true;

                case 8: // '\b'
                    readHeaders(handler, l, k);
                    return true;

                case 9: // '\t'
                    readWindowUpdate(handler, l, k);
                    return true;
                }
                source._mth02D1(k);
                return true;
            }
            boolean flag1;
            if ((l & 1) != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            handler.data(flag1, j & 0x7fffffff, source, k);
            return true;
        }

        public final void readConnectionPreface()
        {
        }

        Reader(vv vv1, boolean flag)
        {
            source = vv1;
            headerBlockReader = new NameValueBlockReader(source);
            client = flag;
        }
    }

    static final class Writer
        implements FrameWriter
    {

        private final boolean client;
        private boolean closed;
        private final vr headerBlockBuffer = new vr();
        private final vu headerBlockOut;
        private final vu sink;

        private void writeNameValueBlockToBuffer(List list)
        {
            if (headerBlockBuffer.size != 0L)
            {
                throw new IllegalStateException();
            }
            headerBlockOut._mth0456(list.size());
            int i = 0;
            for (int j = list.size(); i < j; i++)
            {
                vw vw1 = ((Header)list.get(i)).name;
                headerBlockOut._mth0456(vw1.data.length);
                headerBlockOut._mth02CA(vw1);
                vw1 = ((Header)list.get(i)).value;
                headerBlockOut._mth0456(vw1.data.length);
                headerBlockOut._mth02CA(vw1);
            }

            headerBlockOut.flush();
        }

        public final void ackSettings(Settings settings1)
        {
        }

        public final void close()
        {
            this;
            JVM INSTR monitorenter ;
            closed = true;
            Util.closeAll(sink, headerBlockOut);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public final void connectionPreface()
        {
            this;
            JVM INSTR monitorenter ;
        }

        public final void data(boolean flag, int i, vr vr1, int j)
        {
            this;
            JVM INSTR monitorenter ;
            int k;
            if (flag)
            {
                k = 1;
            } else
            {
                k = 0;
            }
            sendDataFrame(i, k, vr1, j);
            this;
            JVM INSTR monitorexit ;
            return;
            vr1;
            throw vr1;
        }

        public final void flush()
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            sink.flush();
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public final void goAway(int i, ErrorCode errorcode, byte abyte0[])
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            if (errorcode.spdyGoAwayCode == -1)
            {
                throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
            }
            sink._mth0456(0x80030007);
            sink._mth0456(8);
            sink._mth0456(i);
            sink._mth0456(errorcode.spdyGoAwayCode);
            sink.flush();
            this;
            JVM INSTR monitorexit ;
            return;
            errorcode;
            throw errorcode;
        }

        public final void headers(int i, List list)
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            writeNameValueBlockToBuffer(list);
            int j = (int)(headerBlockBuffer.size + 4L);
            sink._mth0456(0x80030008);
            sink._mth0456(0xffffff & j | 0);
            sink._mth0456(0x7fffffff & i);
            sink._mth02CA(headerBlockBuffer);
            this;
            JVM INSTR monitorexit ;
            return;
            list;
            throw list;
        }

        public final int maxDataLength()
        {
            return 16383;
        }

        public final void ping(boolean flag, int i, int j)
        {
            this;
            JVM INSTR monitorenter ;
            boolean flag2;
            if (closed)
            {
                throw new IOException("closed");
            }
            flag2 = client;
            break MISSING_BLOCK_LABEL_25;
_L2:
            if (flag == flag1)
            {
                break MISSING_BLOCK_LABEL_54;
            }
            throw new IllegalArgumentException("payload != reply");
            sink._mth0456(0x80030006);
            sink._mth0456(4);
            sink._mth0456(i);
            sink.flush();
            this;
            JVM INSTR monitorexit ;
            return;
            exception;
            throw exception;
            Exception exception;
            boolean flag1;
            if ((i & 1) == 1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag2 != flag1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (true) goto _L2; else goto _L1
_L1:
        }

        public final void pushPromise(int i, int j, List list)
        {
        }

        public final void rstStream(int i, ErrorCode errorcode)
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            if (errorcode.spdyRstCode == -1)
            {
                throw new IllegalArgumentException();
            }
            sink._mth0456(0x80030003);
            sink._mth0456(8);
            sink._mth0456(0x7fffffff & i);
            sink._mth0456(errorcode.spdyRstCode);
            sink.flush();
            this;
            JVM INSTR monitorexit ;
            return;
            errorcode;
            throw errorcode;
        }

        final void sendDataFrame(int i, int j, vr vr1, int k)
        {
            if (closed)
            {
                throw new IOException("closed");
            }
            if ((long)k > 0xffffffL)
            {
                throw new IllegalArgumentException((new StringBuilder("FRAME_TOO_LARGE max size is 16Mib: ")).append(k).toString());
            }
            sink._mth0456(0x7fffffff & i);
            sink._mth0456((j & 0xff) << 24 | 0xffffff & k);
            if (k > 0)
            {
                sink.write(vr1, k);
            }
        }

        public final void settings(Settings settings1)
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            int i = settings1.size();
            sink._mth0456(0x80030004);
            sink._mth0456(0xffffff & (i << 3) + 4 | 0);
            sink._mth0456(i);
            int j = 0;
_L2:
            if (j > 10)
            {
                break MISSING_BLOCK_LABEL_130;
            }
            if (settings1.isSet(j))
            {
                int k = settings1.flags(j);
                sink._mth0456((k & 0xff) << 24 | 0xffffff & j);
                sink._mth0456(settings1.get(j));
            }
            break MISSING_BLOCK_LABEL_147;
            sink.flush();
            this;
            JVM INSTR monitorexit ;
            return;
            settings1;
            throw settings1;
            j++;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public final void synReply(boolean flag, int i, List list)
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            writeNameValueBlockToBuffer(list);
            int j;
            int k;
            if (flag)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            k = (int)(headerBlockBuffer.size + 4L);
            sink._mth0456(0x80030002);
            sink._mth0456((j & 0xff) << 24 | 0xffffff & k);
            sink._mth0456(0x7fffffff & i);
            sink._mth02CA(headerBlockBuffer);
            sink.flush();
            this;
            JVM INSTR monitorexit ;
            return;
            list;
            throw list;
        }

        public final void synStream(boolean flag, boolean flag1, int i, int j, List list)
        {
            this;
            JVM INSTR monitorenter ;
            int k;
            if (closed)
            {
                throw new IOException("closed");
            }
            writeNameValueBlockToBuffer(list);
            k = (int)(headerBlockBuffer.size + 10L);
            break MISSING_BLOCK_LABEL_39;
_L2:
            sink._mth0456(0x80030001);
            sink._mth0456(((flag2 | byte0) & 0xff) << 24 | 0xffffff & k);
            sink._mth0456(0x7fffffff & i);
            sink._mth0456(0x7fffffff & j);
            sink._mth0457(0);
            sink._mth02CA(headerBlockBuffer);
            sink.flush();
            this;
            JVM INSTR monitorexit ;
            return;
            list;
            throw list;
            boolean flag2;
            byte byte0;
            if (flag)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (flag1)
            {
                byte0 = 2;
            } else
            {
                byte0 = 0;
            }
            if (true) goto _L2; else goto _L1
_L1:
        }

        public final void windowUpdate(int i, long l)
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
              goto _L1
_L2:
            throw new IllegalArgumentException((new StringBuilder("windowSizeIncrement must be between 1 and 0x7fffffff: ")).append(l).toString());
_L3:
            sink._mth0456(0x80030009);
            sink._mth0456(8);
            sink._mth0456(i);
            sink._mth0456((int)l);
            sink.flush();
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
_L1:
            if (l != 0L && l <= 0x7fffffffL) goto _L3; else goto _L2
        }

        Writer(vu vu1, boolean flag)
        {
            sink = vu1;
            client = flag;
            vu1 = new Deflater();
            vu1.setDictionary(Spdy3.DICTIONARY);
            headerBlockOut = wc._mth02CA(new vx(headerBlockBuffer, vu1));
        }
    }


    static final byte DICTIONARY[];
    static final int FLAG_FIN = 1;
    static final int FLAG_UNIDIRECTIONAL = 2;
    static final int TYPE_DATA = 0;
    static final int TYPE_GOAWAY = 7;
    static final int TYPE_HEADERS = 8;
    static final int TYPE_PING = 6;
    static final int TYPE_RST_STREAM = 3;
    static final int TYPE_SETTINGS = 4;
    static final int TYPE_SYN_REPLY = 2;
    static final int TYPE_SYN_STREAM = 1;
    static final int TYPE_WINDOW_UPDATE = 9;
    static final int VERSION = 3;

    public Spdy3()
    {
    }

    public final Protocol getProtocol()
    {
        return Protocol.SPDY_3;
    }

    public final FrameReader newReader(vv vv, boolean flag)
    {
        return new Reader(vv, flag);
    }

    public final FrameWriter newWriter(vu vu, boolean flag)
    {
        return new Writer(vu, flag);
    }

    static 
    {
        UnsupportedEncodingException unsupportedencodingexception;
        try
        {
            DICTIONARY = "\000\000\000\007options\000\000\000\004head\000\000\000\004post\000\000\000\003put\000\000\000\006delete\000\000\000\005trace\000\000\000\006accept\000\000\000\016accept-charset\000\000\000\017accept-encoding\000\000\000\017accept-language\000\000\000\raccept-ranges\000\000\000\003age\000\000\000\005allow\000\000\000\rauthorization\000\000\000\rcache-control\000\000\000\nconnection\000\000\000\fcontent-base\000\000\000\020content-encoding\000\000\000\020content-language\000\000\000\016content-length\000\000\000\020content-location\000\000\000\013content-md5\000\000\000\rcontent-range\000\000\000\fcontent-type\000\000\000\004date\000\000\000\004etag\000\000\000\006expect\000\000\000\007expires\000\000\000\004from\000\000\000\004host\000\000\000\bif-match\000\000\000\021if-modified-since\000\000\000\rif-none-match\000\000\000\bif-range\000\000\000\023if-unmodified-since\000\000\000\rlast-modified\000\000\000\blocation\000\000\000\fmax-forwards\000\000\000\006pragma\000\000\000\022proxy-authenticate\000\000\000\023proxy-authorization\000\000\000\005range\000\000\000\007referer\000\000\000\013retry-after\000\000\000\006server\000\000\000\002te\000\000\000\007trailer\000\000\000\021transfer-encoding\000\000\000\007upgrade\000\000\000\nuser-agent\000\000\000\004vary\000\000\000\003via\000\000\000\007warning\000\000\000\020www-authenticate\000\000\000\006method\000\000\000\003get\000\000\000\006status\000\000\000\006200 OK\000\000\000\007version\000\000\000\bHTTP/1.1\000\000\000\003url\000\000\000\006public\000\000\000\nset-cookie\000\000\000\nkeep-alive\000\000\000\006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(Util.UTF_8.name());
        }
        // Misplaced declaration of an exception variable
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new AssertionError();
        }
    }
}
