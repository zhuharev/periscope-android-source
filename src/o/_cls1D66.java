// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package o:
//            _cls1E8B, _cls1E8D, _cls3035

public final class _cls1D66
    implements Closeable
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}


    private final int appVersion;
    final File directory;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    BufferedWriter kj;
    private ThreadPoolExecutor kk;
    private final _cls1E8B kl = new _cls1E8B(this);
    final LinkedHashMap lruEntries = new LinkedHashMap(0, 0.75F, true);
    private long maxSize;
    private long nextSequenceNumber;
    int redundantOpCount;
    private long size;
    final int valueCount;

    private _cls1D66(File file, int i, int j, long l)
    {
        size = 0L;
        nextSequenceNumber = 0L;
        kk = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        directory = file;
        appVersion = i;
        journalFile = new File(file, "journal");
        journalFileTmp = new File(file, "journal.tmp");
        journalFileBackup = new File(file, "journal.bkp");
        valueCount = j;
        maxSize = l;
    }

    private void processJournal()
    {
        File file = journalFileTmp;
        if (file.exists() && !file.delete())
        {
            throw new IOException();
        }
        for (Iterator iterator = lruEntries.values().iterator(); iterator.hasNext();)
        {
            _cls02CA _lcls02ca = (_cls02CA)iterator.next();
            if (_lcls02ca.ko == null)
            {
                int i = 0;
                while (i < valueCount) 
                {
                    size = size + _lcls02ca.lengths[i];
                    i++;
                }
            } else
            {
                _lcls02ca.ko = null;
                for (int j = 0; j < valueCount; j++)
                {
                    File file1 = _lcls02ca.cleanFiles[j];
                    if (file1.exists() && !file1.delete())
                    {
                        throw new IOException();
                    }
                    file1 = _lcls02ca.dirtyFiles[j];
                    if (file1.exists() && !file1.delete())
                    {
                        throw new IOException();
                    }
                }

                iterator.remove();
            }
        }

    }

    private void readJournal()
    {
        _cls1E8D _lcls1e8d = new _cls1E8D(new FileInputStream(journalFile), _cls3035.US_ASCII);
        String s = _lcls1e8d.readLine();
        String s2 = _lcls1e8d.readLine();
        String s3 = _lcls1e8d.readLine();
        String s4 = _lcls1e8d.readLine();
        String s6 = _lcls1e8d.readLine();
        if (!"libcore.io.DiskLruCache".equals(s) || !"1".equals(s2) || !Integer.toString(appVersion).equals(s3) || !Integer.toString(valueCount).equals(s4) || !"".equals(s6))
        {
            throw new IOException((new StringBuilder("unexpected journal header: [")).append(s).append(", ").append(s2).append(", ").append(s4).append(", ").append(s6).append("]").toString());
        }
        int i = 0;
_L2:
        String s5;
        int j;
        s5 = _lcls1e8d.readLine();
        j = s5.indexOf(' ');
        if (j == -1)
        {
            String s1;
            String as[];
            Exception exception;
            Object obj;
            _cls02CA _lcls02ca;
            int k;
            int l;
            try
            {
                throw new IOException((new StringBuilder("unexpected journal line: ")).append(s5).toString());
            }
            catch (EOFException eofexception) { }
            finally
            {
                _cls3035._mth02CA(_lcls1e8d);
            }
            break; /* Loop/switch isn't completed */
        }
        k = j + 1;
        l = s5.indexOf(' ', k);
        if (l != -1)
        {
            break MISSING_BLOCK_LABEL_284;
        }
        obj = s5.substring(k);
        s1 = ((String) (obj));
        if (j != 6)
        {
            break MISSING_BLOCK_LABEL_294;
        }
        s1 = ((String) (obj));
        if (s5.startsWith("REMOVE"))
        {
            lruEntries.remove(obj);
            break MISSING_BLOCK_LABEL_476;
        }
        break MISSING_BLOCK_LABEL_294;
        s1 = s5.substring(k, l);
        _lcls02ca = (_cls02CA)lruEntries.get(s1);
        obj = _lcls02ca;
        if (_lcls02ca != null)
        {
            break MISSING_BLOCK_LABEL_333;
        }
        obj = new _cls02CA(s1, (byte)0);
        lruEntries.put(s1, obj);
        if (l == -1 || j != 5)
        {
            break MISSING_BLOCK_LABEL_388;
        }
        if (s5.startsWith("CLEAN"))
        {
            as = s5.substring(l + 1).split(" ");
            obj.readable = true;
            obj.ko = null;
            ((_cls02CA) (obj)).setLengths(as);
            break MISSING_BLOCK_LABEL_476;
        }
        if (l != -1 || j != 5)
        {
            break MISSING_BLOCK_LABEL_428;
        }
        if (s5.startsWith("DIRTY"))
        {
            obj.ko = new if(((_cls02CA) (obj)), (byte)0);
            break MISSING_BLOCK_LABEL_476;
        }
        if (l != -1 || j != 4)
        {
            break MISSING_BLOCK_LABEL_451;
        }
        if (s5.startsWith("READ"))
        {
            break MISSING_BLOCK_LABEL_476;
        }
        throw new IOException((new StringBuilder("unexpected journal line: ")).append(s5).toString());
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        redundantOpCount = i - lruEntries.size();
        boolean flag;
        if (_lcls1e8d.end == -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_526;
        }
        rebuildJournal();
        break MISSING_BLOCK_LABEL_559;
        kj = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(journalFile, true), _cls3035.US_ASCII));
        _cls3035._mth02CA(_lcls1e8d);
        return;
        throw exception;
    }

    public static _cls1D66 _mth02CA(File file, int i, int j, long l)
    {
        Object obj;
        if (l <= 0L)
        {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        obj = new File(file, "journal.bkp");
        if (((File) (obj)).exists())
        {
            File file1 = new File(file, "journal");
            if (file1.exists())
            {
                ((File) (obj)).delete();
            } else
            if (!((File) (obj)).renameTo(file1))
            {
                throw new IOException();
            }
        }
        obj = new _cls1D66(file, 1, 1, l);
        if (!((_cls1D66) (obj)).journalFile.exists())
        {
            break MISSING_BLOCK_LABEL_179;
        }
        ((_cls1D66) (obj)).readJournal();
        ((_cls1D66) (obj)).processJournal();
        return ((_cls1D66) (obj));
        IOException ioexception;
        ioexception;
        System.out.println((new StringBuilder("DiskLruCache ")).append(file).append(" is corrupt: ").append(ioexception.getMessage()).append(", removing").toString());
        ((_cls1D66) (obj)).close();
        _cls3035.deleteContents(((_cls1D66) (obj)).directory);
        file.mkdirs();
        file = new _cls1D66(file, 1, 1, l);
        file.rebuildJournal();
        return file;
    }

    public final void close()
    {
        this;
        JVM INSTR monitorenter ;
        if (kj != null)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Iterator iterator = (new ArrayList(lruEntries.values())).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (_cls02CA)iterator.next();
            if (((_cls02CA) (obj)).ko != null)
            {
                obj = ((_cls02CA) (obj)).ko;
                ((if) (obj)).km._mth02CA(((if) (obj)), false);
            }
        } while (true);
        trimToSize();
        kj.close();
        kj = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void rebuildJournal()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (kj != null)
        {
            kj.close();
        }
        obj = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(journalFileTmp), _cls3035.US_ASCII));
        Object obj1;
        ((Writer) (obj)).write("libcore.io.DiskLruCache");
        ((Writer) (obj)).write("\n");
        ((Writer) (obj)).write("1");
        ((Writer) (obj)).write("\n");
        ((Writer) (obj)).write(Integer.toString(appVersion));
        ((Writer) (obj)).write("\n");
        ((Writer) (obj)).write(Integer.toString(valueCount));
        ((Writer) (obj)).write("\n");
        ((Writer) (obj)).write("\n");
        obj1 = lruEntries.values().iterator();
