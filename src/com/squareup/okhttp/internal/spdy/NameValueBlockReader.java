// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import o.vv;
import o.vw;
import o.wb;
import o.wc;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Header

class NameValueBlockReader
{

    private int compressedLimit;
    private final wb inflaterSource;
    private final vv source;

    public NameValueBlockReader(vv vv1)
    {
        inflaterSource = new wb(new _cls1(vv1), new _cls2());
        source = wc._mth02CB(inflaterSource);
    }

    private void doneReading()
    {
        if (compressedLimit > 0)
        {
            inflaterSource._mth025B();
            if (compressedLimit != 0)
            {
                throw new IOException((new StringBuilder("compressedLimit > 0: ")).append(compressedLimit).toString());
            }
        }
    }

    private vw readByteString()
    {
        int i = source.readInt();
        return source._mth02C9(i);
    }

    public void close()
    {
        source.close();
    }

    public List readNameValueBlock(int i)
    {
        compressedLimit = compressedLimit + i;
        int j = source.readInt();
        if (j < 0)
        {
            throw new IOException((new StringBuilder("numberOfPairs < 0: ")).append(j).toString());
        }
        if (j > 1024)
        {
            throw new IOException((new StringBuilder("numberOfPairs > 1024: ")).append(j).toString());
        }
        ArrayList arraylist = new ArrayList(j);
        for (i = 0; i < j; i++)
        {
            vw vw1 = readByteString()._mth01AD();
            vw vw2 = readByteString();
            if (vw1.data.length == 0)
            {
                throw new IOException("name.size == 0");
            }
            arraylist.add(new Header(vw1, vw2));
        }

        doneReading();
        return arraylist;
    }



/*
    static int access$002(NameValueBlockReader namevalueblockreader, int i)
    {
        namevalueblockreader.compressedLimit = i;
        return i;
    }

*/

    private class _cls1 extends vz
    {

        final NameValueBlockReader this$0;

        public long read(vr vr, long l)
        {
            if (compressedLimit == 0)
            {
                return -1L;
            }
            l = super.read(vr, Math.min(l, compressedLimit));
            if (l == -1L)
            {
                return -1L;
            } else
            {
                compressedLimit = (int)((long)compressedLimit - l);
                return l;
            }
        }

        _cls1(wn wn)
        {
            this$0 = NameValueBlockReader.this;
            super(wn);
        }
    }


    private class _cls2 extends Inflater
    {

        final NameValueBlockReader this$0;

        public int inflate(byte abyte0[], int i, int j)
        {
            int i1 = super.inflate(abyte0, i, j);
            int k = i1;
            int l = k;
            if (i1 == 0)
            {
                l = k;
                if (needsDictionary())
                {
                    setDictionary(Spdy3.DICTIONARY);
                    l = super.inflate(abyte0, i, j);
                }
            }
            return l;
        }

        _cls2()
        {
            this$0 = NameValueBlockReader.this;
            super();
        }
    }

}
