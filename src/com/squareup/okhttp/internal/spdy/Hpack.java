// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import o.vr;
import o.vv;
import o.vw;
import o.wc;
import o.wn;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Header, Huffman

final class Hpack
{
    static final class Reader
    {

        Header dynamicTable[];
        int dynamicTableByteCount;
        int headerCount;
        private final List headerList = new ArrayList();
        private int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final vv source;

        private void adjustDynamicTableByteCount()
        {
            if (maxDynamicTableByteCount < dynamicTableByteCount)
            {
                if (maxDynamicTableByteCount == 0)
                {
                    clearDynamicTable();
                    return;
                }
                evictToRecoverBytes(dynamicTableByteCount - maxDynamicTableByteCount);
            }
        }

        private void clearDynamicTable()
        {
            headerList.clear();
            Arrays.fill(dynamicTable, null);
            nextHeaderIndex = dynamicTable.length - 1;
            headerCount = 0;
            dynamicTableByteCount = 0;
        }

        private int dynamicTableIndex(int i)
        {
            return nextHeaderIndex + 1 + i;
        }

        private int evictToRecoverBytes(int i)
        {
            int j = 0;
            boolean flag = false;
            if (i > 0)
            {
                j = dynamicTable.length - 1;
                int k = i;
                i = ((flag) ? 1 : 0);
                for (; j >= nextHeaderIndex && k > 0; j--)
                {
                    k -= dynamicTable[j].hpackSize;
                    dynamicTableByteCount = dynamicTableByteCount - dynamicTable[j].hpackSize;
                    headerCount = headerCount - 1;
                    i++;
                }

                System.arraycopy(dynamicTable, nextHeaderIndex + 1, dynamicTable, nextHeaderIndex + 1 + i, headerCount);
                nextHeaderIndex = nextHeaderIndex + i;
                j = i;
            }
            return j;
        }

        private vw getName(int i)
        {
            if (isStaticHeader(i))
            {
                return Hpack.STATIC_HEADER_TABLE[i].name;
            } else
            {
                return dynamicTable[dynamicTableIndex(i - Hpack.STATIC_HEADER_TABLE.length)].name;
            }
        }

        private void insertIntoDynamicTable(int i, Header header)
        {
            headerList.add(header);
            int k = header.hpackSize;
            int j = k;
            if (i != -1)
            {
                j = k - dynamicTable[dynamicTableIndex(i)].hpackSize;
            }
            if (j > maxDynamicTableByteCount)
            {
                clearDynamicTable();
                return;
            }
            k = evictToRecoverBytes((dynamicTableByteCount + j) - maxDynamicTableByteCount);
            if (i == -1)
            {
                if (headerCount + 1 > dynamicTable.length)
                {
                    Header aheader[] = new Header[dynamicTable.length << 1];
                    System.arraycopy(dynamicTable, 0, aheader, dynamicTable.length, dynamicTable.length);
                    nextHeaderIndex = dynamicTable.length - 1;
                    dynamicTable = aheader;
                }
                i = nextHeaderIndex;
                nextHeaderIndex = i - 1;
                dynamicTable[i] = header;
                headerCount = headerCount + 1;
            } else
            {
                int l = dynamicTableIndex(i);
                dynamicTable[i + (l + k)] = header;
            }
            dynamicTableByteCount = dynamicTableByteCount + j;
        }

        private boolean isStaticHeader(int i)
        {
            return i >= 0 && i <= Hpack.STATIC_HEADER_TABLE.length - 1;
        }

        private int readByte()
        {
            return source.readByte() & 0xff;
        }

        private void readIndexedHeader(int i)
        {
            if (isStaticHeader(i))
            {
                Header header = Hpack.STATIC_HEADER_TABLE[i];
                headerList.add(header);
                return;
            }
            int j = dynamicTableIndex(i - Hpack.STATIC_HEADER_TABLE.length);
            if (j < 0 || j > dynamicTable.length - 1)
            {
                throw new IOException((new StringBuilder("Header index too large ")).append(i + 1).toString());
            } else
            {
                headerList.add(dynamicTable[j]);
                return;
            }
        }

