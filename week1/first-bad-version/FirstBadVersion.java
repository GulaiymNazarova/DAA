public class FirstBadVersion {
    //first solution
    public int firstBadVersion(int n) {
        int left =1;
        int right = n;

        while(left <= right){
            int mid = (left + right)/2;
            if( isBadVersion(mid) && !isBadVersion(mid-1) ){
                return mid;
            }
            else if(isBadVersion(mid)){
                right = mid - 1;
            }
            else if(!isBadVersion(mid)){
                left = mid + 1;
            }
        }
    }



    //Analyzed optimized code
    public int firstBadVersion(int n) {
        int left =1;
        int right = n;

        while(left <= right){
            int mid = (left + right)/2;
            if( isBadVersion(mid)){
                right = mid -1;
            }
            else {
                left = mid +1;
            }

        }
        return left;
    }
}



