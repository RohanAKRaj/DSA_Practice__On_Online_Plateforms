class State{ // state to maintain!
    int row;
    int col;
    int eng;
    int mask;

    State(int row, int col, int eng, int mask){
        this.row = row;
        this.col = col;
        this.eng = eng;
        this.mask = mask;
    }
}

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int stRow = 0;
        int stCol = 0;
        // if L = 4, 00, 01, 10, 11 will we used, so the first Litter is 0, then 1,2,3...
        int totalLitter = 0; 

        // crating a 2D array to maintain mask and count totalLitter
        int [][] litterNo = new int[m][n];

        //Finding S and giving Every L a Number
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                char cell = classroom[i].charAt(j);
                if(cell=='S'){
                    stRow = i;
                    stCol = j;
                }

                if(cell=='L'){
                    litterNo[i][j] = totalLitter++;
                }
                else{
                    litterNo[i][j] = -1;
                }
            }
        }

        int allCollected = (1<<totalLitter)-1; //(1<<4)=10000 so, 1<<4 -1 = 01111

        Queue<State> q = new LinkedList<>();
        boolean[][][][] visited = new boolean[m][n][energy+1][1<<totalLitter];

        // filling q and visited with start state!
        q.offer(new State(stRow, stCol, energy, 0));
        visited[stRow][stCol][energy][0] = true;

        // directions of traversal!
        int [][] dirs = {
            {0,1}, // right
            {0,-1}, // left
            {1,0}, // down
            {-1,0}, // up
        };

        int move = 0; // hav'nt moved yet

        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                State curr = q.poll();

                if(curr.mask == allCollected) return move;
                if(curr.eng == 0) continue;

                for(int [] dir : dirs){
                    int newRow = curr.row + dir[0];
                    int newCol = curr.col + dir[1];
                    
                    // if dir is out of grid;
                    if((newRow<0 || newCol<0) || (newRow>=m || newCol>=n)) continue;
                    // if it reaches to X
                    if(classroom[newRow].charAt(newCol)=='X') continue;

                    int newEng = curr.eng-1;
                    int newMask = curr.mask;

                    //findind new mask & new energy if exist!
                    char ch = classroom[newRow].charAt(newCol);

                    if(ch=='R'){
                        newEng = energy; 
                    }

                    if(ch=='L'){
                        int x = litterNo[newRow][newCol];
                        newMask = newMask | (1<<x); 
                    }

                    if(visited[newRow][newCol][newEng][newMask]) continue;
                    visited[newRow][newCol][newEng][newMask] = true;
                    q.offer(new State(newRow,newCol, newEng, newMask));
                }
            }
            move++;
        }
        return -1;
    }
}