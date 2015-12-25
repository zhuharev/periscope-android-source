// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

// Referenced classes of package o:
//            mq, kv, ir, je, 
//            mt, kx, iq

public abstract class jd
{

    public jd()
    {
    }

    public final Object fromJson(Reader reader)
    {
        return read(new mq(reader));
    }

    public final Object fromJson(String s)
    {
        return fromJson(((Reader) (new StringReader(s))));
    }

    public final Object fromJsonTree(iq iq)
    {
        try
        {
            iq = ((iq) (read(new kv(iq))));
        }
        // Misplaced declaration of an exception variable
        catch (iq iq)
        {
            throw new ir(iq);
        }
        return iq;
    }

    public final jd nullSafe()
    {
        return new je(this);
    }

    public abstract Object read(mq mq1);

    public final String toJson(Object obj)
    {
        StringWriter stringwriter = new StringWriter();
        toJson(((Writer) (stringwriter)), obj);
        return stringwriter.toString();
    }

    public final void toJson(Writer writer, Object obj)
    {
        write(new mt(writer), obj);
    }

    public final iq toJsonTree(Object obj)
    {
        try
        {
            kx kx1 = new kx();
            write(kx1, obj);
            obj = kx1._mth13A8();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new ir(((Exception) (obj)));
        }
        return ((iq) (obj));
    }

    public abstract void write(mt mt1, Object obj);
}
