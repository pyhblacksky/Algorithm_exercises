package ACM;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/16 9:30
 * @Version: 1.0
 * @Function:
 * @Description:
 * Description
 *
 * Your job as a forest ranger comes with many responsibilities,
 * but one of thehardest tasks is planning and preparing new trails for hikers.
 * When a new trailis opened to the public, the National Forest Service adds a page
 * to theirwebsite for the trail which contains quite a bit of information.
 * The web pageincludes things like the location where the trail begins, the difficulty ofhiking the trail,
 * and pictures taken from various scenic views along the trail.The hardest piece of data for you to gather
 * is the difference in elevationbetween the start of the trail and the end of the trail.
 * You and your team use surveying equipment to calculate the slope and distance(along the trail)
 * of each section of the trail. For example,
 * a trail may begincompletely flat for 500 meters, then switch to an 8∘ incline for 1000meters,
 * and then switch to a 2∘decline for the final 500 meters. With somany new trails opening,
 * manually calculating the elevation difference from thesection descriptions has become too tedious.
 * So, you've decided to write aprogram to make the process easier.
 *
 *
 * Input
 * Input begins with a positive integern≤100 indicating the number of trailsections.
 * The following n lines describe the trail sections from the beginningto the end of the trail.
 * Each trail section is described by two integers a d(-50 <= a <= 50, 1 <= d <= 10000)
 * indicating its angle of elevation in degrees and the distance in meters along that section of the trail,
 * respectively.
 *
 *
 * Output
 * Display the difference in elevation between the start of the trail and the endof the trail in meters.
 * The difference in elevation will always be greater than0 meters. Round answers to the hundredths place.
 * Always print answers to twodecimal places and include the leading 0 on answers between 0 and 1.
 *
 *
 * Sample Input 1
 *
 * 3
 * 0 500
 * 8 1000
 * -2 500
 * Sample Output 1
 *
 * 121.72
 * Sample Input 2
 *
 * 3
 * 12 1000
 * -11 1200
 * 5 250
 * Sample Output 2
 *
 * 0.73
 */
public class HappyTrails {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        double res = getRes(arr);
        System.out.println(String.format("%.2f", res));
    }

    static double getRes(int[][] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }

        double res = 0;
        for(int i = 0; i < arr.length; i++){
            res += (DTR(arr[i][0])*arr[i][1]);
        }
        return res;
    }

    static double DTR(int degree){
        return Math.sin(Math.toRadians(degree));
    }
}
