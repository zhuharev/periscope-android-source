// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.examples;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;

public class DESExample
{

    private boolean atN;
    private PaddedBufferedBlockCipher atO;
    private BufferedInputStream atP;
    private BufferedOutputStream atQ;
    private byte key[];

    public DESExample()
    {
        atN = true;
        atO = null;
        atP = null;
        atQ = null;
        key = null;
    }
}