_L2:
        _cls02CA _lcls02ca;
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break MISSING_BLOCK_LABEL_224;
            }
            _lcls02ca = (_cls02CA)((Iterator) (obj1)).next();
            if (_lcls02ca.ko == null)
            {
                break MISSING_BLOCK_LABEL_185;
            }
            ((Writer) (obj)).write((new StringBuilder("DIRTY ")).append(_lcls02ca.key).append('\n').toString());
        } while (true);
        ((Writer) (obj)).write((new StringBuilder("CLEAN ")).append(_lcls02ca.key).append(_lcls02ca._mth01D0()).append('\n').toString());
        if (true) goto _L2; else goto _L1
_L1:
        ((Writer) (obj)).close();
        break MISSING_BLOCK_LABEL_238;
        Exception exception1;
        exception1;
        ((Writer) (obj)).close();
        throw exception1;
        if (!journalFile.exists())
        {
            break MISSING_BLOCK_LABEL_300;
        }
        obj = journalFile;
        exception1 = journalFileBackup;
        if (false)
        {
            break MISSING_BLOCK_LABEL_284;
        }
        if (exception1.exists() && !exception1.delete())
        {
            throw new IOException();
        }
        if (!((File) (obj)).renameTo(exception1))
        {
            throw new IOException();
        }
        if (!journalFileTmp.renameTo(journalFile))
        {
            throw new IOException();
        }
        journalFileBackup.delete();
        kj = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(journalFile, true), _cls3035.US_ASCII));
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean remove(String s)
    {
        this;
        JVM INSTR monitorenter ;
        _cls02CA _lcls02ca;
        if (kj == null)
        {
            throw new IllegalStateException("cache is closed");
        }
        _lcls02ca = (_cls02CA)lruEntries.get(s);
        if (_lcls02ca == null) goto _L2; else goto _L1
_L1:
        if (_lcls02ca.ko == null) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return false;
_L5:
        int i;
        if (i >= valueCount)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        File file = _lcls02ca.cleanFiles[i];
        if (file.exists() && !file.delete())
        {
            throw new IOException((new StringBuilder("failed to delete ")).append(file).toString());
        }
        size = size - _lcls02ca.lengths[i];
        _lcls02ca.lengths[i] = 0L;
        i++;
        continue; /* Loop/switch isn't completed */
        redundantOpCount = redundantOpCount + 1;
        kj.append("REMOVE");
        kj.append(' ');
        kj.append(s);
        kj.append('\n');
        lruEntries.remove(s);
        if (redundantOpCount >= 2000 && redundantOpCount >= lruEntries.size())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_241;
        }
        kk.submit(kl);
        this;
        JVM INSTR monitorexit ;
        return true;
        s;
        throw s;
