// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import javax.management.JMException;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;

// Referenced classes of package com.codahale.metrics:
//            Gauge

public class JmxAttributeGauge
    implements Gauge
{

    private final String attributeName;
    private final MBeanServerConnection mBeanServerConn;
    private final ObjectName objectName;

    public JmxAttributeGauge(MBeanServerConnection mbeanserverconnection, ObjectName objectname, String s)
    {
        mBeanServerConn = mbeanserverconnection;
        objectName = objectname;
        attributeName = s;
    }

    public JmxAttributeGauge(ObjectName objectname, String s)
    {
        this(((MBeanServerConnection) (ManagementFactory.getPlatformMBeanServer())), objectname, s);
    }

    public Object getValue()
    {
        Object obj1;
        Object obj;
        try
        {
            obj = mBeanServerConn.getAttribute(objectName, attributeName);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            return null;
        }
        return obj;
    }
}
