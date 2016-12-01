package org.test.fun.testfun;

public class TypeComparator {
  
  public static void main(String args[]){
    String[] argv = {"10000", "200"};
    args = argv;
    
    if(args.length != 2){
      System.out.println("please provide two integer values to get started!");
      return;
    }
    
    int u, v = 0;
    
    try{
      u = Integer.parseInt(args[0]);
      v = Integer.parseInt(args[1]);
    }catch(Exception e){
      System.out.println("Please make sure youve provided a valid integer");
      return;
    }
    
    TypeComparator typeComparator = new TypeComparator();
    
    boolean uIsLessThanV = typeComparator.compare(u, v, ConditionValueOperator.LT);
    if(uIsLessThanV){
      System.out.println(u + " is less than " + v);
    }else{
      System.out.println(u + " is greater than or equal to " + v);
    }
    
    long start = System.currentTimeMillis();
    typeComparator.xCubeComplexity(u);
    long timeTaken = System.currentTimeMillis() - start;
    
    System.out.println("It took [" + timeTaken + " MS] for three nested loops each running from [1 - " + u + "]");
    
  }
  /**
   * compares the first two numbers and returns TRUE if it satisfies the condition FALSE other wise
   * 
   * @param v1
   * @param v2
   * @param cvo
   * @return boolean
   */
  public boolean compare(int v1, int v2, ConditionValueOperator cvo) {
    boolean matched = false;
    switch (cvo) {

    case EQ:
      matched = v1 == v2;
      break;
    case LT:
      matched = v1 < v2;
      break;
    case GT:
      matched = v1 > v2;
      break;
    case NOT_EQ:
      matched = v1 != v2;
      break;
    case LT_EQ:
      matched = v1 <= v2;
      break;
    case GT_EQ:
      matched = v1 >= v2;
    }

    return matched;
  }

  
  /**
   * uses nested loops deep upto 3 levels
   * @param x
   * @return
   */
  public void xCubeComplexity(int x){
    long v = 0;
    for(int i=0; i<x; i++){
      for(int j=0; j<x; j++){
        for(int k=0; k<x; k++){
          v = x*x; 
        }
      }
    }
  }
}

/**
 * 
 * enumerations 
 */
enum ConditionValueOperator {
  EQ, LT, GT, NOT_EQ, LT_EQ, GT_EQ
}
