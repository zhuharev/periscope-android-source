// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.Writer;

public final class kj extends Writer
{
    static final class if
        implements CharSequence
    {

        char chars[];

        public final char charAt(int i)
        {
            return chars[i];
        }

        public final int length()
        {
            return chars.length;
        }

        public final CharSequence subSequence(int i, int j)
        {
            return new String(chars, i, j - i);
        }

        if()
        {
        }
    }


    private final Appendable HA;
    private final if HB;

    private kj(Appendable appendable)
    {
        HB = new if();
        HA = appendable;
    }

    public kj(Appendable appendable, byte byte0)
    {
        this(appendable);
    }

    public final void close()
    {
    }

    public final void flush()
    {
    }

    public final void write(int i)
    {
        HA.append((char)i);
    }

    public final void write(char ac[], int i, int j)
    {
        HB.chars = ac;
        HA.append(HB, i, i + j);
    }
}
