// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PKIXPolicyNode
    implements PolicyNode
{

    private int aHI;
    protected Set aHJ;
    private PolicyNode aHK;
    private Set aHL;
    private String aHM;
    private boolean aiW;
    private List children;

    public PKIXPolicyNode(ArrayList arraylist, int i, Set set, PKIXPolicyNode pkixpolicynode, Set set1, String s, boolean flag)
    {
        children = arraylist;
        aHI = i;
        aHJ = set;
        aHK = pkixpolicynode;
        aHL = set1;
        aHM = s;
        aiW = flag;
    }

    private String toString(String s)
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(s);
        stringbuffer.append(aHM);
        stringbuffer.append(" {\n");
        for (int i = 0; i < children.size(); i++)
        {
            stringbuffer.append(((PKIXPolicyNode)children.get(i)).toString((new StringBuilder()).append(s).append("    ").toString()));
        }

        stringbuffer.append(s);
        stringbuffer.append("}\n");
        return stringbuffer.toString();
    }

    private PKIXPolicyNode _mth1F3E()
    {
        Object obj = new HashSet();
        for (Iterator iterator = aHJ.iterator(); iterator.hasNext(); ((Set) (obj)).add(new String((String)iterator.next()))) { }
        HashSet hashset = new HashSet();
        for (Iterator iterator2 = aHL.iterator(); iterator2.hasNext(); hashset.add(new String((String)iterator2.next()))) { }
        obj = new PKIXPolicyNode(new ArrayList(), aHI, ((Set) (obj)), null, hashset, new String(aHM), aiW);
        for (Iterator iterator1 = children.iterator(); iterator1.hasNext();)
        {
            PKIXPolicyNode pkixpolicynode = ((PKIXPolicyNode)iterator1.next())._mth1F3E();
            pkixpolicynode.aHK = ((PolicyNode) (obj));
            ((PKIXPolicyNode) (obj)).children.add(pkixpolicynode);
            pkixpolicynode.aHK = ((PolicyNode) (obj));
        }

        return ((PKIXPolicyNode) (obj));
    }

    public Object clone()
    {
        return _mth1F3E();
    }

    public Iterator getChildren()
    {
        return children.iterator();
    }

    public int getDepth()
    {
        return aHI;
    }

    public Set getExpectedPolicies()
    {
        return aHJ;
    }

    public PolicyNode getParent()
    {
        return aHK;
    }

    public Set getPolicyQualifiers()
    {
        return aHL;
    }

    public String getValidPolicy()
    {
        return aHM;
    }

    public final boolean hasChildren()
    {
        return !children.isEmpty();
    }

    public boolean isCritical()
    {
        return aiW;
    }

    public String toString()
    {
        return toString("");
    }

    public final void _mth02CA(PKIXPolicyNode pkixpolicynode)
    {
        children.add(pkixpolicynode);
        pkixpolicynode.aHK = this;
    }

    public final void _mth02CB(PKIXPolicyNode pkixpolicynode)
    {
        children.remove(pkixpolicynode);
    }

    public final void _mth14A2(boolean flag)
    {
        aiW = flag;
    }
}
