//Question: https://leetcode.com/problems/find-median-from-data-stream/

package Heap;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class FindMedian {


    // Always insert element at the correct index .. Use binary search to insert element to right place
    List<Integer> lst;
    public MedianFinder() {
        lst = new ArrayList<>();
    }
    
    public void addNum(int num) {

        if(lst.size() < 1){
            lst.add(0, num);
            return;
        }

        if(lst.size() == 1){ 
            int ind = lst.get(0) < num ? 1 : 0; 
            lst.add(ind, num);
            return;
        }

        // binary search to find the right place to insert the element
        int index = findInsertIndex(num);

        lst.add(index, num);
        
    }
    
    public double findMedian() {
    
        int size = lst.size(); 

        double median; 

        if(size % 2 == 0){ 
            int a = (size-1)/2; 
            median = ((lst.get(a) + lst.get(a+1))*1.0) / 2;
        }else{
            int a = (size) / 2; 
            median = 1.0*(lst.get(a));
        }

        return median;
        
    }

    private int findInsertIndex(int num){
        
        int l = 0;  
        int r = lst.size()-1;  

        while(l<r){ 

            int mid = l + ((r-l)/2); 

            if(num <= lst.get(mid)){ 
                r = mid; 
            }else{
                l = mid+1; 
            }

        }

        if(lst.get(l) < num){
            l++;
        }

        return l; 

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