        private void readLiteralHeaderWithIncrementalIndexingIndexedName(int i)
        {
            insertIntoDynamicTable(-1, new Header(getName(i), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingNewName()
        {
            insertIntoDynamicTable(-1, new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingIndexedName(int i)
        {
            vw vw1 = getName(i);
            vw vw2 = readByteString();
            headerList.add(new Header(vw1, vw2));
        }

        private void readLiteralHeaderWithoutIndexingNewName()
        {
            vw vw1 = Hpack.checkLowercase(readByteString());
            vw vw2 = readByteString();
            headerList.add(new Header(vw1, vw2));
        }

        public final List getAndResetHeaderList()
        {
            ArrayList arraylist = new ArrayList(headerList);
            headerList.clear();
            return arraylist;
        }

        final void headerTableSizeSetting(int i)
        {
            headerTableSizeSetting = i;
            maxDynamicTableByteCount = i;
            adjustDynamicTableByteCount();
        }

        final int maxDynamicTableByteCount()
        {
            return maxDynamicTableByteCount;
        }

        final vw readByteString()
        {
            int i = readByte();
            boolean flag;
            if ((i & 0x80) == 128)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            i = readInt(i, 127);
            if (flag)
            {
                return vw._mth02C9(Huffman.get().decode(source._mth02CD(i)));
            } else
            {
                return source._mth02C9(i);
            }
        }

        final void readHeaders()
        {
            while (!source.FF46()) 
            {
                int i = source.readByte() & 0xff;
                if (i == 128)
                {
                    throw new IOException("index == 0");
                }
                if ((i & 0x80) == 128)
                {
                    readIndexedHeader(readInt(i, 127) - 1);
                } else
                if (i == 64)
                {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else
                if ((i & 0x40) == 64)
                {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(i, 63) - 1);
                } else
                if ((i & 0x20) == 32)
                {
                    maxDynamicTableByteCount = readInt(i, 31);
                    if (maxDynamicTableByteCount < 0 || maxDynamicTableByteCount > headerTableSizeSetting)
                    {
                        throw new IOException((new StringBuilder("Invalid dynamic table size update ")).append(maxDynamicTableByteCount).toString());
                    }
                    adjustDynamicTableByteCount();
                } else
                if (i == 16 || i == 0)
                {
                    readLiteralHeaderWithoutIndexingNewName();
                } else
                {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(i, 15) - 1);
                }
            }
        }

        final int readInt(int i, int j)
        {
            i &= j;
            if (i < j)
            {
                return i;
            }
            i = 0;
            do
            {
                int k = readByte();
                if ((k & 0x80) != 0)
                {
                    j += (k & 0x7f) << i;
                    i += 7;
                } else
                {
                    return j + (k << i);
                }
            } while (true);
        }

        Reader(int i, wn wn)
        {
            dynamicTable = new Header[8];
            nextHeaderIndex = dynamicTable.length - 1;
            headerCount = 0;
            dynamicTableByteCount = 0;
            headerTableSizeSetting = i;
            maxDynamicTableByteCount = i;
            source = wc._mth02CB(wn);
        }
    }

    static final class Writer
    {

        private final vr out;

        final void writeByteString(vw vw1)
        {
            writeInt(vw1.data.length, 127, 0);
            vr vr1 = out;
            if (vw1 == null)
            {
                throw new IllegalArgumentException("byteString == null");
            } else
            {
                vw1._mth02CA(vr1);
                return;
            }
        }

        final void writeHeaders(List list)
        {
            int i = 0;
            for (int j = list.size(); i < j; i++)
            {
                vw vw1 = ((Header)list.get(i)).name._mth01AD();
                Integer integer = (Integer)Hpack.NAME_TO_FIRST_INDEX.get(vw1);
                if (integer != null)
                {
                    writeInt(integer.intValue() + 1, 15, 0);
                    writeByteString(((Header)list.get(i)).value);
                } else
                {
                    out.FEE7(0);
                    writeByteString(vw1);
                    writeByteString(((Header)list.get(i)).value);
                }
            }

        }

        final void writeInt(int i, int j, int k)
        {
            if (i < j)
            {
                out.FEE7(k | i);
                return;
            }
            out.FEE7(k | j);
            for (i -= j; i >= 128; i >>>= 7)
            {
                out.FEE7(i & 0x7f | 0x80);
            }

            out.FEE7(i);
        }

        Writer(vr vr1)
        {
            out = vr1;
        }
    }


    private static final Map NAME_TO_FIRST_INDEX = nameToFirstIndex();
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final Header STATIC_HEADER_TABLE[];

    private Hpack()
    {
    }

    private static vw checkLowercase(vw vw1)
    {
        int i = 0;
        for (int j = vw1.data.length; i < j; i++)
        {
            byte byte0 = vw1.data[i];
            if (byte0 >= 65 && byte0 <= 90)
            {
                throw new IOException((new StringBuilder("PROTOCOL_ERROR response malformed: mixed case name: ")).append(vw1._mth0178()).toString());
            }
        }

        return vw1;
    }

    private static Map nameToFirstIndex()
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
        for (int i = 0; i < STATIC_HEADER_TABLE.length; i++)
        {
            if (!linkedhashmap.containsKey(STATIC_HEADER_TABLE[i].name))
            {
                linkedhashmap.put(STATIC_HEADER_TABLE[i].name, Integer.valueOf(i));
            }
        }

        return Collections.unmodifiableMap(linkedhashmap);
    }

    static 
    {
        STATIC_HEADER_TABLE = (new Header[] {
            new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, "GET"), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, "/"), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, "http"), new Header(Header.TARGET_SCHEME, "https"), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), 
            new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), 
            new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), 
            new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), 
            new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), 
            new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), 
            new Header("www-authenticate", "")
        });
    }



}
