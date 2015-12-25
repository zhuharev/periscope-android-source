// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.net.SocketTimeoutException;
import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package o:
//            nv, ny, os, oa, 
//            aul, pf, ob, ow, 
//            or

final class oy extends nv
{

    private Exception Nx;

    oy(Vector vector, int i, int j, int k, int l, int i1, Hashtable hashtable)
    {
        super(vector, i, j, k, l, i1, hashtable);
        Nx = null;
    }

    public final void shutdown()
    {
        if (NK != null)
        {
            NK.shutdown();
        }
    }

    final void _mth02CB(oa oa1)
    {
        Object obj = null;
        int i;
        if (oa1.Mb)
        {
            i = 1;
        } else
        {
            i = LQ;
        }
        aul._mth02BF("PubNub", (new StringBuilder("disconnectAndResubscribe is ")).append(oa1.Mb).toString());
        if (oa1.Md != null)
        {
            aul._mth02BF("PubNub", (new StringBuilder("Request placed by worker ")).append(oa1.Md.NH.getName()).toString());
            if (oa1.Md.NI)
            {
                aul._mth02BF("PubNub", (new StringBuilder("The thread which placed the request has died, so ignore the request : ")).append(oa1.Md.NH.getName()).toString());
                return;
            }
        }
        oa1.Md = this;
        SocketTimeoutException sockettimeoutexception;
        Object obj1;
        Object obj2;
        Object obj3;
        ob ob1;
        int j;
        boolean flag;
        if (!oa1.Mc && LS != 0)
        {
            try
            {
                Thread.sleep(LS);
            }
            catch (InterruptedException interruptedexception) { }
        }
        j = 0;
        obj1 = obj;
        if (NI)
        {
            break MISSING_BLOCK_LABEL_591;
        }
        obj1 = obj;
        if (i > LQ)
        {
            break MISSING_BLOCK_LABEL_591;
        }
        if (j != 0)
        {
            try
            {
                Thread.sleep(LR);
            }
            catch (InterruptedException interruptedexception1) { }
        }
        flag = true;
        obj1 = obj;
        obj2 = obj;
        obj3 = obj;
        try
        {
            aul._mth02BE("PubNub", oa1.getUrl());
        }
        // Misplaced declaration of an exception variable
        catch (SocketTimeoutException sockettimeoutexception)
        {
            aul._mth02BF("PubNub", (new StringBuilder("No Traffic , Read Timeout Exception in Fetch : ")).append(sockettimeoutexception.toString()).toString());
            if (NI)
            {
                aul._mth02BF("PubNub", "Asked to Die, Don't do back from DAR processing");
            } else
            if (oa1.Mb)
            {
                oa1.LY._mth02CE(oa1);
                return;
            } else
            {
                oa1.LY._mth02CB(or._mth02CA(or.Nk, 1));
                return;
            }
            break MISSING_BLOCK_LABEL_591;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            Nx = ((Exception) (obj1));
            switch (((os) (obj1)).Nq.errorCode)
            {
            case 112: // 'p'
            case 113: // 'q'
                aul._mth02BF("PubNub", (new StringBuilder("Authentication Failure : ")).append(((os) (obj1)).toString()).toString());
                i = LQ + 1;
                sockettimeoutexception = ((SocketTimeoutException) (obj2));
                j = ((flag) ? 1 : 0);
                break;

            default:
                obj3 = new StringBuilder("Retry Attempt : ");
                if (i == LQ)
                {
                    sockettimeoutexception = "last";
                } else
                {
                    sockettimeoutexception = Integer.valueOf(i);
                }
                aul._mth02BF("PubNub", ((StringBuilder) (obj3)).append(sockettimeoutexception).append(" Exception in Fetch : ").append(((os) (obj1)).toString()).toString());
                i++;
                sockettimeoutexception = ((SocketTimeoutException) (obj2));
                j = ((flag) ? 1 : 0);
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            Nx = ((Exception) (obj1));
            obj2 = new StringBuilder("Retry Attempt : ");
            if (i == LQ)
            {
                sockettimeoutexception = "last";
            } else
            {
                sockettimeoutexception = Integer.valueOf(i);
            }
            aul._mth02BF("PubNub", ((StringBuilder) (obj2)).append(sockettimeoutexception).append(" Exception in Fetch : ").append(((Exception) (obj1)).toString()).toString());
            i++;
            sockettimeoutexception = ((SocketTimeoutException) (obj3));
            j = ((flag) ? 1 : 0);
            continue; /* Loop/switch isn't completed */
        }
        obj1 = obj;
        obj2 = obj;
        obj3 = obj;
        ob1 = NK._mth02CA(oa1.getUrl(), null);
        obj = ob1;
        obj1 = obj;
        obj2 = obj;
        obj3 = obj;
        j = ob1.statusCode;
        if (j == 200)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (j != 0)
        {
            obj1 = obj;
        } else
        {
            j = ((flag) ? 1 : 0);
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_591;
        if (!NI)
        {
            if (obj1 == null)
            {
                aul._mth02BE("PubNub", (new StringBuilder("Error in fetching url : ")).append(oa1.getUrl()).toString());
                if (oa1.Mb)
                {
                    aul._mth02BF("PubNub", "Exhausted number of retries");
                    oa1.LY.FB8A();
                    return;
                }
                if (Nx != null && (Nx instanceof os) && ((os)Nx).Nq != null)
                {
                    oa1.LY._mth02CB(((os)Nx).Nq);
                    return;
                } else
                {
                    oa1.LY._mth02CB(or._mth02CA(or.Nb, 1));
                    return;
                }
            }
            aul._mth02BE("PubNub", ((ob) (obj1)).response);
            oa1.LY._mth02CA(oa1, ((ob) (obj1)).response);
        }
        break; /* Loop/switch isn't completed */
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_153;
_L1:
    }
}
