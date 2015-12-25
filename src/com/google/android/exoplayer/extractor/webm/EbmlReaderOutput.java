// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.webm;

import com.google.android.exoplayer.extractor.ExtractorInput;

interface EbmlReaderOutput
{

    public abstract void binaryElement(int i, int j, ExtractorInput extractorinput);

    public abstract void endMasterElement(int i);

    public abstract void floatElement(int i, double d);

    public abstract int getElementType(int i);

    public abstract void integerElement(int i, long l);

    public abstract void startMasterElement(int i, long l, long l1);

    public abstract void stringElement(int i, String s);
}
