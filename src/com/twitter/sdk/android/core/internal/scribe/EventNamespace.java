// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.scribe;


public class EventNamespace
{
    public static class Builder
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

        public Builder setAction(String s)
        {
            action = s;
            return this;
        }

        public Builder setClient(String s)
        {
            client = s;
            return this;
        }

        public Builder setComponent(String s)
        {
            component = s;
            return this;
        }

        public Builder setElement(String s)
        {
            element = s;
            return this;
        }

        public Builder setPage(String s)
        {
            page = s;
            return this;
        }

        public Builder setSection(String s)
        {
            section = s;
            return this;
        }

        public Builder()
        {
        }
    }


    public final String action;
    public final String client;
    public final String component;
    public final String element;
    public final String page;
    public final String section;

    public EventNamespace(String s, String s1, String s2, String s3, String s4, String s5)
    {
        client = s;
        page = s1;
        section = s2;
        component = s3;
        element = s4;
        action = s5;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (EventNamespace)obj;
        if (action == null ? ((EventNamespace) (obj)).action != null : !action.equals(((EventNamespace) (obj)).action))
        {
            return false;
        }
        if (client == null ? ((EventNamespace) (obj)).client != null : !client.equals(((EventNamespace) (obj)).client))
        {
            return false;
        }
        if (component == null ? ((EventNamespace) (obj)).component != null : !component.equals(((EventNamespace) (obj)).component))
        {
            return false;
        }
        if (element == null ? ((EventNamespace) (obj)).element != null : !element.equals(((EventNamespace) (obj)).element))
        {
            return false;
        }
        if (page == null ? ((EventNamespace) (obj)).page != null : !page.equals(((EventNamespace) (obj)).page))
        {
            return false;
        }
        return section == null ? ((EventNamespace) (obj)).section == null : section.equals(((EventNamespace) (obj)).section);
    }

    public int hashCode()
    {
        int i;
        if (client != null)
        {
            i = client.hashCode();
        } else
        {
            i = 0;
        }
        int j;
        if (page != null)
        {
            j = page.hashCode();
        } else
        {
            j = 0;
        }
        int k;
        if (section != null)
        {
            k = section.hashCode();
        } else
        {
            k = 0;
        }
        int l;
        if (component != null)
        {
            l = component.hashCode();
        } else
        {
            l = 0;
        }
        int i1;
        if (element != null)
        {
            i1 = element.hashCode();
        } else
        {
            i1 = 0;
        }
        int j1;
        if (action != null)
        {
            j1 = action.hashCode();
        } else
        {
            j1 = 0;
        }
        return ((((i * 31 + j) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1;
    }

    public String toString()
    {
        return (new StringBuilder("client=")).append(client).append(", page=").append(page).append(", section=").append(section).append(", component=").append(component).append(", element=").append(element).append(", action=").append(action).toString();
    }
}
