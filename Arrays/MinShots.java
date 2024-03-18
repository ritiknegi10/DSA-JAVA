//Question: There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter, and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.
// Link: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

package Arrays;

import java.util.Arrays;

public class MinShots {

    public int findMinArrowShots(int[][] points) {
      Arrays.sort(points,(point1,point2) ->Integer.compare(point1[1],point2[1]));
      int arrow=1;
      int pos=points[0][1];
      for(int i=1;i<points.length;i++){
          if(pos>=points[i][0]){
              continue;
          }
          arrow++;
          pos=points[i][1];
      }
      return arrow;
    }
   
}
