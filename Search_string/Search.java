class Search extends Thread {
    String t;
    String s;
    char[] s1;
    char[] t1;
    int[] p;

    public Search(String s, String t) {
        this.s = s;
        this.t = t;
        this.s1 = s.toCharArray();
        this.t1 = t.toCharArray();
        this.p = new int[s.length()];
    }

    @Override
    public void run() {
        System.out.println("Вхождение подстроки " + t + " c " + kmpMatcher(s, t) + " элемента");
    }

    public static int[] prefixFunction(String s) {
        int[] p = new int[s.length()];
        int k = 0;
        for (int i = 1; i < s.length(); i++) {
            while (k > 0 && s.charAt(k) != s.charAt(i))
                k = p[k - 1];
            if (s.charAt(k) == s.charAt(i))
                ++k;
            p[i] = k;
        }
        return p;
    }

    public static int kmpMatcher(String s, String t) {
        int m = t.length();
        if (m == 0)
            return 0;
        int[] p = prefixFunction(t);
        for (int i = 0, k = 0; i < s.length(); i++)
            for (; ; k = p[k - 1]) {
                if (t.charAt(k) == s.charAt(i)) {
                    if (++k == m)
                        return i + 1 - m;
                    break;
                }
                if (k == 0)
                    break;
            }
        return -1;
    }
}