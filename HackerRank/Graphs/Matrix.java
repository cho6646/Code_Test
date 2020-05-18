static int n;
// Complete the minTime function below.
static int minTime(int[][] roads, int[] machines) {
    int cost = 0;
    boolean[] isBaseMachine = new boolean[n];
    int[] node = new int[n];
    // HashMap<Integer, List<Integer>> map = new HashMap<>();
		
		//여기서 LinkedList를 썼다가 계속 timeout 걸렸었음
    List<HashSet<Integer>> setList = new ArrayList<>();

    for(int i=0; i<n; i++) 
    {
        node[i] = i;
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(i);
        setList.add(set);
    }
    for(int machine: machines)
    {
        isBaseMachine[machine] = true;
    }

    Arrays.sort(roads, (o1, o2)->
    {
        return Integer.compare(o2[2], o1[2]);
    });

    for(int[] road: roads)
    {
        int b1 = node[road[0]];
        int b2 = node[road[1]];
        if(b1 == b2) continue;
        int time = road[2];
        if(isBaseMachine[b1] && isBaseMachine[b2])
        {
            cost += time;
        }
        else
        {
            isBaseMachine[b1] = isBaseMachine[b1] || isBaseMachine[b2];
            for(int a: setList.get(b2))
            {
                setList.get(b1).add(a);
                node[a] = b1;
            }
        }
    }
    return cost;
}