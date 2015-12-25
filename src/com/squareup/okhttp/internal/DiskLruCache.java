// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import com.squareup.okhttp.internal.io.FileSystem;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import o.vu;
import o.vv;
import o.wc;
import o.wm;
import o.wn;

// Referenced classes of package com.squareup.okhttp.internal:
//            Util, Platform

public final class DiskLruCache
    implements Closeable
{
    public final class Editor
    {

        private boolean committed;
        private final Entry entry;
        private boolean hasErrors;
        final DiskLruCache this$0;
        private final boolean written[];

        public final void abort()
        {
            DiskLruCache disklrucache = DiskLruCache.this;
            disklrucache;
            JVM INSTR monitorenter ;
            completeEdit(this, false);
            disklrucache;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public final void abortUnlessCommitted()
        {
            DiskLruCache disklrucache = DiskLruCache.this;
            disklrucache;
            JVM INSTR monitorenter ;
            boolean flag = committed;
            Exception exception;
            if (!flag)
            {
                try
                {
                    completeEdit(this, false);
                }
                catch (IOException ioexception) { }
                finally
                {
                    disklrucache;
                }
            }
            disklrucache;
            JVM INSTR monitorexit ;
            return;
            throw exception;
        }

        public final void commit()
        {
            DiskLruCache disklrucache = DiskLruCache.this;
            disklrucache;
            JVM INSTR monitorenter ;
            if (hasErrors)
            {
                completeEdit(this, false);
                removeEntry(entry);
                break MISSING_BLOCK_LABEL_47;
            }
            completeEdit(this, true);
            committed = true;
            disklrucache;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public final wm newSink(int i)
        {
            DiskLruCache disklrucache = DiskLruCache.this;
            disklrucache;
            JVM INSTR monitorenter ;
            Object obj;
            if (entry.currentEditor != this)
            {
                throw new IllegalStateException();
            }
            if (!entry.readable)
            {
                written[i] = true;
            }
            obj = entry.dirtyFiles[i];
            obj = fileSystem.sink(((File) (obj)));
              goto _L1
_L3:
            obj = DiskLruCache.NULL_SINK;
            disklrucache;
            JVM INSTR monitorexit ;
            return ((wm) (obj));
_L1:
            class _cls1 extends FaultHidingSink
            {

                final Editor this$1;

                protected void onException(IOException ioexception)
                {
                    ioexception = _fld0;
                    ioexception;
                    JVM INSTR monitorenter ;
                    hasErrors = true;
                    ioexception;
                    JVM INSTR monitorexit ;
                    return;
                    Exception exception;
                    exception;
                    throw exception;
                }

                _cls1(wm wm)
                {
                    this$1 = Editor.this;
                    super(wm);
                }
            }

            obj = new _cls1(((wm) (obj)));
            disklrucache;
            JVM INSTR monitorexit ;
            return ((wm) (obj));
            Object obj1;
            obj1;
            throw obj1;
            obj1;
            if (true) goto _L3; else goto _L2
_L2:
        }

        public final wn newSource(int i)
        {
            DiskLruCache disklrucache = DiskLruCache.this;
            disklrucache;
            JVM INSTR monitorenter ;
            boolean flag;
            if (entry.currentEditor != this)
            {
                throw new IllegalStateException();
            }
            flag = entry.readable;
            Object obj;
            if (!flag)
            {
                return null;
            }
            wn wn;
            try
            {
                wn = fileSystem.source(entry.cleanFiles[i]);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return null;
            }
            finally
            {
                disklrucache;
            }
            disklrucache;
            JVM INSTR monitorexit ;
            return wn;
            throw obj;
        }




/*
        static boolean access$1902(Editor editor, boolean flag)
        {
            editor.hasErrors = flag;
            return flag;
        }

*/

        private Editor(Entry entry1)
        {
            this$0 = DiskLruCache.this;
            super();
            entry = entry1;
            if (entry1.readable)
            {
                disklrucache = null;
            } else
            {
                disklrucache = new boolean[valueCount];
            }
            written = DiskLruCache.this;
        }

        Editor(Entry entry1, _cls1 _pcls1)
        {
            this(entry1);
        }
    }

    final class Entry
    {

        private final File cleanFiles[];
        private Editor currentEditor;
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
            if (as.length != valueCount)
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

        final Snapshot snapshot()
        {
            if (!Thread.holdsLock(DiskLruCache.this))
            {
                throw new AssertionError();
            }
            wn awn[] = new wn[valueCount];
            long al[] = (long[])lengths.clone();
            int i = 0;
            do
            {
                Snapshot snapshot1;
                try
                {
                    if (i >= valueCount)
                    {
                        break;
                    }
                    awn[i] = fileSystem.source(cleanFiles[i]);
                }
                // Misplaced declaration of an exception variable
                catch (FileNotFoundException filenotfoundexception)
                {
                    for (i = 0; i < valueCount && awn[i] != null; i++)
                    {
                        Util.closeQuietly(awn[i]);
                    }

                    return null;
                }
                i++;
            } while (true);
            snapshot1 = new Snapshot(key, sequenceNumber, awn, al, null);
            FileNotFoundException filenotfoundexception;
            return snapshot1;
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
        static long access$1602(Entry entry, long l)
        {
            entry.sequenceNumber = l;
            return l;
        }

*/



/*
        static boolean access$802(Entry entry, boolean flag)
        {
            entry.readable = flag;
            return flag;
        }

*/



/*
        static Editor access$902(Entry entry, Editor editor)
        {
            entry.currentEditor = editor;
            return editor;
        }

*/

        private Entry(String s)
        {
            this$0 = DiskLruCache.this;
            super();
            key = s;
            lengths = new long[valueCount];
            cleanFiles = new File[valueCount];
            dirtyFiles = new File[valueCount];
            s = (new StringBuilder(s)).append('.');
            int j = s.length();
            for (int i = 0; i < valueCount; i++)
            {
                s.append(i);
                cleanFiles[i] = new File(directory, s.toString());
                s.append(".tmp");
                dirtyFiles[i] = new File(directory, s.toString());
                s.setLength(j);
            }

        }

        Entry(String s, _cls1 _pcls1)
        {
            this(s);
        }
    }

    public final class Snapshot
        implements Closeable
    {

        private final String key;
        private final long lengths[];
        private final long sequenceNumber;
        private final wn sources[];
        final DiskLruCache this$0;

        public final void close()
        {
            wn awn[] = sources;
            int j = awn.length;
            for (int i = 0; i < j; i++)
            {
                Util.closeQuietly(awn[i]);
            }

        }

        public final Editor edit()
        {
            return DiskLruCache.this.edit(key, sequenceNumber);
        }

        public final long getLength(int i)
        {
            return lengths[i];
        }

        public final wn getSource(int i)
        {
            return sources[i];
        }

        public final String key()
        {
            return key;
        }


        private Snapshot(String s, long l, wn awn[], long al[])
        {
            this$0 = DiskLruCache.this;
            super();
            key = s;
            sequenceNumber = l;
            sources = awn;
            lengths = al;
        }

        Snapshot(String s, long l, wn awn[], long al[], _cls1 _pcls1)
        {
            this(s, l, awn, al);
        }
    }


    static final boolean $assertionsDisabled;
    static final long ANY_SEQUENCE_NUMBER = -1L;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final wm NULL_SINK = new _cls4();
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Runnable cleanupRunnable = new _cls1();
    private boolean closed;
    private final File directory;
    private final Executor executor;
    private final FileSystem fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private vu journalWriter;
    private final LinkedHashMap lruEntries = new LinkedHashMap(0, 0.75F, true);
    private long maxSize;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;

    DiskLruCache(FileSystem filesystem, File file, int i, int j, long l, Executor executor1)
    {
        size = 0L;
        nextSequenceNumber = 0L;
        fileSystem = filesystem;
        directory = file;
        appVersion = i;
        journalFile = new File(file, "journal");
        journalFileTmp = new File(file, "journal.tmp");
        journalFileBackup = new File(file, "journal.bkp");
        valueCount = j;
        maxSize = l;
        executor = executor1;
    }

    private void checkNotClosed()
    {
        this;
        JVM INSTR monitorenter ;
        if (isClosed())
        {
            throw new IllegalStateException("cache is closed");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void completeEdit(Editor editor, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        Entry entry;
        entry = editor.entry;
        if (entry.currentEditor != editor)
        {
            throw new IllegalStateException();
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_454;
        }
        if (entry.readable)
        {
            break MISSING_BLOCK_LABEL_454;
        }
        int i = 0;
_L3:
        if (i >= valueCount)
        {
            break MISSING_BLOCK_LABEL_454;
        }
        if (!editor.written[i])
        {
            editor.abort();
            throw new IllegalStateException((new StringBuilder("Newly created entry didn't create value for index ")).append(i).toString());
        }
        if (fileSystem.exists(entry.dirtyFiles[i])) goto _L2; else goto _L1
_L1:
        editor.abort();
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        File file;
        long l;
        long l1;
        for (; i >= valueCount; i++)
        {
            break MISSING_BLOCK_LABEL_227;
        }

        editor = entry.dirtyFiles[i];
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_214;
        }
        if (fileSystem.exists(editor))
        {
            file = entry.cleanFiles[i];
            fileSystem.rename(editor, file);
            l = entry.lengths[i];
            l1 = fileSystem.size(file);
            entry.lengths[i] = l1;
            size = (size - l) + l1;
        }
        break MISSING_BLOCK_LABEL_460;
        fileSystem.delete(editor);
        break MISSING_BLOCK_LABEL_460;
        redundantOpCount = redundantOpCount + 1;
        entry.currentEditor = null;
        if (!(entry.readable | flag))
        {
            break MISSING_BLOCK_LABEL_339;
        }
        entry.readable = true;
        journalWriter._mth02B8("CLEAN")._mth04C0(32);
        journalWriter._mth02B8(entry.key);
        entry.writeLengths(journalWriter);
        journalWriter._mth04C0(10);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_396;
        }
        l = nextSequenceNumber;
        nextSequenceNumber = 1L + l;
        entry.sequenceNumber = l;
        break MISSING_BLOCK_LABEL_396;
        lruEntries.remove(entry.key);
        journalWriter._mth02B8("REMOVE")._mth04C0(32);
        journalWriter._mth02B8(entry.key);
        journalWriter._mth04C0(10);
        journalWriter.flush();
        if (size > maxSize || journalRebuildRequired())
        {
            executor.execute(cleanupRunnable);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        editor;
        throw editor;
_L2:
        i++;
          goto _L3
        i = 0;
          goto _L4
    }

    public static DiskLruCache create(FileSystem filesystem, File file, int i, int j, long l)
    {
        if (l <= 0L)
        {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (j <= 0)
        {
            throw new IllegalArgumentException("valueCount <= 0");
        } else
        {
            return new DiskLruCache(filesystem, file, i, j, l, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
        }
    }

    private Editor edit(String s, long l)
    {
        this;
        JVM INSTR monitorenter ;
        Entry entry1;
        initialize();
        checkNotClosed();
        validateKey(s);
        entry1 = (Entry)lruEntries.get(s);
        if (l == -1L)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        if (entry1 == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        if (entry1.sequenceNumber == l)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        this;
        JVM INSTR monitorexit ;
        return null;
        if (entry1 == null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        if (entry1.currentEditor == null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        this;
        JVM INSTR monitorexit ;
        return null;
        journalWriter._mth02B8("DIRTY")._mth04C0(32)._mth02B8(s)._mth04C0(10);
        journalWriter.flush();
        if (!hasJournalErrors)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        this;
        JVM INSTR monitorexit ;
        return null;
        Entry entry;
        entry = entry1;
        if (entry1 != null)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        entry = new Entry(s, null);
        lruEntries.put(s, entry);
        s = new Editor(entry, null);
        entry.currentEditor = s;
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    private boolean journalRebuildRequired()
    {
        return redundantOpCount >= 2000 && redundantOpCount >= lruEntries.size();
    }

    private vu newJournalWriter()
    {
        return wc._mth02CA(new _cls2(fileSystem.appendingSink(journalFile)));
    }

    private void processJournal()
    {
        fileSystem.delete(journalFileTmp);
        for (Iterator iterator = lruEntries.values().iterator(); iterator.hasNext();)
        {
            Entry entry = (Entry)iterator.next();
            if (entry.currentEditor == null)
            {
                int i = 0;
                while (i < valueCount) 
                {
                    size = size + entry.lengths[i];
                    i++;
                }
            } else
            {
                entry.currentEditor = null;
                for (int j = 0; j < valueCount; j++)
                {
                    fileSystem.delete(entry.cleanFiles[j]);
                    fileSystem.delete(entry.dirtyFiles[j]);
                }

                iterator.remove();
            }
        }

    }

    private void readJournal()
    {
        o.wi wi = wc._mth02CB(fileSystem.source(journalFile));
        String s = wi.FF90();
        String s1 = wi.FF90();
        String s2 = wi.FF90();
        String s3 = wi.FF90();
        String s4 = wi.FF90();
        if (!"libcore.io.DiskLruCache".equals(s) || !"1".equals(s1) || !Integer.toString(appVersion).equals(s2) || !Integer.toString(valueCount).equals(s3) || !"".equals(s4))
        {
            throw new IOException((new StringBuilder("unexpected journal header: [")).append(s).append(", ").append(s1).append(", ").append(s3).append(", ").append(s4).append("]").toString());
        }
        int i = 0;
_L2:
        readJournalLine(wi.FF90());
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        redundantOpCount = i - lruEntries.size();
        if (!wi.FF46())
        {
            rebuildJournal();
            break MISSING_BLOCK_LABEL_237;
        }
        journalWriter = newJournalWriter();
        Util.closeQuietly(wi);
        return;
        Object obj;
        obj;
        Util.closeQuietly(wi);
        throw obj;
        obj;
        if (true) goto _L1; else goto _L3
_L3:
    }

    private void readJournalLine(String s)
    {
        int i = s.indexOf(' ');
        if (i == -1)
        {
            throw new IOException((new StringBuilder("unexpected journal line: ")).append(s).toString());
        }
        int j = i + 1;
        int k = s.indexOf(' ', j);
        String s1;
        if (k == -1)
        {
            String s2 = s.substring(j);
            s1 = s2;
            if (i == 6)
            {
                s1 = s2;
                if (s.startsWith("REMOVE"))
                {
                    lruEntries.remove(s2);
                    return;
                }
            }
        } else
        {
            s1 = s.substring(j, k);
        }
        Entry entry1 = (Entry)lruEntries.get(s1);
        Entry entry = entry1;
        if (entry1 == null)
        {
            entry = new Entry(s1, null);
            lruEntries.put(s1, entry);
        }
        if (k != -1 && i == 5 && s.startsWith("CLEAN"))
        {
            s = s.substring(k + 1).split(" ");
            entry.readable = true;
            entry.currentEditor = null;
            entry.setLengths(s);
            return;
        }
        if (k == -1 && i == 5 && s.startsWith("DIRTY"))
        {
            entry.currentEditor = new Editor(entry, null);
            return;
        }
        if (k != -1 || i != 4 || !s.startsWith("READ"))
        {
            throw new IOException((new StringBuilder("unexpected journal line: ")).append(s).toString());
        } else
        {
            return;
        }
    }

    private void rebuildJournal()
    {
        this;
        JVM INSTR monitorenter ;
        o.wg wg;
        if (journalWriter != null)
        {
            journalWriter.close();
        }
        wg = wc._mth02CA(fileSystem.sink(journalFileTmp));
        Iterator iterator;
        wg._mth02B8("libcore.io.DiskLruCache")._mth04C0(10);
        wg._mth02B8("1")._mth04C0(10);
        wg.FF9E(appVersion)._mth04C0(10);
        wg.FF9E(valueCount)._mth04C0(10);
        wg._mth04C0(10);
        iterator = lruEntries.values().iterator();
_L2:
        Entry entry;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_236;
            }
            entry = (Entry)iterator.next();
            if (entry.currentEditor == null)
            {
                break MISSING_BLOCK_LABEL_192;
            }
            wg._mth02B8("DIRTY")._mth04C0(32);
            wg._mth02B8(entry.key);
            wg._mth04C0(10);
        } while (true);
        wg._mth02B8("CLEAN")._mth04C0(32);
        wg._mth02B8(entry.key);
        entry.writeLengths(wg);
        wg._mth04C0(10);
        if (true) goto _L2; else goto _L1
_L1:
        wg.close();
        break MISSING_BLOCK_LABEL_254;
        Exception exception1;
        exception1;
        wg.close();
        throw exception1;
        if (fileSystem.exists(journalFile))
        {
            fileSystem.rename(journalFile, journalFileBackup);
        }
        fileSystem.rename(journalFileTmp, journalFile);
        fileSystem.delete(journalFileBackup);
        journalWriter = newJournalWriter();
        hasJournalErrors = false;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private boolean removeEntry(Entry entry)
    {
        if (entry.currentEditor != null)
        {
            entry.currentEditor.hasErrors = true;
        }
        for (int i = 0; i < valueCount; i++)
        {
            fileSystem.delete(entry.cleanFiles[i]);
            size = size - entry.lengths[i];
            entry.lengths[i] = 0L;
        }

        redundantOpCount = redundantOpCount + 1;
        journalWriter._mth02B8("REMOVE")._mth04C0(32)._mth02B8(entry.key)._mth04C0(10);
        lruEntries.remove(entry.key);
        if (journalRebuildRequired())
        {
            executor.execute(cleanupRunnable);
        }
        return true;
    }

    private void trimToSize()
    {
        while (size > maxSize) 
        {
            removeEntry((Entry)lruEntries.values().iterator().next());
        }
    }

    private void validateKey(String s)
    {
        if (!LEGAL_KEY_PATTERN.matcher(s).matches())
        {
            throw new IllegalArgumentException((new StringBuilder("keys must match regex [a-z0-9_-]{1,120}: \"")).append(s).append("\"").toString());
        } else
        {
            return;
        }
    }

    public final void close()
    {
        this;
        JVM INSTR monitorenter ;
        if (initialized && !closed)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        closed = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Entry aentry[];
        int j;
        aentry = (Entry[])lruEntries.values().toArray(new Entry[lruEntries.size()]);
        j = aentry.length;
        int i = 0;
_L2:
        Entry entry;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        entry = aentry[i];
        if (entry.currentEditor != null)
        {
            entry.currentEditor.abort();
        }
        break MISSING_BLOCK_LABEL_114;
        trimToSize();
        journalWriter.close();
        journalWriter = null;
        closed = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void delete()
    {
        close();
        fileSystem.deleteContents(directory);
    }

    public final Editor edit(String s)
    {
        return edit(s, -1L);
    }

    public final void evictAll()
    {
        this;
        JVM INSTR monitorenter ;
        Entry aentry[];
        int j;
        initialize();
        aentry = (Entry[])lruEntries.values().toArray(new Entry[lruEntries.size()]);
        j = aentry.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        removeEntry(aentry[i]);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void flush()
    {
        this;
        JVM INSTR monitorenter ;
        if (initialized)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        checkNotClosed();
        trimToSize();
        journalWriter.flush();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final Snapshot get(String s)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        initialize();
        checkNotClosed();
        validateKey(s);
        obj = (Entry)lruEntries.get(s);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        if (((Entry) (obj)).readable)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        this;
        JVM INSTR monitorexit ;
        return null;
        obj = ((Entry) (obj)).snapshot();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        this;
        JVM INSTR monitorexit ;
        return null;
        redundantOpCount = redundantOpCount + 1;
        journalWriter._mth02B8("READ")._mth04C0(32)._mth02B8(s)._mth04C0(10);
        if (journalRebuildRequired())
        {
            executor.execute(cleanupRunnable);
        }
        this;
        JVM INSTR monitorexit ;
        return ((Snapshot) (obj));
        s;
        throw s;
    }

    public final File getDirectory()
    {
        return directory;
    }

    public final long getMaxSize()
    {
        this;
        JVM INSTR monitorenter ;
        long l = maxSize;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    final void initialize()
    {
        if (!$assertionsDisabled && !Thread.holdsLock(this))
        {
            throw new AssertionError();
        }
        if (initialized)
        {
            return;
        }
        if (fileSystem.exists(journalFileBackup))
        {
            if (fileSystem.exists(journalFile))
            {
                fileSystem.delete(journalFileBackup);
            } else
            {
                fileSystem.rename(journalFileBackup, journalFile);
            }
        }
        if (fileSystem.exists(journalFile))
        {
            try
            {
                readJournal();
                processJournal();
                initialized = true;
                return;
            }
            catch (IOException ioexception)
            {
                Platform.get().logW((new StringBuilder("DiskLruCache ")).append(directory).append(" is corrupt: ").append(ioexception.getMessage()).append(", removing").toString());
            }
            delete();
            closed = false;
        }
        rebuildJournal();
        initialized = true;
    }

    public final boolean isClosed()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = closed;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean remove(String s)
    {
        this;
        JVM INSTR monitorenter ;
        initialize();
        checkNotClosed();
        validateKey(s);
        s = (Entry)lruEntries.get(s);
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        boolean flag = removeEntry(s);
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }

    public final void setMaxSize(long l)
    {
        this;
        JVM INSTR monitorenter ;
        maxSize = l;
        if (initialized)
        {
            executor.execute(cleanupRunnable);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final long size()
    {
        this;
        JVM INSTR monitorenter ;
        long l;
        initialize();
        l = size;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public final Iterator snapshots()
    {
        this;
        JVM INSTR monitorenter ;
        _cls3 _lcls3;
        initialize();
        _lcls3 = new _cls3();
        this;
        JVM INSTR monitorexit ;
        return _lcls3;
        Exception exception;
        exception;
        throw exception;
    }

    static 
    {
        boolean flag;
        if (!com/squareup/okhttp/internal/DiskLruCache.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }















/*
    static int access$502(DiskLruCache disklrucache, int i)
    {
        disklrucache.redundantOpCount = i;
        return i;
    }

*/


/*
    static boolean access$602(DiskLruCache disklrucache, boolean flag)
    {
        disklrucache.hasJournalErrors = flag;
        return flag;
    }

*/

    private class _cls1
        implements Runnable
    {

        final DiskLruCache this$0;

        public void run()
        {
            DiskLruCache disklrucache = DiskLruCache.this;
            disklrucache;
            JVM INSTR monitorenter ;
            Object obj;
            boolean flag;
            boolean flag1;
            if (!initialized)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = closed;
            if (!(flag | flag1))
            {
                break MISSING_BLOCK_LABEL_41;
            }
            disklrucache;
            JVM INSTR monitorexit ;
            return;
            trimToSize();
            if (journalRebuildRequired())
            {
                rebuildJournal();
                redundantOpCount = 0;
            }
            break MISSING_BLOCK_LABEL_87;
            obj;
            throw new RuntimeException(((Throwable) (obj)));
            disklrucache;
            JVM INSTR monitorexit ;
            return;
            obj;
            throw obj;
        }

        _cls1()
        {
            this$0 = DiskLruCache.this;
            super();
        }
    }


    private class _cls2 extends FaultHidingSink
    {

        static final boolean $assertionsDisabled;
        final DiskLruCache this$0;

        protected void onException(IOException ioexception)
        {
            if (!$assertionsDisabled && !Thread.holdsLock(DiskLruCache.this))
            {
                throw new AssertionError();
            } else
            {
                hasJournalErrors = true;
                return;
            }
        }

        static 
        {
            boolean flag;
            if (!com/squareup/okhttp/internal/DiskLruCache.desiredAssertionStatus())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            $assertionsDisabled = flag;
        }

        _cls2(wm wm)
        {
            this$0 = DiskLruCache.this;
            super(wm);
        }
    }


    private class _cls3
        implements Iterator
    {

        final Iterator _flddelegate;
        Snapshot nextSnapshot;
        Snapshot removeSnapshot;
        final DiskLruCache this$0;

        public boolean hasNext()
        {
            if (nextSnapshot != null)
            {
                return true;
            }
            DiskLruCache disklrucache = DiskLruCache.this;
            disklrucache;
            JVM INSTR monitorenter ;
            boolean flag = closed;
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_32;
            }
            disklrucache;
            JVM INSTR monitorexit ;
            return false;
            Snapshot snapshot;
            do
            {
                if (!_flddelegate.hasNext())
                {
                    break MISSING_BLOCK_LABEL_73;
                }
                snapshot = ((Entry)_flddelegate.next()).snapshot();
            } while (snapshot == null);
            nextSnapshot = snapshot;
            disklrucache;
            JVM INSTR monitorexit ;
            return true;
            disklrucache;
            JVM INSTR monitorexit ;
              goto _L1
            Exception exception;
            exception;
            throw exception;
_L1:
            return false;
        }

        public Snapshot next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            } else
            {
                removeSnapshot = nextSnapshot;
                nextSnapshot = null;
                return removeSnapshot;
            }
        }

        public volatile Object next()
        {
            return next();
        }

        public void remove()
        {
            Object obj;
            if (removeSnapshot == null)
            {
                throw new IllegalStateException("remove() before next()");
            }
            try
            {
                DiskLruCache.this.remove(removeSnapshot.key);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                removeSnapshot = null;
                return;
            }
            finally
            {
                removeSnapshot = null;
            }
            removeSnapshot = null;
            return;
            throw obj;
        }

        _cls3()
        {
            this$0 = DiskLruCache.this;
            super();
            _flddelegate = (new ArrayList(lruEntries.values())).iterator();
        }
    }


    private class _cls4
        implements wm
    {

        public final void close()
        {
        }

        public final void flush()
        {
        }

        public final wo timeout()
        {
            return wo.NONE;
        }

        public final void write(vr vr1, long l)
        {
            vr1._mth02D1(l);
        }

        _cls4()
        {
        }
    }

}
