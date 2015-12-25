// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class mt
    implements Closeable, Flushable
{

    private static final String JR[];
    private static final String JS[];
    public boolean Gj;
    public boolean Gk;
    private int JC[];
    private int JD;
    private String JT;
    private String JU;
    public boolean Ju;
    private final Writer out;
    private String separator;

    public mt(Writer writer)
    {
        JC = new int[32];
        JD = 0;
        _mth1541(6);
        separator = ":";
        Gj = true;
        if (writer == null)
        {
            throw new NullPointerException("out == null");
        } else
        {
            out = writer;
            return;
        }
    }

    private void _mth01C3(boolean flag)
    {
        if (JD == 0)
        {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        switch (JC[JD - 1])
        {
        case 7: // '\007'
            if (!Ju)
            {
                throw new IllegalStateException("JSON must have only one top-level value.");
            }
            // fall through

        case 6: // '\006'
            if (!Ju && !flag)
            {
                throw new IllegalStateException("JSON must start with an array or an object.");
            } else
            {
                JC[JD - 1] = 7;
                return;
            }

        case 1: // '\001'
            JC[JD - 1] = 2;
            _mth1528();
            return;

        case 2: // '\002'
            out.append(',');
            _mth1528();
            return;

        case 4: // '\004'
            out.append(separator);
            JC[JD - 1] = 5;
            return;

        case 3: // '\003'
        case 5: // '\005'
        default:
            throw new IllegalStateException("Nesting problem.");
        }
    }

    private mt _mth02CB(int i, int j, String s)
    {
        if (JD == 0)
        {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        int k = JC[JD - 1];
        if (k != j && k != i)
        {
            throw new IllegalStateException("Nesting problem.");
        }
        if (JU != null)
        {
            throw new IllegalStateException((new StringBuilder("Dangling name: ")).append(JU).toString());
        }
        JD = JD - 1;
        if (k == j)
        {
            _mth1528();
        }
        out.write(s);
        return this;
    }

    private void _mth1507(String s)
    {
        String as[];
        if (Gk)
        {
            as = JS;
        } else
        {
            as = JR;
        }
        out.write("\"");
        int j = 0;
        int l = s.length();
        for (int i = 0; i < l;)
        {
            int k;
label0:
            {
                char c = s.charAt(i);
                String s1;
                if (c < '\200')
                {
                    String s2 = as[c];
                    s1 = s2;
                    if (s2 == null)
                    {
                        k = j;
                        break label0;
                    }
                } else
                if (c == '\u2028')
                {
                    s1 = "\\u2028";
                } else
                {
                    k = j;
                    if (c != '\u2029')
                    {
                        break label0;
                    }
                    s1 = "\\u2029";
                }
                if (j < i)
                {
                    out.write(s, j, i - j);
                }
                out.write(s1);
                k = i + 1;
            }
            i++;
            j = k;
        }

        if (j < l)
        {
            out.write(s, j, l - j);
        }
        out.write("\"");
    }

    private void _mth1528()
    {
        if (JT == null)
        {
            return;
        }
        out.write("\n");
        int i = 1;
        for (int j = JD; i < j; i++)
        {
            out.write(JT);
        }

    }

    private void _mth152D()
    {
        if (JD == 0)
        {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        int i = JC[JD - 1];
        if (i == 5)
        {
            out.write(44);
        } else
        if (i != 3)
        {
            throw new IllegalStateException("Nesting problem.");
        }
        _mth1528();
        JC[JD - 1] = 4;
    }

    private void _mth1541(int i)
    {
        if (JD == JC.length)
        {
            int ai[] = new int[JD << 1];
            System.arraycopy(JC, 0, ai, 0, JD);
            JC = ai;
        }
        int ai1[] = JC;
        int j = JD;
        JD = j + 1;
        ai1[j] = i;
    }

    public void close()
    {
        out.close();
        int i = JD;
        if (i > 1 || i == 1 && JC[i - 1] != 7)
        {
            throw new IOException("Incomplete document");
        } else
        {
            JD = 0;
            return;
        }
    }

    public void flush()
    {
        if (JD == 0)
        {
            throw new IllegalStateException("JsonWriter is closed.");
        } else
        {
            out.flush();
            return;
        }
    }

    public final void setIndent(String s)
    {
        if (s.length() == 0)
        {
            JT = null;
            separator = ":";
            return;
        } else
        {
            JT = s;
            separator = ": ";
            return;
        }
    }

    public mt _mth02BE(long l)
    {
        if (JU != null)
        {
            _mth152D();
            _mth1507(JU);
            JU = null;
        }
        _mth01C3(false);
        out.write(Long.toString(l));
        return this;
    }

    public mt _mth02CA(Number number)
    {
        if (number == null)
        {
            return _mth14F7();
        }
        if (JU != null)
        {
            _mth152D();
            _mth1507(JU);
            JU = null;
        }
        String s = number.toString();
        if (!Ju && (s.equals("-Infinity") || s.equals("Infinity") || s.equals("NaN")))
        {
            throw new IllegalArgumentException((new StringBuilder("Numeric values must be finite, but was ")).append(number).toString());
        } else
        {
            _mth01C3(false);
            out.append(s);
            return this;
        }
    }

    public mt _mth13D0()
    {
        if (JU != null)
        {
            _mth152D();
            _mth1507(JU);
            JU = null;
        }
        _mth01C3(true);
        _mth1541(1);
        out.write("[");
        return this;
    }

    public mt _mth141C()
    {
        return _mth02CB(1, 2, "]");
    }

    public mt _mth141F(String s)
    {
        if (s == null)
        {
            throw new NullPointerException("name == null");
        }
        if (JU != null)
        {
            throw new IllegalStateException();
        }
        if (JD == 0)
        {
            throw new IllegalStateException("JsonWriter is closed.");
        } else
        {
            JU = s;
            return this;
        }
    }

    public mt _mth1421(String s)
    {
        if (s == null)
        {
            return _mth14F7();
        }
        if (JU != null)
        {
            _mth152D();
            _mth1507(JU);
            JU = null;
        }
        _mth01C3(false);
        _mth1507(s);
        return this;
    }

    public mt _mth14A9()
    {
        if (JU != null)
        {
            _mth152D();
            _mth1507(JU);
            JU = null;
        }
        _mth01C3(true);
        _mth1541(3);
        out.write("{");
        return this;
    }

    public mt _mth14F6()
    {
        return _mth02CB(3, 5, "}");
    }

    public mt _mth14F7()
    {
        if (JU != null)
        {
            if (Gj)
            {
                if (JU != null)
                {
                    _mth152D();
                    _mth1507(JU);
                    JU = null;
                }
            } else
            {
                JU = null;
                return this;
            }
        }
        _mth01C3(false);
        out.write("null");
        return this;
    }

    public mt FF9F(boolean flag)
    {
        if (JU != null)
        {
            _mth152D();
            _mth1507(JU);
            JU = null;
        }
        _mth01C3(false);
        Writer writer = out;
        String s;
        if (flag)
        {
            s = "true";
        } else
        {
            s = "false";
        }
        writer.write(s);
        return this;
    }

    static 
    {
        JR = new String[128];
        for (int i = 0; i <= 31; i++)
        {
            JR[i] = String.format("\\u%04x", new Object[] {
                Integer.valueOf(i)
            });
        }

        JR[34] = "\\\"";
        JR[92] = "\\\\";
        JR[9] = "\\t";
        JR[8] = "\\b";
        JR[10] = "\\n";
        JR[13] = "\\r";
        JR[12] = "\\f";
        String as[] = (String[])JR.clone();
        JS = as;
        as[60] = "\\u003c";
        JS[62] = "\\u003e";
        JS[38] = "\\u0026";
        JS[61] = "\\u003d";
        JS[39] = "\\u0027";
    }
}
