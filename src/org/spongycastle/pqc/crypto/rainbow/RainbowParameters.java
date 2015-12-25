// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.rainbow;

import org.spongycastle.crypto.CipherParameters;

public class RainbowParameters
    implements CipherParameters
{

    int aNI[];
    private final int aNN[] = {
        6, 12, 17, 22, 33
    };

    public RainbowParameters()
    {
        aNI = aNN;
    }

    public RainbowParameters(int ai[])
    {
        aNI = ai;
        try
        {
            _mth0996();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (int ai[])
        {
            ai.printStackTrace();
        }
    }

    private void _mth0996()
    {
        if (aNI == null)
        {
            throw new Exception("no layers defined.");
        }
        if (aNI.length > 1)
        {
            for (int i = 0; i < aNI.length - 1; i++)
            {
                if (aNI[i] >= aNI[i + 1])
                {
                    throw new Exception("v[i] has to be smaller than v[i+1]");
                }
            }

            return;
        } else
        {
            throw new Exception("Rainbow needs at least 1 layer, such that v1 < v2.");
        }
    }
}
