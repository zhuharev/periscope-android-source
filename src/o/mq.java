// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

// Referenced classes of package o:
//            mr, kb, mu, ms

public class mq
    implements Closeable
{

    private static final char Jt[] = ")]}'\n".toCharArray();
    private int JA;
    private String JB;
    private int JC[];
    private int JD;
    private String JE[];
    private int JF[];
    public boolean Ju;
    private final char Jv[] = new char[1024];
    private int Jw;
    private int Jx;
    private int Jy;
    private long Jz;
    private final Reader in;
    private int limit;
    private int pos;

    public mq(Reader reader)
    {
        Ju = false;
        pos = 0;
        limit = 0;
        Jw = 0;
        Jx = 0;
        Jy = 0;
        JC = new int[32];
        JD = 0;
        int ai[] = JC;
        int i = JD;
        JD = i + 1;
        ai[i] = 6;
        JE = new String[32];
        JF = new int[32];
        if (reader == null)
        {
            throw new NullPointerException("in == null");
        } else
        {
            in = reader;
            return;
        }
    }

    private int _mth0131(boolean flag)
    {
        char ac[] = Jv;
        int i = pos;
        int j = limit;
label0:
        do
        {
            do
            {
                int l = i;
                int k = j;
                if (i == j)
                {
                    pos = i;
                    if (!_mth1551(1))
                    {
                        break;
                    }
                    l = pos;
                    k = limit;
                }
                int i1 = l + 1;
                l = ac[l];
                if (l == '\n')
                {
                    Jw = Jw + 1;
                    Jx = i1;
                    i = i1;
                    j = k;
                } else
                {
                    i = i1;
                    j = k;
                    if (l != ' ')
                    {
                        i = i1;
                        j = k;
                        if (l != '\r')
                        {
                            i = i1;
                            j = k;
                            if (l != '\t')
                            {
                                if (l == '/')
                                {
                                    pos = i1;
                                    if (i1 == k)
                                    {
                                        pos = pos - 1;
                                        boolean flag1 = _mth1551(2);
                                        pos = pos + 1;
                                        if (!flag1)
                                        {
                                            return l;
                                        }
                                    }
                                    if (!Ju)
                                    {
                                        throw _mth14BD("Use JsonReader.setLenient(true) to accept malformed JSON");
                                    }
                                    switch (ac[pos])
                                    {
                                    default:
                                        return l;

                                    case 42: // '*'
                                        pos = pos + 1;
                                        if (!_mth142A("*/"))
                                        {
                                            throw _mth14BD("Unterminated comment");
                                        }
                                        i = pos + 2;
                                        j = limit;
                                        break;

                                    case 47: // '/'
                                        pos = pos + 1;
                                        _mth1500();
                                        i = pos;
                                        j = limit;
                                        break;
                                    }
                                } else
                                if (l == '#')
                                {
                                    pos = i1;
                                    if (!Ju)
                                    {
                                        throw _mth14BD("Use JsonReader.setLenient(true) to accept malformed JSON");
                                    }
                                    _mth1500();
                                    i = pos;
                                    j = limit;
                                } else
                                {
                                    pos = i1;
                                    return l;
                                }
                                continue label0;
                            }
                        }
                    }
                }
            } while (true);
            if (flag)
            {
                throw new EOFException((new StringBuilder("End of input at line ")).append(Jw + 1).append(" column ").append((pos - Jx) + 1).toString());
            } else
            {
                return -1;
            }
        } while (true);
    }

    static int _mth02C9(mq mq1)
    {
        return mq1.Jy;
    }

    static int _mth02CA(mq mq1, int i)
    {
        mq1.Jy = i;
        return i;
    }

    private boolean _mth02CA(char c)
    {
        switch (c)
        {
        case 35: // '#'
        case 47: // '/'
        case 59: // ';'
        case 61: // '='
        case 92: // '\\'
            if (!Ju)
            {
                throw _mth14BD("Use JsonReader.setLenient(true) to accept malformed JSON");
            }
            // fall through

        case 9: // '\t'
        case 10: // '\n'
        case 12: // '\f'
        case 13: // '\r'
        case 32: // ' '
        case 44: // ','
        case 58: // ':'
        case 91: // '['
        case 93: // ']'
        case 123: // '{'
        case 125: // '}'
            return false;

        default:
            return true;
        }
    }

    private String _mth02CB(char c)
    {
        char ac[] = Jv;
        StringBuilder stringbuilder = new StringBuilder();
        do
        {
            int i = pos;
            int j = limit;
            int k = i;
            int l;
            do
            {
                l = i;
                if (l >= j)
                {
                    break;
                }
                i = l + 1;
                l = ac[l];
                if (l == c)
                {
                    pos = i;
                    stringbuilder.append(ac, k, i - k - 1);
                    return stringbuilder.toString();
                }
                if (l == 92)
                {
                    pos = i;
                    stringbuilder.append(ac, k, i - k - 1);
                    stringbuilder.append(_mth1501());
                    i = pos;
                    j = limit;
                    k = i;
                } else
                if (l == 10)
                {
                    Jw = Jw + 1;
                    Jx = i;
                }
            } while (true);
            stringbuilder.append(ac, k, l - k);
            pos = l;
        } while (_mth1551(1));
        throw _mth14BD("Unterminated string");
    }

    static int _mth02CC(mq mq1)
    {
        return mq1._mth14F8();
    }

    static int _mth02CD(mq mq1)
    {
        return mq1.Jw + 1;
    }

    private void _mth02CE(char c)
    {
        char ac[] = Jv;
        do
        {
            int i = pos;
            int j = limit;
            int k;
            do
            {
                k = i;
                if (k >= j)
                {
                    break;
                }
                i = k + 1;
                k = ac[k];
                if (k == c)
                {
                    pos = i;
                    return;
                }
                if (k == 92)
                {
                    pos = i;
                    _mth1501();
                    i = pos;
                    j = limit;
                } else
                if (k == 10)
                {
                    Jw = Jw + 1;
                    Jx = i;
                }
            } while (true);
            pos = k;
        } while (_mth1551(1));
        throw _mth14BD("Unterminated string");
    }

    static int _mth02D1(mq mq1)
    {
        return (mq1.pos - mq1.Jx) + 1;
    }

    private boolean _mth142A(String s)
    {
label0:
        for (; pos + s.length() <= limit || _mth1551(s.length()); pos = pos + 1)
        {
            if (Jv[pos] == '\n')
            {
                Jw = Jw + 1;
                Jx = pos + 1;
                continue;
            }
            for (int i = 0; i < s.length(); i++)
            {
                if (Jv[pos + i] != s.charAt(i))
                {
                    continue label0;
                }
            }

            return true;
        }

        return false;
    }

    private IOException _mth14BD(String s)
    {
        throw new mu((new StringBuilder()).append(s).append(" at line ").append(Jw + 1).append(" column ").append((pos - Jx) + 1).append(" path ").append(getPath()).toString());
    }

    private int _mth14F8()
    {
        int i = JC[JD - 1];
        if (i == 1)
        {
            JC[JD - 1] = 2;
        } else
        if (i == 2)
        {
            switch (_mth0131(true))
            {
            case 93: // ']'
                Jy = 4;
                return 4;

            case 59: // ';'
                if (!Ju)
                {
                    throw _mth14BD("Use JsonReader.setLenient(true) to accept malformed JSON");
                }
                break;

            default:
                throw _mth14BD("Unterminated array");

            case 44: // ','
                break;
            }
        } else
        {
            if (i == 3 || i == 5)
            {
                JC[JD - 1] = 4;
                if (i == 5)
                {
                    switch (_mth0131(true))
                    {
                    case 125: // '}'
                        Jy = 2;
                        return 2;

                    case 59: // ';'
                        if (!Ju)
                        {
                            throw _mth14BD("Use JsonReader.setLenient(true) to accept malformed JSON");
                        }
                        break;

                    default:
                        throw _mth14BD("Unterminated object");

                    case 44: // ','
                        break;
                    }
                }
                int j = _mth0131(true);
                switch (j)
                {
                case 34: // '"'
                    Jy = 13;
                    return 13;

                case 39: // '\''
                    if (!Ju)
                    {
                        throw _mth14BD("Use JsonReader.setLenient(true) to accept malformed JSON");
                    } else
                    {
                        Jy = 12;
                        return 12;
                    }

                case 125: // '}'
                    if (i != 5)
                    {
                        Jy = 2;
                        return 2;
                    } else
                    {
                        throw _mth14BD("Expected name");
                    }
                }
                if (!Ju)
                {
                    throw _mth14BD("Use JsonReader.setLenient(true) to accept malformed JSON");
                }
                pos = pos - 1;
                if (_mth02CA((char)j))
                {
                    Jy = 14;
                    return 14;
                } else
                {
                    throw _mth14BD("Expected name");
                }
            }
            if (i == 4)
            {
                JC[JD - 1] = 5;
                switch (_mth0131(true))
                {
                case 61: // '='
                    if (!Ju)
                    {
                        throw _mth14BD("Use JsonReader.setLenient(true) to accept malformed JSON");
                    }
                    if ((pos < limit || _mth1551(1)) && Jv[pos] == '>')
                    {
                        pos = pos + 1;
                    }
                    break;

                default:
                    throw _mth14BD("Expected ':'");

                case 58: // ':'
                    break;
                }
            } else
            if (i == 6)
            {
                if (Ju)
                {
                    _mth1504();
                }
                JC[JD - 1] = 7;
            } else
            if (i == 7)
            {
                if (_mth0131(false) == -1)
                {
                    Jy = 17;
                    return 17;
                }
                if (!Ju)
                {
                    throw _mth14BD("Use JsonReader.setLenient(true) to accept malformed JSON");
                }
                pos = pos - 1;
            } else
            if (i == 8)
            {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        switch (_mth0131(true))
        {
        case 93: // ']'
            if (i == 1)
            {
                Jy = 4;
                return 4;
            }
            // fall through

        case 44: // ','
        case 59: // ';'
            if (i == 1 || i == 2)
            {
                if (!Ju)
                {
                    throw _mth14BD("Use JsonReader.setLenient(true) to accept malformed JSON");
                } else
                {
                    pos = pos - 1;
                    Jy = 7;
                    return 7;
                }
            } else
            {
                throw _mth14BD("Unexpected value");
            }

        case 39: // '\''
            if (!Ju)
            {
                throw _mth14BD("Use JsonReader.setLenient(true) to accept malformed JSON");
            } else
            {
                Jy = 8;
                return 8;
            }

        case 34: // '"'
            if (JD == 1 && !Ju)
            {
                throw _mth14BD("Use JsonReader.setLenient(true) to accept malformed JSON");
            } else
            {
                Jy = 9;
                return 9;
            }

        case 91: // '['
            Jy = 3;
            return 3;

        case 123: // '{'
            Jy = 1;
            return 1;

        default:
            pos = pos - 1;
            break;
        }
        if (JD == 1 && !Ju)
        {
            throw _mth14BD("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
        i = _mth14F9();
        if (i != 0)
        {
            return i;
        }
        i = _mth14FC();
        if (i != 0)
        {
            return i;
        }
        if (!_mth02CA(Jv[pos]))
        {
            throw _mth14BD("Expected value");
        }
        if (!Ju)
        {
            throw _mth14BD("Use JsonReader.setLenient(true) to accept malformed JSON");
        } else
        {
            Jy = 10;
            return 10;
        }
    }

    private int _mth14F9()
    {
        int i = Jv[pos];
        String s;
        String s1;
        if (i == 116 || i == 84)
        {
            s = "true";
            s1 = "TRUE";
            i = 5;
        } else
        if (i == 102 || i == 70)
        {
            s = "false";
            s1 = "FALSE";
            i = 6;
        } else
        if (i == 110 || i == 78)
        {
            s = "null";
            s1 = "NULL";
            i = 7;
        } else
        {
            return 0;
        }
        int k = s.length();
        for (int j = 1; j < k; j++)
        {
            if (pos + j >= limit && !_mth1551(j + 1))
            {
                return 0;
            }
            char c = Jv[pos + j];
            if (c != s.charAt(j) && c != s1.charAt(j))
            {
                return 0;
            }
        }

        if ((pos + k < limit || _mth1551(k + 1)) && _mth02CA(Jv[pos + k]))
        {
            return 0;
        } else
        {
            pos = pos + k;
            Jy = i;
            return i;
        }
    }

    private int _mth14FC()
    {
        char ac[] = Jv;
        int i2 = pos;
        int l1 = limit;
        long l2 = 0L;
        boolean flag = false;
        int k = 1;
        int j1 = 0;
        int j = 0;
label0:
        do
        {
            int i1 = i2;
            int l = l1;
            if (i2 + j == l1)
            {
                if (j == 1024)
                {
                    return 0;
                }
                if (!_mth1551(j + 1))
                {
                    break;
                }
                i1 = pos;
                l = limit;
            }
            char c = ac[i1 + j];
            int i;
            boolean flag1;
            int k1;
            long l3;
            switch (c)
            {
            case 45: // '-'
                if (j1 == 0)
                {
                    flag1 = true;
                    i = 1;
                    l3 = l2;
                    k1 = k;
                    break;
                }
                if (j1 == 5)
                {
                    i = 6;
                    l3 = l2;
                    flag1 = flag;
                    k1 = k;
                } else
                {
                    return 0;
                }
                break;

            case 43: // '+'
                if (j1 == 5)
                {
                    i = 6;
                    l3 = l2;
                    flag1 = flag;
                    k1 = k;
                } else
                {
                    return 0;
                }
                break;

            case 69: // 'E'
            case 101: // 'e'
                if (j1 == 2 || j1 == 4)
                {
                    i = 5;
                    l3 = l2;
                    flag1 = flag;
                    k1 = k;
                } else
                {
                    return 0;
                }
                break;

            case 46: // '.'
                if (j1 == 2)
                {
                    i = 3;
                    l3 = l2;
                    flag1 = flag;
                    k1 = k;
                } else
                {
                    return 0;
                }
                break;

            default:
                if (c < '0' || c > '9')
                {
                    if (_mth02CA(c))
                    {
                        return 0;
                    }
                    break label0;
                }
                if (j1 == 1 || j1 == 0)
                {
                    l3 = -(c - 48);
                    i = 2;
                    flag1 = flag;
                    k1 = k;
                    break;
                }
                if (j1 == 2)
                {
                    if (l2 == 0L)
                    {
                        return 0;
                    }
                    l3 = 10L * l2 - (long)(c - 48);
                    if (l2 > 0xf333333333333334L || l2 == 0xf333333333333334L && l3 < l2)
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                    k1 = k & i;
                    flag1 = flag;
                    i = j1;
                    break;
                }
                if (j1 == 3)
                {
                    i = 4;
                    l3 = l2;
                    flag1 = flag;
                    k1 = k;
                    break;
                }
                if (j1 != 5)
                {
                    l3 = l2;
                    flag1 = flag;
                    k1 = k;
                    i = j1;
                    if (j1 != 6)
                    {
                        break;
                    }
                }
                i = 7;
                k1 = k;
                flag1 = flag;
                l3 = l2;
                break;
            }
            j++;
            i2 = i1;
            l1 = l;
            l2 = l3;
            flag = flag1;
            k = k1;
            j1 = i;
        } while (true);
        if (j1 == 2 && k != 0 && (l2 != 0x8000000000000000L || flag))
        {
            if (!flag)
            {
                l2 = -l2;
            }
            Jz = l2;
            pos = pos + j;
            Jy = 15;
            return 15;
        }
        if (j1 == 2 || j1 == 4 || j1 == 7)
        {
            JA = j;
            Jy = 16;
            return 16;
        } else
        {
            return 0;
        }
    }

    private String _mth14FD()
    {
        Object obj = null;
        int i = 0;
        StringBuilder stringbuilder;
        int j;
label0:
        do
        {
            if (pos + i < limit)
            {
                switch (Jv[pos + i])
                {
                case 35: // '#'
                case 47: // '/'
                case 59: // ';'
                case 61: // '='
                case 92: // '\\'
                    if (!Ju)
                    {
                        throw _mth14BD("Use JsonReader.setLenient(true) to accept malformed JSON");
                    }
                    // fall through

                case 9: // '\t'
                case 10: // '\n'
                case 12: // '\f'
                case 13: // '\r'
                case 32: // ' '
                case 44: // ','
                case 58: // ':'
                case 91: // '['
                case 93: // ']'
                case 123: // '{'
                case 125: // '}'
                    stringbuilder = ((StringBuilder) (obj));
                    j = i;
                    break label0;

                default:
                    i++;
                    break;
                }
                continue;
            }
            if (i < 1024)
            {
                stringbuilder = ((StringBuilder) (obj));
                j = i;
                if (!_mth1551(i + 1))
                {
                    break;
                }
                continue;
            }
            stringbuilder = ((StringBuilder) (obj));
            if (obj == null)
            {
                stringbuilder = new StringBuilder();
            }
            stringbuilder.append(Jv, pos, i);
            pos = pos + i;
            j = 0;
            i = 0;
            obj = stringbuilder;
            if (!_mth1551(1))
            {
                break;
            }
        } while (true);
        if (stringbuilder == null)
        {
            obj = new String(Jv, pos, j);
        } else
        {
            stringbuilder.append(Jv, pos, j);
            obj = stringbuilder.toString();
        }
        pos = pos + j;
        return ((String) (obj));
    }

    private void _mth1500()
    {
        int i;
        do
        {
            if (pos >= limit && !_mth1551(1))
            {
                break;
            }
            char ac[] = Jv;
            i = pos;
            pos = i + 1;
            i = ac[i];
            if (i == '\n')
            {
                Jw = Jw + 1;
                Jx = pos;
                return;
            }
        } while (i != '\r');
    }

    private char _mth1501()
    {
        if (pos == limit && !_mth1551(1))
        {
            throw _mth14BD("Unterminated escape sequence");
        }
        char ac[] = Jv;
        int i = pos;
        pos = i + 1;
        char c = ac[i];
        switch (c)
        {
        default:
            return c;

        case 117: // 'u'
            if (pos + 4 > limit && !_mth1551(4))
            {
                throw _mth14BD("Unterminated escape sequence");
            }
            c = '\0';
            int k = pos;
            for (int j = k; j < k + 4; j++)
            {
                char c1 = Jv[j];
                char c2 = (char)(c << 4);
                if (c1 >= '0' && c1 <= '9')
                {
                    c = (char)((c1 - 48) + c2);
                    continue;
                }
                if (c1 >= 'a' && c1 <= 'f')
                {
                    c = (char)((c1 - 97) + 10 + c2);
                    continue;
                }
                if (c1 >= 'A' && c1 <= 'F')
                {
                    c = (char)((c1 - 65) + 10 + c2);
                } else
                {
                    throw new NumberFormatException((new StringBuilder("\\u")).append(new String(Jv, pos, 4)).toString());
                }
            }

            pos = pos + 4;
            return c;

        case 116: // 't'
            return '\t';

        case 98: // 'b'
            return '\b';

        case 110: // 'n'
            return '\n';

        case 114: // 'r'
            return '\r';

        case 102: // 'f'
            return '\f';

        case 10: // '\n'
            Jw = Jw + 1;
            Jx = pos;
            return c;
        }
    }

    private void _mth1504()
    {
        _mth0131(true);
        pos = pos - 1;
        if (pos + Jt.length > limit && !_mth1551(Jt.length))
        {
            return;
        }
        for (int i = 0; i < Jt.length; i++)
        {
            if (Jv[pos + i] != Jt[i])
            {
                return;
            }
        }

        pos = pos + Jt.length;
    }

    private void _mth1541(int i)
    {
        if (JD == JC.length)
        {
            int ai[] = new int[JD << 1];
            int ai2[] = new int[JD << 1];
            String as[] = new String[JD << 1];
            System.arraycopy(JC, 0, ai, 0, JD);
            System.arraycopy(JF, 0, ai2, 0, JD);
            System.arraycopy(JE, 0, as, 0, JD);
            JC = ai;
            JF = ai2;
            JE = as;
        }
        int ai1[] = JC;
        int j = JD;
        JD = j + 1;
        ai1[j] = i;
    }

    private boolean _mth1551(int i)
    {
        char ac[] = Jv;
        Jx = Jx - pos;
        if (limit != pos)
        {
            limit = limit - pos;
            System.arraycopy(ac, pos, ac, 0, limit);
        } else
        {
            limit = 0;
        }
        pos = 0;
        do
        {
            int j = in.read(ac, limit, 1024 - limit);
            if (j != -1)
            {
                limit = limit + j;
                j = i;
                if (Jw == 0)
                {
                    j = i;
                    if (Jx == 0)
                    {
                        j = i;
                        if (limit > 0)
                        {
                            j = i;
                            if (ac[0] == '\uFEFF')
                            {
                                pos = pos + 1;
                                Jx = Jx + 1;
                                j = i + 1;
                            }
                        }
                    }
                }
                i = j;
                if (limit >= j)
                {
                    return true;
                }
            } else
            {
                return false;
            }
        } while (true);
    }

    public void beginArray()
    {
        int j = Jy;
        int i = j;
        if (j == 0)
        {
            i = _mth14F8();
        }
        if (i == 3)
        {
            _mth1541(1);
            JF[JD - 1] = 0;
            Jy = 0;
            return;
        } else
        {
            throw new IllegalStateException((new StringBuilder("Expected BEGIN_ARRAY but was ")).append(_mth13A2()).append(" at line ").append(Jw + 1).append(" column ").append((pos - Jx) + 1).append(" path ").append(getPath()).toString());
        }
    }

    public void beginObject()
    {
        int j = Jy;
        int i = j;
        if (j == 0)
        {
            i = _mth14F8();
        }
        if (i == 1)
        {
            _mth1541(3);
            Jy = 0;
            return;
        } else
        {
            throw new IllegalStateException((new StringBuilder("Expected BEGIN_OBJECT but was ")).append(_mth13A2()).append(" at line ").append(Jw + 1).append(" column ").append((pos - Jx) + 1).append(" path ").append(getPath()).toString());
        }
    }

    public void close()
    {
        Jy = 0;
        JC[0] = 8;
        JD = 1;
        in.close();
    }

    public void endArray()
    {
        int k = Jy;
        int i = k;
        if (k == 0)
        {
            i = _mth14F8();
        }
        if (i == 4)
        {
            JD = JD - 1;
            int ai[] = JF;
            int j = JD - 1;
            ai[j] = ai[j] + 1;
            Jy = 0;
            return;
        } else
        {
            throw new IllegalStateException((new StringBuilder("Expected END_ARRAY but was ")).append(_mth13A2()).append(" at line ").append(Jw + 1).append(" column ").append((pos - Jx) + 1).append(" path ").append(getPath()).toString());
        }
    }

    public void endObject()
    {
        int k = Jy;
        int i = k;
        if (k == 0)
        {
            i = _mth14F8();
        }
        if (i == 2)
        {
            JD = JD - 1;
            JE[JD] = null;
            int ai[] = JF;
            int j = JD - 1;
            ai[j] = ai[j] + 1;
            Jy = 0;
            return;
        } else
        {
            throw new IllegalStateException((new StringBuilder("Expected END_OBJECT but was ")).append(_mth13A2()).append(" at line ").append(Jw + 1).append(" column ").append((pos - Jx) + 1).append(" path ").append(getPath()).toString());
        }
    }

    public final String getPath()
    {
        StringBuilder stringbuilder = new StringBuilder("$");
        int i = 0;
        for (int j = JD; i < j; i++)
        {
            switch (JC[i])
            {
            default:
                break;

            case 1: // '\001'
            case 2: // '\002'
                stringbuilder.append('[').append(JF[i]).append(']');
                break;

            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
                stringbuilder.append('.');
                if (JE[i] != null)
                {
                    stringbuilder.append(JE[i]);
                }
                break;
            }
        }

        return stringbuilder.toString();
    }

    public boolean hasNext()
    {
        int j = Jy;
        int i = j;
        if (j == 0)
        {
            i = _mth14F8();
        }
        return i != 2 && i != 4;
    }

    public boolean nextBoolean()
    {
        int k = Jy;
        int i = k;
        if (k == 0)
        {
            i = _mth14F8();
        }
        if (i == 5)
        {
            Jy = 0;
            int ai[] = JF;
            i = JD - 1;
            ai[i] = ai[i] + 1;
            return true;
        }
        if (i == 6)
        {
            Jy = 0;
            int ai1[] = JF;
            int j = JD - 1;
            ai1[j] = ai1[j] + 1;
            return false;
        } else
        {
            throw new IllegalStateException((new StringBuilder("Expected a boolean but was ")).append(_mth13A2()).append(" at line ").append(Jw + 1).append(" column ").append((pos - Jx) + 1).append(" path ").append(getPath()).toString());
        }
    }

    public double nextDouble()
    {
        int k = Jy;
        int i = k;
        if (k == 0)
        {
            i = _mth14F8();
        }
        if (i == 15)
        {
            Jy = 0;
            int ai[] = JF;
            i = JD - 1;
            ai[i] = ai[i] + 1;
            return (double)Jz;
        }
        if (i == 16)
        {
            JB = new String(Jv, pos, JA);
            pos = pos + JA;
        } else
        if (i == 8 || i == 9)
        {
            char c;
            if (i == 8)
            {
                c = '\'';
            } else
            {
                c = '"';
            }
            JB = _mth02CB(c);
        } else
        if (i == 10)
        {
            JB = _mth14FD();
        } else
        if (i != 11)
        {
            throw new IllegalStateException((new StringBuilder("Expected a double but was ")).append(_mth13A2()).append(" at line ").append(Jw + 1).append(" column ").append((pos - Jx) + 1).append(" path ").append(getPath()).toString());
        }
        Jy = 11;
        double d = Double.parseDouble(JB);
        if (!Ju && (Double.isNaN(d) || Double.isInfinite(d)))
        {
            throw new mu((new StringBuilder("JSON forbids NaN and infinities: ")).append(d).append(" at line ").append(Jw + 1).append(" column ").append((pos - Jx) + 1).append(" path ").append(getPath()).toString());
        } else
        {
            JB = null;
            Jy = 0;
            int ai1[] = JF;
            int j = JD - 1;
            ai1[j] = ai1[j] + 1;
            return d;
        }
    }

    public int nextInt()
    {
        int l = Jy;
        int i = l;
        if (l == 0)
        {
            i = _mth14F8();
        }
        if (i == 15)
        {
            i = (int)Jz;
            if (Jz != (long)i)
            {
                throw new NumberFormatException((new StringBuilder("Expected an int but was ")).append(Jz).append(" at line ").append(Jw + 1).append(" column ").append((pos - Jx) + 1).append(" path ").append(getPath()).toString());
            } else
            {
                Jy = 0;
                int ai[] = JF;
                int i1 = JD - 1;
                ai[i1] = ai[i1] + 1;
                return i;
            }
        }
        if (i == 16)
        {
            JB = new String(Jv, pos, JA);
            pos = pos + JA;
            break MISSING_BLOCK_LABEL_357;
        }
        if (i != 8 && i != 9)
        {
            break MISSING_BLOCK_LABEL_284;
        }
        char c;
        if (i == 8)
        {
            c = '\'';
        } else
        {
            c = '"';
        }
        JB = _mth02CB(c);
        int ai1[];
        int j;
        int j1;
        j = Integer.parseInt(JB);
        Jy = 0;
        ai1 = JF;
        j1 = JD - 1;
        ai1[j1] = ai1[j1] + 1;
        return j;
        throw new IllegalStateException((new StringBuilder("Expected an int but was ")).append(_mth13A2()).append(" at line ").append(Jw + 1).append(" column ").append((pos - Jx) + 1).append(" path ").append(getPath()).toString());
_L2:
        Jy = 11;
        double d = Double.parseDouble(JB);
        int k = (int)d;
        if ((double)k != d)
        {
            throw new NumberFormatException((new StringBuilder("Expected an int but was ")).append(JB).append(" at line ").append(Jw + 1).append(" column ").append((pos - Jx) + 1).append(" path ").append(getPath()).toString());
        } else
        {
            JB = null;
            Jy = 0;
            int ai2[] = JF;
            int k1 = JD - 1;
            ai2[k1] = ai2[k1] + 1;
            return k;
        }
        NumberFormatException numberformatexception;
        numberformatexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public long nextLong()
    {
        int l = Jy;
        int i = l;
        if (l == 0)
        {
            i = _mth14F8();
        }
        if (i == 15)
        {
            Jy = 0;
            int ai[] = JF;
            i = JD - 1;
            ai[i] = ai[i] + 1;
            return Jz;
        }
        if (i == 16)
        {
            JB = new String(Jv, pos, JA);
            pos = pos + JA;
            break MISSING_BLOCK_LABEL_268;
        }
        if (i != 8 && i != 9)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        char c;
        if (i == 8)
        {
            c = '\'';
        } else
        {
            c = '"';
        }
        JB = _mth02CB(c);
        int ai1[];
        int j;
        long l1;
        l1 = Long.parseLong(JB);
        Jy = 0;
        ai1 = JF;
        j = JD - 1;
        ai1[j] = ai1[j] + 1;
        return l1;
        throw new IllegalStateException((new StringBuilder("Expected a long but was ")).append(_mth13A2()).append(" at line ").append(Jw + 1).append(" column ").append((pos - Jx) + 1).append(" path ").append(getPath()).toString());
_L2:
        Jy = 11;
        double d = Double.parseDouble(JB);
        long l2 = (long)d;
        if ((double)l2 != d)
        {
            throw new NumberFormatException((new StringBuilder("Expected a long but was ")).append(JB).append(" at line ").append(Jw + 1).append(" column ").append((pos - Jx) + 1).append(" path ").append(getPath()).toString());
        } else
        {
            JB = null;
            Jy = 0;
            int ai2[] = JF;
            int k = JD - 1;
            ai2[k] = ai2[k] + 1;
            return l2;
        }
        NumberFormatException numberformatexception;
        numberformatexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public String nextName()
    {
        int j = Jy;
        int i = j;
        if (j == 0)
        {
            i = _mth14F8();
        }
        String s;
        if (i == 14)
        {
            s = _mth14FD();
        } else
        if (i == 12)
        {
            s = _mth02CB('\'');
        } else
        if (i == 13)
        {
            s = _mth02CB('"');
        } else
        {
            throw new IllegalStateException((new StringBuilder("Expected a name but was ")).append(_mth13A2()).append(" at line ").append(Jw + 1).append(" column ").append((pos - Jx) + 1).append(" path ").append(getPath()).toString());
        }
        Jy = 0;
        JE[JD - 1] = s;
        return s;
    }

    public void nextNull()
    {
        int k = Jy;
        int i = k;
        if (k == 0)
        {
            i = _mth14F8();
        }
        if (i == 7)
        {
            Jy = 0;
            int ai[] = JF;
            int j = JD - 1;
            ai[j] = ai[j] + 1;
            return;
        } else
        {
            throw new IllegalStateException((new StringBuilder("Expected null but was ")).append(_mth13A2()).append(" at line ").append(Jw + 1).append(" column ").append((pos - Jx) + 1).append(" path ").append(getPath()).toString());
        }
    }

    public String nextString()
    {
        int j = Jy;
        int i = j;
        if (j == 0)
        {
            i = _mth14F8();
        }
        String s;
        if (i == 10)
        {
            s = _mth14FD();
        } else
        if (i == 8)
        {
            s = _mth02CB('\'');
        } else
        if (i == 9)
        {
            s = _mth02CB('"');
        } else
        if (i == 11)
        {
            s = JB;
            JB = null;
        } else
        if (i == 15)
        {
            s = Long.toString(Jz);
        } else
        if (i == 16)
        {
            s = new String(Jv, pos, JA);
            pos = pos + JA;
        } else
        {
            throw new IllegalStateException((new StringBuilder("Expected a string but was ")).append(_mth13A2()).append(" at line ").append(Jw + 1).append(" column ").append((pos - Jx) + 1).append(" path ").append(getPath()).toString());
        }
        Jy = 0;
        int ai[] = JF;
        i = JD - 1;
        ai[i] = ai[i] + 1;
        return s;
    }

    public void skipValue()
    {
        int k = 0;
        do
        {
            int i;
label0:
            {
                i = Jy;
                int l = i;
                if (i == 0)
                {
                    l = _mth14F8();
                }
                if (l == 3)
                {
                    _mth1541(1);
                    i = k + 1;
                    break label0;
                }
                if (l == 1)
                {
                    _mth1541(3);
                    i = k + 1;
                    break label0;
                }
                if (l == 4)
                {
                    JD = JD - 1;
                    i = k - 1;
                    break label0;
                }
                if (l == 2)
                {
                    JD = JD - 1;
                    i = k - 1;
                    break label0;
                }
                if (l == 14 || l == 10)
                {
                    do
                    {
                        i = 0;
                        do
                        {
                            if (pos + i >= limit)
                            {
                                break;
                            }
                            switch (Jv[pos + i])
                            {
                            case 35: // '#'
                            case 47: // '/'
                            case 59: // ';'
                            case 61: // '='
                            case 92: // '\\'
                                if (!Ju)
                                {
                                    throw _mth14BD("Use JsonReader.setLenient(true) to accept malformed JSON");
                                }
                                // fall through

                            case 9: // '\t'
                            case 10: // '\n'
                            case 12: // '\f'
                            case 13: // '\r'
                            case 32: // ' '
                            case 44: // ','
                            case 58: // ':'
                            case 91: // '['
                            case 93: // ']'
                            case 123: // '{'
                            case 125: // '}'
                                pos = pos + i;
                                i = k;
                                break label0;

                            default:
                                i++;
                                break;
                            }
                        } while (true);
                        pos = pos + i;
                    } while (_mth1551(1));
                    i = k;
                } else
                if (l == 8 || l == 12)
                {
                    _mth02CE('\'');
                    i = k;
                } else
                if (l == 9 || l == 13)
                {
                    _mth02CE('"');
                    i = k;
                } else
                {
                    i = k;
                    if (l == 16)
                    {
                        pos = pos + JA;
                        i = k;
                    }
                }
            }
            Jy = 0;
            k = i;
            if (i == 0)
            {
                int ai[] = JF;
                int j = JD - 1;
                ai[j] = ai[j] + 1;
                JE[JD - 1] = "null";
                return;
            }
        } while (true);
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append(" at line ").append(Jw + 1).append(" column ").append((pos - Jx) + 1).toString();
    }

    public ms _mth13A2()
    {
        int j = Jy;
        int i = j;
        if (j == 0)
        {
            i = _mth14F8();
        }
        switch (i)
        {
        case 1: // '\001'
            return ms.JI;

        case 2: // '\002'
            return ms.JJ;

        case 3: // '\003'
            return ms.JG;

        case 4: // '\004'
            return ms.JH;

        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
            return ms.JK;

        case 5: // '\005'
        case 6: // '\006'
            return ms.JN;

        case 7: // '\007'
            return ms.JO;

        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
            return ms.JL;

        case 15: // '\017'
        case 16: // '\020'
            return ms.JM;

        case 17: // '\021'
            return ms.JP;
        }
        throw new AssertionError();
    }

    static 
    {
        kb.Hi = new mr();
    }
}
