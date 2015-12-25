// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package o:
//            uh

public final class ug
{
    public static final class aux extends BufferedOutputStream
    {

        private final CharsetEncoder TH;

        public final aux FE7E(String s)
        {
            s = TH.encode(CharBuffer.wrap(s));
            super.write(s.array(), 0, s.limit());
            return this;
        }

        public aux(OutputStream outputstream, String s, int i)
        {
            super(outputstream, i);
            TH = Charset.forName(ug.FE78(s)).newEncoder();
        }
    }

    public static final class if
    {

        private static final byte TE[] = {
            65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
            75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
            85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
            101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
            111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
            121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
            56, 57, 43, 47
        };

        public static String encode(String s)
        {
            byte abyte0[] = s.getBytes("US-ASCII");
            s = abyte0;
              goto _L1
_L3:
            s = s.getBytes();
_L1:
            return _mth141D(s, 0, s.length);
            UnsupportedEncodingException unsupportedencodingexception;
            unsupportedencodingexception;
            if (true) goto _L3; else goto _L2
_L2:
        }

        public static byte[] _mth02BB(byte abyte0[], int i, int j)
        {
            if (abyte0 == null)
            {
                throw new NullPointerException("Cannot serialize a null array.");
            }
            if (i < 0)
            {
                throw new IllegalArgumentException((new StringBuilder("Cannot have negative offset: ")).append(i).toString());
            }
            if (j < 0)
            {
                throw new IllegalArgumentException((new StringBuilder("Cannot have length offset: ")).append(j).toString());
            }
            if (i + j > abyte0.length)
            {
                throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", new Object[] {
                    Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(abyte0.length)
                }));
            }
            int l = j / 3;
            int k;
            if (j % 3 > 0)
            {
                k = 4;
            } else
            {
                k = 0;
            }
            byte abyte1[] = new byte[(l << 2) + k];
            l = 0;
            for (k = 0; l < j - 2; k += 4)
            {
                _mth02CA(abyte0, l + i, 3, abyte1, k);
                l += 3;
            }

            int i1 = k;
            if (l < j)
            {
                _mth02CA(abyte0, l + i, j - l, abyte1, k);
                i1 = k + 4;
            }
            if (i1 <= abyte1.length - 1)
            {
                abyte0 = new byte[i1];
                System.arraycopy(abyte1, 0, abyte0, 0, i1);
                return abyte0;
            } else
            {
                return abyte1;
            }
        }

        private static byte[] _mth02CA(byte abyte0[], int i, int j, byte abyte1[], int k)
        {
            byte abyte2[] = TE;
            int l;
            if (j > 0)
            {
                l = (abyte0[i] << 24) >>> 8;
            } else
            {
                l = 0;
            }
            int i1;
            if (j > 1)
            {
                i1 = (abyte0[i + 1] << 24) >>> 16;
            } else
            {
                i1 = 0;
            }
            if (j > 2)
            {
                i = (abyte0[i + 2] << 24) >>> 24;
            } else
            {
                i = 0;
            }
            i = l | i1 | i;
            switch (j)
            {
            default:
                return abyte1;

            case 3: // '\003'
                abyte1[k] = abyte2[i >>> 18];
                abyte1[k + 1] = abyte2[i >>> 12 & 0x3f];
                abyte1[k + 2] = abyte2[i >>> 6 & 0x3f];
                abyte1[k + 3] = abyte2[i & 0x3f];
                return abyte1;

            case 2: // '\002'
                abyte1[k] = abyte2[i >>> 18];
                abyte1[k + 1] = abyte2[i >>> 12 & 0x3f];
                abyte1[k + 2] = abyte2[i >>> 6 & 0x3f];
                abyte1[k + 3] = 61;
                return abyte1;

            case 1: // '\001'
                abyte1[k] = abyte2[i >>> 18];
                abyte1[k + 1] = abyte2[i >>> 12 & 0x3f];
                abyte1[k + 2] = 61;
                abyte1[k + 3] = 61;
                return abyte1;
            }
        }

        private static String _mth141D(byte abyte0[], int i, int j)
        {
            UnsupportedEncodingException unsupportedencodingexception;
            abyte0 = _mth02BB(abyte0, 0, j);
            String s;
            try
            {
                s = new String(abyte0, "US-ASCII");
            }
            // Misplaced declaration of an exception variable
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                return new String(abyte0);
            }
            return s;
        }

    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class _cls02CF {}


    private static _cls02CB Tw;
    private boolean TA;
    private aux Tx;
    private boolean Ty;
    private boolean Tz;
    private int bufferSize;
    public HttpURLConnection connection;
    private final String requestMethod;
    private URL url;

    private ug(CharSequence charsequence, String s)
    {
        connection = null;
        Tz = true;
        TA = false;
        bufferSize = 8192;
        try
        {
            url = new URL(charsequence.toString());
        }
        // Misplaced declaration of an exception variable
        catch (CharSequence charsequence)
        {
            throw new _cls02CE(charsequence);
        }
        requestMethod = s;
    }

    private static String _mth02CA(CharSequence charsequence, Map map)
    {
        Object obj = charsequence.toString();
        if (map == null || map.isEmpty())
        {
            return ((String) (obj));
        }
        charsequence = new StringBuilder(((String) (obj)));
        if (((String) (obj)).indexOf(':') + 2 == ((String) (obj)).lastIndexOf('/'))
        {
            charsequence.append('/');
        }
        int i = ((String) (obj)).indexOf('?');
        int j = charsequence.length() - 1;
        if (i == -1)
        {
            charsequence.append('?');
        } else
        if (i < j && ((String) (obj)).charAt(j) != '&')
        {
            charsequence.append('&');
        }
        map = map.entrySet().iterator();
        obj = (java.util.Map.Entry)map.next();
        charsequence.append(((java.util.Map.Entry) (obj)).getKey().toString());
        charsequence.append('=');
        obj = ((java.util.Map.Entry) (obj)).getValue();
        if (obj != null)
        {
            charsequence.append(obj);
        }
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            charsequence.append('&');
            Object obj1 = (java.util.Map.Entry)map.next();
            charsequence.append(((java.util.Map.Entry) (obj1)).getKey().toString());
            charsequence.append('=');
            obj1 = ((java.util.Map.Entry) (obj1)).getValue();
            if (obj1 != null)
            {
                charsequence.append(obj1);
            }
        } while (true);
        return charsequence.toString();
    }

    public static ug _mth02CA(String s, Map map, boolean flag)
    {
        return new ug(_mth1D59(_mth02CA(((CharSequence) (s)), map)), "GET");
    }

    static int _mth02CB(ug ug1)
    {
        return ug1.bufferSize;
    }

    public static ug _mth02CB(String s, Map map, boolean flag)
    {
        return new ug(_mth1D59(_mth02CA(s, map)), "POST");
    }

    private String _mth02CC(String s, String s1)
    {
        _mth1D42();
        if (connection == null)
        {
            connection = _mth1D08();
        }
        return _mth02CD(connection.getHeaderField(s), s1);
    }

    private static String _mth02CD(String s, String s1)
    {
        if (s == null || s.length() == 0)
        {
            return null;
        }
        int j = s.length();
        int i = s.indexOf(';') + 1;
        int k = i;
        if (i == 0 || k == j)
        {
            return null;
        }
        int j1 = s.indexOf(';', k);
        i = j1;
        int i1 = k;
        if (j1 == -1)
        {
            i = j;
            i1 = k;
        }
        do
        {
            if (i1 >= i)
            {
                break;
            }
            int l = s.indexOf('=', i1);
            if (l != -1 && l < i && s1.equals(s.substring(i1, l).trim()))
            {
                String s2 = s.substring(l + 1, i).trim();
                l = s2.length();
                if (l != 0)
                {
                    if (l > 2 && '"' == s2.charAt(0) && '"' == s2.charAt(l - 1))
                    {
                        return s2.substring(1, l - 1);
                    } else
                    {
                        return s2;
                    }
                }
            }
            i1 = i + 1;
            l = s.indexOf(';', i1);
            i = l;
            if (l == -1)
            {
                i = j;
            }
        } while (true);
        return null;
    }

    private ug _mth02CF(String s, String s1, String s2)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("form-data; name=\"").append(s);
        if (s1 != null)
        {
            stringbuilder.append("\"; filename=\"").append(s1);
        }
        stringbuilder.append('"');
        s = stringbuilder.toString();
        FE74("Content-Disposition").FE74(": ").FE74(s).FE74("\r\n");
        if (s2 != null)
        {
            FE74("Content-Type").FE74(": ").FE74(s2).FE74("\r\n");
        }
        return FE74("\r\n");
    }

    private InputStream _mth1D0F()
    {
        if (code() < 400)
        {
            InputStream inputstream;
            try
            {
                if (connection == null)
                {
                    connection = _mth1D08();
                }
                inputstream = connection.getInputStream();
            }
            catch (IOException ioexception)
            {
                throw new _cls02CE(ioexception);
            }
            return inputstream;
        }
        if (connection == null)
        {
            connection = _mth1D08();
        }
        Object obj = connection.getErrorStream();
        if (obj == null)
        {
            try
            {
                if (connection == null)
                {
                    connection = _mth1D08();
                }
                obj = connection.getInputStream();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new _cls02CE(((IOException) (obj)));
            }
            return ((InputStream) (obj));
        } else
        {
            return ((InputStream) (obj));
        }
    }

    private ug _mth1D23()
    {
        if (Tx == null)
        {
            return this;
        }
        if (Ty)
        {
            Tx.FE7E("\r\n--00content0boundary00--\r\n");
        }
        if (Tz)
        {
            try
            {
                Tx.close();
            }
            catch (IOException ioexception) { }
        } else
        {
            Tx.close();
        }
        Tx = null;
        return this;
    }

    private ug _mth1D42()
    {
        ug ug1;
        try
        {
            ug1 = _mth1D23();
        }
        catch (IOException ioexception)
        {
            throw new _cls02CE(ioexception);
        }
        return ug1;
    }

    private static String _mth1D59(String s)
    {
        URL url1;
        try
        {
            url1 = new URL(s.toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new _cls02CE(s);
        }
        String s1 = url1.getHost();
        int i = url1.getPort();
        s = s1;
        if (i != -1)
        {
            s = (new StringBuilder()).append(s1).append(':').append(Integer.toString(i)).toString();
        }
        try
        {
            s1 = (new URI(url1.getProtocol(), s, url1.getPath(), url1.getQuery(), null)).toASCIIString();
            i = s1.indexOf('?');
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            IOException ioexception = new IOException("Parsing URI failed");
            ioexception.initCause(s);
            throw new _cls02CE(ioexception);
        }
        s = s1;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        s = s1;
        if (i + 1 < s1.length())
        {
            s = (new StringBuilder()).append(s1.substring(0, i + 1)).append(s1.substring(i + 1).replace("+", "%2B")).toString();
        }
        return s;
    }

    public static ug _mth1D5B(String s)
    {
        return new ug(s, "PUT");
    }

    public static ug _mth1D65(String s)
    {
        return new ug(s, "DELETE");
    }

    private ug _mth1E2C()
    {
        if (Tx != null)
        {
            return this;
        }
        if (connection == null)
        {
            connection = _mth1D08();
        }
        connection.setDoOutput(true);
        if (connection == null)
        {
            connection = _mth1D08();
        }
        String s = _mth02CD(connection.getRequestProperty("Content-Type"), "charset");
        if (connection == null)
        {
            connection = _mth1D08();
        }
        Tx = new aux(connection.getOutputStream(), s, bufferSize);
        return this;
    }

    private ug _mth1E2D()
    {
        if (!Ty)
        {
            Ty = true;
            if (connection == null)
            {
                connection = _mth1D08();
            }
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=00content0boundary00");
            _mth1E2C();
            Tx.FE7E("--00content0boundary00\r\n");
            return this;
        } else
        {
            Tx.FE7E("\r\n--00content0boundary00\r\n");
            return this;
        }
    }

    private ug FE74(String s)
    {
        try
        {
            _mth1E2C();
            Tx.FE7E(s.toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new _cls02CE(s);
        }
        return this;
    }

    static String FE78(String s)
    {
        if (s != null && s.length() > 0)
        {
            return s;
        } else
        {
            return "UTF-8";
        }
    }

    public final int code()
    {
        int i;
        try
        {
            _mth1D23();
            if (connection == null)
            {
                connection = _mth1D08();
            }
            i = connection.getResponseCode();
        }
        catch (IOException ioexception)
        {
            throw new _cls02CE(ioexception);
        }
        return i;
    }

    public final String header(String s)
    {
        _mth1D42();
        if (connection == null)
        {
            connection = _mth1D08();
        }
        return connection.getHeaderField(s);
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (connection == null)
        {
            connection = _mth1D08();
        }
        stringbuilder = stringbuilder.append(connection.getRequestMethod()).append(' ');
        if (connection == null)
        {
            connection = _mth1D08();
        }
        return stringbuilder.append(connection.getURL()).toString();
    }

    public final ug _mth02CA(String s, String s1, String s2, File file)
    {
        File file1;
        File file2;
        file2 = null;
        file1 = null;
        file = new BufferedInputStream(new FileInputStream(file));
        file1 = file;
        file2 = file;
        s = _mth02CA(s, s1, s2, ((InputStream) (file)));
        try
        {
            file.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return s;
        }
        return s;
        s;
        file2 = file1;
        throw new _cls02CE(s);
        s;
        if (file2 != null)
        {
            try
            {
                file2.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s1) { }
        }
        throw s;
    }

    public final ug _mth02CA(String s, String s1, String s2, InputStream inputstream)
    {
        try
        {
            _mth1E2D();
            _mth02CF(s, s1, s2);
            s = Tx;
            (new uh(this, inputstream, Tz, inputstream, s)).call();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new _cls02CE(s);
        }
        return this;
    }

    public final ug _mth02CB(String s, Integer integer)
    {
        if (integer != null)
        {
            integer = integer.toString();
        } else
        {
            integer = null;
        }
        return _mth02CB(s, null, null, ((String) (integer)));
    }

    public final ug _mth02CB(String s, String s1, String s2, String s3)
    {
        try
        {
            _mth1E2D();
            _mth02CF(s, s1, null);
            Tx.FE7E(s3);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new _cls02CE(s);
        }
        return this;
    }

    public HttpURLConnection _mth1D08()
    {
        HttpURLConnection httpurlconnection;
        try
        {
            httpurlconnection = Tw._mth02CB(url);
            httpurlconnection.setRequestMethod(requestMethod);
        }
        catch (IOException ioexception)
        {
            throw new _cls02CE(ioexception);
        }
        return httpurlconnection;
    }

    public final String _mth1D22()
    {
        return _mth02CC("Content-Type", "charset");
    }

    public final String FBE8(String s)
    {
        _mth1D42();
        if (connection == null)
        {
            connection = _mth1D08();
        }
        int i = connection.getHeaderFieldInt("Content-Length", -1);
        ByteArrayOutputStream bytearrayoutputstream;
        if (i > 0)
        {
            bytearrayoutputstream = new ByteArrayOutputStream(i);
        } else
        {
            bytearrayoutputstream = new ByteArrayOutputStream();
        }
        try
        {
            BufferedInputStream bufferedinputstream = new BufferedInputStream(_mth1D0F(), bufferSize);
            (new uh(this, bufferedinputstream, Tz, bufferedinputstream, bytearrayoutputstream)).call();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new _cls02CE(s);
        }
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s.length() <= 0) goto _L2; else goto _L3
_L3:
        s = bytearrayoutputstream.toString(s);
        return s;
_L2:
        s = "UTF-8";
        if (true) goto _L3; else goto _L4
_L4:
    }

    static 
    {
        Tw = _cls02CB.TG;
    }
}
