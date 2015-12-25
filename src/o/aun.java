// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package o:
//            aum

public final class aun
    implements CookieStore
{

    private final HashMap bFk = new HashMap();

    public aun()
    {
    }

    private static URI _mth02CA(URI uri)
    {
        if (uri == null)
        {
            return null;
        }
        URI uri1;
        try
        {
            uri1 = new URI("http", uri.getHost(), null, null);
        }
        catch (URISyntaxException urisyntaxexception)
        {
            return uri;
        }
        return uri1;
    }

    public final void add(URI uri, HttpCookie httpcookie)
    {
        this;
        JVM INSTR monitorenter ;
        if (httpcookie != null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        throw new NullPointerException("cookie == null");
        URI uri1;
        uri1 = _mth02CA(uri);
        uri = (List)bFk.get(uri1);
        if (uri != null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        uri = new ArrayList();
        bFk.put(uri1, uri);
        break MISSING_BLOCK_LABEL_70;
        uri.remove(httpcookie);
        uri.add(httpcookie);
        this;
        JVM INSTR monitorexit ;
        return;
        uri;
        throw uri;
    }

    public final List get(URI uri)
    {
        this;
        JVM INSTR monitorenter ;
        if (uri != null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        throw new NullPointerException("uri == null");
        ArrayList arraylist;
        Object obj;
        arraylist = new ArrayList();
        obj = (List)bFk.get(uri);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        obj = ((List) (obj)).iterator();
_L1:
        Object obj1;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_98;
            }
            obj1 = (HttpCookie)((Iterator) (obj)).next();
            if (!((HttpCookie) (obj1)).hasExpired())
            {
                break MISSING_BLOCK_LABEL_86;
            }
            ((Iterator) (obj)).remove();
        } while (true);
        arraylist.add(obj1);
          goto _L1
        obj = bFk.entrySet().iterator();
_L6:
        if (!((Iterator) (obj)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
        if (uri.equals(((java.util.Map.Entry) (obj1)).getKey()))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj1 = ((List)((java.util.Map.Entry) (obj1)).getValue()).iterator();
_L3:
        HttpCookie httpcookie;
        while (((Iterator) (obj1)).hasNext()) 
        {
            httpcookie = (HttpCookie)((Iterator) (obj1)).next();
            if (HttpCookie.domainMatches(aum._mth02CA(httpcookie), uri.getHost()))
            {
                if (!httpcookie.hasExpired())
                {
                    continue; /* Loop/switch isn't completed */
                }
                ((Iterator) (obj1)).remove();
            }
        }
        break; /* Loop/switch isn't completed */
        if (arraylist.contains(httpcookie)) goto _L3; else goto _L2
_L2:
        arraylist.add(httpcookie);
        if (true) goto _L3; else goto _L4
_L4:
        if (true) goto _L6; else goto _L5
_L5:
        uri = Collections.unmodifiableList(arraylist);
        this;
        JVM INSTR monitorexit ;
        return uri;
        uri;
        throw uri;
    }

    public final List getCookies()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Iterator iterator;
        obj = new ArrayList();
        iterator = bFk.values().iterator();
_L5:
        Iterator iterator1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        iterator1 = ((List)iterator.next()).iterator();
_L2:
        HttpCookie httpcookie;
        while (iterator1.hasNext()) 
        {
            httpcookie = (HttpCookie)iterator1.next();
            if (!httpcookie.hasExpired())
            {
                continue; /* Loop/switch isn't completed */
            }
            iterator1.remove();
        }
        break; /* Loop/switch isn't completed */
        if (((List) (obj)).contains(httpcookie)) goto _L2; else goto _L1
_L1:
        ((List) (obj)).add(httpcookie);
        if (true) goto _L2; else goto _L3
_L3:
        if (true) goto _L5; else goto _L4
_L4:
        obj = Collections.unmodifiableList(((List) (obj)));
        this;
        JVM INSTR monitorexit ;
        return ((List) (obj));
        Exception exception;
        exception;
        throw exception;
    }

    public final List getURIs()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = new ArrayList(bFk.keySet());
        ((List) (obj)).remove(null);
        obj = Collections.unmodifiableList(((List) (obj)));
        this;
        JVM INSTR monitorexit ;
        return ((List) (obj));
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean remove(URI uri, HttpCookie httpcookie)
    {
        this;
        JVM INSTR monitorenter ;
        if (httpcookie != null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        throw new NullPointerException("cookie == null");
        uri = (List)bFk.get(_mth02CA(uri));
        if (uri == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        boolean flag = uri.remove(httpcookie);
        if (flag)
        {
            return true;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        uri;
        throw uri;
    }

    public final boolean removeAll()
    {
        this;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (!bFk.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bFk.clear();
        this;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        throw exception;
    }
}
