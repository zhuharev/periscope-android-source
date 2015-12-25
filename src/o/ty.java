// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package o:
//            sl, rz

public class ty
{

    final File Tl;
    final String Tm;
    sl Tn;
    File To;
    final Context context;
    final File vD;

    public ty(Context context1, File file, String s, String s1)
    {
        context = context1;
        Tl = file;
        Tm = s1;
        vD = new File(Tl, s);
        Tn = new sl(vD);
        _mth1690();
    }

    public OutputStream _mth02BB(File file)
    {
        return new FileOutputStream(file);
    }

    public void _mth02BE(byte abyte0[])
    {
        Tn._mth02CF(abyte0, 0, abyte0.length);
    }

    void _mth02CB(File file, File file1)
    {
        File file2;
        FileInputStream fileinputstream;
        Object obj;
        obj = null;
        fileinputstream = null;
        file2 = obj;
        FileInputStream fileinputstream1 = new FileInputStream(file);
        file2 = obj;
        fileinputstream = fileinputstream1;
        file1 = _mth02BB(file1);
        file2 = file1;
        fileinputstream = fileinputstream1;
        rz._mth02CA(fileinputstream1, file1, new byte[1024]);
        rz._mth02CA(fileinputstream1, "Failed to close file input stream");
        rz._mth02CA(file1, "Failed to close output stream");
        file.delete();
        return;
        file1;
        rz._mth02CA(fileinputstream, "Failed to close file input stream");
        rz._mth02CA(file2, "Failed to close output stream");
        file.delete();
        throw file1;
    }

    public void _mth02CE(List list)
    {
        File file;
        for (list = list.iterator(); list.hasNext(); file.delete())
        {
            file = (File)list.next();
            rz._mth02BD(context, String.format("deleting sent analytics file %s", new Object[] {
                file.getName()
            }));
        }

    }

    public int _mth1529()
    {
        return Tn._mth148D();
    }

    public boolean _mth152A()
    {
        return Tn.isEmpty();
    }

    public List _mth152E()
    {
        return Arrays.asList(To.listFiles());
    }

    public void _mth1624()
    {
        try
        {
            Tn.close();
        }
        catch (IOException ioexception) { }
        vD.delete();
    }

    void _mth1690()
    {
        To = new File(Tl, Tm);
        if (!To.exists())
        {
            To.mkdirs();
        }
    }

    public void _mth1D53(String s)
    {
        Tn.close();
        _mth02CB(vD, new File(To, s));
        Tn = new sl(vD);
    }

    public boolean _mth1D55(int i, int j)
    {
        return Tn._mth148D() + 4 + i <= j;
    }

    public ArrayList FE91(int i)
    {
        ArrayList arraylist = new ArrayList();
        File afile[] = To.listFiles();
        int j = afile.length;
        for (i = 0; i < j; i++)
        {
            arraylist.add(afile[i]);
            if (arraylist.size() > 0)
            {
                return arraylist;
            }
        }

        return arraylist;
    }
}
