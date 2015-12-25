// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.opengl.GLES20;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;

public final class aas
{

    public int baG;

    public aas(Context context, int i, int j)
    {
        i = _mth02CF(35633, _mth02C8(context, 0x7f050004));
        j = _mth02CF(35632, _mth02C8(context, j));
        baG = GLES20.glCreateProgram();
        GLES20.glAttachShader(baG, i);
        GLES20.glAttachShader(baG, j);
        GLES20.glLinkProgram(baG);
        context = new int[1];
        GLES20.glGetProgramiv(baG, 35714, context, 0);
        if (context[0] != 1)
        {
            throw new IllegalArgumentException((new StringBuilder("Can't link program: ")).append(GLES20.glGetProgramInfoLog(baG)).toString());
        } else
        {
            GLES20.glDeleteShader(i);
            GLES20.glDeleteShader(j);
            return;
        }
    }

    private static String _mth02C8(Context context, int i)
    {
        Context context2 = null;
        Context context1 = null;
        String s;
        BufferedReader bufferedreader;
        String s1;
        try
        {
            context = context.getResources().openRawResource(i);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        finally
        {
            if (context1 != null)
            {
                try
                {
                    context1.close();
                }
                catch (IOException ioexception) { }
            }
            throw context;
        }
        context1 = context;
        context2 = context;
        bufferedreader = new BufferedReader(new InputStreamReader(context));
        s = "";
_L2:
        context1 = context;
        context2 = context;
        s1 = bufferedreader.readLine();
        if (s1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        context1 = context;
        context2 = context;
        s = (new StringBuilder()).append(s).append(s1).append("\n").toString();
        if (true) goto _L2; else goto _L1
_L1:
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return s;
            }
        }
        return s;
        context1 = context2;
        throw new IllegalArgumentException((new StringBuilder("Unable to load shader from resource: ")).append(i).toString());
    }

    private static int _mth02CF(int i, String s)
    {
        i = GLES20.glCreateShader(i);
        GLES20.glShaderSource(i, s);
        GLES20.glCompileShader(i);
        s = new int[1];
        GLES20.glGetShaderiv(i, 35713, s, 0);
        if (s[0] == 0)
        {
            throw new IllegalArgumentException((new StringBuilder("Could not compile shader: ")).append(GLES20.glGetShaderInfoLog(i)).toString());
        } else
        {
            return i;
        }
    }
}
