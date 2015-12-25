// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

public class TypedFiles
    implements TypedInput, TypedOutput
{

    private static final int BUFFER_SIZE = 4096;
    private final String mFilename;
    private final File mFiles[];

    public TypedFiles(File afile[], String s)
    {
        mFiles = afile;
        mFilename = s;
    }

    private InputStream getInputStream()
    {
        ArrayList arraylist = new ArrayList(mFiles.length);
        File afile[] = mFiles;
        int j = afile.length;
        for (int i = 0; i < j; i++)
        {
            arraylist.add(new FileInputStream(afile[i]));
        }

        return new SequenceInputStream(Collections.enumeration(arraylist));
    }

    public String fileName()
    {
        return mFilename;
    }

    public InputStream in()
    {
        return getInputStream();
    }

    public long length()
    {
        int j = 0;
        File afile[] = mFiles;
        int k = afile.length;
        for (int i = 0; i < k; i++)
        {
            File file = afile[i];
            j = (int)((long)j + file.length());
        }

        return (long)j;
    }

    public String mimeType()
    {
        return "text/plain; charset=UTF-8";
    }

    public void writeTo(OutputStream outputstream)
    {
        InputStream inputstream;
        byte abyte0[];
        abyte0 = new byte[4096];
        inputstream = getInputStream();
_L2:
        int i = inputstream.read(abyte0);
        if (i == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        outputstream.write(abyte0, 0, i);
        if (true) goto _L2; else goto _L1
_L1:
        inputstream.close();
        return;
        outputstream;
        inputstream.close();
        throw outputstream;
    }
}
