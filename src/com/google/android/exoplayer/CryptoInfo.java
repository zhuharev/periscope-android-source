// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import android.media.MediaExtractor;
import com.google.android.exoplayer.util.Util;

public final class CryptoInfo
{

    private final android.media.MediaCodec.CryptoInfo frameworkCryptoInfo;
    public byte iv[];
    public byte key[];
    public int mode;
    public int numBytesOfClearData[];
    public int numBytesOfEncryptedData[];
    public int numSubSamples;

    public CryptoInfo()
    {
        android.media.MediaCodec.CryptoInfo cryptoinfo;
        if (Util.SDK_INT >= 16)
        {
            cryptoinfo = newFrameworkCryptoInfoV16();
        } else
        {
            cryptoinfo = null;
        }
        frameworkCryptoInfo = cryptoinfo;
    }

    private android.media.MediaCodec.CryptoInfo newFrameworkCryptoInfoV16()
    {
        return new android.media.MediaCodec.CryptoInfo();
    }

    private void updateFrameworkCryptoInfoV16()
    {
        frameworkCryptoInfo.set(numSubSamples, numBytesOfClearData, numBytesOfEncryptedData, key, iv, mode);
    }

    public final android.media.MediaCodec.CryptoInfo getFrameworkCryptoInfoV16()
    {
        return frameworkCryptoInfo;
    }

    public final void set(int i, int ai[], int ai1[], byte abyte0[], byte abyte1[], int j)
    {
        numSubSamples = i;
        numBytesOfClearData = ai;
        numBytesOfEncryptedData = ai1;
        key = abyte0;
        iv = abyte1;
        mode = j;
        if (Util.SDK_INT >= 16)
        {
            updateFrameworkCryptoInfoV16();
        }
    }

    public final void setFromExtractorV16(MediaExtractor mediaextractor)
    {
        mediaextractor.getSampleCryptoInfo(frameworkCryptoInfo);
        numSubSamples = frameworkCryptoInfo.numSubSamples;
        numBytesOfClearData = frameworkCryptoInfo.numBytesOfClearData;
        numBytesOfEncryptedData = frameworkCryptoInfo.numBytesOfEncryptedData;
        key = frameworkCryptoInfo.key;
        iv = frameworkCryptoInfo.iv;
        mode = frameworkCryptoInfo.mode;
    }
}
