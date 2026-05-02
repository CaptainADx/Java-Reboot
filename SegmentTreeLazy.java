class SegmentTreeLazy {
    int[] seg;
    int[] lazy;
    int n;

    public SegmentTreeLazy(int[] arr) {
        n = arr.length; 
        seg = new int[4 * n];
        lazy = new int[4 * n];
        build(0, 0, n - 1, arr);
    }

    // Build Tree
    private void build(int idx, int low, int high, int[] arr) {
        if (low == high) {
            seg[idx] = arr[low];
            return;
        }

        int mid = (low + high) / 2;
        build(2 * idx + 1, low, mid, arr);
        build(2 * idx + 2, mid + 1, high, arr);

        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }

    // Range Update
    public void update(int idx, int low, int high, int l, int r, int val) {

        // Step 1: Resolve Lazy
        if (lazy[idx] != 0) {
            seg[idx] += (high - low + 1) * lazy[idx];

            if (low != high) {
                lazy[2 * idx + 1] += lazy[idx];
                lazy[2 * idx + 2] += lazy[idx];
            }

            lazy[idx] = 0;
        }

        // No overlap
        if (high < l || low > r) return;

        // Complete overlap
        if (low >= l && high <= r) {
            seg[idx] += (high - low + 1) * val;

            if (low != high) {
                lazy[2 * idx + 1] += val;
                lazy[2 * idx + 2] += val;
            }
            return;
        }

        // Partial overlap
        int mid = (low + high) / 2;
        update(2 * idx + 1, low, mid, l, r, val);
        update(2 * idx + 2, mid + 1, high, l, r, val);

        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }

    // Range Query
    public int query(int idx, int low, int high, int l, int r) {

        // Step 1: Resolve Lazy
        if (lazy[idx] != 0) {
            seg[idx] += (high - low + 1) * lazy[idx];

            if (low != high) {
                lazy[2 * idx + 1] += lazy[idx];
                lazy[2 * idx + 2] += lazy[idx];
            }

            lazy[idx] = 0;
        }

        // No overlap
        if (high < l || low > r) return 0;

        // Complete overlap
        if (low >= l && high <= r) return seg[idx];

        // Partial overlap
        int mid = (low + high) / 2;
        int left = query(2 * idx + 1, low, mid, l, r);
        int right = query(2 * idx + 2, mid + 1, high, l, r);

        return left + right;
    }
}