class Solution {
    public boolean checkOverlap(int r, int x, int y, int x1, int y1, int x2, int y2) {
        // centre is inside rec;
        if(x<=x2 && x>=x1 && y>=y1 && y<=y2) return true;

        //is circle is touching the left boundary?
        if((x+r >= x1 && x-r<=x1) && (y>=y1 && y<=y2)) return true;
        //is circle is touching the top of rec?
        if((y+r >= y2 && y-r<=y2) && (x>=x1 && x<=x2)) return true;
        //is circle is touching the right boundary?
        if((x+r >= x2 && x-r<=x2) && (y>=y1 && y<=y2)) return true;
        //is circle is touching the bottom of rec?
        if((y+r >= y1 && y-r<=y1) && (x>=x1 && x<=x2)) return true;
        
        //corner cond^n
        double ulc = Math.sqrt(Math.pow((x-x1),2)+Math.pow((y-y2),2)); // upper left corner
        if(ulc <= r) return true;
        double urc = Math.sqrt(Math.pow((x-x2),2)+Math.pow((y-y2),2)); // upper left corner
        if(urc <= r) return true;
        double llc = Math.sqrt(Math.pow((x-x1),2)+Math.pow((y-y1),2)); // upper left corner
        if(llc <= r) return true;
        double lrc = Math.sqrt(Math.pow((x-x2),2)+Math.pow((y-y1),2)); // upper left corner
        if(lrc <= r) return true;
        return false;
    }
}