_L3:
        i = 0;
        if (true) goto _L5; else goto _L4
_L4:
    }

    void trimToSize()
    {
        while (size > maxSize) 
        {
            remove((String)((java.util.Map.Entry)lruEntries.entrySet().iterator().next()).getKey());
        }
    }

    public final _cls02CB _mth02C8(String s)
    {
        this;
        JVM INSTR monitorenter ;
        _cls02CA _lcls02ca;
        if (kj == null)
        {
            throw new IllegalStateException("cache is closed");
        }
        _lcls02ca = (_cls02CA)lruEntries.get(s);
        if (_lcls02ca != null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        this;
        JVM INSTR monitorexit ;
        return null;
        if (_lcls02ca.readable)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        this;
        JVM INSTR monitorexit ;
        return null;
        File afile[];
        int j;
        afile = _lcls02ca.cleanFiles;
        j = afile.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        if (afile[i].exists())
        {
            break MISSING_BLOCK_LABEL_213;
        }
        this;
        JVM INSTR monitorexit ;
        return null;
        redundantOpCount = redundantOpCount + 1;
        kj.append("READ");
        kj.append(' ');
        kj.append(s);
        kj.append('\n');
        if (redundantOpCount >= 2000 && redundantOpCount >= lruEntries.size())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        kk.submit(kl);
        s = new _cls02CB(s, _lcls02ca.sequenceNumber, _lcls02ca.cleanFiles, _lcls02ca.lengths, (byte)0);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public if _mth02CA(String s, long l)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (kj == null)
        {
            throw new IllegalStateException("cache is closed");
        }
        obj = (_cls02CA)lruEntries.get(s);
        if (-1L == -1L)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        if (((_cls02CA) (obj)).sequenceNumber == -1L)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        this;
        JVM INSTR monitorexit ;
        return null;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        _cls02CA _lcls02ca;
        _lcls02ca = new _cls02CA(s, (byte)0);
        lruEntries.put(s, _lcls02ca);
        break MISSING_BLOCK_LABEL_111;
        _lcls02ca = ((_cls02CA) (obj));
        if (((_cls02CA) (obj)).ko == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        this;
        JVM INSTR monitorexit ;
        return null;
        obj = new if(_lcls02ca, (byte)0);
        _lcls02ca.ko = ((if) (obj));
        kj.append("DIRTY");
        kj.append(' ');
        kj.append(s);
        kj.append('\n');
        kj.flush();
        this;
        JVM INSTR monitorexit ;
        return ((if) (obj));
        s;
        throw s;
    }

    public void _mth02CA(if if1, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        _cls02CA _lcls02ca;
        _lcls02ca = if1.kn;
        if (_lcls02ca.ko != if1)
        {
            throw new IllegalStateException();
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        if (_lcls02ca.readable) goto _L2; else goto _L3
_L3:
        int i = 0;
_L19:
        if (i >= valueCount) goto _L2; else goto _L4
_L4:
        if (!if1.written[i])
        {
            if1.km._mth02CA(if1, false);
            throw new IllegalStateException((new StringBuilder("Newly created entry didn't create value for index ")).append(i).toString());
        }
        if (_lcls02ca.dirtyFiles[i].exists()) goto _L6; else goto _L5
_L5:
        if1.km._mth02CA(if1, false);
        this;
        JVM INSTR monitorexit ;
        return;
_L20:
        if (i >= valueCount) goto _L8; else goto _L7
_L7:
        if1 = _lcls02ca.dirtyFiles[i];
        if (!flag) goto _L10; else goto _L9
_L9:
        if (if1.exists())
        {
            File file = _lcls02ca.cleanFiles[i];
            if1.renameTo(file);
            long l = _lcls02ca.lengths[i];
            long l2 = file.length();
            _lcls02ca.lengths[i] = l2;
            size = (size - l) + l2;
        }
          goto _L11
_L10:
        if (if1.exists() && !if1.delete())
        {
            throw new IOException();
        }
          goto _L11
_L8:
        redundantOpCount = redundantOpCount + 1;
        _lcls02ca.ko = null;
        if (!(_lcls02ca.readable | flag)) goto _L13; else goto _L12
_L12:
        _lcls02ca.readable = true;
        kj.append("CLEAN");
        kj.append(' ');
        kj.append(_lcls02ca.key);
        kj.append(_lcls02ca._mth01D0());
        kj.append('\n');
        if (!flag) goto _L15; else goto _L14
_L14:
        long l1 = nextSequenceNumber;
        nextSequenceNumber = 1L + l1;
        _lcls02ca.sequenceNumber = l1;
          goto _L15
_L13:
        lruEntries.remove(_lcls02ca.key);
        kj.append("REMOVE");
        kj.append(' ');
        kj.append(_lcls02ca.key);
        kj.append('\n');
_L15:
        kj.flush();
        if (size > maxSize) goto _L17; else goto _L16
_L16:
        if (redundantOpCount >= 2000 && redundantOpCount >= lruEntries.size())
        {
            i = 1;
        } else
        {
            i = 0;
        }
          goto _L18
_L17:
        kk.submit(kl);
_L21:
        this;
        JVM INSTR monitorexit ;
        return;
        if1;
        throw if1;
_L6:
        i++;
          goto _L19
_L2:
        i = 0;
          goto _L20
_L11:
        i++;
          goto _L20
_L18:
        if (i == 0) goto _L21; else goto _L17
    }
}
