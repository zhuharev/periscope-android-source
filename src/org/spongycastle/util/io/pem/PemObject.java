// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.util.io.pem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package org.spongycastle.util.io.pem:
//            PemObjectGenerator

public class PemObject
    implements PemObjectGenerator
{

    private static final List EMPTY_LIST = Collections.unmodifiableList(new ArrayList());
    byte aPE[];
    List headers;
    String type;

    private PemObject(String s, List list, byte abyte0[])
    {
        type = s;
        headers = Collections.unmodifiableList(list);
        aPE = abyte0;
    }

    public PemObject(String s, byte abyte0[])
    {
        this(s, EMPTY_LIST, abyte0);
    }

    public final PemObject _mth1E3C()
    {
        return this;
    }

}
