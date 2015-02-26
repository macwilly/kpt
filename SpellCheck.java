public class SpellCheck
{
   int editDistance(String x, String y){
      if(x.length()==0)
         return y.length();
      else if(y.length()==0)
         return x.length();
      else{
         int addDistance = editDistance(x,y.substring(0,y.length()-1))+1;
         int removeDistance = editDistance(x.substring(0,x.length()-1),y) + 1;
         int changeDistance = editDistance(x.substring(0,x.length()-1), y.substring(0,y.length()-1)) + ((x.charAt(x.length()-1)==y.charAt(y.length()-1))?0:1);
         return Math.min(Math.min(addDistance, removeDistance), changeDistance);
      }
   }
   
   public static void main(String[] args){
      SpellCheck sc = new SpellCheck();
      System.out.println(sc.editDistance("good","goodbye"));
      System.out.println(sc.editDistance("dog","hog"));
      System.out.println(sc.editDistance("zeil","trials"));
   }
}