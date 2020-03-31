package ejercicio6;

import java.rmi.RemoteException;

public class ServerImplement implements RemoteInt {
	

	public int [] SumaV(int vector1[],int vector2[]) throws RemoteException{
		
		 int vector3[]=new int[9];
		 
         int i=0;
         	for(int x=0;x<=8;x++){
         		int a=(vector2[x]=0);//Error Introducido
         		i=vector1[x]+a;
         		vector3[x]=i;
         	}
         
         	System.out.println("*******Suma*******");
         	for(int x=0;x<=8;x++)
         	{
         		
             System.out.println("v1:"+x+"="+vector1[x]+"  v2:"+x+"="+vector2[x]+"  ===> v:"+x+"="+vector3[x]);
             System.out.println();
         	}
         
         return vector3;
		
	}

	
	public int [] RestaV(int vector1[],int vector2[]) throws RemoteException{
		
		int vector3[]= new int[9];
		 
        int i=0;
        for(int x=0;x<=8;x++){
        	int a=(vector2[x]=0);//Error Introducido
        	i=vector1[x] - a;
            vector3[x]=i;
        }
        
        System.out.println("*******Resta*******");
        
        for(int x=0;x<=8;x++){
         System.out.println("v1:"+x+"="+vector1[x]+"  v2:"+x+"="+vector2[x]+"  ===> v:"+x+"="+vector3[x]);
     	 System.out.println();
     	}
		
		return vector3;
	}




}
