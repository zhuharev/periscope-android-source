// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.gmss;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Vector;
import org.spongycastle.crypto.Digest;
import org.spongycastle.util.Integers;
import org.spongycastle.util.encoders.Hex;

// Referenced classes of package org.spongycastle.pqc.crypto.gmss:
//            GMSSDigestProvider, Treehash

public class GMSSRootCalc
{

    private int aKM[];
    private GMSSDigestProvider aLe;
    private int aLh;
    private int aLk;
    Treehash aLl[];
    Vector aLm[];
    byte aLn[];
    byte aLo[][];
    private int aLp;
    private Vector aLq;
    private Vector aLr;
    private Digest aLs;
    private boolean aLt;
    boolean aLu;
    private int aLv;
    private int aLw;

    public GMSSRootCalc(int i, int j, GMSSDigestProvider gmssdigestprovider)
    {
        aLk = i;
        aLe = gmssdigestprovider;
        aLs = gmssdigestprovider._mth05EA();
        aLh = aLs._mth14AF();
        aLp = j;
        aKM = new int[i];
        int k = aLh;
        aLo = (byte[][])Array.newInstance(Byte.TYPE, new int[] {
            i, k
        });
        aLn = new byte[aLh];
        aLm = new Vector[aLp - 1];
        for (i = 0; i < j - 1; i++)
        {
            aLm[i] = new Vector();
        }

    }

    private byte[][] _mth067D()
    {
        int i;
        if (aLq == null)
        {
            i = 0;
        } else
        {
            i = aLq.size();
        }
        int j = aLk;
        byte abyte0[][] = (byte[][])Array.newInstance(Byte.TYPE, new int[] {
            j + 1 + i, 64
        });
        abyte0[0] = aLn;
        for (int k = 0; k < aLk; k++)
        {
            abyte0[k + 1] = aLo[k];
        }

        for (int l = 0; l < i; l++)
        {
            abyte0[aLk + 1 + l] = (byte[])aLq.elementAt(l);
        }

        return abyte0;
    }

    private int[] _mth067E()
    {
        int i;
        if (aLq == null)
        {
            i = 0;
        } else
        {
            i = aLq.size();
        }
        int ai[] = new int[aLk + 8 + i];
        ai[0] = aLk;
        ai[1] = aLh;
        ai[2] = aLp;
        ai[3] = aLv;
        ai[4] = 0;
        if (aLu)
        {
            ai[5] = 1;
        } else
        {
            ai[5] = 0;
        }
        if (aLt)
        {
            ai[6] = 1;
        } else
        {
            ai[6] = 0;
        }
        ai[7] = i;
        for (int j = 0; j < aLk; j++)
        {
            ai[j + 8] = aKM[j];
        }

        for (int k = 0; k < i; k++)
        {
            ai[aLk + 8 + k] = ((Integer)aLr.elementAt(k)).intValue();
        }

        return ai;
    }

    public String toString()
    {
        String s = "";
        int i;
        if (aLq == null)
        {
            i = 0;
        } else
        {
            i = aLq.size();
        }
        for (int j = 0; j < aLk + 8 + i; j++)
        {
            s = (new StringBuilder()).append(s).append(_mth067E()[j]).append(" ").toString();
        }

        for (int k = 0; k < aLk + 1 + i; k++)
        {
            s = (new StringBuilder()).append(s).append(new String(Hex._mth1D65(_mth067D()[k]))).append(" ").toString();
        }

        return (new StringBuilder()).append(s).append("  ").append(aLe._mth05EA()._mth14AF()).toString();
    }

