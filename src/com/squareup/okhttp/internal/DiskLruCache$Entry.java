// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import com.squareup.okhttp.internal.io.FileSystem;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import o.vu;
import o.wn;

// Referenced classes of package com.squareup.okhttp.internal:
//            DiskLruCache, Util

final class <init>
{

    private final File cleanFiles[];
    private  currentEditor;
    private final File dirtyFiles[];
    private final String key;
    private final long lengths[];
    private boolean readable;
    private long sequenceNumber;
    final DiskLruCache this$0;

    private IOException invalidLengths(String as[])
    {
        throw new IOException((new StringBuilder("unexpected journal line: ")).append(Arrays.toString(as)).toString());
    }

    private void setLengths(String as[])
    {
        NumberFormatException numberformatexception;
        if (as.length != DiskLruCache.access$2300(DiskLruCache.this))
        {
            throw invalidLengths(as);
        }
        int i = 0;
        do
        {
            try
            {
                if (i >= as.length)
                {
                    break;
                }
                lengths[i] = Long.parseLong(as[i]);
            }
            // Misplaced declaration of an exception variable
            catch (NumberFormatException numberformatexception)
            {
                throw invalidLengths(as);
            }
            i++;
        } while (true);
    }

    final ot snapshot()
    {
        if (!Thread.holdsLock(DiskLruCache.this))
        {
            throw new AssertionError();
        }
        wn awn[] = new wn[DiskLruCache.access$2300(DiskLruCache.this)];
        long al[] = (long[])lengths.clone();
        int i = 0;
        do
        {
            ot ot;
            try
            {
                if (i >= DiskLruCache.access$2300(DiskLruCache.this))
                {
                    break;
                }
                awn[i] = DiskLruCache.access$2400(DiskLruCache.this).source(cleanFiles[i]);
            }
            // Misplaced declaration of an exception variable
            catch (FileNotFoundException filenotfoundexception)
            {
                for (i = 0; i < DiskLruCache.access$2300(DiskLruCache.this) && awn[i] != null; i++)
                {
                    Util.closeQuietly(awn[i]);
                }

                return null;
            }
            i++;
        } while (true);
        ot = new ot(DiskLruCache.this, key, sequenceNumber, awn, al, null);
        FileNotFoundException filenotfoundexception;
        return ot;
    }

    final void writeLengths(vu vu1)
    {
        long al[] = lengths;
        int j = al.length;
        for (int i = 0; i < j; i++)
        {
            long l = al[i];
            vu1._mth04C0(32).FF9E(l);
        }

    }








/*
    static long access$1602(ot ot, long l)
    {
        ot.sequenceNumber = l;
        return l;
    }

*/



/*
    static boolean access$802(sequenceNumber sequencenumber, boolean flag)
    {
        sequencenumber.readable = flag;
        return flag;
    }

*/



/*
    static  access$902( ,  1)
    {
        .currentEditor = 1;
        return 1;
    }

*/

    private currentEditor(String s)
    {
        this$0 = DiskLruCache.this;
        super();
        key = s;
        lengths = new long[DiskLruCache.access$2300(DiskLruCache.this)];
        cleanFiles = new File[DiskLruCache.access$2300(DiskLruCache.this)];
        dirtyFiles = new File[DiskLruCache.access$2300(DiskLruCache.this)];
        s = (new StringBuilder(s)).append('.');
        int j = s.length();
        for (int i = 0; i < DiskLruCache.access$2300(DiskLruCache.this); i++)
        {
            s.append(i);
            cleanFiles[i] = new File(DiskLruCache.access$2800(DiskLruCache.this), s.toString());
            s.append(".tmp");
            dirtyFiles[i] = new File(DiskLruCache.access$2800(DiskLruCache.this), s.toString());
            s.setLength(j);
        }

    }

    ._cls2800(String s, ._cls2800 _pcls2800)
    {
        this(s);
    }
}
