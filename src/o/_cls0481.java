// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

// Referenced classes of package o:
//            FEAE, FF43, FEE9, FC62, 
//            _cls1D08, _cls0507

final class _cls0481
    implements FEAE
{

    private int hashCode;
    private final int height;
    final String id;
    private final FF43 jD;
    final FEAE jt;
    private final _cls1D08 ml;
    private final FEE9 na;
    private final FEE9 nb;
    private final FC62 nc;
    private final FC62 nd;
    private String ne;
    _cls0507 nf;
    private final int width;

    public _cls0481(String s, FEAE feae, int i, int j, FEE9 fee9, FEE9 fee9_1, FF43 ff43, 
            FC62 fc62, _cls1D08 _pcls1d08, FC62 fc62_1)
    {
        id = s;
        jt = feae;
        width = i;
        height = j;
        na = fee9;
        nb = fee9_1;
        jD = ff43;
        nc = fc62;
        ml = _pcls1d08;
        nd = fc62_1;
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (_cls0481)obj;
        if (!id.equals(((_cls0481) (obj)).id))
        {
            return false;
        }
        if (!jt.equals(((_cls0481) (obj)).jt))
        {
            return false;
        }
        if (height != ((_cls0481) (obj)).height)
        {
            return false;
        }
        if (width != ((_cls0481) (obj)).width)
        {
            return false;
        }
        boolean flag;
        if (jD == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        boolean flag1;
        if (((_cls0481) (obj)).jD == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag ^ flag1)
        {
            return false;
        }
        if (jD != null && !jD.getId().equals(((_cls0481) (obj)).jD.getId()))
        {
            return false;
        }
        if (nb == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((_cls0481) (obj)).nb == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag ^ flag1)
        {
            return false;
        }
        if (nb != null && !nb.getId().equals(((_cls0481) (obj)).nb.getId()))
        {
            return false;
        }
        if (na == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((_cls0481) (obj)).na == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag ^ flag1)
        {
            return false;
        }
        if (na != null && !na.getId().equals(((_cls0481) (obj)).na.getId()))
        {
            return false;
        }
        if (nc == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((_cls0481) (obj)).nc == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag ^ flag1)
        {
            return false;
        }
        if (nc != null && !nc.getId().equals(((_cls0481) (obj)).nc.getId()))
        {
            return false;
        }
        if (ml == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((_cls0481) (obj)).ml == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag ^ flag1)
        {
            return false;
        }
        if (ml != null && !ml.getId().equals(((_cls0481) (obj)).ml.getId()))
        {
            return false;
        }
        if (nd == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((_cls0481) (obj)).nd == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag ^ flag1)
        {
            return false;
        }
        return nd == null || nd.getId().equals(((_cls0481) (obj)).nd.getId());
    }

    public final int hashCode()
    {
        if (hashCode == 0)
        {
            hashCode = id.hashCode();
            hashCode = hashCode * 31 + jt.hashCode();
            hashCode = hashCode * 31 + width;
            hashCode = hashCode * 31 + height;
            int j = hashCode;
            int i;
            if (na != null)
            {
                i = na.getId().hashCode();
            } else
            {
                i = 0;
            }
            hashCode = j * 31 + i;
            j = hashCode;
            if (nb != null)
            {
                i = nb.getId().hashCode();
            } else
            {
                i = 0;
            }
            hashCode = j * 31 + i;
            j = hashCode;
            if (jD != null)
            {
                i = jD.getId().hashCode();
            } else
            {
                i = 0;
            }
            hashCode = j * 31 + i;
            j = hashCode;
            if (nc != null)
            {
                i = nc.getId().hashCode();
            } else
            {
                i = 0;
            }
            hashCode = j * 31 + i;
            j = hashCode;
            if (ml != null)
            {
                i = ml.getId().hashCode();
            } else
            {
                i = 0;
            }
            hashCode = j * 31 + i;
            j = hashCode;
            if (nd != null)
            {
                i = nd.getId().hashCode();
            } else
            {
                i = 0;
            }
            hashCode = j * 31 + i;
        }
        return hashCode;
    }

    public final String toString()
    {
        if (ne == null)
        {
            StringBuilder stringbuilder = (new StringBuilder("EngineKey{")).append(id).append('+').append(jt).append("+[").append(width).append('x').append(height).append("]+'");
            String s;
            if (na != null)
            {
                s = na.getId();
            } else
            {
                s = "";
            }
            stringbuilder = stringbuilder.append(s).append('\'').append('+').append('\'');
            if (nb != null)
            {
                s = nb.getId();
            } else
            {
                s = "";
            }
            stringbuilder = stringbuilder.append(s).append('\'').append('+').append('\'');
            if (jD != null)
            {
                s = jD.getId();
            } else
            {
                s = "";
            }
            stringbuilder = stringbuilder.append(s).append('\'').append('+').append('\'');
            if (nc != null)
            {
                s = nc.getId();
            } else
            {
                s = "";
            }
            stringbuilder = stringbuilder.append(s).append('\'').append('+').append('\'');
            if (ml != null)
            {
                s = ml.getId();
            } else
            {
                s = "";
            }
            stringbuilder = stringbuilder.append(s).append('\'').append('+').append('\'');
            if (nd != null)
            {
                s = nd.getId();
            } else
            {
                s = "";
            }
            ne = stringbuilder.append(s).append('\'').append('}').toString();
        }
        return ne;
    }

    public final void _mth02CA(MessageDigest messagedigest)
    {
        byte abyte0[] = ByteBuffer.allocate(8).putInt(width).putInt(height).array();
        jt._mth02CA(messagedigest);
        messagedigest.update(id.getBytes("UTF-8"));
        messagedigest.update(abyte0);
        String s;
        if (na != null)
        {
            s = na.getId();
        } else
        {
            s = "";
        }
        messagedigest.update(s.getBytes("UTF-8"));
        if (nb != null)
        {
            s = nb.getId();
        } else
        {
            s = "";
        }
        messagedigest.update(s.getBytes("UTF-8"));
        if (jD != null)
        {
            s = jD.getId();
        } else
        {
            s = "";
        }
        messagedigest.update(s.getBytes("UTF-8"));
        if (nc != null)
        {
            s = nc.getId();
        } else
        {
            s = "";
        }
        messagedigest.update(s.getBytes("UTF-8"));
        if (nd != null)
        {
            s = nd.getId();
        } else
        {
            s = "";
        }
        messagedigest.update(s.getBytes("UTF-8"));
    }
}
