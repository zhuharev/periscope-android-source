// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.Protocol;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import o.vr;
import o.vu;
import o.vv;
import o.vw;
import o.wn;
import o.wo;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Variant, FrameReader, FrameWriter, ErrorCode, 
//            HeadersMode, Settings

public final class Http2
    implements Variant
{
    static final class ContinuationSource
        implements wn
    {

        byte flags;
        int left;
        int length;
        short padding;
        private final vv source;
        int streamId;

        private void readContinuationHeader()
        {
            int i = streamId;
            int j = Http2.readMedium(source);
            left = j;
            length = j;
            byte byte0 = source.readByte();
            flags = source.readByte();
            if (Http2.logger.isLoggable(Level.FINE))
            {
                Http2.logger.fine(FrameLogger.formatHeader(true, streamId, length, byte0, flags));
            }
            streamId = source.readInt() & 0x7fffffff;
            if (byte0 != 9)
            {
                throw Http2.ioException("%s != TYPE_CONTINUATION", new Object[] {
                    Byte.valueOf(byte0)
                });
            }
            if (streamId != i)
            {
                throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
            } else
            {
                return;
            }
        }

        public final void close()
        {
        }

        public final long read(vr vr, long l)
        {
            while (left == 0) 
            {
                source._mth02D1(padding);
                padding = 0;
                if ((flags & 4) != 0)
                {
                    return -1L;
                }
                readContinuationHeader();
            }
            l = source.read(vr, Math.min(l, left));
            if (l == -1L)
            {
                return -1L;
            } else
            {
                left = (int)((long)left - l);
                return l;
            }
        }

        public final wo timeout()
        {
            return source.timeout();
        }

        public ContinuationSource(vv vv1)
        {
            source = vv1;
        }
    }

    static final class FrameLogger
    {

        private static final String BINARY[];
        private static final String FLAGS[];
        private static final String TYPES[] = {
            "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"
        };

        static String formatFlags(byte byte0, byte byte1)
        {
            if (byte1 == 0)
            {
                return "";
            }
            switch (byte0)
            {
            case 4: // '\004'
            case 6: // '\006'
                if (byte1 == 1)
                {
                    return "ACK";
                } else
                {
                    return BINARY[byte1];
                }

            case 2: // '\002'
            case 3: // '\003'
            case 7: // '\007'
            case 8: // '\b'
                return BINARY[byte1];
            }
            String s;
            if (byte1 < FLAGS.length)
            {
                s = FLAGS[byte1];
            } else
            {
                s = BINARY[byte1];
            }
            if (byte0 == 5 && (byte1 & 4) != 0)
            {
                return s.replace("HEADERS", "PUSH_PROMISE");
            }
            if (byte0 == 0 && (byte1 & 0x20) != 0)
            {
                return s.replace("PRIORITY", "COMPRESSED");
            } else
            {
                return s;
            }
        }

        static String formatHeader(boolean flag, int i, int j, byte byte0, byte byte1)
        {
            String s;
            if (byte0 < TYPES.length)
            {
                s = TYPES[byte0];
            } else
            {
                s = String.format("0x%02x", new Object[] {
                    Byte.valueOf(byte0)
                });
            }
            String s2 = formatFlags(byte0, byte1);
            String s1;
            if (flag)
            {
                s1 = "<<";
            } else
            {
                s1 = ">>";
            }
            return String.format("%s 0x%08x %5d %-13s %s", new Object[] {
                s1, Integer.valueOf(i), Integer.valueOf(j), s, s2
            });
        }

        static 
        {
            FLAGS = new String[64];
            BINARY = new String[256];
            for (int i = 0; i < BINARY.length; i++)
            {
                BINARY[i] = String.format("%8s", new Object[] {
                    Integer.toBinaryString(i)
                }).replace(' ', '0');
            }

            FLAGS[0] = "";
            FLAGS[1] = "END_STREAM";
            int ai[] = new int[1];
            int[] _tmp = ai;
            ai[0] = 1;
            FLAGS[8] = "PADDED";
            for (int j = 0; j <= 0; j++)
            {
                int i1 = ai[j];
                FLAGS[i1 | 8] = (new StringBuilder()).append(FLAGS[i1]).append("|PADDED").toString();
            }

            FLAGS[4] = "END_HEADERS";
            FLAGS[32] = "PRIORITY";
            FLAGS[36] = "END_HEADERS|PRIORITY";
            for (int k = 0; k < 3; k++)
            {
                int k1 = (new int[] {
                    4, 32, 36
                })[k];
                for (int j1 = 0; j1 <= 0; j1++)
                {
                    int l1 = ai[j1];
                    FLAGS[l1 | k1] = (new StringBuilder()).append(FLAGS[l1]).append('|').append(FLAGS[k1]).toString();
                    FLAGS[l1 | k1 | 8] = (new StringBuilder()).append(FLAGS[l1]).append('|').append(FLAGS[k1]).append("|PADDED").toString();
                }

            }

            for (int l = 0; l < FLAGS.length; l++)
            {
                if (FLAGS[l] == null)
                {
                    FLAGS[l] = BINARY[l];
                }
            }

        }

        FrameLogger()
        {
        }
    }

    static final class Reader
        implements FrameReader
    {

        private final boolean client;
        private final ContinuationSource continuation;
        final Hpack.Reader hpackReader;
        private final vv source;

        private void readData(FrameReader.Handler handler, int i, byte byte0, int j)
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
                throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            }
            int k;
            if ((byte0 & 8) != 0)
            {
                k = (short)(source.readByte() & 0xff);
            } else
            {
                k = 0;
            }
            i = Http2.lengthWithoutPadding(i, byte0, k);
            handler.data(flag1, j, source, i);
            source._mth02D1(k);
        }

        private void readGoAway(FrameReader.Handler handler, int i, byte byte0, int j)
        {
            if (i < 8)
            {
                throw Http2.ioException("TYPE_GOAWAY length < 8: %s", new Object[] {
                    Integer.valueOf(i)
                });
            }
            if (j != 0)
            {
                throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
            }
            byte0 = source.readInt();
            j = source.readInt();
            i -= 8;
            ErrorCode errorcode = ErrorCode.fromHttp2(j);
            if (errorcode == null)
            {
                throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", new Object[] {
                    Integer.valueOf(j)
                });
            }
            vw vw1 = vw.Vk;
            if (i > 0)
            {
                vw1 = source._mth02C9(i);
            }
            handler.goAway(byte0, errorcode, vw1);
        }

        private List readHeaderBlock(int i, short word0, byte byte0, int j)
        {
            ContinuationSource continuationsource = continuation;
            continuation.left = i;
            continuationsource.length = i;
            continuation.padding = word0;
            continuation.flags = byte0;
            continuation.streamId = j;
            hpackReader.readHeaders();
            return hpackReader.getAndResetHeaderList();
        }

        private void readHeaders(FrameReader.Handler handler, int i, byte byte0, int j)
        {
            if (j == 0)
            {
                throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
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
                readPriority(handler, j);
                k = i - 5;
            }
            handler.headers(false, flag, j, -1, readHeaderBlock(Http2.lengthWithoutPadding(k, byte0, word0), word0, byte0, j), HeadersMode.HTTP_20_HEADERS);
        }

        private void readPing(FrameReader.Handler handler, int i, byte byte0, int j)
        {
            if (i != 8)
            {
                throw Http2.ioException("TYPE_PING length != 8: %s", new Object[] {
                    Integer.valueOf(i)
                });
            }
            if (j != 0)
            {
                throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
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
            handler.ping(flag, i, j);
        }

        private void readPriority(FrameReader.Handler handler, int i)
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
            handler.priority(i, j & 0x7fffffff, (source.readByte() & 0xff) + 1, flag);
        }

        private void readPriority(FrameReader.Handler handler, int i, byte byte0, int j)
        {
            if (i != 5)
            {
                throw Http2.ioException("TYPE_PRIORITY length: %d != 5", new Object[] {
                    Integer.valueOf(i)
                });
            }
            if (j == 0)
            {
                throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
            } else
            {
                readPriority(handler, j);
                return;
            }
        }

        private void readPushPromise(FrameReader.Handler handler, int i, byte byte0, int j)
        {
            if (j == 0)
            {
                throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            }
            short word0;
            if ((byte0 & 8) != 0)
            {
                word0 = (short)(source.readByte() & 0xff);
            } else
            {
                word0 = 0;
            }
            handler.pushPromise(j, source.readInt() & 0x7fffffff, readHeaderBlock(Http2.lengthWithoutPadding(i - 4, byte0, word0), word0, byte0, j));
        }

        private void readRstStream(FrameReader.Handler handler, int i, byte byte0, int j)
        {
            if (i != 4)
            {
                throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", new Object[] {
                    Integer.valueOf(i)
                });
            }
            if (j == 0)
            {
                throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
            }
            i = source.readInt();
            ErrorCode errorcode = ErrorCode.fromHttp2(i);
            if (errorcode == null)
            {
                throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", new Object[] {
                    Integer.valueOf(i)
                });
            } else
            {
                handler.rstStream(j, errorcode);
                return;
            }
        }

        private void readSettings(FrameReader.Handler handler, int i, byte byte0, int j)
        {
            if (j != 0)
            {
                throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
            }
            if ((byte0 & 1) != 0)
            {
                if (i != 0)
                {
                    throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                } else
                {
                    handler.ackSettings();
                    return;
                }
            }
            if (i % 6 != 0)
            {
                throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", new Object[] {
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
                        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    }
                    break;

                case 3: // '\003'
                    j = 4;
                    break;

                case 4: // '\004'
                    j = 7;
                    if (k < 0)
                    {
                        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
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
                    throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[] {
                        Integer.valueOf(k)
                    });

                case 6: // '\006'
                    j = word0;
                    break;

                default:
                    throw Http2.ioException("PROTOCOL_ERROR invalid settings id: %s", new Object[] {
                        Short.valueOf(word0)
                    });
                }
                settings.set(j, 0, k);
            }

            handler.settings(false, settings);
            if (settings.getHeaderTableSize() >= 0)
            {
                hpackReader.headerTableSizeSetting(settings.getHeaderTableSize());
            }
        }

        private void readWindowUpdate(FrameReader.Handler handler, int i, byte byte0, int j)
        {
            if (i != 4)
            {
                throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", new Object[] {
                    Integer.valueOf(i)
                });
            }
            long l = (long)source.readInt() & 0x7fffffffL;
            if (l == 0L)
            {
                throw Http2.ioException("windowSizeIncrement was 0", new Object[] {
                    Long.valueOf(l)
                });
            } else
            {
                handler.windowUpdate(j, l);
                return;
            }
        }

        public final void close()
        {
            source.close();
        }

        public final boolean nextFrame(FrameReader.Handler handler)
        {
            try
            {
                source._mth02BF(9L);
            }
            // Misplaced declaration of an exception variable
            catch (FrameReader.Handler handler)
            {
                return false;
            }
            int i = Http2.readMedium(source);
            if (i < 0 || i > 16384)
            {
                throw Http2.ioException("FRAME_SIZE_ERROR: %s", new Object[] {
                    Integer.valueOf(i)
                });
            }
            byte byte0 = source.readByte();
            byte byte1 = source.readByte();
            int j = source.readInt() & 0x7fffffff;
            if (Http2.logger.isLoggable(Level.FINE))
            {
                Http2.logger.fine(FrameLogger.formatHeader(true, j, i, byte0, byte1));
            }
            switch (byte0)
            {
            case 0: // '\0'
                readData(handler, i, byte1, j);
                break;

            case 1: // '\001'
                readHeaders(handler, i, byte1, j);
                break;

            case 2: // '\002'
                readPriority(handler, i, byte1, j);
                break;

            case 3: // '\003'
                readRstStream(handler, i, byte1, j);
                break;

            case 4: // '\004'
                readSettings(handler, i, byte1, j);
                break;

            case 5: // '\005'
                readPushPromise(handler, i, byte1, j);
                break;

            case 6: // '\006'
                readPing(handler, i, byte1, j);
                break;

            case 7: // '\007'
                readGoAway(handler, i, byte1, j);
                break;

            case 8: // '\b'
                readWindowUpdate(handler, i, byte1, j);
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
            vw vw1 = source._mth02C9(Http2.CONNECTION_PREFACE.data.length);
            if (Http2.logger.isLoggable(Level.FINE))
            {
                Http2.logger.fine(String.format("<< CONNECTION %s", new Object[] {
                    vw1._mth0192()
                }));
            }
            if (!Http2.CONNECTION_PREFACE.equals(vw1))
            {
                throw Http2.ioException("Expected a connection header but was %s", new Object[] {
                    vw1._mth0178()
                });
            } else
            {
                return;
            }
        }

        Reader(vv vv1, int i, boolean flag)
        {
            source = vv1;
            client = flag;
            continuation = new ContinuationSource(source);
            hpackReader = new Hpack.Reader(i, continuation);
        }
    }

    static final class Writer
        implements FrameWriter
    {

        private final boolean client;
        private boolean closed;
        private final vr hpackBuffer = new vr();
        private final Hpack.Writer hpackWriter;
        private int maxFrameSize;
        private final vu sink;

        private void writeContinuationFrames(int i, long l)
        {
            while (l > 0L) 
            {
                int j = (int)Math.min(maxFrameSize, l);
                l -= j;
                byte byte0;
                if (l == 0L)
                {
                    byte0 = 4;
                } else
                {
                    byte0 = 0;
                }
                frameHeader(i, j, (byte)9, byte0);
                sink.write(hpackBuffer, j);
            }
        }

        public final void ackSettings(Settings settings1)
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            maxFrameSize = settings1.getMaxFrameSize(maxFrameSize);
            frameHeader(0, 0, (byte)4, (byte)1);
            sink.flush();
            this;
            JVM INSTR monitorexit ;
            return;
            settings1;
            throw settings1;
        }

        public final void close()
        {
            this;
            JVM INSTR monitorenter ;
            closed = true;
            sink.close();
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
            if (closed)
            {
                throw new IOException("closed");
            }
            if (client)
            {
                break MISSING_BLOCK_LABEL_29;
            }
            this;
            JVM INSTR monitorexit ;
            return;
            if (Http2.logger.isLoggable(Level.FINE))
            {
                Http2.logger.fine(String.format(">> CONNECTION %s", new Object[] {
                    Http2.CONNECTION_PREFACE._mth0192()
                }));
            }
            sink._mth02C8(Http2.CONNECTION_PREFACE.toByteArray());
            sink.flush();
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public final void data(boolean flag, int i, vr vr1, int j)
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_37;
_L1:
            byte byte0;
            dataFrame(i, byte0, vr1, j);
            this;
            JVM INSTR monitorexit ;
            return;
            vr1;
            throw vr1;
            byte0 = 0;
            if (flag)
            {
                byte0 = 1;
            }
              goto _L1
        }

        final void dataFrame(int i, byte byte0, vr vr1, int j)
        {
            frameHeader(i, j, (byte)0, byte0);
            if (j > 0)
            {
                sink.write(vr1, j);
            }
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

        final void frameHeader(int i, int j, byte byte0, byte byte1)
        {
            if (Http2.logger.isLoggable(Level.FINE))
            {
                Http2.logger.fine(FrameLogger.formatHeader(false, i, j, byte0, byte1));
            }
            if (j > maxFrameSize)
            {
                throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", new Object[] {
                    Integer.valueOf(maxFrameSize), Integer.valueOf(j)
                });
            }
            if ((0x80000000 & i) != 0)
            {
                throw Http2.illegalArgument("reserved bit set: %s", new Object[] {
                    Integer.valueOf(i)
                });
            } else
            {
                Http2.writeMedium(sink, j);
                sink._mth04C0(byte0 & 0xff);
                sink._mth04C0(byte1 & 0xff);
                sink._mth0456(0x7fffffff & i);
                return;
            }
        }

        public final void goAway(int i, ErrorCode errorcode, byte abyte0[])
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            if (errorcode.httpCode == -1)
            {
                throw Http2.illegalArgument("errorCode.httpCode == -1", new Object[0]);
            }
            frameHeader(0, abyte0.length + 8, (byte)7, (byte)0);
            sink._mth0456(i);
            sink._mth0456(errorcode.httpCode);
            if (abyte0.length > 0)
            {
                sink._mth02C8(abyte0);
            }
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
            headers(false, i, list);
            this;
            JVM INSTR monitorexit ;
            return;
            list;
            throw list;
        }

        final void headers(boolean flag, int i, List list)
        {
            if (closed)
            {
                throw new IOException("closed");
            }
            if (hpackBuffer.size != 0L)
            {
                throw new IllegalStateException();
            }
            hpackWriter.writeHeaders(list);
            long l = hpackBuffer.size;
            int j = (int)Math.min(maxFrameSize, l);
            byte byte0;
            if (l == (long)j)
            {
                byte0 = 4;
            } else
            {
                byte0 = 0;
            }
            byte byte1 = byte0;
            if (flag)
            {
                byte1 = (byte)(byte0 | 1);
            }
            frameHeader(i, j, (byte)1, byte1);
            sink.write(hpackBuffer, j);
            if (l > (long)j)
            {
                writeContinuationFrames(i, l - (long)j);
            }
        }

        public final int maxDataLength()
        {
            return maxFrameSize;
        }

        public final void ping(boolean flag, int i, int j)
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_71;
_L1:
            byte byte0;
            frameHeader(0, 8, (byte)6, byte0);
            sink._mth0456(i);
            sink._mth0456(j);
            sink.flush();
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
            if (flag)
            {
                byte0 = 1;
            } else
            {
                byte0 = 0;
            }
              goto _L1
        }

        public final void pushPromise(int i, int j, List list)
        {
            this;
            JVM INSTR monitorenter ;
            int k;
            long l;
            if (closed)
            {
                throw new IOException("closed");
            }
            if (hpackBuffer.size != 0L)
            {
                throw new IllegalStateException();
            }
            hpackWriter.writeHeaders(list);
            l = hpackBuffer.size;
            k = (int)Math.min(maxFrameSize - 4, l);
            byte byte0;
            if (l == (long)k)
            {
                byte0 = 4;
            } else
            {
                byte0 = 0;
            }
            frameHeader(i, k + 4, (byte)5, byte0);
            sink._mth0456(0x7fffffff & j);
            sink.write(hpackBuffer, k);
            if (l <= (long)k)
            {
                break MISSING_BLOCK_LABEL_148;
            }
            writeContinuationFrames(i, l - (long)k);
            this;
            JVM INSTR monitorexit ;
            return;
            list;
            throw list;
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
            frameHeader(i, 4, (byte)3, (byte)0);
            sink._mth0456(errorcode.httpCode);
            sink.flush();
            this;
            JVM INSTR monitorexit ;
            return;
            errorcode;
            throw errorcode;
        }

        public final void settings(Settings settings1)
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            frameHeader(0, settings1.size() * 6, (byte)4, (byte)0);
            int i = 0;
