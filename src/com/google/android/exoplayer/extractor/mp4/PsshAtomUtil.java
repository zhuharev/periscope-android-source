// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.mp4;

import com.google.android.exoplayer.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.UUID;

// Referenced classes of package com.google.android.exoplayer.extractor.mp4:
//            Atom

public final class PsshAtomUtil
{

    private PsshAtomUtil()
    {
    }

    public static byte[] buildPsshAtom(UUID uuid, byte abyte0[])
    {
        int i = abyte0.length + 32;
        ByteBuffer bytebuffer = ByteBuffer.allocate(i);
        bytebuffer.putInt(i);
        bytebuffer.putInt(Atom.TYPE_pssh);
        bytebuffer.putInt(0);
        bytebuffer.putLong(uuid.getMostSignificantBits());
        bytebuffer.putLong(uuid.getLeastSignificantBits());
        bytebuffer.putInt(abyte0.length);
        bytebuffer.put(abyte0);
        return bytebuffer.array();
    }

    private static boolean isPsshAtom(ParsableByteArray parsablebytearray, UUID uuid)
    {
        if (parsablebytearray.limit() < 32)
        {
            return false;
        }
        parsablebytearray.setPosition(0);
        if (parsablebytearray.readInt() != parsablebytearray.bytesLeft() + 4)
        {
            return false;
        }
        if (parsablebytearray.readInt() != Atom.TYPE_pssh)
        {
            return false;
        }
        parsablebytearray.setPosition(12);
        if (uuid == null)
        {
            parsablebytearray.skipBytes(16);
        } else
        if (parsablebytearray.readLong() != uuid.getMostSignificantBits() || parsablebytearray.readLong() != uuid.getLeastSignificantBits())
        {
            return false;
        }
        return parsablebytearray.readInt() == parsablebytearray.bytesLeft();
    }

    public static byte[] parseSchemeSpecificData(byte abyte0[], UUID uuid)
    {
        abyte0 = new ParsableByteArray(abyte0);
        if (!isPsshAtom(abyte0, uuid))
        {
            return null;
        } else
        {
            abyte0.setPosition(28);
            int i = abyte0.readInt();
            uuid = new byte[i];
            abyte0.readBytes(uuid, 0, i);
            return uuid;
        }
    }

    public static UUID parseUuid(byte abyte0[])
    {
        abyte0 = new ParsableByteArray(abyte0);
        if (!isPsshAtom(abyte0, null))
        {
            return null;
        } else
        {
            abyte0.setPosition(12);
            return new UUID(abyte0.readLong(), abyte0.readLong());
        }
    }
}