    public final void update(byte abyte0[])
    {
        if (aLu)
        {
            System.out.print("Too much updates for Tree!!");
            return;
        }
        if (!aLt)
        {
            System.err.println("GMSSRootCalc not initialized!");
            return;
        }
        int ai[] = aKM;
        ai[0] = ai[0] + 1;
        if (aKM[0] == 1)
        {
            System.arraycopy(abyte0, 0, aLo[0], 0, aLh);
        } else
        if (aKM[0] == 3 && aLk > aLp)
        {
            Treehash treehash = aLl[0];
            if (!treehash.aLt)
            {
                treehash.initialize();
            }
            treehash.aLI = abyte0;
            treehash.aLM = treehash.maxHeight;
            treehash.aLu = true;
        }
        if ((aKM[0] - 3) % 2 == 0 && aKM[0] >= 3 && aLk == aLp)
        {
            aLm[0].insertElementAt(abyte0, 0);
        }
        if (aKM[0] == 0)
        {
            aLq.addElement(abyte0);
            aLr.addElement(Integers.valueOf(0));
            return;
        }
        treehash = new byte[aLh];
        byte abyte2[] = new byte[aLh << 1];
        System.arraycopy(abyte0, 0, treehash, 0, aLh);
        int i = 0;
        abyte0 = treehash;
        do
        {
            if (aLq.size() <= 0 || i != ((Integer)aLr.lastElement()).intValue())
            {
                break;
            }
            System.arraycopy(aLq.lastElement(), 0, abyte2, 0, aLh);
            aLq.removeElementAt(aLq.size() - 1);
            aLr.removeElementAt(aLr.size() - 1);
            System.arraycopy(abyte0, 0, abyte2, aLh, aLh);
            aLs.update(abyte2, 0, abyte2.length);
            byte abyte1[] = new byte[aLs._mth14AF()];
            aLs.doFinal(abyte1, 0);
            int j = i + 1;
            abyte0 = abyte1;
            i = j;
            if (j < aLk)
            {
                abyte0 = aKM;
                abyte0[j] = abyte0[j] + 1;
                if (aKM[j] == 1)
                {
                    System.arraycopy(abyte1, 0, aLo[j], 0, aLh);
                }
                if (j >= aLk - aLp)
                {
                    if (j == 0)
                    {
                        System.out.println("M\uFFFD\uFFFD\uFFFDP");
                    }
                    abyte0 = abyte1;
                    i = j;
                    if ((aKM[j] - 3) % 2 == 0)
                    {
                        abyte0 = abyte1;
                        i = j;
                        if (aKM[j] >= 3)
                        {
                            aLm[j - (aLk - aLp)].insertElementAt(abyte1, 0);
                            abyte0 = abyte1;
                            i = j;
                        }
                    }
                } else
                {
                    abyte0 = abyte1;
                    i = j;
                    if (aKM[j] == 3)
                    {
                        abyte0 = aLl[j];
                        if (!((Treehash) (abyte0)).aLt)
                        {
                            abyte0.initialize();
                        }
                        abyte0.aLI = abyte1;
                        abyte0.aLM = ((Treehash) (abyte0)).maxHeight;
                        abyte0.aLu = true;
                        abyte0 = abyte1;
                        i = j;
                    }
                }
            }
        } while (true);
        aLq.addElement(abyte0);
        aLr.addElement(Integers.valueOf(i));
        if (i == aLk)
        {
            aLu = true;
            aLt = false;
            aLn = (byte[])aLq.lastElement();
        }
    }

    public final void _mth02CF(Vector vector)
    {
        aLl = new Treehash[aLk - aLp];
        for (int i = 0; i < aLk - aLp; i++)
        {
            aLl[i] = new Treehash(vector, i, aLe._mth05EA());
        }

        aKM = new int[aLk];
        int j = aLk;
        int i1 = aLh;
        aLo = (byte[][])Array.newInstance(Byte.TYPE, new int[] {
            j, i1
        });
        aLn = new byte[aLh];
        aLq = new Vector();
        aLr = new Vector();
        aLt = true;
        aLu = false;
        for (int k = 0; k < aLk; k++)
        {
            aKM[k] = -1;
        }

        aLm = new Vector[aLp - 1];
        for (int l = 0; l < aLp - 1; l++)
        {
            aLm[l] = new Vector();
        }

        aLv = 3;
        aLw = 0;
    }
}
