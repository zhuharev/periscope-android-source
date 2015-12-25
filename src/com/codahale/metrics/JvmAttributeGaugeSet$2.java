// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.lang.management.RuntimeMXBean;
import java.util.Locale;

// Referenced classes of package com.codahale.metrics:
//            Gauge, JvmAttributeGaugeSet

class this._cls0
    implements Gauge
{

    final JvmAttributeGaugeSet this$0;

    public volatile Object getValue()
    {
        return getValue();
    }

    public String getValue()
    {
        return String.format(Locale.US, "%s %s %s (%s)", new Object[] {
            JvmAttributeGaugeSet.access$000(JvmAttributeGaugeSet.this).getVmVendor(), JvmAttributeGaugeSet.access$000(JvmAttributeGaugeSet.this).getVmName(), JvmAttributeGaugeSet.access$000(JvmAttributeGaugeSet.this).getVmVersion(), JvmAttributeGaugeSet.access$000(JvmAttributeGaugeSet.this).getSpecVersion()
        });
    }

    ()
    {
        this$0 = JvmAttributeGaugeSet.this;
        super();
    }
}
