import java.util.*;

public class App {
    public static void main(String[] args) {
           Scanner sc=new Scanner(System.in);

           System.out.println("Enter NO. of Student");
           int no_of_student=sc.nextInt();

           System.out.println("Enter NO. of Subjects");
           int no_of_sub=sc.nextInt();

           float arr[][]=new float[no_of_student+1][no_of_sub+2];


            System.out.println("enter one by one student's marks by subject vice");
            
            for(int i=0;i<no_of_student;i++)
            {
               System.out.println("for student :" + (i+1));
               
                    for(int j=0;j<no_of_sub;j++)
                    {
                        System.out.println("Enter mark/gread subject" + (j+1)+":");
                        
                        arr[i][j]=sc.nextInt();
                        
                    }
            }
            
             for(int i=0;i<no_of_student;i++)
            {
               
                    for(int j=0;j<no_of_sub;j++)
                    {
                        System.out.print(arr[i][j] +" ");
                       
                        
                    }
                    System.out.println();
            }

           // calculating average.....
           
              for(int i=0;i<no_of_student;i++)
            {
                   int sum=0;
                   
                    for(int j=0;j<no_of_sub;j++)
                    {
                           sum=sum+(int)arr[i][j];
                           
                           if(j==no_of_sub-1)
                           {
                               arr[i][j+1]=(float)sum/no_of_sub;
                           }   
                    }     
            }
            
            System.out.println();
            
            float min_marks=Integer.MAX_VALUE;
            float max_marks=Integer.MIN_VALUE;
            
               for(int i=0;i<no_of_student;i++)
               {
            	   		if(arr[i][no_of_sub]<min_marks)
            	   		{
            	   			min_marks=arr[i][no_of_sub];
            	   		}
            	   		
            	   		if(arr[i][no_of_sub]>max_marks)
            	   		{
            	   			max_marks=arr[i][no_of_sub];
            	   			
            	   		}
                    System.out.println("Avg. of Student 1: " +arr[i][no_of_sub] );
                }
            
               System.out.println("MAX AVERAGE IS :"+ max_marks);
               System.out.println("MIn AVERAGE IS :"+ min_marks);
                   
    }
}
