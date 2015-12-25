// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.i18n;


public class LocalizedMessage
{
    public class FilteredArguments
    {
    }


    private String aCD;
    private String id;

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("Resource: \"").append(aCD);
        stringbuffer.append("\" Id: \"").append(id).append("\"");
        stringbuffer.append(" Arguments: ").append(null.length).append(" normal");
        stringbuffer.append(" Encoding: ").append(null);
        stringbuffer.append(" ClassLoader: ").append(null);
        return stringbuffer.toString();
    }
}
