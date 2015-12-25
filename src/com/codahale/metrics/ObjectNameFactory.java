// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import javax.management.ObjectName;

public interface ObjectNameFactory
{

    public abstract ObjectName createName(String s, String s1, String s2);
}
