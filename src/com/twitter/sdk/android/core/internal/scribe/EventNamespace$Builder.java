// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.scribe;


// Referenced classes of package com.twitter.sdk.android.core.internal.scribe:
//            EventNamespace

public static class I
{

    private String action;
    private String client;
    private String component;
    private String element;
    private String page;
    private String section;

    public EventNamespace builder()
    {
        return new EventNamespace(client, page, section, component, element, action);
    }

    public action setAction(String s)
    {
        action = s;
        return this;
    }

    public action setClient(String s)
    {
        client = s;
        return this;
    }

    public client setComponent(String s)
    {
        component = s;
        return this;
    }

    public component setElement(String s)
    {
        element = s;
        return this;
    }

    public element setPage(String s)
    {
        page = s;
        return this;
    }

    public page setSection(String s)
    {
        section = s;
        return this;
    }

    public I()
    {
    }
}
