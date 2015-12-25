// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package o:
//            _cls0534, ra, rl

class _cls050F
{

    final File file;
    final HashMap vJ;

    public _cls050F(File file1)
    {
        this(file1, Collections.emptyMap());
    }

    public _cls050F(File file1, Map map)
    {
        file = file1;
        vJ = new HashMap(map);
        if (file.length() == 0L)
        {
            vJ.putAll(_cls0534.vL);
        }
    }

    public String getFileName()
    {
        return FEAA().getName();
    }

    public String getIdentifier()
    {
        String s = getFileName();
        return s.substring(0, s.lastIndexOf('.'));
    }

    public boolean FE80()
    {
        ra._mth0454()._mth02BE("CrashlyticsCore", (new StringBuilder("Removing report at ")).append(file.getPath()).toString());
        return file.delete();
    }

    public File FEAA()
    {
        return file;
    }

    public Map FEAD()
    {
        return Collections.unmodifiableMap(vJ);
    }
}