_L9:
            if (i >= 10) goto _L2; else goto _L1
_L1:
            if (!settings1.isSet(i)) goto _L4; else goto _L3
_L3:
            int k = i;
            if (i != 4) goto _L6; else goto _L5
_L5:
            int j = 3;
_L7:
            sink._mth0457(j);
            sink._mth0456(settings1.get(i));
            break; /* Loop/switch isn't completed */
_L2:
            sink.flush();
            this;
            JVM INSTR monitorexit ;
            return;
            settings1;
            throw settings1;
_L6:
            j = k;
            if (k == 7)
            {
                j = 4;
            }
            if (true) goto _L7; else goto _L4
_L4:
            i++;
            if (true) goto _L9; else goto _L8
_L8:
        }

        public final void synReply(boolean flag, int i, List list)
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            headers(flag, i, list);
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
            if (!flag1)
            {
                break MISSING_BLOCK_LABEL_14;
            }
            throw new UnsupportedOperationException();
            if (closed)
            {
                throw new IOException("closed");
            }
            headers(flag, i, list);
            this;
            JVM INSTR monitorexit ;
            return;
            list;
            throw list;
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
            throw Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[] {
                Long.valueOf(l)
            });
_L3:
            frameHeader(i, 4, (byte)8, (byte)0);
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
            hpackWriter = new Hpack.Writer(hpackBuffer);
            maxFrameSize = 16384;
        }
    }


    private static final vw CONNECTION_PREFACE = vw._mth02C0("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    static final byte FLAG_ACK = 1;
    static final byte FLAG_COMPRESSED = 32;
    static final byte FLAG_END_HEADERS = 4;
    static final byte FLAG_END_PUSH_PROMISE = 4;
    static final byte FLAG_END_STREAM = 1;
    static final byte FLAG_NONE = 0;
    static final byte FLAG_PADDED = 8;
    static final byte FLAG_PRIORITY = 32;
    static final int INITIAL_MAX_FRAME_SIZE = 16384;
    static final byte TYPE_CONTINUATION = 9;
    static final byte TYPE_DATA = 0;
    static final byte TYPE_GOAWAY = 7;
    static final byte TYPE_HEADERS = 1;
    static final byte TYPE_PING = 6;
    static final byte TYPE_PRIORITY = 2;
    static final byte TYPE_PUSH_PROMISE = 5;
    static final byte TYPE_RST_STREAM = 3;
    static final byte TYPE_SETTINGS = 4;
    static final byte TYPE_WINDOW_UPDATE = 8;
    private static final Logger logger = Logger.getLogger(com/squareup/okhttp/internal/spdy/Http2$FrameLogger.getName());

    public Http2()
    {
    }

    private static transient IllegalArgumentException illegalArgument(String s, Object aobj[])
    {
        throw new IllegalArgumentException(String.format(s, aobj));
    }

    private static transient IOException ioException(String s, Object aobj[])
    {
        throw new IOException(String.format(s, aobj));
    }

    private static int lengthWithoutPadding(int i, byte byte0, short word0)
    {
        int j = i;
        if ((byte0 & 8) != 0)
        {
            j = i - 1;
        }
        if (word0 > j)
        {
            throw ioException("PROTOCOL_ERROR padding %s > remaining length %s", new Object[] {
                Short.valueOf(word0), Integer.valueOf(j)
            });
        } else
        {
            return (short)(j - word0);
        }
    }

    private static int readMedium(vv vv1)
    {
        return (vv1.readByte() & 0xff) << 16 | (vv1.readByte() & 0xff) << 8 | vv1.readByte() & 0xff;
    }

    private static void writeMedium(vu vu1, int i)
    {
        vu1._mth04C0(i >>> 16 & 0xff);
        vu1._mth04C0(i >>> 8 & 0xff);
        vu1._mth04C0(i & 0xff);
    }

    public final Protocol getProtocol()
    {
        return Protocol.HTTP_2;
    }

    public final FrameReader newReader(vv vv1, boolean flag)
    {
        return new Reader(vv1, 4096, flag);
    }

    public final FrameWriter newWriter(vu vu1, boolean flag)
    {
        return new Writer(vu1, flag);
    }








}
