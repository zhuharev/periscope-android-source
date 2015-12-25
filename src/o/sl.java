// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package o:
//            sm

public class sl
    implements Closeable
{
    static final class if
    {

        static final if Sw = new if(0, 0);
        final int length;
        final int position;

        public final String toString()
        {
            return (new StringBuilder()).append(getClass().getSimpleName()).append("[position = ").append(position).append(", length = ").append(length).append("]").toString();
        }


        if(int i, int j)
        {
            position = i;
            length = j;
        }
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}


    private static final Logger So = Logger.getLogger(o/sl.getName());
    private final RandomAccessFile Sp;
    private int Sq;
    private if Sr;
    private if Ss;
    private final byte buffer[];
    private int elementCount;

    public sl(File file)
    {
        RandomAccessFile randomaccessfile;
        File file1;
        buffer = new byte[16];
        if (file.exists())
        {
            break MISSING_BLOCK_LABEL_142;
        }
        file1 = new File((new StringBuilder()).append(file.getPath()).append(".tmp").toString());
        randomaccessfile = new RandomAccessFile(file1, "rwd");
        randomaccessfile.setLength(4096L);
        randomaccessfile.seek(0L);
        byte abyte0[] = new byte[16];
        _mth02CA(abyte0, new int[] {
            4096, 0, 0, 0
        });
        randomaccessfile.write(abyte0);
        randomaccessfile.close();
        break MISSING_BLOCK_LABEL_124;
        file;
        randomaccessfile.close();
        throw file;
        if (!file1.renameTo(file))
        {
            throw new IOException("Rename failed!");
        }
        Sp = new RandomAccessFile(file, "rwd");
        Sp.seek(0L);
        Sp.readFully(buffer);
        Sq = _mth02CE(buffer, 0);
        if ((long)Sq > Sp.length())
        {
            throw new IOException((new StringBuilder("File is truncated. Expected length: ")).append(Sq).append(", Actual length: ").append(Sp.length()).toString());
        } else
        {
            elementCount = _mth02CE(buffer, 4);
            int i = _mth02CE(buffer, 8);
            int j = _mth02CE(buffer, 12);
            Sr = FE77(i);
            Ss = FE77(j);
            return;
        }
    }

    private void clear()
    {
        this;
        JVM INSTR monitorenter ;
        _mth02BC(4096, 0, 0, 0);
        elementCount = 0;
        Sr = if.Sw;
        Ss = if.Sw;
        if (Sq > 4096)
        {
            Sp.setLength(4096L);
            Sp.getChannel().force(true);
        }
        Sq = 4096;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void _mth02BC(int i, int j, int k, int l)
    {
        _mth02CA(buffer, new int[] {
            i, j, k, l
        });
        Sp.seek(0L);
        Sp.write(buffer);
    }

    static int _mth02CA(sl sl1, int i)
    {
        if (i < sl1.Sq)
        {
            return i;
        } else
        {
            return (i + 16) - sl1.Sq;
        }
    }

    static RandomAccessFile _mth02CA(sl sl1)
    {
        return sl1.Sp;
    }

    static Object _mth02CA(Object obj, String s)
    {
        if (obj == null)
        {
            throw new NullPointerException(s);
        } else
        {
            return obj;
        }
    }

    private void _mth02CA(int i, byte abyte0[], int j, int k)
    {
        if (i >= Sq)
        {
            i = (i + 16) - Sq;
        }
        if (i + k <= Sq)
        {
            Sp.seek(i);
            Sp.write(abyte0, j, k);
            return;
        } else
        {
            int l = Sq - i;
            Sp.seek(i);
            Sp.write(abyte0, j, l);
            Sp.seek(16L);
            Sp.write(abyte0, j + l, k - l);
            return;
        }
    }

    static void _mth02CA(sl sl1, int i, byte abyte0[], int j, int k)
    {
        sl1._mth02CB(i, abyte0, j, k);
    }

    private static transient void _mth02CA(byte abyte0[], int ai[])
    {
        int j = 0;
        for (int i = 0; i < 4; i++)
        {
            _mth02CE(abyte0, j, ai[i]);
            j += 4;
        }

    }

    private void _mth02CB(int i, byte abyte0[], int j, int k)
    {
        if (i >= Sq)
        {
            i = (i + 16) - Sq;
        }
        if (i + k <= Sq)
        {
            Sp.seek(i);
            Sp.readFully(abyte0, j, k);
            return;
        } else
        {
            int l = Sq - i;
            Sp.seek(i);
            Sp.readFully(abyte0, j, l);
            Sp.seek(16L);
            Sp.readFully(abyte0, j + l, k - l);
            return;
        }
    }

    private static int _mth02CE(byte abyte0[], int i)
    {
        return ((abyte0[i] & 0xff) << 24) + ((abyte0[i + 1] & 0xff) << 16) + ((abyte0[i + 2] & 0xff) << 8) + (abyte0[i + 3] & 0xff);
    }

    private static void _mth02CE(byte abyte0[], int i, int j)
    {
        abyte0[i] = j >> 24;
        abyte0[i + 1] = (byte)(j >> 16);
        abyte0[i + 2] = (byte)(j >> 8);
        abyte0[i + 3] = (byte)j;
    }

    private if FE77(int i)
    {
        if (i == 0)
        {
            return if.Sw;
        } else
        {
            Sp.seek(i);
            return new if(i, Sp.readInt());
        }
    }

    private void FE7B(int i)
    {
        int i1 = i + 4;
        i = Sq - _mth148D();
        int j = i;
        if (i >= i1)
        {
            return;
        }
        i = Sq;
        int k;
        int l;
        do
        {
            l = j + i;
            k = i << 1;
            j = l;
            i = k;
        } while (l < i1);
        Sp.setLength(k);
        Sp.getChannel().force(true);
        i = Ss.position + 4 + Ss.length;
        if (i >= Sq)
        {
            i = (i + 16) - Sq;
        }
        if (i < Sr.position)
        {
            FileChannel filechannel = Sp.getChannel();
            filechannel.position(Sq);
            i -= 4;
            if (filechannel.transferTo(16L, i, filechannel) != (long)i)
            {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        if (Ss.position < Sr.position)
        {
            i = (Sq + Ss.position) - 16;
            _mth02BC(k, elementCount, Sr.position, i);
            Ss = new if(i, Ss.length);
        } else
        {
            _mth02BC(k, elementCount, Sr.position, Ss.position);
        }
        Sq = k;
    }

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        Sp.close();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean isEmpty()
    {
        this;
        JVM INSTR monitorenter ;
        int i = elementCount;
        if (i == 0)
        {
            return true;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        Exception exception;
        exception;
        throw exception;
    }

    public final void remove()
    {
        this;
        JVM INSTR monitorenter ;
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        if (elementCount != 1)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        clear();
        this;
        JVM INSTR monitorexit ;
        return;
        int i;
        i = Sr.position + 4 + Sr.length;
        if (i < Sq)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        i = (i + 16) - Sq;
        _mth02CB(i, buffer, 0, 4);
        int j = _mth02CE(buffer, 0);
        _mth02BC(Sq, elementCount - 1, i, Ss.position);
        elementCount = elementCount - 1;
        Sr = new if(i, j);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(getClass().getSimpleName()).append('[');
        stringbuilder.append("fileLength=").append(Sq);
        stringbuilder.append(", size=").append(elementCount);
        stringbuilder.append(", first=").append(Sr);
        stringbuilder.append(", last=").append(Ss);
        stringbuilder.append(", element lengths=[");
        try
        {
            _mth02CA(new sm(this, stringbuilder));
        }
        catch (IOException ioexception)
        {
            So.log(Level.WARNING, "read error", ioexception);
        }
        stringbuilder.append("]]");
        return stringbuilder.toString();
    }

    public final void _mth02CA(_cls02CB _pcls02cb)
    {
        this;
        JVM INSTR monitorenter ;
        int i = Sr.position;
        int j = 0;
_L2:
        if (j >= elementCount)
        {
            break; /* Loop/switch isn't completed */
        }
        if if1 = FE77(i);
        _pcls02cb.read(new _cls02CA(if1, (byte)0), if1.length);
        i = if1.position + 4 + if1.length;
        if (i < Sq)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        int k = Sq;
        i = (i + 16) - k;
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        return;
        _pcls02cb;
        throw _pcls02cb;
    }

    public final void _mth02CF(byte abyte0[], int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        if (abyte0 != null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        throw new NullPointerException("buffer");
        if ((j | 0) < 0)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        if (j <= abyte0.length)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        throw new IndexOutOfBoundsException();
        boolean flag;
        FE7B(j);
        flag = isEmpty();
        if (flag)
        {
            i = 16;
            break MISSING_BLOCK_LABEL_98;
        }
        i = Ss.position + 4 + Ss.length;
        if (i < Sq)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        i = (i + 16) - Sq;
        if if1;
        if1 = new if(i, j);
        _mth02CE(buffer, 0, j);
        _mth02CA(if1.position, buffer, 0, 4);
        _mth02CA(if1.position + 4, abyte0, 0, j);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        i = if1.position;
        break MISSING_BLOCK_LABEL_169;
        i = Sr.position;
        _mth02BC(Sq, elementCount + 1, i, if1.position);
        Ss = if1;
        elementCount = elementCount + 1;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        Sr = Ss;
        this;
        JVM INSTR monitorexit ;
        return;
        abyte0;
        throw abyte0;
    }

    public final int _mth148D()
    {
        if (elementCount == 0)
        {
            return 16;
        }
        if (Ss.position >= Sr.position)
        {
            return (Ss.position - Sr.position) + 4 + Ss.length + 16;
        } else
        {
            return (Ss.position + 4 + Ss.length + Sq) - Sr.position;
        }
    }

}
