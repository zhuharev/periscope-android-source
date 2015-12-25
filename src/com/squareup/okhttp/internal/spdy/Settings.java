// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import java.util.Arrays;

public final class Settings
{

    static final int CLIENT_CERTIFICATE_VECTOR_SIZE = 8;
    static final int COUNT = 10;
    static final int CURRENT_CWND = 5;
    static final int DEFAULT_INITIAL_WINDOW_SIZE = 0x10000;
    static final int DOWNLOAD_BANDWIDTH = 2;
    static final int DOWNLOAD_RETRANS_RATE = 6;
    static final int ENABLE_PUSH = 2;
    static final int FLAG_CLEAR_PREVIOUSLY_PERSISTED_SETTINGS = 1;
    static final int FLOW_CONTROL_OPTIONS = 10;
    static final int FLOW_CONTROL_OPTIONS_DISABLED = 1;
    static final int HEADER_TABLE_SIZE = 1;
    static final int INITIAL_WINDOW_SIZE = 7;
    static final int MAX_CONCURRENT_STREAMS = 4;
    static final int MAX_FRAME_SIZE = 5;
    static final int MAX_HEADER_LIST_SIZE = 6;
    static final int PERSISTED = 2;
    static final int PERSIST_VALUE = 1;
    static final int ROUND_TRIP_TIME = 3;
    static final int UPLOAD_BANDWIDTH = 1;
    private int persistValue;
    private int persisted;
    private int set;
    private final int values[] = new int[10];

    public Settings()
    {
    }

    final void clear()
    {
        persisted = 0;
        persistValue = 0;
        set = 0;
        Arrays.fill(values, 0);
    }

    final int flags(int i)
    {
        byte byte0 = 0;
        if (isPersisted(i))
        {
            byte0 = 2;
        }
        int j = byte0;
        if (persistValue(i))
        {
            j = byte0 | 1;
        }
        return j;
    }

    final int get(int i)
    {
        return values[i];
    }

    final int getClientCertificateVectorSize(int i)
    {
        if ((set & 0x100) != 0)
        {
            return values[8];
        } else
        {
            return i;
        }
    }

    final int getCurrentCwnd(int i)
    {
        if ((set & 0x20) != 0)
        {
            return values[5];
        } else
        {
            return i;
        }
    }

    final int getDownloadBandwidth(int i)
    {
        if ((set & 4) != 0)
        {
            return values[2];
        } else
        {
            return i;
        }
    }

    final int getDownloadRetransRate(int i)
    {
        if ((set & 0x40) != 0)
        {
            return values[6];
        } else
        {
            return i;
        }
    }

    final boolean getEnablePush(boolean flag)
    {
        int i;
        if ((set & 4) != 0)
        {
            i = values[2];
        } else
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return i == 1;
    }

    final int getHeaderTableSize()
    {
        if ((set & 2) != 0)
        {
            return values[1];
        } else
        {
            return -1;
        }
    }

    final int getInitialWindowSize(int i)
    {
        if ((set & 0x80) != 0)
        {
            return values[7];
        } else
        {
            return i;
        }
    }

    final int getMaxConcurrentStreams(int i)
    {
        if ((set & 0x10) != 0)
        {
            return values[4];
        } else
        {
            return i;
        }
    }

    final int getMaxFrameSize(int i)
    {
        if ((set & 0x20) != 0)
        {
            return values[5];
        } else
        {
            return i;
        }
    }

    final int getMaxHeaderListSize(int i)
    {
        if ((set & 0x40) != 0)
        {
            return values[6];
        } else
        {
            return i;
        }
    }

    final int getRoundTripTime(int i)
    {
        if ((set & 8) != 0)
        {
            return values[3];
        } else
        {
            return i;
        }
    }

    final int getUploadBandwidth(int i)
    {
        if ((set & 2) != 0)
        {
            return values[1];
        } else
        {
            return i;
        }
    }

    final boolean isFlowControlDisabled()
    {
        int i;
        if ((set & 0x400) != 0)
        {
            i = values[10];
        } else
        {
            i = 0;
        }
        return (i & 1) != 0;
    }

    final boolean isPersisted(int i)
    {
        return (persisted & 1 << i) != 0;
    }

    final boolean isSet(int i)
    {
        return (set & 1 << i) != 0;
    }

    final void merge(Settings settings)
    {
        for (int i = 0; i < 10; i++)
        {
            if (settings.isSet(i))
            {
                set(i, settings.flags(i), settings.get(i));
            }
        }

    }

    final boolean persistValue(int i)
    {
        return (persistValue & 1 << i) != 0;
    }

    final Settings set(int i, int j, int k)
    {
        if (i >= values.length)
        {
            return this;
        }
        int l = 1 << i;
        set = set | l;
        if ((j & 1) != 0)
        {
            persistValue = persistValue | l;
        } else
        {
            persistValue = persistValue & ~l;
        }
        if ((j & 2) != 0)
        {
            persisted = persisted | l;
        } else
        {
            persisted = persisted & ~l;
        }
        values[i] = k;
        return this;
    }

    final int size()
    {
        return Integer.bitCount(set);
    }
}
