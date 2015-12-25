// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.impl.StaticLoggerBinder;

// Referenced classes of package o:
//            xb, wy, _cls1D4D, ws, 
//            xa, wt

public final class wu
{

    private static int VF = 0;
    private static xb VG = new xb();
    private static wy VH = new wy();
    private static final String VI[] = {
        "1.6", "1.7"
    };
    private static String VJ = "org/slf4j/impl/StaticLoggerBinder.class";

    private wu()
    {
    }

    private static final void _mth02A2()
    {
        LinkedHashSet linkedhashset = _mth03B5();
        boolean flag;
label0:
        {
            if (linkedhashset.size() > 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_86;
            }
            try
            {
                _cls1D4D._mth02BF("Class path contains multiple SLF4J bindings.");
                URL url;
                for (Iterator iterator = linkedhashset.iterator(); iterator.hasNext(); _cls1D4D._mth02BF((new StringBuilder("Found binding in [")).append(url).append("]").toString()))
                {
                    url = (URL)iterator.next();
                }

            }
            catch (NoClassDefFoundError noclassdeffounderror)
            {
label1:
                {
                    String s = noclassdeffounderror.getMessage();
                    if (s != null)
                    {
                        if (s.indexOf("org/slf4j/impl/StaticLoggerBinder") != -1)
                        {
                            flag = true;
                            break label1;
                        }
                        if (s.indexOf("org.slf4j.impl.StaticLoggerBinder") != -1)
                        {
                            flag = true;
                            break label1;
                        }
                    }
                    flag = false;
                }
                if (flag)
                {
                    VF = 4;
                    _cls1D4D._mth02BF("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                    _cls1D4D._mth02BF("Defaulting to no-operation (NOP) logger implementation");
                    _cls1D4D._mth02BF("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
                } else
                {
                    VF = 2;
                    _cls1D4D._mth02CA("Failed to instantiate SLF4J LoggerFactory", noclassdeffounderror);
                    throw noclassdeffounderror;
                }
                break label0;
            }
            catch (NoSuchMethodError nosuchmethoderror)
            {
                String s1 = nosuchmethoderror.getMessage();
                if (s1 != null && s1.indexOf("org.slf4j.impl.StaticLoggerBinder.getSingleton()") != -1)
                {
                    VF = 2;
                    _cls1D4D._mth02BF("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                    _cls1D4D._mth02BF("Your binding is version 1.5.5 or earlier.");
                    _cls1D4D._mth02BF("Upgrade your binding to version 1.6.x.");
                }
                throw nosuchmethoderror;
            }
            catch (Exception exception)
            {
                VF = 2;
                _cls1D4D._mth02CA("Failed to instantiate SLF4J LoggerFactory", exception);
                throw new IllegalStateException("Unexpected initialization failure", exception);
            }
        }
        _cls1D4D._mth02BF("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        StaticLoggerBinder.getSingleton();
        VF = 3;
        if (linkedhashset.size() > 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        _cls1D4D._mth02BF((new StringBuilder("Actual binding is of type [")).append(StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr()).append("]").toString());
        _mth03AB();
        break label0;
        if (VF == 3)
        {
            _mth03B3();
        }
        return;
    }

    public static wt _mth02BF(Class class1)
    {
        class1 = class1.getName();
        return _mth03BA()._mth02E4(class1);
    }

    public static wt _mth02E4(String s)
    {
        return _mth03BA()._mth02E4(s);
    }

    private static final void _mth03AB()
    {
        Object obj = new ArrayList(VG.VM.values());
        if (((List) (obj)).isEmpty())
        {
            return;
        }
        _cls1D4D._mth02BF("The following set of substitute loggers may have been accessed");
        _cls1D4D._mth02BF("during the initialization phase. Logging calls during this");
        _cls1D4D._mth02BF("phase were not honored. However, subsequent logging calls to these");
        _cls1D4D._mth02BF("loggers will work as normally expected.");
        _cls1D4D._mth02BF("See also http://www.slf4j.org/codes.html#substituteLogger");
        xa xa1;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); _cls1D4D._mth02BF(xa1.name))
        {
            xa1 = (xa)((Iterator) (obj)).next();
            String s = xa1.name;
            xa1.VL = _mth03BA()._mth02E4(s);
        }

        VG.VM.clear();
    }

    private static final void _mth03B3()
    {
        int i;
        String s;
        boolean flag;
        try
        {
            s = StaticLoggerBinder.REQUESTED_API_VERSION;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
        catch (Throwable throwable)
        {
            _cls1D4D._mth02CA("Unexpected problem occured during version sanity check", throwable);
            return;
        }
        flag = false;
        i = 0;
_L2:
        if (i >= 2)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        if (s.startsWith(VI[i]))
        {
            flag = true;
        }
        break MISSING_BLOCK_LABEL_86;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        _cls1D4D._mth02BF((new StringBuilder("The requested version ")).append(s).append(" by your slf4j binding is not compatible with ").append(Arrays.asList(VI).toString()).toString());
        _cls1D4D._mth02BF("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
        return;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static LinkedHashSet _mth03B5()
    {
        LinkedHashSet linkedhashset = new LinkedHashSet();
        Object obj;
        try
        {
            obj = o/wu.getClassLoader();
        }
        catch (IOException ioexception)
        {
            _cls1D4D._mth02CA("Error getting resources from path", ioexception);
            return linkedhashset;
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        obj = ClassLoader.getSystemResources(VJ);
        break MISSING_BLOCK_LABEL_36;
        obj = ((ClassLoader) (obj)).getResources(VJ);
        while (((Enumeration) (obj)).hasMoreElements()) 
        {
            linkedhashset.add((URL)((Enumeration) (obj)).nextElement());
        }
        return linkedhashset;
    }

    private static ws _mth03BA()
    {
        if (VF == 0)
        {
            VF = 1;
            _mth02A2();
        }
        switch (VF)
        {
        case 3: // '\003'
            return StaticLoggerBinder.getSingleton().getLoggerFactory();

        case 4: // '\004'
            return VH;

        case 2: // '\002'
            throw new IllegalStateException("org.slf4j.LoggerFactory could not be successfully initialized. See also http://www.slf4j.org/codes.html#unsuccessfulInit");

        case 1: // '\001'
            return VG;
        }
        throw new IllegalStateException("Unreachable code");
    }

}
