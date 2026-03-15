class Fancy {
    static final int MOD = 1_000_000_007;
    List<int[]> values; // [op-index checkpoint, current value]
    List<int[]> ops;    // [type (1=add, 2=mul), operand]

    public Fancy() {
        values = new ArrayList<>();
        ops = new ArrayList<>();
    }

    public void append(int val) {
        // snapshot current ops size so only future ops apply to this element
        values.add(new int[] { ops.size(), val });
    }

    public void addAll(int inc) {
        ops.add(new int[] { 1, inc }); // lazy: just log the operation
    }

    public void multAll(int m) {
        ops.add(new int[] { 2, m }); // lazy: just log the operation
    }

    public int getIndex(int idx) {
        if (values.size() - 1 < idx) return -1;
        int n = ops.size();
        int k = values.get(idx)[0]; // op index when this element was last evaluated
        if (n != k) {
            long x = values.get(idx)[1];
            for (int i = k; i < n; i++) { // replay ops since last evaluation
                if (ops.get(i)[0] == 1) {
                    x = (x + ops.get(i)[1]) % MOD;
                } else {
                    x = (x * ops.get(i)[1]) % MOD;
                }
            }
            // cache result and advance checkpoint
            values.get(idx)[0] = n;
            values.get(idx)[1] = (int) x;
        }
        return values.get(idx)[1];
    }
}