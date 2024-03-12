//Question link
//https://leetcode.com/problems/pascals-triangle/description/
package DP;

import java.util.ArrayList;
import java.util.List;

public class pascalTriangal {
   
    public List<List<Integer>> generate(int numRows) {
        var row = new ArrayList<>(List.of(1));
    List<List<Integer>> res = new ArrayList<>(List.of(row));
    if (numRows == 1) return res;
    
    row = new ArrayList<>(List.of(1, 1));
    res.add(row);
    
    for (var i=2; i < numRows; i++) {
      var newRow = new ArrayList<>(List.of(1));

      for (var j=0; j+1 < row.size(); j++)
        newRow.add(row.get(j) + row.get(j+1));

      newRow.add(1);
      res.add(newRow);
      row = newRow;
    }
    return res;
    }

}
