// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SkeinParameterSpec
    implements AlgorithmParameterSpec
{
    public static class Builder
    {

        private HashMap aGl;

        public Builder()
        {
            aGl = new HashMap();
        }
    }


    public Map aGk;

    public SkeinParameterSpec()
    {
        this(new HashMap());
    }

    private SkeinParameterSpec(HashMap hashmap)
    {
        aGk = Collections.unmodifiableMap(hashmap);
    }
}
