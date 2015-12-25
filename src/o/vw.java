// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.EOFException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

// Referenced classes of package o:
//            wq, vq, vr

public class vw
    implements Serializable
{

    private static char Vj[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f'
    };
    public static final vw Vk = new vw((byte[])(new byte[0]).clone());
    private transient String Vl;
    public final byte data[];
    private transient int hashCode;

    vw(byte abyte0[])
    {
        data = abyte0;
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        int j = objectinputstream.readInt();
        if (objectinputstream == null)
        {
            throw new IllegalArgumentException("in == null");
        }
        if (j < 0)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(j).toString());
        }
        byte abyte0[] = new byte[j];
        int k;
        for (int i = 0; i < j; i += k)
        {
            k = objectinputstream.read(abyte0, i, j - i);
            if (k == -1)
            {
                throw new EOFException();
            }
        }

        objectinputstream = new vw(abyte0);
        try
        {
            Field field = o/vw.getDeclaredField("data");
            field.setAccessible(true);
            field.set(this, ((vw) (objectinputstream)).data);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectInputStream objectinputstream)
        {
            throw new AssertionError();
        }
        // Misplaced declaration of an exception variable
        catch (ObjectInputStream objectinputstream)
        {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.writeInt(data.length);
        objectoutputstream.write(data);
    }

    public static vw _mth02C0(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("s == null");
        } else
        {
            vw vw1 = new vw(s.getBytes(wq.UTF_8));
            vw1.Vl = s;
            return vw1;
        }
    }

    private vw _mth02C1(String s)
    {
        try
        {
            s = MessageDigest.getInstance(s).digest(data);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new AssertionError(s);
        }
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        throw new IllegalArgumentException("data == null");
        s = new vw((byte[])s.clone());
        return s;
    }

    public static transient vw _mth02C9(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("data == null");
        } else
        {
            return new vw((byte[])abyte0.clone());
        }
    }

    public static vw _mth02E2(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("base64 == null");
        }
        s = vq._mth1508(s);
        if (s != null)
        {
            return new vw(s);
        } else
        {
            return null;
        }
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if ((obj instanceof vw) && ((vw)obj).data.length == data.length)
        {
            obj = (vw)obj;
            byte abyte0[] = data;
            int i = data.length;
            boolean flag;
            if (((vw) (obj)).data.length - i <= 0 && abyte0.length - i <= 0 && wq._mth02CA(((vw) (obj)).data, 0, abyte0, 0, i))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        int i = hashCode;
        if (i != 0)
        {
            return i;
        } else
        {
            int j = Arrays.hashCode(data);
            hashCode = j;
            return j;
        }
    }

    public final byte[] toByteArray()
    {
        return (byte[])data.clone();
    }

    public String toString()
    {
        if (data.length == 0)
        {
            return "ByteString[size=0]";
        }
        if (data.length <= 16)
        {
            return String.format("ByteString[size=%s data=%s]", new Object[] {
                Integer.valueOf(data.length), _mth0192()
            });
        } else
        {
            return String.format("ByteString[size=%s md5=%s]", new Object[] {
                Integer.valueOf(data.length), _mth02C1("MD5")._mth0192()
            });
        }
    }

    public final String _mth0178()
    {
        String s = Vl;
        if (s != null)
        {
            return s;
        } else
        {
            String s1 = new String(data, wq.UTF_8);
            Vl = s1;
            return s1;
        }
    }

    public final String _mth0192()
    {
        char ac[] = new char[data.length << 1];
        int j = 0;
        byte abyte0[] = data;
        int k = abyte0.length;
        for (int i = 0; i < k; i++)
        {
            byte byte0 = abyte0[i];
            int l = j + 1;
            ac[j] = Vj[byte0 >> 4 & 0xf];
            j = l + 1;
            ac[l] = Vj[byte0 & 0xf];
        }

        return new String(ac);
    }

    public final vw _mth01AD()
    {
        for (int i = 0; i < data.length; i++)
        {
            byte byte1 = data[i];
            if (byte1 >= 65 && byte1 <= 90)
            {
                byte abyte0[] = (byte[])data.clone();
                int j = i + 1;
                abyte0[i] = (byte)(byte1 + 32);
                for (i = j; i < abyte0.length; i++)
                {
                    byte byte0 = abyte0[i];
                    if (byte0 >= 65 && byte0 <= 90)
                    {
                        abyte0[i] = (byte)(byte0 + 32);
                    }
                }

                return new vw(abyte0);
            }
        }

        return this;
    }

    public final void _mth02CA(vr vr1)
    {
        vr1._mth02BC(data, 0, data.length);
    }

}
