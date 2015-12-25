// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            it

public final class or
{

    static final or MN = new or(100, "Timeout Occurred");
    static final or MO = new or(125, "Internal Error");
    static final or MP = new or(115, "Error while encrypting message to be published to Pubnub Cloud .Please contact support with error details.");
    static final or MQ = new or(116, "Decryption Error. Please contact support with error details.");
    static final or MR = new or(117, "Invalid Json. Please contact support with error details.");
    static final or MS = new or(121, "JSON Error while processing API response. Please contact support with error details.");
    static final or MT = new or(119, "Malformed URL .Please contact support with error details.");
    static final or MU = new or(101, "Pubnub Error");
    static final or MV = new or(120, "Error opening url. Please contact support with error details.");
    static final or MW = new or(122, "Protocol Exception. Please contact support with error details.");
    static final or MX = new or(128, "Unable to get Response Code. Please contact support with error details.");
    static final or MY = new or(118, "Unable to get Input Stream. Please contact support with error details.");
    static final or MZ = new or(123, "Unable to read Input Stream. Please contact support with error details.");
    static final or Na = new or(127, "Bad request. Please contact support with error details.");
    static final or Nb = new or(103, "HTTP Error. Please check network connectivity. Please contact support with error details if issue persists.");
    static final or Nc = new or(124, "Bad Gateway. Please contact support with error details.");
    static final or Nd = new or(104, "Client Timeout");
    static final or Ne = new or(111, "Gateway Timeout");
    static final or Nf = new or(126, "Parsing Error");
    static final or Ng = new or(109, "Disconnect");
    static final or Nh = new or(112, "Authentication Failure. Incorrect Authentication Key");
    static final or Ni = new or(113, "Authentication Failure. Authentication Key is missing");
    static final or Nj = new or(129, "Page Not FoundPlease verify if network is reachable.Please contact support with error details.");
    static final or Nk = new or(130, "Subscribe Timeout.");
    static final or Nl = new or(135, "Error while encrypting/decrypting message.Please contact support with error details.");
    private int Nm;
    private it Nn;
    private final String No;
    public final int errorCode;
    private String message;

    private or(int i, int j, String s)
    {
        this(i, j, s, null, null);
    }

    private or(int i, int j, String s, String s1)
    {
        this(i, j, s, null, s1);
    }

    private or(int i, int j, String s, it it, String s1)
    {
        Nm = j;
        errorCode = i;
        No = s;
        Nn = it;
        message = s1;
    }

    private or(int i, String s)
    {
        this(i, 0, s, null, null);
    }

    static or _mth02CA(or or1, int i)
    {
        return new or(or1.errorCode, i, or1.No);
    }

    static or _mth02CA(or or1, int i, String s)
    {
        return new or(or1.errorCode, i, or1.No, s);
    }

    static or _mth02CA(or or1, String s)
    {
        return new or(or1.errorCode, or1.Nm, or1.No, s);
    }

    static or _mth02CA(or or1, String s, it it)
    {
        return new or(or1.errorCode, or1.Nm, or1.No, it, s);
    }

    public final String toString()
    {
        String s1 = (new StringBuilder("[Error: ")).append(errorCode).append("-").append(Nm).append("] : ").append(No).toString();
        String s = s1;
        if (Nn != null)
        {
            s = (new StringBuilder()).append(s1).append(" : ").append(Nn).toString();
        }
        s1 = s;
        if (message != null)
        {
            s1 = s;
            if (message.length() > 0)
            {
                s1 = (new StringBuilder()).append(s).append(" : ").append(message).toString();
            }
        }
        return s1;
    }

    static 
    {
        new or(102, "Connect Exception. Please verify if network is reachable. ");
        new or(125, "Internal Server Error. Please contact support with error details.");
        new or(108, "Pubnub Exception");
        new or(110, "Disconnect and Resubscribe");
        new or(114, "ULS configuration failed. Secret Key not configured. ");
        new or(105, "Invalid Signature . Please contact support with error details.");
        new or(106, "Network Error. Please verify if network is reachable.");
        new or(131, "INVALID ARGUMENTS.");
        new or(132, "Channel Missing.");
        new or(133, "Pubnub Connection not set");
        new or(134, "Channel group name is invalid");
    }
}
