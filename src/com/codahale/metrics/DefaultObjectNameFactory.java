// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import o.wt;
import o.wu;

// Referenced classes of package com.codahale.metrics:
//            ObjectNameFactory, JmxReporter

public class DefaultObjectNameFactory
    implements ObjectNameFactory
{

    private static final wt LOGGER = wu._mth02BF(com/codahale/metrics/JmxReporter);

    public DefaultObjectNameFactory()
    {
    }

    public ObjectName createName(String s, String s1, String s2)
    {
        ObjectName objectname;
        ObjectName objectname1;
        try
        {
            objectname1 = new ObjectName(s1, "name", s2);
        }
        // Misplaced declaration of an exception variable
        catch (MalformedObjectNameException malformedobjectnameexception)
        {
            try
            {
                s1 = new ObjectName(s1, "name", ObjectName.quote(s2));
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                LOGGER._mth02CF("Unable to register {} {}", new Object[] {
                    s, s2, s1
                });
                throw new RuntimeException(s1);
            }
            return s1;
        }
        objectname = objectname1;
        if (objectname1.isPattern())
        {
            objectname = new ObjectName(s1, "name", ObjectName.quote(s2));
        }
        MalformedObjectNameException malformedobjectnameexception;
        return objectname;
    }

}
