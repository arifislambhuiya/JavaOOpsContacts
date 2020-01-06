package chapterOne;

public class BoxTester {

    public static void main(String[] args) {
//        int [] width = {2,4,5,6,7};
//        int [] height= {5,6,3,6,7};
//        int [] depth = {2,6,7,90,7};
//
//       for(int i = 0;i<width.length;i++){
//           System.out.println("Box-"+ (i+1) + " Height = "+height[i] +"Width = "+width[i] + "Depth = "+depth[i]);
//       }


        Box box = new Box(10, 5, 3);

        System.out.println(box.width + " ,"  + box.heigth + " ," + box.depth );
   }

    private static  int volume (int width,int heigth,int depth){
        return width*heigth*depth;
    }


}
