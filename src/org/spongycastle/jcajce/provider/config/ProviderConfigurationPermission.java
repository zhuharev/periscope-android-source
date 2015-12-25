// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.config;

import java.security.BasicPermission;
import java.security.Permission;
import java.util.StringTokenizer;
import org.spongycastle.util.Strings;

public class ProviderConfigurationPermission extends BasicPermission
{

    private final String aEW;
    private final int aEX;

    public ProviderConfigurationPermission(String s, String s1)
    {
        super(s, s1);
        aEW = s1;
        aEX = _mth1D44(s1);
    }

    private static int _mth1D44(String s)
    {
        s = new StringTokenizer(Strings.FE91(s), " ,");
        int i = 0;
        while (s.hasMoreTokens()) 
        {
            String s1 = s.nextToken();
            if (s1.equals("threadlocalecimplicitlyca"))
            {
                i |= 1;
            } else
            if (s1.equals("ecimplicitlyca"))
            {
                i |= 2;
            } else
            if (s1.equals("threadlocaldhdefaultparams"))
            {
                i |= 4;
            } else
            if (s1.equals("dhdefaultparams"))
            {
                i |= 8;
            } else
            {
                int j = i;
                if (s1.equals("all"))
                {
                    j = i | 0xf;
                }
                i = j;
            }
        }
        if (i == 0)
        {
            throw new IllegalArgumentException("unknown permissions passed to mask");
        } else
        {
            return i;
        }
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof ProviderConfigurationPermission)
        {
            obj = (ProviderConfigurationPermission)obj;
            return aEX == ((ProviderConfigurationPermission) (obj)).aEX && getName().equals(((ProviderConfigurationPermission) (obj)).getName());
        } else
        {
            return false;
        }
    }

    public String getActions()
    {
        return aEW;
    }

    public int hashCode()
    {
        return getName().hashCode() + aEX;
    }

    public boolean implies(Permission permission)
    {
        if (!(permission instanceof ProviderConfigurationPermission))
        {
            return false;
        }
        if (!getName().equals(permission.getName()))
        {
            return false;
        }
        permission = (ProviderConfigurationPermission)permission;
        return (aEX & ((ProviderConfigurationPermission) (permission)).aEX) == ((ProviderConfigurationPermission) (permission)).aEX;
    }
}
