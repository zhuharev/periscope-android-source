// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.ParserException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;

// Referenced classes of package com.google.android.exoplayer.hls:
//            HlsParserUtil, Subtitle, Variant, HlsMasterPlaylist, 
//            HlsMediaPlaylist, HlsPlaylist

public final class HlsPlaylistParser
    implements com.google.android.exoplayer.upstream.UriLoadable.Parser
{
    static class LineIterator
    {

        private final Queue extraLines;
        private String next;
        private final BufferedReader reader;

        public boolean hasNext()
        {
            if (next != null)
            {
                return true;
            }
            if (!extraLines.isEmpty())
            {
                next = (String)extraLines.poll();
                return true;
            }
            do
            {
                String s = reader.readLine();
                next = s;
                if (s != null)
                {
                    next = next.trim();
                    if (!next.isEmpty())
                    {
                        return true;
                    }
                } else
                {
                    return false;
                }
            } while (true);
        }

        public String next()
        {
            String s = null;
            if (hasNext())
            {
                s = next;
                next = null;
            }
            return s;
        }

        public LineIterator(Queue queue, BufferedReader bufferedreader)
        {
            extraLines = queue;
            reader = bufferedreader;
        }
    }


    private static final String AUDIO_TYPE = "AUDIO";
    private static final String AUTOSELECT_ATTR = "AUTOSELECT";
    private static final Pattern AUTOSELECT_ATTR_REGEX = HlsParserUtil.compileBooleanAttrPattern("AUTOSELECT");
    private static final String BANDWIDTH_ATTR = "BANDWIDTH";
    private static final Pattern BANDWIDTH_ATTR_REGEX = Pattern.compile("BANDWIDTH=(\\d+)\\b");
    private static final Pattern BYTERANGE_REGEX = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final String BYTERANGE_TAG = "#EXT-X-BYTERANGE";
    private static final String CLOSED_CAPTIONS_TYPE = "CLOSED-CAPTIONS";
    private static final String CODECS_ATTR = "CODECS";
    private static final Pattern CODECS_ATTR_REGEX = Pattern.compile("CODECS=\"(.+?)\"");
    private static final String DEFAULT_ATTR = "DEFAULT";
    private static final Pattern DEFAULT_ATTR_REGEX = HlsParserUtil.compileBooleanAttrPattern("DEFAULT");
    private static final String DISCONTINUITY_TAG = "#EXT-X-DISCONTINUITY";
    private static final String ENDLIST_TAG = "#EXT-X-ENDLIST";
    private static final String IV_ATTR = "IV";
    private static final Pattern IV_ATTR_REGEX = Pattern.compile("IV=([^,.*]+)");
    private static final String KEY_TAG = "#EXT-X-KEY";
    private static final String LANGUAGE_ATTR = "LANGUAGE";
    private static final Pattern LANGUAGE_ATTR_REGEX = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern MEDIA_DURATION_REGEX = Pattern.compile("#EXTINF:([\\d.]+)\\b");
    private static final String MEDIA_DURATION_TAG = "#EXTINF";
    private static final Pattern MEDIA_SEQUENCE_REGEX = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final String MEDIA_SEQUENCE_TAG = "#EXT-X-MEDIA-SEQUENCE";
    private static final String MEDIA_TAG = "#EXT-X-MEDIA";
    private static final String METHOD_AES128 = "AES-128";
    private static final String METHOD_ATTR = "METHOD";
    private static final Pattern METHOD_ATTR_REGEX = Pattern.compile("METHOD=(NONE|AES-128)");
    private static final String METHOD_NONE = "NONE";
    private static final String NAME_ATTR = "NAME";
    private static final Pattern NAME_ATTR_REGEX = Pattern.compile("NAME=\"(.+?)\"");
    private static final String RESOLUTION_ATTR = "RESOLUTION";
    private static final Pattern RESOLUTION_ATTR_REGEX = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    private static final String STREAM_INF_TAG = "#EXT-X-STREAM-INF";
    private static final String SUBTITLES_TYPE = "SUBTITLES";
    private static final Pattern TARGET_DURATION_REGEX = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    private static final String TARGET_DURATION_TAG = "#EXT-X-TARGETDURATION";
    private static final String TYPE_ATTR = "TYPE";
    private static final Pattern TYPE_ATTR_REGEX = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final String URI_ATTR = "URI";
    private static final Pattern URI_ATTR_REGEX = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern VERSION_REGEX = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    private static final String VERSION_TAG = "#EXT-X-VERSION";
    private static final String VIDEO_TYPE = "VIDEO";

    public HlsPlaylistParser()
    {
    }

    private static HlsMasterPlaylist parseMasterPlaylist(LineIterator lineiterator, String s)
    {
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        int i = 0;
        String s1 = null;
        int j = -1;
        int k = -1;
        int l = 0;
        do
        {
            if (!lineiterator.hasNext())
            {
                break;
            }
            Object obj = lineiterator.next();
            if (((String) (obj)).startsWith("#EXT-X-MEDIA"))
            {
                if ("SUBTITLES".equals(HlsParserUtil.parseStringAttr(((String) (obj)), TYPE_ATTR_REGEX, "TYPE")))
                {
                    arraylist1.add(new Subtitle(HlsParserUtil.parseStringAttr(((String) (obj)), NAME_ATTR_REGEX, "NAME"), HlsParserUtil.parseStringAttr(((String) (obj)), URI_ATTR_REGEX, "URI"), HlsParserUtil.parseOptionalStringAttr(((String) (obj)), LANGUAGE_ATTR_REGEX), HlsParserUtil.parseOptionalBooleanAttr(((String) (obj)), DEFAULT_ATTR_REGEX), HlsParserUtil.parseOptionalBooleanAttr(((String) (obj)), AUTOSELECT_ATTR_REGEX)));
                }
            } else
            if (((String) (obj)).startsWith("#EXT-X-STREAM-INF"))
            {
                l = HlsParserUtil.parseIntAttr(((String) (obj)), BANDWIDTH_ATTR_REGEX, "BANDWIDTH");
                s1 = HlsParserUtil.parseOptionalStringAttr(((String) (obj)), CODECS_ATTR_REGEX);
                obj = HlsParserUtil.parseOptionalStringAttr(((String) (obj)), RESOLUTION_ATTR_REGEX);
                if (obj != null)
                {
                    obj = ((String) (obj)).split("x");
                    j = Integer.parseInt(obj[0]);
                    i = j;
                    if (j <= 0)
                    {
                        i = -1;
                    }
                    j = Integer.parseInt(obj[1]);
                    k = j;
                    if (j <= 0)
                    {
                        k = -1;
                    }
                    j = i;
                } else
                {
                    j = -1;
                    k = -1;
                }
                boolean flag = true;
                i = l;
                l = ((flag) ? 1 : 0);
            } else
            if (!((String) (obj)).startsWith("#") && l != 0)
            {
                arraylist.add(new Variant(arraylist.size(), ((String) (obj)), i, s1, j, k));
                i = 0;
                s1 = null;
                j = -1;
                k = -1;
                l = 0;
            }
        } while (true);
        return new HlsMasterPlaylist(s, Collections.unmodifiableList(arraylist), Collections.unmodifiableList(arraylist1));
    }

    private static HlsMediaPlaylist parseMediaPlaylist(LineIterator lineiterator, String s)
    {
        ArrayList arraylist;
        int l;
        int i1;
        int j1;
        boolean flag2;
label0:
        {
            j1 = 0;
            i1 = 0;
            l = 1;
            boolean flag3 = true;
            arraylist = new ArrayList();
            double d = 0.0D;
            boolean flag = false;
            long l1 = 0L;
            int i = 0;
            int j = -1;
            int k = 0;
            boolean flag1 = false;
            String s2 = null;
            String s1 = null;
            String s4;
label1:
            do
            {
                do
                {
                    flag2 = flag3;
                    if (!lineiterator.hasNext())
                    {
                        break label0;
                    }
                    s4 = lineiterator.next();
                    if (s4.startsWith("#EXT-X-TARGETDURATION"))
                    {
                        i1 = HlsParserUtil.parseIntAttr(s4, TARGET_DURATION_REGEX, "#EXT-X-TARGETDURATION");
                    } else
                    if (s4.startsWith("#EXT-X-MEDIA-SEQUENCE"))
                    {
                        k = HlsParserUtil.parseIntAttr(s4, MEDIA_SEQUENCE_REGEX, "#EXT-X-MEDIA-SEQUENCE");
                        j1 = k;
                    } else
                    if (s4.startsWith("#EXT-X-VERSION"))
                    {
                        l = HlsParserUtil.parseIntAttr(s4, VERSION_REGEX, "#EXT-X-VERSION");
                    } else
                    if (s4.startsWith("#EXTINF"))
                    {
                        d = HlsParserUtil.parseDoubleAttr(s4, MEDIA_DURATION_REGEX, "#EXTINF");
                    } else
                    if (s4.startsWith("#EXT-X-KEY"))
                    {
                        flag2 = "AES-128".equals(HlsParserUtil.parseStringAttr(s4, METHOD_ATTR_REGEX, "METHOD"));
                        flag1 = flag2;
                        if (flag2)
                        {
                            s2 = HlsParserUtil.parseStringAttr(s4, URI_ATTR_REGEX, "URI");
                            s1 = HlsParserUtil.parseOptionalStringAttr(s4, IV_ATTR_REGEX);
                        } else
                        {
                            s2 = null;
                            s1 = null;
                        }
                    } else
                    if (s4.startsWith("#EXT-X-BYTERANGE"))
                    {
                        String as[] = HlsParserUtil.parseStringAttr(s4, BYTERANGE_REGEX, "#EXT-X-BYTERANGE").split("@");
                        j = Integer.parseInt(as[0]);
                        if (as.length > 1)
                        {
                            i = Integer.parseInt(as[1]);
                        }
                    } else
                    if (s4.equals("#EXT-X-DISCONTINUITY"))
                    {
                        flag = true;
                    } else
                    {
                        if (s4.startsWith("#"))
                        {
                            continue label1;
                        }
                        String s3;
                        if (!flag1)
                        {
                            s3 = null;
                        } else
                        if (s1 != null)
                        {
                            s3 = s1;
                        } else
                        {
                            s3 = Integer.toHexString(k);
                        }
                        int k1 = k + 1;
                        k = i;
                        if (j == -1)
                        {
                            k = 0;
                        }
                        arraylist.add(new HlsMediaPlaylist.Segment(s4, d, flag, l1, flag1, s2, s3, k, j));
                        l1 += (long)(1000000D * d);
                        flag = false;
                        d = 0.0D;
                        i = k;
                        if (j != -1)
                        {
                            i = k + j;
                        }
                        j = -1;
                        k = k1;
                    }
                } while (true);
            } while (!s4.equals("#EXT-X-ENDLIST"));
            flag2 = false;
        }
        return new HlsMediaPlaylist(s, j1, i1, l, flag2, Collections.unmodifiableList(arraylist));
    }

    public final HlsPlaylist parse(String s, InputStream inputstream)
    {
        LinkedList linkedlist;
        inputstream = new BufferedReader(new InputStreamReader(inputstream));
        linkedlist = new LinkedList();
_L2:
        String s1 = inputstream.readLine();
        if (s1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = s1.trim();
        if (s1.isEmpty())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!s1.startsWith("#EXT-X-STREAM-INF"))
        {
            break MISSING_BLOCK_LABEL_89;
        }
        linkedlist.add(s1);
        s = parseMasterPlaylist(new LineIterator(linkedlist, inputstream), s);
        inputstream.close();
        return s;
        if (!s1.startsWith("#EXT-X-TARGETDURATION") && !s1.startsWith("#EXT-X-MEDIA-SEQUENCE") && !s1.startsWith("#EXTINF") && !s1.startsWith("#EXT-X-KEY") && !s1.startsWith("#EXT-X-BYTERANGE") && !s1.equals("#EXT-X-DISCONTINUITY") && !s1.equals("#EXT-X-ENDLIST"))
        {
            break MISSING_BLOCK_LABEL_188;
        }
        linkedlist.add(s1);
        s = parseMediaPlaylist(new LineIterator(linkedlist, inputstream), s);
        inputstream.close();
        return s;
        linkedlist.add(s1);
        if (true) goto _L2; else goto _L1
_L1:
        inputstream.close();
        break MISSING_BLOCK_LABEL_214;
        s;
        inputstream.close();
        throw s;
        throw new ParserException("Failed to parse the playlist, could not identify any tags.");
    }

    public final volatile Object parse(String s, InputStream inputstream)
    {
        return parse(s, inputstream);
    }

}
